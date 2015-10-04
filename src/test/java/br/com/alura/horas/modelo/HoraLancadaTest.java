package br.com.alura.horas.modelo;

import org.junit.Assert;
import org.junit.Test;

import br.com.alura.horas.modelos.HoraLancada;

public class HoraLancadaTest {

	@Test
	public void calculaDuracaoQuandoHoraInicialMenorQueHoraFinal() {
		HoraLancada hora = new HoraLancada();
		hora.setHoraFinal("19:00");
		hora.setHoraInicial("09:00");
		Assert.assertEquals("10:00:00", hora.getDuracao());
	}

}