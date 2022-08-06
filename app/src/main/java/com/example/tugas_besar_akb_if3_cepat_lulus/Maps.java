package com.example.tugas_besar_akb_if3_cepat_lulus;

// nama  : fauzi fikrinullah
// nim   : 10119111
// kelas : if-3
// nama  : fakhri adi saputra
// nim   : 10119116
// kelas : if-3
// 27 juli 2022

public class Maps {
    private String title;
    private double latitude, longitude;

    public Maps() {
    }

    //constructor
    public Maps(String title, double latitude, double longitude) {
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //getter setter
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
