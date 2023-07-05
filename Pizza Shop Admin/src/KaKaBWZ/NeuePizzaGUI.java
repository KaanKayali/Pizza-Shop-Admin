package KaKaBWZ;

import KaKaBWZ.Ordner.Bestellung;
import KaKaBWZ.Ordner.Kunde;
import KaKaBWZ.Ordner.Pizza;
import com.google.gson.Gson;
import org.bson.Document;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class NeuePizzaGUI extends JFrame implements ActionListener {

    //Panels
    private JPanel mainPanel;
    private JPanel gridPanel;

    private JPanel namegridPanel;
    private JPanel zutatengridPanel;
    private JPanel einzelpreisgridPanel;
    private JPanel kcalgridPanel;
    private JPanel errorgridPanel;
    private JPanel groessegridPanel;
    private JPanel extrazutatengridPanel;
    private JPanel buttonsgridPanel;

    //Buttons
    private JButton bestaetigenbtn;
    private JButton abbrechenbtn;
    private JButton clearbtn;

    //Labels
    private JLabel nameTextLabel;

    private JLabel errorTextLabel;

    private JLabel zutatenTextLabel;

    private JLabel einzelpreisTextLabel;

    private JLabel kcalTextLabel;

    private JLabel groesseTextLabel;

    private JLabel extrazutatenTextLabel;
    private JLabel extrazutatenEmptyTextLabel;
    private JLabel extrazutatenNameTextLabel;
    private JLabel extrazutatenPreisTextLabel;

    //Textfields
    public ArrayList<String> extrazutatenarraylist;
    public JTextField nameTextfield;
    public JTextField einzelpreisTextfield;
    public JTextField kcalTextfield;
    public JTextField extrazutatenNameTextfield;
    public JTextField extrazutatenPreisTextfield;

    //Checkbox
    private ArrayList<JCheckBox> zutatenChechboxGroup;
    private ArrayList<String> alleextrazutatenarraylist;
    private JCheckBox zutatenZwiebelnCheckbox;
    private JCheckBox zutatenSalamiCheckbox;
    private JCheckBox zutatenPilzeCheckbox;
    private JCheckBox zutatenThunfischCheckbox;
    private JCheckBox zutatenOlivenCheckbox;

    private ButtonGroup groesserbGroup;
    private JRadioButton groesseSmallrb;
    private JRadioButton groesseMediumrb;
    private JRadioButton groesseLargerb;


    //Constructor
    NeuePizzaGUI() {
        //Options
        setTitle("Neue Bestellung");
        setSize(420, 470);
        setVisible(true);

        //Instanzieren
        mainPanel = new JPanel();
        gridPanel = new JPanel();

        //Panels
        namegridPanel = new JPanel();
        zutatengridPanel = new JPanel();
        einzelpreisgridPanel = new JPanel();
        kcalgridPanel = new JPanel();
        errorgridPanel = new JPanel();
        groessegridPanel = new JPanel();
        extrazutatengridPanel = new JPanel();
        buttonsgridPanel = new JPanel();

        //Buttons
        bestaetigenbtn = new JButton("Bestätigen");
        abbrechenbtn = new JButton("Abbrechen");
        clearbtn = new JButton("Clear");

        //Labels
        nameTextLabel = new JLabel("Name:");

        errorTextLabel = new JLabel("");

        zutatenTextLabel = new JLabel("Zutaten:");

        einzelpreisTextLabel = new JLabel("Einzelpreis(CHF):");

        kcalTextLabel = new JLabel("kcal (Kilokalorien):");

        groesseTextLabel = new JLabel("Grösse:");

        extrazutatenTextLabel = new JLabel("Extrazutaten");
        extrazutatenEmptyTextLabel = new JLabel("");
        extrazutatenNameTextLabel = new JLabel("Name:");
        extrazutatenPreisTextLabel = new JLabel("Preis:");

        //Textfields
        nameTextfield = new JTextField();
        einzelpreisTextfield = new JTextField();
        kcalTextfield = new JTextField();
        extrazutatenNameTextfield = new JTextField();
        extrazutatenPreisTextfield = new JTextField();

        //Checkbox
        zutatenChechboxGroup = new ArrayList<>();
        extrazutatenarraylist = new ArrayList<>();
        alleextrazutatenarraylist = new ArrayList<>();
        zutatenZwiebelnCheckbox = new JCheckBox("Zwiebeln");
        zutatenSalamiCheckbox = new JCheckBox("Salami");
        zutatenPilzeCheckbox = new JCheckBox("Pilze");
        zutatenThunfischCheckbox = new JCheckBox("Thunfisch");
        zutatenOlivenCheckbox = new JCheckBox("Oliven");

        //Radiobutton
        groesserbGroup = new ButtonGroup();
        groesseSmallrb = new JRadioButton("Small (⌀24):");
        groesseMediumrb = new JRadioButton("Medium (⌀30):", true);
        groesseLargerb = new JRadioButton("Large (⌀40):");
        groesserbGroup.add(groesseSmallrb);
        groesserbGroup.add(groesseMediumrb);
        groesserbGroup.add(groesseLargerb);

        //Options
        getContentPane().setLayout(new BorderLayout(5, 5));
        mainPanel.setLayout(new BorderLayout(20, 10));
        gridPanel.setLayout(new GridLayout(4, 2, 5, 5));

        namegridPanel.setLayout(new GridLayout(2, 1, 5, 5));
        errorgridPanel.setLayout(new GridLayout(2, 1, 5, 5));
        zutatengridPanel.setLayout(new GridLayout(6, 1, 5, 5));
        groessegridPanel.setLayout(new GridLayout(4, 1, 5, 5));
        einzelpreisgridPanel.setLayout(new GridLayout(2, 1, 5, 5));
        extrazutatengridPanel.setLayout(new GridLayout(3, 2, 5, 5));
        kcalgridPanel.setLayout(new GridLayout(2, 1, 5, 5));
        buttonsgridPanel.setLayout(new GridLayout(3, 1, 5, 5));

        //Objects
        getContentPane().add(mainPanel);
        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(buttonsgridPanel, BorderLayout.SOUTH);

        gridPanel.add(namegridPanel);
        gridPanel.add(errorgridPanel);
        gridPanel.add(zutatengridPanel);
        gridPanel.add(groessegridPanel);
        gridPanel.add(einzelpreisgridPanel);
        gridPanel.add(extrazutatengridPanel);
        gridPanel.add(kcalgridPanel);
        gridPanel.add(buttonsgridPanel);

        namegridPanel.add(nameTextLabel);
        namegridPanel.add(nameTextfield);

        errorgridPanel.add(errorTextLabel);

        zutatengridPanel.add(zutatenTextLabel);
        zutatengridPanel.add(zutatenZwiebelnCheckbox);
        zutatengridPanel.add(zutatenSalamiCheckbox);
        zutatengridPanel.add(zutatenPilzeCheckbox);
        zutatengridPanel.add(zutatenThunfischCheckbox);
        zutatengridPanel.add(zutatenOlivenCheckbox);
        zutatenChechboxGroup.add(zutatenZwiebelnCheckbox);
        zutatenChechboxGroup.add(zutatenSalamiCheckbox);
        zutatenChechboxGroup.add(zutatenPilzeCheckbox);
        zutatenChechboxGroup.add(zutatenThunfischCheckbox);
        zutatenChechboxGroup.add(zutatenOlivenCheckbox);

        groessegridPanel.add(groesseTextLabel);
        groessegridPanel.add(groesseSmallrb);
        groessegridPanel.add(groesseMediumrb);
        groessegridPanel.add(groesseLargerb);

        einzelpreisgridPanel.add(einzelpreisTextLabel);
        einzelpreisgridPanel.add(einzelpreisTextfield);

        extrazutatengridPanel.add(extrazutatenTextLabel);
        extrazutatengridPanel.add(extrazutatenEmptyTextLabel);
        extrazutatengridPanel.add(extrazutatenNameTextLabel);
        extrazutatengridPanel.add(extrazutatenNameTextfield);
        extrazutatengridPanel.add(extrazutatenPreisTextLabel);
        extrazutatengridPanel.add(extrazutatenPreisTextfield);

        kcalgridPanel.add(kcalTextLabel);
        kcalgridPanel.add(kcalTextfield);

        buttonsgridPanel.add(abbrechenbtn);
        buttonsgridPanel.add(clearbtn);
        buttonsgridPanel.add(bestaetigenbtn);
        abbrechenbtn.addActionListener(this);
        clearbtn.addActionListener(this);
        bestaetigenbtn.addActionListener(this);

        //Colors
        errorTextLabel.setForeground(Color.red);
        abbrechenbtn.setBackground(Color.lightGray);
        clearbtn.setBackground(Color.lightGray);
        bestaetigenbtn.setBackground(Color.lightGray);

        abbrechenbtn.setBorder(new LineBorder(Color.BLACK));
        clearbtn.setBorder(new LineBorder(Color.BLACK));
        bestaetigenbtn.setBorder(new LineBorder(Color.BLACK));

        //Arraylist from checkboxes
        for(JCheckBox zutatencheckboxes : zutatenChechboxGroup){
            zutatencheckboxes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (zutatencheckboxes.isSelected()) {
                        alleextrazutatenarraylist.add(zutatencheckboxes.getText());

                    }
                    else{
                        alleextrazutatenarraylist.remove(zutatencheckboxes.getText());
                    }
                }
            });
        }
    }

    //Button click
    @Override
    public void actionPerformed(ActionEvent e) {
        //Abbrechen
        if(e.getSource() == abbrechenbtn){
            //Instanzieren
            dispose();

        }

        //Clear
        if(e.getSource() == clearbtn){
            nameTextfield.setText("");
            einzelpreisTextfield.setText("");
            kcalTextfield.setText("");
            extrazutatenNameTextfield.setText("");
            extrazutatenPreisTextfield.setText("");
            groesseSmallrb.setSelected(false);
            groesseMediumrb.setSelected(true);
            groesseLargerb.setSelected(false);
            zutatenZwiebelnCheckbox.setSelected(false);
            zutatenSalamiCheckbox.setSelected(false);
            zutatenPilzeCheckbox.setSelected(false);
            zutatenThunfischCheckbox.setSelected(false);
            zutatenOlivenCheckbox.setSelected(false);

        }

        //Bestätigen
        if(e.getSource() == bestaetigenbtn){
            //Instanzieren
            Bestellung bestellung = new Bestellung();
            Kunde kunde = new Kunde();
            Pizza pizza = new Pizza();

            //Extrazutaten
            if(extrazutatenNameTextfield.getText() == "") {
                extrazutatenarraylist.add(extrazutatenNameTextfield.getText());
                extrazutatenarraylist.add(extrazutatenPreisTextfield.getText());
            }

            //Set object
            try {
                pizza.setName(nameTextfield.getText());
                if(groesseSmallrb.isSelected()){
                    pizza.setDurchmesser(24);
                    pizza.setGroesse("Small");
                }
                else if(groesseMediumrb.isSelected()){
                    pizza.setDurchmesser(30);
                    pizza.setGroesse("Medium");
                }
                else if(groesseLargerb.isSelected()){
                    pizza.setDurchmesser(40);
                    pizza.setGroesse("Large");
                }
                pizza.setZutaten(alleextrazutatenarraylist);
                pizza.setEinzelpreis(Double.parseDouble(einzelpreisTextfield.getText()));
                pizza.setKcal(Double.parseDouble(kcalTextfield.getText()));
                pizza.setExtrazutaten(extrazutatenarraylist);

                try {
                    //Verbindung zur Datenbank erstellen
                    Datenbankverbindung datenbankverbindung = new Datenbankverbindung();

                    //Dokument erstellen
                    Gson gson = new Gson();
                    String json = gson.toJson(pizza);
                    Document doc = Document.parse(json);

                    //Hinzufügen oder updaten
                    datenbankverbindung.collectionpizza.insertOne(doc);


                    //Schliessen
                    PizzaverwaltungGUI pizzaverwaltungGUI = new PizzaverwaltungGUI();
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

    }

}
