import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;
public class CsvReader
{
    public static Baum RestaurantsGeben(File file)
    {
        Baum restaurants = new Baum();
        String line = "";

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null)   //loops through every line until null found
            {
                String[] token = line.split(";");    // separate every token by comma
                Baum speisekarte = new Baum();
                for(int i = 3;i < token.length;i++)
                {
                    String[] speise = token[i].split(",");
                    String[] beilagen = speise[3].split("/");
                    speisekarte.sortiertEinfuegen(new Gericht(speise[0],Double.parseDouble(speise[1]),Double.parseDouble(speise[2]),beilagen));
                }
                restaurants.sortiertEinfuegen(new Restaurant(token[0],speisekarte,token[1],token[2]));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return restaurants;
    }
}
