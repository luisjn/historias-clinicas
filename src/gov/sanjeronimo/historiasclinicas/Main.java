package gov.sanjeronimo.historiasclinicas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{


    @Override
    public void start(Stage primaryStage) {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			primaryStage.setTitle("Historias Clínicas");
			primaryStage.setScene(scene);
			primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
