<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!-- Main content -->
<section class="content">
    <div class="row">
        <div class="col-md-12">
	       <div class="row">
	           <div class="col-xs-12">
	               <div class="box">
	                   <div class="box-header">
	                       <h3 class="box-title">List of Roles</h3>
	                       <div class="box-tools">
	                           <div class="input-group">
	                               <input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>
	                               <div class="input-group-btn">
	                                   <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
	                               </div>
	                           </div>
	                       </div>
	                   </div><!-- /.box-header -->
	                   <div class="box-body table-responsive no-padding">
	                       <table class="table table-hover">
	                           <tr>
	                               <th>Description</th>
	                               <th>Code</th>
	                               <th>Created</th>
	                               <th>Updated</th>
	                               <th>Options</th>
	                           </tr>
	                           <c:choose>
								<c:when test="${not empty roles}">
				                  	<c:forEach items="${roles}" var="role">
				                  		<tr>
				                          <td><c:out value="${role.description}"></c:out></td>
				                          <td><c:out value="${role.code}"></c:out></td>
				                          <td><c:out value="${role.createdAt}"></c:out></td>
				                           <td><c:out value="${role.updatedAt}"></c:out></td>
				                          <td><a href="<c:url value="edit.htm" ><c:param name="id" value="${role.id}"/></c:url>" class="btn btn-sm btn-primary">Edit</a>
				                          <a href="<c:url value="disable.htm" ><c:param name="id" value="${role.id}"/></c:url>" class="btn btn-sm btn-danger">Delete</a></td>
				                      	</tr>
				                  	</c:forEach> 
			                  	</c:when>
			                  	<c:otherwise>
			                  		<tr><td colspan="5">Nothing to display.</td></tr>
			                  	</c:otherwise>
		                  	</c:choose>
	                       </table>
	                   </div><!-- /.box-body -->
	               </div><!-- /.box -->
	           </div>
	       </div>
			</div>
		</div>
	</section>