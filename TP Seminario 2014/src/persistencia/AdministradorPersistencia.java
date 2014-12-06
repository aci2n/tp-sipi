package persistencia;


public abstract class AdministradorPersistencia {
	private static String database = "tpseminario";
	
	public String getDatabase() {
		return AdministradorPersistencia.database;
	}
}
