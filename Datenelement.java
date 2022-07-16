
public abstract class Datenelement
{
    public abstract boolean ist_kleiner(Datenelement dat);
    public abstract boolean ist_gleich(Datenelement dat);
    public abstract Object wert_geben();
    public abstract double preis_geben();
    public abstract double dauer_geben();
    public abstract String getName();
    public abstract String[] getBeilagen();
    public abstract Gericht[] gericht_in_speisekarte_suchen(String gesGericht);
    public abstract double[] getKoordinaten();

}
