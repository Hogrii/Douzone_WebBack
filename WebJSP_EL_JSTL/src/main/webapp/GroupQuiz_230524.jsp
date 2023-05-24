<%@page import="kr.or.kosa.dto.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosa.dao.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	EmpDAO dao = new EmpDAO();
	List<EmpDTO> empList = dao.getSelectAll();
	request.setAttribute("empList", empList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<style>
<style>
    .container {
       width: 100vw;
       height: 100vh;
       display: flex;
       align-items : center;
       justify-content: center;
       
    }
    
	table {
	  border-collapse: collapse;
	  width: 50vw;
	}
	
	th, td {
	  padding-top : 2vh;
	  padding-bottom: 2vh;
	  text-align: center;
	}
	
	tbody > tr{
	  border-bottom: 1px solid #444444;
	}
</style>
</style>
</head>
<body>
	<div class="container">
		<table class="table-primary">
			<tr>
				<th>사번</td>
				<th>사원명</td>
				<th>직업</td>
				<th>급여</td>
				<th>고용일</td>
			</tr>
			<c:forEach var="emp" items="${requestScope.empList }">
				<tr>
					<td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.job }</td>
					<td>${emp.sal }</td>
					<td>${emp.hiredate }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>