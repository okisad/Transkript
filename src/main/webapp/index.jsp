<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/fundamental.css" rel="stylesheet">
<link href="css/bootstrap1.min.css" rel="stylesheet">
<link href="css/homepage.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>

<title>HomePage</title>
</head>
<body>
	<div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header text-uppercase">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">HATALI GİRİŞ</h4>
                    </div>
                    <div class="modal-body text-center">
                        <p>Email veya şifre hatalı</p>
                    </div>
                </div>
            </div>
        </div>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#collapse-login">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand">TRANSKRİPT</a>
			</div>
			<div class="collapse navbar-collapse" id="collapse-login">
				<form data-toggle="validator"
					class="navbar-form navbar-right text-right" id="signin" role="form"
					method="post" action="loginservlet">
					<div class="form-group">
						<input type="text" name="email" placeholder="Email Adresi"
							class="form-control" data-error="Email adres geçerli değil"
							required />
					</div>
					<div class="form-group">
						<input type="password" name="password" placeholder="Şifre"
							class="form-control" required />
					</div>
					<div class="form-group">
						<button id="loginButton" type="submit" name="loginButton"
							class="btn btn-md btn-success btn-block">Giriş</button>
					</div>
				</form>
			</div>
		</div>
	</nav>
	<div class="topbuffer10 container">
		<div class="hidden-xs col-sm-6" id="textDiv">
			<p class="lead">
				Transkriptini <b>Şekillendir</b>.
			</p>

			<p class="lead">
				Ortalamanı <b>Hesapla</b>.
			</p>

			<p class="lead">
				Geleceğini <b>Gör</b>.
			</p>
		</div>
		<div class="col-xs-12 col-sm-6">
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header text-uppercase">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">HATALI GİRİŞ</h4>
						</div>
						<div class="modal-body text-center">
							<p>Email veya şifre hatalı</p>
						</div>
					</div>
				</div>
			</div>
			<h2 class="text-uppercase text-center topbuffer8">KAYIT</h2>
	
			<form data-toggle="validator" id="signup-form"
				class="topbuffer3 form-signup col-md-10 col-md-offset-1"
				method="post" action="registerservlet" name="signup-form"
				role="form">

				<div class="form-group">
					<input type="email" class="form-control" name="sign-up-email"
						placeholder="Email Adresi" data-error="Email adres geçerli değil"
						required />
				</div>
				<div class="form-group">
					<input type="password" data-minlength="6" class="form-control"
						id="sign-up-password1" name="sign-up-password1"
						placeholder="Şifre" required />
					<p class="help-block">Şifre en az 6 karakter olmalı</p>
				</div>
				<div class="form-group">
					<input type="password" data-minlength="6" class="form-control"
						id="sign-up-password2" name="sign-up-password2"
						placeholder="Şifre Tekrar" required
						data-match="#sign-up-password1"
						data-match-error="Whoops, these don't match" />

				</div>
				<div class="form-group">
					<button class="btn btn-lg btn-success btn-block" type="submit"
						name="signUpButton">Kayıt ol</button>
				</div>
			</form>

		</div>
	</div>
	<footer class="footer">
		<div class="container">
			<div class="row">	
				<div class="col-xs-3 col-xs-offset-9">
					<p>© 2015 Transkript</p>
				</div>
			</div>
		</div>
	</footer>
	<script src="js/jquery-2.1.3.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>


	<!-- Form Control js -->
	<script src="js/validator.js"></script>
	<script src="js/error.js" type="text/javascript"></script>


	
</body>
</html>