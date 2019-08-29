<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="main/resources/css/register.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Registration</title>
</head>

<!------ Include the above in your HEAD tag ---------->
<body>
<div class="container register">
	<div class="row">
		<div class="col-md-3 register-left">
			<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
			<h3>Welcome</h3>
			<p>StockMarket welcomes You!</p>
			<input type="submit" name="" value="Login" /><br />
		</div>
		<div class="col-md-9 register-right">
			<ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link active" id="home-tab"
					data-toggle="tab" href="#home" role="tab" aria-controls="home"
					aria-selected="true">User Registration</a></li>

			</ul>

			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="home" role="tabpanel"
					aria-labelledby="home-tab">

					<br> <br>
					<form action="registerUser" method="post">
						<div class="row register-form">
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="username *" name="username" />
								</div>
								<div class="form-group">
									<input type="password" class="form-control"
										placeholder="password" name="password" />
								</div>

							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="email" class="form-control"
										placeholder="Your Email *" name="email" />
								</div>
								<div class="form-group">
									<input type="text" minlength="10" maxlength="10"
										class="form-control" placeholder="Your Phone *" name="number" />
								</div>
								<div class="form-group">
									<select class="form-control" name="userType">
										<option class="hidden" selected disabled>User Type</option>
										<option>admin</option>
										<option>normal</option>

									</select>
								</div>

								<input type="submit" class="btnRegister" value="Register" />
							</div>
						</div>
				</div>
				</form>

			</div>
		</div>
	</div>

</div>
</body>
</html>