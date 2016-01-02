package br.com.timesheet.modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RelatorioDeHoras {

	private List<HorasPorDia> horasPorDia = new ArrayList<HorasPorDia>();

	public RelatorioDeHoras(List<HoraLancada> horas) {
		calculaHorasPorDia(horas);

	}

	private void calculaHorasPorDia(List<HoraLancada> horas) {
		Map<Calendar, ArrayList<Double>> horasAgrupadasPorDia = new HashMap<Calendar, ArrayList<Double>>();
		if (!horas.isEmpty()) {

			horasAgrupadasPorDia.put(horas.get(0).getData(),
					new ArrayList<Double>());
			for (HoraLancada hora : horas) {
				if (horasAgrupadasPorDia.get(hora.getData()) == null) {
					ArrayList<Double> totais = new ArrayList<Double>();
					double horaInicial = Double.parseDouble(hora
							.getHoraInicial().replace(":", "."));
					double horaFinal = Double.parseDouble(hora.getHoraFinal()
							.replace(":", "."));
					double total = horaFinal - horaInicial;
					totais.add(total);
					horasAgrupadasPorDia.put(hora.getData(), totais);
				} else {
					double horaInicial = Double.parseDouble(hora
							.getHoraInicial().replace(":", "."));
					double horaFinal = Double.parseDouble(hora.getHoraFinal()
							.replace(":", "."));
					double total = horaFinal - horaInicial;
					horasAgrupadasPorDia.get(hora.getData()).add(total);
				}

			}

			for (Entry<Calendar, ArrayList<Double>> entry : horasAgrupadasPorDia
					.entrySet()) {

				Calendar data = entry.getKey();
				ArrayList<Double> horasTotais = entry.getValue();
				double horasNormais = 0.0;
				double horasExtras = 0.0;

				double total = 0.0;
				for (Double horaTotal : horasTotais) {
					total += horaTotal;
				}

				if (total > 8.0) {
					horasExtras = total - 8.0;
					horasNormais = 8.0;
				} else {
					horasNormais = total;
				}

				HorasPorDia horaPorDia = new HorasPorDia(horasNormais,
						horasExtras, data, total);
				this.horasPorDia.add(horaPorDia);

			}

		}
	}

	public List<HorasPorDia> getHorasPorDia() {
		return horasPorDia;
	}

	public void setHorasPorDia(List<HorasPorDia> horasPorDia) {
		this.horasPorDia = horasPorDia;
	}
}
