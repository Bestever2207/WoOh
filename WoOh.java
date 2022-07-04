import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class WoOh
{
    private User user;

    private Baum restaurants;
    private String[] essensrichtungen = {"asiatisch","italienisch","kroatisch"};

    public WoOh()
    {
        Ui.start();
        RestaurantsEinfuegen();


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
        for(int i = 0;i < 5;i++)
        {
            
        }
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
                if(koordinaten == null || userDaten[1].isBlank())
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
                    System.out.println("nichts eingegeben");
                    //kein Gericht eingegeben
                }
                else
                {
                    System.out.println("Gericht wird gesucht");
                    Datenelement[][][] suchergebnisse = restaurants.GerichtSuchen(gesGericht);
                    gerichteAusgeben(suchergebnisse);
                }
            }
        });

        suchen_btn_restaurant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gesRestaurant = restaurants_in.getText();

                if(gesRestaurant.isBlank())
                {
                    System.out.println("nichts eingegeben");
                    //kein Restaurant eingegeben
                }
                else if (istEssensrichtung(gesRestaurant))
                {
                    System.out.println("Genre wird gesucht");
                    Restaurant[] suchergebnisse_Genre = restaurants.GenreSuchen(gesRestaurant);

                    if(suchergebnisse_Genre != null)
                    {
                        restaurantsAusgeben(suchergebnisse_Genre);
                    }
                    else
                    {
                        System.out.println("keine Ergebnisse");
                    }
                }
                else
                {
                    System.out.println("Restaurant wird gesucht");
                    Restaurant[] suchergebnis_restaurant = new Restaurant[]{(Restaurant) restaurants.RestaurantSuchen(gesRestaurant)};
                    if(suchergebnis_restaurant != null)
                    {
                        restaurantsAusgeben(suchergebnis_restaurant);
                    }
                    else
                    {
                        System.out.println("keine Ergebnisse");
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
                Warenkorb();
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


    public void gerichteAusgeben(Datenelement[][][] suchergebnisse_gerichte)
    {
        int anzahl_ergebnisse = 0;
        for(int i = 0;i < suchergebnisse_gerichte.length;i++)
        {
            anzahl_ergebnisse += suchergebnisse_gerichte[i][0].length;
            //for(int e = 0; e < suchergebnisse_gerichte[r][0])
        }
        double[] lieferzeiten = new double[anzahl_ergebnisse];

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

    public void restaurantsAusgeben(Restaurant[] suchergebnisse_restaurants)
    {
        double[] lieferzeiten = new double[suchergebnisse_restaurants.length];

        for(int i = 0;i < suchergebnisse_restaurants.length;i++)
        {
            lieferzeiten[i] = Lieferdaten.LieferzeitBerechnen(suchergebnisse_restaurants[i].dauerGeben(),user.getKoordinaten(),suchergebnisse_restaurants[i].getKoordinaten());
        }
        JComponent[] components = Ui.restaurantsAusgeben(suchergebnisse_restaurants,lieferzeiten);
    }



    public static void speisekarteAusgeben(Datenelement restaurant)
    {
        Gericht[] speisekarte = restaurant.GerichtinspeisekarteSuchen("");
        for(int i = 0; i < speisekarte.length;i++)
        {
            System.out.println(speisekarte[i].getName());
        }
    }

    public static void gericht_warenkorbhinzufügen(Datenelement[] gerichtDaten)
    {

    }

    public static void Warenkorb()
    {

    }
    public static void Bestellhistorie()
    {

    }
    public static void Guthaben()
    {

    }

}
