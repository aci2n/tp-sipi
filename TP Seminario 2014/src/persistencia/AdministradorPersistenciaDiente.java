package persistencia;

import implementacion.Diente;
import implementacion.Odontograma;

public class AdministradorPersistenciaDiente extends AdministradorPersistencia {
	private static AdministradorPersistenciaDiente instancia = null;
	
	private AdministradorPersistenciaDiente(){
		
	}
	
	public static AdministradorPersistenciaDiente getInstancia(){
		if (instancia==null)
			instancia = new AdministradorPersistenciaDiente();
		return instancia;
	}
	
	public void insert (Diente diente, Odontograma odontograma){
		
	}
	
	public void delete (Diente diente, Odontograma odontograma){
		
	}
}
