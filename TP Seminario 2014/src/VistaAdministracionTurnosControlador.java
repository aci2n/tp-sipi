import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.sun.jmx.snmp.Timestamp;

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


public class VistaAdministracionTurnosControlador implements Initializable {

	@FXML
	private TextField tDni, tDescripcion;
	@FXML
	private ComboBox<String> comboOdontologos, comboHora;
	@FXML
	private DatePicker fecha;
	@FXML
	private Button altaTurno;
	
	@SuppressWarnings("deprecation")
	public void agregarTurno(ActionEvent event) {
		if (tDni.getText()!=""){
			if(comboOdontologos.getValue().compareTo("Odontologo")!=0 && comboOdontologos.getValue().compareTo("")!=0){
				if(fecha.getValue()!=null){
					if(comboHora.getValue().compareTo("Hora")!=0 && comboHora.getValue().compareTo("")!=0){
						if(tDescripcion.getText().compareTo("")!=0 && tDescripcion.getText().compareTo("Descripcion")!=0){
							Controlador con = Controlador.getInstancia();
							OdontologoView ov = new OdontologoView();
							PacienteView pv = new PacienteView();
							TurnoView tv = new TurnoView();
							SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm");
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
							
							pv = con.obtenerPacienteView(tDni.getText());
							ov = con.obtenerOdontologoView(comboOdontologos.getValue());
							tv.setPaciente(pv);
							tv.setOdontologo(ov);
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		for (OdontologoView ov : Controlador.getInstancia().obtenerOdontologosView()){
			comboOdontologos.getItems().add(ov.getMatricula());
		}
		comboHora.getItems().addAll("8:30", "09:00", "10:00");
		
		}
}
