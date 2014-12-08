import java.util.ArrayList;
import java.util.Collection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.EspecialidadView;
import views.OdontologoView;
import controlador.Controlador;


public class VistaAdministracionOdontologosControlador {

	@FXML
	private TextField tNombre;
	@FXML
	private TextField tApellido;
	@FXML
	private TextField tMatricula;
	@FXML
	private TextField tEspecialidades;
	
	public void altaOdontologo(ActionEvent event) {
		String nombre = tNombre.getText();
		String apellido = tApellido.getText();
		String matricula = tMatricula.getText();
		String especialidadesText = tEspecialidades.getText();
		Collection<EspecialidadView> especialidades = new ArrayList<EspecialidadView>();
		
		if (especialidadesText != null && !especialidadesText.trim().equals("")) {
			for (String especialidad : especialidadesText.split(",")) {
				EspecialidadView especialidadView = new EspecialidadView();
				especialidadView.setDescripcion(especialidad.trim());
				especialidades.add(especialidadView);
			}
		}
		
		if (nombre != null && !nombre.trim().equals("") 
			&& apellido != null && !apellido.trim().equals("")
			&& matricula != null && !matricula.trim().equals("")
			&& !especialidades.isEmpty()) {
			OdontologoView odontologoView = new OdontologoView();
			odontologoView.setNombre(nombre);
			odontologoView.setApellido(apellido);
			odontologoView.setMatricula(matricula);
			odontologoView.setEspecialidades(especialidades);
			Controlador.getInstancia().altaOdontologo(odontologoView);
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.setScene(new Scene(VBoxBuilder.create().
			    children(new Text("Odontólogo registrado correctamente"), new Button("Continuar")).
			    alignment(Pos.CENTER).padding(new Insets(5)).build()));
			dialogStage.show();
		}
	}
}
