import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class WoOh
{
    private User user;

    private Baum restaurants;
    private Bestellung warenkorb;
    private Bestellung[] bestellhistorie;
    private final String[] essensrichtungen = {"asiatisch","italienisch","kroatisch"};

    public WoOh()
    {
        Ui.start();
        Ui.loading_screen();
        RestaurantsEinfuegen();
        Warenkorb_erstellen();

        KoordsSetzen();

        //mainScreen();

    }
    public void RestaurantsEinfuegen()
    {
        restaurants = CsvReader.RestaurantsGeben(new File("Restaurants.csv"));
    }


    public void KoordsSetzen()
    {
        JComponent[] userDaten_in = Ui.KoordsScreen();
        JComponent[] userDaten_false = new JComponent[4];
        JButton suchen_btn = (JButton) userDaten_in[5];

        String[] userDaten = new String[5];
        
        suchen_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ist_falsch = false;
                for(int i = 0;i < 5;i++)
                {
                    if(((JTextField)userDaten_in[i]).getText().isBlank())
                    {
                        userDaten_false[i] = userDaten_in[i];
                        ist_falsch = true;
                    }
                    
                    userDaten[i] = ((JTextField)userDaten_in[i]).getText();
                }
                
                
                if(ist_falsch)
                {
                    Ui.koordsScreenFalsch(userDaten_false);    
                }
                
                
                String adresse = userDaten[0] + " " + userDaten[1] + " " + userDaten[2] + " " + userDaten[3];

                double[] koordinaten;

                koordinaten = Entfernung.KoordsErmitteln(adresse);
                if(koordinaten == null)
                {

                }
                else
                {
                    System.out.println(koordinaten[0] + " " + koordinaten[1]);
                    user = new User(adresse, koordinaten, userDaten[4]);
                    mainScreen();
                }
            }
        });

    }


    public void mainScreen()
    {
        JComponent[] jComponent = Ui.mainScreen();

        JTextField gerichte_in = (JTextField)jComponent[0];
        JTextField restaurants_in = (JTextField)jComponent[1];
        JButton suchen_btn_gericht = (JButton)jComponent[2];
        JButton suchen_btn_restaurant = (JButton)jComponent[3];
        JButton geld_btn = (JButton)jComponent[4];
        JButton bestellhistorie_btn = (JButton)jComponent[5];
        JButton warenkorb_btn = (JButton)jComponent[6];
        JComboBox sortieren_nach = (JComboBox)jComponent[7];

        suchen_btn_gericht.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gesGericht = gerichte_in.getText();
                if(gesGericht.isBlank())
                {
                    Ui.KeineSuchergebnisse();
                    
                }
                else
                {
                    System.out.println("Gericht wird gesucht");

                    Ui.info_panel_setzen("Suche nach: " + "\"" + gesGericht + "\"");

                    Datenelement[][][] suchergebnisse = restaurants.GerichtSuchen(gesGericht);
                    if(suchergebnisse.length == 0)
                    {
                        Ui.KeineSuchergebnisse();
                    }
                    else {
                        gerichteAusgeben(suchergebnisse,gesGericht);
                    }
                }
            }
        });

        suchen_btn_restaurant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gesRestaurant = restaurants_in.getText();

                Ui.info_panel_setzen("Suche nach: " + "\"" + gesRestaurant + "\"");

                if(gesRestaurant.isBlank())
                {
                    Ui.KeineSuchergebnisse();
                }
                else if (istEssensrichtung(gesRestaurant))
                {
                    System.out.println("Genre wird gesucht");
                    Restaurant[] suchergebnisse_Genre = restaurants.GenreSuchen(gesRestaurant);


                    if(suchergebnisse_Genre.length == 0)
                    {
                        Ui.KeineSuchergebnisse();
                    }
                    else
                    {
                        restaurantsAusgeben(suchergebnisse_Genre,gesRestaurant);
                    }
                }
                else
                {
                    System.out.println("Restaurant wird gesucht");
                    Restaurant[] suchergebnis_restaurant = new Restaurant[]{(Restaurant) restaurants.RestaurantSuchen(gesRestaurant)};
                    if(suchergebnis_restaurant[0] == null)
                    {
                        Ui.KeineSuchergebnisse();
                    }
                    else
                    {
                        restaurantsAusgeben(suchergebnis_restaurant,gesRestaurant);
                    }
                }
            }
        });

        geld_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Guthaben();
            }
        });

        warenkorb_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Warenkorb_anzeigen();
            }
        });

        bestellhistorie_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bestellhistorie();
            }
        });
    }

    public boolean istEssensrichtung(String input)
    {
        boolean istEssensr = false;
        for(int i = 0; i < essensrichtungen.length; i++)
        {
            if(essensrichtungen[i].equals(input))
            {
                istEssensr = true;
            }
        }
        return istEssensr;
    }

        
    public void gerichteAusgeben(Datenelement[][][] suchergebnisse_gerichte,String gesGericht)
    {
        int anzahl_ergebnisse = 0;
        for(int i = 0;i < suchergebnisse_gerichte.length;i++)
        {
            anzahl_ergebnisse += suchergebnisse_gerichte[i][0].length;
            //for(int e = 0; e < suchergebnisse_gerichte[r][0])
        }
        int[] lieferzeiten = new int[anzahl_ergebnisse];

        int index = 0;
        for(int r = 0;r < anzahl_ergebnisse;r++)
        {
            for(int s = 0; s < suchergebnisse_gerichte[r][0].length;s++)
            {
                lieferzeiten[index] = Lieferdaten.LieferzeitBerechnen(suchergebnisse_gerichte[r][0][s].dauerGeben(), user.getKoordinaten(), suchergebnisse_gerichte[r][1][0].getKoordinaten());
                index++;
            }
        }

        System.out.println(suchergebnisse_gerichte[0][1][0].getName());
        System.out.println(suchergebnisse_gerichte[1][1][0].getName());

        JComponent[] components = Ui.gerichteAusgeben(suchergebnisse_gerichte,lieferzeiten,true);

        index = 0;
        for(int r = 0; r < suchergebnisse_gerichte.length;r++)
        {
            for(int s = 0;s < suchergebnisse_gerichte[r][0].length;s++)
            {
                JButton main_btn = (JButton) components[index];
                Datenelement restaurant = suchergebnisse_gerichte[r][1][0];
                main_btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        speisekarteAusgeben(restaurant);
                    }
                });

                index++;

                JButton btn_plus = (JButton) components[index];
                Datenelement[] gerichtDaten = new Datenelement[]{suchergebnisse_gerichte[r][0][s],restaurant};

                btn_plus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        gericht_warenkorbhinzufügen(gerichtDaten);
                    }
                });
                index++;
            }
        }
    }

    public void restaurantsAusgeben(Restaurant[] suchergebnisse_restaurants,String gesRestaurant)
    {
        double[] lieferzeiten = new double[suchergebnisse_restaurants.length];

        for(int i = 0;i < suchergebnisse_restaurants.length;i++)
        {
            lieferzeiten[i] = Lieferdaten.LieferzeitBerechnen(suchergebnisse_restaurants[i].dauerGeben(),user.getKoordinaten(),suchergebnisse_restaurants[i].getKoordinaten());
        }
        JComponent[] components = Ui.restaurantsAusgeben(suchergebnisse_restaurants,lieferzeiten);

        for(int i = 0;i < components.length;i++)
        {
            ((JButton) components[i]).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    speisekarteAusgeben(suchergebnisse_restaurants[0]);
                }
            });
        }
    }



    public void speisekarteAusgeben(Datenelement restaurant)
    {
        Gericht[] speisekarte = restaurant.GerichtinspeisekarteSuchen("");
        Datenelement[][][] suchergebnis = new Datenelement[][][]{new Datenelement[][]{speisekarte,new Restaurant[]{(Restaurant) restaurant}}};

        int anzahl_ergebnisse = speisekarte.length;

        int[] lieferzeiten = new int[anzahl_ergebnisse];

        int index = 0;


        for(int s = 0; s < suchergebnis[0][0].length;s++)
        {
            lieferzeiten[index] = Lieferdaten.LieferzeitBerechnen(suchergebnis[0][0][s].dauerGeben(), user.getKoordinaten(), suchergebnis[0][1][0].getKoordinaten());
            index++;
        }


        JComponent[] components = Ui.gerichteAusgeben(suchergebnis,lieferzeiten,false);
        Ui.info_panel_setzen("Speisekarte von " + "\"" + restaurant.getName() + "\"");

        for(int i = 0;i < components.length;i++)
        {
            Datenelement[] gerichtDaten = new Datenelement[]{speisekarte[i],restaurant};
            ((JButton)components[i]).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gericht_warenkorbhinzufügen(gerichtDaten);
                }
            });
        }
    }

    public void gericht_warenkorbhinzufügen(Datenelement[] gerichtDaten)
    {
        warenkorb.gerichthinzufuegen((Gericht) gerichtDaten[0]);
    }

    public void Warenkorb_erstellen()
    {
        warenkorb = new Bestellung();
    }
    public void Warenkorb_anzeigen()
    {

    }
    public void Bestellhistorie()
    {

    }
    public void Guthaben()
    {

    }

}
