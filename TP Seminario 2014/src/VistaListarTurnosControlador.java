import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import views.OdontologoView;
import controlador.Controlador;


public class VistaListarTurnosControlador implements Initializable {

	private ObservableList<OdontologoView> odontologos = FXCollections
			.observableArrayList();
	private ObservableList<TurnoViewLista> turnos = FXCollections.observableArrayList();
	@FXML
	private TextField textFiltrarTabla;
	@FXML
	private Button botonBuscar, botonVerTodos;
	@FXML
	private TableView<TurnoViewLista> tablaListarTurnos;
	@FXML
	private TableColumn<TurnoViewLista, String> columnaPaciente, columnaMatricula,
			columnaDni, columnaFecha, columnaDescripcion;
	@FXML 
	private TableColumn<TurnoViewLista, String> columnaOdontologo;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		columnaOdontologo.setCellValueFactory(new PropertyValueFactory<TurnoViewLista, String>(
				"odontologo"));
		columnaMatricula
		.setCellValueFactory(new PropertyValueFactory<TurnoViewLista, String>(
				"matricula"));
		columnaPaciente
		.setCellValueFactory(new PropertyValueFactory<TurnoViewLista, String>(
				"paciente"));
		columnaDni
		.setCellValueFactory(new PropertyValueFactory<TurnoViewLista, String>(
				"dni"));
		columnaFecha
		.setCellValueFactory(new PropertyValueFactory<TurnoViewLista, String>(
				"fecha"));
		columnaDescripcion
		.setCellValueFactory(new PropertyValueFactory<TurnoViewLista, String>(
				"descripcion"));
		
		odontologos = this.getOdontologos();
		turnos.removeAll(turnos);
		tablaListarTurnos.getItems().setAll(this.getTurnos());
	}
	
	
	
	
	/* METODOS */

	
	private boolean evaluarOdontologo(OdontologoView o, String s) {

		if (o.getNombre().equals(s))
			return true;
		else if (o.getApellido().equals(s))
			return true;
		else if (o.getMatricula().equals(s))
			return true;
		else
			return false;
	}
	
	private boolean evaluarTurno(OdontologoView ov, TurnoViewLista tvl){
		if (ov.getMatricula().compareTo(tvl.getMatricula())==0)
			return true;
		return false;
	}
	
	
	
	
	private ObservableList<OdontologoView> getOdontologos() {

		// CREA Y RETORNA LA LISTA QUE CONTIENE LOS ODONTOLOGOS
		
				
		for (views.OdontologoView ov : Controlador.getInstancia().obtenerOdontologosView()){
			OdontologoView ovn = new OdontologoView();
			ovn.setMatricula(ov.getMatricula());
			ovn.setApellido(ov.getApellido());
			ovn.setNombre(ov.getNombre());
			ovn.setEspecialidades(ov.getEspecialidades());
			odontologos.add(ovn);
		}

		return odontologos;
		
	}
	

	
	private ObservableList<TurnoViewLista> getTurnos() {

		// CREA Y RETORNA LA LISTA QUE CONTIENE LOS ODONTOLOGOS
		
				
		for (views.TurnoView tv : Controlador.getInstancia().obtenerTurnosView()){
			TurnoViewLista tvl = new TurnoViewLista();
			tvl.setOdontologo(concat(tv.getOdontologo().getApellido(), tv.getOdontologo().getNombre()));
			tvl.setMatricula(tv.getOdontologo().getMatricula());
			tvl.setPaciente(concat(tv.getPaciente().getApellido(), tv.getPaciente().getNombre()));
			tvl.setDni(tv.getPaciente().getDni());
			tvl.setFecha(tv.getFecha());
			tvl.setDescripcion(tv.getDescripcion());
			turnos.add(tvl);
			

		}

		return turnos;
		
	}
	
	
	
	/* EVENT HANDLERS */

	public void verTodos(ActionEvent event) {

		turnos.removeAll(turnos);
		tablaListarTurnos.getItems().setAll(this.getTurnos());
		
	}
	
	public void filtrarTabla(ActionEvent event) {

		
		ObservableList<TurnoViewLista> tablaFiltro = FXCollections
				.observableArrayList();

		
		if (textFiltrarTabla.getText().compareTo("")!=0){
			for (OdontologoView o : odontologos) {
	
				if (this.evaluarOdontologo(o, textFiltrarTabla.getText()) == true) {
	
					for (TurnoViewLista tvl : turnos){
						
						if (this.evaluarTurno(o, tvl)==true){
							tablaFiltro.add(tvl);
						}
					}
				}
			}
		}
		
		tablaListarTurnos.getItems().setAll(tablaFiltro);
		tablaFiltro.removeAll(tablaFiltro);
	}
	
	
	
	
	
	
	
	
	
	/*UTILITARIOS*/
	
	private String concat(String apellido, String nombre){
		String nuevo = apellido+", "+nombre;
		return nuevo;
	}
	
	
	
	
	public class TurnoViewLista {

		private String odontologo;
		private String matricula;
		private String paciente;
		private String dni;
		private Timestamp fecha;
		private String descripcion;

		public TurnoViewLista() {
		}

		public void setOdontologo(String odontologo){
			this.odontologo = odontologo;
		}
		
		public void setMatricula(String matricula){
			this.matricula = matricula;
		}
		public void setPaciente(String paciente){
			this.paciente = paciente;
		}
		public void setDni(String dni){
			this.dni = dni;
		}
		public void setFecha(Timestamp fecha){
			this.fecha = fecha;
		}
		public void setDescripcion(String descripcion){
			this.descripcion = descripcion;
		}
		
		
		public String getMatricula() {
			return matricula;
		}

		public String getOdontologo() {
			return odontologo;
		}


		public String getPaciente() {
			return paciente;
		}
		
		public Timestamp getFecha() {
			return fecha;
		}
		
		public String getDni() {
			return dni;
		}
		
		public String getDescripcion() {
			return descripcion;
		}
		
		
		
	}

}
