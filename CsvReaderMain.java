import java.io.File;

public class CsvReaderMain
{
    private Baum restaurants;
    public void main()
    {
        restaurants = CsvReader.RestaurantsGeben(new File("Restaurants.csv"));
    }
}
