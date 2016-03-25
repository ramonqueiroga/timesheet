package br.com.timesheet.modelos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.timesheet.business.util.DateUtil;

@Entity
public class HoraLancada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Calendar data;

	@Column
	private LocalDateTime horaInicial;
	
	@Column
	private LocalDateTime horaFinal;

	@ManyToOne
	private Usuario usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public LocalDateTime getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(LocalDateTime horaInicial) {
		this.horaInicial = horaInicial;
	}

	public LocalDateTime getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(LocalDateTime horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDuracao() {
		return DateUtil.calculadaDuracaoEntreDatas(horaInicial, horaFinal);
	}

}
