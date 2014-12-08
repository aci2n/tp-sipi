package views;



public class CaraView {
	private String posicion;
	private String estado;
	
	
	public CaraView(){
		
	}
	
	public CaraView(String pos, String estado){
		
		this.posicion = pos;
		this.estado = estado;
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
}
