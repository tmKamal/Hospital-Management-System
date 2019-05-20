<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!--Admin CSS-->
    <link rel="stylesheet" href="css/admin_style.css">
    <!--Font CDN-->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,300i,400" rel="stylesheet">
    <!--FontAwesome icon library CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">


    <title>Header Query</title>
</head>
<body>
    <!--NEW STRUCTURE-->
    <div id="wrapper" class="toggled">
        <!--======================
        SIDE BAR
        ==========================-->
        <div id="sidebar-wrapper">

            <div class="box_header">
                <a href="#"><h1 class="boxed_item">CONTROL-<span class="logo_bold">PANEL</span></h1>
                </a><h2 class="logo_title">MyZone.lk</h2>
            </div>

            <ul class="navigation_section">

                <li class="navigation_item">
                    <a href="#">PROFILE</a>
                </li>
                <%
                //===========================================================
                //-------Category Management according to the Session--------
                //===========================================================
                
                if(session.getAttribute("power")=="lvl1"){
                %>	
                	<li class="navigation_item">
                    	<a href="addPharmaceutical.jsp">ADD MEDICINE</a>
                	</li>
                	<li class="navigation_item">
                    	<a href="PharmaceuticalControllerServlet">VIEW MEDICINE</a>
                	</li>
                	<li class="navigation_item">
                    	<a href="selectPatient.jsp">ASSIGN MEDICINES TO PATIENT</a>
                	</li>
                <%
                }else if(session.getAttribute("power")=="lvl2"){
                %>
                	<li class="navigation_item">
                    	<a href="purchasehistory.php">PAYMENTS</a>
                	</li>
                	<li class="navigation_item">
                    	<a href="order.php">PENDING ORDERS</a>
               	 	</li>
                	<li class="navigation_item">
                    	<a href="#">REPORTS</a>
                	</li>
                
                <%
                }else if(session.getAttribute("power")=="all"){ 
                %>
                	<li class="navigation_item">
                    	<a href="addPharmaceutical.jsp">ADD MEDICINE</a>
                	</li>
                	<li class="navigation_item">
                    	<a href="PharmaceuticalControllerServlet">VIEW MEDICINE</a>
                	</li>
                	<li class="navigation_item">
                    	<a href="selectPatient.jsp">ASSIGN MEDICINES TO PATIENT</a>
                	</li>
                	<li class="navigation_item">
                    	<a href="purchasehistory.php">PURCHASED HISTORY</a>
                	</li>
                	<li class="navigation_item">
                    	<a href="order.php">PENDING ORDERS</a>
                	</li>
                	<li class="navigation_item">
                    	<a href="#">REPORTS</a>
                	</li>
                
                <%
                	} 
                %>

            </ul>
            <center>
                <a href="LogoutControllerServlet"><h1 class="boxed_item boxed_item_smaller signup">
                        <i class="fa fa-user"></i>
                        SIGN OUT
                    </h1></a>
            </center>
        </div><!--End SIDE BAR-->

        <!--======================
        page Content
        ==========================-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <!--Page Navigation Bar-->
                <div class="row">
                    <div class="col-sm-12 page-nav">
                        <div class="container">
                            <a href="#" id="tog_btn" onclick="openSlide()"><i  class="fas fa-bars toggle_menu"></i></a>
                            <ul>
                            	<li><a href="signup.html"><i class="fas fa-user"></i>&nbsp;<%=session.getAttribute("userName") %></a></li>
                                <li><a href="contactus.html">Logged as: <%=session.getAttribute("position") %></a></li>
                                <li><a href="index.html"><%=session.getAttribute("email") %></a></li>
                            </ul>
                        </div>
                    </div>
                </div><!--END-Page Navigation bar-->

                <!--All of Our Page Contents Goes Here!!
                ========================================-->
                <div class="page-content-body-wrapper">
                    <div class="row justify-content-center">
                        <!--Custom page content-->





