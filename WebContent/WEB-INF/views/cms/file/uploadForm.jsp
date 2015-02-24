<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
$(document).ready(function(){
	$('#addFile').click(function(){
		var fileIndex=$('#dumadami-files tr').children().length;
		$('#dumadami-files').append('<tr><td>'+
				'<input type="file" name="files['+fileIndex+']" class="form-control"/>'+
				'</td></tr>');
	});
});
</script>
 
<!-- Main content -->
<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-6">
            <!-- general form elements -->
            <div class="box box-primary">
                <div class="box-header">
                    <h3 class="box-title">Upload File/s</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
                <form:form method="POST" enctype="multipart/form-data" role="form" commandName="uploadModel">
                    <div class="box-body">
                    <c:if test="${not empty requestScope['org.springframework.validation.BindingResult.uploadModel'].allErrors}">
					    <div class="form-group alert alert-danger alert-dismissable">
							<i class="fa fa-ban"></i>
							<button class="close" aria-hidden="true" data-dismiss="alert" type="button">×</button>
							<b>Alert!</b>
							<form:errors path="files"/>
						</div>
					</c:if>
                       <c:if test="${message ne null}">
                        <div class="form-group alert alert-success alert-dismissable">
							<i class="fa fa-check"></i>
							<button class="close" aria-hidden="true" data-dismiss="alert" type="button">×</button>
							<b>Alert!</b>
							<c:out value="${message}"></c:out>
						</div>
                       </c:if>
                        <div class="form-group">
                			 <label>Upload File:</label>
                			 <table id="dumadami-files">
                			 	<tr>
                			 		<td>
                			 			<input type="file" name="files[0]" class="form-control">	
                			 		</td>
                			 	</tr>
                			 </table>
                        </div>
                        
                    </div><!-- /.box-body -->

                    <div class="box-footer">
                    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <button id="addFile" class="btn" onclick="return false;">Add More Files</button>
                    </div>
                </form:form>
            </div><!-- /.box -->
		</div>
	</div>
</section>