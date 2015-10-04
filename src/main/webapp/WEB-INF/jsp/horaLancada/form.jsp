<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="timesheet" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

	<form action="${linkTo[HoraLancadaController].adiciona(null)}" method="post">
		<label for="data">Data: </label>
		<input type="text" name="horaLancada.data" id="data" class="form-control" />
		<timesheet:validationMessage name="horaLancada.data"></timesheet:validationMessage>
		
		<label for="horaInicial">Hora Inicial: </label>
		<input type="text" name="horaLancada.horaInicial" id="horaInicial" class="form-control" />
		<timesheet:validationMessage name="horaLancada.horaInicial"></timesheet:validationMessage>
		
		<label for="horaInicial">Hora Final: </label>
		<input type="text" name="horaLancada.horaFinal" id="horaFinal" class="form-control" />
		<timesheet:validationMessage name="horaLancada.horaFinal"></timesheet:validationMessage>
		
		<input type="submit" value="Cadastrar" class="btn"/>
	
	</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />