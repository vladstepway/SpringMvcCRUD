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
<h3>Update User</h3>
<form method="POST" name="update_interview"
      action="<%=request.getContextPath()%>/interview/update">
    <input hidden="hidden" name="id" value="${interview.id}" type="text" />
   plan_date: <input name="plan_date" value="${interview.plan_date}" type="text" /><br />
    <br /> fact_date: <input name="fact_date" value="${interview.fact_date}" type="text" /> <br />
    <br />
    <tr>
        <td>Vacancy_id:</td>
        <td>
            <form:label path="vacancy_id">vacancy_id:</form:label>
            <form:select path="vacancy_id" size="1">
                <form:options items="${vacancyIdList}"/>
            </form:select>
    </tr>
    <tr>
        <td>Candidate_id:</td>
        <td>
            <form:label path="candidate_id">cndidate_id:</form:label>
            <form:select path="candidate_id" size="1">
                <form:options items="${candidateIdList}"/>
            </form:select>
    </tr>
    <br /> <input value="Update Interview" type="submit" />
</form>
</body>
</html>