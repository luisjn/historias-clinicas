package gov.sanjeronimo.historiasclinicas.views;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class IndexController {
  public Label mensaje;

  public void buscarHistoriaClinica(ActionEvent actionEvent) {
    mensaje.setText("Buscando...");
  }

  public void guardarHistoriaClinica(ActionEvent actionEvent) {
  }
}
