package br.com.timesheet.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.timesheet.dao.HoraLancadaDao;
import br.com.timesheet.modelos.HoraLancada;
import br.com.timesheet.modelos.RelatorioDeHoras;
import br.com.timesheet.seguranca.UsuarioLogado;

@Controller
public class HoraLancadaController {

	private HoraLancadaDao horaLancadaDao;
	private Validator validator;
	private Result result;
	private UsuarioLogado usuarioLogado;

	@Inject
	public HoraLancadaController(HoraLancadaDao horaLancadaDao,
			Validator validator, Result result, UsuarioLogado usuarioLogado) {
		this.horaLancadaDao = horaLancadaDao;
		this.validator = validator;
		this.result = result;
		this.usuarioLogado = usuarioLogado;
	}

	public HoraLancadaController() {}
	
	public void form(){
		result.include("textoPagina", "Lançamento de horas");
	}
	
	public void adiciona(@Valid HoraLancada horaLancada){
		validator.onErrorRedirectTo(this).form();
		horaLancada.setUsuario(usuarioLogado.getUsuario());
		horaLancadaDao.adiciona(horaLancada);
		result.redirectTo(this).lista();
	}
	
	public void lista(){
		result.include("horas", horaLancadaDao.lista(usuarioLogado.getUsuario()));
		result.include("textoPagina", "Horas lançadas");
	}
	
	public void relatorioDeHoras(){
		List<HoraLancada> horas = horaLancadaDao.lista(usuarioLogado.getUsuario());
		RelatorioDeHoras relatorioDeHoras = new RelatorioDeHoras(horas);
		result.include("textoPagina", "Relatório de horas");
		result.include("relatorio", relatorioDeHoras);
	}

}