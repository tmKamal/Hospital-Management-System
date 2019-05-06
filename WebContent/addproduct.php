<?php
    require_once('include/adminheader.php');
    require_once ('../db.php');



    if(isset($_POST['btnSubmit'])){
        $get_prodID=0;
        $productName=$_POST['prodName'];
        $productPrice=$_POST['prodPrice'];
        $productCategory=$_POST['prodCategory'];
        $productDescription=$_POST['prodDescription'];

        $sql="INSERT INTO product (prodName,prodPrice,prodDesc,categoryID,sellerID) VALUES ('{$productName}','{$productPrice}','{$productDescription}','{$productCategory}',2)";
        $result=$conn->query($sql);

        if(!$result){
            echo "Query error".$conn->error;
        }

        //Image Uploader

        $sql1="SELECT prodID FROM  product ORDER BY prodID DESC LIMIT 1";
        $result1=$conn->query($sql1);

        if(!$result1){
            echo " Image Query error".$conn->error;
        }

        if ($result1->num_rows>0) {
            // output data of each row
            while($row = $result1->fetch_assoc()) {
                echo "id: " . $row["prodID"]. "<br>";
                $get_prodID=$row["prodID"];
            }
        } else {
            echo "0 results";
        }
        //SELECT * FROM Table ORDER BY ID DESC LIMIT 1
        echo $get_prodID;
        foreach ($_FILES['file']['name'] as $f => $name) {
            //$i=0;

            $allowedExts = array("gif", "jpeg", "jpg", "png");
            $temp = explode(".", $name);
            $extension = end($temp);

            if ((($_FILES["file"]["type"][$f] == "image/gif")
                    || ($_FILES["file"]["type"][$f] == "image/jpeg")
                    || ($_FILES["file"]["type"][$f] == "image/jpg")
                    || ($_FILES["file"]["type"][$f] == "image/png"))
                && ($_FILES["file"]["size"][$f] < 2000000)
                && in_array($extension, $allowedExts))
            {
                if ($_FILES["file"]["error"][$f] > 0)
                {
                    echo "Return Code: " . $_FILES["file"]["error"][$f] . "<br>";
                }
                else
                {

                    if (file_exists("../product_img" . $name))
                    {

                    }
                    else
                    {
                        move_uploaded_file($_FILES["file"]["tmp_name"][$f], "../product_img/". $name);
                        //$store[$i]=$name;
                        //$i++;
                        $sqlimg="INSERT INTO product_image (prodID,imagePath) VALUES ('{$get_prodID}','{$name}')";
                        $resultimg=$conn->query($sqlimg);

                        if(!$resultimg){
                            echo "Query error".$conn->error;
                        }else{
                            echo "img inserted successfully";
                        }
                    }
                }
            }
            else
            {
                $error =  "Invalid file";
            }
        }




        //Inserting Values into DB from user form



    }
?>

<!--=====================================================
Custom content page - body - Referencing (adminheader.php)
=========================================================-->

<div class="main_content col-lg-10 col-md-12 col-sm-12 ">

    <!--form-->
    <form action="addproduct.php" class="form-horizontal" method="post" enctype="multipart/form-data">
        <fieldset>

            <!-- Form Name -->
            <div class="content-title">
                <h2>ADD PRODUCT</h2>
            </div>

            <!-- Input Product Name-->
            <div class="form-group row">
                <label for="prodName" class="col-lg-2 col-form-label-sm">Product Name</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control form-control-sm" id="prodName" name="prodName" placeholder="Product Name">
                </div>
            </div>

            <!--Image uploader-->
            <!--<div class="form-group row">
                <label for="prodImg" class="col-lg-2 col-form-label-sm">Choose images</label>

                <input type="file" id="file" name="file[]" multiple>


            </div>-->


            <div class="form-group row">
                <label for="prodImg22" class="col-lg-2 col-form-label-sm">Images</label>
                <input type="file" name="file[]" id="file" class="inputfile inputfile-6" data-multiple-caption="{count} files selected" multiple />
                <label for="file"><span></span> <strong> Choose a file&hellip;</strong></label>
            </div>




            <!-- Input Product Price-->
            <div class="form-group row">
                <label for="prodPrice" class="col-lg-2 col-form-label-sm">Price</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control form-control-sm" id="prodPrice" name="prodPrice" placeholder="2500">
                </div>
            </div>

            <!-- DropDown Product Category-->
            <div class="form-group row">
                <label for="prodCategory" class="col-lg-2 col-form-label-sm">Category</label>
                <div class="col-lg-10">
                    <select class="form-control form-control-sm" id="prodCategory" name="prodCategory">
                        <option value="1">Phone</option>
                        <option value="2">Cases</option>
                        <option value="3">Cables</option>
                        <option value="4">Adapters</option>
                        <option value="5">Audio</option>
                        <option value="6">Screen Protectors</option>
                    </select>
                </div>
            </div>



            <!-- TextArea Product description-->
            <div class="form-group row">
                <label for="prodDescription" class="col-lg-2 col-form-label-sm">Description</label>
                <div class="col-lg-10">
                    <textarea class="form-control form-control-sm" id="prodDescription" name="prodDescription" placeholder="Details about your Product. (300 words or less..)"></textarea>
                </div>
            </div>

            <button name="btnSubmit" type="submit" class="btn btn-outline-success btn-sm">Submit</button>

        </fieldset>
    </form>
</div><!--Main content end-->
<!--END-Custom page content-->
</div>
</div>
</div>
</div><!--End PAGE CONTENT-->
</div>
<!--End NEW Structure-->



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="../js/admin.js"></script>
</body>
</html>