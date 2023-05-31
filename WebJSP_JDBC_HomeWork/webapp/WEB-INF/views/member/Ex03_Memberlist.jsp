
<%@page import="kr.or.kosa.utils.ConnectionHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
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
							style="width: 400px; height: 100px; margin-left: auto; margin-right: auto">
							<tr>
								<th colspan="4">회원리스트</th>
							</tr>
							<c:forEach var="member" items="${requestScope.memberList }">
								<tr>
									<td width="100px"><a href='detail.Member?id=${member.id }'>${member.id}</a>
									</td>
									<td width="100px">${member.ip }</td>
									<td><a href="delete.Member?id=${member.id }">[삭제]</a></td>
									<td><a href="moveUpdate.Member?id=${member.id }">[수정]</a></td>
								</tr>
							</c:forEach>
						</table>
						<hr>
						<form action="search.Member" method="post">
							회원명:<input type="text" name="search"> <input
								type="submit" value="이름검색하기">
						</form>
						<hr>
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