package br.com.alura.horas.modelos;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class RelatorioDeHorasTest {
	
	@Test
	public void calculaRelatorioQuandoDatasSaoIguais(){
//		Calendar data = new GregorianCalendar(2015, 10, 06);
//		HoraLancada hora1 = novaHoraLancada("10:00", "18:00", data);
//		HoraLancada hora2 = novaHoraLancada("10:00", "18:00", data);
//		
//		RelatorioDeHoras relatorio = new RelatorioDeHoras(Arrays.asList(hora1, hora2));
//		List<HorasPorDia> horasPorDia = relatorio.getHorasPorDia();
//		
//		Assert.assertEquals(1, horasPorDia.size());
//		
//		HorasPorDia dia = horasPorDia.get(0);
//		
//		Assert.assertEquals(8.0, dia.getHorasNormais(), 0.01);
//		Assert.assertEquals(0.0, dia.getHorasExtras(), 0.01);
	}
	
	@Test
	public void calculaRelatorioQuandoDatasSaoDiferentes(){
//		Calendar data1 = new GregorianCalendar(2015, 10, 06);
//		Calendar data2 = new GregorianCalendar(2015, 10, 07);
//		HoraLancada hora1 = novaHoraLancada("10:00", "18:00", data1);
//		HoraLancada hora2 = novaHoraLancada("10:00", "20:00", data2);
//		
//		RelatorioDeHoras relatorio = new RelatorioDeHoras(Arrays.asList(hora1, hora2));
//		List<HorasPorDia> horasPorDia = relatorio.getHorasPorDia();
//		
//		Assert.assertEquals(2, horasPorDia.size());
//		
//		HorasPorDia dia = horasPorDia.get(0);
//		Assert.assertEquals(8.0, dia.getHorasNormais(), 0.01);
//		Assert.assertEquals(0.0, dia.getHorasExtras(), 0.01);
//		
//		HorasPorDia dia2 = horasPorDia.get(1);
//		Assert.assertEquals(8.0, dia2.getHorasNormais(), 0.01);
//		Assert.assertEquals(2.0, dia2.getHorasExtras(), 0.01);		
	}	

	private HoraLancada novaHoraLancada(String horaInicial, String horaFinal, Calendar data) {
		HoraLancada hora = new HoraLancada();
		hora.setData(data);
		hora.setHoraFinal(horaFinal);
		hora.setHoraInicial(horaInicial);
		return hora;
	}

}
