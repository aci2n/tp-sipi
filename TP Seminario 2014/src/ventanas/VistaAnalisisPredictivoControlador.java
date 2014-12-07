package ventanas;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;

public class VistaAnalisisPredictivoControlador implements Initializable {

	private ObservableList<PieChart.Data> dastosEstadisticos = FXCollections
			.observableArrayList();
	@FXML
	private PieChart grafico;
	@FXML
	private Button botonRealizarAnalisis;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		grafico.setVisible(false);
	}

	/* METODOS */

	private ObservableList<PieChart.Data> generarEstadisticas(
			Collection<Prediccion> predicicones) {

		// SE CARGAN LOS DATOS ESTADISTICOS

		this.dastosEstadisticos.add(new Data("Valor 1", 10));

		return dastosEstadisticos;
	}

	/* EVENT HANDLERS */

	public void realizarAnalisis(ActionEvent event) {

		// SE GENERA EL ANALISIS PASANDOLE LOS DATOS ESTADISTICOS

		grafico.setData(generarEstadisticas(null));
		grafico.setLegendSide(Side.RIGHT);
		grafico.setVisible(true);

	}
	
	class Prediccion{
		
	}

}
