<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<title>Vacancy Info</title>
<body>
<h2>Info about vacancy : ${vacancy.id}</h2>
<br/> Position : ${vacancy.position}
<br/> Salary from : ${vacancy.salary_from}
<br/> Salary to : ${vacancy.salary_to}
<br/> Vacancy state : ${vacancy.vacancy_state}
<br/> Experience : ${vacancy.experience_years_require}
<br/> Developer id : ${vacancy.developer_id}
</body>
</html>