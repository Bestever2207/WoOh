import java.io.File;

public class MainBaum
{
    public MainBaum()
    {
        Baum restaurants = CsvReader.restaurants_geben(new File("Restaurants.csv"));
        Restaurant[] rest = restaurants.genre_suchen("italienisch");
        for (Restaurant restaurant : rest) {
            System.out.println(restaurant.getName());
        }
    }
}
