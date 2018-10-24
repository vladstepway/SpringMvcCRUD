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
      action="<%=request.getContextPath()%>/skill/update">
    Name: <input name="name" value="${skill.name}" type="text" /><br />
    <br /> <input value="Update Skill" type="submit" />
</form>
</body>
</html>