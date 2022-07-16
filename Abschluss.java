
public class Abschluss extends Baumelement
{
    public Baumelement getNaechsterL()
    {
        return null;
    }
    public Baumelement getNaechsterR()
    {
        return null;
    }
    public Datenelement getInhalt()
    {
        return null;
    }
    public Baumelement sortiert_einfuegen(Datenelement dat)
    {
        return new Datenknoten(this,this,dat);
    }
    public Datenelement name_suchen(String s)
    {
        return null;
    }
    public double preis_geben()
    {
        return 0;
    }
    public double dauer_geben()
    {
        return 0;
    }
    public int anz_datenknoten()
    {
        return 0;
    }
    public Restaurant[] genre_suchen(String gesGenre)
    {
        return new Restaurant[0];
    }
    public Datenelement[][][] gericht_suchen(String gesGericht)
    {
        return new Datenelement[0][0][0];
    }
    public Gericht[] gericht_in_speisekarte_suchen(String gesGericht)
    {
        return new Gericht[0];
    }
}
