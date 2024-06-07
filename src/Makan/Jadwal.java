/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Makan;
import java.util.Date;
/**
 *
 * @author asus
 */
public class Jadwal extends Pakan {
    private String idJadwal;
    private Date tglPekan;
    private String jenisJadwal;
    private int total;
    private int jml;

    public Jadwal(String idJadwal, Date tglPekan, String jenisJadwal, int total, int jml, String kdPakan, String namaPakan, String jenis, int jmlPakan) {
        super(kdPakan, namaPakan, jenis, jmlPakan);
        this.idJadwal = idJadwal;
        this.tglPekan = tglPekan;
        this.jenisJadwal = jenisJadwal;
        this.total = total;
        this.jml = jml;
    }

    public String getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(String idJadwal) {
        this.idJadwal = idJadwal;
    }

    public Date getTglPekan() {
        return tglPekan;
    }

    public void setTglPekan(Date tglPekan) {
        this.tglPekan = tglPekan;
    }

    public String getJenisJadwal() {
        return jenisJadwal;
    }

    public void setJenisJadwal(String jenisJadwal) {
        this.jenisJadwal = jenisJadwal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getJml() {
        return jml;
    }

    public void setJml(int jml) {
        this.jml = jml;
    }

    @Override
    public String toString() {
        return "Jadwal{" +
                "idJadwal='" + idJadwal + '\'' +
                ", tglPekan=" + tglPekan +
                ", jenisJadwal='" + jenisJadwal + '\'' +
                ", total=" + total +
                ", jml=" + jml +
                "} " + super.toString();
    }
}
