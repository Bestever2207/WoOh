import java.util.Date;

public class Bestellung
{
    Gericht[] gerichte;
    int gerichte_anzahl = 0;
    double preis;
    double[] lieferzeiten;
    Restaurant restaurant;
    String adresse;
    double[] koords;
    Date uhrzeit;
    Date datum;
    public Bestellung()
    {
        gerichte = new Gericht[0];
        lieferzeiten = new double[0];
    }

    public void gerichthinzufuegen(Gericht neuesGericht, double lieferzeit)
    {
        Gericht[] neuesArray_gerichte = new Gericht[gerichte.length + 1];
        System.arraycopy(gerichte, 0, neuesArray_gerichte, 0, gerichte.length);
        neuesArray_gerichte[gerichte.length] = neuesGericht;
        gerichte = neuesArray_gerichte;

        double[] neuesArray_lieferzeit = new double[lieferzeiten.length + 1];
        System.arraycopy(lieferzeiten, 0, neuesArray_lieferzeit, 0, lieferzeiten.length);
        neuesArray_lieferzeit[lieferzeiten.length] = lieferzeit;
        lieferzeiten = neuesArray_lieferzeit;

        gerichte_anzahl++;
        preis += neuesGericht.getPreis();
        System.out.println(neuesGericht.getName() + " wurde dem Warenkorb hinzugefügt");
    }

    public int getGerichte_anzahl() {
        return gerichte_anzahl;
    }

    public Gericht[] getGerichte() {
        return gerichte;
    }

    public double getPreis() {
        return preis;
    }

    public double getDauer()
    {
        double dauer = 0.0;
        for(int i = 0; i < gerichte_anzahl;i++)
        {
            if(lieferzeiten[i] > dauer)
            {
                dauer = lieferzeiten[i];
            }
        }

        return dauer;
    }
}
