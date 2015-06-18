<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page</title>
<link href="css/mainPage.css" rel="stylesheet">
<link href="css/fundamental.css" rel="stylesheet">
<link href="css/bootstrap1.min.css" rel="stylesheet">

<link href='css/myFont.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header text-uppercase">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">BİLGİ</h4>
				</div>
				<div class="modal-body text-center">
					<p>Email veya şifre hatalı</p>
				</div>
			</div>
		</div>
	</div>
	<div class="hidden-xs col-xs-3 col-xs-offset-9 topbuffer15"
		id="degerTablo">
		<table class="table">
			<thead>
				<h3>DEĞERLER</h3>
			</thead>
			<tbody>
				<tr>
					<td>Alınan Toplam Kredi</td>
					<td>0</td>
				</tr>
				<tr>
					<td>Verilen Toplam Kredi</td>
					<td>0</td>
				</tr>
				<tr>
					<td>Başarı Puanı</td>
					<td>0</td>
				</tr>
				<tr>
					<td>Not Ortalaması</td>
					<td>0.00</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="col-xs-3 col-xs-offset-9" id="formSubmitButton">
		<div class="btn-group-vertical" role="group">
			<div class="btn-group">
				<input id="kaydet" class="btn btn-lg btn-success" type="submit"
					value="Kaydet" form="myForm" name="kaydet">
			</div>
			<div class="btn-group topbuffer5">
				<input id="logout" class="btn btn-lg btn-warning" type="submit"
					form="myForm" name="logout" value="Çıkış">
			</div>
		</div>
	</div>

	<div class="col-xs-3 col-xs-offset-9" id="selectFakulte">
		<select name="fakulte">
			<option value="">Seçiniz</option>
			<option value="IN">İnşaat Fakültesi</option>
			<option value="MM">Mimarlık Fakültesi</option>
			<option value="MK">Makina Fakültesi</option>
			<option value="EE">Elektrik - Elektronik Fakültesi</option>
			<option value="MD">Maden Fakültesi</option>
			<option value="KM">Kimya - Metalurji Fakültesi</option>
			<option value="IS">İşletme Fakültesi</option>
			<option value="GD">Gemi İnşaatı ve Deniz Bilimleri Fakültesi</option>
			<option value="FE">Fen - Edebiyat Fakültesi</option>
			<option value="UU">Uçak ve Uzay Bilimleri Fakültesi</option>
			<option value="KO">Türk Musikisi Devlet Konservatuarı</option>
			<option value="DZ">Denizcilik Fakültesi</option>
			<option value="TK">Tekstil Teknolojileri ve Tasarımı
				Fakültesi</option>
			<option value="BB">Bilgisayar ve Bilişim Fakültesi</option>
		</select> <select name="bolum">

		</select> <select name="yil">

		</select>
		<button class="btn btn-md btn-success" name="myButton">Getir</button>
	</div>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#collapseElements" aria-expanded="true">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#donem1">TRANSKRİPT</a>
			</div>
			<div class="navbar-collapse collapse in" id="collapseElements"
				aria-expanded="true">

				<ul class="nav navbar-nav navbar-right">
					<li><h3>DÖNEMLER :</h3></li>
					<li class="page-scroll"><a href="#donem1">1</a></li>
					<li class="page-scroll"><a href="#donem2">2</a></li>
					<li class="page-scroll">
						<button class="btn btn-md btn-success">-</button>
					</li>
					<li class="page-scroll">
						<button class="btn btn-md btn-success">+</button>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<form id="myForm" name="tableForm" method="post"
		action="mainPageServlet" role="form">
		<section id="donem1" class="tempRow1 topbufferpad13">
			<div class="container">
				<div class="row">
					<div id="planTable1" class="col-md-9">
						<div class="panel-heading text-center">
							<h4>1.DÖNEM</h4>
						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th><h4>Ders Kodu</h4></th>
									<th><h4>Ders Adı</h4></th>
									<th><h4>Ders Notu</h4></th>
									<th><h4>Ders Kredisi</h4></th>
								</tr>
							</thead>
							<tbody>
								<tr id="row_1_1">
									<td><input name="1_1_1"></td>
									<td><input name="1_1_2"></td>
									<td><select name="1_1_3">
									<option value='null'>seçiniz</option>
											<option value="4">aa</option>
											<option value="3.5">ba</option>
											<option value="3">bb</option>
											<option value="2.5">cb</option>
											<option value="2">cc</option>
											<option value="1.5">dc</option>
											<option value="1">dd</option>
											<option value="0">ff</option>
									</select></td>
									<td><input name="1_1_4" value="0"></td>
								</tr>
								<tr id="row_1_2">
									<td><input name="1_2_1"></td>
									<td><input name="1_2_2"></td>
									<td><select name="1_2_3">
									<option value='null'>seçiniz</option>
											<option value="4">aa</option>
											<option value="3.5">ba</option>
											<option value="3">bb</option>
											<option value="2.5">cb</option>
											<option value="2">cc</option>
											<option value="1.5">dc</option>
											<option value="1">dd</option>
											<option value="0">ff</option>
									</select></td>
									<td><input name="1_2_4" value="0"></td>
								</tr>
								<tr id="row_1_3">
									<td><input name="1_3_1"></td>
									<td><input name="1_3_2"></td>
									<td><select name="1_3_3">
									<option value='null'>seçiniz</option>
											<option value="4">aa</option>
											<option value="3.5">ba</option>
											<option value="3">bb</option>
											<option value="2.5">cb</option>
											<option value="2">cc</option>
											<option value="1.5">dc</option>
											<option value="1">dd</option>
											<option value="0">ff</option>
									</select></td>
									<td><input name="1_3_4" value="0"></td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td></td>
									<td></td>
									<td><a id="removeRow1" class="btn btn-md btn-danger">Ders
											Çıkar</a></td>
									<td><a id="addRow1" class="btn btn-md btn-success">Ders
											Ekle</a></td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</section>
		<section id="donem2" class="tempRow2">
			<div class="container">
				<div class="row">
					<div id="planTable2" class="col-md-9">
						<div class="panel-heading text-center">
							<h4>2.DÖNEM</h4>
						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th><h4>Ders Kodu</h4></th>
									<th><h4>Ders Adı</h4></th>
									<th><h4>Ders Notu</h4></th>
									<th><h4>Ders Kredisi</h4></th>
								</tr>
							</thead>
							<tbody>
								<tr id="row_2_1">
									<td><input name="2_1_1"></td>
									<td><input name="2_1_2"></td>
									<td><select name="2_1_3">
									<option value='null'>seçiniz</option>
											<option value="4">aa</option>
											<option value="3.5">ba</option>
											<option value="3">bb</option>
											<option value="2.5">cb</option>
											<option value="2">cc</option>
											<option value="1.5">dc</option>
											<option value="1">dd</option>
											<option value="0">ff</option>
									</select></td>
									<td><input name="2_1_4" value="0"></td>
								</tr>
								<tr id="row_2_2">
									<td><input name="2_2_1"></td>
									<td><input name="2_2_2"></td>
									<td><select name="2_2_3">
									<option value='null'>seçiniz</option>
											<option value="4">aa</option>
											<option value="3.5">ba</option>
											<option value="3">bb</option>
											<option value="2.5">cb</option>
											<option value="2">cc</option>
											<option value="1.5">dc</option>
											<option value="1">dd</option>
											<option value="0">ff</option>
									</select></td>
									<td><input name="2_2_4" value="0"></td>
								</tr>
								<tr id="row_2_3">
									<td><input name="2_3_1"></td>
									<td><input name="2_3_2"></td>
									<td><select name="2_3_3">
									<option value='null'>seçiniz</option>
											<option value="4">aa</option>
											<option value="3.5">ba</option>
											<option value="3">bb</option>
											<option value="2.5">cb</option>
											<option value="2">cc</option>
											<option value="1.5">dc</option>
											<option value="1">dd</option>
											<option value="0">ff</option>
									</select></td>
									<td><input value="0" name="2_3_4"></td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td></td>
									<td></td>
									<td><a id="removeRow2" class="btn btn-md btn-danger">Ders
											Çıkar</a></td>
									<td><a id="addRow2" class="btn btn-md btn-success">Ders
											Ekle</a></td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</section>
	</form>
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
	<script src="js/jquery.easing.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<script src="js/classie.js"></script>
	<script src="js/cbpAnimatedHeader.js"></script>
	<script src="js/freelancer.js"></script>
	<script type="text/javascript" src="js/mainPage.js"></script>
</body>
</html>