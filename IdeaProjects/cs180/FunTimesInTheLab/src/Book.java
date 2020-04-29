import java.math.BigDecimal; 

public class Book {
    private String title;
    private String author; 
    private int wordCount; 
    private BigDecimal totalSales; 

    public Book(String title, String author, int wordCount) {
        this.title = title;
        this.author = author; 
        this.wordCount = wordCount; 
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author; 
    }

    public int getWordCount() {
        return wordCount; 
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }
   
    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales; 
    }
}
