<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Main content -->
<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-6">
            <!-- general form elements -->
            <div class="box box-primary">
                <div class="box-header">
                    <h3 class="box-title">Edit Role</h3>
                    <h2><c:out value="${message}" /></h2>
                </div><!-- /.box-header -->
                <!-- form start -->
                <form:form method="POST" commandName="roleModel" role="form">
                    <div class="box-body">
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
                    </div><!-- /.box-body -->

                    <div class="box-footer">
                    	<form:hidden path="id"/>
					    <form:hidden path="createdAt"/>
					    <form:hidden path="enabled"/>
                    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </form:form>
            </div><!-- /.box -->
		</div>
	</div>
</section>