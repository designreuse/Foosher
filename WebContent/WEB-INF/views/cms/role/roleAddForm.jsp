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
                <i class="fa fa-edit"></i> Add Role
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->

<div class="row">
    <div class="col-lg-6">
		<h2><c:out value="${message}" /></h2>
        <form:form method="POST" commandName="roleModel" role="form">

            <div class="form-group">
                <form:label path="description">Role Description:</form:label>
                <form:input path="description" value="${role.description}" cssClass="form-control"/>
            </div>
            <div class="form-group has-error"><form:errors path="description" cssClass="form-control"/></div>

            <div class="form-group">
                <form:label path="code">Code:</form:label>
                <form:input path="code" value="${role.code}" cssClass="form-control"/>
            </div>
             <div class="form-group has-error"><form:errors path="code" cssClass="form-control"/></div>
            
            
            <div class="form-group">
            	<input type="submit" value="Submit" class="btn btn-success"/>
            </div>

		</form:form>
    </div>
</div>