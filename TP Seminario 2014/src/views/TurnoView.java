package views;

import java.sql.Timestamp;



public class TurnoView {
	private PacienteView paciente;
	private OdontologoView odontologo;
	private String descripcion;
	private Timestamp fecha;
	
	public PacienteView getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteView paciente) {
		this.paciente = paciente;
	}
	public OdontologoView getOdontologo() {
		return odontologo;
	}
	public void setOdontologo(OdontologoView odontologo) {
		this.odontologo = odontologo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
}