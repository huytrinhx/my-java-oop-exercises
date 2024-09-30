package amazon_books_reader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.AbstractMap;
import java.util.stream.Collectors;

public class Analyzer {
    List<String[]> dataset;
    List<Book> allBooks = new ArrayList<>();

    public Analyzer(List<String[]> dataset) {
        this.dataset = dataset;
        int i = 0;
        for (String[] rowData : dataset) {
            if (i == 0) {
                i++;
                continue;
            }
            this.allBooks.add(new Book(rowData[0].replace("\"", ""), 
            rowData[1].replace("\"", ""), 
            rowData[2].replace("\"", ""),
            rowData[3].replace("\"", ""), 
            rowData[4].replace("\"", ""), 
            rowData[5].replace("\"", ""),
            rowData[6].replace("\"", "")));
            i++;
        }
    }

    public void getBookCountByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        books = allBooks.stream()
                .filter(book -> book.getAuthor().startsWith(author))
                .collect(Collectors.toList());

        System.out.format("Total number of books by %s: %d \n",
                author,
                books.size());
    }

    public void getAllBooksByAuthor(String author) {
        List<String> books = new ArrayList<>();
        books = allBooks.stream()
                .filter(book -> book.getAuthor().startsWith(author))
                .map(book -> book.getTitle())
                .collect(Collectors.toList());
        books.forEach(x -> System.out.println(x));
    }

    public void getPriceOfAllBooksByAuthor(String author) {
        List<AbstractMap.SimpleEntry<String, String>> matched = new ArrayList<>();
        matched = allBooks.stream()
                .filter(book -> book.getAuthor().startsWith(author))
                .map(book -> new AbstractMap.SimpleEntry<>(book.getTitle(), book.getPrice()))
                .collect(Collectors.toList());
        
        matched.forEach(x -> System.out.println(x.getKey() + " priced at " + x.getValue() + " by " + author));

    }

    public void getAllAuthors() {
        Set<String> authors = new HashSet<>();
        for (Book book: allBooks) {
            authors.add(book.getAuthor());
        }

        System.out.format("Total number of authors in dataset: %d \n",
                authors.size());
    }

    public void getAllBooksWithUserRating(double userRating) {
        List<AbstractMap.SimpleEntry<String, String>> matched = new ArrayList<>();
        matched = allBooks.stream()
                .filter(book -> book.getUserRating() == userRating)
                .map(book -> new AbstractMap.SimpleEntry<>(book.getTitle(), book.getAuthor()))
                .collect(Collectors.toList());
        
        matched.forEach(x -> System.out.println(x.getKey() + " by " + x.getValue()));


    }
}
