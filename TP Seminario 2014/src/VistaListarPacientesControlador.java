
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import views.PacienteView;
import controlador.Controlador;

public class VistaListarPacientesControlador implements Initializable {

	private ObservableList<PacienteView> pacientes = FXCollections
			.observableArrayList();
	@FXML
	private TextField textFiltrarTabla;
	@FXML
	private TableView<PacienteView> tablaListarPacientes;
	@FXML
	private TableColumn<PacienteView, String> columnaNombre;
	@FXML
	private TableColumn<PacienteView, String> columnaApellido;
	@FXML
	private TableColumn<PacienteView, String> columnaDni;
	@FXML
	private TableColumn<PacienteView, String> columnaTelefono;
	@FXML
	private TableColumn<PacienteView, String> columnaEmail;
	@FXML
	private TableColumn<PacienteView, String> columnaNacimiento;
	@FXML
	private TableColumn<PacienteView, String> columnaObraSocial;
	@FXML
	private TableColumn<PacienteView, String> columnaPlan;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		columnaNombre
				.setCellValueFactory(new PropertyValueFactory<PacienteView, String>(
						"nombre"));
		columnaApellido
				.setCellValueFactory(new PropertyValueFactory<PacienteView, String>(
						"apellido"));
		columnaDni
				.setCellValueFactory(new PropertyValueFactory<PacienteView, String>(
						"dni"));
		columnaTelefono
				.setCellValueFactory(new PropertyValueFactory<PacienteView, String>(
						"telefono"));
		columnaEmail
				.setCellValueFactory(new PropertyValueFactory<PacienteView, String>(
						"email"));
		columnaNacimiento
				.setCellValueFactory(new PropertyValueFactory<PacienteView, String>(
						"nacimiento"));
		columnaObraSocial
				.setCellValueFactory(new PropertyValueFactory<PacienteView, String>(
						"obraSocial"));
		columnaPlan
				.setCellValueFactory(new PropertyValueFactory<PacienteView, String>(
						"plan"));
		
		pacientes.removeAll(pacientes);
		tablaListarPacientes.getItems().setAll(this.getPacientes());
		
	}

	private boolean evaluar(PacienteView p, String s) {

		if (p.getNombre().equals(s))
			return true;
		else if (p.getApellido().equals(s))
			return true;
		else if (p.getApellido().equals(s))
			return true;
		else if (p.getDni().equals(s))
			return true;
		else if (p.getEmail().equals(s))
			return true;
		else if (p.getFechaNacimiento().toString().equals(s))
			return true;
		else if (p.getTelefono().equals(s))
			return true;
		else if (p.getObraSocial().equals(s))
			return true;
		else if (p.getPlanObraSocial().equals(s))
			return true;
		else
			return false;
	}

	private ObservableList<PacienteView> getPacientes() {

		// CREA Y RETORNA LA LISTA QUE CONTIENE LOS PACIENTES

		for(PacienteView p : Controlador.getInstancia().obtenerPacientesView())
			pacientes.add(p);

		return pacientes;
	}

	/* EVENT HANDLERS */

	public void filtrarTabla(ActionEvent event) {

		ObservableList<PacienteView> tablaFiltro = FXCollections
				.observableArrayList();

		for (PacienteView p : pacientes) {

			if (this.evaluar(p, textFiltrarTabla.getText()) == true) {

				tablaFiltro.add(p);
			}
		}

		tablaListarPacientes.getItems().setAll(tablaFiltro);
	}

	public void verTodos(ActionEvent event) {

		// setea los pacientes en la tabla
		pacientes.removeAll(pacientes);
		tablaListarPacientes.getItems().setAll(this.getPacientes());

	}
	
	public void agregarNuevoPaciente(ActionEvent event){
		
		VistaNavegador.loadVista(VistaNavegador.VISTA_3);
	}

	
}
