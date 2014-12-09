import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.OdontologoView;
import views.PacienteView;
import views.TurnoView;
import controlador.Controlador;


@SuppressWarnings("deprecation")
public class VistaAdministracionTurnosControlador implements Initializable {

	@FXML
	private TextField tDni, tDescripcion;
	@FXML
	private ComboBox<OdontologoView> comboOdontologos;
	@FXML
	private ComboBox<String> comboHora;
	@FXML
	private DatePicker fecha;
	@FXML
	private Button altaTurno;
	
	public void agregarTurno(ActionEvent event) {
		if (tDni.getText()!=""){
			if (comboOdontologos.getValue()!=null){
				if(fecha.getValue()!=null){
					if(comboHora.getValue()!=null){
						if(tDescripcion.getText().compareTo("")!=0 && tDescripcion.getText().compareTo("Descripcion")!=0){
							Controlador con = Controlador.getInstancia();
							PacienteView pv = new PacienteView();
							TurnoView tv = new TurnoView();
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
							String fechaT = fecha.getValue().toString()+' '+comboHora.getValue();
							java.util.Date fechaCompleta = null;
							java.sql.Timestamp timestamp = null;
							try {
								fechaCompleta = format.parse(fechaT);
								timestamp = new java.sql.Timestamp(fechaCompleta.getTime());
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							

							
							if ((pv = con.obtenerPacienteView(tDni.getText()))!=null){
								if (comboOdontologos.getValue()!=null){
									tv.setPaciente(pv);
									tv.setOdontologo(comboOdontologos.getValue());
									tv.setFecha(timestamp);
									tv.setDescripcion(tDescripcion.getText());
			
									con.altaTurno(tv);
									
									Stage dialogStage = new Stage();
									dialogStage.initModality(Modality.WINDOW_MODAL);
									dialogStage.setScene(new Scene(VBoxBuilder.create().
									    children(new Text("Turno registrado correctamente")).
									    alignment(Pos.CENTER).padding(new Insets(5)).build()));
									dialogStage.show();
								}
							}
 						}
					}
				}
			}
		}
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		comboOdontologos.getItems().clear();

		ObservableList<OdontologoView> odontologos = FXCollections
				.observableArrayList();

		for (OdontologoView o : Controlador.getInstancia().obtenerOdontologosView()){
			odontologos.add(o);
		}

		comboOdontologos.getItems().addAll(odontologos);
		comboHora.getItems().addAll("8:30", "09:00", "10:00");
		
		}
}
