package KaKaBWZ;

import KaKaBWZ.Ordner.Bestellung;

import org.bson.Document;
import org.bson.conversions.Bson;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.google.gson.Gson;

import static com.mongodb.client.model.Filters.eq;

public class NeueBestellungenGUI extends JFrame implements ActionListener {

    //Panels
    private JPanel mainPanel;
    private JPanel bestellnummerPanel;
    private JPanel bestelldatumPanel;
    private JPanel lieferadressePanel;
    private JPanel kundePanel;
    private JPanel pizzaPanel;
    private JPanel amountPanel;
    private JPanel extrazutatenPanel;
    private JPanel totalPanel;
    private JPanel buttonPanel;

    //Buttons
    private JButton abbrechenbtn;
    private JButton bestetigenbtn;

    //Labels
    private JLabel bestellnummerTextlabel;
    private JLabel bestelldatumTextlabel;
    private JLabel lieferadresseTextlabel;
    private JLabel kundeTextlabel;
    private JLabel pizzaTextlabel;
    private JLabel amountTextlabel;

    private JLabel extrazutatenTextlabel;

    private JLabel errorTextlabel;

    private JLabel totalTextlabel;

    //Textfields
    private JTextField bestellnummerTextfield;
    private JTextField bestelldatumTextfield;
    private JTextField lieferadresseTextfield;
    private JTextField totalTextfield;

    //Spinner
    private SpinnerModel pizzaamountmodel;
    private JSpinner pizzaamount;

    //Checkbox
    private ArrayList<JCheckBox> extrazutatenarraylist;
    private ArrayList<String> alleextrazutatenarraylist;
    private JCheckBox extrazutatenZwiebelnCheckbox;
    private JCheckBox extrazutatenSalamiCheckbox;
    private JCheckBox extrazutatenPilzeCheckbox;
    private JCheckBox extrazutatenThunfischCheckbox;
    private JCheckBox extrazutatenOlivenCheckbox;

    //Combobox
    private JComboBox kundenCombobox;
    private JComboBox pizzenCombobox;

    //Total
    public double total;

