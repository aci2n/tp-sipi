package implementacion;

import java.util.Collection;



public class Odontologo {
	private String matricula;
	private String nombre;
	private String apellido;
	private Collection<Especialidad> especialidades;
	
	public Odontologo(String matricula, String nombre, String apellido){
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
	}
		
	public boolean sosElOdontologo(String matricula) {
		return this.matricula.equals(matricula);
	}
	
	public String getMatricula() {
		return this.matricula;
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

	public Collection<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Collection<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
