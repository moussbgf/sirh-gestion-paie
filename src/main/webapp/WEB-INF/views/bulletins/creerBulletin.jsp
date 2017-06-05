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
				<a class="navbar-brand" href="lister">Pro RH</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li ><a href="/paie/index.html">Home</a></li>
					<li><a href="/paie/mvc/employes/lister">Employes</a></li>
					<li class="active"><a href="activites">Activités</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	
	<br>

	
	<a href="/paie/mvc/bulletins/lister" class="btn btn-lg btn-warning"><span
		class="glyphicon glyphicon-arrow-left"> Retour</span> </a>

	<br>
	<br>
	
	<form class="form-horizontal">
        <fieldset>
            <!-- Form Name -->
            <legend>
                <h1 align="center">Créer un Bulletin</h1>
            </legend>
            <!-- Select Profil -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="selectbasic">Période</label>
                <div class="col-md-4">
                    <select id="selectbasic" name="selectbasic" class="form-control">
                        <c:forEach var="periode" items="${listePeriodes}">
                            <option value="${periode.id}">${periode.dateDebut}  -  ${periode.dateFin}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <!-- Select Grade -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="selectbasic">Matricule</label>
                <div class="col-md-4">
                    <select id="selectbasic" name="selectbasic" class="form-control">
                        <c:forEach var="remun" items="${listEmployes}">
                            <option value="${remun.matricule}">${remun.matricule}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <!-- Input Periode -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Prime exceptionnelle</label>
                <div class="col-md-4">
                    <input id="textinput" name="textinput" type="text" placeholder=""
                        class="form-control input-md">
                </div>
            </div>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton"
                        class="btn btn-primary">Créer</button>
                </div>
            </div>
        </fieldset>
    </form>
	
	
		<br>
	<br>
	<br>
	
	
</body>
</html>
