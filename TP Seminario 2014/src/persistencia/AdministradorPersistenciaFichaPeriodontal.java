package persistencia;

import implementacion.FichaPeriodontal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdministradorPersistenciaFichaPeriodontal extends AdministradorPersistencia {
	private static AdministradorPersistenciaFichaPeriodontal instance;
	
	private AdministradorPersistenciaFichaPeriodontal() {
	}
	
	public static AdministradorPersistenciaFichaPeriodontal getInstancia() {
		if (instance == null)
			instance = new AdministradorPersistenciaFichaPeriodontal();
		return instance;
	}
	
	public void insert(FichaPeriodontal ficha) {
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.FichasPeriodontales VALUES (?,?)");
			ps.setString(1, ficha.getIdFicha());
			ps.setString(2, ficha.getOdontologo().getMatricula());
			
			ps.execute();
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void update(FichaPeriodontal ficha) {
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.FichasPeriodontales SET matricula = ? WHERE id_ficha like ?");
			ps.setString(1, ficha.getOdontologo().getMatricula());
			ps.setString(2, ficha.getIdFicha());
			
			ps.execute();
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}

}
