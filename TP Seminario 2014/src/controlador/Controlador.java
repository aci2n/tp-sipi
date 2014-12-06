package controlador;

import implementacion.Especialidad;
import implementacion.FichaPeriodontal;
import implementacion.HistoriaClinica;
import implementacion.Odontologo;
import implementacion.Paciente;
import implementacion.Prediccion;
import implementacion.Turno;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import persistencia.AdministradorPersistenciaEspecialidades;
import persistencia.AdministradorPersistenciaHistoriasClinicas;
import persistencia.AdministradorPersistenciaOdontologos;
import persistencia.AdministradorPersistenciaPaciente;

public class Controlador {
	
	private Collection<Paciente> pacientes;
	private Collection<Turno> turnos;
	private Collection<Odontologo> odontologos;
	private Collection<HistoriaClinica> historiasClinicas;
	private Collection<Prediccion> predicciones;
	private Collection<Especialidad> especialidades;
	private static Controlador instancia;
	
	private Controlador(){
		this.pacientes = new ArrayList<Paciente>();
		this.turnos = new ArrayList<Turno>();
		this.odontologos = new ArrayList<Odontologo>();
		this.historiasClinicas = new ArrayList<HistoriaClinica>();
		this.predicciones = new ArrayList<Prediccion>();
		this.especialidades = new ArrayList<Especialidad>();
	}
	
	public static Controlador getInstancia(){
		if (instancia==null)
			instancia = new Controlador();
		return instancia;
	}
	
	public void altaHistoriaClinica(String dni) {
		Paciente paciente = obtenerPaciente(dni);
		if (paciente != null) {
			HistoriaClinica historia = obtenerHistoriaClinica(dni);
			if (historia == null) {
				historia = new HistoriaClinica();
				historia.setPaciente(paciente);
			}
		}
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
	
	public Collection<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Collection<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

	public Odontologo obtenerOdontologo(String matricula) {
		Odontologo odontologo = null;
		for (Odontologo odon : odontologos) {
			if (odon.sosElOdontologo(matricula)) {
				odontologo = odon;
			}
		}
		if (odontologo == null) {
			odontologo = AdministradorPersistenciaOdontologos.getInstancia().buscarOdontologo(matricula);
			if (odontologo != null) {
				odontologos.add(odontologo);
			}
		}
		return odontologo;
	}

	public Paciente obtenerPaciente(String dni) {
		Paciente paciente = null;
		for (Paciente pac : pacientes) {
			if (pac.sosElPaciente(dni)) {
				paciente = pac;
			}
		}
		if (paciente == null) {
			paciente = AdministradorPersistenciaPaciente.getInstancia().buscarPaciente(dni);
			if (paciente != null) {
				pacientes.add(paciente);
			}
		}
		return paciente;
	}
	
	public HistoriaClinica obtenerHistoriaClinica(String dni) {
		HistoriaClinica historia = null;
		for (HistoriaClinica hist : historiasClinicas) {
			if (hist.sosLaHistoria(dni)) {
				historia = hist;
			}
		}
		if (historia == null) {
			historia = AdministradorPersistenciaHistoriasClinicas.getInstancia().buscarHistoria(dni);
			if (historia != null) {
				historiasClinicas.add(historia);
			}
		}
		return historia;
	}

	public FichaPeriodontal obtenerFicha(String dni) {
		HistoriaClinica historia = obtenerHistoriaClinica(dni);
		if (historia != null) {
			return historia.getFicha();
		}
		return null;
	}
	
	public Especialidad obtenerEspecialidad(String descripcion) {
		Especialidad especialidad = null;
		for (Especialidad esp : especialidades) {
			if (esp.sosLaEspecialidad(descripcion)) {
				especialidad = esp;
			}
		}
		if (especialidad == null) {
			especialidad = AdministradorPersistenciaEspecialidades.getInstancia().buscarEspecialidad(descripcion);
			if (especialidad != null) {
				especialidades.add(especialidad);
			}
		}
		return especialidad;
	}
}