
import java.net.URL;
import java.util.ResourceBundle;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class VistaAltaSintomaControlador implements Initializable{

	@FXML
	private TextField textNombre;
	@FXML
	private Button buttonConfirmar;
	
	@FXML
	public void agregarSintoma(ActionEvent event) {
		if (!textNombre.getText().equals("")){
			Controlador.getInstancia().altaSintoma(textNombre.getText());
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	

}
