package gov.sanjeronimo.historiasclinicas.controllers;

import gov.sanjeronimo.historiasclinicas.services.ServicioHistoriaClinica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class RegistrarController extends ViewController {
  public static final String INDEX_VIEW_PATH = "../views/index.fxml";
  private ServicioHistoriaClinica servicioHistoriaClinica = ServicioHistoriaClinica.getInstance();
  @FXML
  private AnchorPane anchorPane;
  @FXML
  private TextField cedula;
  @FXML
  private DatePicker fecha;
  @FXML
  private Label fileName;
  File file;

  public void guardar(ActionEvent actionEvent) throws IOException {
    String dni = cedula.getText();
    LocalDate date = fecha.getValue();
    servicioHistoriaClinica.registrarHistoriaClinica(dni, date, file);
    /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Guardar Historia");
    alert.setHeaderText(null);
    alert.setContentText("Se ha guardado correctamente");
    alert.showAndWait();*/
    fileName.setText("");
    buildView(actionEvent);
  }

  public void btnSeleccionar(ActionEvent actionEvent) {
    FileChooser fileChooser = new FileChooser();
    file = fileChooser.showOpenDialog((Stage)anchorPane.getScene().getWindow());
    fileName.setText(file.getName());
  }

  @Override
  public void buildView(ActionEvent actionEvent) throws IOException {
    Parent registrarParent = FXMLLoader.load(getClass().getResource(INDEX_VIEW_PATH));
    this.changeScene(registrarParent, actionEvent);
  }
}