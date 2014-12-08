import java.net.URL;
import java.util.ResourceBundle;

import views.ObservacionView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class vistaAltaObservacionesControlador implements Initializable {

	private ObservableList<ObservacionView> observaciones = FXCollections
			.observableArrayList();
	@FXML
	private ComboBox<String> comboOdontologos2;

	@FXML
	private Button botonAgregarObs;

	@FXML
	private TextArea textObservaciones;

	@FXML
	private TableView<ObservacionView> tablaObservaciones;
	@FXML
	private TableColumn<ObservacionView, String> columnaOdontologo,
			columnaDescripcion, columnaFecha;

	@FXML
	private Button botonEliminarFila;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		columnaOdontologo
				.setCellValueFactory(new PropertyValueFactory<ObservacionView, String>(
						"odontologo"));
		columnaFecha
				.setCellValueFactory(new PropertyValueFactory<ObservacionView, String>(
						"fecha"));
		columnaDescripcion
				.setCellValueFactory(new PropertyValueFactory<ObservacionView, String>(
						"descripcion"));
	}
	
	public void agregarObservacion(ActionEvent event) {

		tablaObservaciones.getItems().addAll(this.generarObservacion());
	}
	
	public void limpiarTabla(ActionEvent event) {

		tablaObservaciones.getItems().clear();
	}
	
	private ObservableList<ObservacionView> generarObservacion() {

		// CREA Y RETORNA LA LISTA QUE CONTIENE LAS OBSERVACIONES
		observaciones = FXCollections.observableArrayList();

		ObservacionView o = new ObservacionView();

		return observaciones;
	}

}
