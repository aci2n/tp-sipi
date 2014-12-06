package persistencia;

import implementacion.Diente;
import implementacion.HistoriaClinica;
import implementacion.Odontograma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdministradorPersistenciaOdontograma extends AdministradorPersistencia{
	
	private static AdministradorPersistenciaOdontograma instancia = null;
	
	private AdministradorPersistenciaOdontograma(){
		
	}
	
	public AdministradorPersistenciaOdontograma getInstancia(){
		if (instancia==null)
			instancia = new AdministradorPersistenciaOdontograma();
		return instancia;
	}

	public void insert(Odontograma odontograma, HistoriaClinica historia) {		
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO "+super.getDatabase()+".dbo.Odontogramas(id_historia_clinica, id_odontograma, fecha, matricula)");
			ps.setString(1, historia.getIdHistoria());
			ps.setString(2, odontograma.getIdOdontograma());
			ps.setDate(3, odontograma.getFecha());
			ps.setString(4, odontograma.getOdontologo().getMatricula());
			
			for (Diente diente : odontograma.getDientes()){
				AdministradorPersistenciaDiente.getInstancia().insert(diente,odontograma);
			}

			ps.execute();			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void update(Odontograma odontograma) {
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase()+".dbo.Odontogramas SET fecha = ?, matricula = ? WHERE id_odontograma like ?");
			ps.setDate(1, odontograma.getFecha());
			ps.setString(2, odontograma.getOdontologo().getMatricula());
			ps.setString(3, odontograma.getIdOdontograma());
			
			for (Diente diente : odontograma.getDientes()){
				AdministradorPersistenciaDiente.getInstancia().delete(diente, odontograma);
			}			
			for (Diente diente : odontograma.getDientes()){
				AdministradorPersistenciaDiente.getInstancia().insert(diente, odontograma);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void delete(Odontograma odontograma) {
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE "+super.getDatabase+"dbo.Odontogramas SET activo = 0 WHERE id_odontograma = ?");
			
		}
	}

}
