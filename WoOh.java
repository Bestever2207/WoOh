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
    private final String[] essensrichtungen = {"asiatisch","italienisch","kroatisch","amerikanisch"};

    public WoOh()
    {
        UI.start();
        UI.loading_screen();

        bestellhistorie = new Bestellung[0];
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
        JComponent[] userDaten_in = UI.KoordsScreen();
        JComponent[] userDaten_false = new JComponent[5];
        JButton suchen_btn = (JButton) userDaten_in[5];

        String[] userDaten = new String[5];
        
        suchen_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ist_falsch = false;
                double[] koordinaten;

                String adresse = ((JTextField)userDaten_in[0]).getText() + " " + ((JTextField)userDaten_in[1]).getText() + " " + ((JTextField)userDaten_in[2]).getText() + " " + ((JTextField)userDaten_in[3]).getText();
                koordinaten = Entfernung.KoordsErmitteln(adresse);

                for(int i = 0;i < 5;i++)
                {
                    if(((JTextField)userDaten_in[i]).getText().isBlank())
                    {
                        userDaten_false[i] = userDaten_in[i];
                        ist_falsch = true;
                    }

                }
                if(koordinaten == null && !ist_falsch)
                {
                    for(int i = 0;i < 4;i++)
                    {
                        userDaten_false[i] = userDaten_in[i];
                        ist_falsch = true;
                    }
                }



                if(ist_falsch)
                {
                    UI.koordsScreenFalsch(userDaten_false);
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
        JComponent[] jComponent = UI.mainScreen();

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
                    UI.KeineSuchergebnisse();
                    
                }
                else
                {
                    System.out.println("Gericht wird gesucht");

                    UI.info_panel_setzen("Suche nach: " + "\"" + gesGericht + "\"");

                    Datenelement[][][] suchergebnisse = restaurants.GerichtSuchen(gesGericht);
                    if(suchergebnisse.length == 0)
                    {
                        UI.KeineSuchergebnisse();
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

                UI.info_panel_setzen("Suche nach: " + "\"" + gesRestaurant + "\"");

                if(gesRestaurant.isBlank())
                {
                    UI.KeineSuchergebnisse();
                }
                else if (istEssensrichtung(gesRestaurant))
                {
                    System.out.println("Genre wird gesucht");
                    Restaurant[] suchergebnisse_Genre = restaurants.GenreSuchen(gesRestaurant);


                    if(suchergebnisse_Genre.length == 0)
                    {
                        UI.KeineSuchergebnisse();
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
                        UI.KeineSuchergebnisse();
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
        for (String s : essensrichtungen) {
            if (s.toLowerCase().equals(input.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

        
    public void gerichteAusgeben(Datenelement[][][] suchergebnisse_gerichte,String gesGericht)
    {
        int anzahl_ergebnisse = 0;
        for (Datenelement[][] datenelements : suchergebnisse_gerichte) {
            anzahl_ergebnisse += datenelements[0].length;
            //for(int e = 0; e < suchergebnisse_gerichte[r][0])
        }
        double[] lieferzeiten = new double[anzahl_ergebnisse];

        int index = 0;
        for(int r = 0;r < suchergebnisse_gerichte.length;r++)
        {
            for(int s = 0; s < suchergebnisse_gerichte[r][0].length;s++)
            {
                lieferzeiten[index] = Lieferdaten.LieferzeitBerechnen(suchergebnisse_gerichte[r][0][s].dauerGeben(), user.getKoordinaten(), suchergebnisse_gerichte[r][1][0].getKoordinaten());
                index++;
            }
        }

        System.out.println(suchergebnisse_gerichte[0][1][0].getName());
        System.out.println(suchergebnisse_gerichte[1][1][0].getName());

        JComponent[] components = UI.gerichteAusgeben(suchergebnisse_gerichte,lieferzeiten,true);

        index = 0;
        for (Datenelement[][] datenelements : suchergebnisse_gerichte) {
            for (int s = 0; s < datenelements[0].length; s++) {
                JButton main_btn = (JButton) components[index];
                Datenelement restaurant = datenelements[1][0];
                main_btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        speisekarteAusgeben(restaurant);
                    }
                });

                index++;

                JButton btn_plus = (JButton) components[index];
                Datenelement[] gerichtDaten = new Datenelement[]{datenelements[0][s], restaurant};
                double lieferzeit = lieferzeiten[index/2];
                btn_plus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gericht_warenkorbhinzufuegen(gerichtDaten,lieferzeit);
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
        JComponent[] components = UI.restaurantsAusgeben(suchergebnisse_restaurants,lieferzeiten);

        for (JComponent component : components) {
            ((JButton) component).addActionListener(new ActionListener() {
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

        double[] lieferzeiten = new double[anzahl_ergebnisse];

        int index = 0;


        for(int s = 0; s < suchergebnis[0][0].length;s++)
        {
            lieferzeiten[index] = Lieferdaten.LieferzeitBerechnen(suchergebnis[0][0][s].dauerGeben(), user.getKoordinaten(), suchergebnis[0][1][0].getKoordinaten());
            index++;
        }


        JComponent[] components = UI.gerichteAusgeben(suchergebnis,lieferzeiten,false);
        UI.info_panel_setzen("Speisekarte von " + "\"" + restaurant.getName() + "\"");

        for(int i = 0;i < components.length;i++)
        {
            Datenelement[] gerichtDaten = new Datenelement[]{speisekarte[i],restaurant};
            double lieferzeit = lieferzeiten[i];
            ((JButton)components[i]).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gericht_warenkorbhinzufuegen(gerichtDaten,lieferzeit);
                }
            });
        }
    }

    public void gericht_warenkorbhinzufuegen(Datenelement[] gerichtDaten, double lieferzeit)
    {
        warenkorb.gerichthinzufuegen((Gericht) gerichtDaten[0],lieferzeit);
    }

    public void Warenkorb_erstellen()
    {
        warenkorb = new Bestellung();
    }
    public void Warenkorb_anzeigen()
    {
        JComponent[] components = UI.Warenkorb(warenkorb);

        ((JButton)components[0]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainScreen();
            }
        });

        ((JButton)components[1]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(warenkorb.getPreis() <= user.getGuthaben())
                {
                    user.GuthabenAbziehen(warenkorb.getPreis());

                    warenkorb.akt_zeit_speichern();

                    Bestellung[] neuesArray_bestellhistorie = new Bestellung[bestellhistorie.length + 1];
                    System.arraycopy(bestellhistorie, 0, neuesArray_bestellhistorie, 0, bestellhistorie.length);
                    neuesArray_bestellhistorie[bestellhistorie.length] = warenkorb;
                    bestellhistorie = neuesArray_bestellhistorie;

                    Warenkorb_erstellen();
                    Warenkorb_anzeigen();
                }
                else
                {
                    UI.kein_geld();
                }
            }
        });


    }
    public void Bestellhistorie()
    {
        JComponent[] components = UI.Bestellhistorie(bestellhistorie);

        ((JButton)components[0]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainScreen();
            }
        });
    }
    public void Guthaben()
    {
        JComponent[] components = UI.Guthaben(user.getGuthaben());

        ((JButton)components[0]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainScreen();
            }
        });

        ((JButton)components[1]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String betrag = ((JTextField)components[2]).getText();

                try{
                    double betrag_zahl = Double.parseDouble(betrag);
                    user.GuthabenAufladen(betrag_zahl);
                    Guthaben();
                }
                catch (NumberFormatException r)
                {
                    System.out.println("keine Zahlen eingegeben");
                    UI.falsches_format();
                }

            }
        });
    }
}
