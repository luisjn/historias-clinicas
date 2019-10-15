package gov.sanjeronimo.historiasclinicas.services;

import gov.sanjeronimo.historiasclinicas.models.HistoriaClinica;
import gov.sanjeronimo.historiasclinicas.repository.RepositorioHistoriaClinica;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class ServicioHistoriaClinica {
  private static final ServicioHistoriaClinica INSTANCE = new ServicioHistoriaClinica();
  RepositorioHistoriaClinica repositorioHistoriaClinica = RepositorioHistoriaClinica.getInstance();

  private ServicioHistoriaClinica() {}

  public static ServicioHistoriaClinica getInstance() {
    return INSTANCE;
  }

  public void registrarHistoriaClinica(String dni, LocalDate date, File file) {
    repositorioHistoriaClinica.addMedicalHistory(dni, date, file);
  }

  public List<HistoriaClinica> listarHistorias(String dni, LocalDate date) {
    List<HistoriaClinica> historiasClinicas;
    if(date == null) {
      historiasClinicas = repositorioHistoriaClinica.getMedicalHistoryByDni(dni);
    } else {
      historiasClinicas = repositorioHistoriaClinica.getMedicalHistoryByDniAndDate(dni, date);
    }
    return historiasClinicas;
  }
}
