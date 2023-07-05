package KaKaBWZ;

import KaKaBWZ.Ordner.Bestellung;
import KaKaBWZ.Ordner.Kunde;
import KaKaBWZ.Ordner.Pizza;
import com.google.gson.Gson;
import com.toedter.calendar.JDateChooser;
import org.bson.Document;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NeuerKundeGUI extends JFrame implements ActionListener {

    //Panels
    private JPanel mainPanel;

    private JPanel gridPanel;
    private JPanel nachnamePanel;
    private JPanel vornamePanel;
    private JPanel adressePanel;
    private JPanel telefonPanel;
    private JPanel emailPanel;
    private JPanel geburtsdatumPanel;

    private JPanel buttongridPanel;

    //Buttons
    private JButton bestetigenbtn;
    private JButton Clearbtn;
    private JButton Abbrechenbtn;

    //Labels
    private JLabel nachnameTextlabel;

    private JLabel vornameTextlabel;

    private JLabel AdresseTextlabel;
    private JLabel AdresseEmptyTextlabel;
    private JLabel strasseAdresseTextlabel;
    private JLabel plzAdresseTextlabel;
    private JLabel ortAdresseTextlabel;

    private JLabel emailTextlabel;

    private JLabel telefonTextlabel;

    private JLabel errorTextLabel;

    private JLabel geburtsdatumTextlabel;

    //Textfields
    private JTextField nachnameTextfield;

    private JTextField vornameTextfield;

    private ArrayList<String> adressearraylist;
    private JTextField strasseAdresseTextfield;
    private JTextField plzAdresseTextfield;
    private JTextField ortAdresseTextfield;

    private JTextField telefonTextfield;

    private JTextField emailTextfield;

    //Datum
    private JDateChooser geburtsdatumDatefield;


    //Constructor
    NeuerKundeGUI(){
        //Options
        setTitle("Kunde hinzufügen");
        setSize(450,400);
        setVisible(true);

        //Instanzieren
        mainPanel = new JPanel();

        gridPanel = new JPanel();
        nachnamePanel = new JPanel();
        vornamePanel = new JPanel();
        adressePanel = new JPanel();
        telefonPanel = new JPanel();
        emailPanel = new JPanel();
        geburtsdatumPanel = new JPanel();

        buttongridPanel = new JPanel();

        //Buttons
        bestetigenbtn = new JButton("Bestätigen");
        Clearbtn = new JButton("Clear");
        Abbrechenbtn = new JButton("Abbrechen");

        //Labels
        nachnameTextlabel = new JLabel("Nachname:");

        vornameTextlabel = new JLabel("Vorname:");

        AdresseTextlabel = new JLabel("Adresse:");
        AdresseEmptyTextlabel = new JLabel("");
        strasseAdresseTextlabel = new JLabel("Strasse:");
        plzAdresseTextlabel = new JLabel("Postleitzahl:");
        ortAdresseTextlabel = new JLabel("Ort:");

        emailTextlabel = new JLabel("E-Mail-Adresse:");

        telefonTextlabel = new JLabel("Telefon:");
        errorTextLabel = new JLabel("");

        geburtsdatumTextlabel = new JLabel("Geburtsdatum:");

        //Textfields
        nachnameTextfield = new JTextField();

        vornameTextfield = new JTextField();

        adressearraylist = new ArrayList<>();
        strasseAdresseTextfield = new JTextField();
        plzAdresseTextfield = new JTextField();
        ortAdresseTextfield = new JTextField();

        telefonTextfield = new JTextField();

        emailTextfield = new JTextField();

        //Datum
        geburtsdatumDatefield = new JDateChooser();

        //Options
        getContentPane().setLayout(new BorderLayout(5, 5));
        mainPanel.setLayout(new BorderLayout(20, 10));

        gridPanel.setLayout(new GridLayout(3,2,5,5));
        nachnamePanel.setLayout(new GridLayout(2,1,5,5));
        vornamePanel.setLayout(new GridLayout(2,1,5,5));
        adressePanel.setLayout(new GridLayout(4,2,5,5));
        telefonPanel.setLayout(new GridLayout(3,1,5,5));
        emailPanel.setLayout(new GridLayout(2,1,5,5));
        geburtsdatumPanel.setLayout(new GridLayout(2,1,5,5));

        buttongridPanel.setLayout(new GridLayout(1,3,5,5));

        //Objects
        getContentPane().add(mainPanel);
        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(buttongridPanel, BorderLayout.SOUTH);

        gridPanel.add(nachnamePanel);
        gridPanel.add(vornamePanel);
        gridPanel.add(adressePanel);
        gridPanel.add(telefonPanel);
        gridPanel.add(emailPanel);
        gridPanel.add(geburtsdatumPanel);

        nachnamePanel.add(nachnameTextlabel);
        nachnamePanel.add(nachnameTextfield);

        vornamePanel.add(vornameTextlabel);
        vornamePanel.add(vornameTextfield);

        adressePanel.add(AdresseTextlabel);
        adressePanel.add(AdresseEmptyTextlabel);
        adressePanel.add(strasseAdresseTextlabel);
        adressePanel.add(strasseAdresseTextfield);
        adressePanel.add(plzAdresseTextlabel);
        adressePanel.add(plzAdresseTextfield);
        adressePanel.add(ortAdresseTextlabel);
        adressePanel.add(ortAdresseTextfield);

        telefonPanel.add(telefonTextlabel);
        telefonPanel.add(telefonTextfield);
        telefonPanel.add(errorTextLabel);

        emailPanel.add(emailTextlabel);
        emailPanel.add(emailTextfield);

        geburtsdatumPanel.add(geburtsdatumTextlabel);
        geburtsdatumPanel.add(geburtsdatumDatefield);

        buttongridPanel.add(Abbrechenbtn);
        buttongridPanel.add(Clearbtn);
        buttongridPanel.add(bestetigenbtn);

        Abbrechenbtn.addActionListener(this);
        Clearbtn.addActionListener(this);
        bestetigenbtn.addActionListener(this);

        //Colors
        errorTextLabel.setForeground(Color.red);
        Abbrechenbtn.setBackground(Color.lightGray);
        Clearbtn.setBackground(Color.lightGray);
        bestetigenbtn.setBackground(Color.lightGray);

        Abbrechenbtn.setBorder(new LineBorder(Color.BLACK));
        Clearbtn.setBorder(new LineBorder(Color.BLACK));
        bestetigenbtn.setBorder(new LineBorder(Color.BLACK));
    }

    //Button click
    @Override
    public void actionPerformed(ActionEvent e) {
        //Neue Bestellung
        if(e.getSource() == bestetigenbtn){
                //Instanzieren
                Bestellung bestellung = new Bestellung();
                Kunde kunde = new Kunde();
                Pizza pizza = new Pizza();

            //Set object
            try {
                adressearraylist.add(strasseAdresseTextfield.getText());
                adressearraylist.add(plzAdresseTextfield.getText());
                adressearraylist.add(ortAdresseTextfield.getText());

                kunde.setNachname(nachnameTextfield.getText());
                kunde.setVorname(vornameTextfield.getText());
                kunde.setAdresse(adressearraylist);
                kunde.setTelefon(Integer.parseInt(telefonTextfield.getText()));
                kunde.setDate(geburtsdatumDatefield.getDate());

                try {
                    //Verbindung zur Datenbank erstellen
                    Datenbankverbindung datenbankverbindung = new Datenbankverbindung();

                    //Dokument erstellen
                    Gson gson = new Gson();
                    String json = gson.toJson(kunde);
                    Document doc = Document.parse(json);

                    //Hinzufügen
                    datenbankverbindung.collectionkunde.insertOne(doc);

                    //Instanzieren
                    KundenverwaltungGUI kundenverwaltungGUI = new KundenverwaltungGUI();
                    dispose();
                }
                catch(Exception exception){
                    errorTextLabel.setText("Error: No connection to Server");
                }
            }
            catch(Exception exception){
                errorTextLabel.setText("Error: Invalid input");
            }

        }

        //Admin ~ Kunden verwalten
        if(e.getSource() == Clearbtn){
            nachnameTextfield.setText("");
            vornameTextfield.setText("");

            strasseAdresseTextfield.setText("");
            plzAdresseTextfield.setText("");
            ortAdresseTextfield.setText("");

            emailTextfield.setText("");

        }

        //Admin ~ Pizzen verwalten
        if(e.getSource() == Abbrechenbtn){
            dispose();
        }
    }
}
