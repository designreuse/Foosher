<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Foosher - <tiles:insertAttribute name="title"/></title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="<c:url value="/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="<c:url value="/css/ionicons.min.css"/>" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <link href="<c:url value="/css/morris/morris.css"/>" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="<c:url value="/css/jvectormap/jquery-jvectormap-1.2.2.css"/>" rel="stylesheet" type="text/css" />
        <!-- fullCalendar -->
        <link href="<c:url value="/css/fullcalendar/fullcalendar.css"/>" rel="stylesheet" type="text/css" />
        <!-- Daterange picker -->
        <link href="<c:url value="/css/daterangepicker/daterangepicker-bs3.css"/>" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <link href="<c:url value="/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css"/>" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="<c:url value="/css/AdminLTE.css"/>" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="skin-blue">
        
        <tiles:insertAttribute name="header"/>
        
        <div class="wrapper row-offcanvas row-offcanvas-left">
            
            <tiles:insertAttribute name="sidebar"/>
            
            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                
                <tiles:insertAttribute name="breadcrumb"/>

                <!-- Main content -->
                <section class="content">

					<tiles:insertAttribute name="content"/>
					
                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->

        <!-- add new calendar event modal -->


        <!-- jQuery 2.0.2 -->
        <script src="<c:url value="/js/jquery-2.0.2.js"/>"></script>
        <!-- jQuery UI 1.10.3 -->
        <script src="<c:url value="/js/jquery-ui-1.10.3.min.js"/>" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="<c:url value="/js/bootstrap.min.js"/>" type="text/javascript"></script>
        <!-- Morris.js charts -->
        <script src="<c:url value="/js/raphael-210.js"/>"></script>
        <script src="<c:url value="/js/plugins/morris/morris.min.js"/>" type="text/javascript"></script>
        <!-- Sparkline -->
        <script src="<c:url value="/js/plugins/sparkline/jquery.sparkline.min.js"/>" type="text/javascript"></script>
        <!-- jvectormap -->
        <script src="<c:url value="/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"/>" type="text/javascript"></script>
        <!-- fullCalendar -->
        <script src="<c:url value="/js/plugins/fullcalendar/fullcalendar.min.js"/>" type="text/javascript"></script>
        <!-- jQuery Knob Chart -->
        <script src="<c:url value="/js/plugins/jqueryKnob/jquery.knob.js"/>" type="text/javascript"></script>
        <!-- daterangepicker -->
        <script src="<c:url value="/js/plugins/daterangepicker/daterangepicker.js"/>" type="text/javascript"></script>
        <!-- Bootstrap WYSIHTML5 -->
        <script src="<c:url value="/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"/>" type="text/javascript"></script>
        <!-- iCheck -->
        <script src="<c:url value="/js/plugins/iCheck/icheck.min.js"/>" type="text/javascript"></script>

        <!-- AdminLTE App -->
        <script src="<c:url value="/js/AdminLTE/app.js"/>" type="text/javascript"></script>
        
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="<c:url value="/js/AdminLTE/dashboard.js"/>" type="text/javascript"></script>        

    </body>
</html>