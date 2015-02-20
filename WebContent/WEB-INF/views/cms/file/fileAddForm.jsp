<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Page Heading -->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Roles
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
            </li>
            <li class="active">
                <i class="fa fa-edit"></i> Upload a File
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->

<div class="row">
    <div class="col-lg-6">
		<h2><c:out value="${message}" /></h2>
        <form:form method="POST" enctype="multipart/form-data" role="form" action="upload">
        
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            <div class="form-group">
                <label>Upload File 1:</label>
                <input type="file" name="file">
            </div>
<!-- 
			<div class="form-group">
                <label>Upload File 2:</label>
                <input type="file" name="file">
            </div>
            
            <div class="form-group">
                <label>Upload File 3:</label>
                <input type="file" name="file">
            </div>
            
            <div class="form-group">
                <label>Upload File 4:</label>
                <input type="file" name="file">
            </div>
            
            <div class="form-group">
                <label>Upload File 5:</label>
                <input type="file" name="file">
            </div> -->
            
            <div class="form-group">
            	<input type="submit" value="Upload" class="btn btn-success"/>
            </div>

		</form:form>
    </div>
</div>