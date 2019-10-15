package gov.sanjeronimo.historiasclinicas.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class ViewController {

  public void changeScene(Parent parent, ActionEvent actionEvent) {
    Scene loginScene = new Scene(parent);
    Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
    window.setScene(loginScene);
    window.show();
  }

  public abstract void buildView(ActionEvent actionEvent) throws IOException;
}
