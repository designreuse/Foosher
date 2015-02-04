 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
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
                 <i class="fa fa-table"></i> Users' List
             </li>
         </ol>
     </div>
 </div>
 <!-- /.row -->
 
 
 <div class="row">
      <div class="col-lg-12">
          <div class="table-responsive">
              <table class="table table-bordered table-hover">
                  <tr>
                      <th>Username</th>
                      <th>Name</th>
                      <th>Created Date</th>
                      <th>Last Update</th>
                      <th>Options</th>
                  </tr>
                  <c:choose>
						<c:when test="${not empty users}">
		                  	<c:forEach items="${users}" var="user">
		                  		<tr>
		                          <td><c:out value="${user.username}"></c:out></td>
		                          <td><c:out value="${user.fullName}"></c:out></td>
		                          <td><c:out value="${user.createdAt}"></c:out></td>
		                           <td><c:out value="${user.updatedAt}"></c:out></td>
		                          <td><a href="<c:url value="edit.htm" ><c:param name="id" value="${user.id}"/></c:url>" class="btn btn-sm btn-primary">Edit</a>
		                          <a href="<c:url value="disable.htm" ><c:param name="id" value="${user.id}"/></c:url>" class="btn btn-sm btn-danger">Delete</a></td>
		                      	</tr>
		                  	</c:forEach> 
	                  	</c:when>
	                  	<c:otherwise>
	                  		<tr><td colspan=5">Nothing to display.</td></tr>
	                  	</c:otherwise>
                  	</c:choose>
              </table>
          </div>
      </div>
</div>
                    