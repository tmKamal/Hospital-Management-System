<jsp:include page="include/adminheader.jsp" />  

<!--=====================================================
Custom content page - body - Referencing (adminheader.jsp)
=========================================================-->

<div class="main_content col-lg-10 col-md-12 col-sm-12 ">

    <!--Form-->
    <form action="PharmaceuticalControllerServlet" class="form-horizontal" method="POST" >
        <fieldset>

            <!-- Form Name -->
            <div class="content-title">
                <h2>ADD PHARMACEUTICAL</h2>
            </div>
            
            <!-- Input for send info of request-->
            <input type="hidden" name="infoPost" value="add">
            
            
            <!-- Input Pharmaceutical ID-->
            <div class="form-group row">
                <label for="phId" class="col-lg-2 col-form-label-sm">Pharmaceutical ID</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control form-control-sm" id="phId" name="phId" placeholder="Pharmacetical ID">
                </div>
            </div>

            <!-- Input Pharmaceutical Name-->
            <div class="form-group row">
                <label for="phName" class="col-lg-2 col-form-label-sm">Pharmaceutical Name</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control form-control-sm" id="phName" name="phName" placeholder="Pharmacetical Name">
                </div>
            </div>
			
			<!-- Input Pharmaceutical Brand Name-->
            <div class="form-group row">
                <label for="phName" class="col-lg-2 col-form-label-sm">Pharmaceutical Brand Name</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control form-control-sm" id="phBrand" name="phBrand" placeholder="Brand Name">
                </div>
            </div>
            
            <!-- Input Pharmaceutical Price-->
            <div class="form-group row">
                <label for="phPrice" class="col-lg-2 col-form-label-sm">Price</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control form-control-sm" id="phPrice" name="phPrice" placeholder="2500">
                </div>
            </div>
            
            <!-- Input Pharmaceutical Qty-->
            <div class="form-group row">
                <label for="phQty" class="col-lg-2 col-form-label-sm">Quantity</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control form-control-sm" id="phQty" name="phQty" placeholder="1">
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
<script src="js/admin.js"></script>
</body>
</html>