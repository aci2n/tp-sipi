package implementacion;

import java.sql.Date;



public class Observacion {
	private Date fecha;
	private String descripcion;
	private Odontologo odontologo;
	
	public Observacion(Odontologo odontologo, Date fecha, String descripcion) {
	
	}

	public Observacion() {
		
	}

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

	public Odontologo getOdontologo() {
		return odontologo;
	}

	public void setOdontologo(Odontologo odontologo) {
		this.odontologo = odontologo;
	}	
}