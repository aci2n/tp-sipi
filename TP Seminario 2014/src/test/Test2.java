package test;

import implementacion.Especialidad;
import implementacion.HistoriaClinica;
import implementacion.Odontologo;
import implementacion.Paciente;
import implementacion.Turno;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import persistencia.AdministradorPersistenciaHistoriasClinicas;
import persistencia.AdministradorPersistenciaPaciente;

public class Test2 {

	public static void main(String[] args) {
		try{
			
			Paciente paciente = new Paciente();
			paciente.setApellido("Calace");
			paciente.setDni("37521883");
			paciente.setEmail("alvarocalace@hotmail.com");	
			paciente.setFechaNacimiento(formarDateSQL("04/01/1994"));		
			paciente.setGenero("masculino");
			paciente.setNombre("Alvaro");
			paciente.setObraSocial("OSDE");
			paciente.setPlanObraSocial("OSDE Soy Diamond");
			paciente.setTelefono("43830700");
						
			AdministradorPersistenciaPaciente.getInstancia().insert(paciente);		
			//admPaciente.delete(paciente);
			
			HistoriaClinica historia = new HistoriaClinica();
			
			historia.setDescripcion("macaco");
			historia.setPaciente(paciente);
			
			AdministradorPersistenciaHistoriasClinicas.getInstancia().insert(historia);
			
			Odontologo odontologo = new Odontologo();
			
			odontologo.setApellido("Pauletti");
			odontologo.setMatricula("122-555566");
			odontologo.setNombre("Lalo");
			
			//AdministradorPersistenciaOdontologos.getInstancia().insert(odontologo);
			
			Especialidad especialidad = new Especialidad();
			especialidad.setDescripcion("Conductos");
			
			//odontologo.agregarEspecialidad(especialidad);
			
			
			//historia.altaObservacion(odontologo, new Date((format.parse("15/11/2014")).getTime()), "El paciente muestra gengivitis aguda.");
			
			/*
			FichaPeriodontal ficha = new FichaPeriodontal();
			ficha.setOdontologo(odontologo);
			ficha.setPaciente(paciente);
			
			//AdministradorPersistenciaFichaPeriodontal.getInstancia().insert(ficha);
			
			Seccion seccion = new Seccion();
			seccion.setMargen(2);
			seccion.setPlaca(true);
			seccion.setPosicionDiente("25");
			seccion.setPosicionSeccion("1");
			seccion.setProfundidad(5);
			seccion.setSangrado(false);
			
			*/
			
			//ficha.agregarSeccion(seccion);
			
			Turno turno = new Turno();
			
			turno.setDescripcion("Implantación de brackets.");
			turno.setFecha(formarDateSQL("24/12/2014"));
			turno.setOdontologo(odontologo);
			turno.setPaciente(paciente);
			
			//AdministradorPersistenciaTurnos.getInstancia().insert(turno);
			
			/*Odontograma odontograma = new Odontograma();
			odontograma.setFecha(formarDateSQL("05/12/2014"));
			odontograma.setIdOdontograma("1");
			odontograma.setOdontologo(odontologo);
			
			//AdministradorPersistenciaOdontograma.getInstancia().insert(odontograma, historia);
			
			Diente diente = new Diente();
			diente.setEstado("Roto");
			diente.setIdProtesis("1");
			diente.setIdPuente("-");
			diente.setPosicion("12");
			
			//AdministradorPersistenciaDiente.getInstancia().insert(diente, odontograma);
			
			Cara cara = new Cara();
			cara.setEstado("Broken");
			cara.setPosicion("Lingual");
			
			*/
			
			//historia.agregarOdontograma("424",getFechaActualSQL(), odontologo);
			
			historia.asignarFichaPeriodontal(odontologo);
			
		}
		
		catch (Exception e){
			e.printStackTrace();
		}
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
	
	private static java.sql.Date getFechaActualSQL(){
		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		return new Date(utilDate.getTime());
	}

}
