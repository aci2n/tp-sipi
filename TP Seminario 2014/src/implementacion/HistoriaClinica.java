package implementacion;



public class HistoriaClinica {
	private Integer dni;
	private FichaPeriodontal ficha;
	private Collection<Odontograma> odontogramas;
	private Collection<Observacion> observaciones;
	private String descripcion;
	public void HistoriaClinica(String dni) {
	
	}
	
	public void altaFichaPeriodontal() {
	
	}
	
	public void altaOdontograma(Date fecha) {
	
	}
	
	public void altaObservacion(Odontologo odontologo, Date fecha, String descripcion) {
	
	}
	
	public void bajaOdontograma(Date fecha) {
	
	}
	
	public void bajaObservacion(Odontologo odontologo, Date fecha) {
	
	}
	
	public boolean sosLaHistoriaClinica(String dni) {
	
	}
	
	public void modificarSeccionFicha(String seccion, String sDiente, boolean sangrado, boolean placa, Integer margen) {
	
	}
	
	public Odontograma obtenerUltimoOdontograma() {
	
	}
	
	public void modificarOdontogramaEstadoDiente(Integer idDiente, String estado) {
	
	}
	
	public void modificarOdontogramaProtesis(Integer idDiente) {
	
	}
	
	public void modificarOdontogramaEstadoCara(Integer idDiente, Integer idCara, String estadoCara) {
	
	}
	
	public void modificarOdontogramaPuenteDientes(Collection<Integer> idDientes) {
	
	}
	
	public Collection<String> obtenerSintomasHistoria() {
	
	}
	
	public Collection<String> obtenerSintomasObservaciones() {
	
	}
	
	public Collection<String> obtenerSintomasOdontogramas() {
	
	}
	
	public Collection<String> unirSintomas(Collection<String> sintomasObservacion, Collection<String> sintomasOdontograma) {
	
	}
	
	public void setDescripcion() {
	
	}
}
