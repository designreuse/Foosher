<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:out value="${message}" />
<form:form method="POST" commandName="roleModel">
	<table>
	 
	    <tr>
	        <td><form:label path="description">Role Description:</form:label></td>
	        <td><form:input path="description" value="${role.description}"/></td>
	        <td><form:errors path="description" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="code">Code:</form:label></td>
	        <td><form:input path="code" value="${role.code}"/></td>
	        <td><form:errors path="code" /></td>
	    </tr>
	    <tr>
	      <td colspan="2"><input type="submit" value="Submit"/></td>
      	</tr>
	</table> 
</form:form>