
import implementacion.ItemPrediccion;
import implementacion.Prediccion;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import controlador.Controlador;

public class VistaAnalisisPredictivoControlador implements Initializable {

	@FXML
	private PieChart grafico;
	@FXML
	private Button botonRealizarAnalisis;
	@FXML
	private TextField textFiltrarTabla;
	@FXML
	private ComboBox<String> comboPredicciones;
	//private ObservableList<String> observablePredicciones = FXCollections.observableArrayList();
	private Collection<Prediccion> predicciones = new ArrayList<Prediccion>();
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		grafico.setVisible(false);
	}

	/* EVENT HANDLERS */

	public void realizarAnalisis(ActionEvent event) {

		// SE GENERA EL ANALISIS PASANDOLE LOS DATOS ESTADISTICOS
		
		predicciones = Controlador.getInstancia().analisisPredictivoHistoriaClinica(textFiltrarTabla.getText());
				
		for (Prediccion p : predicciones)
			comboPredicciones.getItems().add(p.getSintomaBase());
	}
		
	public void mostrarPrediccionDeSintoma (){		
		
		Prediccion prediccion = null;
		
		for (Prediccion p : predicciones)
			if (p.getSintomaBase().equals(comboPredicciones.getValue())){
				prediccion = p;
				break;
			}
		
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		
		for (ItemPrediccion i : prediccion.getItemsPrediccion())
			pieChartData.add(new PieChart.Data(i.getSintomaAnalisis(),i.getCantidad()));
				
		grafico.setData(pieChartData);
		grafico.setLegendSide(Side.RIGHT);
		grafico.setVisible(true);
		
	}
}
