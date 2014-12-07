
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VistaAltaHistoriaClinicaControlador implements Initializable {

	private ObservableList<ObservacionView> observaciones = FXCollections
			.observableArrayList();
	@FXML
	private BorderPane panelFichaPeriodontal;
	@FXML
	private Label datosPaciente;
	@FXML
	private TextField filtrarFicha;
	@FXML
	private Button botonBuscar;
	@FXML
	private Button botonCancelar, botonEliminarFila, botonLimpiarTabla;
	@FXML
	private VBox fichaPeriodontal;
	@FXML
	private ComboBox<String> comboOdontologos, comboOdontologos2;
	@FXML
	private TableView<ObservacionView> tablaObservaciones;
	@FXML
	private TableColumn<ObservacionView, String> columnaOdontologo,
			columnaDescripcion, columnaFecha;
	@FXML
	private TextArea textObservaciones;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		panelFichaPeriodontal.setDisable(true);
		panelFichaPeriodontal.getStylesheets().setAll(
				getClass().getResource("historiaClinica.css").toExternalForm());

//		comboOdontologos.getItems().addAll("Odontologo 1");
//		comboOdontologos.getItems().addAll("Odontologo 2");
//		comboOdontologos.getItems().addAll("Odontologo 3");
//		comboOdontologos.getItems().addAll("Odontologo 4");

		comboOdontologos2.getItems().addAll("Odontologo 1");

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

	/* METODOS */

	@SuppressWarnings("deprecation")
	private ObservableList<ObservacionView> generarObservacion() {

		// CREA Y RETORNA LA LISTA QUE CONTIENE LAS OBSERVACIONES
		observaciones = FXCollections.observableArrayList();

		observaciones
				.add(new ObservacionView(comboOdontologos2.getValue(),
						new Date(2014, 11, 05).toString(), textObservaciones
								.getText()));

		return observaciones;
	}

	private Stage generarPrevisualizacion(Node node) {

		WritableImage imagen = node.snapshot(new SnapshotParameters(), null);
		ImageView imagenView = new ImageView();
		imagenView.setImage(imagen);

		StackPane snapLayout = new StackPane();
		snapLayout.getChildren().add(imagenView);

		Scene snapScene = new Scene(snapLayout, imagen.getWidth(),
				imagen.getHeight());

		Stage ventanaPrevisualizacion = new Stage();
		ventanaPrevisualizacion.setTitle("Previsualización");
		ventanaPrevisualizacion.setScene(snapScene);
		ventanaPrevisualizacion.initStyle(StageStyle.UNIFIED);

		return ventanaPrevisualizacion;
	}

	/* EVENT HANDLERS */

	public void presionarBuscarPaciente(ActionEvent event) {

		panelFichaPeriodontal.setDisable(false);
		datosPaciente.setText(filtrarFicha.getText());
	}

	public void agregarObservacion(ActionEvent event) {

		tablaObservaciones.getItems().addAll(this.generarObservacion());
	}

	public void mostrarPrevisualizacion(ActionEvent event) {

		this.generarPrevisualizacion(fichaPeriodontal).show();
	}

	public void limpiarTabla(ActionEvent event) {

		tablaObservaciones.getItems().clear();
	}

	public void eliminarFila(ActionEvent event) {

		// tablaObservaciones.getItems().clear();
		// tablaObservaciones.getItems().setAll(observaciones);

	}

	/* CAMBIAR POR LA VIEW DEL NEGOCIO */

	public class ObservacionView {

		private String odontologo;
		private String descripcion;
		private String fecha;

		public ObservacionView(String odontologo, String fecha,
				String descripcion) {

			this.fecha = fecha;
			this.descripcion = descripcion;
			this.odontologo = odontologo;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getOdontologo() {
			return odontologo;
		}

		public void setOdontologo(String odontologo) {
			this.odontologo = odontologo;
		}
	}

}
