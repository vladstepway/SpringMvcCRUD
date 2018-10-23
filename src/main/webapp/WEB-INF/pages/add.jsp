
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<springForm:form method="POST" modelAttribute="user"
                 action="/user/add.do">
    <table>
        <tr>
            <td>Name:</td>
            <td><springForm:input path="firstName" /></td>
            <td><springForm:errors path="firstName" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><springForm:input path="surname" /></td>
            <td><springForm:errors path="surname" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><springForm:input path="email" /></td>
            <td><springForm:errors path="email" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><springForm:input path="password"/></td>
            <td><springForm:errors path="password" cssClass="error" /></td>
        </tr>
        <tr>
            <td>User Role:</td>
            <td><springForm:select path="userRole">
                <springForm:option value="" label="Select user role" />
                <springForm:option value="manager" label="manager" />
                <springForm:option value="developer" label="developer" />
                <springForm:option value="interviewer" label="interviewer" />
                <springForm:option value="admin" label="admin" />

            </springForm:select></td>
            <td><springForm:errors path="userRole" cssClass="error" /></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="Save Customer"></td>
        </tr>
    </table>

</springForm:form>

</body>
</html>
