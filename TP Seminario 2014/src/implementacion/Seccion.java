package implementacion;

import java.util.Collection;

import views.SeccionView;



public class Seccion {
	private boolean sangrado;
	private boolean placa;
	private int margen;
	private int profundidad;
	private String posicionSeccion;
	private String posicionDiente;
	
	public Seccion(String posicionDiente, String posicionSeccion) {
		this.posicionDiente=posicionDiente;
		this.posicionSeccion=posicionSeccion;
	}

	public Seccion() {
	}

	public boolean sosLaSeccion(String posicionSeccion, String posicionDiente) {
		return this.posicionDiente.equals(posicionSeccion) && this.posicionDiente.equals(posicionDiente);
	}
	
	public Collection<String> getSintomas() {
		return null;
	}

	public boolean isSangrado() {
		return sangrado;
	}

	public void setSangrado(boolean sangrado) {
		this.sangrado = sangrado;
	}

	public boolean isPlaca() {
		return placa;
	}

	public void setPlaca(boolean placa) {
		this.placa = placa;
	}

	public int getMargen() {
		return margen;
	}

	public void setMargen(int margen) {
		this.margen = margen;
	}

	public int getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}

	public String getPosicionSeccion() {
		return posicionSeccion;
	}

	public void setPosicionSeccion(String posicionSeccion) {
		this.posicionSeccion = posicionSeccion;
	}

	public String getPosicionDiente() {
		return posicionDiente;
	}

	public void setPosicionDiente(String posicionDiente) {
		this.posicionDiente = posicionDiente;
	}
	
	public SeccionView generarView() {
		SeccionView view = new SeccionView();
		view.setMargen(margen);
		view.setPlaca(placa);
		view.setPosicionDiente(posicionDiente);
		view.setPosicionSeccion(posicionSeccion);
		view.setProfundidad(profundidad);
		view.setSangrado(sangrado);
		return view;
	}

	public Observacion generarObservacion() {
		Observacion observacion = new Observacion();
		observacion.setFecha(null);
		StringBuilder sintomas = new StringBuilder();
		if (sangrado)
			sintomas.append("sangrado ");
		if (placa)
			sintomas.append("placa ");
		String descripcion = sintomas.toString();
		if (!descripcion.equals(""))
			observacion.setDescripcion(descripcion);
		else
			observacion.setDescripcion(null);
		observacion.setOdontologo(null);
		return observacion;
	}

}