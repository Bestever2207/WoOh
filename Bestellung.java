import java.util.Date;

public class Bestellung
{
    Gericht gerichte[];
    Restaurant restaurant;
    String adresse;
    double koords[];
    Date uhrzeit;
    Date datum;
    public Bestellung()
    {
        gerichte = new Gericht[0];
    }

    public void gerichthinzufuegen(Gericht neuesGericht)
    {
        Gericht[] neuesArray = new Gericht[gerichte.length + 1];
        for(int i = 0; i < gerichte.length; i++)
        {
            neuesArray[i] = gerichte[i];
        }
        neuesArray[gerichte.length] = neuesGericht;
        gerichte = neuesArray;
    }
}
