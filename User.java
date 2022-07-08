
public class User
{
    private final String adresse;
    private final double[] koordinaten;
    private final String name;
    private double guthaben;

    User(String adresse, double[] koordinaten, String name) {
        this.adresse = adresse;
        this.koordinaten = koordinaten;
        this.name = name;
    }
    public void GuthabenAufladen(double neuesGuthaben)
    {
        guthaben = guthaben + neuesGuthaben;
    }
    public void GuthabenAbziehen(double preis)
    {
        guthaben = guthaben - preis;
    }

    public String getAdresse() {
        return adresse;
    }

    public double[] getKoordinaten() {
        return koordinaten;
    }

    public String getName() {
        return name;
    }
}
