
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Clase main de la aplicaci�n.
 */
public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("Sistema Odontol�gico");
		stage.setScene(createScene(loadMainPane()));
		stage.initStyle(StageStyle.DECORATED);
		stage.setMaximized(true);
		stage.setWidth(1100);
		stage.setHeight(680);
		stage.show();
		
	}

	/**
	 * Loads the main fxml layout. Sets up the vista switching VistaNavegador.
	 * Loads the first vista into the fxml layout.
	 *
	 * @return the loaded pane.
	 * @throws IOException
	 *             if the pane could not be loaded.
	 */
	private Pane loadMainPane() throws IOException {
		FXMLLoader loader = new FXMLLoader();

		Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(VistaNavegador.MAIN));

		VistaPrincipalControlador mainController = loader.getController();

		
		VistaNavegador.setMainController(mainController);
		VistaNavegador.loadVista(VistaNavegador.VISTA_1);

		return mainPane;
	}

	/**
	 * Creates the main application scene.
	 *
	 * @param mainPane
	 *            the main application layout.
	 *
	 * @return the created scene.
	 */
	private Scene createScene(Pane mainPane) {
		Scene scene = new Scene(mainPane);

		scene.getStylesheets().setAll(
				getClass().getResource("vista.css").toExternalForm());
		

		return scene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
