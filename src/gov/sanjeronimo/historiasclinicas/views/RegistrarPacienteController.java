package gov.sanjeronimo.historiasclinicas.views;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class RegistrarPacienteController {
  public Label mensaje;

  public void registrarPaciente(ActionEvent actionEvent) {
    mensaje.setText("No se ha podido registar el paciente.");
  }
}
