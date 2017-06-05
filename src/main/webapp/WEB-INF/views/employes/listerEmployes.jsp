<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" pageEncoding="UTF-8"%>



<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'></c:url>">
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/js/bootstrap.js'></c:url>">
<title>SGP - liste employes</title>
</head>

<body class="container jumbotron">

	<br>
	<br>
	<br>
	<br>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/paie/index.html">Pro RH</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="/paie/index.html">Home</a></li>
					<li class="active"><a href="/paie/mvc/employes/lister">Employes</a></li>
					<li><a href="/paie/mvc/bulletins/lister">Bulletins</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>


	<h1>liste des Employes</h1>

	<a href="/paie/mvc/employes/creer" type="button"
		class="btn btn-sm btn-warning"> creer employer </a>


	<br>
	<br>
	<br>

	<div class="container">
		<div class="row">
			<!-- 			<div class="col-md-5  toppad  pull-right col-md-offset-3 ">
				<A href="edit.html">Edit Profile</A> <A href="edit.html">Logout</A>
				<br>
				<p class=" text-info">May 05,2014,03:00 pm</p>
			</div> -->
			<c:forEach var="employe" items="${ Employes }">
				<div
					class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xs-offset-0 col-sm-offset-0 col-md-offset-0 col-lg-offset-0 toppad">


					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">${employe.nom}</h3>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3 col-lg-3 " align="center">
									<img alt="User Pic"
										src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png"
										class="img-circle img-responsive"> <br /> <a href="#"
										class="btn btn-sm btn-primary pull-right"><span
										class="glyphicon glyphicon-search"></span> Détails</a>
								</div>

								<div style="word-wrap: break-word;" class=" col-md-9 col-lg-9 ">
									<table class="jumbotron table table-user-information">
										<tbody>
											<tr>
												<td>Matricule:</td>
												<td>${employe.matricule}</td>
											</tr>
											<tr>
												<td>Adresse:</td>
												<td>${employe.adresse}</td>
											</tr>
											<tr>
												<td>Date de Naissance</td>
												<td>${employe.dateDeNaissance}</td>
											</tr>

											<tr>
											<tr>
												<td>Numéro de sécu:</td>
												<td>${employe.numSecu}</td>
											</tr>
												<!-- 											</tr>
											<td>Phone Number</td>
											<td>123-4567-890(Landline)<br> <br>555-4567-890(Mobile)
											</td>

											</tr> -->
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<a data-original-title="Broadcast Message" data-toggle="tooltip"
								type="button" class="btn btn-sm btn-primary"><i
								class="glyphicon glyphicon-envelope"></i></a> <span
								class="pull-right"> <a
								href="editer?matricule=${employe.matricule}"
								data-original-title="Edit this user" data-toggle="tooltip"
								type="button" class="btn btn-sm btn-warning"><i
									class="glyphicon glyphicon-edit"></i> Modifier</a> <a
								data-original-title="Remove this user" data-toggle="tooltip"
								type="button" class="btn btn-sm btn-danger"><i
									class="glyphicon glyphicon-remove"></i> Supprimer</a>
							</span>
						</div>

					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>

</html>