    //Constructor
    NeueBestellungenGUI(){
        //Options
        setTitle("Neue Bestellung");
        setSize(350,430);
        setVisible(true);

        //Instanzieren
        mainPanel = new JPanel();
        bestellnummerPanel = new JPanel();
        bestelldatumPanel = new JPanel();
        lieferadressePanel = new JPanel();
        kundePanel = new JPanel();
        pizzaPanel = new JPanel();
        amountPanel = new JPanel();
        extrazutatenPanel = new JPanel();
        totalPanel = new JPanel();
        buttonPanel = new JPanel();

        //Buttons
        abbrechenbtn = new JButton("Abbrechen");
        bestetigenbtn = new JButton("Bestätigen");

        //Labels
        bestellnummerTextlabel = new JLabel("Bestellnummer:");
        bestelldatumTextlabel = new JLabel("Bestelldatum:");
        lieferadresseTextlabel = new JLabel("Lieferadresse:");
        kundeTextlabel = new JLabel("Kunde auswählen:");
        pizzaTextlabel = new JLabel("Pizza auswählen:");
        amountTextlabel = new JLabel("Anzahl Pizzen:");

        extrazutatenTextlabel = new JLabel("Extrazutaten:");

        errorTextlabel = new JLabel("");

        totalTextlabel = new JLabel("Total(CHF):");

        //Textfields
        bestellnummerTextfield = new JTextField();
        bestelldatumTextfield = new JTextField();
        lieferadresseTextfield = new JTextField();
        totalTextfield = new JTextField();

        //Spinner
        pizzaamountmodel = new SpinnerNumberModel(1, 1, 20, 1);
        pizzaamount = new JSpinner();
        pizzaamount.setModel(pizzaamountmodel);

        //Checkbox
        extrazutatenarraylist = new ArrayList<>();
        alleextrazutatenarraylist = new ArrayList<>();
        extrazutatenZwiebelnCheckbox = new JCheckBox("extra Zwiebeln");
        extrazutatenSalamiCheckbox = new JCheckBox("extra Salami");
        extrazutatenPilzeCheckbox = new JCheckBox("extra Pilze");
        extrazutatenThunfischCheckbox = new JCheckBox("extra Thunfisch");
        extrazutatenOlivenCheckbox = new JCheckBox("extra Oliven");

        //Combobox
        Persistence persistence = new Persistence();
        kundenCombobox = new JComboBox<>(persistence.kundearrayList.toArray(new String[0]));
        pizzenCombobox = new JComboBox<>(persistence.pizzaarrayList.toArray(new String[0]));

        //Totalberechnung
        Datenbankverbindung datenbankverbindung = new Datenbankverbindung();
        Bson filter = eq("name", pizzenCombobox.getSelectedItem().toString());
        total = (datenbankverbindung.collectionpizza.find(filter).first().getDouble("einzelpreis")) * ((Integer) pizzaamount.getValue());

        //Options
        getContentPane().setLayout(new BorderLayout(5, 5));
        mainPanel.setLayout(new GridLayout(5, 2));
        bestellnummerPanel.setLayout(new GridLayout(2, 1));
        bestelldatumPanel.setLayout(new GridLayout(2, 1));
        lieferadressePanel.setLayout(new GridLayout(2, 1));
        kundePanel.setLayout(new GridLayout(2, 1));
        pizzaPanel.setLayout(new GridLayout(2, 1));
        extrazutatenPanel.setLayout(new GridLayout(6, 1));
        totalPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.setLayout(new GridLayout(2, 1));

        bestellnummerTextfield.setEnabled(false);
        bestellnummerTextfield.setText(String.valueOf((int) (Math.random() * (99999999 - 10000000 + 1) + 10000000)));

        bestelldatumTextfield.setEnabled(true);
        bestelldatumTextfield.setText(String.valueOf(java.time.LocalDate.now()));

        totalTextfield.setEnabled(false);
        totalTextfield.setText(String.valueOf(total));


        //Objects
        getContentPane().add(mainPanel);
        mainPanel.add(bestellnummerPanel);
        mainPanel.add(bestelldatumPanel);
        mainPanel.add(kundePanel);
        mainPanel.add(lieferadressePanel);
        mainPanel.add(pizzaPanel);
        mainPanel.add(amountPanel);
        mainPanel.add(extrazutatenPanel);
        mainPanel.add(errorTextlabel);
        mainPanel.add(totalPanel);
        mainPanel.add(buttonPanel);

        bestellnummerPanel.add(bestellnummerTextlabel);
        bestellnummerPanel.add(bestellnummerTextfield);

        bestelldatumPanel.add(bestelldatumTextlabel);
        bestelldatumPanel.add(bestelldatumTextfield);

        lieferadressePanel.add(lieferadresseTextlabel);
        lieferadressePanel.add(lieferadresseTextfield);

        kundePanel.add(kundeTextlabel);
        kundePanel.add(kundenCombobox);

        pizzaPanel.add(pizzaTextlabel);
        pizzaPanel.add(pizzenCombobox);

        amountPanel.add(amountTextlabel);
        amountPanel.add(pizzaamount);

        extrazutatenPanel.add(extrazutatenTextlabel);
        extrazutatenPanel.add(extrazutatenZwiebelnCheckbox);
        extrazutatenPanel.add(extrazutatenSalamiCheckbox);
        extrazutatenPanel.add(extrazutatenPilzeCheckbox);
        extrazutatenPanel.add(extrazutatenThunfischCheckbox);
        extrazutatenPanel.add(extrazutatenOlivenCheckbox);
        extrazutatenarraylist.add(extrazutatenZwiebelnCheckbox);
        extrazutatenarraylist.add(extrazutatenSalamiCheckbox);
        extrazutatenarraylist.add(extrazutatenPilzeCheckbox);
        extrazutatenarraylist.add(extrazutatenThunfischCheckbox);
        extrazutatenarraylist.add(extrazutatenOlivenCheckbox);

        totalPanel.add(totalTextlabel);
        totalPanel.add(totalTextfield);

        abbrechenbtn.addActionListener(this);
        bestetigenbtn.addActionListener(this);

        buttonPanel.add(abbrechenbtn);
        buttonPanel.add(bestetigenbtn);

        //Colors
        errorTextlabel.setForeground(Color.red);
        abbrechenbtn.setBackground(Color.lightGray);
        bestetigenbtn.setBackground(Color.lightGray);

        abbrechenbtn.setBorder(new LineBorder(Color.BLACK));
        bestetigenbtn.setBorder(new LineBorder(Color.BLACK));

        //Everytime when an item from combobox gets selected
        pizzenCombobox.addActionListener(event -> {
            //Akutalisieren
            Bson bsonfilter = eq("name", pizzenCombobox.getSelectedItem().toString());
            total = (datenbankverbindung.collectionpizza.find(bsonfilter).first().getDouble("einzelpreis")) * ((Integer) pizzaamount.getValue());
            totalTextfield.setText(String.valueOf(total));
        });

        //Everytime when an itme from spinner gets selected
        pizzaamount.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //Akutalisieren
                Bson bsonfilter = eq("name", pizzenCombobox.getSelectedItem().toString());
                total = (datenbankverbindung.collectionpizza.find(bsonfilter).first().getDouble("einzelpreis")) * ((Integer) pizzaamount.getValue());
                totalTextfield.setText(String.valueOf(total));
            }
        });

        //Arraylist from checkboxes
        for(JCheckBox extrazutatencheckboxes : extrazutatenarraylist){
            extrazutatencheckboxes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (extrazutatencheckboxes.isSelected()) {
                        alleextrazutatenarraylist.add(extrazutatencheckboxes.getText());

                    }
                    else{
                        alleextrazutatenarraylist.remove(extrazutatencheckboxes.getText());
                    }
                }
            });
        }
    }

    //Button click
    @Override
    public void actionPerformed(ActionEvent e) {
        //Neue Bestellung
        if(e.getSource() == abbrechenbtn){
            dispose();
        }

        //Admin ~ Kunden verwalten
        if(e.getSource() == bestetigenbtn) {
            //Instanzieren
            Bestellung bestellung = new Bestellung();

            //Set object
            try {
                bestellung.setBestellnummer(Integer.parseInt(bestellnummerTextfield.getText()));
                bestellung.setBestelldatum(bestelldatumTextfield.getText());
                bestellung.setLieferadresse(lieferadresseTextfield.getText());
                bestellung.setKunde(kundenCombobox.getSelectedItem().toString());
                bestellung.setPizza(pizzenCombobox.getSelectedItem().toString());
                bestellung.setExtrazutaten(alleextrazutatenarraylist);
                bestellung.setTotal(Double.parseDouble(totalTextfield.getText()));

                try {
                    //Verbindung zur Datenbank erstellen
                    Datenbankverbindung datenbankverbindung = new Datenbankverbindung();

                    //Dokument erstellen
                    Gson gson = new Gson();
                    String json = gson.toJson(bestellung);
                    Document doc = Document.parse(json);

                    //Dokument hinzufügen
                    datenbankverbindung.collectionbestellung.insertOne(doc);

                    //Schliessen
                    BestellungverwaltungGUI bestellungverwaltungGUI = new BestellungverwaltungGUI();
                    dispose();
                }
                catch(Exception exception){
                    errorTextlabel.setText("Error: No connection to Server");
                }
            }
            catch(Exception exception){
                errorTextlabel.setText("Error: Invalid input");
            }
        }
    }
}

