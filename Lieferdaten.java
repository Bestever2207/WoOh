
public class Lieferdaten {
    public static int lieferzeit_berechnen(double zubereitdauer, double[] koordsUser, double[] koordsRestaurant)
    {
        double entfernung = Entfernung.entfernung_berechnen(koordsUser, koordsRestaurant);
        System.out.println(zubereitdauer);
        System.out.println(entfernung);
        
        double lieferzeit = zubereitdauer + (entfernung / 20) * 60;
        System.out.println(lieferzeit);
        return (int) lieferzeit;
    }
}
