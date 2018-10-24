<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<title>Candidate Info</title>
<body>
<h2>Info about candidate : ${candidate.id}</h2>
<br/> Name : ${candidate.name}
<br/> Surname : ${candidate.surname}
<br/> Birthday : ${candidate.birthday}
<br/> Expected salary : ${candidate.expected_salary}
<br/> Candidate state : ${candidate.candidate_state}
</body>
</html>