
import implementacion.Estadistica;
import implementacion.EstadisticaHistoriaClinica;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
	private VBox vBoxGrafico;

	private Estadistica estadistica;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void realizarAnalisis(ActionEvent event) {
		String dni = textFiltrarTabla.getText();
		if (dni != null && !dni.trim().equals("")) {
			Estadistica estadistica = Controlador.getInstancia().analisisPredictivoHistoriaClinica(dni); 
			if (estadistica != null) {
				ObservableList<String> observableSintomas = FXCollections.observableArrayList();
				observableSintomas.setAll(estadistica.getSintomasBase());
				
				comboPredicciones.getItems().clear();
				comboPredicciones.setItems(observableSintomas);
				
				this.estadistica = estadistica;
			}
		}		
	}
		
	public void mostrarPrediccionDeSintoma (){	
		String sintomaBase = comboPredicciones.getValue();
		if (sintomaBase != null && !sintomaBase.equals("Sintomas detectados")){
			PieChart grafico = (PieChart) vBoxGrafico.getChildren().get(0);
			ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
			
			for (EstadisticaHistoriaClinica estadisticaHistoria : estadistica.getEstadisticasPaciente()) {
				if (estadisticaHistoria.getSintomasPresentados().contains(sintomaBase)) {
					for (String sintomaPresentado : estadisticaHistoria.getSintomasPresentados()) {
						if (!sintomaPresentado.equals(sintomaBase)) {
							anadirDatos(data, sintomaPresentado);
						}
					}
				}
			}
			
			grafico.setData(data);	
			grafico.setTitle("Basado en coincidencias con otros " + estadistica.getEstadisticasPaciente().size() + " pacientes");
			
			for (final PieChart.Data dato : grafico.getData()) {
				Tooltip t = new Tooltip((dato.getPieValue() / estadistica.getEstadisticasPaciente().size() * 100) + "%");
				Tooltip.install(dato.getNode(), t);
			}
		}
		
	}
	
	public void anadirDatos(ObservableList<PieChart.Data> data, String sintomaPresentado) {
		for (PieChart.Data dato : data) {
			if (dato.getName().equals(sintomaPresentado)) {
				dato.setPieValue(dato.getPieValue() + 1);
				return;
			}
		}
		PieChart.Data dato = new PieChart.Data(sintomaPresentado, 1);
		data.add(dato);
	}
}
