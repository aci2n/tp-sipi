package test;

import implementacion.Odontograma;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleTimestampFormat;

import views.ObservacionView;
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
		paciente.setFechaNacimiento(formarTimestampSQL("04/01/1994"));		
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

		//con.asignarFichaAHistoria(paciente.getDni(), odontologo.getMatricula());
		
		ObservacionView observacion = new ObservacionView();
		observacion.setDescripcion("El cliente se murio.");
		observacion.setFecha(getFechaActualSQL());
		observacion.setOdontologo(odontologo);
		
		con.altaObservacion(paciente.getDni(), observacion);
	}
	
	//UTILITARIAS
	
	private static java.sql.Timestamp getFechaActualSQL(){
		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Timestamp utilTimestamp = cal.getTime();
		return new Timestamp(utilTimestamp.getTime());
	}	
	
	private static java.sql.Timestamp formarTimestampSQL (String fecha){
		SimpleTimestampFormat format = new SimpleTimestampFormat("dd/mm/yyyy");
		try {
			return new Timestamp((format.parse(fecha)).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
