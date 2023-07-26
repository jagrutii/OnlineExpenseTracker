<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@page isELIgnored ="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/all_css.jsp"%>
<style>
body {
	background-color: #f8f9fa;
}

.card {
	border: none;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	background-color: #ffffff;
}

.form-label {
	font-weight: bold;
}

.form-control {
	border-radius: 0;
}

.form-control:focus {
	box-shadow: none;
}

.btn-primary {
	background-color: #007bff;
	border-color: #007bff;
	border-radius: 0;
}

.btn-primary:hover {
	background-color: #0069d9;
	border-color: #0062cc;
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>
	<div class="container">
		<div class="row justify-content-center align-items-center"
			style="min-height: 50vh;">
			<div class="col-md-6 mt-2">
				<div class="card">
					<div class="card-header text-center fs-3">Login Page</div>
					
					<c:if test="${not empty msg}">
				<p class="text-center text-danger fs-4">${msg}</p>
				<c:remove var="msg"/>
				</c:if>
					
					<div class="card-body">
						<form method="post" action="login">

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
								</label> <input type="email" class="form-control" id="email"
									name="email" aria-describedby="emailHelp">
							</div>


							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control" id="password"
									name="password">
							</div>

							<button type="submit" class="btn btn-success col-md-12">Login</button>
							<div class="text-center mt-2">
							Don't have an accout <a href="register.jsp" class="text-decoration-none">Create One</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>