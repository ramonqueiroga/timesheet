package br.com.alura.horas.modelos;

import org.junit.Assert;
import org.junit.Test;

public class HoraLancadaTest {

	@Test
	public void calculaDuracaoQuandoHoraInicialMenorQueHoraFinal() {
		HoraLancada hora = new HoraLancada();
		hora.setHoraFinal("19:00");
		hora.setHoraInicial("09:00");
		Assert.assertEquals("10:00", hora.getDuracao());
	}
	
}
