package implementacion;

import views.CaraView;



public class Cara {
	private String posicion;
	private String estado;
	
	public boolean sosLaCara(String posicionCara) {
		return this.posicion==posicionCara;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public String getPosicion() {
		return this.posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public CaraView generarView() {
		CaraView view = new CaraView();
		view.setEstado(estado);
		view.setPosicion(posicion);
		return view;
	}
}
