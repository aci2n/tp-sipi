
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import controlador.Controlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.PacienteView;

public class VistaAdministracionPacientesControlador implements Initializable{

	@FXML
	private TextField tNombre;
	@FXML
	private TextField tApellido;
	@FXML
	private TextField tDni;
	@FXML
	private TextField tTelefono;
	@FXML
	private TextField tEmail;
	@FXML
	private DatePicker tNacimiento;
	@FXML
	private ComboBox<String> comboGenero;
	@FXML
	private TextField tObraSocial;
	@FXML
	private TextField tPlan;
	
	
	public void altaPaciente(ActionEvent event) {
		String nombre = tNombre.getText();
		String apellido = tApellido.getText();
		String dni = tDni.getText();
		String telefono = tTelefono.getText();
		String email = tEmail.getText();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		String fechaT = tNacimiento.getValue().toString();
		Timestamp fecha = null;
		try {
			fecha = new Timestamp(format.parse(fechaT).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String genero = comboGenero.getValue();
		String obraSocial = tObraSocial.getText();
		String planObraSocial = tPlan.getText();
		
		if (nombre != null && !nombre.trim().equals("")
			&& apellido != null && !apellido.trim().equals("")
			&& dni != null && !dni.trim().equals("")
			&& telefono != null && !telefono.trim().equals("")
			&& email != null && !email.trim().equals("")
			&& fecha != null
			&& genero != null && !genero.trim().equals("")
			&& obraSocial != null && !obraSocial.trim().equals("")
			&& planObraSocial != null && !planObraSocial.trim().equals("")) {
			PacienteView view = new PacienteView();
			view.setNombre(nombre);
			view.setApellido(apellido);
			view.setDni(dni);
			view.setTelefono(telefono);
			view.setEmail(email);
			view.setFechaNacimiento(fecha);
			view.setGenero(genero);
			view.setObraSocial(obraSocial);
			view.setPlanObraSocial(planObraSocial);
			Controlador.getInstancia().altaPaciente(view);
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.setScene(new Scene(VBoxBuilder.create().
			    children(new Text("Paciente registrado correctamente")).
			    alignment(Pos.CENTER).padding(new Insets(5)).build()));
			dialogStage.show();
		}
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> generos = FXCollections.observableArrayList();
		generos.add("Femenino");
		generos.add("Masculino");
		comboGenero.setItems(generos);
	}
	

}
