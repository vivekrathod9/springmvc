<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page isELIgnored="false" %>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Spring MVC Form Handling</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

 </head>
<body>

	<h2>Add Product Data</h2>

<div class="container">  
  <form:form method="POST" action="http://localhost:8080/newmvcspring/save" modelAttribute="empbean">
      <table>
       <tr>
           <td><form:label path="empId">Employee ID:</form:label></td>
           <td><form:input path="empId" value="${empbean.empId}" /></td>
       </tr>
       
        <tr>
           <td><form:label path="empName">Employee Name:</form:label></td>
           <td><form:input path="empName" value="${empbean.empName}" /></td>
       </tr>
       
        <tr>
           <td><form:label path="empAge">Employee Age:</form:label></td>
           <td><form:input path="empAge" value="${empbean.empAge}" /></td>
       </tr>
       
       
        <tr>
           <td><form:label path="empAddress">Employee Address:</form:label></td>
           <td><form:input path="empAddress" value="${empbean.empAddress}"/></td>
       </tr>
	
		<tr>
         <td colspan="2"><input type="submit" value="Submit"/></td>
        </tr>
	
		</table>
	</form:form>

		<hr>
		
		<c:if test="${!empty employees}">
  <h2>List of Employees</h2>
 <table align="left" border="1">
  <tr>
   <th>Employee ID</th>
   <th>Employee Name</th>
   <th>EMployee Age</th>
   <th>Employee Address</th>
           <th>Actions on Row</th>
  </tr>

  <c:forEach items="${employees}" var="employee">
   <tr>
    <td><c:out value="${employee.empId}"/></td>
    <td><c:out value="${employee.empName}"/></td>
    <td><c:out value="${employee.empAge}"/></td>
    <td><c:out value="${employee.empAddress}"/></td>
    <td align="center">
   </tr>
  </c:forEach>
 </table>
</c:if>

	</div>	

</body>

</html>