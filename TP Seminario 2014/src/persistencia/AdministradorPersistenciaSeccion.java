package persistencia;

import implementacion.FichaPeriodontal;
import implementacion.Seccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

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
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.Secciones(dni, posicion_diente, posicion_seccion, sangrado, profundidad, placa, margen) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, ficha.getPaciente().getDni());
			ps.setString(2, seccion.getPosicionDiente());
			ps.setString(3, seccion.getPosicionSeccion());
			ps.setBoolean(4, seccion.isSangrado());
			ps.setInt(5, seccion.getProfundidad());
			ps.setBoolean(6, seccion.isPlaca());
			ps.setInt(7, seccion.getMargen());
			
			ps.execute();
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void update(Seccion seccion, FichaPeriodontal ficha) {
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Secciones SET sangrado = ?, margen = ?, profundidad = ?, placa = ? WHERE dni = ? AND posicion_diente = ? AND posicion_seccion = ?");
			ps.setBoolean(1, seccion.isSangrado());
			ps.setInt(2, seccion.getMargen());
			ps.setInt(3, seccion.getProfundidad());
			ps.setBoolean(4, seccion.isPlaca());
			ps.setString(5, ficha.getPaciente().getDni());
			ps.setString(6, seccion.getPosicionDiente());
			ps.setString(7, seccion.getPosicionSeccion());
			
			ps.execute();
			
			con.close();			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void delete(Seccion seccion, FichaPeriodontal ficha) {
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Secciones SET activo = 0 WHERE dni = ? AND posicion_diente = ? AND posicion_seccion = ?");
			ps.setString(1, ficha.getPaciente().getDni());
			ps.setString(2, seccion.getPosicionDiente());
			ps.setString(3, seccion.getPosicionSeccion());
			
			ps.execute();
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public Collection<Seccion> buscarSecciones (FichaPeriodontal ficha){
		Collection<Seccion> secciones = new ArrayList<Seccion>();
		Seccion seccion;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Secciones WHERE dni like ?");
			ps.setString(1,ficha.getPaciente().getDni());
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				seccion = new Seccion();
				
				seccion.setMargen(rs.getInt("margen"));
				seccion.setPlaca(rs.getBoolean("placa"));
				seccion.setPosicionDiente(rs.getString("posicion_diente"));
				seccion.setPosicionSeccion(rs.getString("posicion_seccion"));
				seccion.setSangrado(rs.getBoolean("sangrado"));
				seccion.setProfundidad(rs.getInt("profundidad"));
				
				secciones.add(seccion);
			}
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return secciones;
	}
}
