import java.io.File;

public class CsvReaderMain
{
    public void main()
    {
        Baum restaurants = CsvReader.restaurants_geben(new File("Restaurants.csv"));
    }
}
