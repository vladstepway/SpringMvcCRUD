<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<body>

<c:if test="${not empty msg}">
    ${msg}
</c:if>
<h3>Update Candidate</h3>
<form method="POST" name="update_user"
      action="<%=request.getContextPath()%>/candidate/update">
    <input hidden="hidden" name="id" value="${candidate.id}" type="text" />
    First Name: <input name="name" value="${candidate.name}" type="text" /><br />
    <br /> Last Name: <input name="surname" value="${candidate.surname}" type="text" /> <br />
    <br /> Birthday: <input name="birthday"   value="${candidate.birthday}" type="text" /><br />
    <br /> Expected salary: <input name="expected_salary"   value="${candidate.expected_salary}" type="text" /><br />
    <br />
    <td>Candidate State:</td>
    <td>  <form:label path="candidate_state">candidate_state:</form:label>
        <form:select path="candidate_state" size="1">
            <form:options items="${candidateStateList}"/>
        </form:select>
   </td><br />
    <br /> <input value="Update Candidate" type="submit" />
</form>
</body>
</html>