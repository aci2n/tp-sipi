package test;

import implementacion.Odontograma;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import views.OdontologoView;
import views.PacienteView;
import controlador.Controlador;

public class Test3 {

	public static void main(String[] args) {
		Controlador con = Controlador.getInstancia();
		
		PacienteView paciente = new PacienteView();
		paciente.setApellido("Calace");
		paciente.setDni("testpaciente1");
		paciente.setEmail("alvarocalace@hotmail.com");	
		paciente.setFechaNacimiento(formarDateSQL("04/01/1994"));		
		paciente.setGenero("masculino");
		paciente.setNombre("Alvaro");
		paciente.setObraSocial("OSDE");
		paciente.setPlanObraSocial("OSDE Soy Diamond");
		paciente.setTelefono("43830700");
		
		con.altaPaciente(paciente);
		con.altaHistoriaClinica(paciente.getDni(), "alta tarta amigo");
				
		OdontologoView odontologo = new OdontologoView();
		
		odontologo.setApellido("Pauletti");
		odontologo.setMatricula("122-555566");
		odontologo.setNombre("Lalo");
		
		//con.altaOdontograma(paciente.getDni(), "test2", odontologo.getMatricula());
		
		Odontograma o = new Odontograma("test1", getFechaActualSQL(), con.obtenerOdontologo(odontologo.getMatricula()));
		
		//con.actualizarOdontograma(paciente.getDni(), o.generarView());

		con.asignarFichaAHistoria(paciente.getDni(), odontologo.getMatricula());
		
	}
	
	//UTILITARIAS
	
	private static java.sql.Date getFechaActualSQL(){
		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		return new Date(utilDate.getTime());
	}	
	
	private static java.sql.Date formarDateSQL (String fecha){
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		try {
			return new Date((format.parse(fecha)).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
