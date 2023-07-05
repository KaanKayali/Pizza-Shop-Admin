package KaKaBWZ;

import com.mongodb.Block;
import org.bson.Document;
import java.util.ArrayList;
import java.lang.String;

public class Persistence {
    public ArrayList<String> kundearrayList;
    public ArrayList<String> pizzaarrayList;
    public ArrayList<String> bestellungenarrayList;

    Persistence(){
        //Setten
        kundearrayList = new ArrayList<>();
        pizzaarrayList = new ArrayList<>();
        bestellungenarrayList = new ArrayList<>();

        //Arraylist beladen
        Datenbankverbindung datenbankverbindung = new Datenbankverbindung();

        datenbankverbindung.kunden.forEach(new Block<Document>(){
            @Override
            public void apply(final Document document) {
                kundearrayList.add(document.getString("nachname"));
            }

        });

        datenbankverbindung.pizzen.forEach(new Block<Document>(){
            @Override
            public void apply(final Document document){
                pizzaarrayList.add(document.getString("name"));
            }
        });

        datenbankverbindung.bestellungen.forEach(new Block<Document>(){
            @Override
            public void apply(final Document document){
                bestellungenarrayList.add("Kunde: " + document.getString("kunde") + "       Pizza: " + document.getString("pizza") + "      Preis: " + document.getDouble("total"));
            }
        });
    }
}
