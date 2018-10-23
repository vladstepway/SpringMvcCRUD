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
<c:choose>
    <c:when test="${candidate != null}">
        <h3>List of Candidates</h3>
        <table cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>ID</th>
                <th> Name</th>
                <th>Surname</th>
                <th>Birthday</th>
                <th>Expected salary</th>
                <th>Candidate state</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="candidate" items="${candidate}">
                <tr>
                    <td>${candidate.id}</td>
                    <td>${candidate.name}</td>
                    <td>${candidate.surname}</td>
                    <td>${candidate.birthday}</td>
                    <td>${candidate.expected_salary}</td>
                    <td>${candidate.candidate_state}</td>
                    <td><a
                            href="<%=request.getContextPath()%>/update/candidate/${candidate.id}">Update</a>
                        &nbsp; <a
                                href="<%=request.getContextPath()%>/delete/candidate/${candidate.id}"
                                onclick="return confirm('Do you really want to delete?')">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        No Candidate found in the DB!
    </c:otherwise>
</c:choose>
</body>
</html>