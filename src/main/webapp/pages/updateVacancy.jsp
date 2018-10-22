<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Spring MVC and JDBC CRUD Example</title>
<body>
<h2>Spring MVC and JDBC CRUD Example</h2>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<h3>Update Vacancy</h3>
<form method="POST" name="update_vacancy"
      action="<%=request.getContextPath()%>/update/vacancy">
    <input hidden="hidden" name="id" value="${id}" type="text" />
    Position: <input name="pos" value="${vacancy.position}" type="text"/>
        <br/>
        <br/>
        Salary from <input name="sal_from" value="${vacancy.salary_from}" type="text"/>
        <br/>
        <br/>
        Salary to: <input name="sal_to" value="${vacancy.salary_to}"
                          type="text"/>
        <br/>
        <br/>
        Vacancy state: <input name="vac_state" value="${vacancy.vacancy_state}"
                              type="text"/>
        <br/>
        <br/>
        Experience: <input name="exp_years" value="${vacancy.experience_years_require}"
                           type="text"/>
        <br/>
        <br/>
        Creator of vacancy: <input name="dev_id" value="${vacancy.developer_id}"
                                   type="text"/>
        <br/>
        <br/>
    <br /> <input value="Update Vacancy" type="submit" />
</form>
</body>
</html>