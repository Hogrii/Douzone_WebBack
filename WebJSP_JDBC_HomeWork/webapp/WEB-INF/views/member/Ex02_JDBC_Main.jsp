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
						<!-- MAIN PAGE CONTENT  --> <c:choose>
							<c:when test="${sessionScope.userid != null}">
						${sessionScope.userid } 회원님 방가방가^^<br>
						<c:if test="${sessionScope.userid == 'admin' }">
									<a href="list.Member">회원관리</a>
								</c:if>
							</c:when>
							<c:otherwise>
						사이트 방문을 환영합니다^^ <br>회원가입 좀 하지...
					</c:otherwise>
						</c:choose>
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


