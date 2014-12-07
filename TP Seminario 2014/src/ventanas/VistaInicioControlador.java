package ventanas;

import java.io.IOException;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

//import org.controlsfx.control.PopOver;

/**
 * Controller class for the first vista.
 */
public class VistaInicioControlador implements Initializable {

	@FXML
	private Label hora;
	@FXML
	private Label fecha;
	@FXML
	private Group groupHora;
	@FXML
	private Button botonHora, botonFecha;
	@FXML
	private StackPane vistaHolder;
	@FXML
	private StackPane ventanaEmergente;
	@FXML
	private Button cerrarBoton;

	/**
	 * Event handler fired when the user requests a new vista.
	 *
	 * @param event
	 *            the event that triggered the handler.
	 */
	@FXML
	public void nextPane(ActionEvent event) {
		// VistaNavigator.loadVista(VistaNavigator.VISTA_2);

	}

	/**
	 * Crea y muestra una ventana emergente
	 * 
	 * @param event
	 *            El evento que dispara el handler
	 */
	@FXML
	public void accionarBotonHora(ActionEvent event) {

		Stage dialog = new Stage();
		dialog.initStyle(StageStyle.TRANSPARENT);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(vistaHolder.getScene().getWindow());

		VentanaEmergente ventanaE = new VentanaEmergente();

		dialog.setScene(ventanaE.obtenerScene("ALERTA",
				"¿Estás seguro que deseas eliminar al paciente seleccionado?"));
		ventanaE.getCerrar().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				dialog.close();
				vistaHolder.setDisable(false);
			}
		});
		ventanaE.getExit().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				dialog.close();
				vistaHolder.setDisable(false);
			}
		});

		dialog.show();
		vistaHolder.setDisable(true);

	}

	@FXML
	public void accionarBotonFecha(ActionEvent event) throws IOException {

		// PopOver p = new PopOver();
		// p.show(botonFecha);
		// p.setAutoHide(true);

	}

	/**
	 * Setea la hora actual del sistema
	 */
	public void comenzarHora() {
		final Timeline digitalTime = new Timeline(new KeyFrame(
				Duration.seconds(0), new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						Calendar calendar = GregorianCalendar.getInstance();
						String hourString = pad(2, '0',
								calendar.get(Calendar.HOUR) == 0 ? "12"
										: calendar.get(Calendar.HOUR) + "");
						String minuteString = pad(2, '0',
								calendar.get(Calendar.MINUTE) + "");
						String secondString = pad(2, '0',
								calendar.get(Calendar.SECOND) + "");
						String ampmString = calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM"
								: "PM";
						hora.setText(hourString + ":" + minuteString + ":"
								+ secondString + " " + ampmString);
					}
				}), new KeyFrame(Duration.seconds(1)));
		// time never ends.
		digitalTime.setCycleCount(Animation.INDEFINITE);
		digitalTime.play();
	}

	private String pad(int fieldWidth, char padChar, String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length(); i < fieldWidth; i++) {
			sb.append(padChar);
		}
		sb.append(s);

		return sb.toString();
	}

	@SuppressWarnings("unused")
	private void setTransicionDesvanecer(Node node, boolean valor) {
		FadeTransition ft = new FadeTransition(Duration.millis(250), node);
		ft.setFromValue(1.0);
		if (valor == true)
			ft.setToValue(0.3);
		else
			ft.setToValue(1);
		ft.setAutoReverse(true);
		ft.play();
	}

	/**
	 * Genera la fecha actual con su formato correspondiente.
	 * 
	 * @return la fecha actual formateada.
	 */
	private String getFechaConFormato() {

		String fechaString;
		Format formato;
		Date fechaActual = new Date();
		formato = new SimpleDateFormat("MMMM dd, YYYY");
		fechaString = formato.format(fechaActual);
		return fechaString;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.comenzarHora();
		fecha.setText(this.getFechaConFormato());

	}
}