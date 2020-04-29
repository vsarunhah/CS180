public class ExtendsTwo extends Abstract {

    ExtendsTwo(String word) {
        super(word);
    }

    public void printWord() {
        System.out.println("Doing something different with " + super.getWord());
    }
}