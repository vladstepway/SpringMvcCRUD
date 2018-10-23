<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<html>
<title>Spring MVC and JDBC CRUD Example</title>
<body>
<h2>Spring MVC and JDBC CRUD Example</h2>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<h3>Update User</h3>
<form method="POST" name="update_user"
      action="<%=request.getContextPath()%>/update/user">
    <input hidden="hidden" name="id" value="${user.id}" type="text" />
    First Name: <input name="firstName" value="${user.firstName}" type="text" /><br />
    <br /> Last Name: <input name="surname" value="${user.surname}" type="text" /> <br />
    <br /> Email: <input name="email"   value="${user.email}" type="text" /><br />
    <br /> Password: <input name="password"   value="${user.password}" type="text" /><br />
    <br />
    <td>User Role:</td>
    <td><springForm:select path="userRole">
        <springForm:option value="${user.userRole}" label="Select user role" />
        <springForm:option value="manager" label="manager" />
        <springForm:option value="developer" label="developer" />
        <springForm:option value="interviewer" label="interviewer" />
        <springForm:option value="admin" label="admin" />
    </springForm:select></td>
    <td><springForm:errors path="userRole" cssClass="error" /></td><br />
    <br /> <input value="Update User" type="submit" />
</form>
</body>
</html>