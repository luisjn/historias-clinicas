package gov.sanjeronimo.historiasclinicas.controllers;

import gov.sanjeronimo.historiasclinicas.models.HistoriaClinica;
import gov.sanjeronimo.historiasclinicas.services.ServicioHistoriaClinica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.List;

public class IndexController extends ViewController {
  public static final String REGISTRAR_VIEW_PATH = "../views/registrar.fxml";
  private ServicioHistoriaClinica servicioHistoriaClinica = ServicioHistoriaClinica.getInstance();
  @FXML
  private ListView<String> listView;
  @FXML
  private TextField cedula;
  @FXML
  private DatePicker fecha;
  private List<HistoriaClinica> historiasClinicas;

  public void buscarHistoriaClinica(ActionEvent actionEvent) {
    listView.getItems().clear();
    String dni = cedula.getText();
    LocalDate date = fecha.getValue();
    if(!(dni == null || dni.length() == 0)) {
      historiasClinicas = servicioHistoriaClinica.listarHistorias(dni, date);
      historiasClinicas.stream().forEach(historiaClinica -> listView.getItems().add(
          historiaClinica.getFecha().toString()
      ));
    } else {
      System.out.println("campos vacios");
    }
  }

  public void handleClick(MouseEvent mouseEvent) {
    if(mouseEvent.getClickCount() >= 2) {
      int index = listView.getSelectionModel().getSelectedIndex();
      HistoriaClinica historiaClinica = historiasClinicas.get(index);
      String pathname = System.getProperty("user.home") + "\\Documents\\historias\\" + historiaClinica.getFileName();
      new File(System.getProperty("user.home") + "\\Documents\\historias").mkdirs();
      File file = new File(pathname);
      try {
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(historiaClinica.getFile());
        System.out.println("Write bytes to file.");
        outputStream.close();
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) desktop.open(file);
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void buildView(ActionEvent actionEvent) throws IOException {
    Parent registrarParent = FXMLLoader.load(getClass().getResource(REGISTRAR_VIEW_PATH));
    this.changeScene(registrarParent, actionEvent);
  }
}