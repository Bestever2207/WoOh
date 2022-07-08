import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

public class Entfernung {

    //public static void main(String[] args) {

    //}
    //static String adresse = "Düsseldorfer Str. 17 90425 Nürnberg";

    public static double[] KoordsErmitteln(String adresse)
    {
        adresse = adresse.replace("ü","ue");
        adresse = adresse.replace("ö","oe");
        adresse = adresse.replace("ä","ae");
        adresse = adresse.replace("ß","ss");
        StringBuilder koordinaten = new StringBuilder();
        if(adresse.isBlank())
        {
            return null;
        }
        try {
            URL url = new URL("https://api.myptv.com/geocoding/v1/locations/by-text?searchText=" + adresse.replace(" ", "%20") + "&apiKey=NzQwNWE4YmUwMTg3NDM0ZWI4NGE4ZWE4OTEzZTQ0ZmQ6NzllMzRiMDAtYzcxMS00NDVhLTkzNjItNWMwODdjYjc0Y2Mz");
            System.out.println(url);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    koordinaten.append(line);
                }
            }
            catch (IOException io) {
                io.printStackTrace();
            }

        }

        catch (MalformedURLException mal)
        {
            mal.printStackTrace();
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
    public static double entfernungBerechnen(double[] koordsUser, double[] koordsRestaurant)
    {
        double entfernung;
        double dx = 71.5 * (koordsUser[1] - koordsRestaurant[1]);
        double dy = 111.3 * (koordsUser[0] - koordsRestaurant[0]);
        entfernung = Math.sqrt(dx * dx + dy * dy);
        System.out.println(entfernung);
        return entfernung;
    }
}