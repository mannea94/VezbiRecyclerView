package com.example.manne.vezbirecyclerview.Model;

/**
 * Created by manne on 13.12.2017.
 */

public class Student {
    public String ime;
    public String prezime;
    public String photoUrl;
    public boolean isActive=true;

    public Student(){

    }

    public Student(String ime, String prezime, String photoUrl, boolean isActive) {
        this.ime = ime;
        this.prezime = prezime;
        this.photoUrl = photoUrl;
        this.isActive = isActive;
    }
}
