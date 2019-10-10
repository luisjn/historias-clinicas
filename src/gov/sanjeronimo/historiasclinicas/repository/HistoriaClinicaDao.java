package gov.sanjeronimo.historiasclinicas.repository;

import gov.sanjeronimo.historiasclinicas.models.HistoriaClinica;

import java.io.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoriaClinicaDao {
  private static final HistoriaClinicaDao INSTANCE = new HistoriaClinicaDao();
  ConexionBD conexionBD = ConexionBD.getInstance();

  private HistoriaClinicaDao() {}

  public static HistoriaClinicaDao getInstance() {
    return INSTANCE;
  }

  public void savePatient(String dni) {
    String sql= "INSERT INTO patient(dni) VALUES (?)";
    try {
      PreparedStatement query = conexionBD.getConnection().prepareStatement(sql);
      query.setString(1, dni);
      query.executeQuery();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void saveMedicalHistory(String dni, LocalDate date, File file) {
    String sql= "INSERT INTO medical_record (medical_history, patient_dni, date, file_name) VALUES (?,?,?,?)";
    FileInputStream fileInputStream = null;
    byte[] bytesArray = new byte[(int) file.length()];

    try {
      fileInputStream = new FileInputStream(file);
      fileInputStream.read(bytesArray);
      fileInputStream.close();
    } catch(IOException ex) {
      ex.printStackTrace();
    }

    try {
      PreparedStatement query = conexionBD.getConnection().prepareStatement(sql);
      query.setBytes(1, bytesArray);
      query.setString(2, dni);
      query.setDate(3, Date.valueOf(date));
      query.setString(4, file.getName());
      query.executeUpdate();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public List<HistoriaClinica> findAllByDni(String dni) {
    String sql = "SELECT patient_dni, date, medical_history, file_name FROM medical_record WHERE patient_dni = ?";
    List<HistoriaClinica> historiasClinicas = new ArrayList();
    try {
      PreparedStatement query = conexionBD.getConnection().prepareStatement(sql);
      query.setString(1, dni);
      ResultSet resultSet = query.executeQuery();
      while(resultSet.next()) {
        historiasClinicas.add(setHistoriaClinica(resultSet));
      }
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
    return historiasClinicas;
  }

  public List<HistoriaClinica> findAllByDniAndDate(String dni, LocalDate date) {
    String sql = "SELECT patient_dni, date, medical_history, file_name FROM medical_record WHERE patient_dni = ? AND date = ?";
    List<HistoriaClinica> historiasClinicas = new ArrayList();
    try {
      PreparedStatement query = conexionBD.getConnection().prepareStatement(sql);
      query.setString(1, dni);
      query.setDate(2, Date.valueOf(date));
      ResultSet resultSet = query.executeQuery();
      while(resultSet.next()) {
        historiasClinicas.add(setHistoriaClinica(resultSet));
      }
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
    return historiasClinicas;
  }

  public boolean existPatient(String dni) {
    String sql= "SELECT * FROM patient WHERE dni = ?";
    try {
      PreparedStatement query = conexionBD.getConnection().prepareStatement(sql);
      query.setString(1, dni);
      ResultSet resultSet = query.executeQuery();
      if(resultSet.isBeforeFirst()) {
        return true;
      }
    } catch(SQLException e){
      System.out.println(e.getMessage());
    }
    return false;
  }

  private HistoriaClinica setHistoriaClinica(ResultSet resultSet) throws SQLException {
    HistoriaClinica historiaClinica = new HistoriaClinica();
    historiaClinica.setDni(resultSet.getString("patient_dni"));
    historiaClinica.setFecha(resultSet.getDate("date").toLocalDate());
    historiaClinica.setFile(resultSet.getBytes("medical_history"));
    historiaClinica.setFileName(resultSet.getString("file_name"));
    return historiaClinica;
  }
}
