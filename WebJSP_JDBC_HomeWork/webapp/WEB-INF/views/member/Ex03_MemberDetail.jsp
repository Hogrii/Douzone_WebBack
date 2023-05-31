
<%@page import="kr.or.kosa.utils.ConnectionHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/styles.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="/common/Check.jsp"></jsp:include>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<jsp:include page="/common/sidebar.jsp" />
		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<!-- Top navigation-->
			<jsp:include page="/common/nav.jsp" />
			<!-- Page content-->
			<table
				style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
				<tr>
					<td style="width: 700px">

						<table
							style="width: 400px; height: 100px; margin-left: auto; margin-right: auto;">
							<tr>
								<td style="width: 100px">아이디</td>
								<td style="width: 100px">${requestScope.detail.id }</td>
							</tr>
							<tr>
								<td style="width: 100px">비번</td>
								<td style="width: 100px">${requestScope.detail.pwd }</td>
							</tr>
							<tr>
								<td style="width: 100px">이름</td>
								<td style="width: 100px">${requestScope.detail.name }</td>
							</tr>
							<tr>
								<td style="width: 100px">나이</td>
								<td style="width: 100px">${requestScope.detail.age }</td>
							</tr>
							<tr>
								<td style="width: 100px">성별</td>
								<td style="width: 100px">${requestScope.detail.gender }</td>
							</tr>
							<tr>
								<td style="width: 100px">이메일</td>
								<td style="width: 100px">${requestScope.detail.id }email</td>
							</tr>
							<tr>
								<td colspan="2"><a href="list.Member">목록가기</a></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>