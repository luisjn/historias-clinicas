package gov.sanjeronimo.historiasclinicas.repository;

import gov.sanjeronimo.historiasclinicas.models.HistoriaClinica;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class RepositorioHistoriaClinica {
  private static final RepositorioHistoriaClinica INSTANCE = new RepositorioHistoriaClinica();
  HistoriaClinicaDao historiaClinicaDao = HistoriaClinicaDao.getInstance();

  private RepositorioHistoriaClinica() {}

  public static RepositorioHistoriaClinica getInstance() {
    return INSTANCE;
  }

  public void addMedicalHistory(String dni, LocalDate date, File file) {
    if(!historiaClinicaDao.existPatient(dni)) {
      historiaClinicaDao.savePatient(dni);
    }
    historiaClinicaDao.saveMedicalHistory(dni, date, file);
  }

  public List<HistoriaClinica> getMedicalHistoryByDni(String dni) {
    return historiaClinicaDao.findAllByDni(dni);
  }

  public List<HistoriaClinica> getMedicalHistoryByDniAndDate(String dni, LocalDate date) {
    return historiaClinicaDao.findAllByDniAndDate(dni, date);
  }
}
