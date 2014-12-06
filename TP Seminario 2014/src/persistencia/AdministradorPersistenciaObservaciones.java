package persistencia;

import implementacion.HistoriaClinica;
import implementacion.Observacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import controlador.Controlador;

public class AdministradorPersistenciaObservaciones extends
		AdministradorPersistencia {
	private static AdministradorPersistenciaObservaciones instancia;
	
	private AdministradorPersistenciaObservaciones(){
		
	}
	
	public static AdministradorPersistenciaObservaciones getInstancia(){
		if (instancia==null)
			instancia = new AdministradorPersistenciaObservaciones();
		return instancia;
	}
	
	public void insert (Observacion observacion, HistoriaClinica historia){
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.Observaciones(dni, matricula, fecha, descripcion) VALUES (?,?,?,?)");
			ps.setString(1,historia.getPaciente().getDni());
			ps.setString(2, observacion.getOdontologo().getMatricula());
			ps.setDate(3, observacion.getFecha());
			ps.setString(4, observacion.getDescripcion());
			
			ps.execute();
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void update (Observacion observacion, HistoriaClinica historia){
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Observaciones SET descripcion = ?, odontologo = ? WHERE dni = ? AND fecha = ?");
			ps.setString(1, observacion.getDescripcion());
			ps.setString(2, observacion.getOdontologo().getMatricula());
			ps.setString(3, historia.getPaciente().getDni());
			ps.setDate(4, observacion.getFecha());
			
			ps.execute();
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void delete (Observacion observacion, HistoriaClinica historia){
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Observaciones SET activo = 0 WHERE dni = ? AND fecha = ?");
			ps.setString(1, historia.getPaciente().getDni());
			ps.setDate(2, observacion.getFecha());
			
			ps.execute();
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public Collection<Observacion> buscarObservaciones(HistoriaClinica historia){
		Collection<Observacion> observaciones = new ArrayList<Observacion>();
		Observacion observacion;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Observaciones WHERE dni like ?");
			ps.setString(1, historia.getPaciente().getDni());
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				observacion = new Observacion();
				
				observacion.setOdontologo(Controlador.getInstancia().obtenerOdontologo(rs.getString("matricula")));
				observacion.setDescripcion(rs.getString("descripcion"));
				observacion.setFecha(rs.getDate("fecha"));
				
				observaciones.add(observacion);
			}
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return observaciones;
	}
}
