import java.math.BigDecimal; 

public class Novel extends Book{
    private String protagonist; 
    private String antagonist; 
    private String plot; 

    public Novel(String title, String author, int wordCount, String protagonist, String antagonist, String plot) {
        super(title, author, wordCount);
        this.protagonist = protagonist;
        this.antagonist = antagonist; 
        this.plot = plot; 
    }


   public String getProtagonist() {
        return protagonist;
    }

    public String getAntagonist() {
        return antagonist; 
    }

    public String getPlot() {
        return plot; 
    }
}
