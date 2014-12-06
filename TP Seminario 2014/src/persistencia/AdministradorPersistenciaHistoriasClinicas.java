package persistencia;

import implementacion.HistoriaClinica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import controlador.Controlador;

public class AdministradorPersistenciaHistoriasClinicas extends AdministradorPersistencia{
	
	private static AdministradorPersistenciaHistoriasClinicas instancia = null;
	
	private AdministradorPersistenciaHistoriasClinicas(){
		
	}
	
	public static AdministradorPersistenciaHistoriasClinicas getInstancia(){
		if (instancia==null)
			instancia = new AdministradorPersistenciaHistoriasClinicas();
		return instancia;
	}

	public void insert(Object o) {
		HistoriaClinica historia = (HistoriaClinica)o;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.HistoriasClinicas(id_historia_clinica, dni, descripcion, id_ficha, activo) VALUES (?,?,?,?,1)");
			ps.setString(1, historia.getIdHistoria());
			ps.setString(2,historia.getPaciente().getDni());
			ps.setString(3, historia.getDescripcion());
			ps.setString(4, historia.getFicha().getIdFicha());
			
			ps.execute();
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void update(Object o) {
		HistoriaClinica historia = (HistoriaClinica)o;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.HistoriasClinicas SET descripcion = ? WHERE id_historia_clinica like ?");
			ps.setString(1, historia.getDescripcion());
			ps.setString(2, historia.getIdHistoria());
			
			ps.execute();
			
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void delete(Object o) {
		HistoriaClinica historia = (HistoriaClinica)o;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("DELETE FROM "+super.getDatabase()+".dbo.HistoriasClinicas WHERE id_historia_clinica like ?");
			ps.setString(1, historia.getIdHistoria());
			
			ps.execute();
			
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public Collection<HistoriaClinica> buscarHistorias(){
		Collection<HistoriaClinica> historias = new ArrayList<HistoriaClinica>(); 
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+"dbo.HistoriasClinicas WHERE activo = 1");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				HistoriaClinica historia = new HistoriaClinica();
				
				historia.setIdHistoria(rs.getString("id_historia_clinica"));
				historia.setPaciente(Controlador.getInstancia().obtenerPaciente(rs.getString("dni")));
				historia.setDescripcion(rs.getString("descripcion"));
				historia.setFicha(Controlador.getInstancia().obtenerFicha(rs.getString("id_ficha")));
				
				historias.add(historia);
			}
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return historias;
	}
	
	public HistoriaClinica buscarHistoria(String idHistoria){
		HistoriaClinica historia = null;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+"dbo.HistoriasClinicas WHERE id_historia_clinica like ?");
			ps.setString(1, idHistoria);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				historia = new HistoriaClinica();
				
				historia.setIdHistoria(rs.getString("id_historia_clinica"));
				historia.setPaciente(Controlador.getInstancia().obtenerPaciente(rs.getString("dni")));
				historia.setDescripcion(rs.getString("descripcion"));
				historia.setFicha(Controlador.getInstancia().obtenerFicha(rs.getString("id_ficha")));
				
			}
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return historia;
	}
}
