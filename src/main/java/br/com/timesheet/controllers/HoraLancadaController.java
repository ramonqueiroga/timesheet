package br.com.timesheet.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.timesheet.infra.dao.HoraLancadaDao;
import br.com.timesheet.infra.seguranca.UsuarioLogado;
import br.com.timesheet.modelos.HoraLancada;
import br.com.timesheet.modelos.Usuario;

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

	public HoraLancadaController() {
		this(null, null, null, null);
	}
	
	public void form(){
		result.include("textoPagina", "Lançamento de horas");
	}
	
	public void adiciona(@Valid HoraLancada horaLancada){
		validator.onErrorRedirectTo(this).form();
	
		Usuario usuario = usuarioLogado.getUsuario();
		horaLancada.setUsuario(usuario);
		horaLancada.setCriado(LocalDateTime.now());
		horaLancada.setCriadoPor(usuario.getUsuarioId().toString());
		
		horaLancadaDao.adiciona(horaLancada);
		result.redirectTo(this).lista();
	}
	
	public void lista() {
		List<HoraLancada> horasCadastradas = horaLancadaDao.listaHorasPorUsuario(usuarioLogado.getUsuario());		
		result.include("horas", horasCadastradas);
	}

}
