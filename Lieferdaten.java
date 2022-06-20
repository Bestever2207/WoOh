import java.util.Random;



public class Lieferdaten {
    public static double LieferzeitBerechnen(double zubereitdauer,double[] koordsUser,double[] koordsRestaurant)
    {
        double entfernung = Entfernung.EntfernungBerechnen(koordsUser,koordsRestaurant);
        Random random = new Random();
        double lieferzeit = zubereitdauer + random.nextInt(25 + 15) / entfernung;;
        return lieferzeit;
    }
}
