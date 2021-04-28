import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LexicalAnalyzer lex = new LexicalAnalyzer();
        ShiftReduceParser shiftReduceParser = new ShiftReduceParser();

        Scanner inputObj = new Scanner(System.in);
        while (true) {
            System.out.print("\nSelect an input method\n\n1. Enter input manually.\n2. Use default input\n\nAnswer here: ");
            String inputType = inputObj.nextLine();

            String inputStream;

            if (inputType.equals("1")) {
                System.out.print("\nPlease enter a sentence here: ");
                try {
                    inputStream = inputObj.nextLine();
                    analyze(inputStream, lex, shiftReduceParser);
                } catch (Error error) {
                    System.out.println(error.getMessage());
                }
            } else if (inputType.equals("2")) {
                try {
                    inputStream = "-1.764 * 10^-4";
                    analyze(inputStream, lex, shiftReduceParser);
                    inputStream = "+7.999 * 10^3";
                    analyze(inputStream, lex, shiftReduceParser);
                } catch (Error error) {
                    System.out.println(error.getMessage());
                }
            } else {
                System.out.println("Invalid input. Please select an option by entering '1' or '2'.");
            }
        }
    }

    private static void analyze(String inputStream, LexicalAnalyzer lex, ShiftReduceParser shiftReduceParser) {
        System.out.println("\nOutput of Lexical Analysis for " + inputStream + ":");
        List<String> lexOutput = lex.scanInputStream(inputStream);
        System.out.println(lexOutput.toString());

        System.out.println("\nOutput of Syntax Analysis for " + inputStream + ":");
        System.out.println(shiftReduceParser.parse(lexOutput));
    }
}
