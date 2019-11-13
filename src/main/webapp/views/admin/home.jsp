<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Trang chủ</title>
</head>

<body>
	<div class="container">
		<h1>Estate Real</h1>
		  <nav class="class="navbar navbar-dark bg-primary"">
			<ul class="nav">
			  <li class="nav-item">
			    <a class="nav-link active" href="#">Home</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#">Add Building</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#">Search Building</a>
			  </li>
			</ul>
		  </nav>
		  <img src="<c:url value="/template/img/REstate.jpg"></c:url>" class="img-fluid" alt="Responsive image">
	</div>
</body>

</html>