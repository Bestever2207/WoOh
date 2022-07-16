
public class Gericht extends Datenelement
{
    private final String name;
    private final double preis;
    private final double dauer;
    private final String[] beilagen;

    public Gericht(String name, double preis, double dauer, String[] beilagen)
    {
        this.name = name;
        this.preis = preis;
        this.dauer = dauer;
        this.beilagen = beilagen;
    }
    public String getName()
    {
        return name;
    }

    public double getPreis()
    {
        return preis;
    }

    public double getDauer()
    {
        return dauer;
    }

    public String[] getBeilagen()
    {
        return beilagen;
    }

    public boolean ist_kleiner(Datenelement dat)
    {
        return name.compareTo((String)dat.wert_geben()) < 0;
    }
    public boolean ist_gleich(Datenelement dat)
    {
        return name.compareTo((String)dat.wert_geben()) == 0;
    }
    public Object wert_geben()
    {
        return name;
    }
    public Gericht[] gericht_in_speisekarte_suchen(String gesGericht)
    {
        return null;
    }
    public double[] getKoordinaten()
    {
        return null;
    }

    public double preis_geben()
    {
        return preis;
    }
    public double dauer_geben()
    {
        return dauer;
    }
}
