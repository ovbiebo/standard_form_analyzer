import models.enums.ShiftActions;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ShiftReduceParser {
    private final HashMap<String, String> grammar;
    private final Stack<String> stack;

    public ShiftReduceParser(HashMap<String, String> grammar) {
        this.grammar = grammar;
        this.stack = new Stack<>();
        this.stack.add("$");
    }

    public ShiftActions parse(List<String> tokens) {
        for (String token : tokens) {
//            // if token is in grammar reduce
//            if (grammar.containsKey(token)) {
//                // reduce
//                stack.push(token);
//                reduce();
//            } else {
//                // shift
//                stack.push(token);
//            }
            stack.push(token);
            if (grammar.containsKey(token)) {
                reduce(token);
            }
        }
        return ShiftActions.ERROR;
    }

    private void reduce(String token) {

    }
}
