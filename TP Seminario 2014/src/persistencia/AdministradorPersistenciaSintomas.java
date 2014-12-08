package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class AdministradorPersistenciaSintomas extends AdministradorPersistencia{
	
	private static AdministradorPersistenciaSintomas instancia;

	private AdministradorPersistenciaSintomas() {
		
	}
	
	public static AdministradorPersistenciaSintomas getInstancia(){
		if (instancia == null)
			instancia = new AdministradorPersistenciaSintomas();
		return instancia;
	}

	public void insert(String sintoma) {
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.Sintomas(nombre) VALUES (?)");
			ps.setString(1, sintoma);
			
			ps.execute();
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public Collection<String> buscarSintomas(){
		Collection<String> sintomas = new ArrayList<String>();
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Sintomas WHERE activo = 1");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				sintomas.add(rs.getString("nombre"));
			}
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return sintomas;
	}
	
}
