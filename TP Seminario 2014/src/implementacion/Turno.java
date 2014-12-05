package implementacion;

import java.sql.Date;



public class Turno {
	private Paciente paciente;
	private Odontologo odontologo;
	private String descripcion;
	private Date fecha;
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Odontologo getOdontologo() {
		return odontologo;
	}
	public void setOdontologo(Odontologo odontologo) {
		this.odontologo = odontologo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}