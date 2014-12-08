package views;

import java.util.Collection;



public class SeccionView {
	private boolean sangrado;
	private boolean placa;
	private int margen;
	private int profundidad;
	private String posicionSeccion;
	private String posicionDiente;
	
	public SeccionView(){
		
	}
	
	public SeccionView(boolean sangrado, boolean placa, int margen, int profundidad, String posSeccion, String posDiente){
		
		this.sangrado = sangrado;
		this.placa = placa;
		this.margen = margen;
		this.profundidad = profundidad;
		this.posicionSeccion = posSeccion;
		this.posicionDiente = posDiente;
		
	}
	
	public boolean sosLaSeccion(String seccion, String sDiente) {
		return this.posicionDiente.equals(seccion) && this.posicionDiente.equals(sDiente);
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

}