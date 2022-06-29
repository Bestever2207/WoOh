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
        RestaurantsEinfuegen();
        Ui.start();

        KoordsSetzen();

        mainScreen();

    }
    public void RestaurantsEinfuegen()
    {
        restaurants = CsvReader.RestaurantsGeben(new File("Restaurants.csv"));
    }


    public void KoordsSetzen()
    {
        JComponent[] userDaten_in = Ui.KoordsScreen();

        JButton suchen_btn = (JButton) userDaten_in[5];

        String[] userDaten = new String[5];
        suchen_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0;i < 5;i++)
                {
                    userDaten[i] = ((JTextField)userDaten_in[i]).getText();
                }

                String adresse = userDaten[0] + " " + userDaten[1] + " " + userDaten[2] + " " + userDaten[3];

                double[] koordinaten;

                koordinaten = Entfernung.KoordsErmitteln(adresse);
                if(koordinaten == null || userDaten[1].isBlank())
                {
                    Ui.koordsScreenFalsch();
                    KoordsSetzen();
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
        Ui.mainScreen();

    }
    /*
    public void suchenScreen()
    {
        String[] suche = Ui.suchenScreen();
        if(!(suche[0].isBlank() ^ suche[1].isBlank()))
        {
            Ui.suchenScreenFalsch();
            suchenScreen();
        }
        else if (suche[0].isBlank()) //suche nach Gericht
        {
            Datenelement[][][] suchergebnisse = restaurants.GerichtSuchen(suche[1]);
            if(suchergebnisse.length > 0)
            {
                double[] lieferzeiten = {1.55,8.4};
                Ui.GerichteAusgeben(suchergebnisse,lieferzeiten);
            }
            else
            {
                Ui.KeineSuchergebnisse();
            }
        }
        else //Suche nach Essensrichtung oder Restaurant
        {
            if(istEssensrichtung(suche[0])) // Suche nach Essensrichtung
            {
                Restaurant[] suchergebnisse = restaurants.GenreSuchen(suche[0]);
                if(suchergebnisse.length > 0) {
                    double[] lieferzeiten = new double[suchergebnisse.length];
                    for (int i = 0; i < suchergebnisse.length; i++) {
                        lieferzeiten[i] = Lieferdaten.LieferzeitBerechnen(suchergebnisse[i].getDurchschnittdauer(), user.getKoordinaten(), suchergebnisse[i].getKoordinaten());
                    }
                    Ui.RestaurantsAusgeben(suchergebnisse, lieferzeiten);
                }
                else
                {
                    Ui.KeineSuchergebnisse();
                }
            }
            else // Suche nach Restaurant
            {
                Restaurant[] suchergebnis = new Restaurant[]{(Restaurant) restaurants.RestaurantSuchen(suche[0])};
                if(suchergebnis[0] != null)
                {
                    double[] lieferzeit = new double[]{Lieferdaten.LieferzeitBerechnen(suchergebnis[0].dauerGeben(), user.getKoordinaten(), suchergebnis[0].getKoordinaten())};
                    Ui.RestaurantsAusgeben(suchergebnis,lieferzeit);
                }
                else
                {
                    Ui.KeineSuchergebnisse();
                }
            }
        }
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

    public static void Warenkorb()
    {

    }
    public static void Bestellhistorie()
    {

    }
    public static void Guthaben()
    {

    }
   */
}
