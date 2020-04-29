public class Extends extends Abstract {
    Extends(String word){
        super(word);
    }

    public void printWord() {
        System.out.println("Extends: " + super.getWord());
    }
}