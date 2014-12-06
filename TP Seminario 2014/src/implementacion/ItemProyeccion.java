package implementacion;

public class ItemProyeccion {
	private String sintomaAnalisis;
	private float porcentaje;
	
	public ItemProyeccion(String sintomaAnalisis, float porcentaje) {
		super();
		this.sintomaAnalisis = sintomaAnalisis;
		this.porcentaje = porcentaje;
	}
	public String getSintomaAnalisis() {
		return sintomaAnalisis;
	}
	public void setSintomaAnalisis(String sintomaAnalisis) {
		this.sintomaAnalisis = sintomaAnalisis;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
}
