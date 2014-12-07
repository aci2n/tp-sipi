package implementacion;

import views.EspecialidadView;



public class Especialidad {
	private String descripcion;

	public Especialidad(){
		
	}
	
	public Especialidad(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public boolean sosLaEspecialidad(String descripcion) {
		return this.descripcion.equalsIgnoreCase(descripcion);
	}
	
	public EspecialidadView generarView() {
		EspecialidadView view = new EspecialidadView();
		view.setDescripcion(descripcion);
		return view;
	}
}
