

public class Baum
{
    private Baumelement wurzel;

    public Baum()
    {
        wurzel = new Abschluss();
    }
    
    public void sortiertEinfuegen(Datenelement dat)
    {
        wurzel = wurzel.sortiertEinfuegen(dat);
    }

    public Datenelement RestaurantSuchen(String name)
    {
        return wurzel.nameSuchen(name);
    }
    public double preisspanneBerechnen()
    {
        return wurzel.preisGeben()/ AnzahlDatenknoten();
    }
    public double durchschnittdauerBerechnen()
    {
        return wurzel.dauerGeben()/ AnzahlDatenknoten();
    }
    public int AnzahlDatenknoten()
    {
        return wurzel.anzDatenknoten();
    }
    public Restaurant[] GenreSuchen(String gesGenre)
    {
        return wurzel.genreSuchen(gesGenre);
    }
    public Datenelement[][][] GerichtSuchen(String gesGericht)
    {
        return wurzel.gerichtSuchen(gesGericht);
    }
    public Gericht[] GerichtinspeisekarteSuchen(String gesGericht)
    {
        return wurzel.GerichtinspeisekarteSuchen(gesGericht);
    }
}
