import java.io.*;

public class CsvReader
{
    public static Baum RestaurantsGeben(File file)
    {
        Baum restaurants = new Baum();
        String line;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null)
            {
                String[] token = line.split(";");
                Baum speisekarte = new Baum();
                for(int i = 3;i < token.length;i++)
                {
                    String[] beilagen;
                    String[] speise = token[i].split(",");
                    if(speise.length == 4) {
                        beilagen = speise[3].split("/");
                    }
                    else {
                        beilagen = new String[]{"keine"};
                    }
                    speisekarte.sortiertEinfuegen(new Gericht(speise[0], Double.parseDouble(speise[1]), Double.parseDouble(speise[2]), beilagen));
                }
                restaurants.sortiertEinfuegen(new Restaurant(token[0], speisekarte, token[1], token[2]));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return restaurants;
    }
}
