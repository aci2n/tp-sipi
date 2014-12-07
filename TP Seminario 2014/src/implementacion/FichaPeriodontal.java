package implementacion;

import java.util.ArrayList;
import java.util.Collection;

import persistencia.AdministradorPersistenciaSeccion;
import views.FichaPeriodontalView;
import views.SeccionView;



public class FichaPeriodontal {
	private Paciente paciente;
	private Collection<Seccion> secciones;
	private Odontologo odontologo;
	
	public FichaPeriodontal() {
	}
	
	public void modificarSeccion(String posicionSeccion, String posicionDiente, boolean sangrado, boolean placa, int margen) {
		Seccion seccion = buscarSeccion(posicionSeccion, posicionDiente);
		if (seccion != null) {
			seccion.setSangrado(sangrado);
			seccion.setPlaca(placa);
			seccion.setMargen(margen);
			AdministradorPersistenciaSeccion.getInstance().update(seccion, this);
		}
	}
	
	public Seccion buscarSeccion(String posicionSeccion, String posicionDiente) {
		for (Seccion seccion : secciones) {
			if (seccion.sosLaSeccion(posicionSeccion, posicionDiente)) {
				return seccion;
			}
		}
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
 
	public void agregarSeccion(Seccion seccion) {
		this.secciones.add(seccion);
		AdministradorPersistenciaSeccion.getInstance().insert(seccion, this);
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public FichaPeriodontalView generarView() {
		FichaPeriodontalView view = new FichaPeriodontalView();
		Collection<SeccionView> seccionesView = new ArrayList<SeccionView>();
		for (Seccion seccion : secciones) {
			seccionesView.add(seccion.generarView());
		}
		view.setSecciones(seccionesView);
		view.setOdontologo(odontologo.generarView());
		view.setPaciente(paciente.generarView());
		return view;
	}
}