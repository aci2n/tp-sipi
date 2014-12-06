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

		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.Odontologos VALUES (?,?,?)");
			ps.setString(1, o.getMatricula());
			ps.setString(2, o.getNombre());
			ps.setString(3, o.getApellido());
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
		Odontologo odon = new Odontologo();
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Odontologos WHERE matricula like ? AND activo=1");
			ps.setString(1, matricula);
			ResultSet rs = ps.executeQuery();
			odon.setMatricula(rs.getString("matricula"));
			odon.setApellido(rs.getString("apellido"));
			odon.setNombre(rs.getString("nombre"));
			odon.setEspecialidades(AdministradorPersistenciaEspecialidades.getInstancia().buscarEspecialidades(matricula));
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
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Odontologos WHERE activo=1");
			Odontologo odon;
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				odon = new Odontologo();
				odon.setMatricula(rs.getString("matricula"));
				odon.setNombre(rs.getString("nombre"));
				odon.setApellido(rs.getString("apellido"));
				odon.setEspecialidades(AdministradorPersistenciaEspecialidades.getInstancia().buscarEspecialidades(rs.getString("matricula")));
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
