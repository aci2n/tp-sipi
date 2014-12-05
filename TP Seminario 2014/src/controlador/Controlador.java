package controlador;

import implementacion.HistoriaClinica;
import implementacion.Odontologo;
import implementacion.Paciente;
import implementacion.Prediccion;
import implementacion.Turno;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Controlador {
	
	private Collection<Paciente> pacientes;
	private Collection<Turno> turnos;
	private Collection<Odontologo> odontologos;
	private Collection<HistoriaClinica> historiasClinicas;
	private Collection<Prediccion> predicciones;
	
	private static Controlador instancia;
	
	private Controlador(){
		this.pacientes = new ArrayList<Paciente>();
		this.turnos = new ArrayList<Turno>();
		this.odontologos = new ArrayList<Odontologo>();
		this.historiasClinicas = new ArrayList<HistoriaClinica>();
		this.predicciones = new ArrayList<Prediccion>();
	}
	
	public static Controlador getInstance(){
		if (instancia==null)
			instancia = new Controlador();
		return instancia;
	}
	
	public void altaHistoriaClinica(String dni) {
	
	}
	
	public void modificarSeccionHistoriaFicha(int dni, String seccion, String sDiente, boolean sangrado, boolean placa, int margen) {
	
	}
	
	public void actualizarHistoriaClinica(String dni, String matricula, Date fecha, String descripcion) {
	
	}
	
	public Odontologo buscarOdontologo(String dni) {
		return null;
	}
	
	public HistoriaClinica buscarHistoriaClinica(String dni) {
		return null;
	}
	
	public void ingresarEstadoDiente(int dni, int idDiente, String estado) {
	
	}
	
	public void ingresarProtesis(int dni, int idDiente) {
	
	}
	
	public void ingresarEstadoCara(int dni, int idDiente, int idCara, String estadoCara) {
	
	}
	
	public void ingresarDientesPuente(int dni, int[] idDientes) {
	
	}
	
	public Prediccion analisisPredictivoHistoriaClinica(int dni) {
		return null;
	}
	
	public float[] calcularProbabilidadesHistorias(Collection<String> Sintomas) {
		return null;
	}
	
	public float[] calcularProbabilidades(Collection<String> Sintomas, Collection<String> SintomasOtros) {
		return null;
	}

	public Collection<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Collection<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Collection<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Collection<Turno> turnos) {
		this.turnos = turnos;
	}

	public Collection<Odontologo> getOdontologos() {
		return odontologos;
	}

	public void setOdontologos(Collection<Odontologo> odontologos) {
		this.odontologos = odontologos;
	}

	public Collection<HistoriaClinica> getHistoriasClinicas() {
		return historiasClinicas;
	}

	public void setHistoriasClinicas(Collection<HistoriaClinica> historiasClinicas) {
		this.historiasClinicas = historiasClinicas;
	}

	public Collection<Prediccion> getPredicciones() {
		return predicciones;
	}

	public void setPredicciones(Collection<Prediccion> predicciones) {
		this.predicciones = predicciones;
	}	
}