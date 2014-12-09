import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import views.CaraView;
import views.DienteView;
import views.OdontogramaView;
import views.OdontologoView;
import controlador.Controlador;

public class VistaAltaOdontogramaControlador implements Initializable {

	@FXML
	private StackPane stackOdontograma;
	@FXML
	private Button diente1;
	@FXML
	private VBox boxOdontograma;
	@FXML
	private ComboBox<String> comboOdontologos;
	@FXML
	private TextField tDni;
	@FXML
	private Button d1b1, d1b2, d1b3, d1b4, d1b5, d2b1, d2b2, d2b3, d2b4, d2b5,
			d3b1, d3b2, d3b3, d3b4, d3b5, d4b1, d4b2, d4b3, d4b4, d4b5, d5b1,
			d5b2, d5b3, d5b4, d5b5, d6b1, d6b2, d6b3, d6b4, d6b5, d7b1, d7b2,
			d7b3, d7b4, d7b5, d8b1, d8b2, d8b3, d8b4, d8b5, d9b1, d9b2, d9b3,
			d9b4, d9b5, d10b1, d10b2, d10b3, d10b4, d10b5, d11b1, d11b2, d11b3,
			d11b4, d11b5, d12b1, d12b2, d12b3, d12b4, d12b5, d13b1, d13b2,
			d13b3, d13b4, d13b5, d14b1, d14b2, d14b3, d14b4, d14b5, d15b1,
			d15b2, d15b3, d15b4, d15b5, d16b1, d16b2, d16b3, d16b4, d16b5,
			d17b1, d17b2, d17b3, d17b4, d17b5, d18b1, d18b2, d18b3, d18b4,
			d18b5, d19b1, d19b2, d19b3, d19b4, d19b5, d20b1, d20b2, d20b3,
			d20b4, d20b5, d21b1, d21b2, d21b3, d21b4, d21b5, d22b1, d22b2,
			d22b3, d22b4, d22b5, d23b1, d23b2, d23b3, d23b4, d23b5, d24b1,
			d24b2, d24b3, d24b4, d24b5, d25b1, d25b2, d25b3, d25b4, d25b5,
			d26b1, d26b2, d26b3, d26b4, d26b5, d27b1, d27b2, d27b3, d27b4,
			d27b5, d28b1, d28b2, d28b3, d28b4, d28b5, d29b1, d29b2, d29b3,
			d29b4, d29b5, d30b1, d30b2, d30b3, d30b4, d30b5, d31b1, d31b2,
			d31b3, d31b4, d31b5, d32b1, d32b2, d32b3, d32b4, d32b5;
	@FXML
	private Label referenciaCaries, referenciaCorona, referenciaFractura, referenciaAusente,
		referenciaEnfermedadPeriodontal, referenciaInfeccion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		stackOdontograma.getStylesheets().setAll(
				getClass().getResource("altaOdontograma.css").toExternalForm());

		comboOdontologos.getItems().clear();

		ObservableList<String> odontologos = FXCollections
				.observableArrayList();

		for (OdontologoView o : Controlador.getInstancia()
				.obtenerOdontologosView())
			odontologos.add(o.getMatricula());

		comboOdontologos.getItems().addAll(odontologos);

		boxOdontograma.setDisable(true);
		
