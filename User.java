
public class User
{
    public static void main() {
    }
    private String adresse;
    private double[] koordinaten;
    private String name;
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
