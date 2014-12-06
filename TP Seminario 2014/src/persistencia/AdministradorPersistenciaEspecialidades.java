package persistencia;

import implementacion.Especialidad;

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
	
	@Override
	public void insert(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub

	}

	public Collection<Especialidad> buscarEspecialidades(String matricula) {
		// TODO Auto-generated method stub
		Collection<Especialidad> especialidades = null;
		Especialidad esp = null;
		try{
			Connection con = Conexion.connect();
			especialidades = new ArrayList<Especialidad>();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Especialidades WHERE matricula like ?");
			ps.setString(1, matricula);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				esp = new Especialidad(rs.getString("descripcion"));
				especialidades.add(esp);
			}
		}catch (SQLException e){
				e.printStackTrace();
			}
			return especialidades;
	}

}
