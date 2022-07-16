
public class Restaurant extends Datenelement
{
    private final String name;
    private final double preisspanne;
    private final double durchschnittdauer; //nur Zubereitung
    private final Baum speisekarte;
    private final String genre;
    private final String adresse;
    private final double[] koordinaten;

    public String getAdresse() {
        return adresse;
    }

    public double[] getKoordinaten() {
        return koordinaten;
    }

    public Restaurant(String name, Baum speisekarte, String genre, String adresse)
    {
        this.name = name;
        this.speisekarte = speisekarte;
        this.genre = genre;
        this.adresse = adresse;
        this.koordinaten = Entfernung.koords_ermitteln(adresse);
        this.preisspanne = preisspanne_berechnen();
        this.durchschnittdauer = durchschnittsdauer_berchnen();
    }

    public Gericht[] gericht_suchen(String gesGericht)
    {
        return speisekarte.gericht_in_speisekarte_suchen(gesGericht);
    }
    public String getGenre() {
        return genre;
    }

    public String getName()
    {
        return name;
    }

    public double getPreisspanne()
    {
        return preisspanne;
    }

    public String[] getBeilagen()
    {
        return null;
    }

    public double durchschnittsdauer_berchnen()
    {
        return speisekarte.durchschnittsdauer_berechnen();
    }
    public double preisspanne_berechnen()
    {
        return speisekarte.preisspanne_berechnen();
    }
    public boolean ist_kleiner(Datenelement dat)
    {
        return name.compareTo((String)dat.wert_geben()) < 0;
    }
    public boolean ist_gleich(Datenelement dat)
    {
        return name.compareTo((String) dat.wert_geben()) == 0;
    }
    public Gericht[] gericht_in_speisekarte_suchen(String gesGericht)
    {
        return speisekarte.gericht_in_speisekarte_suchen(gesGericht);
    }
    public Object wert_geben()
    {
        return name;
    }
    public double preis_geben()
    {
        return preisspanne;
    }
    public double dauer_geben()
    {
        return durchschnittdauer;
    }

}
