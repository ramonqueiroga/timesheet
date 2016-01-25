package br.com.timesheet.modelos;

import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	//TODO refatorar esse método
	public String getDuracao() {
//			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//
//			Date inicio = format.parse(horaInicial);
//			Date fim = format.parse(horaFinal);
//			long millis = fim.getTime() - inicio.getTime();
//
//			long minutos = (millis / 60000) % 60;
//			long horas = (millis / 3600000);
//
//			return String.format("%02d:%02d", horas, minutos);
			return "";
	}

	//TODO refatorar esse método
	public double getDuracaoNumber() {
		double total = 0.0;
//		try {
//			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//			Date inicio = format.parse(horaInicial);
//			Date fim = format.parse(horaFinal);
//			long millis = fim.getTime() - inicio.getTime();
//			total = (millis / (1000 * 60 * 60));
//		} catch (java.text.ParseException e) {
//			e.printStackTrace();
//		}
		return total;
	}

}
