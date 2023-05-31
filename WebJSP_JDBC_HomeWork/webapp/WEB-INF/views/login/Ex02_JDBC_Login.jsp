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
						<form action="login.Member" method="post" name="loginForm"
							id="joinForm">
							<h3 style="text-align: center;">Login Page</h3>
							<div>
								<table
									style="width: 400px; height: 100px; margin-left: auto; margin-right: auto;">
									<tr>
										<th>아이디:</th>
										<td><input type="text" name="id" id="id"></td>
									</tr>
									<tr>
										<th>비밀번호</th>
										<td><input type="password" name="pwd" id="pwd"></td>
									</tr>
									<tr>
										<td colspan="2"><input type="submit" value="로그인">
											<input type="reset" value="취소"></td>
									</tr>
								</table>

							</div>
						</form>
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