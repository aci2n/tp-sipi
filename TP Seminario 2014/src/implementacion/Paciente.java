package implementacion;

import java.sql.Date;

import persistencia.AdministradorPersistenciaPaciente;
import views.PacienteView;


public class Paciente {
	private String dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private Date fechaNacimiento;
	private String genero;
	private String obraSocial;
	private String planObraSocial;
	
	public Paciente() {
	}
	
	public Paciente(String dni, String nombre, String apellido, String telefono, String email, Date fechaNacimiento, String genero, String obraSocial, String planObraSocial) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.obraSocial = obraSocial;
		this.planObraSocial = planObraSocial;
		AdministradorPersistenciaPaciente.getInstancia().insert(this);
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}
	public String getPlanObraSocial() {
		return planObraSocial;
	}
	public void setPlanObraSocial(String planObraSocial) {
		this.planObraSocial = planObraSocial;
	}
	public boolean sosElPaciente(String dni) {
		return this.dni.equals(dni);
	}
	
	public PacienteView generarView() {
		PacienteView view = new PacienteView();
		view.setNombre(nombre);
		view.setApellido(apellido);
		view.setDni(dni);
		view.setTelefono(telefono);
		view.setEmail(email);
		view.setFechaNacimiento(fechaNacimiento);
		view.setGenero(genero);
		view.setObraSocial(obraSocial);
		view.setPlanObraSocial(planObraSocial);
		return view;
	}
}
