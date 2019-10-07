package gov.sanjeronimo.historiasclinicas.repository;

import java.sql.*;

public class ConexionBD {
  private static ConexionBD instance;
  private Connection connection;
  private static final String URL = "jdbc:postgresql://localhost:5432/historias_clinicas";
  private static final String DRIVER = "org.postgresql.Driver";
  private static final String USER = "postgres";
  private static final String PASSWORD = "superuser";

  private ConexionBD() {
    try {
      Class.forName(DRIVER);
      this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException ex) {
      ex.printStackTrace();
    }
  }

  public Connection getConnection() {
    return connection;
  }

  public static ConexionBD getInstance() {
    try {
      if (instance == null) {
        instance = new ConexionBD();
      } else if (instance.getConnection().isClosed()) {
        instance = new ConexionBD();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return instance;
  }

  public void closeConnection() {
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
