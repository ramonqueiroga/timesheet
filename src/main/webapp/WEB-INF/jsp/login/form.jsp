<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="timesheet"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>TimeSheet</title>
<script src="<c:url value='/js/jquery-2.0.0.js' />"></script>
<script src="<c:url value='/js/bootstrap.js' />"></script>
<script src="<c:url value='/js/jquery-validate-min.js' />"></script>
<!-- Esse Js sobrescreve as mensagens do jQuery Validate traduzindo para o portugu�s -->
<script src="<c:url value='/js/myMessagesValidation.js' />"></script>
<script src="<c:url value='/js/login/showPassword.js' />"></script>

<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet" />
<link href="<c:url value='/css/site.css'/>" rel="stylesheet" />
<link href="<c:url value='/css/login.css'/>" rel="stylesheet" />
</head>
<body>

	<div class="login-background">
		<nav class="navbar navbar-fixed-top navbar-light"
			style="background-color: #222222; color: #FFFFFF;">
			<div class="container">
				<div class="navbar-text pull-left">
					Aqui vai o logotipo!
				</div>
			</div>
		</nav>

		<section id="login">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="form-wrap">
							<h1>
								<fmt:message key="titulo.faca.o.login" />
							</h1>
							<form role="form"
								action="${linkTo[LoginController].autentica(null, null)}"
								method="post" id="login-form" autocomplete="off">
								<div class="form-group">
									<c:if test="${errors.size() > 0 }">
										<div class="alert alert-danger">
											<c:forEach var="error" items="${errors}">
												<strong>${error.message}</strong>
											</c:forEach>
										</div>
									</c:if>
									<c:if test="${not empty senhaRecuperada}">
										<div class="alert alert-success">
											<strong>${senhaRecuperada}</strong>
										</div>
									</c:if>
								</div>
								<div class="form-group">
									<label for="usuario" class="sr-only">
										<fmt:message key="label.usuario" />
									</label> 
									<input type="text" name="usuario" id="usuario"
										class="form-control transparent-input" placeholder="Usu�rio">
								</div>
								<div class="form-group">
									<label for="senha" class="sr-only">
										<fmt:message key="label.senha" />
									</label> 
									<input type="password" name="senha" id="senha"
										class="form-control transparent-input" placeholder="Senha">
								</div>
								<div class="checkbox">
									<span class="character-checkbox" onclick="showPassword()"></span>
									<span class="label">
										<fmt:message key="label.mostrar.senha"/>
									</span>
								</div>
								<input type="submit" id="btn-login"
									class="btn btn-custom btn-lg btn-block transparent-input"
									value="Entrar">
							</form>
							
							<!-- valida o formulario de login com jQuery validate -->
							<script src="<c:url value='/js/login/validateLoginForm.js' />"></script>
							
							<a href="#" class="forget" data-toggle="modal" data-target=".signin-modal">
								<fmt:message key="link.nao.possui.cadastro" />
							</a> 
							<a href="#" class="signin" data-toggle="modal" data-target=".forget-modal">
								<fmt:message key="link.esqueceu.sua.senha" />
							</a>
							
							<hr>
							
						</div>
					</div>
					<!-- /.col-xs-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container -->
		</section>

		<div class="modal fade forget-modal" tabindex="-1" role="dialog"
			aria-labelledby="myForgetModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					
					<form role="form" action="${linkTo[LoginController].recuperaSenhaPorEmail(null)}" method="post" id="recovery-form" autocomplete="off">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">�</span> <span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">Recuperar senha</h4>
						</div>
						
						<div class="modal-body">
								<div class="form-group">
									<p>Digite seu email de cadastro</p>
									<input type="email" name="emailTo" id="recovery-email"
										class="form-control" autocomplete="off">
								</div>
						</div>
						
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
							<button type="submit" id="cadastrar" class="btn btn-primary">Recuperar</button>
						</div>
					</form>
					
					<!-- valida o formulario de recupera��o de senha com jQuery validate -->
					<script src="<c:url value='/js/login/validateRecoveryForm.js' />"></script>
					
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->

		<div class="modal fade signin-modal" tabindex="-1" role="dialog"
			aria-labelledby="mySigninModal" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">�</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">Preencha os dados</h4>
					</div>

					<form role="form"
						action="${linkTo[CadastroController].cadastraUsuario(null)}"
						method="post" 
						id="signin-form" 
						autocomplete="off">
						<div class="modal-body">
							<div class="form-group">
								<p>Nome completo:</p>
								<input type="text" name="usuario.nome" id="nome"
									class="form-control" autocomplete="off">
							</div>
							<div class="form-group">
								<p>Email:</p>
								<input type="email" name="usuario.email" id="email"
									class="form-control" autocomplete="off"
									placeholder="exemplo@exemplo.com.br">
							</div>
							<div class="form-group">
								<p>Nome para login:</p>
								<input type="text" name="usuario.login" id="usuarioLogin"
									class="form-control" autocomplete="off">
							</div>
							<div class="form-group">
								<p>Senha:</p>
								<input type="password" name="usuario.senha" id="usuarioSenha"
									class="form-control" autocomplete="off">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Cancelar</button>
							<button type="submit" id="cadastrar" class="btn btn-primary">Enviar</button>
						</div>
					</form>
					
					<!-- valida o formulario de cadastro com jQuery validate -->
					<script src="<c:url value='/js/login/validateSigninForm.js' />"></script>
					
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->


		<div class="navbar navbar-inverse navbar-fixed-bottom"
			role="navigation">
			<div class="container">
				<div class="navbar-text pull-left">Copyright by Ramon Araujo!
				</div>
			</div>
		</div>
	</div>

</body>
</html>