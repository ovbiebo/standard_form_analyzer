import models.enums.ShiftActions;

import java.util.List;
import java.util.regex.Pattern;

public class ShiftReduceParser {
    private String stack;

    public ShiftActions parse(List<String> tokens) {
        stack = "$";
        tokens.add("$");

        System.out.printf("%30s|%30s|%30s\n", "Stack", "Input", "Action");
        System.out.printf("%30s|%30s|%30s\n", stack, tokens, "");
        System.out.printf("%25s|%25s|%25s\n", "Stack", "Input", "Action");
        for (int i = 0; i < tokens.size(); i++) {
            stack = stack + tokens.get(i);
            System.out.printf("%30s|%30s|%30s\n", stack, tokens.subList(i+1, tokens.size()), "Shift");
            Pattern grammarRegex = Pattern.compile("\\d+|-T|\\+T|N|T\\.N|T\\*10\\^T");
            while (grammarRegex.matcher(stack).find()) {
                reduce(tokens.subList(i+1, tokens.size()).toString());
            }
        }
        return ShiftActions.ERROR;
    }

    private void reduce(String input) {
        Pattern numberRegex = Pattern.compile("\\d+\\.\\d+|\\d+");
        Pattern termRegex = Pattern.compile("-T|\\+T|N");
        Pattern sdRegex = Pattern.compile("T\\*10\\^T");
        if (numberRegex.matcher(stack).find()) {
            stack = stack.replaceFirst(numberRegex.pattern(), "N");
        }
        if (termRegex.matcher(stack).find()) {
            stack = stack.replaceFirst(termRegex.pattern(), "T");
        }
        if (sdRegex.matcher(stack).find()) {
            stack = stack.replaceFirst(sdRegex.pattern(), "S");
        }
        System.out.printf("%30s|%30s|%30s\n", stack, input, "Reduce");
    }
}
