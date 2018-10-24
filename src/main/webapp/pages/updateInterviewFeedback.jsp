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
<h3>Update InterviewF</h3>
<form method="POST" name="update_interviewFeedback"
      action="<%=request.getContextPath()%>/interviewFeedback/update">
    <tr>
        <td>Interview_id:</td>
        <td>
            <form:label path="interview_id">interview_id:</form:label>
            <form:select path="interview_id" size="1">
                <form:options items="${interviewIdList}"/>
            </form:select>
    </tr>
    <tr>
        <td>Interviewer_id:</td>
        <td>
            <form:label path="interviewer_id">interviewer_id:</form:label>
            <form:select path="interviewer_id" size="1">
                <form:options items="${interviewerIdList}"/>
            </form:select>
    </tr>
    <tr>
        <td>Feedback_State:</td>
        <td>
            <form:label path="feedback_state">feedback_state:</form:label>
            <form:select path="feedback_state" size="1">
                <form:options items="${feedbackStatesList}"/>
            </form:select>
    </tr>
    <tr>
        <td>Reason:</td>
        <td><springForm:input path="reason"/></td>
        <td><springForm:errors path="reason" cssClass="error" /></td>
    </tr>

    <br /> <input value="Update InterviewFeedback" type="submit" />
</form>
</body>
</html>