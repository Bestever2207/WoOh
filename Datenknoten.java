
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

    public Baumelement sortiertEinfuegen(Datenelement dat)
    {
        if(inhalt.istKleiner(dat))
        {
            naechsterR = naechsterR.sortiertEinfuegen(dat);
        }
        else
        {
            naechsterL = naechsterL.sortiertEinfuegen(dat);
        }
        return this;
    }
    public Datenelement nameSuchen(String s)
    {
        Datenelement dat = new Restaurant(s,new Baum(),"s","s");
        if((inhalt.wertGeben()).equals(s))
        {
            return inhalt;
        }
        else if(inhalt.istKleiner(dat))
        {
            return naechsterL.nameSuchen(s);
        }
        return naechsterR.nameSuchen(s);


    }
    public double preisGeben()
    {
        return naechsterL.preisGeben() + naechsterR.preisGeben() + inhalt.preisGeben();
    }
    public double dauerGeben()
    {
        return naechsterL.dauerGeben() + naechsterR.dauerGeben() + inhalt.dauerGeben();
    }
    public int anzDatenknoten()
    {
        return naechsterL.anzDatenknoten() + naechsterR.anzDatenknoten() + 1;
    }
    public Restaurant[] genreSuchen(String gesGenre)
    {
        Restaurant[] result;
        Restaurant[] liste1 = naechsterL.genreSuchen(gesGenre);
        Restaurant[] liste2 = naechsterR.genreSuchen(gesGenre);
        if(((Restaurant)inhalt).getGenre().equals(gesGenre))
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
    public Datenelement[][][] gerichtSuchen(String gesGericht)
    {
        Datenelement[][][] result;
        Datenelement[][][] liste1 = naechsterL.gerichtSuchen(gesGericht);
        Datenelement[][][] liste2 = naechsterR.gerichtSuchen(gesGericht);
        Gericht[] gerichte = inhalt.GerichtinspeisekarteSuchen(gesGericht);
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
    public Gericht[] GerichtinspeisekarteSuchen(String gesGericht)
    {
        Gericht[] result;
        Gericht[] liste1 = naechsterL.GerichtinspeisekarteSuchen(gesGericht);
        Gericht[] liste2 = naechsterR.GerichtinspeisekarteSuchen(gesGericht);
        if(inhalt.getName().contains(gesGericht))
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
