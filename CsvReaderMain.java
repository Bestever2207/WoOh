import java.io.File;

public class CsvReaderMain
{
    public void main()
    {
        Baum restaurants = CsvReader.RestaurantsGeben(new File("Restaurants.csv"));
    }
}