		referenciaCaries.setStyle("-fx-background-color: #16a085"); 
		referenciaCorona.setStyle("-fx-background-color:#2980b9");
		referenciaFractura.setStyle("-fx-background-color:#e74c3c");
		referenciaAusente.setStyle("-fx-background-color:#34495e");
		referenciaEnfermedadPeriodontal.setStyle("-fx-background-color:#c0392b");
		referenciaInfeccion.setStyle("-fx-background-color:#f1c40f");
	}

	/* EVENT HANDLERS */

	public void buscaHistoriaClinica(ActionEvent event) {

		if (Controlador.getInstancia().obtenerHistoriaClinicaView(
				tDni.getText()) != null) {
			boxOdontograma.setDisable(false);
		}
	}

	public void agregarEstado(ActionEvent event) {
		// Button was clicked, change color

		final Button b = ((Button) event.getTarget());

		ContextMenu contextMenu = new ContextMenu();

		MenuItem carie = new MenuItem("Carie");
		MenuItem corona = new MenuItem("Corona");
		MenuItem fractura = new MenuItem("Fractura");
		MenuItem ausente = new MenuItem("Ausente");
		MenuItem infeccion = new MenuItem("Infecci�n");
		MenuItem enfermedadPeriodontal = new MenuItem("Enfermedad Periodontal");

		contextMenu.getItems().addAll(carie, corona, fractura, ausente,
				infeccion, enfermedadPeriodontal);

		carie.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				b.setStyle("-fx-background-color: #16a085");
				b.setText("Carie");
			}
		});

		corona.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				b.setStyle("-fx-background-color:#2980b9");
				b.setText("Corona");
			}
		});

		ausente.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				b.setStyle("-fx-background-color:#34495e");
				b.setText("Ausente");
			}
		});

		fractura.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				b.setStyle("-fx-background-color:#e74c3c");
				b.setText("Fractura");
			}
		});

		infeccion.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				b.setStyle("-fx-background-color:#f1c40f");
				b.setText("Infecci�n");
			}
		});

		enfermedadPeriodontal.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				b.setStyle("-fx-background-color:#c0392b");
				b.setText("Enfermedad Periodontal");
			}
		});

		((Button) event.getTarget()).setContextMenu(contextMenu);
	}

	public void guardarOdontograma(ActionEvent event) {

		Collection<DienteView> dientes = new ArrayList<DienteView>();

		// DIENTE 1

		Collection<CaraView> d1caras = new ArrayList<CaraView>();
		d1caras.add(new CaraView("1", d1b1.getText()));
		d1caras.add(new CaraView("2", d1b2.getText()));
		d1caras.add(new CaraView("3", d1b3.getText()));
		d1caras.add(new CaraView("4", d1b4.getText()));
		d1caras.add(new CaraView("5", d1b5.getText()));

		dientes.add(new DienteView("1", "0", "0", "null", d1caras));

		// DIENTE 2

		Collection<CaraView> d2caras = new ArrayList<CaraView>();
		d2caras.add(new CaraView("1", d2b1.getText()));
		d2caras.add(new CaraView("2", d2b2.getText()));
		d2caras.add(new CaraView("3", d2b3.getText()));
		d2caras.add(new CaraView("4", d2b4.getText()));
		d2caras.add(new CaraView("5", d2b5.getText()));

		dientes.add(new DienteView("2", "0", "0", "null", d2caras));

		// DIENTE 3

		Collection<CaraView> d3caras = new ArrayList<CaraView>();
		d3caras.add(new CaraView("1", d3b1.getText()));
		d3caras.add(new CaraView("2", d3b2.getText()));
		d3caras.add(new CaraView("3", d3b3.getText()));
		d3caras.add(new CaraView("4", d3b4.getText()));
		d3caras.add(new CaraView("5", d3b5.getText()));

		dientes.add(new DienteView("3", "0", "0", "null", d3caras));

		// DIENTE 4

		Collection<CaraView> d4caras = new ArrayList<CaraView>();
		d4caras.add(new CaraView("1", d4b1.getText()));
		d4caras.add(new CaraView("2", d4b2.getText()));
		d4caras.add(new CaraView("3", d4b3.getText()));
		d4caras.add(new CaraView("4", d4b4.getText()));
		d4caras.add(new CaraView("5", d4b5.getText()));

		dientes.add(new DienteView("4", "0", "0", "null", d4caras));

		// DIENTE 5

		Collection<CaraView> d5caras = new ArrayList<CaraView>();
		d5caras.add(new CaraView("1", d5b1.getText()));
		d5caras.add(new CaraView("2", d5b2.getText()));
		d5caras.add(new CaraView("3", d5b3.getText()));
		d5caras.add(new CaraView("4", d5b4.getText()));
		d5caras.add(new CaraView("5", d5b5.getText()));

		dientes.add(new DienteView("5", "0", "0", "null", d5caras));

		// DIENTE 6

		Collection<CaraView> d6caras = new ArrayList<CaraView>();
		d6caras.add(new CaraView("1", d6b1.getText()));
		d6caras.add(new CaraView("2", d6b2.getText()));
		d6caras.add(new CaraView("3", d6b3.getText()));
		d6caras.add(new CaraView("4", d6b4.getText()));
		d6caras.add(new CaraView("5", d6b5.getText()));

		dientes.add(new DienteView("6", "0", "0", "null", d6caras));

		// DIENTE 7

		Collection<CaraView> d7caras = new ArrayList<CaraView>();
		d7caras.add(new CaraView("1", d7b1.getText()));
		d7caras.add(new CaraView("2", d7b2.getText()));
		d7caras.add(new CaraView("3", d7b3.getText()));
		d7caras.add(new CaraView("4", d7b4.getText()));
		d7caras.add(new CaraView("5", d7b5.getText()));

		dientes.add(new DienteView("7", "0", "0", "null", d7caras));

		// DIENTE 8

		Collection<CaraView> d8caras = new ArrayList<CaraView>();
		d8caras.add(new CaraView("1", d8b1.getText()));
		d8caras.add(new CaraView("2", d8b2.getText()));
		d8caras.add(new CaraView("3", d8b3.getText()));
		d8caras.add(new CaraView("4", d8b4.getText()));
		d8caras.add(new CaraView("5", d8b5.getText()));

		dientes.add(new DienteView("8", "0", "0", "null", d8caras));

		// DIENTE 9

		Collection<CaraView> d9caras = new ArrayList<CaraView>();
		d9caras.add(new CaraView("1", d9b1.getText()));
		d9caras.add(new CaraView("2", d9b2.getText()));
		d9caras.add(new CaraView("3", d9b3.getText()));
		d9caras.add(new CaraView("4", d9b4.getText()));
		d9caras.add(new CaraView("5", d9b5.getText()));

		dientes.add(new DienteView("9", "0", "0", "null", d9caras));

		// DIENTE 10

		Collection<CaraView> d10caras = new ArrayList<CaraView>();
		d10caras.add(new CaraView("1", d10b1.getText()));
		d10caras.add(new CaraView("2", d10b2.getText()));
		d10caras.add(new CaraView("3", d10b3.getText()));
		d10caras.add(new CaraView("4", d10b4.getText()));
		d10caras.add(new CaraView("5", d10b5.getText()));

		dientes.add(new DienteView("10", "0", "0", "null", d10caras));

		// DIENTE 11

		Collection<CaraView> d11caras = new ArrayList<CaraView>();
		d11caras.add(new CaraView("1", d11b1.getText()));
		d11caras.add(new CaraView("2", d11b2.getText()));
		d11caras.add(new CaraView("3", d11b3.getText()));
		d11caras.add(new CaraView("4", d11b4.getText()));
		d11caras.add(new CaraView("5", d11b5.getText()));

		dientes.add(new DienteView("11", "0", "0", "null", d11caras));

		// DIENTE 12

		Collection<CaraView> d12caras = new ArrayList<CaraView>();
		d12caras.add(new CaraView("1", d12b1.getText()));
		d12caras.add(new CaraView("2", d12b2.getText()));
		d12caras.add(new CaraView("3", d12b3.getText()));
		d12caras.add(new CaraView("4", d12b4.getText()));
		d12caras.add(new CaraView("5", d12b5.getText()));

		dientes.add(new DienteView("12", "0", "0", "null", d12caras));

		// DIENTE 13

		Collection<CaraView> d13caras = new ArrayList<CaraView>();
		d13caras.add(new CaraView("1", d13b1.getText()));
		d13caras.add(new CaraView("2", d13b2.getText()));
		d13caras.add(new CaraView("3", d13b3.getText()));
		d13caras.add(new CaraView("4", d13b4.getText()));
		d13caras.add(new CaraView("5", d13b5.getText()));

		dientes.add(new DienteView("13", "0", "0", "null", d13caras));

		// DIENTE 14

		Collection<CaraView> d14caras = new ArrayList<CaraView>();
		d14caras.add(new CaraView("1", d14b1.getText()));
		d14caras.add(new CaraView("2", d14b2.getText()));
		d14caras.add(new CaraView("3", d14b3.getText()));
		d14caras.add(new CaraView("4", d14b4.getText()));
		d14caras.add(new CaraView("5", d14b5.getText()));

		dientes.add(new DienteView("14", "0", "0", "null", d14caras));

		// DIENTE 15

		Collection<CaraView> d15caras = new ArrayList<CaraView>();
		d15caras.add(new CaraView("1", d15b1.getText()));
		d15caras.add(new CaraView("2", d15b2.getText()));
		d15caras.add(new CaraView("3", d15b3.getText()));
		d15caras.add(new CaraView("4", d15b4.getText()));
		d15caras.add(new CaraView("5", d15b5.getText()));

		dientes.add(new DienteView("15", "0", "0", "null", d15caras));

		// DIENTE 16

		Collection<CaraView> d16caras = new ArrayList<CaraView>();
		d16caras.add(new CaraView("1", d16b1.getText()));
		d16caras.add(new CaraView("2", d16b2.getText()));
		d16caras.add(new CaraView("3", d16b3.getText()));
		d16caras.add(new CaraView("4", d16b4.getText()));
		d16caras.add(new CaraView("5", d16b5.getText()));

		dientes.add(new DienteView("16", "0", "0", "null", d16caras));

		// DIENTE 17

		Collection<CaraView> d17caras = new ArrayList<CaraView>();
		d17caras.add(new CaraView("1", d17b1.getText()));
		d17caras.add(new CaraView("2", d17b2.getText()));
		d17caras.add(new CaraView("3", d17b3.getText()));
		d17caras.add(new CaraView("4", d17b4.getText()));
		d17caras.add(new CaraView("5", d17b5.getText()));

		dientes.add(new DienteView("17", "0", "0", "null", d17caras));

		// DIENTE 18

		Collection<CaraView> d18caras = new ArrayList<CaraView>();
		d18caras.add(new CaraView("1", d18b1.getText()));
		d18caras.add(new CaraView("2", d18b2.getText()));
		d18caras.add(new CaraView("3", d18b3.getText()));
		d18caras.add(new CaraView("4", d18b4.getText()));
		d18caras.add(new CaraView("5", d18b5.getText()));

		dientes.add(new DienteView("18", "0", "0", "null", d18caras));

		// DIENTE 19

		Collection<CaraView> d19caras = new ArrayList<CaraView>();
		d19caras.add(new CaraView("1", d19b1.getText()));
		d19caras.add(new CaraView("2", d19b2.getText()));
		d19caras.add(new CaraView("3", d19b3.getText()));
		d19caras.add(new CaraView("4", d19b4.getText()));
		d19caras.add(new CaraView("5", d19b5.getText()));

		dientes.add(new DienteView("19", "0", "0", "null", d19caras));

		// DIENTE 20

		Collection<CaraView> d20caras = new ArrayList<CaraView>();
		d20caras.add(new CaraView("1", d20b1.getText()));
		d20caras.add(new CaraView("2", d20b2.getText()));
		d20caras.add(new CaraView("3", d20b3.getText()));
		d20caras.add(new CaraView("4", d20b4.getText()));
		d20caras.add(new CaraView("5", d20b5.getText()));

		dientes.add(new DienteView("20", "0", "0", "null", d20caras));

		// DIENTE 21

		Collection<CaraView> d21caras = new ArrayList<CaraView>();
		d21caras.add(new CaraView("1", d21b1.getText()));
		d21caras.add(new CaraView("2", d21b2.getText()));
		d21caras.add(new CaraView("3", d21b3.getText()));
		d21caras.add(new CaraView("4", d21b4.getText()));
		d21caras.add(new CaraView("5", d21b5.getText()));

		dientes.add(new DienteView("21", "0", "0", "null", d21caras));

		// DIENTE 22

		Collection<CaraView> d22caras = new ArrayList<CaraView>();
		d22caras.add(new CaraView("1", d22b1.getText()));
		d22caras.add(new CaraView("2", d22b2.getText()));
		d22caras.add(new CaraView("3", d22b3.getText()));
		d22caras.add(new CaraView("4", d22b4.getText()));
		d22caras.add(new CaraView("5", d22b5.getText()));

		dientes.add(new DienteView("22", "0", "0", "null", d22caras));

		// DIENTE 23

		Collection<CaraView> d23caras = new ArrayList<CaraView>();
		d23caras.add(new CaraView("1", d23b1.getText()));
		d23caras.add(new CaraView("2", d23b2.getText()));
		d23caras.add(new CaraView("3", d23b3.getText()));
		d23caras.add(new CaraView("4", d23b4.getText()));
		d23caras.add(new CaraView("5", d23b5.getText()));

		dientes.add(new DienteView("23", "0", "0", "null", d23caras));

		// DIENTE 24

		Collection<CaraView> d24caras = new ArrayList<CaraView>();
		d24caras.add(new CaraView("1", d24b1.getText()));
		d24caras.add(new CaraView("2", d24b2.getText()));
		d24caras.add(new CaraView("3", d24b3.getText()));
		d24caras.add(new CaraView("4", d24b4.getText()));
		d24caras.add(new CaraView("5", d24b5.getText()));

		dientes.add(new DienteView("24", "0", "0", "null", d24caras));

		// DIENTE 25

		Collection<CaraView> d25caras = new ArrayList<CaraView>();
		d25caras.add(new CaraView("1", d25b1.getText()));
		d25caras.add(new CaraView("2", d25b2.getText()));
		d25caras.add(new CaraView("3", d25b3.getText()));
		d25caras.add(new CaraView("4", d25b4.getText()));
		d25caras.add(new CaraView("5", d25b5.getText()));

		dientes.add(new DienteView("25", "0", "0", "null", d25caras));

		// DIENTE 26

		Collection<CaraView> d26caras = new ArrayList<CaraView>();
		d26caras.add(new CaraView("1", d26b1.getText()));
		d26caras.add(new CaraView("2", d26b2.getText()));
		d26caras.add(new CaraView("3", d26b3.getText()));
		d26caras.add(new CaraView("4", d26b4.getText()));
		d26caras.add(new CaraView("5", d26b5.getText()));

		dientes.add(new DienteView("26", "0", "0", "null", d26caras));

		// DIENTE 27

		Collection<CaraView> d27caras = new ArrayList<CaraView>();
		d27caras.add(new CaraView("1", d27b1.getText()));
		d27caras.add(new CaraView("2", d27b2.getText()));
		d27caras.add(new CaraView("3", d27b3.getText()));
		d27caras.add(new CaraView("4", d27b4.getText()));
		d27caras.add(new CaraView("5", d27b5.getText()));

		dientes.add(new DienteView("27", "0", "0", "null", d27caras));

		// DIENTE 28

		Collection<CaraView> d28caras = new ArrayList<CaraView>();
		d28caras.add(new CaraView("1", d28b1.getText()));
		d28caras.add(new CaraView("2", d28b2.getText()));
		d28caras.add(new CaraView("3", d28b3.getText()));
		d28caras.add(new CaraView("4", d28b4.getText()));
		d28caras.add(new CaraView("5", d28b5.getText()));

		dientes.add(new DienteView("28", "0", "0", "null", d28caras));

		// DIENTE 29

		Collection<CaraView> d29caras = new ArrayList<CaraView>();
		d29caras.add(new CaraView("1", d29b1.getText()));
		d29caras.add(new CaraView("2", d29b2.getText()));
		d29caras.add(new CaraView("3", d29b3.getText()));
		d29caras.add(new CaraView("4", d29b4.getText()));
		d29caras.add(new CaraView("5", d29b5.getText()));

		dientes.add(new DienteView("29", "0", "0", "null", d29caras));

		// DIENTE 30

		Collection<CaraView> d30caras = new ArrayList<CaraView>();
		d30caras.add(new CaraView("1", d30b1.getText()));
		d30caras.add(new CaraView("2", d30b2.getText()));
		d30caras.add(new CaraView("3", d30b3.getText()));
		d30caras.add(new CaraView("4", d30b4.getText()));
		d30caras.add(new CaraView("5", d30b5.getText()));

		dientes.add(new DienteView("30", "0", "0", "null", d30caras));

		// DIENTE 31

		Collection<CaraView> d31caras = new ArrayList<CaraView>();
		d31caras.add(new CaraView("1", d31b1.getText()));
		d31caras.add(new CaraView("2", d31b2.getText()));
		d31caras.add(new CaraView("3", d31b3.getText()));
		d31caras.add(new CaraView("4", d31b4.getText()));
		d31caras.add(new CaraView("5", d31b5.getText()));

		dientes.add(new DienteView("31", "0", "0", "null", d31caras));

		// DIENTE 32

		Collection<CaraView> d32caras = new ArrayList<CaraView>();
		d32caras.add(new CaraView("1", d32b1.getText()));
		d32caras.add(new CaraView("2", d32b2.getText()));
		d32caras.add(new CaraView("3", d32b3.getText()));
		d32caras.add(new CaraView("4", d32b4.getText()));
		d32caras.add(new CaraView("5", d32b5.getText()));

		dientes.add(new DienteView("32", "0", "0", "null", d32caras));

		// CARGA
		
		OdontogramaView odontograma = new OdontogramaView();
		odontograma.setDientes(dientes);
		odontograma
				.setOdontologo(Controlador.getInstancia()
						.obtenerOdontologoView(
								comboOdontologos.getSelectionModel()
										.getSelectedItem()));
		odontograma.setIdOdontograma(Controlador.getInstancia().obtenerIdOdontogramaMasReciente());
		odontograma.setFecha(getFechaActualSQL());

		Controlador.getInstancia().altaOdontograma(tDni.getText(), odontograma);
		
		/*Controlador.getInstancia().actualizarOdontograma(tDni.getText(),
				odontograma);*/

	}
	
	public void cancelar(ActionEvent event){		
		VistaNavegador.loadVista(VistaNavegador.VISTA_7);
	}
	
	private java.sql.Timestamp getFechaActualSQL(){
		return new Timestamp(System.currentTimeMillis());
	}	
}
