import java.net.URL;
import java.util.ResourceBundle;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class VistaAltaOdontogramaControlador implements Initializable {

	@FXML
	private StackPane stackOdontograma;
	@FXML
	private Button diente1;
	@FXML
	private VBox boxOdontograma;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		stackOdontograma.getStylesheets().setAll(
				getClass().getResource("altaOdontograma.css").toExternalForm());

		boxOdontograma.setDisable(true);
	}

	/* EVENT HANDLERS */

	public void buscaHistoriaClinica(ActionEvent event) {

		if (Controlador.getInstancia().obtenerHistoriaClinicaView(
				tDni.getText()) != null) {
			boxOdontograma.setDisable(false);
		}
	}

}
