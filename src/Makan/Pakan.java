/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Makan;

/**
 *
 * @author asus
 */
public class Pakan {
    
    private String kdPakan;
    private String namaPakan;
    private String jenis;
    private int jmlPakan;

    public Pakan(String kdPakan, String namaPakan, String jenis, int jmlPakan) {
        this.kdPakan = kdPakan;
        this.namaPakan = namaPakan;
        this.jenis = jenis;
        this.jmlPakan = jmlPakan;
    }

    public String getKdPakan() {
        return kdPakan;
    }

    public void setKdPakan(String kdPakan) {
        this.kdPakan = kdPakan;
    }

    public String getNamaPakan() {
        return namaPakan;
    }

    public void setNamaPakan(String namaPakan) {
        this.namaPakan = namaPakan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getJmlPakan() {
        return jmlPakan;
    }

    public void setJmlPakan(int jmlPakan) {
        this.jmlPakan = jmlPakan;
    }

    @Override
    public String toString() {
        return "Pakan{" +
                "kdPakan='" + kdPakan + '\'' +
                ", namaPakan='" + namaPakan + '\'' +
                ", jenis='" + jenis + '\'' +
                ", jmlPakan=" + jmlPakan +
                '}';
        }
    }