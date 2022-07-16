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
        restaurants_einfuegen();
        warenkorb_erstellen();

        koords_setzen();


    }
    public void restaurants_einfuegen()
    {
        restaurants = CsvReader.restaurants_geben(new File("Restaurants.csv"));
    }


    public void koords_setzen()
    {
        JComponent[] userDaten_in = UI.koords_screen();
        JComponent[] userDaten_false = new JComponent[5];
        JButton suchen_btn = (JButton) userDaten_in[5];

        String[] userDaten = new String[5];
        
        suchen_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ist_falsch = false;
                double[] koordinaten;

                String adresse = ((JTextField)userDaten_in[0]).getText() + " " + ((JTextField)userDaten_in[1]).getText() + " " + ((JTextField)userDaten_in[2]).getText() + " " + ((JTextField)userDaten_in[3]).getText();
                koordinaten = Entfernung.koords_ermitteln(adresse);

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
                    UI.koords_screen_falsch(userDaten_false);
                }
                else
                {
                    System.out.println(koordinaten[0] + " " + koordinaten[1]);
                    user = new User(adresse, koordinaten, userDaten[4]);
                    main_screen();
                }
            }
        });

    }


    public void main_screen()
    {
        JComponent[] jComponent = UI.main_screen();

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
                    UI.keine_suchergebnisse();
                    
                }
                else
                {
                    System.out.println("Gericht wird gesucht");

                    UI.info_panel_setzen("Suche nach: " + "\"" + gesGericht + "\"");

                    Datenelement[][][] suchergebnisse = restaurants.gericht_suchen(gesGericht);
                    if(suchergebnisse.length == 0)
                    {
                        UI.keine_suchergebnisse();
                    }
                    else {
                        gerichte_ausgeben(suchergebnisse,gesGericht);
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
                    UI.keine_suchergebnisse();
                }
                else if (ist_essensrichtung(gesRestaurant))
                {
                    System.out.println("Genre wird gesucht");
                    Restaurant[] suchergebnisse_Genre = restaurants.genre_suchen(gesRestaurant);


                    if(suchergebnisse_Genre.length == 0)
                    {
                        UI.keine_suchergebnisse();
                    }
                    else
                    {
                        restaurants_ausgeben(suchergebnisse_Genre,gesRestaurant);
                    }
                }
                else
                {
                    System.out.println("Restaurant wird gesucht");
                    Restaurant[] suchergebnis_restaurant = new Restaurant[]{(Restaurant) restaurants.restaurant_suchen(gesRestaurant)};
                    if(suchergebnis_restaurant[0] == null)
                    {
                        UI.keine_suchergebnisse();
                    }
                    else
                    {
                        restaurants_ausgeben(suchergebnis_restaurant,gesRestaurant);
                    }
                }
            }
        });

        geld_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guthaben();
            }
        });

        warenkorb_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                warenkorb_anzeigen();
            }
        });

        bestellhistorie_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bestellhistorie();
            }
        });
    }

    public boolean ist_essensrichtung(String input)
    {
        for (String s : essensrichtungen) {
            if (s.equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }

        
    public void gerichte_ausgeben(Datenelement[][][] suchergebnisse_gerichte, String gesGericht)
    {
        int anzahl_ergebnisse = 0;
        for (Datenelement[][] datenelements : suchergebnisse_gerichte) {
            anzahl_ergebnisse += datenelements[0].length;
            //for(int e = 0; e < suchergebnisse_gerichte[r][0])
        }
        double[] lieferzeiten = new double[anzahl_ergebnisse];

        int index = 0;
        for (Datenelement[][] value : suchergebnisse_gerichte) {
            for (int s = 0; s < value[0].length; s++) {
                lieferzeiten[index] = Lieferdaten.lieferzeit_berechnen(value[0][s].dauer_geben(), user.getKoordinaten(), value[1][0].getKoordinaten());
                index++;
            }
        }



        JComponent[] components = UI.gerichte_ausgeben(suchergebnisse_gerichte,lieferzeiten,true);

        index = 0;
        for (Datenelement[][] datenelements : suchergebnisse_gerichte) {
            for (int s = 0; s < datenelements[0].length; s++) {
                JButton main_btn = (JButton) components[index];
                Datenelement restaurant = datenelements[1][0];
                main_btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        speisekarte_ausgeben(restaurant);
                    }
                });

                index++;

                JButton btn_plus = (JButton) components[index];
                Datenelement[] gerichtDaten = new Datenelement[]{datenelements[0][s], restaurant};
                double lieferzeit = lieferzeiten[index/2];
                btn_plus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gericht_warenkorb_hinzufuegen(gerichtDaten,lieferzeit);
                    }
                });
                index++;
            }
        }
    }

    public void restaurants_ausgeben(Restaurant[] suchergebnisse_restaurants, String gesRestaurant)
    {
        double[] lieferzeiten = new double[suchergebnisse_restaurants.length];

        for(int i = 0;i < suchergebnisse_restaurants.length;i++)
        {
            lieferzeiten[i] = Lieferdaten.lieferzeit_berechnen(suchergebnisse_restaurants[i].dauer_geben(),user.getKoordinaten(),suchergebnisse_restaurants[i].getKoordinaten());
        }
        JComponent[] components = UI.restaurants_ausgeben(suchergebnisse_restaurants,lieferzeiten);

        for (JComponent component : components) {
            ((JButton) component).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    speisekarte_ausgeben(suchergebnisse_restaurants[0]);
                }
            });
        }
    }



    public void speisekarte_ausgeben(Datenelement restaurant)
    {
        Gericht[] speisekarte = restaurant.gericht_in_speisekarte_suchen("");
        Datenelement[][][] suchergebnis = new Datenelement[][][]{new Datenelement[][]{speisekarte,new Restaurant[]{(Restaurant) restaurant}}};

        int anzahl_ergebnisse = speisekarte.length;

        double[] lieferzeiten = new double[anzahl_ergebnisse];

        int index = 0;


        for(int s = 0; s < suchergebnis[0][0].length;s++)
        {
            lieferzeiten[index] = Lieferdaten.lieferzeit_berechnen(suchergebnis[0][0][s].dauer_geben(), user.getKoordinaten(), suchergebnis[0][1][0].getKoordinaten());
            index++;
        }


        JComponent[] components = UI.gerichte_ausgeben(suchergebnis,lieferzeiten,false);
        UI.info_panel_setzen("Speisekarte von " + "\"" + restaurant.getName() + "\"");

        for(int i = 0;i < components.length;i++)
        {
            Datenelement[] gerichtDaten = new Datenelement[]{speisekarte[i],restaurant};
            double lieferzeit = lieferzeiten[i];
            ((JButton)components[i]).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gericht_warenkorb_hinzufuegen(gerichtDaten,lieferzeit);
                }
            });
        }
    }

    public void gericht_warenkorb_hinzufuegen(Datenelement[] gerichtDaten, double lieferzeit)
    {
        warenkorb.gericht_hinzufuegen(gerichtDaten,lieferzeit);
    }

    public void warenkorb_erstellen()
    {
        warenkorb = new Bestellung();
    }
    public void warenkorb_anzeigen()
    {
        JComponent[] components = UI.warenkorb_screen(warenkorb);

        ((JButton)components[0]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_screen();
            }
        });

        ((JButton)components[1]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(warenkorb.getPreis() <= user.getGuthaben())
                {
                    user.guthaben_abziehen(warenkorb.getPreis());

                    warenkorb.akt_zeit_speichern();

                    Bestellung[] neuesArray_bestellhistorie = new Bestellung[bestellhistorie.length + 1];
                    System.arraycopy(bestellhistorie, 0, neuesArray_bestellhistorie, 0, bestellhistorie.length);
                    neuesArray_bestellhistorie[bestellhistorie.length] = warenkorb;
                    bestellhistorie = neuesArray_bestellhistorie;

                    warenkorb_erstellen();
                    warenkorb_anzeigen();
                }
                else
                {
                    UI.kein_geld();
                }
            }
        });

        for(int i = 2;i < components.length;i++)
        {
            int finalI = i;
            ((JButton)components[i]).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    warenkorb.gericht_entfernen(finalI - 2);
                    warenkorb_anzeigen();
                }
            });
        }

    }
    public void bestellhistorie()
    {
        JComponent[] components = UI.bestellhistorie_screen(bestellhistorie);

        ((JButton)components[0]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_screen();
            }
        });

        for(int i = 1;i < bestellhistorie.length;i++)
        {
            int finalI = i;
            ((JButton)components[i]).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    warenkorb.bestellung_hinzufuegen(bestellhistorie[finalI - 1]);
                }
            });
        }
    }
    public void guthaben()
    {
        JComponent[] components = UI.guthaben_screen(user.getGuthaben());

        ((JButton)components[0]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_screen();
            }
        });

        ((JButton)components[1]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String betrag = ((JTextField)components[2]).getText();

                try{
                    double betrag_zahl = Double.parseDouble(betrag);
                    user.guthaben_aufladen(betrag_zahl);
                    guthaben();
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
