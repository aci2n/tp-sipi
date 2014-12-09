import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.HistoriaClinicaView;
import views.OdontogramaView;
import controlador.Controlador;


public class VistaVerFichaOdontogramasControlador implements Initializable{

	@FXML
	private TextField tDni;
	@FXML
	private TableView<OdontogramaView> table;
	@FXML
	private TableColumn<OdontogramaView, String> columnaOdontologo, columnaFecha;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		columnaOdontologo.setCellValueFactory(new PropertyValueFactory<OdontogramaView, String>("odontologo"));
		columnaFecha.setCellValueFactory(new PropertyValueFactory<OdontogramaView, String>("fecha"));
		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<OdontogramaView>() {
			@Override
			public void changed(ObservableValue<? extends OdontogramaView> observable, OdontogramaView oldValue, OdontogramaView newValue) {
				if (table.getSelectionModel().getSelectedItem() != null) {
	                mostrarOdontograma(table.getSelectionModel().getSelectedItem());
	            }
			}
        });
	}
	
	public void buscarDatos(ActionEvent event){
		String dni = tDni.getText();
		if (dni != null && !dni.trim().equals("")) {
			HistoriaClinicaView historia = Controlador.getInstancia().obtenerHistoriaClinicaView(dni);
			if (historia != null) {
				ObservableList<OdontogramaView> odontogramas = FXCollections.observableArrayList();
				odontogramas.addAll(historia.getOdontogramas());
				table.setItems(odontogramas);
			}
		}
		else
		{	Stage mensaje = new Stage();
			Scene scene = new Scene(new Group(new Text(25, 25, "Los datos son incorrectos")));
			mensaje.setTitle("Mensaje de alerta");
			mensaje.setScene(scene);
			mensaje.sizeToScene();
			mensaje.show();
		}
	}
	
	public void mostrarHistoria(ActionEvent event) {
		String dni = tDni.getText();
		if (dni != null && !dni.trim().equals("")) {
			HistoriaClinicaView historia = Controlador.getInstancia().obtenerHistoriaClinicaView(dni);
			if (historia != null) {
				Image image = new Image("file:Fichas Periodontales/" + tDni.getText() + ".png");
				 
		        ImageView imageView = new ImageView(image);

		        Group root = new Group();
		        Scene scene = new Scene(root);
		        VBox box = new VBox();
		        box.getChildren().add(new Text("Descripcion: " + historia.getDescripcion()));
		        box.getChildren().add(imageView);
		        root.getChildren().add(box);

		        Stage stage = new Stage();
		        stage.initModality(Modality.WINDOW_MODAL);
		        stage.setTitle("Historia clinica");
		        stage.setScene(scene); 
		        stage.sizeToScene(); 
		        stage.show(); 
			}
		}
	}
	
	private void mostrarOdontograma(OdontogramaView view) {
		Image image = new Image("file:Odontogramas/"+ tDni.getText() + "_" + view.getIdOdontograma() +".png");
		 
        ImageView imageView = new ImageView(image);

        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
        HBox box = new HBox();
        box.getChildren().add(imageView);
        root.getChildren().add(box);

        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Odontograma");
        stage.setScene(scene); 
        stage.sizeToScene(); 
        stage.show(); 
	}

}
