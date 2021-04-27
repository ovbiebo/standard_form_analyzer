import java.util.*;
import java.util.regex.*;

public class LexicalAnalyzer {
    private final Pattern regex = Pattern.compile("\\d+\\.\\d+|\\d+|[*^+-]");

    public List<String> scanInputStream(String inputStream) {
        List<String> resultList = new ArrayList<String>();
        Matcher regexMatcher = regex.matcher(inputStream);

        int lastEndIndex = 0;
        while (regexMatcher.find()) {
            //if there's some unmatched string between current match and previous match
            if (lastEndIndex != regexMatcher.start()) {
                //if said unmatched string is not just spaces, throw error
                if (!inputStream.substring(lastEndIndex, regexMatcher.start()).matches("\\s*")) {
                    throw new Error("Scanner Error: Invalid character at index " + lastEndIndex);
                }
            }
            lastEndIndex = regexMatcher.end();
            resultList.add(regexMatcher.group(0));
        }

        return resultList;
    }
}
