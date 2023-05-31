<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link"
						href="moveMain.Member">Main</a></li>
					<li class="nav-item"><a class="nav-link"
						href="moveJoin.Member">Register</a></li>
					<c:choose>
						<c:when test="${sessionScope.userid != null }">
							<a href="logout.Member" class="nav-link"> Logout</a>
						</c:when>
						<c:when test="${sessionScope.userid == null }">
							<a href="moveLogin.Member" class="nav-link">Login</a>
						</c:when>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>