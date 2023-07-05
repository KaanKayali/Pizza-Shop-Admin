package KaKaBWZ;

import org.bson.Document;
import org.bson.conversions.Bson;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.mongodb.client.model.Filters.eq;

public class PizzaverwaltungGUI extends JFrame implements ActionListener {

    //Datenbank
    Datenbankverbindung datenbankverbindung;

    //Panels
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel secondbuttonPanel;

    //Buttons
    private JButton abbrechenbtn;
    private JButton pizzahinzubtn;
    private JButton pizzaupdatebtn;
    private JButton pizzaloschenbn;

    //Labels
    private JLabel pizzalistTextlabel;
    private JLabel errorTextlabel;

    //Labels
    public JList pizzaList;

    //Constructor
    PizzaverwaltungGUI(){
        //Options
        setTitle("Pizza verwalten");
        setSize(480,320);
        setVisible(true);

        //Instanzieren
        Persistence persistence = new Persistence();
        datenbankverbindung = new Datenbankverbindung();
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        secondbuttonPanel = new JPanel();
        pizzahinzubtn = new JButton("Pizza hinzufügen");
        pizzaupdatebtn = new JButton("Pizza updaten");
        pizzaloschenbn = new JButton("Pizza löschen");
        abbrechenbtn = new JButton("Abbrechen");

        pizzalistTextlabel = new JLabel("Pizzen:");
        errorTextlabel = new JLabel("");

        //Pizzen in JList anzeigen
        pizzaList = new JList<>(persistence.pizzaarrayList.toArray(new String[0]));

        //Options
        getContentPane().setLayout(new BorderLayout(5, 5));
        mainPanel.setLayout(new BorderLayout(20, 10));
        buttonPanel.setLayout(new GridLayout(4, 1, 5, 5));
        secondbuttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        pizzahinzubtn.addActionListener(this);
        pizzaupdatebtn.addActionListener(this);
        pizzaloschenbn.addActionListener(this);
        abbrechenbtn.addActionListener(this);

        //Objects
        getContentPane().add(mainPanel);
        mainPanel.add(buttonPanel, BorderLayout.EAST);
        mainPanel.add(pizzaList, BorderLayout.CENTER);
        mainPanel.add(secondbuttonPanel, BorderLayout.SOUTH);
        mainPanel.add(pizzalistTextlabel, BorderLayout.NORTH);
        buttonPanel.add(pizzahinzubtn);
        buttonPanel.add(pizzaupdatebtn);
        buttonPanel.add(pizzaloschenbn);
        secondbuttonPanel.add(abbrechenbtn);
        secondbuttonPanel.add(errorTextlabel);

        //Colors
        errorTextlabel.setForeground(Color.red);
        abbrechenbtn.setBackground(Color.lightGray);
        pizzahinzubtn.setBackground(Color.lightGray);
        pizzaupdatebtn.setBackground(Color.lightGray);
        pizzaloschenbn.setBackground(Color.lightGray);

        pizzahinzubtn.setBorder(new LineBorder(Color.BLACK));
        pizzaupdatebtn.setBorder(new LineBorder(Color.BLACK));
        pizzaloschenbn.setBorder(new LineBorder(Color.BLACK));
        abbrechenbtn.setBorder(new LineBorder(Color.BLACK));
        pizzaList.setBorder(new LineBorder(Color.BLACK));

    }

    //Button click
    @Override
    public void actionPerformed(ActionEvent e) {
        //Pizza hinzufügen
        if(e.getSource() == pizzahinzubtn){
            //Instanzieren
            NeuePizzaGUI neuePizzaGUI = new NeuePizzaGUI();
            dispose();
        }

        //Pizza updaten
        if(e.getSource() == pizzaupdatebtn){
            //Selektieren
            if (pizzaList.getSelectedIndex() != -1) {
                //Reseting error
                errorTextlabel.setText("");

                //Connect to MongoDB
                datenbankverbindung = new Datenbankverbindung();

                //Abrufen des aktuellen kundennamen
                NeuePizzaGUI neuePizzaGUI = new NeuePizzaGUI();
                Bson filter = eq("name", pizzaList.getSelectedValue());
                neuePizzaGUI.nameTextfield.setText(datenbankverbindung.collectionpizza.find(filter).first().getString("name"));
                neuePizzaGUI.einzelpreisTextfield.setText(String.valueOf(datenbankverbindung.collectionpizza.find(filter).first().getDouble("einzelpreis")));
                neuePizzaGUI.kcalTextfield.setText(String.valueOf(datenbankverbindung.collectionpizza.find(filter).first().getDouble("kcal")));
                neuePizzaGUI.extrazutatenNameTextfield.setText("");
                neuePizzaGUI.extrazutatenPreisTextfield.setText("");

                //Schliessen
                dispose();

            }
            else{
                errorTextlabel.setText("Error: Nichts selektiert");
            }
        }

        //Pizza löschen
        if(e.getSource() == pizzaloschenbn){
            //löschen
            if (pizzaList.getSelectedIndex() != -1) {
                //Reseting error
                errorTextlabel.setText("");

                //Connect to MongoDB
                datenbankverbindung = new Datenbankverbindung();

                //Abrufen des aktuellen kundennamen
                String pizzaName = (String) pizzaList.getSelectedValue();
                datenbankverbindung.collectionpizza.deleteOne(new Document("name", pizzaName));

                //Datenbank aktualisieren
                Persistence persistence = new Persistence();
                dispose();
                PizzaverwaltungGUI pizzaverwaltungGUI = new PizzaverwaltungGUI();


            }
            else {
                errorTextlabel.setText("Error: Nichts selektiert");
            }
        }

        //Abbrechen
        if(e.getSource() == abbrechenbtn){
            //Close
            dispose();
        }
    }
}
