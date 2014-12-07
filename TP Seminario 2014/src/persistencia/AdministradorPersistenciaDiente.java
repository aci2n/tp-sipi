package persistencia;

import implementacion.Cara;
import implementacion.Diente;
import implementacion.Odontograma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class AdministradorPersistenciaDiente extends AdministradorPersistencia {
	private static AdministradorPersistenciaDiente instancia = null;
	
	private AdministradorPersistenciaDiente(){
		
	}
	
	public static AdministradorPersistenciaDiente getInstancia(){
		if (instancia==null)
			instancia = new AdministradorPersistenciaDiente();
		return instancia;
	}
	
	public void insert (Diente diente, Odontograma odontograma){
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.Dientes(posicion_diente, id_odontograma, estado_diente, id_puente, id_protesis) VALUES (?,?,?,?,?)");
			ps.setString(1, diente.getPosicion());
			ps.setString(2, odontograma.getIdOdontograma());
			ps.setString(3, diente.getEstado());
			ps.setString(4, diente.getIdPuente());
			ps.setString(5, diente.getIdProtesis());
			
			ps.execute();
			
			for (Cara cara : diente.getCaras())
				AdministradorPersistenciaCaras.getInstancia().insert(cara, diente, odontograma);
			
			con.close();
			 
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void delete (Diente diente, Odontograma odontograma){
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Dientes SET activo = 0 WHERE id_odontograma = ? AND posicion_diente = ?");
			ps.setString(1, odontograma.getIdOdontograma());
			ps.setString(2, diente.getPosicion());
			
			for (Cara cara : diente.getCaras())
				AdministradorPersistenciaCaras.getInstancia().delete(cara, diente, odontograma);
			
			for (Cara cara : diente.getCaras())
				AdministradorPersistenciaCaras.getInstancia().insert(cara, diente, odontograma);
			
			ps.execute();
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public Collection<Diente> buscarDientes(Odontograma odontograma) {
		Collection<Diente> dientes = new ArrayList<Diente>();
		Diente diente = null;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Dientes WHERE id_odontograma = ? AND activo = 1");
			ps.setString(1, odontograma.getIdOdontograma());
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				diente = new Diente();
				
				diente.setEstado(rs.getString("estado_diente"));
				diente.setIdProtesis(rs.getString("id_protesis"));
				diente.setIdPuente(rs.getString("id_puente"));
				diente.setPosicion(rs.getString("posicion_diente"));
				diente.setCaras(AdministradorPersistenciaCaras.getInstancia().buscarCaras(odontograma, diente));
				
				dientes.add(diente);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return dientes;
	}
}
