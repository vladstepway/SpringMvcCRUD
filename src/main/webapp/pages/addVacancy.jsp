
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
            color: #ff3338;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>
<%--<c:if test="${not empty msg}">--%>
<%--${msg}--%>
<%--</c:if>--%>
<springForm:form method="POST" modelAttribute="vacancy"
                 action="/vacancy/add.do">
    <table>
        <tr>
            <td>position:</td>
            <td><springForm:input path="position"/></td>
            <td><springForm:errors path="position" cssClass="error" /></td>
        </tr>
        <tr>
            <td>salary from:</td>
            <td><springForm:input path="salary_from" /></td>
            <td><springForm:errors path="salary_from" cssClass="error" /></td>
        </tr>
        <tr>
            <td>salary to:</td>
            <td><springForm:input path="salary_to" /></td>
            <td><springForm:errors path="salary_to" cssClass="error" /></td>
        </tr>
        <tr>
            <td>User Role:</td>
            <td><springForm:select path="vacancy_state">
                <springForm:option value="OPENED" label="OPENED" />
                <springForm:option value="CLOSED" label="CLOSED" />
            </springForm:select></td>

        </tr>
        <tr>
            <td>exp years require:</td>
            <td><springForm:input path="experience_years_require" /></td>
            <td><springForm:errors path="experience_years_require" cssClass="error" /></td>
        </tr>
        <tr>
            <td>DeveloperId:</td>
            <td>
                <form:label path="developer_id">developer_id:</form:label>
                <form:select path="developer_id" size="1">
                    <form:options items="${developerIDList}"/>
                </form:select>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Add Interview"></td>
        </tr>
    </table>

</springForm:form>

</body>
</html>
