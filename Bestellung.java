import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bestellung
{
    private Gericht[] gerichte;
    private int gerichte_anzahl = 0;
    private double preis;
    private double dauer = 0.0;
    private double[] lieferzeiten;
    private Restaurant restaurant;
    private String adresse;
    private double[] koords;
    private String uhrzeit;
    private String datum;
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
        preis = 0;
        for(int i = 0;i < gerichte_anzahl;i++)
        {
            preis += gerichte[i].getPreis();
        }
        return preis;
    }

    public String getUhrzeit() {
        return uhrzeit;
    }

    public String getDatum() {
        return datum;
    }

    public double getDauer()
    {

        for(int i = 0; i < gerichte_anzahl;i++)
        {
            if(lieferzeiten[i] > dauer)
            {
                dauer = lieferzeiten[i];
            }
        }

        return dauer;
    }
    public void akt_zeit_speichern()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String[] daten = dtf.format(LocalDateTime.now()).split(" ");

        uhrzeit = daten[1];

        String[] datum_array = daten[0].split("/");
        datum = datum_array[2] + "." + datum_array[1] + "." + datum_array[0];

        System.out.println(uhrzeit + "    " + datum);
    }

    public double[] getLieferzeiten() {
        return lieferzeiten;
    }

    public void gericht_entfernen(int zu_loeschendes_element)
    {
        Gericht[] neues_Array_gerichte = new Gericht[gerichte.length - 1];
        int index = 0;

        for(int i = 0;i < gerichte.length;i++)
        {
            if(i != zu_loeschendes_element)
            {
                neues_Array_gerichte[index] = gerichte[i];
                index++;
            }
        }
        gerichte = neues_Array_gerichte;

        gerichte_anzahl--;
    }

    public void bestellung_hinzufuegen(Bestellung bestellung)
    {
        if(gerichte_anzahl == 0)
        {
            gerichte = bestellung.getGerichte();
            gerichte_anzahl = bestellung.getGerichte_anzahl();
            lieferzeiten = bestellung.getLieferzeiten();
        }
        else {
            Gericht[] neuesArray_gerichte = new Gericht[gerichte_anzahl + bestellung.getGerichte_anzahl()];
            System.arraycopy(gerichte, 0, neuesArray_gerichte, 0, gerichte.length);
            System.arraycopy(bestellung.getGerichte(), 0, neuesArray_gerichte, gerichte.length, bestellung.getGerichte_anzahl());
            gerichte = neuesArray_gerichte;

            gerichte_anzahl += bestellung.getGerichte_anzahl();

            double[] neuesArray_lieferzeit = new double[lieferzeiten.length + bestellung.getLieferzeiten().length];
            System.arraycopy(lieferzeiten, 0, neuesArray_lieferzeit, 0, lieferzeiten.length);
            System.arraycopy(bestellung.getLieferzeiten(), 0, neuesArray_lieferzeit, lieferzeiten.length, bestellung.getLieferzeiten().length);
            lieferzeiten = neuesArray_lieferzeit;
        }
    }
}