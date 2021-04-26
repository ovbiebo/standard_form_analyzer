import java.util.Scanner;

public class Main {
    private static LexicalAnalyzer lex;

    public static void main(String[] args) {
        Scanner inputObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter input stream");

        String inputStream = inputObj.nextLine();  // Read user input
        lex = new LexicalAnalyzer("as seen on screen");

        System.out.println("Output of Lexical Analysis:\n\n" + lex.getOutput() + "\n");
    }
}
