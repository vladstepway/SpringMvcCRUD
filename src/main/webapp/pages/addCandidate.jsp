<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<title>Spring MVC and JDBC CRUD Example</title>
<body>
<h2>Spring MVC and JDBC CRUD Example</h2>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<h3>Add Candidate</h3>
<form method="POST" name="add_candidate"
      action="<%=request.getContextPath()%>/add/candidate">
    Name: <input name="name" value="${name}" type="text"/>
    <br/> <br/>
    Surname: <input name="sname" value="${surname}" type="text"/>
    <br/> <br/>
    Birthday: <input name="bday" value="${birthday}" type="text"/>
    <br/> <br/>
    Expected salary: <input name="exp_salary" value="${expected_salary}" type="text"/>
    <br/> <br/>
    Candidate state: <input name="cand_state" value="${candidate_state}" type="text"/>
    <br/> <br/>
    <input value="Add Candidate" type="submit"/>
</form>
</body>
</html>