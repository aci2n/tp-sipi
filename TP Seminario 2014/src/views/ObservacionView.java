package views;

import java.sql.Date;



public class ObservacionView {
	private Date fecha;
	private String descripcion;
	private OdontologoView odontologo;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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