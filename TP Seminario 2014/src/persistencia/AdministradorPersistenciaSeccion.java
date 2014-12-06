package persistencia;

import implementacion.FichaPeriodontal;
import implementacion.Seccion;

public class AdministradorPersistenciaSeccion extends AdministradorPersistencia {
	private static AdministradorPersistenciaSeccion instance;
	
	public static AdministradorPersistenciaSeccion getInstance() {
		if (instance == null)
			instance = new AdministradorPersistenciaSeccion();
		return instance;
	}
	
	private AdministradorPersistenciaSeccion() {
	}
	
	public void insert(Seccion seccion, FichaPeriodontal ficha) {
		
	}
	
	public void update(Seccion seccion) {
		
	}
	
	public void delete(Seccion seccion) {
		
	}
	
	
}
