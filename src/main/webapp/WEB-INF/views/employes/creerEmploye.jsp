<%-- <%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%> --%>

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
					<li class="active"><a href="/paie/mvc/employes/lister">Employes</a></li>
					<li><a href="/paie/mvc/bulletins/lister">Bulletins</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<br>

	<a href="/paie/mvc/employes/lister" class="btn btn-lg btn-warning"><span
		class="glyphicon glyphicon-arrow-left"> Retour</span> </a>

	<br>
	<br>

	<form:form class="form-horizontal" modelAttribute="employe">
		<fieldset>

			<!-- Form Name -->
			<legend>
				<h1 align="center">Créer un employé</h1>
			</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="matricule">Matricule
					: </label>
				<div class="col-md-2">
					<form:input path="matricule" class="form-control input-md" />
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="entreprises">Entreprise
					:</label>
				<div class="col-md-2">
					<form:select path="entreprise" class="form-control">
						<form:options itemValue="id" items="${listeEntreprise}" />
					</form:select>
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="profiles">Profile
					: </label>
				<div class="col-md-2">
					<form:select path="profilRemuneration" class="form-control">
						<form:options itemValue="id" items="${listProfile}" />
					</form:select>
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="grades">Grade</label>
				<div class="col-md-2">
					<form:select path="grade" class="form-control">
						<form:options itemValue="id" items="${listeGrade}" />
					</form:select>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="envoyer"></label>
				<div class="col-md-4">
					<button id="envoyer" name="envoyer" class="btn btn-success">Envoyer</button>
				</div>
			</div>

		</fieldset>
	</form:form>


</body>
</html>