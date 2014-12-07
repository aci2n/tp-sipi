
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class VistaAltaOdontogramaControlador implements Initializable{

	@FXML	
	private StackPane stackOdontograma;
	@FXML
	private Button diente1;
	@FXML
	private VBox boxOdontograma;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		stackOdontograma.getStylesheets().setAll(
				getClass().getResource("altaOdontograma.css").toExternalForm());
		
		boxOdontograma.setDisable(true);		
	}
	
	/* EVENT HANDLERS */
	
	public void buscarPaciente(ActionEvent event){
		
		boxOdontograma.setDisable(false);
	}

}
