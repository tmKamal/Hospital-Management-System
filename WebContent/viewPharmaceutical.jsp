<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List,com.hospital.management.jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="include/adminheader.jsp" />


<%
		//get the pharmaceutical from the Controller class
		
		List<Pharmaceutical> listJspP=(List<Pharmaceutical>)request.getAttribute("tmpList");
%>

<!--=====================================================
Custom content page - body - Referencing (adminheader.jsp)
=========================================================-->

<div class="main_content col-lg-10 col-md-12 col-sm-12 ">
    <div class="content-title">
        <h2>VIEW PHARMACEUTICALS</h2>
        <div class="row">
            <div class="col-sm-12 table-inside">

                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Qty</th>
                        <th scope="col">Price</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Remove</th>
                    </tr>
                    </thead>
                    <tbody>

                   			
                   		<%
							for(Pharmaceutical printList : listJspP){
								%>
								<tr>
									<td><%= printList.getName()%></td>
									<td><%= printList.getBrandName()%></td>
									<td><%= printList.getQty()%></td>
									<td><%= printList.getPrice()%></td>
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