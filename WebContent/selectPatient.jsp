<jsp:include page="include/adminheader.jsp" />  

<!--=====================================================
Custom content page - body - Referencing (adminheader.jsp)
=========================================================-->
 <%! String s1 = ""; %>
 <% s1  = (String) session.getAttribute("userdb");%>
<div class="main_content col-lg-10 col-md-12 col-sm-12 ">

    <!--Form-->
    <form action="PharmaceuticalControllerServlet" class="form-horizontal" method="POST" >
        <fieldset>

            <!-- Form Name -->
            <div class="content-title">
                <h2>Select Patient</h2>
            </div>
            
            <!-- Input for send info of request-->
            <input type="hidden" name="infoPost" value="selectPatient">
            
            
            <!-- Input Pharmaceutical ID-->
            <div class="form-group row">
                <label for="phId" class="col-lg-2 col-form-label-sm">Patient's NIC</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control form-control-sm" id="pNic" name="pNic" placeholder="NIC No">
                </div>
            </div>
		   
		    <% if(s1!=null){ %>
		    <div class="besideemailbox" style="color : red">Email Already exist</div>
		    <% }else { %>
		    <div class="besideemailbox" style="color : green">ok or a tick</div>
		    <% } %>
    
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