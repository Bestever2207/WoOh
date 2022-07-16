
public abstract class Baumelement
{
    public abstract Baumelement getNaechsterL();
    public abstract Baumelement getNaechsterR();
    public abstract Datenelement getInhalt();
    public abstract Baumelement sortiert_einfuegen(Datenelement dat);
    public abstract Datenelement name_suchen(String s);
    public abstract double preis_geben();
    public abstract double dauer_geben();
    public abstract int anz_datenknoten();
    public abstract Restaurant[] genre_suchen(String gesGenre);
    public abstract Datenelement[][][] gericht_suchen(String gesGericht);
    public abstract Gericht[] gericht_in_speisekarte_suchen(String gesGericht);
}
