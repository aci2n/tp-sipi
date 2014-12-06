package implementacion;

public class Proyeccion {
	private String sintomaBase;
	private String sintomaAnalisis;
	private float porcentaje;
	
	
	public Proyeccion(String sintomaBase, String sintomaAnalisis,
			float porcentaje) {
		super();
		this.sintomaBase = sintomaBase;
		this.sintomaAnalisis = sintomaAnalisis;
		this.porcentaje = porcentaje;
	}
	
	public String getSintomaBase() {
		return sintomaBase;
	}
	public void setSintomaBase(String sintomaBase) {
		this.sintomaBase = sintomaBase;
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
