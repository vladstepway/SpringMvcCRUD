<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<form action="/skill/add" method="get">
    <p><button>Add</button></p>
</form>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${skill != null}">
        <h3>List of Skills</h3>
        <table cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>name</th>
            </tr>
            </thead>u
            <tbody>
            <c:forEach var="skill" items="${skill}">
                <tr>
                    <td>${skill.name}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/skill/update/${skill.name}">Update</a>
                        &nbsp;
                        <a href="<%=request.getContextPath()%>/skill/delete${skill.name}"
                           onclick="return confirm('Do you really want to delete?')">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:when>
    <c:otherwise>
        No skill found in the DB!
    </c:otherwise>
</c:choose>
</body>
</html>