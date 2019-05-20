<%@ page import="java.util.List,com.hospital.login.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page %>
<!DOCTYPE html>
<html lang="en">
<head>
	
  <title>Admin Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap CSS CDN -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <!--Login CSS-->
  <link rel="stylesheet" href="css/login.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
</head>
<body>
<%! String s1 = ""; %>
<% s1  = (String) session.getAttribute("errorAdmin");%>

<div class="container">
	<div class="login-box">
		<h2>Admin Login</h2>
  		<form action="LoginControllerServlet" method="post">
	  	<input type="hidden" name="infoLog" value="admin">
	    <div class="form-group">
	      
	      <input type="text" class="form-control" id="userId" name="userId" placeholder="Enter User ID" name="email">
	    </div>
	    <div class="form-group">
	      
	      <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password" name="pwd">
	    </div>

	    <button style="text-align:center; padding-right: 70px;" class="social-button" id="cashier-connect" type="submit" ><span>Login</span></button>
	    <% if(s1!=null){ %>
			   
			    <div class="alert alert-danger" role="alert">
  					<strong>Ooops!</strong><%=s1 %>
				</div>
		 <% }else { %>
			    
			    
		 <% } %>
  </form>
	
	</div>
  
</div>

</body>
</html>







