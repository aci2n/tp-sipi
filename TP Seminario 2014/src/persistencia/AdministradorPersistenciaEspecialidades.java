package persistencia;

import implementacion.Especialidad;
import implementacion.Odontologo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class AdministradorPersistenciaEspecialidades extends
		AdministradorPersistencia {

	private static AdministradorPersistenciaEspecialidades instance;
	
	public static AdministradorPersistenciaEspecialidades getInstancia() {
		if (instance == null)
			instance = new AdministradorPersistenciaEspecialidades();
		return instance;
	}
	
	public void insert(Especialidad esp, Odontologo odon) {
		// TODO Auto-generated method stub
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.Especialidades_Odontologos(matricula, nombre_especialidad) values(?,?)");
			ps.setString(1, odon.getMatricula());
			ps.setString(2,esp.getDescripcion());
			ps.execute();
			con.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}


	public void delete(Especialidad esp, Odontologo odon) {
		// TODO Auto-generated method stub
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Especialidades SET activo=0 WHERE matricula like ? AND descripcion like ?");
			ps.setString(1, odon.getMatricula());
			ps.setString(2, esp.getDescripcion());
			ps.execute();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public Collection<Especialidad> buscarEspecialidades(String matricula) {
		// TODO Auto-generated method stub
		Collection<Especialidad> especialidades = new ArrayList<Especialidad>();
		Especialidad esp;
		try{
			Connection con = Conexion.connect();
			StringBuilder statement = new StringBuilder("SELECT * FROM "+super.getDatabase()+".dbo.Especialidades WHERE activo = 1");
			if (matricula != null) {
				statement.append(" AND matricula like ?");
			}
			PreparedStatement ps = con.prepareStatement(statement.toString());
			if (matricula != null) {
				ps.setString(1, matricula);
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				esp = new Especialidad();
				esp.setDescripcion(rs.getString("descripcion"));
				especialidades.add(esp);
			}
		}catch (SQLException e){
				e.printStackTrace();
			}
			return especialidades;
	}
	
	public Especialidad buscarEspecialidad(String descripcion) {
		Especialidad especialidad = null;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Especialidades WHERE nombre_especialidad like ? AND activo = 1");
			ps.setString(1, descripcion);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				especialidad = new Especialidad();
				especialidad.setDescripcion(rs.getString(2));
			}
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return especialidad;
	}

	public void eliminarEspecialidades(Odontologo o) {
		// TODO Auto-generated method stub
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Especialidades SET activo=0 WHERE matricula like ?");
			ps.setString(1, o.getMatricula());
			ps.execute();
			con.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
