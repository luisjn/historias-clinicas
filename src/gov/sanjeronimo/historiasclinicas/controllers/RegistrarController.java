package gov.sanjeronimo.historiasclinicas.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrarController extends ViewController {
  public static final String INDEX_VIEW_PATH = "../views/index.fxml";

  @Override
  public void buildView(ActionEvent actionEvent) throws IOException {
    Parent registrarParent = FXMLLoader.load(getClass().getResource(INDEX_VIEW_PATH));
    this.changeScene(registrarParent, actionEvent);
  }
}
