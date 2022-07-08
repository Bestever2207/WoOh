import java.util.Date;

public class Bestellung
{
    Gericht[] gerichte;
    Restaurant restaurant;
    String adresse;
    double[] koords;
    Date uhrzeit;
    Date datum;
    public Bestellung()
    {
        gerichte = new Gericht[0];
    }

    public void gerichthinzufuegen(Gericht neuesGericht)
    {
        Gericht[] neuesArray = new Gericht[gerichte.length + 1];
        System.arraycopy(gerichte, 0, neuesArray, 0, gerichte.length);
        neuesArray[gerichte.length] = neuesGericht;
        gerichte = neuesArray;

        System.out.println(neuesGericht.getName() + " wurde dem Warenkorb hinzugefügt");
    }
}
