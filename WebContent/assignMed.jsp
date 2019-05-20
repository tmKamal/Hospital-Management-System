<%@page import="com.hospital.patient.Patient"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List,com.hospital.Pharmaceutical.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="include/adminheader.jsp" />  

<!--=====================================================
Custom content page - body - Referencing (adminheader.jsp)
=========================================================-->
 <%! String s2 = ""; %>
 <% s2  = (String) session.getAttribute("medDb1");%>
 <%
 	//set related Patient Nic as a Session
 	
 	Patient sesPatient=(Patient)request.getAttribute("PatientDb");
 	String sesPatientNic=sesPatient.getNic();
 	session.setAttribute("medUserId", sesPatientNic);
 %>

<div class="main_content col-lg-10 col-md-12 col-sm-12 ">

    <!--Form-->
    <form action="PharmaceuticalControllerServlet" class="form-horizontal" method="post" >
        <fieldset>

            <!-- Form Name -->
            <div class="content-title">
                <h2>Patient Name : ${PatientDb.firstName} </h2>
                <h3>Patient Id : ${PatientDb.nic}</h3>
               
            </div>
            
            <!-- Input for send info of request-->
            <input type="hidden" name="infoPost" value="selectMed">
            <input type="hidden" name="patientId" value="${PatientDb.nic}">
            
            
            <!-- Input Pharmaceutical ID-->
            <div class="form-group row">
                <label for="pMedId" class="col-lg-2 col-form-label-sm">Pharmaceutical Id</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control form-control-sm" id="pMedId" name="pMedId" placeholder="Medicine ID">
                </div>
            </div>
            
            <% if(s2=="ret"){ %>
		    <!-- When Returning to this after assigned the medicine from assignMedDb -->
		    <% }else if(s2=="NoMed") { %>
		    <div class="alert alert-danger" role="alert">
  				<strong>Ooops!</strong>That Pharmaceutical doesn't exists.
			</div>
		    <% }else{ %>
		    
		    <%} %>
            
            <button name="btnSubmit1" type="submit" class="btn btn-outline-success btn-sm">Assign</button>

        </fieldset>
    </form>
    
    

    <%
		//get the pharmaceutical from the Controller class
		
		//List<Pharmaceutical> listJspP=(List<Pharmaceutical>)request.getAttribute("tmpList");
        List<AllocatedPharmaceutical> listAllocatedMeds=(List<AllocatedPharmaceutical>)request.getAttribute("AllocatedDb");
%>
<div class="main_content col-lg-10 col-md-12 col-sm-12 ">
    <div class="content-title">
        <h2>Assigned Pharmaceuticals</h2>
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

                   			
                   		<%
							for(AllocatedPharmaceutical printList : listAllocatedMeds){
								
								%>
								<tr>
									<td><%= printList.getId() %></td>
									<td><%= printList.getPhName()%></td>
									<td><%= printList.getPhBrandName() %></td>
									<td><%= printList.getQty() %></td>
								</tr>
								<% 
							}
						%>


                    </tbody>
                </table>

            </div>
        </div>

    </div>
    <!--form-->
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