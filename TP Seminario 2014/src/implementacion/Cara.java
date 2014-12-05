package implementacion;



public class Cara {
	private int posicion;
	private String estado;
	
	public boolean sosLaCara(int posicionCara) {
		return this.posicion==posicionCara;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public int getPosicion() {
		return this.posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
