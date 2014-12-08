
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;

public class VistaGraficoAnalisisPredictivoControlador implements Initializable {

	@FXML
	private BarChart<String, Integer> grafico;
	@FXML
	private Label labelCantidadPacientes;
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		grafico.setAnimated(false);
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
