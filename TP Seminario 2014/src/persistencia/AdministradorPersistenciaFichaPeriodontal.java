package persistencia;

import implementacion.FichaPeriodontal;
import implementacion.Seccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Controlador;

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
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.FichasPeriodontales(matricula, dni) VALUES (?,?)");
			ps.setString(1, ficha.getOdontologo().getMatricula());
			ps.setString(2, ficha.getPaciente().getDni());
			
			ps.execute();
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void update(FichaPeriodontal ficha) {
		/*try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.FichasPeriodontales SET matricula = ? WHERE id_ficha like ?");
			ps.setString(1, ficha.getOdontologo().getMatricula());
			ps.setString(2, ficha.getIdFicha());
			
			ps.execute();
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}*/
	}

	public void delete(FichaPeriodontal ficha) {
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.FichasPeriodontales SET activo = 0 WHERE dni = ? AND matricula = ?");
			ps.setString(1, ficha.getPaciente().getDni());
			ps.setString(2, ficha.getOdontologo().getMatricula());
			
			for (Seccion seccion : ficha.getSecciones())
				AdministradorPersistenciaSeccion.getInstance().delete(seccion, ficha);
			
			for (Seccion seccion : ficha.getSecciones())
				AdministradorPersistenciaSeccion.getInstance().insert(seccion, ficha);
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public FichaPeriodontal buscarFicha(String dni){
		FichaPeriodontal ficha =  null;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.FichasPeriodontales WHERE dni like ?");
			ps.setString(1, dni);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				ficha = new FichaPeriodontal();
				
				ficha.setOdontologo(Controlador.getInstancia().obtenerOdontologo(rs.getString("matricula")));
				ficha.setPaciente(Controlador.getInstancia().obtenerPaciente(rs.getString("dni")));
				ficha.setSecciones(AdministradorPersistenciaSeccion.getInstance().buscarSecciones(ficha));
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return ficha;		
	}
}
