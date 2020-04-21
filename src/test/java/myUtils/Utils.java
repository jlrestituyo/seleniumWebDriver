package myUtils;
import com.opencsv.CSVReader;
import org.openqa.selenium.*;



import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Utils {
    public WebDriver driver;


    public List<String[]> readCSVFile(String filePath){
        List<String[]> records = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVReader csvReader = new CSVReader(reader);

            records = csvReader.readAll();

        }catch(IOException e){
            e.printStackTrace();
        }

        return records;

    }


}
