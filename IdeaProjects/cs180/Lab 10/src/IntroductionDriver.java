import java.util.Scanner;

public class IntroductionDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String wordOne = scan.nextLine();
        String wordTwo = scan.nextLine();
        Abstract firstExample = new Extends(wordOne);
        Abstract secondExample = new ExtendsTwo(wordTwo);

        handleExamples(firstExample);
        handleExamples(secondExample);
    }

    public static void handleExamples(Abstract example){
        example.printWord();
    }
}
