package implementacion;

import views.CaraView;

public class Cara {
	public final static String posicion1 = "Vestibular";
	public final static String posicion2 = "Mesial";
	public final static String posicion3 = "Oclusal";
	public final static String posicion4 = "Lingual";
	public final static String posicion5 = "Distal";
	private String posicion;
	private String estado;
	
	public Cara(String posicion){
		this.posicion=posicion;
	}
	
	public Cara() {
	}

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