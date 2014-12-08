package implementacion;

import java.util.ArrayList;
import java.util.Collection;

public class Estadistica {
	private Collection<String> sintomasBase;
	private Collection<EstadisticaHistoriaClinica> estadisticasPaciente;
	
	public Estadistica() {
		sintomasBase = new ArrayList<String>();
		estadisticasPaciente = new ArrayList<EstadisticaHistoriaClinica>();
	}
	
	public Collection<String> getSintomasBase() {
		return sintomasBase;
	}
	public void setSintomasBase(Collection<String> sintomasBase) {
		this.sintomasBase = sintomasBase;
	}
	public Collection<EstadisticaHistoriaClinica> getEstadisticasPaciente() {
		return estadisticasPaciente;
	}
	public void setEstadisticasPaciente(
			Collection<EstadisticaHistoriaClinica> estadisticasPaciente) {
		this.estadisticasPaciente = estadisticasPaciente;
	}
	public void agregarEstadisticaHistoriaClinica(EstadisticaHistoriaClinica estadisticaHistoria) {
		this.estadisticasPaciente.add(estadisticaHistoria);
	}
}
