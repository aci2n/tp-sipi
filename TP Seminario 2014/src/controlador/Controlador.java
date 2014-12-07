package controlador;

import implementacion.FichaPeriodontal;
import implementacion.HistoriaClinica;
import implementacion.Odontologo;
import implementacion.Paciente;
import implementacion.Prediccion;
import implementacion.Proyeccion;
import implementacion.Turno;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import persistencia.AdministradorPersistenciaHistoriasClinicas;
import persistencia.AdministradorPersistenciaOdontologos;
import persistencia.AdministradorPersistenciaPaciente;
import persistencia.AdministradorPersistenciaSintomas;
import persistencia.AdministradorPersistenciaTurnos;
import views.PacienteView;
import views.TurnoView;

public class Controlador {
	
	private Collection<Paciente> pacientes;
	private Collection<Turno> turnos;
	private Collection<Odontologo> odontologos;
	private Collection<HistoriaClinica> historiasClinicas;
	private Collection<String> sintomas;
	private static Controlador instancia;
	
	private Controlador(){
		this.pacientes = AdministradorPersistenciaPaciente.getInstancia().buscarPacientes();
		this.turnos = AdministradorPersistenciaTurnos.getInstancia().buscarTurnos();
		this.odontologos = AdministradorPersistenciaOdontologos.getInstancia().buscarOdontologos();
		this.historiasClinicas = AdministradorPersistenciaHistoriasClinicas.getInstancia().buscarHistorias();
		this.sintomas = AdministradorPersistenciaSintomas.getInstancia().buscarSintomas();
	}
	
	public static Controlador getInstancia(){
		if (instancia==null)
			instancia = new Controlador();
		return instancia;
	}
	
	public void altaPaciente(PacienteView pacienteView) {
		Paciente paciente = obtenerPaciente(pacienteView.getDni());
		if (paciente == null) {
			paciente = new Paciente(pacienteView.getDni(),
					pacienteView.getNombre(),
					pacienteView.getApellido(),
					pacienteView.getTelefono(),
					pacienteView.getEmail(),
					pacienteView.getFechaNacimiento(),
					pacienteView.getGenero(),
					pacienteView.getObraSocial(),
					pacienteView.getPlanObraSocial());
			this.pacientes.add(paciente);
		}
	}
	
	public void altaTurno(TurnoView turnoView) {
		Turno turno = obtenerTurno(turnoView.getPaciente().getDni(), turnoView.getOdontologo().getMatricula(), turnoView.getFecha());
		if (turno == null) {
			Paciente paciente = obtenerPaciente(turnoView.getPaciente().getDni());
			Odontologo odontologo = obtenerOdontologo(turnoView.getOdontologo().getMatricula());
			if (paciente != null && odontologo != null) {
				turno = new Turno(paciente, odontologo, turnoView.getDescripcion(), turnoView.getFecha());
				turnos.add(turno);
			}
		}
	}
	
	public void altaHistoriaClinica(String dni, String descripcion) {
		Paciente paciente = obtenerPaciente(dni);
		if (paciente != null) {
			HistoriaClinica historia = obtenerHistoriaClinica(dni);
			if (historia == null) {
				historia = new HistoriaClinica(paciente, descripcion);
				historiasClinicas.add(historia);
			}
		}
	}
	
	public Collection<Proyeccion> analisisPredictivoHistoriaClinica(String dni) {
		HistoriaClinica historia = obtenerHistoriaClinica(dni);
		Collection<Proyeccion> proyecciones = new ArrayList<Proyeccion>();
		if (historia != null){
			Collection<String> sintomasDetectados = historia.detectarSintomas(sintomas);
			Prediccion prediccion;
			Collection<HistoriaClinica> historiasSinContarLaAnalizada = this.historiasClinicas;
			historiasSinContarLaAnalizada.remove(historia);
			for (String sintoma : sintomasDetectados){
				prediccion = new Prediccion(sintoma);
				for (HistoriaClinica h : historiasSinContarLaAnalizada)
					if (h.tenesElSintoma(sintoma)){
						for (String sintomaAnalisis : h.detectarSintomas(sintomas))
							prediccion.agregarItemPrediccion(sintomaAnalisis);
						prediccion.aumentarCantidad();
					}
				proyecciones.add(prediccion.generarProyeccion());
			}				
		}
		return proyecciones;
	}
	
	public void actualizarHistoriaClinica(String dni, String matricula, Date fecha, String descripcion) {
		HistoriaClinica historia = obtenerHistoriaClinica(dni);
		if (historia != null) {
			historia.setDescripcion(descripcion);
			AdministradorPersistenciaHistoriasClinicas.getInstancia().update(historia);
		}
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
	
	public Turno obtenerTurno(String dni, String matricula, Date fecha) {
		Turno turno = null;
		for (Turno turn : turnos) {
			if (turn.sosElTurno(dni, matricula, fecha)) {
				turno = turn;
			}
		}
		if (turno == null) {
			turno = AdministradorPersistenciaTurnos.getInstancia().buscarTurno(matricula, dni, fecha);
			if (turno != null) {
				turnos.add(turno);
			}
		}
		return turno;
	}
	
	//metodos para el test
	
	public void altaPacienteTest(String dni){
		Paciente paciente = new Paciente();
		paciente.setDni(dni);
		this.pacientes.add(paciente);
	}
	

	public HistoriaClinica obtenerHistoriaClinicaTest(String dni) {
		HistoriaClinica historia = null;
		for (HistoriaClinica hist : historiasClinicas) {
			if (hist.sosLaHistoria(dni)) {
				historia = hist;
			}
		}
		return historia;
	}
	
	public void altaHistoriaClinicaTest(String dni) {
		Paciente paciente = obtenerPaciente(dni);
		if (paciente != null) {
			HistoriaClinica historia = obtenerHistoriaClinicaTest(dni);
			if (historia == null) {
				historia = new HistoriaClinica();
				historia.setPaciente(paciente);
				this.historiasClinicas.add(historia);
			}
		}
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

}