import java.net.URL;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.ResourceBundle;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import views.HistoriaClinicaView;
import views.ObservacionView;
import views.OdontologoView;
import controlador.Controlador;

public class vistaAltaObservacionesControlador implements Initializable {

	private ObservableList<ObservacionView> observaciones = FXCollections
			.observableArrayList();
	@FXML
	private ComboBox<OdontologoView> comboOdontologos2;

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
	@FXML
	private TextField textDNI;

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
		
		ObservableList<OdontologoView> odontologos = FXCollections.observableArrayList();
		odontologos.addAll(Controlador.getInstancia().obtenerOdontologosView());
		comboOdontologos2.setItems(odontologos);
	}
	
	public void obtenerObservaciones(KeyEvent event) {

		tablaObservaciones.setItems(this.generarObservacion());
	}
	
	public void limpiarTabla(ActionEvent event) {

		tablaObservaciones.getItems().clear();
	}
	
	public void altaObservacion(ActionEvent event) {
		String dni = textDNI.getText();
		OdontologoView odontologo = comboOdontologos2.getValue();
		String descripcion = textObservaciones.getText();
		
		if (dni != null && !dni.trim().equals("") && descripcion != null && !descripcion.trim().equals("") && odontologo != null) {
			ObservacionView view = new ObservacionView();
			view.setDescripcion(descripcion);
			view.setFecha(new Timestamp(Calendar.getInstance().getTime().getTime()));
			view.setOdontologo(odontologo);
			Controlador.getInstancia().altaObservacion(dni, view);
		}
		
		obtenerObservaciones(null);
	}
	
	public void bajaObservacion(ActionEvent event) {
		String dni = textDNI.getText();
		ObservacionView view = tablaObservaciones.getSelectionModel().getSelectedItem();
		if (view != null && dni != null && !dni.trim().equals("")) {
			Controlador.getInstancia().bajaObservacion(dni, view);

			obtenerObservaciones(null);
		}
	}
	
	private ObservableList<ObservacionView> generarObservacion() {

		// CREA Y RETORNA LA LISTA QUE CONTIENE LAS OBSERVACIONES
		observaciones = FXCollections.observableArrayList();
		
		if (textDNI.getText() != null) {
			HistoriaClinicaView historia = Controlador.getInstancia().obtenerHistoriaClinicaView(textDNI.getText());
			if (historia != null) {
				observaciones.addAll(historia.getObservaciones());
			}
		}

		return observaciones;
	}

}
