
public class Datenknoten extends Baumelement
{
    private Baumelement naechsterL;
    private Baumelement naechsterR;
    private final Datenelement inhalt;

    public Datenknoten(Baumelement naechsterL, Baumelement naechsterR, Datenelement inhalt)
    {
        this.naechsterL = naechsterL;
        this.naechsterR = naechsterR;
        this.inhalt = inhalt;
    }

    public Baumelement getNaechsterL() {
        return naechsterL;
    }

    public Baumelement getNaechsterR() {
        return naechsterR;
    }

    public Datenelement getInhalt() {
        return inhalt;
    }

    public Baumelement sortiert_einfuegen(Datenelement dat)
    {
        if(inhalt.ist_kleiner(dat))
        {
            naechsterR = naechsterR.sortiert_einfuegen(dat);
        }
        else
        {
            naechsterL = naechsterL.sortiert_einfuegen(dat);
        }
        return this;
    }
    public Datenelement name_suchen(String s)
    {
        Datenelement dat = new Restaurant(s,new Baum(),"s","s");
        if(((String)inhalt.wert_geben()).toLowerCase().equals(s))
        {
            return inhalt;
        }
        else if(inhalt.ist_kleiner(dat))
        {
            return naechsterL.name_suchen(s);
        }
        return naechsterR.name_suchen(s);


    }
    public double preis_geben()
    {
        return naechsterL.preis_geben() + naechsterR.preis_geben() + inhalt.preis_geben();
    }
    public double dauer_geben()
    {
        return naechsterL.dauer_geben() + naechsterR.dauer_geben() + inhalt.dauer_geben();
    }
    public int anz_datenknoten()
    {
        return naechsterL.anz_datenknoten() + naechsterR.anz_datenknoten() + 1;
    }
    public Restaurant[] genre_suchen(String gesGenre)
    {
        Restaurant[] result;
        Restaurant[] liste1 = naechsterL.genre_suchen(gesGenre);
        Restaurant[] liste2 = naechsterR.genre_suchen(gesGenre);
        if(((Restaurant)inhalt).getGenre().toLowerCase().equals(gesGenre))
        {
            result = new Restaurant[liste1.length + liste2.length + 1];
            System.arraycopy(liste1,0,result,0,liste1.length);
            System.arraycopy(liste2,0,result,liste1.length,liste2.length);
            result[result.length - 1] = (Restaurant)inhalt;
        }
        else
        {
            result = new Restaurant[liste1.length + liste2.length];
            System.arraycopy(liste1,0,result,0,liste1.length);
            System.arraycopy(liste2,0,result,liste1.length,liste2.length);
        }
        return result;
    }
    public Datenelement[][][] gericht_suchen(String gesGericht)
    {
        Datenelement[][][] result;
        Datenelement[][][] liste1 = naechsterL.gericht_suchen(gesGericht);
        Datenelement[][][] liste2 = naechsterR.gericht_suchen(gesGericht);
        Gericht[] gerichte = inhalt.gericht_in_speisekarte_suchen(gesGericht);
        if(gerichte.length > 0)
        {
            result = new Datenelement[liste1.length + liste2.length + 1][2][50];
            Restaurant[] restaurant = {(Restaurant) inhalt};
            Datenelement[][][] suchergebnisse = {{gerichte,restaurant}};
            System.arraycopy(liste1, 0, result, 0, liste1.length);
            System.arraycopy(liste2, 0, result, liste1.length, liste2.length);
            result[liste1.length + liste2.length] = suchergebnisse[0];

        }
        else
        {
            result = new Datenelement[liste1.length + liste2.length][2][50];
            System.arraycopy(liste1, 0, result, 0, liste1.length);
            System.arraycopy(liste2, 0, result, liste1.length, liste2.length);
        }
        return result;
    }
    public Gericht[] gericht_in_speisekarte_suchen(String gesGericht)
    {
        Gericht[] result;
        Gericht[] liste1 = naechsterL.gericht_in_speisekarte_suchen(gesGericht);
        Gericht[] liste2 = naechsterR.gericht_in_speisekarte_suchen(gesGericht);
        if(inhalt.getName().toLowerCase().contains(gesGericht))
        {
            result = new Gericht[liste1.length + liste2.length + 1];
            System.arraycopy(liste1,0,result,0,liste1.length);
            System.arraycopy(liste2,0,result,liste1.length,liste2.length);
            result[result.length - 1] = (Gericht) inhalt;
        }
        else
        {
            result = new Gericht[liste1.length + liste2.length];
            System.arraycopy(liste1,0,result,0,liste1.length);
            System.arraycopy(liste2,0,result,liste1.length,liste2.length);
        }
        return result;
    }
}
