<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="timesheet"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<table class="table table-hover table-bordered">
	<thead>
		<th>Data</th>
		<th>Horas normais</th>
		<th>Horas extras</th>
		<th>Total de horas</th>
	</thead>
	<tbody>
		<c:forEach items="${relatorio.horasPorDia}" var="horas">
			<tr>
				<td>${horas.data.time}</td>
				<td>${horas.horasNormais}</td>
				<td>${horas.horasExtras}</td>
				<td>${horas.total}</td>
			</tr>
		</c:forEach>
	</tbody>

</table>

<c:import url="/WEB-INF/jsp/footer.jsp" />