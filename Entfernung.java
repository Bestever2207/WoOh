import java.net.SocketOption;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
public class Entfernung {

    //public static void main(String[] args) {

    //}
    //static String Adresse = "Düsseldorfer Str. 17 90425 Nürnberg";

    public static double[] KoordsErmitteln(String Adresse)
    {
        Adresse = Adresse.replace("ü","ue");
        Adresse = Adresse.replace("ö","oe");
        Adresse = Adresse.replace("ä","ae");
        Adresse = Adresse.replace("ß","ss");
        String koordinaten = "";
        if(Adresse.isBlank())
        {
            return null;
        }
        try {
            URL url = new URL("https://api.myptv.com/geocoding/v1/locations/by-text?searchText=" + Adresse.replace(" ", "%20") + "&apiKey=NzQwNWE4YmUwMTg3NDM0ZWI4NGE4ZWE4OTEzZTQ0ZmQ6NzllMzRiMDAtYzcxMS00NDVhLTkzNjItNWMwODdjYjc0Y2Mz");
            System.out.println(url);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
                String line = "";
                while ((line = br.readLine()) != null) {
                    koordinaten = koordinaten + line;
                }
            }
            catch (IOException io) {
                System.out.println(io);
            }

        }

        catch (MalformedURLException mal)
        {
            System.out.println(mal);
        }
        if(koordinaten.length() < 520) {
            int idx = koordinaten.indexOf("latitude");
            String breitengrad = koordinaten.substring(idx + 10, idx + 40);
            idx = breitengrad.indexOf(",");
            breitengrad = breitengrad.substring(0,idx);

            int idx2 = koordinaten.indexOf("longitude");
            String laengengrad = koordinaten.substring(idx2 + 11, idx2 + 40);
            idx = laengengrad.indexOf("}");
            laengengrad = laengengrad.substring(0,idx);

            return new double[]{Double.parseDouble(breitengrad), Double.parseDouble(laengengrad)};
        }
        else
        {
            return null;
        }
    }
    public static double EntfernungBerechnen(double[]koordsUser,double[] koordsRestaurant)
    {
        double entfernung = 0;
        entfernung = Math.sqrt(Math.pow(koordsUser[0]-koordsRestaurant[0],2.0) + (Math.pow(koordsUser[1]-koordsRestaurant[1],2.0)) );
        return entfernung;
    }




}