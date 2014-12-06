package implementacion;

import java.sql.Date;

import persistencia.AdministradorPersistenciaObservaciones;



public class Observacion {
	private Date fecha;
	private String descripcion;
	private Odontologo odontologo;
	
	public Observacion(Odontologo odontologo, Date fecha, String descripcion, HistoriaClinica historia) {
		this.fecha=fecha;
		this.descripcion=descripcion;
		this.odontologo=odontologo;
		AdministradorPersistenciaObservaciones.getInstancia().insert(this, historia);
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

	public boolean tenesElSintoma(String sintoma) {
		return descripcion.toLowerCase().contains(sintoma.toLowerCase());
	}	
}