import java.io.File;

public class MainBaum
{
    private Baum restaurants;
    public MainBaum()
    {
        restaurants = CsvReader.RestaurantsGeben(new File("Restaurants.csv"));
        Restaurant[] rest = restaurants.GenreSuchen("italienisch");
        for(int i = 0;i < rest.length;i++)
        {
            System.out.println(rest[i].getName());
        }



    }
}
