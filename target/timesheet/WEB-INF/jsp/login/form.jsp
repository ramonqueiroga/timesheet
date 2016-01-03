<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="timesheet"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>TimeSheet</title>
<script src="<c:url value='/js/jquery-2.0.0.js' />"></script>
<script src="<c:url value='/js/bootstrap.js' />"></script>
<script src="<c:url value='/js/showPassword.js' />"></script>
<script src="<c:url value='/js/jquery-validate-min.js' />"></script>
<script src="<c:url value='/js/myMessagesValidation.js' />"></script>

<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet" />
<link href="<c:url value='/css/site.css'/>" rel="stylesheet" />
<link href="<c:url value='/css/login.css'/>" rel="stylesheet" />
</head>
<body>

	<div class="login-background">
		<nav class="navbar navbar-fixed-top navbar-light"
			style="background-color: #222222; color: #FFFFFF;">
			<div class="container">
				<div class="navbar-text pull-left">${textoPagina}</div>
			</div>
		</nav>

		<section id="login">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="form-wrap">
							<h1>${textoPagina}</h1>
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
								</div>
								<div class="form-group">
									<label for="usuario" class="sr-only">Usuário</label> <input
										type="text" name="usuario" id="usuario"
										class="form-control transparent-input" placeholder="Usuário">
								</div>
								<div class="form-group">
									<label for="senha" class="sr-only">Senha</label> <input
										type="password" name="senha" id="senha"
										class="form-control transparent-input" placeholder="Senha">
								</div>
								<div class="checkbox">
									<span class="character-checkbox" onclick="showPassword()"></span>
									<span class="label">Mostrar senha</span>
								</div>
								<input type="submit" id="btn-login"
									class="btn btn-custom btn-lg btn-block transparent-input"
									value="Entrar">
							</form>
							
							<script type="text/javascript">
								$('#login-form').validate({
									errorClass : "form-error-class",
									validClass : "form-valid-class",
									rules :{
										"usuario" : {
											required : true
										},
										"senha" : {
											required : true,
										}
									}
								});
							</script>
							
							
							<a href="#" class="forget" data-toggle="modal"
								data-target=".signin-modal">Não possui cadastro?</a> 
							<a href="#" class="forget" data-toggle="modal" data-target=".forget-modal">Esqueceu
								sua senha?</a>
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
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">Recuperar senha</h4>
					</div>
					<div class="modal-body">
						<p>Type your email account</p>
						<input type="email" name="recovery-email" id="recovery-email"
							class="form-control" autocomplete="off">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<button type="button" class="btn btn-custom">Recuperar</button>
					</div>
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
							<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">Preencha os dados</h4>
					</div>

					<form role="form"
						action="${linkTo[CadastroController].cadastraUsuario(null)}"
						method="post" 
						id="formCadastro" 
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
					
					<script type="text/javascript">
						$('#formCadastro').validate({
							errorClass : "form-error-class",
							validClass : "form-valid-class",
							rules :{
								"usuario.nome" : {
									required : true
								},
								"usuario.email" : {
									required : true,
									email : true
								},
								"usuario.login" : {
									required : true,
									minlength : 4
								},
								"usuario.senha" : {
									required : true,
									minlength : 6
								}
							}
							
						});
					</script>
					
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