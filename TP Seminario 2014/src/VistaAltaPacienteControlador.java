import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import controlador.Controlador;
import views.PacienteView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VistaAltaPacienteControlador implements Initializable {

	@FXML
	private TextField tNombre, tApellido, tDni, tDomicilio, tTelefono, tEmail,
			tObraSocial, tPlan;
	@FXML
	private DatePicker tNacimiento;
	@FXML
	private ComboBox<String> comboGenero;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		comboGenero.getItems().addAll("Masculino", "Femenino");

	}

	public void agregarPaciente(ActionEvent event) {

//		PacienteView paciente = new PacienteView();
//		paciente.setApellido(tApellido.getText());
//		paciente.setNombre(tNombre.getText());
//		paciente.setDni(tDni.getText());
//		paciente.setEmail(tEmail.getText());
//		// paciente.setFechaNacimiento(new Date());
//		paciente.setObraSocial(tObraSocial.getText());
//		paciente.setPlanObraSocial(tPlan.getText());
//		paciente.setGenero(comboGenero.getSelectionModel().getSelectedItem());
//
//		if(controlarDatosPaciente(paciente))
//			Controlador.getInstancia().altaPaciente(paciente);
//		else{
//			
//			Stage stage = new Stage();
//			stage.show();
//		}
	}

	private boolean controlarDatosPaciente(PacienteView p) {

		return false;
			
	}

}
