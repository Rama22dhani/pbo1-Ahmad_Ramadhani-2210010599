/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;
import java.sql.Connection; // mendapatkan koneksi
import java.sql.DriverManager; // menghubungkan database
import java.sql.PreparedStatement; // perintah sql [CRUD]
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author asus
 */
public class database {
    private String databaseName = "ahmad_ramadhani_2210010599";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
    public database(){
        try {
           String location = "jdbc:mysql://localhost/" + databaseName;
           Class.forName("com.mysql.jdbc.Driver");
           connectionDB = DriverManager.getConnection(location, username, password);
           System.out.println("database terkoneksi");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public void tambahuji(String nik, String nama, String telp, String alamat){
        try {
            String sql = "insert into uji (nik, nama, telp, alamat) value(?, ?, ?, ?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, nik);
            perintah.setString(2, nama);
            perintah.setString(3, telp);
            perintah.setString(4, alamat);
            
            perintah.executeUpdate();
            System.out.println("added");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahuji(String nik, String nama, String telp, String alamat){
        try {
            String sql ="update uji set nama = ?, telp = ?, alamat = ? where nik = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setString(2, telp);
            perintah.setString(3, alamat);
            perintah.setString(4, nik);
            
            perintah.executeUpdate();
            System.out.println("updated");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusuji(String nik){
        try {
            String sql = "delete from uji where nik = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, nik);
            
            perintah.executeUpdate();
            System.out.println("deleted");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    // tabel kandang
    public void tambahkandang(String kd_kandang, String nama_kandang, String kapasitas){
        try {
            String sql = "insert into kandang (kd_kandang, nama_kandang, kapasitas) value (?,?,?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, kd_kandang);
            perintah.setString(2, nama_kandang);
            perintah.setString(3, kapasitas);
            
            perintah.executeUpdate();
            System.out.println("added");
            
        }
        catch (Exception e) {
           System.out.println(e.getMessage()); 
        }
    }
    public void ubahkandang(String kd_kandang, String nama_kandang, String kapasitas) {
        try {
            String sql = "update kandang set nama_kandang = ?, kapasitas = ? where kd_kandang = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, nama_kandang);
            perintah.setString(2, kapasitas);
            perintah.setString(3, kd_kandang);
            
            perintah.executeUpdate();
            System.out.println("update");
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapuskandang(String kd_kandang){
        try {
            String sql = "delete from kandang where kd_kandang = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, kd_kandang);
            
            perintah.executeUpdate();
            System.out.println("deleted");
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void carikandang(String kd_kandang){
        try {
            String sql = "select*from kandang where kd_kandang = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, kd_kandang);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("Kode :"+data.getString("kd_kandang"));
                System.out.println("Nama :"+data.getString("nama_kandang"));
                System.out.println("Kapasitas :"+data.getString("kapasitas"));
                
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void datakandang(){
        try {
            Statement stmt = connectionDB.createStatement();
            ResultSet baris = stmt.executeQuery("select*from kandang order by kd_kandang");
            while(baris.next()){
                System.out.println(baris.getString("kd_kandang")+"|"+
                        baris.getString("nama_kandang")+"|"+
                        baris.getString("kapasitas"));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    // tabel populasi
    public void tambahpopulasi(String id_populasi, String tgl_populasi, String jml_mati, String jml_hidup, String sisa, String kd_kandang, String kd_user){
        try {
            String sql = "insert into populasi (id_populasi, tgl_populasi, jml_mati, jml_hidup, sisa, kd_kandang, kd_user) value (?,?,?,?,?,?,?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, id_populasi);
            perintah.setString(2, tgl_populasi);
            perintah.setString(3, jml_mati);
            perintah.setString(4, jml_hidup);
            perintah.setString(5, sisa);
            perintah.setString(6, kd_kandang);
            perintah.setString(7, kd_user);
            
            perintah.executeUpdate();
            System.out.println("added");
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void ubahpopulasi(String id_populasi, String tgl_populasi, String jml_mati, String jml_hidup, String sisa, String kd_kandang, String kd_user){
        try {
            String sql = "update populasi set tgl_populasi = ?, jml_mati = ?, jml_hidup = ?, sisa = ?, kd_kandang = ?, kd_user = ? where id_populasi = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, tgl_populasi);
            perintah.setString(2, jml_mati);
            perintah.setString(3, jml_hidup);
            perintah.setString(4, sisa);
            perintah.setString(5, kd_kandang);
            perintah.setString(6, kd_user);
            perintah.setString(7, id_populasi);
            
            perintah.executeUpdate();
            System.out.println("update");
            
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void hapuspopulasi(String id_populasi){
        try {
           String sql = "delete from populasi where id_populasi = ?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setString(1, id_populasi);
           
           perintah.executeUpdate();
           System.out.println("deleted");
           
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void caripopulasi(String id_populasi){
        try {
            String sql = "select*from populasi where id_populasi = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, id_populasi);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID :"+data.getString("id_populasi"));
                System.out.println("Tanggal :"+data.getString("tgl_populasi"));
                System.out.println("Mati :"+data.getString("jml_mati"));
                System.out.println("Hidup :"+data.getString("jml_hidup"));
                System.out.println("Sisa :"+data.getString("sisa"));
                System.out.println("Kode :"+data.getString("kd_kandang"));
                System.out.println("Kode User :"+data.getString("kd_user"));
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void datapopulasi(){
        try {
            Statement stmt = connectionDB.createStatement();
            ResultSet baris = stmt.executeQuery("select*from populasi order by id_populasi");
            while(baris.next()){
                System.out.println(baris.getString("id_populasi")+"|"+
                        baris.getString("tgl_populasi")+"|"+
                        baris.getString("jml_mati")+"|"+
                        baris.getString("jml_hidup")+"|"+
                        baris.getString("sisa")+"|"+
                        baris.getString("kd_kandang")+"|"+
                        baris.getString("kd_user"));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
   
    // tabel produksi
    public void tambahproduksi(String id_produksi, String tgl_populasi, String jml_utuh, String jml_retak, String total, String id_populasi){
        try {
            String sql = "insert into produksi (id_produksi, tgl_populasi, jml_utuh, jml_retak, total, id_populasi) value (?,?,?,?,?,?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, id_produksi);
            perintah.setString(2, tgl_populasi);
            perintah.setString(3, jml_utuh);
            perintah.setString(4, jml_retak);
            perintah.setString(5, total);
            perintah.setString(6, id_populasi);
            
            perintah.executeUpdate();
            System.out.println("added");
            
        }
        catch (Exception e){
           System.out.println(e.getMessage()); 
        }
    }
    public void ubahproduksi(String id_produksi, String tgl_populasi, String jml_utuh, String jml_retak, String total, String id_populasi){
        try {
            String sql = "update produksi set tgl_populasi = ?, jml_utuh = ?, jml_retak = ?, total = ?, id_populasi = ? where id_produksi = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, tgl_populasi);
            perintah.setString(2, jml_utuh);
            perintah.setString(3, jml_retak);
            perintah.setString(4, total);
            perintah.setString(5, id_populasi);
            perintah.setString(6, id_produksi);
            
            perintah.executeUpdate();
            System.out.println("update");
            
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }  
    }
    public void hapusproduksi(String id_produksi){
        try {
            String sql = "delete from produksi where id_produksi = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, id_produksi);
            
            perintah.executeUpdate();
            System.out.println("deleted");
            
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
    public void cariproduksi(String id_produksi){
        try {
            String sql = "select*from produksi where id_produksi = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, id_produksi);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID Produksi :"+data.getString("id_produksi"));
                System.out.println("Tgl Populasi :"+data.getString("tgl_populasi"));
                System.out.println("Utuh :"+data.getString("jml_utuh"));
                System.out.println("Retak :"+data.getString("jml_retak"));
                System.out.println("Total :"+data.getString("total"));
                System.out.println("ID :"+data.getString("id_populasi"));    
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void dataproduksi(){
        try {
            Statement stmt = connectionDB.createStatement();
            ResultSet baris = stmt.executeQuery("select*from produksi order by id_produksi");
            while(baris.next()){
                System.out.println(baris.getString("id_produksi")+"|"+
                        baris.getString("tgl_populasi")+"|"+
                        baris.getString("jml_utuh")+"|"+
                        baris.getString("jml_retak")+"|"+
                        baris.getString("total")+"|"+
                        baris.getString("id_populasi"));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    // tabel jadwal
    public void tambahjadwal(String id_jadwal, String tgl_jadwal, String jenis, String total, String jml, String id_populasi, String kd_pakan){
       try {
           String sql = "insert into jadwal (id_jadwal, tgl_jadwal, jenis, total, jml, id_populasi, kd_pakan) value (?,?,?,?,?,?,?)";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setString(1, id_jadwal);
           perintah.setString(2, tgl_jadwal);
           perintah.setString(3, jenis);
           perintah.setString(4, total);
           perintah.setString(5, jml);
           perintah.setString(6, id_populasi);
           perintah.setString(7, kd_pakan);
           
           perintah.executeUpdate();
           System.out.println("added");
           
       }
       catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
    public void ubahjadwal(String id_jadwal, String tgl_jadwal, String jenis, String total, String jml, String id_populasi, String kd_pakan){
        try {
            String sql = "update jadwal set tgl_jadwal = ?, jenis = ?, total = ?, jml = ?, id_populasi = ?, kd_pakan = ? where id_jadwal = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, tgl_jadwal);
            perintah.setString(2, jenis);
            perintah.setString(3, total);
            perintah.setString(4, jml);
            perintah.setString(5, id_populasi);
            perintah.setString(6, kd_pakan);
            perintah.setString(7, id_jadwal);
            
            perintah.executeUpdate();
            System.out.println("update");
            
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void hapusjadwal(String id_jadwal){
        try {
            String sql = "delete from jadwal where id_jadwal = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, id_jadwal);
            
            perintah.executeUpdate();
            System.out.println("deleted");
            
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void carijadwal(String id_jadwal){
        try {
            String sql = "select*from jadwal where id_jadwal = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, id_jadwal);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID Jadwal :"+data.getString("id_jadwal"));
                System.out.println("Tgl Jadwal :"+data.getString("tgl_jadwal"));
                System.out.println("Jenis :"+data.getString("jenis"));
                System.out.println("Total :"+data.getString("total"));
                System.out.println("Jumlah :"+data.getString("jml"));
                System.out.println("ID :"+data.getString("id_populasi"));
                System.out.println("Kode Pakan :"+data.getString("kd_pakan"));
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void datajadwal(){
        try {
            Statement stmt = connectionDB.createStatement();
            ResultSet baris = stmt.executeQuery("select*from jadwal order by id_jadwal");
            while(baris.next()){
                System.out.println(baris.getString("id_jadwal")+"|"+
                        baris.getString("tgl_jadwal")+"|"+
                        baris.getString("jenis")+"|"+
                        baris.getString("total")+"|"+
                        baris.getString("jml")+"|"+
                        baris.getString("id_populasi")+"|"+
                        baris.getString("kd_pakan"));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    // tabel pakan
    public void tambahpakan(String kd_pakan, String nama_pakan, String jenis, String jml_pakan){
        try {
            String sql = "insert into pakan (kd_pakan, nama_pakan, jenis, jml_pakan) value (?,?,?,?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, kd_pakan);
            perintah.setString(2, nama_pakan);
            perintah.setString(3, jenis);
            perintah.setString(4, jml_pakan);
            
            perintah.executeUpdate();
            System.out.println("added");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void ubahpakan(String kd_pakan, String nama_pakan, String jenis, String jml_pakan){
        try {
            String sql = "update pakan set nama_pakan = ?, jenis = ?, jml_pakan = ? where kd_pakan = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, nama_pakan);
            perintah.setString(2, jenis);
            perintah.setString(3, jml_pakan);
            perintah.setString(4, kd_pakan);
            
            perintah.executeUpdate();
            System.out.println("update");
            
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void hapuspakan(String kd_pakan){
        try {
            String sql = "delete from pakan where kd_pakan = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, kd_pakan);
            
            perintah.executeUpdate();
            System.out.println("deleted");
            
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void caripakan(String kd_pakan){
        try {
            String sql = "select*from pakan where kd_pakan = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, kd_pakan);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("Kode Pakan :"+data.getString("kd_pakan"));
                System.out.println("Nama :"+data.getString("nama_pakan"));
                System.out.println("Jenis :"+data.getString("jenis"));
                System.out.println("Jumlah Pakan :"+data.getString("jml_pakan"));
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void datapakan(){
        try {
            Statement stmt = connectionDB.createStatement();
            ResultSet baris = stmt.executeQuery("select*from pakan order by kd_pakan");
            while(baris.next()){
                System.out.println(baris.getString("kd_pakan")+"|"+
                        baris.getString("nama_pakan")+"|"+
                        baris.getString("jenis")+"|"+
                        baris.getString("jml_pakan"));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
   
}
