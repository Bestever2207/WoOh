
public abstract class Baumelement
{
    public abstract Baumelement getNaechsterL();
    public abstract Baumelement getNaechsterR();
    public abstract Datenelement getInhalt();
    public abstract Baumelement sortiertEinfuegen(Datenelement dat);
    public abstract Datenelement nameSuchen(String s);
    public abstract double preisGeben();
    public abstract double dauerGeben();
    public abstract int anzDatenknoten();
    public abstract Restaurant[] genreSuchen(String gesGenre);
    public abstract Datenelement[][][] gerichtSuchen(String gesGericht);
    public abstract Gericht[] GerichtinspeisekarteSuchen(String gesGericht);
}
