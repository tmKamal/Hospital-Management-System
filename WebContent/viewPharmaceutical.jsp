<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List,com.hospital.management.jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pharmaceuticals</title>
</head>
<body>
	<%
		//get the pharmaceutical from the Controller class
		
		List<Pharmaceutical> listJspP=(List<Pharmaceutical>)request.getAttribute("tmpList");
	%>

	
	<table>
		<tr>	
			<th>Name</th>
			<th>Brand Name</th>
			<th>Qty</th>
			<th>Price</th>
		</tr>
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
	</table>
	
	
</body>
</html>