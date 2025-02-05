// PenitipanHewan.java
package Kode.models;

public class penitipanHewan {
    private String namaPemilik;
    private String nomorHP;
    private String alamat;
    private String namaHewan;
    private String jenisHewan;
    private String kelamin;
    private String umur;
    private String tanggalPenitipan;
    private String penginapan;
    private String keluhan;

    // Constructor
    public penitipanHewan(String namaPemilik, String nomorHP, String alamat,
            String namaHewan, String jenisHewan, String kelamin,
            String umur, String tanggalPenitipan, String penginapan, String keluhan) {
        this.namaPemilik = namaPemilik;
        this.nomorHP = nomorHP;
        this.alamat = alamat;
        this.namaHewan = namaHewan;
        this.jenisHewan = jenisHewan;
        this.kelamin = kelamin;
        this.umur = umur;
        this.tanggalPenitipan = tanggalPenitipan;
        this.penginapan = penginapan;
        this.keluhan = keluhan;
    }

    // Getters
    public String getNamaPemilik() {
        return namaPemilik;
    }

    public String getNomorHP() {
        return nomorHP;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNamaHewan() {
        return namaHewan;
    }

    public String getJenisHewan() {
        return jenisHewan;
    }

    public String getKelamin() {
        return kelamin;
    }

    public String getUmur() {
        return umur;
    }

    public String getTanggalPenitipan() {
        return tanggalPenitipan;
    }

    public String getPenginapan() {
        return penginapan;
    }

    public String getKeluhan() {
        return keluhan;
    }

    // Setters
    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public void setNomorHP(String nomorHP) {
        this.nomorHP = nomorHP;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNamaHewan(String namaHewan) {
        this.namaHewan = namaHewan;
    }

    public void setJenisHewan(String jenisHewan) {
        this.jenisHewan = jenisHewan;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public void setTanggalPenitipan(String tanggalPenitipan) {
        this.tanggalPenitipan = tanggalPenitipan;
    }

    public void setPenginapan(String penginapan) {
        this.penginapan = penginapan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }
}