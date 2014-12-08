
import implementacion.Prediccion;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import controlador.Controlador;

public class VistaAnalisisPredictivoControlador implements Initializable {

	@FXML
	private Button botonRealizarAnalisis;
	@FXML
	private TextField textFiltrarTabla;
	@FXML
	private ComboBox<String> comboPredicciones;
	@FXML
	private Button botonGraficar;
	@FXML
	private Label labelCantidadPacientes;
	@FXML
	private VBox vBoxGrafico;
	
	private ObservableList<String> observablePredicciones;
	private Collection<Prediccion> predicciones = new ArrayList<Prediccion>();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void realizarAnalisis(ActionEvent event) {
		predicciones = Controlador.getInstancia().analisisPredictivoHistoriaClinica(textFiltrarTabla.getText());
		observablePredicciones = FXCollections.observableArrayList();
		comboPredicciones.getItems().clear();
		for (Prediccion p : predicciones)
			observablePredicciones.add(p.getSintomaBase());
		comboPredicciones.setItems(observablePredicciones);		
	}
		
	public void mostrarPrediccionDeSintoma (){	
		if (comboPredicciones.getValue()!=null && !comboPredicciones.getValue().equals("Sintomas detectados")){
			 try {
		            setVista((Node) FXMLLoader.load(VistaNavegador.class.getResource("vistaGraficoAnalisisPredictivo.fxml")));
		        } 
			 catch (IOException e) {
		            e.printStackTrace();
		        }			
		}
		
	}
	
	public void setVista(Node node) {
		vBoxGrafico.getChildren().setAll(node);
	}
		/*
		grafico.getData().clear();
		
		Prediccion prediccion = null;
		
		for (Prediccion p : predicciones)
			if (p.getSintomaBase().equals(comboPredicciones.getValue())){
				prediccion = p;
				break;
			}
				
		XYChart.Series<String,Integer> series = new XYChart.Series<String,Integer>();
							
		for (ItemPrediccion i : prediccion.getItemsPrediccion()){
			series.getData().add(new XYChart.Data<String, Integer>(i.getSintomaAnalisis(),i.getCantidad()));
		}
		
		labelCantidadPacientes.setText("Cantidad de pacientes analizados: "+prediccion.getTotal());
		
		grafico.getData().add(series);
		
	}
	*/
}
