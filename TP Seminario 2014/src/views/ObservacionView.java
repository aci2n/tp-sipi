package views;

import java.sql.Timestamp;



public class ObservacionView {
	private Timestamp fecha;
	private String descripcion;
	private OdontologoView odontologo;

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

	public OdontologoView getOdontologo() {
		return odontologo;
	}

	public void setOdontologo(OdontologoView odontologo) {
		this.odontologo = odontologo;
	}	
}