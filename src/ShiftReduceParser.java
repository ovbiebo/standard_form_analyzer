import models.enums.ShiftActions;

import java.util.List;
import java.util.regex.Pattern;

public class ShiftReduceParser {
    private String stack;

    public ShiftActions parse(List<String> tokens) {
        System.out.printf("%25s|%25s|%25s\n", "Stack", "Input", "Action");
//        System.out.printf("%25s|%25s|%25s\n", stack, input, "Shift");
        for (int i = 0; i < tokens.size(); i++) {
            stack = stack + tokens.get(i);
            System.out.printf("%25s|%25s|%25s\n", stack, String.join("", tokens.subList(i + 1, tokens.size())) + "$", "Shift");
            Pattern grammarRegex = Pattern.compile("\\d+|-T|\\+T|D|T\\.D|T\\*10\\^T");
            while (grammarRegex.matcher(stack).find()) {
                reduce(String.join("", tokens.subList(i + 1, tokens.size())) + "$");
            }
        }
        return ShiftActions.ERROR;
    }

    private void reduce(String input) {
        Pattern digitRegex = Pattern.compile("\\d+");
        Pattern termRegex = Pattern.compile("-T|\\+T|D|T\\.D");
        Pattern sdRegex = Pattern.compile("T\\*10\\^T");
        if (digitRegex.matcher(stack).find()) {
            stack = stack.replaceFirst(digitRegex.pattern(), "D");
        }
        if (termRegex.matcher(stack).find()) {
            stack = stack.replaceFirst(termRegex.pattern(), "T");
        }
        if (sdRegex.matcher(stack).find()) {
            stack = stack.replaceFirst(sdRegex.pattern(), "S");
        }
        System.out.printf("%25s|%25s|%25s\n", stack, input, "Reduce");
    }
}
