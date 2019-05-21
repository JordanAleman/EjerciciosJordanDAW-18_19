package combo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComboExecute extends Application {
    
	@Override
	public void start(Stage stage) throws Exception {
//
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("comboFutbol.fxml"));
	    Parent root = loader.load();

	    ComboController myController = loader.getController();

	    Scene scene = new Scene(root);
	    
        stage.setTitle("Liga Fúbol 2019");
	    stage.setScene(scene);
	    stage.show();

	    myController.cargaEquipos();
	}
	  public static void main(String[] args) {
	    launch(args);
	}
}