package implementacion;

import java.sql.Timestamp;

import views.ObservacionView;



public class Observacion {
	private Timestamp fecha;
	private String descripcion;
	private Odontologo odontologo;
	
	public Observacion(Odontologo odontologo, Timestamp fecha, String descripcion) {
		this.fecha=fecha;
		this.descripcion=descripcion;
		this.odontologo=odontologo;
	}

	public Observacion() {
		
	}


	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Odontologo getOdontologo() {
		return odontologo;
	}

	public void setOdontologo(Odontologo odontologo) {
		this.odontologo = odontologo;
	}

	public boolean tenesElSintoma(String sintoma) {
		return descripcion.toLowerCase().contains(sintoma.toLowerCase());
	}	
	
	public ObservacionView generarView() {
		ObservacionView view = new ObservacionView();
		view.setDescripcion(descripcion);
		view.setFecha(fecha);
		view.setOdontologo(odontologo.generarView());
		return view;
	}
}