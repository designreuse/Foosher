<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:out value="${message}" />
<form:form method="POST" commandName="categoryModel">
	<table>
	 
	    <tr>
	        <td><form:label path="description">Category Description:</form:label></td>
	        <td><form:input path="description" value="${category.description}"/></td>
	    </tr>
	    
	    <tr>
	      <td colspan="2"><input type="submit" value="Submit"/></td>
      </tr>
	</table> 
</form:form>