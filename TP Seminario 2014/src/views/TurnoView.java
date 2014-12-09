package views;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;



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
	
	public String getDatos(){
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(fecha)+" - "+this.odontologo.getApellido()+", "+this.odontologo.getNombre()+" - "+this.paciente.getApellido()+", "+this.paciente.getNombre();
	}
}