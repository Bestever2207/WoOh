
public class Restaurant extends Datenelement
{
    private String name;
    private double preisspanne;
    private double durchschnittdauer; //nur Zubereitung
    private Baum speisekarte;
    private String genre;
    private String adresse;
    private double[] koordinaten;

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
        this.koordinaten = Entfernung.KoordsErmitteln(adresse);
        this.preisspanne = preisspanneBerechnen();
        this.durchschnittdauer = durchschnittdauerBerchnen();
    }

    public Gericht[] GerichtSuchen(String gesGericht)
    {
        return speisekarte.GerichtinspeisekarteSuchen(gesGericht);
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

    public double getDurchschnittdauer()
    {
        return durchschnittdauer;
    }



    public Baum getSpeisekarte()
    {
        return speisekarte;
    }
    public void DatenAusgeben()
    {}
    public double durchschnittdauerBerchnen()
    {
        return speisekarte.durchschnittdauerBerechnen();
    }
    public double preisspanneBerechnen()
    {
        return speisekarte.preisspanneBerechnen();
    }
    public boolean istKleiner(Datenelement dat)
    {
        return name.compareTo((String)dat.wertGeben()) < 0;
    }
    public boolean istGleich(Datenelement dat)
    {
        return name.compareTo((String) dat.wertGeben()) == 0;
    }
    public Gericht[] GerichtinspeisekarteSuchen(String gesGericht)
    {
        return speisekarte.GerichtinspeisekarteSuchen(gesGericht);
    }
    public Object wertGeben()
    {
        return name;
    }
    public double preisGeben()
    {
        return preisspanne;
    }
    public double dauerGeben()
    {
        return durchschnittdauer;
    }

}
