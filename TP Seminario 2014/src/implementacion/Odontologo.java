package implementacion;

import java.util.ArrayList;
import java.util.Collection;

import persistencia.AdministradorPersistenciaEspecialidades;
import persistencia.AdministradorPersistenciaOdontologos;



public class Odontologo {
	private String matricula;
	private String nombre;
	private String apellido;
	private Collection<Especialidad> especialidades;
	
	public Odontologo(String matricula, String nombre, String apellido, Collection<Especialidad> especialidades){
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		if (especialidades != null) {
			this.especialidades = especialidades;
		} else {
			this.especialidades = new ArrayList<Especialidad>();
		}
		AdministradorPersistenciaOdontologos.getInstancia().insert(this);
	}
	
	public Odontologo() {
		
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
	
	public void agregarEspecialidad(String descripcion) {
		if (especialidades == null) {
			especialidades = new ArrayList<Especialidad>();
		}
		Especialidad especialidad = new Especialidad();
		especialidad.setDescripcion(descripcion);
		if (!especialidades.contains(especialidad)) {
			especialidades.add(especialidad);
			AdministradorPersistenciaEspecialidades.getInstancia().insert(especialidad, this);
		}
	}

}
