package br.com.timesheet.business.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtil {

	public static String calculadaDuracaoEntreDatas(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		long horas = ChronoUnit.HOURS.between(dataInicial, dataFinal);
		long minutos = ChronoUnit.MINUTES.between(dataInicial, dataFinal);
		
		Duration duracao = Duration.ofHours(horas).ofMinutes(minutos);
		
		LocalTime t = LocalTime.MIDNIGHT.plus(duracao);
		return DateTimeFormatter.ofPattern("hh:mm:ss").format(t);
	}
	
}
