
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
    public Baumelement sortiertEinfuegen(Datenelement dat)
    {
        return new Datenknoten(this,this,dat);
    }
    public Datenelement nameSuchen(String s)
    {
        return null;
    }
    public double preisGeben()
    {
        return 0;
    }
    public double dauerGeben()
    {
        return 0;
    }
    public int anzDatenknoten()
    {
        return 0;
    }
    public Restaurant[] genreSuchen(String gesGenre)
    {
        return new Restaurant[0];
    }
    public Datenelement[][][] gerichtSuchen(String gesGericht)
    {
        return new Datenelement[0][0][0];
    }
    public Gericht[] GerichtinspeisekarteSuchen(String gesGericht)
    {
        return new Gericht[0];
    }
}
