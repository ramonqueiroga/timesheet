<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Controle de horas</title>
	<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet"/>
	<link href="<c:url value='/css/site.css'/>" rel="stylesheet"/>
</head>
<body>

	<nav>
		<ul class="nav nav-pills nav-justified">
			<li role="presentation" class="active"><a href="${linkTo[IndexController].index()}">Home</a></li>
			<li role="presentation"><a href="${linkTo[UsuarioController].lista()}">Usuarios</a></li>
			<c:if test="${usuarioLogado.logado}">
				<li role="presentation"><a href="${linkTo[LoginController].deslogaUsuario()}">Deslogar</a></li>
			</c:if>
			<c:if test="${!usuarioLogado.logado}">
				<li role="presentation"><a href="${linkTo[LoginController].form()}">Autenticar</a></li>
			</c:if>			
		</ul>
	</nav>

	<div class="container">
		<main class="col-sm-8">
			<!-- conteudo -->
