<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:out value="${message}" />
<form:form method="POST" commandName="userModel">
	<table>
	 
	    <tr>
	        <td><form:label path="username">Username:</form:label></td>
	        <td><form:input path="username" value="${user.username}"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="password">Password:</form:label></td>
	        <td><form:password path="password" value="${user.password}"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="email">Email:</form:label></td>
	        <td><form:input path="email" value="${user.email}"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="firstname">First Name:</form:label></td>
	        <td><form:input path="firstname" value="${user.firstname}"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="middlename">Middle Name</form:label></td>
	        <td><form:input path="middlename" value="${user.middlename}"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="lastname">Last Name:</form:label></td>
	        <td><form:input path="lastname" value="${user.lastname}"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="address">Address:</form:label></td>
	        <td><form:input path="address" value="${user.address}"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="city">City:</form:label></td>
	        <td><form:input path="city" value="${user.city}"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="zipcode">Zip Code:</form:label></td>
	        <td><form:input path="zipcode" value="${user.zipcode}"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="contactno">COntact No:</form:label></td>
	        <td><form:input path="contactno" value="${user.contactno}"/></td>
	    </tr>
	    
	    <tr>
	      <td colspan="2"><input type="submit" value="Submit"/></td>
      </tr>
	</table> 
</form:form>