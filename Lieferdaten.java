import java.util.Random;



public class Lieferdaten {
    public static int LieferzeitBerechnen(double zubereitdauer,double[] koordsUser,double[] koordsRestaurant)
    {
        double entfernung = Entfernung.EntfernungBerechnen(koordsUser,koordsRestaurant);
        System.out.println(zubereitdauer);
        System.out.println(entfernung);
        
        double lieferzeit = zubereitdauer + (entfernung / 20) * 60;
        System.out.println(lieferzeit);
        
        return (int) lieferzeit;
    }
}
