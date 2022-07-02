
public abstract class Datenelement
{
    public abstract void DatenAusgeben();
    public abstract boolean istKleiner(Datenelement dat);
    public abstract boolean istGleich(Datenelement dat);
    public abstract Object wertGeben();
    public abstract double preisGeben();
    public abstract double dauerGeben();
    public abstract String getName();
    public abstract String[] getBeilagen();
    public abstract Gericht[] GerichtinspeisekarteSuchen(String gesGericht);
    public abstract double[] getKoordinaten();

}
