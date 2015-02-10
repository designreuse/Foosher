<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Page Heading -->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
	            Users
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
            </li>
            <li class="active">
                <i class="fa fa-edit"></i> Add User
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->

<div class="row">
    <div class="col-lg-6">
		<h2><c:out value="${message}" /></h2>
        <form:form method="POST" commandName="userModel" role="form">
        
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            <div class="form-group">
                <form:label path="username">Username:</form:label>
                <form:input path="username" value="${user.username}" cssClass="form-control"/>
            </div>
            <div class="form-group has-error"><form:errors path="username" cssClass="form-control"/></div>

          <div class="form-group">
                <form:label path="password">Password:</form:label>
                <form:input path="password" value="${user.password}" cssClass="form-control"/>
            </div>
            <div class="form-group has-error"><form:errors path="password" cssClass="form-control"/></div>

             <div class="form-group">
                <form:label path="firstname">First Name:</form:label>
                <form:input path="firstname" value="${user.firstname}" cssClass="form-control"/>
            </div>
            <div class="form-group has-error"><form:errors path="firstname" cssClass="form-control"/></div>
            
             <div class="form-group">
                <form:label path="middlename">Middle Name:</form:label>
                <form:input path="middlename" value="${user.middlename}" cssClass="form-control"/>
            </div>
            <div class="form-group has-error"><form:errors path="middlename" cssClass="form-control"/></div>
            
             <div class="form-group">
                <form:label path="lastname">Surname:</form:label>
                <form:input path="lastname" value="${user.lastname}" cssClass="form-control"/>
            </div>
            <div class="form-group has-error"><form:errors path="lastname" cssClass="form-control"/></div>
            
             <div class="form-group">
                <form:label path="address">Address:</form:label>
                <form:input path="address" value="${user.address}" cssClass="form-control"/>
            </div>
            <div class="form-group has-error"><form:errors path="address" cssClass="form-control"/></div>
            
             <div class="form-group">
                <form:label path="city">City:</form:label>
                <form:input path="city" value="${user.city}" cssClass="form-control"/>
            </div>
            <div class="form-group has-error"><form:errors path="city" cssClass="form-control"/></div>
            
             <div class="form-group">
                <form:label path="zipcode">Zipcode:</form:label>
                <form:input path="zipcode" value="${user.zipcode}" cssClass="form-control"/>
            </div>
            <div class="form-group has-error"><form:errors path="zipcode" cssClass="form-control"/></div>
            
             <div class="form-group">
                <form:label path="contactno">Contact #:</form:label>
                <form:input path="contactno" value="${user.contactno}" cssClass="form-control"/>
            </div>
            <div class="form-group has-error"><form:errors path="contactno" cssClass="form-control"/></div>
            
            <div class="form-group">
            	 <form:label path="roles">Select Roles:</form:label>
           	 </div>
          	 <div class="form-group">
            	<form:select multiple="true" path="roles" items="${activeRoles}" itemLabel="description" itemValue="idString" />
            	 <div class="form-group has-error"><form:errors path="roles" cssClass="form-control"/></div>
            </div>
            
            
            <div class="form-group">
            	<input type="submit" value="Submit" class="btn btn-success"/>
            </div>

		</form:form>
    </div>
</div>