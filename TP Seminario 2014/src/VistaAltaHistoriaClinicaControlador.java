import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import controlador.Controlador;
import views.ObservacionView;
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
import javafx.scene.control.ToggleButton;
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
	private TextField filtrarFicha, tDni, tDescripcion;
	@FXML
	private Button botonBuscar;
	@FXML
	private Button botonCancelar, botonEliminarFila, botonLimpiarTabla;
	@FXML
	private VBox boxFichaPeriodontal;
	@FXML
	private ComboBox<String> comboOdontologos, comboOdontologos2;
	@FXML
	private TableView<ObservacionView> tablaObservaciones;
	@FXML
	private TableColumn<ObservacionView, String> columnaOdontologo,
			columnaDescripcion, columnaFecha;
	@FXML
	private TextArea textObservaciones;
	@FXML
	private ToggleButton d1s1, d1s2, d1s3, d2s1, d2s2, d2s3, d3s1, d3s2, d3s3,
			d4s1, d4s2, d4s3, d5s1, d5s2, d5s3, d6s1, d6s2, d6s3, d7s1, d7s2,
			d7s3, d8s1, d8s2, d8s3, d9s1, d9s2, d9s3, d10s1, d10s2, d10s3,
			d11s1, d11s2, d11s3, d12s1, d12s2, d12s3, d13s1, d13s2, d13s3,
			d14s1, d14s2, d14s3, d15s1, d15s2, d15s3, d16s1, d16s2, d16s3,
			d17s1, d17s2, d17s3, d18s1, d18s2, d18s3, d19s1, d19s2, d19s3,
			d20s1, d20s2, d20s3, d21s1, d21s2, d21s3, d22s1, d22s2, d22s3,
			d23s1, d23s2, d23s3, d24s1, d24s2, d24s3, d25s1, d25s2, d25s3,
			d26s1, d26s2, d26s3, d27s1, d27s2, d27s3, d28s1, d28s2, d28s3,
			d29s1, d29s2, d29s3, d30s1, d30s2, d30s3, d31s1, d31s2, d31s3,
			d32s1, d32s2, d32s3;
	@FXML
	private ToggleButton d1p1, d1p2, d1p3, d2p1, d2p2, d2p3, d3p1, d3p2, d3p3,
			d4p1, d4p2, d4p3, d5p1, d5p2, d5p3, d6p1, d6p2, d6p3, d7p1, d7p2,
			d7p3, d8p1, d8p2, d8p3, d9p1, d9p2, d9p3, d10p1, d10p2, d10p3,
			d11p1, d11p2, d11p3, d12p1, d12p2, d12p3, d13p1, d13p2, d13p3,
			d14p1, d14p2, d14p3, d15p1, d15p2, d15p3, d16p1, d16p2, d16p3,
			d17p1, d17p2, d17p3, d18p1, d18p2, d18p3, d19p1, d19p2, d19p3,
			d20p1, d20p2, d20p3, d21p1, d21p2, d21p3, d22p1, d22p2, d22p3,
			d23p1, d23p2, d23p3, d24p1, d24p2, d24p3, d25p1, d25p2, d25p3,
			d26p1, d26p2, d26p3, d27p1, d27p2, d27p3, d28p1, d28p2, d28p3,
			d29p1, d29p2, d29p3, d30p1, d30p2, d30p3, d31p1, d31p2, d31p3,
			d32p1, d32p2, d32p3;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		panelFichaPeriodontal.setDisable(true);
		panelFichaPeriodontal.getStylesheets().setAll(
				getClass().getResource("historiaClinica.css").toExternalForm());

		// comboOdontologos.getItems().addAll("Odontologo 1");
		// comboOdontologos.getItems().addAll("Odontologo 2");
		// comboOdontologos.getItems().addAll("Odontologo 3");
		// comboOdontologos.getItems().addAll("Odontologo 4");

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

		d15p1.setSelected(true);
	}

	/* METODOS */

	@SuppressWarnings("deprecation")
	private ObservableList<ObservacionView> generarObservacion() {

		// CREA Y RETORNA LA LISTA QUE CONTIENE LAS OBSERVACIONES
		observaciones = FXCollections.observableArrayList();

		ObservacionView o = new ObservacionView();

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

	public void altaHistoriaClinica(ActionEvent event) {

		Controlador.getInstancia().altaHistoriaClinica(tDni.getText(),
				tDescripcion.getText());
	}

	public void presionarBuscarPaciente(ActionEvent event) {

		panelFichaPeriodontal.setDisable(false);
		datosPaciente.setText(filtrarFicha.getText());
	}

	public void agregarObservacion(ActionEvent event) {

		tablaObservaciones.getItems().addAll(this.generarObservacion());
	}

	public void mostrarPrevisualizacion(ActionEvent event) {

		this.generarPrevisualizacion(boxFichaPeriodontal).show();
	}

	public void limpiarTabla(ActionEvent event) {

		tablaObservaciones.getItems().clear();
	}

	public void eliminarFila(ActionEvent event) {

		// tablaObservaciones.getItems().clear();
		// tablaObservaciones.getItems().setAll(observaciones);

	}

	/* CAMBIAR POR LA VIEW DEL NEGOCIO */

}
