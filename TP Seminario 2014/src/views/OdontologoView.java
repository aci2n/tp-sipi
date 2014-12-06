package views;

import java.util.Collection;



public class OdontologoView {
	private String matricula;
	private String nombre;
	private String apellido;
	private Collection<EspecialidadView> especialidades;
	
	public OdontologoView(String matricula, String nombre, String apellido, Collection<EspecialidadView> especialidades){
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidades = especialidades;
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

	public Collection<EspecialidadView> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Collection<EspecialidadView> especialidades) {
		this.especialidades = especialidades;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
