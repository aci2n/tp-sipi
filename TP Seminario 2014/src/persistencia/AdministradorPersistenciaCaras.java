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

public class AdministradorPersistenciaCaras extends AdministradorPersistencia {
	private static AdministradorPersistenciaCaras instancia;
	
	private AdministradorPersistenciaCaras(){
		
	}
	
	public static AdministradorPersistenciaCaras getInstancia(){
		if (instancia == null)
			instancia = new AdministradorPersistenciaCaras();
		return instancia;
	}
	
	public void insert (Cara cara, Diente diente, Odontograma odontograma){
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.Caras (posicion_cara, posicion_diente, id_odontograma, estado_cara) VALUES (?,?,?,?)");
			ps.setString(1,cara.getPosicion());
			ps.setString(2,diente.getPosicion());
			ps.setString(3,odontograma.getIdOdontograma());
			ps.setString(4,cara.getEstado());
			
			ps.execute();
			
			con.close();			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void delete(Cara cara, Diente diente, Odontograma odontograma) {
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Caras SET activo = 0 WHERE id_odontograma = ? AND posicion_diente = ? AND posicion_cara = ?");
			ps.setString(1, odontograma.getIdOdontograma());
			ps.setString(2, diente.getPosicion());
			ps.setString(3, cara.getPosicion());
			
			ps.execute();
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public Collection<Cara> buscarCaras(Odontograma odontograma, Diente diente){
		Collection<Cara> caras = new ArrayList<Cara>();
		Cara cara;
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Caras WHERE activo = 1 AND id_odontograma = ? AND posicion_diente = ?");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				cara = new Cara();
				
				cara.setEstado(rs.getString("estado_cara"));
				cara.setPosicion(rs.getString("posicion_cara"));
				
				caras.add(cara);
			}
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return caras;
	}
}
