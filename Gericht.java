
public class Gericht extends Datenelement
{
    private String name;
    private double preis;
    private double dauer;
    private String[] beilagen;

    public Gericht(String name,double preis,double dauer,String[] beilagen)
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
    public void DatenAusgeben()
    {}
    public boolean istKleiner(Datenelement dat)
    {
        return name.compareTo((String)dat.wertGeben()) < 0;
    }
    public boolean istGleich(Datenelement dat)
    {
        return name.compareTo((String) dat.wertGeben()) == 0;
    }
    public Object wertGeben()
    {
        return name;
    }
    public Gericht[] GerichtinspeisekarteSuchen(String gesGericht)
    {
        return null;
    }

    public double preisGeben()
    {
        return preis;
    }
    public double dauerGeben()
    {
        return dauer;
    }
}
