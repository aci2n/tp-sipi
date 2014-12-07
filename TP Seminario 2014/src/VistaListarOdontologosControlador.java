
import java.net.URL;
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

public class VistaListarOdontologosControlador implements Initializable {

	private ObservableList<OdontologoView> odontologos = FXCollections
			.observableArrayList();
	@FXML
	private TextField textFiltrarTabla;
	@FXML
	private Button botonBuscar, botonVerTodos;
	@FXML
	private TableView<OdontologoView> tablaListarOdontologos;
	@FXML
	private TableColumn<OdontologoView, String> columnaNombre, columnaApellido,
			columnaMatricula, columnaEspecialidad;

	public void initialize(URL location, ResourceBundle resources) {

		columnaMatricula
				.setCellValueFactory(new PropertyValueFactory<OdontologoView, String>(
						"matricula"));
		columnaNombre
				.setCellValueFactory(new PropertyValueFactory<OdontologoView, String>(
						"nombre"));
		columnaApellido
				.setCellValueFactory(new PropertyValueFactory<OdontologoView, String>(
						"apellido"));
		columnaEspecialidad
				.setCellValueFactory(new PropertyValueFactory<OdontologoView, String>(
						"especialidad"));

	}

	/* METODOS */

	private boolean evaluar(OdontologoView o, String s) {

		if (o.getNombre().equals(s))
			return true;
		else if (o.getApellido().equals(s))
			return true;
		else if (o.getMatricula().equals(s))
			return true;
		else if (o.getEspeciliadad().equals(s))
			return true;
		else
			return false;
	}

	private ObservableList<OdontologoView> getOdontologos() {

		// CREA Y RETORNA LA LISTA QUE CONTIENE LOS ODONTOLOGOS

		odontologos.add(new OdontologoView("1", "A", "A", "Awww"));
		odontologos.add(new OdontologoView("2", "B", "B", "B"));
		odontologos.add(new OdontologoView("3", "C", "C", "C"));
		odontologos.add(new OdontologoView("4", "D", "D", "D"));

		return odontologos;
	}

	/* EVENT HANDLERS */

	public void verTodos(ActionEvent event) {

		tablaListarOdontologos.getItems().setAll(this.getOdontologos());

	}

	public void filtrarTabla(ActionEvent event) {

		ObservableList<OdontologoView> tablaFiltro = FXCollections
				.observableArrayList();

		for (OdontologoView o : odontologos) {

			if (this.evaluar(o, textFiltrarTabla.getText()) == true) {

				tablaFiltro.add(o);
			}
		}

		tablaListarOdontologos.getItems().setAll(tablaFiltro);
	}

	public class OdontologoView {

		private String matricula;
		private String nombre;
		private String apellido;
		private String especiliadad;

		public OdontologoView(String matricula, String nombre, String apellido, String especialidad) {

			this.matricula = matricula;
			this.nombre = nombre;
			this.apellido = apellido;
			this.especiliadad = especialidad;
		}

		public String getMatricula() {
			return matricula;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getEspeciliadad() {
			return especiliadad;
		}

		public void setEspeciliadad(String especiliadad) {
			this.especiliadad = especiliadad;
		}

	}

}
