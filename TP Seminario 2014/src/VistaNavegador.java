


import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 *	Clase para controlador la navegación entre las vistas.
 */
public class VistaNavegador {

    /**
     * Los fxml layouts manejados por el navegador.
     */
	
    public static final String MAIN    = "/fxml/main.fxml";
    public static final String VISTA_1 = "/fxml/vistaInicio.fxml";
    public static final String VISTA_2 = "/fxml/vista2.fxml";
    public static final String VISTA_3 = "/fxml/vistaAltaPaciente.fxml";
    public static final String VISTA_4 = "/fxml/vistaAltaHistoriaClinica.fxml";
    public static final String VISTA_5 = "/fxml/vistaListarPacientes.fxml";
    public static final String VISTA_6 = "/fxml/vistaAdministracionPacientes.fxml";
    public static final String VISTA_7 = "/fxml/vistaAltaOdontograma.fxml";
    public static final String VISTA_8 = "/fxml/vistaListarOdontologos.fxml";
    public static final String VISTA_9 = "/fxml/vistaAnalisisPredictivo.fxml";
    public static final String VISTA_10 = "/fxml/vistaAltaOdontologo.fxml";
    
    private static VistaPrincipalControlador mainController;

    
    public static void setMainController(VistaPrincipalControlador mainController) {
        VistaNavegador.mainController = mainController;
    }

    /**
     * Loads the vista specified by the fxml file into the
     * vistaHolder pane of the main application layout.
     *
     * Previously loaded vista for the same fxml file are not cached.
     * The fxml is loaded anew and a new vista node hierarchy generated
     * every time this method is invoked.
     *
     * A more sophisticated load function could potentially add some
     * enhancements or optimizations, for example:
     *   cache FXMLLoaders
     *   cache loaded vista nodes, so they can be recalled or reused
     *   allow a user to specify vista node reuse or new creation
     *   allow back and forward history like a browser
     *
     * @param fxml the fxml file to be loaded.
     */
    public static void loadVista(String fxml) {
        try {
            mainController.setVista((Node) FXMLLoader.load(VistaNavegador.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}