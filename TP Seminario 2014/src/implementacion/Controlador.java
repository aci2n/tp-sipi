package implementacion;



public class Controlador {
	private Collection<Paciente> pacientes;
	private Collection<Turno> turnos;
	private Collection<Odontologo> odontologos;
	private Collection<HistoriaClinica> historiasClinicas;
	private Collection<Prediccion> predicciones;
	private static Controlador instancia;
	public void Controlador() {
	
	}
	
	public static Controlador getControlador() {
	
	}
	
	public void altaHistoriaClinica(String dni) {
	
	}
	
	public void modificarSecciónHistoriaFicha(Integer dni, String seccion, String sDiente, boolean sangrado, boolean placa, Integer margen) {
	
	}
	
	public void actualizarHistoriaClínica(String dni, String matricula, Date fecha, String descripcion) {
	
	}
	
	public Odontologo buscarOdontologo(String dni) {
	
	}
	
	public HistoriaClinica buscarHistoriaClinica(String dni) {
	
	}
	
	public void ingresarEstadoDiente(Integer dni, Integer idDiente, String estado) {
	
	}
	
	public void ingresarProtesis(Integer dni, Integer idDiente) {
	
	}
	
	public void ingresarEstadoCara(Integer dni, Integer idDiente, Integer idCara, String estadoCara) {
	
	}
	
	public void ingresarDientesPuente(Integer dni, Collection<Integer> idDientes) {
	
	}
	
	public Prediccion analisisPredictivoHistoriaClinica(Integer dni) {
	
	}
	
	public Collection<Float> calcularProbabilidadesHistorias(Collection<String> Sintomas) {
	
	}
	
	public Collection<Float> calcularProbabilidades(Collection<String> Sintomas, Collection<String> SintomasOtros) {
	
	}
}
