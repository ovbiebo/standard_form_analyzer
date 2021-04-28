import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Scanner inputObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter input stream");

//        String inputStream = inputObj.nextLine();  // Read user input
        String inputStream;  // Read user input

        LexicalAnalyzer lex = new LexicalAnalyzer();
        ShiftReduceParser shiftReduceParser = new ShiftReduceParser();

        try {
            inputStream = "-1.764 * 10^-4";

            System.out.println("\nOutput of Lexical Analysis for " + inputStream + ":");
            List<String> lexOutput = lex.scanInputStream(inputStream);
            System.out.println(lexOutput.toString());

            System.out.println("\nOutput of Syntax Analysis for " + inputStream + ":");
            System.out.println(shiftReduceParser.parse(lexOutput));
        } catch (Error error) {
            System.out.println(error.getMessage());
        }

        try {
            inputStream = "+7.999 * 10^3";

            System.out.println("\nOutput of Lexical Analysis for " + inputStream + ":");
            List<String> lexOutput = lex.scanInputStream(inputStream);
            System.out.println(lexOutput.toString());

            System.out.println("\nOutput of Syntax Analysis for " + inputStream + ":");
            System.out.println(shiftReduceParser.parse(lexOutput));
        } catch (Error error) {
            System.out.println(error.getMessage());
        }
    }
}
