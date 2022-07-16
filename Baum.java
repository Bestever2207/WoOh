

public class Baum
{
    private Baumelement wurzel;

    public Baum()
    {
        wurzel = new Abschluss();
    }
    
    public void sortiert_einfuegen(Datenelement dat)
    {
        wurzel = wurzel.sortiert_einfuegen(dat);
    }

    public Datenelement restaurant_suchen(String name)
    {
        return wurzel.name_suchen(name.toLowerCase());
    }
    public double preisspanne_berechnen()
    {
        return wurzel.preis_geben()/ anz_datenknoten();
    }
    public double durchschnittsdauer_berechnen()
    {
        return wurzel.dauer_geben()/ anz_datenknoten();
    }
    public int anz_datenknoten()
    {
        return wurzel.anz_datenknoten();
    }
    public Restaurant[] genre_suchen(String gesGenre)
    {
        return wurzel.genre_suchen(gesGenre.toLowerCase());
    }
    public Datenelement[][][] gericht_suchen(String gesGericht)
    {
        return wurzel.gericht_suchen(gesGericht.toLowerCase());
    }
    public Gericht[] gericht_in_speisekarte_suchen(String gesGericht)
    {
        return wurzel.gericht_in_speisekarte_suchen(gesGericht);
    }
}
