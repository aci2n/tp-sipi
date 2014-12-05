package implementacion;

import java.util.Collection;



public class Prediccion {
	private Collection<String> sintomasOtros;
	private Collection<Float> porcentajes;
	
	public Prediccion(Collection<String> SintomasOtros, Collection<Float> Porcentajes) {
	
	}

	public Collection<String> getSintomasOtros() {
		return sintomasOtros;
	}

	public void setSintomasOtros(Collection<String> sintomasOtros) {
		this.sintomasOtros = sintomasOtros;
	}

	public Collection<Float> getPorcentajes() {
		return porcentajes;
	}

	public void setPorcentajes(Collection<Float> porcentajes) {
		this.porcentajes = porcentajes;
	}
	
	
}
