import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ui {
    JFrame frame;
    JPanel statusLine;
    JPanel pixelRaster;
    JPanel buttonPanel;
    JLabel statusLabel;
    JButton button;
    public static void start()
    {
        
    }
    public static String[] KoordsScreen()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benutze keine Sonderzeichen (z.B. %, !, ., /, \")");
        System.out.println("Gib deine Straße ein: ");
        String street = scanner.nextLine();

        System.out.println("Gib deine Hausnummer ein: ");
        String nummer = scanner.nextLine();


        System.out.println("Gib deine Plz ein: ");
        String plz = scanner.nextLine();

        System.out.println("Gib deine stadt ein: ");
        String stadt = scanner.nextLine();

        System.out.println("Gib deinen Namen ein: ");
        String name = scanner.nextLine();
        //System.out.println("Deine Eingaben: " + street + ",  " + nummer);
        return new String[] {street,nummer,plz,stadt,name};
    }

    public static void koordsScreenFalsch()
    {
        System.out.println("Adresse nicht eindeutig! Achte darauf, dass alles richtig geschrieben und eine Hausnummer eingegeben wurde. Wiederholen sie den Vorgang.");
    }

    public static String mainScreen()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gebe eine der Folgenden Aktionen ein, um sie auszuführen");
        System.out.println("suchen - Gericht/Restaurant/Genre suchen");
        System.out.println("Bestellverlauf - zeigt bereits getätigte Bestellungen an");
        System.out.println("Warenkorb - zeigt alle Gerichte, welche bereits hinzugefügt wurden");
        System.out.println("Geld - zeigt dein aufgeladenes Geld + du kannst weiteres Geld aufladen");

        String input = scanner.nextLine();
        return input;
    }
    public static String[] suchenScreen()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Fülle nur eins der beiden Felder aus!");
        System.out.println("Gib deine gewünschte Essensrichtung oder ein Restaurant ein: ");
        String restaurant = scanner.nextLine();

        System.out.println("Gib dein gewünschtes Gericht ein: ");
        String gericht = scanner.nextLine();

        return new String[]{restaurant,gericht};
    }
    public static void suchenScreenFalsch()
    {
        System.out.println("Achte darauf in nur eins der beiden Felder etwas einzugeben");
    }
    public static void RestaurantsAusgeben(Restaurant[] suchergebnisse,double[] lieferzeiten)
    {
        for(int i = 0;i < suchergebnisse.length;i++)
        {
            System.out.println(suchergebnisse[i].getName() + ": " + suchergebnisse[i].getGenre() + ", " + lieferzeiten[i] + ", " + suchergebnisse[i].getPreisspanne());
        }
    }
    public static void GerichteAusgeben(Datenelement[][][] suchergebnisse,double[] lieferzeiten)
    {
        for(int r = 0;r < suchergebnisse.length;r++)
        {
            for(int s = 0;s < suchergebnisse[r][0].length;s++)
            {
                System.out.println(suchergebnisse[r][1][0].getName() + ": " + suchergebnisse[r][0][s].getName());
            }
        }
    }

    public static void KeineSuchergebnisse()
    {
        System.out.println("Keine passenden Angebote gefunden");
    }
    public static void bestellScreen()
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
    public static void extra()
    {

    }

}
