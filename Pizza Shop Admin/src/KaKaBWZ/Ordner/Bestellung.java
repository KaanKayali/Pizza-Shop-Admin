package KaKaBWZ.Ordner;

import java.util.ArrayList;

public class Bestellung {
    //Variablen
    private int bestellnummer;
    private String bestelldatum;
    private String lieferadresse;
    private String kunde;
    private String pizza;
    private ArrayList<String> extrazutaten;
    private double total;

    //Getter & Setter
    public int getBestellnummer() {
        return bestellnummer;
    }

    public void setBestellnummer(int bestellnummer) {
        this.bestellnummer = bestellnummer;
    }

    public String getBestelldatum() {
        return bestelldatum;
    }

    public void setBestelldatum(String bestelldatum) {
        this.bestelldatum = bestelldatum;
    }

    public String getLieferadresse() {
        return lieferadresse;
    }

    public void setLieferadresse(String lieferadresse) {
        this.lieferadresse = lieferadresse;
    }

    public String getKunde() {
        return kunde;
    }

    public void setKunde(String kunde) {
        this.kunde = kunde;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public ArrayList<String> getExtrazutaten() {
        return extrazutaten;
    }

    public void setExtrazutaten(ArrayList<String> extrazutaten) {
        this.extrazutaten = extrazutaten;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
