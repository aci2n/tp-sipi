package implementacion;

import views.ItemPrediccionView;


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
	
	public ItemPrediccionView generarView() {
		ItemPrediccionView view = new ItemPrediccionView();
		view.setCantidad(cantidad);
		view.setSintomaAnalisis(sintomaAnalisis);
		return view;
	}
}
