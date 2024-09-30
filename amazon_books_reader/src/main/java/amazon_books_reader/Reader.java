package amazon_books_reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;
import com.opencsv.CSVReader;

public class Reader {
    public List<String[]> readDataset(String file) {

        List<String[]> records = new ArrayList<>();
        try {
            // Load the CSV file from the resources folder
            InputStream inputStream = Reader.class.getClassLoader().getResourceAsStream("books_data.csv");
            if (inputStream == null) {
                System.out.println("File not found!");
                return records;
            }

            CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
            records = reader.readAll();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }
}
