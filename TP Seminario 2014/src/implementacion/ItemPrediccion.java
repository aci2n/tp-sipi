package implementacion;




public class ItemPrediccion {
	
	private String sintomaAnalisis;
	private float cantidad;
	
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
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
}
