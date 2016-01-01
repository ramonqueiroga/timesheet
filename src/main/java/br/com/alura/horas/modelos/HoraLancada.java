package br.com.alura.horas.modelos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class HoraLancada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Calendar data;

	@NotEmpty(message="Precisa preencher a hora inicial!")
	private String horaInicial;
	
	@NotEmpty(message="Precisa preencher a hora final!")
	private String horaFinal;

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

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDuracao() {
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");

			Date inicio = format.parse(horaInicial);
			Date fim = format.parse(horaFinal);
			long millis = fim.getTime() - inicio.getTime();

			long minutos = (millis / 60000) % 60;
			long horas = (millis / 3600000);

			return String.format("%02d:%02d", horas, minutos);
		} catch (java.text.ParseException e) {
			return "NONE";
		}
	}

	public double getDuracaoNumber() {
		double total = 0.0;
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			Date inicio = format.parse(horaInicial);
			Date fim = format.parse(horaFinal);
			long millis = fim.getTime() - inicio.getTime();
			total = (millis / (1000 * 60 * 60));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return total;
	}

}
