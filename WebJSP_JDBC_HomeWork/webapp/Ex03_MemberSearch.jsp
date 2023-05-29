
<%@page import="kr.or.kosa.utils.ConnectionHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
if (session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")) {
	//강제로 페이지 이동
	out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
}

request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}

tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}

td {
	border: solid 1px red;
}
</style>
</head>
<body>
	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2"><jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px"><jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<!--  데이터 받아서 UI 구성 -->
				<table
					style="width: 400px; height: 100px; margin-left: auto; margin-right: auto">
					<tr>
						<th colspan="4">회원리스트</th>
					</tr>
					<c:forEach var="member" items="${requestScope.memberList }">
						<tr>
							<td>${member.id}</td>
							<td>${member.name }</td>
							<td>${member.email }</td>
						</tr>
					</c:forEach>
				</table> <a href="Ex03_Memberlist.jsp">회원 목록 페이지</a> 
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>