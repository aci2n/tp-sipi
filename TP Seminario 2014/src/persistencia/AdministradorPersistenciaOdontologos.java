package persistencia;

import implementacion.Especialidad;
import implementacion.Odontologo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	public void insert(Object o) {
		// TODO Auto-generated method stub
		Odontologo odon = (Odontologo)o;
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


	public void update(Object o) {
		// TODO Auto-generated method stub
		Odontologo odon = (Odontologo)o;
		try{	
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Odontologos SET nombre = ?, apellido = ? WHERE matricula like ?");
			ps.setString(1, odon.getNombre());
			ps.setString(2, odon.getApellido());
			ps.setString(3, odon.getMatricula());	
			PreparedStatement ps2 = con.prepareStatement("DELETE FROM "+super.getDatabase()+".dbo.Especialidades_Odontologos WHERE matricula like ?");
			ps2.setString(1, odon.getMatricula());
			PreparedStatement ps3;
			for (Especialidad e : odon.getEspecialidades())
				{
				ps3 = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.Especialidades_Odontologos VALUES (?, ?)");
				ps3.setString(1, odon.getMatricula());
				ps3.setString(2, e.getDescripcion());
				con.close();
				}
			}
			catch (SQLException e){
				e.printStackTrace();
			}
	}

	public void delete(Object o) {
		// TODO Auto-generated method stub
		Odontologo odon = (Odontologo)o;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("DELETE FROM "+super.getDatabase()+".dbo.Odontologos WHERE matricula like ?");
			ps.setString(1, odon.getMatricula());
			ps.execute();
			PreparedStatement ps2 = con.prepareStatement("DELETE FROM "+super.getDatabase()+".dbo.Especialidades_Odontologos WHERE matricula like ?");
			ps2.setString(1, odon.getMatricula());
			ps2.execute();
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
