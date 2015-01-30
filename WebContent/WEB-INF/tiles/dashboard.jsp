<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Foosher Inc. - <tiles:insertAttribute name="title"/> </title>

    <!-- Bootstrap Core CSS -->
    <link href='<c:url value="/admin/css/bootstrap.min.css"/>' rel="stylesheet">

    <!-- Custom CSS -->
    <link href='<c:url value="/admin/css/sb-admin.css"/>' rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href='<c:url value="/admin/css/plugins/morris.css"/>' rel="stylesheet">

    <!-- Custom Fonts -->
    <link href='<c:url value="/admin/font-awesome/css/font-awesome.min.css"/>' rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		
	        <!-- Navigation Header -->
	        <tiles:insertAttribute name="header" />
	        
	        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
	        <tiles:insertAttribute name="nav" />

		</nav>
        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
               <tiles:insertAttribute name="body" />

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src='<c:url value="/admin/js/jquery.js"/>'></script>

    <!-- Bootstrap Core JavaScript -->
    <script src='<c:url value="/admin/js/bootstrap.min.js"/>'></script>

    <!-- Morris Charts JavaScript -->
    <script src='<c:url value="/admin/js/plugins/morris/raphael.min.js"/>'></script>
    <script src='<c:url value="/admin/js/plugins/morris/morris.min.js"/>'></script>
    <script src='<c:url value="/admin/js/plugins/morris/morris-data.js"/>'></script>

</body>

</html>