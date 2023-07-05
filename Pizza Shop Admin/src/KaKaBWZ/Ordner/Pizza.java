package KaKaBWZ.Ordner;

import java.util.ArrayList;

public class Pizza {
    //Variablen
    private String name;
    private ArrayList<String> zutaten;
    private double einzelpreis;
    private double kcal;
    private double durchmesser;
    private String groesse;
    private ArrayList<String> extrazutaten;

    //Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getZutaten() {
        return zutaten;
    }

    public void setZutaten(ArrayList<String> zutaten) {
        this.zutaten = zutaten;
    }

    public double getEinzelpreis() {
        return einzelpreis;
    }

    public void setEinzelpreis(double einzelpreis) {
        this.einzelpreis = einzelpreis;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public double getDurchmesser() {
        return durchmesser;
    }

    public void setDurchmesser(double durchmesser) {
        this.durchmesser = durchmesser;
    }

    public String getGroesse() {
        return groesse;
    }

    public void setGroesse(String groesse) {
        this.groesse = groesse;
    }

    public ArrayList<String> getExtrazutaten() {
        return extrazutaten;
    }

    public void setExtrazutaten(ArrayList<String> extrazutaten) {
        this.extrazutaten = extrazutaten;
    }
}
