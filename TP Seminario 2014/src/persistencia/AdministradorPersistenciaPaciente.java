package persistencia;

import implementacion.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class AdministradorPersistenciaPaciente extends AdministradorPersistencia {
	
	private static AdministradorPersistenciaPaciente instance;
	
	private AdministradorPersistenciaPaciente() {
		
	}
	
	public static AdministradorPersistenciaPaciente getInstancia() {
		if (instance == null)
			instance = new AdministradorPersistenciaPaciente();
		return instance;
	}

	public void insert(Paciente paciente) {	
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.Pacientes"
					+ "(dni, nombre, apellido, telefono, email, fecha_nac, genero, obra_social, plan_obra_social) VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, paciente.getDni());
			ps.setString(2, paciente.getNombre());
			ps.setString(3, paciente.getApellido());
			ps.setString(4, paciente.getTelefono());
			ps.setString(5, paciente.getEmail());
			ps.setTimestamp(6, paciente.getFechaNacimiento());
			ps.setString(7, paciente.getGenero());
			ps.setString(8, paciente.getObraSocial());
			ps.setString(9, paciente.getPlanObraSocial());
			
			ps.execute();
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void update(Paciente paciente) {
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Pacientes"
					+ " SET nombre = ?"
					+ ", apellido = ?"
					+ ", telefono = ?"
					+ ", email = ?"
					+ ", fecha_nac = ?"
					+ ", genero = ?"
					+ ", obra_social = ?"
					+ ", plan_obra_social = ?"
					+ " WHERE dni like ?");
			ps.setString(1, paciente.getNombre());
			ps.setString(2, paciente.getApellido());
			ps.setString(3, paciente.getTelefono());
			ps.setString(4, paciente.getEmail());
			ps.setTimestamp(5, paciente.getFechaNacimiento());
			ps.setString(6, paciente.getGenero());
			ps.setString(7, paciente.getObraSocial());
			ps.setString(8, paciente.getPlanObraSocial());
			ps.setString(9, paciente.getDni());
			
			ps.execute();
			
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void delete(Paciente paciente) {
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Pacientes SET activo = 0 WHERE dni like ?");
			ps.setString(1, paciente.getDni());		
			ps.execute();
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public Paciente buscarPaciente(String dni) {
		Paciente paciente = null;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Pacientes WHERE dni like ?");
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				paciente = new Paciente();
				
				paciente.setApellido(rs.getString("apellido"));
				paciente.setDni(rs.getString("dni"));
				paciente.setEmail(rs.getString("email"));
				paciente.setFechaNacimiento(rs.getTimestamp("fecha_nac"));
				paciente.setGenero(rs.getString("genero"));
				paciente.setNombre(rs.getString("nombre"));
				paciente.setObraSocial(rs.getString("obra_social"));
				paciente.setPlanObraSocial(rs.getString("plan_obra_social"));
				paciente.setTelefono(rs.getString("telefono"));
			}
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return paciente;
	}

	public Collection<Paciente> buscarPacientes() {
		Collection<Paciente> pacientes = new ArrayList<Paciente>();
		Paciente paciente = null;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Pacientes WHERE activo = 1");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				paciente = new Paciente();
				
				paciente.setApellido(rs.getString("apellido"));
				paciente.setDni(rs.getString("dni"));
				paciente.setEmail(rs.getString("email"));
				paciente.setFechaNacimiento(rs.getTimestamp("fecha_nac"));
				paciente.setGenero(rs.getString("genero"));
				paciente.setNombre(rs.getString("nombre"));
				paciente.setObraSocial(rs.getString("obra_social"));
				paciente.setPlanObraSocial(rs.getString("plan_obra_social"));
				paciente.setTelefono(rs.getString("telefono"));
				
				pacientes.add(paciente);
			}
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return pacientes;
	}

}
