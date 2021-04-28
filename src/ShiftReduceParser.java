import models.enums.ShiftActions;

import java.util.List;
import java.util.regex.Pattern;

public class ShiftReduceParser {
    private String stack;

    public ShiftActions parse(List<String> tokens) {
        stack = "$";
        List<String> input = tokens;
        input.add("$");

        System.out.printf("%20s|%35s|%20s\n", "Stack", "Input", "Action");
        for (int i = 0; i < tokens.size() - 1; i++) {
            input = tokens.subList(i + 1, tokens.size());
            System.out.printf("%20s|%35s|%20s\n", stack, input, "Shift");
            stack = stack + tokens.get(i);
            Pattern grammarRegex = Pattern.compile("\\d+|-T|\\+T|N|T\\.N|T\\*10\\^T");
            while (grammarRegex.matcher(stack).find()) {
                reduce(input.toString());
            }
        }
        if (stack.equals("$S")) {
            System.out.printf("%20s|%35s|%20s\n", stack, input, ShiftActions.ACCEPT);
            return ShiftActions.ACCEPT;
        }
        System.out.printf("%20s|%35s|%20s\n", stack, input, ShiftActions.ERROR);
        return ShiftActions.ERROR;
    }

    private void reduce(String input) {
        Pattern numberRegex = Pattern.compile("\\d+\\.\\d+|\\d+");
        Pattern termRegex = Pattern.compile("-T|\\+T|N");
        Pattern sdRegex = Pattern.compile("T\\*T\\^T");
        if (numberRegex.matcher(stack).find()) {
            System.out.printf("%20s|%35s|%20s\n", stack, input, "Reduce");
            stack = stack.replaceFirst(numberRegex.pattern(), "N");
        }
        if (termRegex.matcher(stack).find()) {
            System.out.printf("%20s|%35s|%20s\n", stack, input, "Reduce");
            stack = stack.replaceFirst(termRegex.pattern(), "T");
        }
        if (sdRegex.matcher(stack).find()) {
            System.out.printf("%20s|%35s|%20s\n", stack, input, "Reduce");
            stack = stack.replaceFirst(sdRegex.pattern(), "S");
        }
    }
}
