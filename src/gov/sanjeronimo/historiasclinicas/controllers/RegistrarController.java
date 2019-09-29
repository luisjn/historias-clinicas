package gov.sanjeronimo.historiasclinicas.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrarController {
  public void irAIndex(ActionEvent actionEvent) throws IOException {
    Parent loginParent = FXMLLoader.load(getClass().getResource("../views/index.fxml"));
    Scene loginScene = new Scene(loginParent);

    Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
    window.setScene(loginScene);
    window.show();
  }
}
