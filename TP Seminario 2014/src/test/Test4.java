package test;

import implementacion.ItemProyeccion;
import implementacion.Proyeccion;

import java.sql.Timestamp;
import java.util.Collection;

import views.ObservacionView;
import views.OdontologoView;
import controlador.Controlador;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controlador con = Controlador.getInstancia();
		
		OdontologoView odontologo = new OdontologoView();
		
		odontologo.setApellido("Pauletti");
		odontologo.setMatricula("122-555566");
		odontologo.setNombre("Lalo");
		
		ObservacionView observacion = new ObservacionView();
		observacion.setDescripcion("El cliente con gengivitis sufrio la muerte.");
		observacion.setFecha(getFechaActualSQL());
		observacion.setOdontologo(odontologo);
		
		con.altaObservacion("37521882", observacion);
		
		observacion = new ObservacionView();
		observacion.setDescripcion("El paciente sufre gengivitis.");
		observacion.setFecha(getFechaActualSQL());
		observacion.setOdontologo(odontologo);
		
		con.altaObservacion("testpaciente1", observacion);
		
		observacion = new ObservacionView();
		observacion.setDescripcion("El cliente con gengivitis no se murio.");
		observacion.setFecha(getFechaActualSQL());
		observacion.setOdontologo(odontologo);
		
		con.altaObservacion("37521884", observacion);
		
		Collection<Proyeccion> proyecciones = con.analisisPredictivoHistoriaClinica("testpaciente1");
		
		for (Proyeccion p : proyecciones){
			System.out.println("Los pacientes que tuvieron el síntoma \""+p.getSintomaBase()+"\" también tuvieron:");
			for (ItemProyeccion i : p.getItemsProyeccion()){
				System.out.println("	"+i.getSintomaAnalisis()+" ("+i.getPorcentaje()+"%)");
			}
		}
		
		System.out.println("\nAnalisis realizado en base a "+con.obtenerHistoriasClinicasView().size()+" historias clinicas.");
	}
	
	private static Timestamp getFechaActualSQL(){
		return new Timestamp(System.currentTimeMillis());
	}	

}
