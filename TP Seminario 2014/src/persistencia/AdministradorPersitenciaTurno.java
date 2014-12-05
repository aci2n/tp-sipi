package persistencia;

import implementacion.Turno;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import controlador.Controlador;

public class AdministradorPersitenciaTurno extends AdministradorPersistencia {
	
	private static AdministradorPersitenciaTurno instancia = null;
	
	private AdministradorPersitenciaTurno(){
		
	}
	
	public static AdministradorPersitenciaTurno getInstancia(){
		if (instancia==null)
			instancia = new AdministradorPersitenciaTurno();
		return instancia;
	}

	public void insert(Object o) {
		Turno turno = (Turno)o;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.Turnos VALUES (?,?,?,?)");
			ps.setString(1, turno.getOdontologo().getMatricula());
			ps.setString(2,turno.getPaciente().getDni());
			ps.setDate(3, turno.getFecha());
			ps.setString(4, turno.getDescripcion());
			
			ps.execute();
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void update(Object o) {
		Turno turno = (Turno)o;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Turnos SET descripcion = ? WHERE matricula like ? AND paciente like ? AND fecha = ?");
			ps.setString(1, turno.getDescripcion());
			ps.setString(2, turno.getOdontologo().getMatricula());
			ps.setString(3, turno.getPaciente().getDni());
			ps.setDate(4,turno.getFecha());
			
			ps.execute();
			
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void delete(Object o) {
		Turno turno = (Turno)o;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("DELETE FROM "+super.getDatabase()+".dbo.Turnos WHERE matricula like ? AND paciente like ? AND fecha = ?");
			ps.setString(1, turno.getOdontologo().getMatricula());
			ps.setString(2, turno.getPaciente().getDni());
			ps.setDate(3,turno.getFecha());
			
			ps.execute();
			
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public Collection<Turno> buscarTurnos(){
		Collection<Turno> turnos = new ArrayList<Turno>(); 
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+"dbo.Turnos");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				Turno turno = new Turno();
				
				turno.setOdontologo(Controlador.getInstance().obtenerOdontologo(rs.getString("matricula")));
				turno.setPaciente(Controlador.getInstance().obtenerPaciente(rs.getString("paciente")));
				turno.setFecha(rs.getDate("fecha"));
				turno.setDescripcion(rs.getString("descripcion"));
				
				turnos.add(turno);
			}
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return turnos;
	}
	
	public Turno buscarTurno(String matricula, String dni, Date fecha){
		Turno turno = null;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+"dbo.Turnos WHERE matricula like ? AND dni like ? AND fecha = ?");
			ps.setString(1, matricula);
			ps.setString(2, dni);
			ps.setDate(3, fecha);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				turno = new Turno();
				
				turno.setOdontologo(Controlador.getInstance().obtenerOdontologo(rs.getString("matricula")));
				turno.setPaciente(Controlador.getInstance().obtenerPaciente(rs.getString("paciente")));
				turno.setFecha(rs.getDate("fecha"));
				turno.setDescripcion(rs.getString("descripcion"));
			}
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return turno;
	}
}
