import java.io.File;

public class MainBaum
{
    public MainBaum()
    {
        Baum restaurants = CsvReader.RestaurantsGeben(new File("Restaurants.csv"));
        Restaurant[] rest = restaurants.GenreSuchen("italienisch");
        for (Restaurant restaurant : rest) {
            System.out.println(restaurant.getName());
        }
    }
}
