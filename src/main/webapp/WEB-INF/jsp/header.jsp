<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>TimeSheet</title>
	<script src="<c:url value='/js/jquery-2.0.0.js' />"></script>
	<script src="<c:url value='/js/bootstrap.js' />"></script>
	<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet"/>
	<link href="<c:url value='/css/site.css'/>" rel="stylesheet"/>
</head>
<body>

	<nav class="navbar navbar-fixed-top">
		<ul class="nav nav-tabs">
		    <li class="navbar-brand" role="presentation" class="active"><img alt="Brand" src="<c:url value='/images/icon.png' />"></li>
			<li role="presentation"><a href="${linkTo[IndexController].index()}">Home</a></li>
			<li role="presentation" class="dropdown">
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      			Usuários <span class="caret"></span>
    			</a>
    			<ul class="dropdown-menu">
			        <li><a href="${linkTo[UsuarioController].form()}">Novo usuário</a></li>
			        <li><a href="${linkTo[UsuarioController].lista()}">Usuários cadastrados</a></li>
    			</ul>
  			</li>
  			
			<li role="presentation" class="dropdown">
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      			Horas lançadas <span class="caret"></span>
    			</a>
    			<ul class="dropdown-menu">
			        <li><a href="${linkTo[HoraLancadaController].form()}">Novo lançamento</a></li>
			        <li><a href="${linkTo[HoraLancadaController].lista()}">Horas lançadas</a></li>
			        <li><a href="${linkTo[HoraLancadaController].relatorioDeHoras()}">Relatório de horas</a></li>
    			</ul>
  			</li>  			
			
			<c:if test="${usuarioLogado.logado}">
				<li role="presentation"><a href="${linkTo[LoginController].deslogaUsuario()}">Deslogar</a></li>
			</c:if>
			<c:if test="${!usuarioLogado.logado}">
				<li role="presentation"><a href="${linkTo[LoginController].form()}">Autenticar</a></li>
			</c:if>			
		</ul>
	</nav>
	<nav class="navbar navbar-light" style="background-color: #222222; color:#FFFFFF;">
  		<div class="container">
			<div class="navbar-text pull-left">
				${textoPagina}
			</div>
		</div>
	</nav>

	<div class="container">
		<main class="col-sm-12">
			<!-- conteudo -->
