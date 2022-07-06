import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Bestellung
{
    Gericht gericht;
    Restaurant restaurant;
    String adresse;
    double koords[];
    Date uhrzeit;
    Date datum;
    public Bestellung(Gericht gericht,Restaurant restaurant)
    {
        this.gericht = gericht;
        this.restaurant = restaurant;
        adresse = restaurant.getAdresse();
        koords = restaurant.getKoordinaten();
        uhrzeit = Calendar.getInstance().getTime();

        datum = Calendar.getInstance()
    }
}
