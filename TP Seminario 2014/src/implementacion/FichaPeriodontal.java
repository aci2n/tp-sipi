package implementacion;

import java.util.Collection;

import persistencia.AdministradorPersistenciaSeccion;



public class FichaPeriodontal {
	private Paciente paciente;
	private Collection<Seccion> secciones;
	private Odontologo odontologo;
	
	public FichaPeriodontal() {
	
	}
	
	public void modificarSeccion(String seccion, String sDiente, boolean sangrado, boolean placa, int margen) {
	
	}
	
	public Seccion buscarSeccion(int seccion) {
		return null;
	}
	
	public Collection<String> getSintomas() {
		return null;
	}

	public Collection<Seccion> getSecciones() {
		return secciones;
	}

	public void setSecciones(Collection<Seccion> secciones) {
		this.secciones = secciones;
	}

	public Odontologo getOdontologo() {
		return odontologo;
	}

	public void setOdontologo(Odontologo odontologo) {
		this.odontologo = odontologo;
	}

	public Paciente getIdFicha() {
		return paciente;
	}

	public void setIdFicha(Paciente Paciente) {
		this.paciente = paciente;
	}	
	
	public void agregarSeccion(Seccion seccion) {
		this.secciones.add(seccion);
		AdministradorPersistenciaSeccion.getInstance().insert(seccion, this);
	}
}