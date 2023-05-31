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
						<form action="update.Member" method="post">

							<h3 style="text-align: center;">회원가입</h3>
							<div>
								<table
									style="width: 400px; height: 200px; margin-left: auto; margin-right: auto;">
									<tr>
										<td>아이디</td>
										<td><input type="text" name="id"
											value="${requestScope.dto.id }" readonly></td>
									</tr>
									<tr>
										<td>비번</td>
										<td>${requestScope.dto.pwd }</td>
									</tr>
									<tr>
										<td>이름</td>
										<td><input type="text" name="name"
											value="${requestScope.dto.name }"
											style="background-color: yellow"></td>
									</tr>
									<tr>
										<td>나이</td>
										<td><input type="text" name="age"
											value="${requestScope.dto.age }"
											style="background-color: yellow"></td>
									</tr>
									<tr>
										<td>성별</td>
										<td>[${requestScope.dto.gender}] <input type="radio"
											name="gender" id="gender" value="여"
											${requestScope.dto.gender == '여' ? 'checked' : ''}>여자
											<input type="radio" name="gender" id="gender" value="남"
											${requestScope.dto.gender == '남' ? 'checked' : ''}>남자
										</td>
									</tr>
									<tr>
										<td>이메일</td>
										<td><input type="text" name="email"
											value="${requestScope.dto.email }"
											style="background-color: yellow"></td>
									</tr>
									<tr>
										<td colspan="2"><input type="submit" value="수정하기">
											<a href="list.Member">리스트이동</a></td>
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