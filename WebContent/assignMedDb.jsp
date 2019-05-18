<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List,com.hospital.Pharmaceutical.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="include/adminheader.jsp" />  

<!--=====================================================
Custom content page - body - Referencing (adminheader.jsp)
=========================================================-->
 <%! String s1 = ""; %>
 <% s1  = (String) session.getAttribute("medDb");%>

<div class="main_content col-lg-10 col-md-12 col-sm-12 ">

    <div class="content-title">
        <h2>Pharmaceutical Details</h2>
        <div class="row">
            <div class="col-sm-12 table-inside">

                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Brand Name</th>
                        <th scope="col">Qty</th>
                        
                    </tr>
                    </thead>
                    <tbody>

								<tr>
									<td>${selectMedDb.id}</td>
									<td>${selectMedDb.name}</td>
									<td>${selectMedDb.brandName}</td>
									<td>${selectMedDb.qty}</td>
								</tr>
		
                    </tbody>
                </table>

            </div>
        </div>

    </div>
    

    <!--Form-->
    <form action="PharmaceuticalControllerServlet" class="form-horizontal" method="POST" >
        <fieldset>

            <!-- Input for send info of request-->
            <input type="hidden" name="infoPost" value="updateMed">
            
            
            <!-- Input Pharmaceutical ID-->
            <div class="form-group row">
                <label for="pMedId" class="col-lg-2 col-form-label-sm">Qty</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control form-control-sm" id="pMedId" name="pMedId" placeholder="Medicine ID">
                </div>
            </div>
            
            <% if(s1!=null){ %>
		    <div class="besideemailbox" style="color : red">No Such Medicine</div>
		    <% }else { %>
		    <div class="besideemailbox" style="color : green">There You go</div>
		    <% } %>
            
            <button name="btnSubmit" type="submit" class="btn btn-outline-success btn-sm">Assign</button>

        </fieldset>
    </form>


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