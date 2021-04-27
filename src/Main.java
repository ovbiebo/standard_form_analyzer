import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static LexicalAnalyzer lex;
    List<String> symbolTable = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner inputObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter input stream");

        String inputStream = inputObj.nextLine();  // Read user input
        lex = new LexicalAnalyzer();

        System.out.println("\nOutput of Lexical Analysis for " + "-1.764 * 10^-4" + ":\n" + lex.scanInputStream("-1.764 * 10^-4").toString());

        System.out.println("\nOutput of Lexical Analysis for " + "+7.999 * 10^3" + ":\n" + lex.scanInputStream("+7.999 * 10^3").toString());

        ShiftReduceParser shiftReduceParser = new ShiftReduceParser();

        shiftReduceParser.parse(lex.scanInputStream("-1.764 * 10^-4"));
    }
}
