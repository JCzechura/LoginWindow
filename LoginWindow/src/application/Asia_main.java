package application;
	

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.Optional;




public class Asia_main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Weryfikacja u¿ytkownika");
			alert.setHeaderText(null);
			Optional<Pair<MyEnum,String>> result =(new LogonDialog("Logowanie","Logowanie do systemu STYLEman")).showAndWait();
			if (result.isPresent()) 
					alert.setContentText("Logowanie u¿ytkownika "+result.get().getValue()+" do œrodowiska "+ result.get().getKey()+"go przebieg³o pomyœlnie!" );
				else 
					alert.setContentText("Nie uda³o siê zalogowaæ - b³êdne dane!");
			alert.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
    
}
