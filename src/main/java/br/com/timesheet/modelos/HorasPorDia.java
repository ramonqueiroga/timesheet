package br.com.timesheet.modelos;

import java.util.Calendar;

public class HorasPorDia {

	private double horasNormais;
	private double horasExtras;
	private Calendar data;
	private double total;

	public HorasPorDia(double horasNormais, double horasExtras, Calendar data, double total){
		this.horasNormais = horasNormais;
		this.horasExtras = horasExtras;
		this.data = data;
		this.total = total;
	}

	public double getHorasNormais() {
		return horasNormais;
	}

	public void setHorasNormais(double horasNormais) {
		this.horasNormais = horasNormais;
	}

	public double getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(double horasExtras) {
		this.horasExtras = horasExtras;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
