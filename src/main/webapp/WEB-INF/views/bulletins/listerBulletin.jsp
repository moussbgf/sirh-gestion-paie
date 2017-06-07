<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<title>SIRH - Paie</title>
</head>
<body class="container jumbotron">


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
					<li><a href="/paie/mvc/employes/lister">Employes</a></li>
					<li class="active"><a href="/paie/mvc/bulletins/lister">Bulletins</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<br><br>
	
		<a href="/paie/mvc/bulletins/creer" type="button"
		class="btn btn-sm btn-warning"><span class="glyphicon glyphicon-plus"></span> Créer bulletin</a>
	
	<br>
	
	<div class="container">
		<h2>Liste des bulletins salaire</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Date Heure de création</th>
					<th>Periode</th>
					<th>Matricule</th>
					<th>Salaire Brut</th>
					<th>Net imposable</th>
					<th>Net à payer</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="bulletin" items="${ bulletins }">
<%-- 				<c:set var="calcule" value="${ calcul.calculer(bulletin) }" scope="page"></c:set> --%>
					<tr>
						<td>${calcule} ${ bulletin.dateForm() }</td>
						<td>${ bulletin.periode }</td>
						<td>${ bulletin.remunerationEmploye.matricule }</td>
						<td>${ calcul.calculer(bulletin).salaireBrut }</td>
<%-- 						<td>${ calcul.calculer(bulletin).netImposable } </td> --%>
<%-- 						<td>${ calcul.calculer(bulletin).netAPayer }</td> --%>
						<td><a href="#" class="btn btn-sm btn-primary"><span class="glyphicon glyphicon-search"></span> Visualiser</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

<!-- 	private String salaireDeBase;
	private String salaireBrut;
	private String totalRetenueSalarial;
	private String totalCotisationsPatronales;
	private String netImposable;
	private String netAPayer; -->



</body>
</html>
