package persistencia;

import implementacion.Especialidad;
import implementacion.Odontologo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class AdministradorPersistenciaOdontologos extends
		AdministradorPersistencia {

	
	private static AdministradorPersistenciaOdontologos instancia;
	
	private AdministradorPersistenciaOdontologos() {
		
	}
	
	public static AdministradorPersistenciaOdontologos getInstancia() {
		if (instancia == null) {
			instancia = new AdministradorPersistenciaOdontologos();
		}
		return instancia;
	}
	
	public void insert(Odontologo o) {
		// TODO Auto-generated method stub
		Odontologo odon = o;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.Odontologos VALUES (?,?,?)");
			ps.setString(1, odon.getMatricula());
			ps.setString(2, odon.getNombre());
			ps.setString(3, odon.getApellido());
			ps.execute();
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}


	public void update(Odontologo o) {
		// TODO Auto-generated method stub
		try{	
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Odontologos SET nombre = ?, apellido = ? WHERE matricula like ?");
			ps.setString(1, o.getNombre());
			ps.setString(2, o.getApellido());
			ps.setString(3, o.getMatricula());	
			AdministradorPersistenciaEspecialidades.getInstancia().eliminarEspecialidades(o);
			for (Especialidad esp : o.getEspecialidades())
				{
				AdministradorPersistenciaEspecialidades.getInstancia().insert(esp, o);
				}
			con.close();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
	}

	public void delete(Odontologo o) {
		// TODO Auto-generated method stub
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Odontologos SET activo = 0 WHERE matricula like ?");
			ps.setString(1, o.getMatricula());
			ps.execute();
			AdministradorPersistenciaEspecialidades.getInstancia().eliminarEspecialidades(o);
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public Odontologo buscarOdontologo(String matricula){
		Odontologo odon = null;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Odontologos WHERE matricula like ?");
			ps.setString(1, matricula);
			ResultSet rs = ps.executeQuery();
			odon = new Odontologo(rs.getString("matricula"), rs.getString("nombre"), rs.getString("apellido"), AdministradorPersistenciaEspecialidades.getInstancia().buscarEspecialidades(matricula));
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return odon;
	}
	
	public Collection<Odontologo> buscarOdontologos(){
		Collection<Odontologo> odontologos = new ArrayList<Odontologo>(); 
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Odontologos");
			Odontologo odon;
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				odon = new Odontologo(rs.getString("matricula"), rs.getString("nombre"), rs.getString("apellido"), AdministradorPersistenciaEspecialidades.getInstancia().buscarEspecialidades(rs.getString("matricula")));
				odontologos.add(odon);
			}
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return odontologos;
	}

}
