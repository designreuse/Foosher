<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Main content -->
<form:form method="GET">
<section class="content">
    <div class="row">
        <div class="col-md-12">
	               <div class="box">
	                   <div class="box-header">
	                       <h3 class="box-title">Roles Table <small>displaying ${pagination.countTotal} result/s</small></h3>
	                                          
	                       <div class="box-tools">
	                           <div class="input-group">
	                               <input type="text" name="searchName" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>
	                               <input type="hidden" name="size" value="${pagination.pageSize}"/>
	                               <input type="hidden" name="page" value="${pagination.page}"/>
	                               <input type="hidden" name="column" value="${pagination.column}"/>
	                               <input type="hidden" name="ascending" value="${pagination.isAscending}"/>
	                               <div class="input-group-btn">
           		                   		<input type="submit" class="btn btn-sm btn-default" value="Search">
           		                   		<select name="searchCategory">
           		                   			<option value="description">Description</option>
           		                   			<option value="code">Code</option>
           		                   			<option value="createdAt">Created Date</option>
           		                   			<option value="updatedAt">Updated Date</option>
           		                   		</select>
	                               </div>
	                               
	                           </div>
	        				</div>
	                        <div class="box-tools">
	                           <div class="input-group">
	                               <label class="pull-right" style="width: 65px;">Display </label>
	                               <div class="input-group-btn">
	                               		<c:forEach begin="1" end="5" varStatus="loop">
  											<a class="btn btn-sm" href="<c:url value="list.html">
		                               			<c:param name="size" value="${loop.index * 5}"/>
		                               			<c:param name="page" value="${pagination.page}" />
		                               			<c:param name="column" value="${pagination.column}"/>
								        		<c:param name="ascending" value="${pagination.isAscending}"/>
								        		<c:param name="searchName" value="${pagination.searchName}"/>
								        		<c:param name="searchCategory" value="${pagination.searchCategory}"/></c:url>">
	                               				${loop.index * 5}
                               				</a>
										</c:forEach>
                               		</div>
	                           </div>
	                       </div>              
	                   </div><!-- /.box-header -->
	                   <div class="box-body table-responsive no-padding">
	                       <table class="table table-hover">
	                           <tr>
	                               <th>
	                               		<a href="<c:url value="list.html">
	                               			<c:param name="size" value="${pagination.pageSize}"/>
	                               			<c:param name="page" value="${pagination.page}" />
	                               			<c:param name="column" value="description"/>
							        		<c:param name="ascending" value="${!pagination.isAscending}"/>
							        		<c:param name="searchName" value="${pagination.searchName}"/>
							        		<c:param name="searchCategory" value="${pagination.searchCategory}"/></c:url>">
		                               		Description
	                               		</a>
	                               </th>
	                               	<th>
	                               		<a href="<c:url value="list.html">
	                               			<c:param name="size" value="${pagination.pageSize}"/>
	                               			<c:param name="page" value="${pagination.page}" />
	                               			<c:param name="column" value="code"/>
							        		<c:param name="ascending" value="${!pagination.isAscending}"/>
							        		<c:param name="searchName" value="${pagination.searchName}"/>
							        		<c:param name="searchCategory" value="${pagination.searchCategory}"/></c:url>">
	                               			Code
	                               		</a>
	                               	</th>
	                               <th>
	                               		<a href="<c:url value="list.html">
	                               			<c:param name="size" value="${pagination.pageSize}"/>
	                               			<c:param name="page" value="${pagination.page}" />
	                               			<c:param name="column" value="createdAt"/>
							        		<c:param name="ascending" value="${!pagination.isAscending}"/>
							        		<c:param name="searchName" value="${pagination.searchName}"/>
							        		<c:param name="searchCategory" value="${pagination.searchCategory}"/></c:url>">
	                               			Created
	                               		</a>
	                               	</th>
	                               <th>
	                               		<a href="<c:url value="list.html">
	                               			<c:param name="size" value="${pagination.pageSize}"/>
	                               			<c:param name="page" value="${pagination.page}" />
	                               			<c:param name="column" value="updatedAt"/>
							        		<c:param name="ascending" value="${!pagination.isAscending}"/>
							        		<c:param name="searchName" value="${pagination.searchName}"/>
							        		<c:param name="searchCategory" value="${pagination.searchCategory}"/></c:url>">
	                               			Updated
                               			</a>
                            		</th>
	                               <th>Options</th>
	                           </tr>
	                           <c:choose>
								<c:when test="${pagination.countTotal > 0}">
				             		<c:forEach items="${pagination.pageList}" var="role">
				                  		<tr>
				                          <td><c:out value="${role.description}"></c:out></td>
				                          <td><c:out value="${role.code}"></c:out></td>
				                          <td><c:out value="${role.createdAt}"></c:out></td>
				                          <td><c:out value="${role.updatedAt}"></c:out></td>
				                          <td><a href="<c:url value="edit.html" ><c:param name="id" value="${role.id}"/></c:url>" class="btn btn-sm btn-primary">Edit</a>
				                          <a href="<c:url value="disable.html" ><c:param name="id" value="${role.id}"/></c:url>" class="btn btn-sm btn-danger">Delete</a></td>
				                      	</tr>
				                  	</c:forEach> 
			                  	</c:when>
			                  	<c:otherwise>
			                  		<tr><td colspan="5">Nothing to display.</td></tr>
			                  	</c:otherwise>
		                  	</c:choose>
		                  	</table>
		                  	 
						</div><!-- /.box-body -->
			    			 <div class="box-footer clear">
							<ul class="pagination pagination-sm no-margin pull-right">
							<c:if test="${pagination.pageCount > 1}">
							    <c:if test="${!pagination.firstPage}">
							        <li>
							        	<a href="<c:url value="list.html">
							        		<c:param name="size" value="${pagination.pageSize}"/>
							        		<c:param name="page" value="${pagination.page - 1}"/>
							        		<c:param name="column" value="${pagination.column}"/>
							        		<c:param name="ascending" value="${pagination.isAscending}"/>
							        		<c:param name="searchName" value="${pagination.searchName}"/>
							        		<c:param name="searchCategory" value="${pagination.searchCategory}"/></c:url> ">
							        		&lt;
							        	</a>
					        		</li>
							    </c:if>
							    <c:if test="${pagination.firstLinkedPage > 0}">
							        <li>
							        	<a href="<c:url value="list.html">
							        		<c:param name="size" value="${pagination.pageSize}"/>
							        		<c:param name="page" value="0"/>
							        		<c:param name="column" value="${pagination.column}"/>
							        		<c:param name="ascending" value="${pagination.isAscending}"/>
							        		<c:param name="searchName" value="${pagination.searchName}"/>
							        		<c:param name="searchCategory" value="${pagination.searchCategory}"/></c:url>">
							        		1
						        		</a>
					        		</li>
							    </c:if>
							    <c:if test="${pagination.firstLinkedPage > 1}">
							        <li>
							        	...
						        	</li>
							    </c:if>
							    <c:forEach begin="${pagination.firstLinkedPage}" end="${pagination.lastLinkedPage}" var="i">
							        <c:choose>
							            <c:when test="${pagination.page == i}">
							                <li>
							                	<a href="#">
							                		<strong style="text-decoration: underline">${i+1}</strong>
						                		</a>
						                	</li>
							            </c:when>
							            <c:otherwise>
							                <li>
							                	<a href="<c:url value="list.html">
							                		<c:param name="size" value="${pagination.pageSize}"/>
							                		<c:param name="page" value="${i}"/>
							                   		<c:param name="column" value="${pagination.column}"/>
									        		<c:param name="ascending" value="${pagination.isAscending}"/>
									        		<c:param name="searchName" value="${pagination.searchName}"/>
									        		<c:param name="searchCategory" value="${pagination.searchCategory}"/></c:url>">
							                		${i+1}
						                		</a>
					                		</li>
							            </c:otherwise>
							        </c:choose>
							    </c:forEach>
							    <c:if test="${pagination.lastLinkedPage < pagination.pageCount - 2}">
							        <li>
							        	...
						        	</li>
							    </c:if>
							    <c:if test="${pagination.lastLinkedPage < pagination.pageCount - 1}">
							        <li>
							        	<a href="<c:url value="list.html">
							        		<c:param name="size" value="${pagination.pageSize}"/>
							        		<c:param name="page" value="${pagination.pageCount-1}"/>
							        		<c:param name="column" value="${pagination.column}"/>
							        		<c:param name="ascending" value="${pagination.isAscending}"/>
							        		<c:param name="searchName" value="${pagination.searchName}"/>
							        		<c:param name="searchCategory" value="${pagination.searchCategory}"/></c:url>">
							        		${pagination.pageCount}
						        		</a>
						        	</li>
							    </c:if>
							    <c:if test="${!pagination.lastPage}">
							        <li>
							        	<a href="<c:url value="list.html">
							        		<c:param name="size" value="${pagination.pageSize}"/>
							        		<c:param name="page" value="${pagination.page +1}"/>
							        		<c:param name="column" value="${pagination.column}"/>
							        		<c:param name="ascending" value="${pagination.isAscending}"/>
							        		<c:param name="searchName" value="${pagination.searchName}"/>
							        		<c:param name="searchCategory" value="${pagination.searchCategory}"/></c:url>">
							        		&gt;
						        		</a>
						        	</li>
							    </c:if>
							</c:if>
							</ul>
						</div>          
	               </div><!-- /.box -->
	           </div>
	       </div>
	</section>
</form:form>