
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Save Page</title>
    <style>
        .error {
            color: #2364ff;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>
<%--<c:if test="${not empty msg}">--%>
<%--${msg}--%>
<%--</c:if>--%>
<springForm:form method="POST" modelAttribute="interviewFeedback"
                 action="/interviewFeedback/add.do">
    <table>
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

        <tr>
            <td colspan="3"><input type="submit" value="Add interviewFeedback"></td>
        </tr>
    </table>

</springForm:form>

</body>
</html>
