

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class VentanaEmergente {

	private Button cerrar;
	private StackPane stackPaneVentana;
	private VBox vbox1;
	private Button exit;
	private Button confirmar;

	public Button getCerrar() {
		return cerrar;
	}

	public void setCerrar(Button cerrar) {
		this.cerrar = cerrar;
	}

	public Button getExit() {
		return exit;
	}

	public void setexit(Button exit) {
		this.exit = exit;
	}

	public Scene obtenerScene(String title, String body) {

		stackPaneVentana = new StackPane();
		vbox1 = new VBox();

		// HBOX1

		HBox hbox1 = new HBox();

		// Crea los controles

		Label titulo = new Label(title);
		titulo.getStyleClass().add("titulo");
		exit = new Button();
		exit.getStyleClass().add("exit");
		StackPane stack = new StackPane();
		stack.getChildren().add(exit);
		stack.setAlignment(Pos.CENTER_RIGHT);
		HBox.setHgrow(stack, Priority.ALWAYS);
		StackPane.setMargin(exit, new Insets(0, 10, 0, 0));
		hbox1.setAlignment(Pos.CENTER_LEFT);

		// Agrega los controles al hbox

		hbox1.getChildren().add(titulo);
		hbox1.getChildren().add(stack);
		HBox.setMargin(titulo, new Insets(20));
		hbox1.getStyleClass().add("hbox1");

		// HBOX2

		HBox hbox2 = new HBox();
		hbox2.setPrefHeight(100);
		Label texto = new Label(body);
		texto.getStyleClass().add("body");
		texto.setWrapText(true);

		hbox2.getChildren().add(texto);
		hbox2.setAlignment(Pos.TOP_LEFT);
		HBox.setMargin(texto, new Insets(20));
		hbox2.getStyleClass().add("hbox2");

		// HBOX3

		HBox hbox3 = new HBox();
		hbox3.setAlignment(Pos.CENTER_RIGHT);
		hbox3.setSpacing(20);
		hbox3.setPadding(new Insets(20));
		hbox3.getStyleClass().add("hbox3");

		cerrar = new Button("Cerrar");
		cerrar.getStyleClass().add("cerrar");
		confirmar = new Button("Continuar");
		confirmar.getStyleClass().add("confirmar");

		hbox3.getChildren().add(confirmar);
		hbox3.getChildren().add(cerrar);

		hbox1.setPrefWidth(Control.USE_COMPUTED_SIZE);
		vbox1.getChildren().add(hbox1);
		vbox1.getChildren().add(hbox2);
		vbox1.getChildren().add(hbox3);

		stackPaneVentana.getChildren().add(vbox1);

		// Crea la scene y le asigna estilos

		Scene sceneVentana = new Scene(stackPaneVentana, 480, 180);
		sceneVentana.getStylesheets().add("ventanaEmergente.css");
		sceneVentana.setFill(javafx.scene.paint.Color.TRANSPARENT);

		// Crea y asigna a la scene el efecto fade

		FadeTransition ft = new FadeTransition(Duration.millis(500),
				stackPaneVentana);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();

		return sceneVentana;
	}

}
