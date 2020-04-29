public abstract class Abstract {
    private String word;
    Abstract(String word){
        this.word = word;
    }
    public abstract void printWord();

    public String getWord() {
        return this.word;
    }
}