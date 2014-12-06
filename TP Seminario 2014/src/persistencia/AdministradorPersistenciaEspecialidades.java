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
		Connection con = Conexion.connect();
		try{
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.Especialidades values(?,?)");
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
		Connection con = Conexion.connect();
		try{
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
		Connection con = Conexion.connect();
		Collection<Especialidad> especialidades = null;
		Especialidad esp = null;
		try{
			especialidades = new ArrayList<Especialidad>();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Especialidades WHERE matricula like ? AND activo=1");
			ps.setString(1, matricula);
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

	public void eliminarEspecialidades(Odontologo o) {
		// TODO Auto-generated method stub
		Connection con = Conexion.connect();
		try{
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Especialidades SET activo=0 WHERE matricula like ?");
			ps.setString(1, o.getMatricula());
			ps.execute();
			con.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
