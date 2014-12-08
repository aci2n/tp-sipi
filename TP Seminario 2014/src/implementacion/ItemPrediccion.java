package implementacion;




public class ItemPrediccion {
	
	private String sintomaAnalisis;
	private int cantidad;
	
	public ItemPrediccion(String sintomaAnalisis) {
		this.sintomaAnalisis=sintomaAnalisis;
		this.cantidad=1;
	}
	public String getSintomaAnalisis() {
		return sintomaAnalisis;
	}
	public void setSintomaAnalisis(String sintomaAnalisis) {
		this.sintomaAnalisis = sintomaAnalisis;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
