<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${interviewFeedback != null}">
        <table cellpadding="3" cellspacing="5">
            <thead>
            <tr>
                <th>interview_id</th>
                <th>interviewer_id</th>
                <th>feedback_state</th>
                <th>reason</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="interviewFeedback" items="${interviewFeedback}">
                <tr>
                    <td>${interviewFeedback.interview_id}</td>
                    <td>${interviewFeedback.interviewer_id}</td>
                    <td>${interviewFeedback.feedback_state}</td>
                    <td>${interviewFeedback.reason}</td>
                    <td><a href="<%=request.getContextPath()%>/interviewFeedback/update/${interviewFeedback.interview_id}">Update</a>
                        &nbsp;
                        <a   href="<%=request.getContextPath()%>/interviewFeedback/delete/${interviewFeedback.interview_id}"
                             onclick="return confirm('Do you really want to delete?')">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        No feedback found in the DB!
    </c:otherwise>
</c:choose>
</body>
</html>