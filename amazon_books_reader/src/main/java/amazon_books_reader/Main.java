package amazon_books_reader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader datasetReader = new Reader();
        List<String[]> dataset = datasetReader.readDataset("books_data.csv");
        Analyzer analyzer = new Analyzer(dataset);

        analyzer.getBookCountByAuthor("J.K. Rowling");

        analyzer.getAllAuthors();

        analyzer.getAllBooksWithUserRating(4.0);

        analyzer.getAllBooksByAuthor("J.K. Rowling");

        analyzer.getPriceOfAllBooksByAuthor("George R. R. Martin");

    }
}