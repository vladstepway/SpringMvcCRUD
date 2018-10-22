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
    <c:when test="${vacancy != null}">
        <h3>List of Vacancies</h3>
        <table cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>ID</th>
                <th>Position</th>
                <th>Salary from</th>
                <th>Salary to</th>
                <th>Vacancy state</th>
                <th>Experience</th>
                <th>Developer(id)</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="vacancy" items="${vacancy}">
                <tr>
                    <td>${vacancy.id}</td>
                    <td>${vacancy.position}</td>
                    <td>${vacancy.salary_from}</td>
                    <td>${vacancy.salary_to}</td>
                    <td>${vacancy.vacancy_state}</td>
                    <td>${vacancy.experience_years_require}</td>
                    <td>${vacancy.developer_id}</td>

                    <td><a href="<%=request.getContextPath()%>/update/vacancy/${vacancy.id}">Update</a>
                        &nbsp;
                        <a href="<%=request.getContextPath()%>/delete/vacancy/${vacancy.id}"
                                  onclick="return confirm('Do you really want to delete?')">Delete</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        No Vacancy found in the DB!
    </c:otherwise>
</c:choose>
</body>
</html>