import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
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
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import views.FichaPeriodontalView;
import views.ObservacionView;
import views.OdontologoView;
import views.PacienteView;
import views.SeccionView;
import controlador.Controlador;

public class VistaAltaHistoriaClinicaControlador implements Initializable {

	@FXML
	private BorderPane panelFichaPeriodontal;
	@FXML
	private Label datosPaciente, labelDni;
	@FXML
	private TextField filtrarFicha, tDni;
	@FXML
	private TextArea tDescripcion;
	@FXML 
	private Button botonBuscar;
	@FXML
	private Button botonCancelar, botonEliminarFila, botonLimpiarTabla;
	@FXML
	private VBox boxFichaPeriodontal;
	@FXML
	private ComboBox<String> comboOdontologos;
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
	@FXML
	private TextField d1t1, d1t2, d1t3, d2t1, d2t2, d2t3, d3t1, d3t2, d3t3,
			d4t1, d4t2, d4t3, d5t1, d5t2, d5t3, d6t1, d6t2, d6t3, d7t1, d7t2,
			d7t3, d8t1, d8t2, d8t3, d9t1, d9t2, d9t3, d10t1, d10t2, d10t3,
			d11t1, d11t2, d11t3, d12t1, d12t2, d12t3, d13t1, d13t2, d13t3,
			d14t1, d14t2, d14t3, d15t1, d15t2, d15t3, d16t1, d16t2, d16t3,
			d17t1, d17t2, d17t3, d18t1, d18t2, d18t3, d19t1, d19t2, d19t3,
			d20t1, d20t2, d20t3, d21t1, d21t2, d21t3, d22t1, d22t2, d22t3,
			d23t1, d23t2, d23t3, d24t1, d24t2, d24t3, d25t1, d25t2, d25t3,
			d26t1, d26t2, d26t3, d27t1, d27t2, d27t3, d28t1, d28t2, d28t3,
			d29t1, d29t2, d29t3, d30t1, d30t2, d30t3, d31t1, d31t2, d31t3,
			d32t1, d32t2, d32t3;
	@FXML
	private TextField d1f1, d1f2, d1f3, d2f1, d2f2, d2f3, d3f1, d3f2, d3f3,
			d4f1, d4f2, d4f3, d5f1, d5f2, d5f3, d6f1, d6f2, d6f3, d7f1, d7f2,
			d7f3, d8f1, d8f2, d8f3, d9f1, d9f2, d9f3, d10f1, d10f2, d10f3,
			d11f1, d11f2, d11f3, d12f1, d12f2, d12f3, d13f1, d13f2, d13f3,
			d14f1, d14f2, d14f3, d15f1, d15f2, d15f3, d16f1, d16f2, d16f3,
			d17f1, d17f2, d17f3, d18f1, d18f2, d18f3, d19f1, d19f2, d19f3,
			d20f1, d20f2, d20f3, d21f1, d21f2, d21f3, d22f1, d22f2, d22f3,
			d23f1, d23f2, d23f3, d24f1, d24f2, d24f3, d25f1, d25f2, d25f3,
			d26f1, d26f2, d26f3, d27f1, d27f2, d27f3, d28f1, d28f2, d28f3,
			d29f1, d29f2, d29f3, d30f1, d30f2, d30f3, d31f1, d31f2, d31f3,
			d32f1, d32f2, d32f3;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		panelFichaPeriodontal.setDisable(true);
		panelFichaPeriodontal.getStylesheets().setAll(
				getClass().getResource("historiaClinica.css").toExternalForm());
		
		comboOdontologos.getItems().clear();
		
		ObservableList<String> odontologos = FXCollections.observableArrayList();
		
		for(OdontologoView o : Controlador.getInstancia().obtenerOdontologosView())
			odontologos.add(o.getMatricula());
		
		comboOdontologos.getItems().addAll(odontologos);
		
