package gov.sanjeronimo.historiasclinicas.models;

import java.time.LocalDate;

public class HistoriaClinica {
    private String dni;
    private LocalDate fecha;
    private String fileName;
    private byte[] file;

    public HistoriaClinica(String dni, LocalDate fecha, String fileName, byte[] file) {
        this.dni = dni;
        this.fecha = fecha;
        this.fileName = fileName;
        this.file = file;
    }

    public HistoriaClinica() {}

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
