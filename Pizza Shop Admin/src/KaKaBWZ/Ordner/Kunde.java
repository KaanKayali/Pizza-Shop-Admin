package KaKaBWZ.Ordner;

import java.util.ArrayList;
import java.util.Date;

public class Kunde {
    //Variablen
    private String nachname;
    private String vorname;
    private ArrayList<String> adresse;
    private int telefon;
    private String email;
    private Date date;

    //Getter & Setter
    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public ArrayList<String> getAdresse() {
        return adresse;
    }

    public void setAdresse(ArrayList<String> adresse) {
        this.adresse = adresse;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
