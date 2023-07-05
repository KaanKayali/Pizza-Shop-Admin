package KaKaBWZ;

import com.google.gson.Gson;
import com.mongodb.client.*;
import org.bson.Document;

public class Datenbankverbindung {
    //Connect to MongoDB
    public MongoClient mongoClient;

    //Get the database
    public MongoDatabase database;

    //Get the collection
    public MongoCollection<Document> collectionkunde;
    public MongoCollection<Document> collectionpizza;
    public MongoCollection<Document> collectionbestellung;

    public FindIterable<Document> kunden;
    public FindIterable<Document> pizzen;
    public FindIterable<Document> bestellungen;

    //Create the document
    public Gson gson;
    public String json;
    public Document doc;



    //Konstruktor
    Datenbankverbindung(){
        //Connect to MongoDB
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("pizzaShopDb");
        collectionkunde = database.getCollection("kunde");
        collectionpizza = database.getCollection("pizza");
        collectionbestellung = database.getCollection("bestellungen");
        kunden = collectionkunde.find();
        pizzen = collectionpizza.find();
        bestellungen = collectionbestellung.find();



    }
}
