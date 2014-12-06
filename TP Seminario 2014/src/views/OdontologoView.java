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

	public String getApellido() {
		return apellido;
	}

	public Collection<EspecialidadView> getEspecialidades() {
		return especialidades;
	}



}
