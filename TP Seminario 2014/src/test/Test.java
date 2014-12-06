package test;

import implementacion.Proyeccion;

import java.util.Collection;

import controlador.Controlador;

public class Test {

	public static void main(String[] args) {
		Controlador con = Controlador.getInstancia();
		con.altaPacienteTest("1");
		con.altaHistoriaClinicaTest("1");
		con.obtenerHistoriaClinicaTest("1").altaObservacion(null, null, "cancer sida");
		
		con.altaPacienteTest("2");
		con.altaHistoriaClinicaTest("2");
		con.obtenerHistoriaClinicaTest("2").altaObservacion(null, null, "cancer linceismo escorbuto");
		
		con.altaPacienteTest("3");
		con.altaHistoriaClinicaTest("3");
		con.obtenerHistoriaClinicaTest("3").altaObservacion(null, null, "sida linceismo cancer");
		
		con.altaPacienteTest("4");
		con.altaHistoriaClinicaTest("4");
		con.obtenerHistoriaClinicaTest("4").altaObservacion(null, null, "El paciente presento un caso severo de Linceismo acompañado de sida");
		
		con.altaPacienteTest("5");
		con.altaHistoriaClinicaTest("5");
		con.obtenerHistoriaClinicaTest("5").altaObservacion(null, null, "cancer");
		
		Collection<Proyeccion> proyecciones = con.analisisPredictivoHistoriaClinica("1");
		for (Proyeccion p : proyecciones){
			System.out.println(p.getSintomaBase());
			System.out.println(p.getSintomaAnalisis());
			System.out.println(p.getPorcentaje());
		}
	}

}
