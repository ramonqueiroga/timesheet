<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="timesheet" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<section id="login">
    <div class="container">
    	<div class="row">
    	    <div class="col-xs-12">
        	    <div class="form-wrap">
                <h1>${textoPagina}</h1>
                    <form role="form" action="${linkTo[LoginController].autentica(null, null)}" method="post" id="login-form" autocomplete="off">
                        <div class="form-group">
                        	<c:if test="${errors.size() > 0 }">
                        		<div class="alert alert-danger">
  									<strong>${errors.from('loginInvalido')}</strong>.
								</div>
                        	</c:if>
                        	</div>
                        <div class="form-group">
                            <label for="usuario" class="sr-only">Usuário</label>
                            <input type="text" name="usuario" id="usuario" class="form-control" placeholder="Usuário">
                        </div>
                        <div class="form-group">
                            <label for="senha" class="sr-only">Senha</label>
                            <input type="password" name="senha" id="senha" class="form-control" placeholder="Senha">
                        </div>
                        <div class="checkbox">
                            <span class="character-checkbox" onclick="showPassword()"></span>
                            <span class="label">Mostrar senha</span>
                        </div>
                        <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="Entrar">
                    </form>
                    <a href="javascript:;" class="forget" data-toggle="modal" data-target=".forget-modal">Esqueceu sua senha?</a>
                    <hr>
        	    </div>
    		</div> <!-- /.col-xs-12 -->
    	</div> <!-- /.row -->
    </div> <!-- /.container -->
</section>

<div class="modal fade forget-modal" tabindex="-1" role="dialog" aria-labelledby="myForgetModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span>
					<span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">Recuperar senha</h4>
			</div>
			<div class="modal-body">
				<p>Type your email account</p>
				<input type="email" name="recovery-email" id="recovery-email" class="form-control" autocomplete="off">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<button type="button" class="btn btn-custom">Recuperar</button>
			</div>
		</div> <!-- /.modal-content -->
	</div> <!-- /.modal-dialog -->
</div> <!-- /.modal -->

<c:import url="/WEB-INF/jsp/footer.jsp" />