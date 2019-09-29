package gov.sanjeronimo.historiasclinicas.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class IndexController extends ViewController {
  public static final String REGISTRAR_VIEW_PATH = "../views/registrar.fxml";

  public void buscarHistoriaClinica(ActionEvent actionEvent) {
  }

  @Override
  public void buildView(ActionEvent actionEvent) throws IOException {
    Parent registrarParent = FXMLLoader.load(getClass().getResource(REGISTRAR_VIEW_PATH));
    this.changeScene(registrarParent, actionEvent);
  }
}
