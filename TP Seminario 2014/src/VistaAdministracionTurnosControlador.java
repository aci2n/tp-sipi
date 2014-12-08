import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

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
	private ComboBox<String> comboOdontologos, comboHora;
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
							OdontologoView ovAgregar = new OdontologoView();
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
							
							for (OdontologoView ov2: con.obtenerOdontologosView()){
								if(concat(ov2.getApellido(), ov2.getNombre()).compareTo(comboOdontologos.getValue())==0){
									ovAgregar=ov2;
								}
							}
							
							if ((pv = con.obtenerPacienteView(tDni.getText()))!=null){
								if (con.obtenerOdontologoView(ovAgregar.getMatricula())!=null){
									tv.setPaciente(pv);
									tv.setOdontologo(ovAgregar);
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
	
	private String concat(String apellido, String nombre){
		String nuevo = apellido+", "+nombre;
		return nuevo;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		for (OdontologoView ov : Controlador.getInstancia().obtenerOdontologosView()){
			comboOdontologos.getItems().add(concat(ov.getApellido(), ov.getNombre()));
		}
		comboHora.getItems().addAll("8:30", "09:00", "10:00");
		
		}
}
