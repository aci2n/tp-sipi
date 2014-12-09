
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import views.EspecialidadView;
import views.OdontologoView;
import controlador.Controlador;

public class VistaListarOdontologosControlador implements Initializable {

	private ObservableList<OdontologoView> odontologos = FXCollections
			.observableArrayList();
	@FXML
	private TextField textFiltrarTabla;
	@FXML
	private Button botonBuscar, botonVerTodos;
	@FXML
	private TableView<OdontologoView> tablaListarOdontologos;
	@FXML
	private TableColumn<OdontologoView, String> columnaNombre, columnaApellido,
			columnaMatricula, columnaEspecialidad;

	public void initialize(URL location, ResourceBundle resources) {

		columnaMatricula
				.setCellValueFactory(new PropertyValueFactory<OdontologoView, String>(
						"matricula"));
		columnaNombre
				.setCellValueFactory(new PropertyValueFactory<OdontologoView, String>(
						"nombre"));
		columnaApellido
				.setCellValueFactory(new PropertyValueFactory<OdontologoView, String>(
						"apellido"));
		columnaEspecialidad.setCellValueFactory(new Callback<CellDataFeatures<OdontologoView,String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<OdontologoView, String> data) {
					StringBuilder stringB = new StringBuilder();
					for (EspecialidadView e : data.getValue().getEspecialidades())
						stringB.append(e.getDescripcion()+", ");
					if (!stringB.toString().equals(""))
						stringB.setLength(stringB.length()-2);
					return new ReadOnlyObjectWrapper<String>(stringB.toString());
			}
		});
		odontologos.removeAll(odontologos);
		tablaListarOdontologos.getItems().setAll(this.getOdontologos());
	}

	/* METODOS */

	private boolean evaluar(OdontologoView o, String s) {

		if (o.getNombre().equals(s))
			return true;
		else if (o.getApellido().equals(s))
			return true;
		else if (o.getMatricula().equals(s))
			return true;
		else
			return false;
	}

	private ObservableList<OdontologoView> getOdontologos() {

		// CREA Y RETORNA LA LISTA QUE CONTIENE LOS ODONTOLOGOS
		
				
		for (views.OdontologoView ov : Controlador.getInstancia().obtenerOdontologosView()){
			OdontologoView ovn = new OdontologoView();
			ovn.setMatricula(ov.getMatricula());
			ovn.setApellido(ov.getApellido());
			ovn.setNombre(ov.getNombre());
			ovn.setEspecialidades(ov.getEspecialidades());
			odontologos.add(ovn);
		}

		return odontologos;
		
	}

	/* EVENT HANDLERS */

	public void verTodos(ActionEvent event) {

		odontologos.removeAll(odontologos);
		tablaListarOdontologos.getItems().setAll(this.getOdontologos());

	}

	public void filtrarTabla(ActionEvent event) {

			
		ObservableList<OdontologoView> tablaFiltro = FXCollections
				.observableArrayList();

		
		
		for (OdontologoView o : odontologos) {

			if (this.evaluar(o, textFiltrarTabla.getText()) == true) {

				
				tablaFiltro.add(o);
			}
		}

		tablaListarOdontologos.getItems().setAll(tablaFiltro);
		
		tablaFiltro.removeAll(tablaFiltro);
	}
	


}