		labelDni.setText("-");
		tDni.setText("");
		tDescripcion.setText("");

		
	}

	/* METODOS */

	private Stage generarPrevisualizacion(Node node) {

		WritableImage imagen = node.snapshot(new SnapshotParameters(), null);
		ImageView imagenView = new ImageView();
		imagenView.setImage(imagen);

		StackPane snapLayout = new StackPane();
		snapLayout.getChildren().add(imagenView);

		Scene snapScene = new Scene(snapLayout, imagen.getWidth(),
				imagen.getHeight());

		Stage ventanaPrevisualizacion = new Stage();
		ventanaPrevisualizacion.setTitle("Previsualizaci�n");
		ventanaPrevisualizacion.setScene(snapScene);
		ventanaPrevisualizacion.initStyle(StageStyle.UNIFIED);

		return ventanaPrevisualizacion;
	}

	/* EVENT HANDLERS */

	public void presionarBuscarPaciente(ActionEvent event) {
		PacienteView paciente = Controlador.getInstancia().obtenerPacienteView(tDni.getText());
		if(paciente != null){
			panelFichaPeriodontal.setDisable(false);
			labelDni.setText(paciente.getNombre() + " " + paciente.getApellido());
		}
	}

	public void guardarFicha(ActionEvent event) {
		
		Controlador.getInstancia().altaHistoriaClinica(tDni.getText(),
				tDescripcion.getText());

		Collection<SeccionView> seccionesView = new ArrayList<SeccionView>();
		// DIENTE 1

		seccionesView.add(new SeccionView(d1s1.isSelected(), d1p1.isSelected(),
				Integer.parseInt(d1t1.getText()), Integer.parseInt(d1f1
						.getText()), "1", "1"));
		seccionesView.add(new SeccionView(d1s2.isSelected(), d1p2.isSelected(),
				Integer.parseInt(d1t2.getText()), Integer.parseInt(d1f2
						.getText()), "2", "1"));
		seccionesView.add(new SeccionView(d1s3.isSelected(), d1p3.isSelected(),
				Integer.parseInt(d1t2.getText()), Integer.parseInt(d1f2
						.getText()), "3", "1"));

		seccionesView.add(new SeccionView(d2s1.isSelected(), d1p1.isSelected(),
				Integer.parseInt(d2t1.getText()), Integer.parseInt(d2f1
						.getText()), "1", "2"));
		seccionesView.add(new SeccionView(d2s2.isSelected(), d2p2.isSelected(),
				Integer.parseInt(d2t2.getText()), Integer.parseInt(d2f2
						.getText()), "2", "2"));
		seccionesView.add(new SeccionView(d2s3.isSelected(), d2p3.isSelected(),
				Integer.parseInt(d2t3.getText()), Integer.parseInt(d2f3
						.getText()), "3", "2"));

		// DIENTE 3

		seccionesView.add(new SeccionView(d3s1.isSelected(), d3p1.isSelected(),
				Integer.parseInt(d3t1.getText()), Integer.parseInt(d3f1
						.getText()), "1", "3"));
		seccionesView.add(new SeccionView(d3s2.isSelected(), d3p2.isSelected(),
				Integer.parseInt(d3t2.getText()), Integer.parseInt(d3f2
						.getText()), "2", "3"));
		seccionesView.add(new SeccionView(d3s3.isSelected(), d3p3.isSelected(),
				Integer.parseInt(d3t3.getText()), Integer.parseInt(d3f2
						.getText()), "3", "3"));

		// DIENTE 4

		seccionesView.add(new SeccionView(d4s1.isSelected(), d4p1.isSelected(),
				Integer.parseInt(d4t1.getText()), Integer.parseInt(d4f1
						.getText()), "1", "4"));
		seccionesView.add(new SeccionView(d4s2.isSelected(), d4p2.isSelected(),
				Integer.parseInt(d4t2.getText()), Integer.parseInt(d4f2
						.getText()), "2", "4"));
		seccionesView.add(new SeccionView(d4s3.isSelected(), d4p3.isSelected(),
				Integer.parseInt(d4t3.getText()), Integer.parseInt(d4f2
						.getText()), "3", "4"));

		// DIENTE 5

		seccionesView.add(new SeccionView(d5s1.isSelected(), d5p1.isSelected(),
				Integer.parseInt(d5t1.getText()), Integer.parseInt(d5f1
						.getText()), "1", "5"));
		seccionesView.add(new SeccionView(d5s2.isSelected(), d5p2.isSelected(),
				Integer.parseInt(d5t2.getText()), Integer.parseInt(d5f2
						.getText()), "2", "5"));
		seccionesView.add(new SeccionView(d5s3.isSelected(), d5p3.isSelected(),
				Integer.parseInt(d5t3.getText()), Integer.parseInt(d5f2
						.getText()), "3", "5"));

		// DIENTE 6

		seccionesView.add(new SeccionView(d6s1.isSelected(), d6p1.isSelected(),
				Integer.parseInt(d6t1.getText()), Integer.parseInt(d6f1
						.getText()), "1", "6"));
		seccionesView.add(new SeccionView(d6s2.isSelected(), d6p2.isSelected(),
				Integer.parseInt(d6t2.getText()), Integer.parseInt(d6f2
						.getText()), "2", "6"));
		seccionesView.add(new SeccionView(d6s3.isSelected(), d6p3.isSelected(),
				Integer.parseInt(d6t3.getText()), Integer.parseInt(d6f2
						.getText()), "3", "6"));

		// DIENTE 7

		seccionesView.add(new SeccionView(d7s1.isSelected(), d7p1.isSelected(),
				Integer.parseInt(d7t1.getText()), Integer.parseInt(d7f1
						.getText()), "1", "7"));
		seccionesView.add(new SeccionView(d7s2.isSelected(), d7p2.isSelected(),
				Integer.parseInt(d7t2.getText()), Integer.parseInt(d7f2
						.getText()), "2", "7"));
		seccionesView.add(new SeccionView(d7s3.isSelected(), d7p3.isSelected(),
				Integer.parseInt(d7t3.getText()), Integer.parseInt(d7f2
						.getText()), "3", "7"));

		// DIENTE 8

		seccionesView.add(new SeccionView(d8s1.isSelected(), d8p1.isSelected(),
				Integer.parseInt(d8t1.getText()), Integer.parseInt(d8f1
						.getText()), "1", "8"));
		seccionesView.add(new SeccionView(d8s2.isSelected(), d8p2.isSelected(),
				Integer.parseInt(d8t2.getText()), Integer.parseInt(d8f2
						.getText()), "2", "8"));
		seccionesView.add(new SeccionView(d8s3.isSelected(), d8p3.isSelected(),
				Integer.parseInt(d8t2.getText()), Integer.parseInt(d8f2
						.getText()), "3", "8"));

		// DIENTE 9

		seccionesView.add(new SeccionView(d9s1.isSelected(), d9p1.isSelected(),
				Integer.parseInt(d9t1.getText()), Integer.parseInt(d9f1
						.getText()), "1", "9"));
		seccionesView.add(new SeccionView(d9s2.isSelected(), d9p2.isSelected(),
				Integer.parseInt(d9t2.getText()), Integer.parseInt(d9f2
						.getText()), "2", "9"));
		seccionesView.add(new SeccionView(d9s3.isSelected(), d9p3.isSelected(),
				Integer.parseInt(d9t2.getText()), Integer.parseInt(d9f2
						.getText()), "3", "9"));

		// DIENTE 10

		seccionesView.add(new SeccionView(d10s1.isSelected(), d10p1
				.isSelected(), Integer.parseInt(d10t1.getText()), Integer
				.parseInt(d10f1.getText()), "1", "10"));
		seccionesView.add(new SeccionView(d10s2.isSelected(), d10p2
				.isSelected(), Integer.parseInt(d10t2.getText()), Integer
				.parseInt(d10f2.getText()), "2", "10"));
		seccionesView.add(new SeccionView(d10s3.isSelected(), d10p3
				.isSelected(), Integer.parseInt(d10t2.getText()), Integer
				.parseInt(d10f2.getText()), "3", "10"));

		// DIENTE 11

		seccionesView.add(new SeccionView(d11s1.isSelected(), d11p1
				.isSelected(), Integer.parseInt(d11t1.getText()), Integer
				.parseInt(d11f1.getText()), "1", "11"));
		seccionesView.add(new SeccionView(d11s2.isSelected(), d11p2
				.isSelected(), Integer.parseInt(d11t2.getText()), Integer
				.parseInt(d11f2.getText()), "2", "11"));
		seccionesView.add(new SeccionView(d11s3.isSelected(), d11p3
				.isSelected(), Integer.parseInt(d11t2.getText()), Integer
				.parseInt(d11f2.getText()), "3", "11"));

		// DIENTE 12

		seccionesView.add(new SeccionView(d12s1.isSelected(), d12p1
				.isSelected(), Integer.parseInt(d12t1.getText()), Integer
				.parseInt(d12f1.getText()), "1", "12"));
		seccionesView.add(new SeccionView(d12s2.isSelected(), d12p2
				.isSelected(), Integer.parseInt(d12t2.getText()), Integer
				.parseInt(d12f2.getText()), "2", "12"));
		seccionesView.add(new SeccionView(d12s3.isSelected(), d12p3
				.isSelected(), Integer.parseInt(d12t2.getText()), Integer
				.parseInt(d12f2.getText()), "3", "12"));

		// DIENTE 13

		seccionesView.add(new SeccionView(d13s1.isSelected(), d13p1
				.isSelected(), Integer.parseInt(d13t1.getText()), Integer
				.parseInt(d13f1.getText()), "1", "13"));
		seccionesView.add(new SeccionView(d13s2.isSelected(), d13p2
				.isSelected(), Integer.parseInt(d13t2.getText()), Integer
				.parseInt(d13f2.getText()), "2", "13"));
		seccionesView.add(new SeccionView(d13s3.isSelected(), d13p3
				.isSelected(), Integer.parseInt(d13t2.getText()), Integer
				.parseInt(d13f2.getText()), "3", "13"));

		// DIENTE 14

		seccionesView.add(new SeccionView(d14s1.isSelected(), d14p1
				.isSelected(), Integer.parseInt(d14t1.getText()), Integer
				.parseInt(d14f1.getText()), "1", "14"));
		seccionesView.add(new SeccionView(d14s2.isSelected(), d14p2
				.isSelected(), Integer.parseInt(d14t2.getText()), Integer
				.parseInt(d14f2.getText()), "2", "14"));
		seccionesView.add(new SeccionView(d14s3.isSelected(), d14p3
				.isSelected(), Integer.parseInt(d14t2.getText()), Integer
				.parseInt(d14f2.getText()), "3", "14"));

		// DIENTE 15

		seccionesView.add(new SeccionView(d15s1.isSelected(), d15p1
				.isSelected(), Integer.parseInt(d15t1.getText()), Integer
				.parseInt(d15f1.getText()), "1", "15"));
		seccionesView.add(new SeccionView(d15s2.isSelected(), d15p2
				.isSelected(), Integer.parseInt(d15t2.getText()), Integer
				.parseInt(d15f2.getText()), "2", "15"));
		seccionesView.add(new SeccionView(d15s3.isSelected(), d15p3
				.isSelected(), Integer.parseInt(d15t2.getText()), Integer
				.parseInt(d15f2.getText()), "3", "15"));

		// DIENTE 16

		seccionesView.add(new SeccionView(d16s1.isSelected(), d16p1
				.isSelected(), Integer.parseInt(d16t1.getText()), Integer
				.parseInt(d16f1.getText()), "1", "16"));
		seccionesView.add(new SeccionView(d16s2.isSelected(), d16p2
				.isSelected(), Integer.parseInt(d16t2.getText()), Integer
				.parseInt(d16f2.getText()), "2", "16"));
		seccionesView.add(new SeccionView(d16s3.isSelected(), d16p3
				.isSelected(), Integer.parseInt(d16t2.getText()), Integer
				.parseInt(d16f2.getText()), "3", "16"));

		// DIENTE 17

		seccionesView.add(new SeccionView(d17s1.isSelected(), d17p1
				.isSelected(), Integer.parseInt(d17t1.getText()), Integer
				.parseInt(d17f1.getText()), "1", "17"));
		seccionesView.add(new SeccionView(d17s2.isSelected(), d17p2
				.isSelected(), Integer.parseInt(d17t2.getText()), Integer
				.parseInt(d17f2.getText()), "2", "17"));
		seccionesView.add(new SeccionView(d17s3.isSelected(), d17p3
				.isSelected(), Integer.parseInt(d17t2.getText()), Integer
				.parseInt(d17f2.getText()), "3", "17"));

		// DIENTE 18

		seccionesView.add(new SeccionView(d18s1.isSelected(), d18p1
				.isSelected(), Integer.parseInt(d18t1.getText()), Integer
				.parseInt(d18f1.getText()), "1", "18"));
		seccionesView.add(new SeccionView(d18s2.isSelected(), d18p2
				.isSelected(), Integer.parseInt(d18t2.getText()), Integer
				.parseInt(d18f2.getText()), "2", "18"));
		seccionesView.add(new SeccionView(d18s3.isSelected(), d18p3
				.isSelected(), Integer.parseInt(d18t2.getText()), Integer
				.parseInt(d18f2.getText()), "3", "18"));

		// DIENTE 19

		seccionesView.add(new SeccionView(d19s1.isSelected(), d19p1
				.isSelected(), Integer.parseInt(d19t1.getText()), Integer
				.parseInt(d19f1.getText()), "1", "19"));
		seccionesView.add(new SeccionView(d19s2.isSelected(), d19p2
				.isSelected(), Integer.parseInt(d19t2.getText()), Integer
				.parseInt(d19f2.getText()), "2", "19"));
		seccionesView.add(new SeccionView(d19s3.isSelected(), d19p3
				.isSelected(), Integer.parseInt(d19t2.getText()), Integer
				.parseInt(d19f2.getText()), "3", "19"));

		// DIENTE 20

		seccionesView.add(new SeccionView(d20s1.isSelected(), d20p1
				.isSelected(), Integer.parseInt(d20t1.getText()), Integer
				.parseInt(d20f1.getText()), "1", "20"));
		seccionesView.add(new SeccionView(d20s2.isSelected(), d20p2
				.isSelected(), Integer.parseInt(d20t2.getText()), Integer
				.parseInt(d20f2.getText()), "2", "20"));
		seccionesView.add(new SeccionView(d20s3.isSelected(), d20p3
				.isSelected(), Integer.parseInt(d20t2.getText()), Integer
				.parseInt(d20f2.getText()), "3", "20"));

		// DIENTE 21

		seccionesView.add(new SeccionView(d21s1.isSelected(), d21p1
				.isSelected(), Integer.parseInt(d21t1.getText()), Integer
				.parseInt(d21f1.getText()), "1", "21"));
		seccionesView.add(new SeccionView(d21s2.isSelected(), d21p2
				.isSelected(), Integer.parseInt(d21t2.getText()), Integer
				.parseInt(d21f2.getText()), "2", "21"));
		seccionesView.add(new SeccionView(d21s3.isSelected(), d21p3
				.isSelected(), Integer.parseInt(d21t2.getText()), Integer
				.parseInt(d21f2.getText()), "3", "21"));

		// DIENTE 22

		seccionesView.add(new SeccionView(d22s1.isSelected(), d22p1
				.isSelected(), Integer.parseInt(d22t1.getText()), Integer
				.parseInt(d22f1.getText()), "1", "22"));
		seccionesView.add(new SeccionView(d22s2.isSelected(), d22p2
				.isSelected(), Integer.parseInt(d22t2.getText()), Integer
				.parseInt(d22f2.getText()), "2", "22"));
		seccionesView.add(new SeccionView(d22s3.isSelected(), d22p3
				.isSelected(), Integer.parseInt(d22t2.getText()), Integer
				.parseInt(d22f2.getText()), "3", "22"));

		// DIENTE 23

		seccionesView.add(new SeccionView(d23s1.isSelected(), d23p1
				.isSelected(), Integer.parseInt(d23t1.getText()), Integer
				.parseInt(d23f1.getText()), "1", "23"));
		seccionesView.add(new SeccionView(d23s2.isSelected(), d23p2
				.isSelected(), Integer.parseInt(d23t2.getText()), Integer
				.parseInt(d23f2.getText()), "2", "23"));
		seccionesView.add(new SeccionView(d23s3.isSelected(), d23p3
				.isSelected(), Integer.parseInt(d23t2.getText()), Integer
				.parseInt(d23f2.getText()), "3", "23"));

		// DIENTE 24

		seccionesView.add(new SeccionView(d24s1.isSelected(), d24p1
				.isSelected(), Integer.parseInt(d24t1.getText()), Integer
				.parseInt(d24f1.getText()), "1", "24"));
		seccionesView.add(new SeccionView(d24s2.isSelected(), d24p2
				.isSelected(), Integer.parseInt(d24t2.getText()), Integer
				.parseInt(d24f2.getText()), "2", "24"));
		seccionesView.add(new SeccionView(d24s3.isSelected(), d24p3
				.isSelected(), Integer.parseInt(d24t2.getText()), Integer
				.parseInt(d24f2.getText()), "3", "24"));

		// DIENTE 25

		seccionesView.add(new SeccionView(d25s1.isSelected(), d25p1
				.isSelected(), Integer.parseInt(d25t1.getText()), Integer
				.parseInt(d25f1.getText()), "1", "25"));
		seccionesView.add(new SeccionView(d25s2.isSelected(), d25p2
				.isSelected(), Integer.parseInt(d25t2.getText()), Integer
				.parseInt(d25f2.getText()), "2", "25"));
		seccionesView.add(new SeccionView(d25s3.isSelected(), d25p3
				.isSelected(), Integer.parseInt(d25t2.getText()), Integer
				.parseInt(d25f2.getText()), "3", "25"));

		// DIENTE 26

		seccionesView.add(new SeccionView(d26s1.isSelected(), d26p1
				.isSelected(), Integer.parseInt(d26t1.getText()), Integer
				.parseInt(d26f1.getText()), "1", "26"));
		seccionesView.add(new SeccionView(d26s2.isSelected(), d26p2
				.isSelected(), Integer.parseInt(d26t2.getText()), Integer
				.parseInt(d26f2.getText()), "2", "26"));
		seccionesView.add(new SeccionView(d26s3.isSelected(), d26p3
				.isSelected(), Integer.parseInt(d26t2.getText()), Integer
				.parseInt(d26f2.getText()), "3", "26"));

		// DIENTE 27

		seccionesView.add(new SeccionView(d27s1.isSelected(), d27p1
				.isSelected(), Integer.parseInt(d27t1.getText()), Integer
				.parseInt(d27f1.getText()), "1", "27"));
		seccionesView.add(new SeccionView(d27s2.isSelected(), d27p2
				.isSelected(), Integer.parseInt(d27t2.getText()), Integer
				.parseInt(d27f2.getText()), "2", "27"));
		seccionesView.add(new SeccionView(d27s3.isSelected(), d27p3
				.isSelected(), Integer.parseInt(d27t2.getText()), Integer
				.parseInt(d27f2.getText()), "3", "27"));

		// DIENTE 28

		seccionesView.add(new SeccionView(d28s1.isSelected(), d28p1
				.isSelected(), Integer.parseInt(d28t1.getText()), Integer
				.parseInt(d28f1.getText()), "1", "28"));
		seccionesView.add(new SeccionView(d28s2.isSelected(), d28p2
				.isSelected(), Integer.parseInt(d28t2.getText()), Integer
				.parseInt(d28f2.getText()), "2", "28"));
		seccionesView.add(new SeccionView(d28s3.isSelected(), d28p3
				.isSelected(), Integer.parseInt(d28t2.getText()), Integer
				.parseInt(d28f2.getText()), "3", "28"));

		// DIENTE 29

		seccionesView.add(new SeccionView(d29s1.isSelected(), d29p1
				.isSelected(), Integer.parseInt(d29t1.getText()), Integer
				.parseInt(d29f1.getText()), "1", "29"));
		seccionesView.add(new SeccionView(d29s2.isSelected(), d29p2
				.isSelected(), Integer.parseInt(d29t2.getText()), Integer
				.parseInt(d29f2.getText()), "2", "29"));
		seccionesView.add(new SeccionView(d29s3.isSelected(), d29p3
				.isSelected(), Integer.parseInt(d29t2.getText()), Integer
				.parseInt(d29f2.getText()), "3", "29"));

		// DIENTE 30

		seccionesView.add(new SeccionView(d30s1.isSelected(), d30p1
				.isSelected(), Integer.parseInt(d30t1.getText()), Integer
				.parseInt(d30f1.getText()), "1", "30"));
		seccionesView.add(new SeccionView(d30s2.isSelected(), d30p2
				.isSelected(), Integer.parseInt(d30t2.getText()), Integer
				.parseInt(d30f2.getText()), "2", "30"));
		seccionesView.add(new SeccionView(d30s3.isSelected(), d30p3
				.isSelected(), Integer.parseInt(d30t2.getText()), Integer
				.parseInt(d30f2.getText()), "3", "30"));

		// DIENTE 31

		seccionesView.add(new SeccionView(d31s1.isSelected(), d31p1
				.isSelected(), Integer.parseInt(d31t1.getText()), Integer
				.parseInt(d31f1.getText()), "1", "31"));
		seccionesView.add(new SeccionView(d31s2.isSelected(), d31p2
				.isSelected(), Integer.parseInt(d31t2.getText()), Integer
				.parseInt(d31f2.getText()), "2", "31"));
		seccionesView.add(new SeccionView(d31s3.isSelected(), d31p3
				.isSelected(), Integer.parseInt(d31t2.getText()), Integer
				.parseInt(d31f2.getText()), "3", "31"));

		// DIENTE 32

		seccionesView.add(new SeccionView(d32s1.isSelected(), d32p1
				.isSelected(), Integer.parseInt(d32t1.getText()), Integer
				.parseInt(d32f1.getText()), "1", "32"));
		seccionesView.add(new SeccionView(d32s2.isSelected(), d32p2
				.isSelected(), Integer.parseInt(d32t2.getText()), Integer
				.parseInt(d32f2.getText()), "2", "32"));
		seccionesView.add(new SeccionView(d32s3.isSelected(), d32p3
				.isSelected(), Integer.parseInt(d32t2.getText()), Integer
				.parseInt(d32f2.getText()), "3", "32"));

		
		// SE CREA LA FICHA PERIODONTAL VIEW
		
		FichaPeriodontalView ficha = new FichaPeriodontalView();
		ficha.setOdontologo(Controlador.getInstancia().obtenerOdontologoView(
				comboOdontologos.getSelectionModel().getSelectedItem()));
		ficha.setSecciones(seccionesView);

		
		// ASIGNA LA FICHA A LA HISTORIA CLINICA
		
		Controlador.getInstancia().asignarFichaAHistoria(tDni.getText(), ficha);

	}

	public void mostrarPrevisualizacion(ActionEvent event) {

		this.generarPrevisualizacion(boxFichaPeriodontal).show();
	}

	public void cancelar(ActionEvent event) {

		this.initialize(null, null);
	}

}
