
public class Lieferdaten {
    public static int lieferzeit_berechnen(double zubereitdauer, double[] koordsUser, double[] koordsRestaurant)
    {
        double entfernung = Entfernung.entfernung_berechnen(koordsUser, koordsRestaurant);
        
        double lieferzeit = zubereitdauer + (entfernung / 20) * 60;
        return (int)lieferzeit;
    }
}
