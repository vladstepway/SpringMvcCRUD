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
<h3>Add Vacancy</h3>
<form method="POST" name="add_vacancy"
      action="<%=request.getContextPath()%>/add/vacancy">

    Position: <input name="pos" value="${position}" type="text"/>
    <br/>
    <br/>
    Salary from <input name="sal_from" value="${salary_from}" type="text"/>
    <br/>
    <br/>
    Salary to: <input name="sal_to" value="${salary_to}"
                      type="text"/>
    <br/>
    <br/>
    Vacancy state: <input name="vac_state" value="${vacancy_state}"
                          type="text"/>
    <br/>
    <br/>
    Experience: <input name="exp_years" value="${experience_years_require}"
                       type="text"/>
    <br/>
    <br/>
    Creator of vacancy: <input name="dev_id" value="${developer_id}"
                               type="text"/>
    <br/>
    <br/>
    <input value="Add Vacancy"
           type="submit"/>
</form>
</body>
</html>