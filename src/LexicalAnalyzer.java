import java.util.*;
import java.util.regex.*;

public class LexicalAnalyzer {
    private final Pattern regex = Pattern.compile("\\d+|[.*^+-]");

    public List<String> scanInputStream(String inputStream) {
        List<String> resultList = new ArrayList<String>();
        Matcher regexMatcher = regex.matcher(inputStream);

        while (regexMatcher.find()) {
            resultList.add(regexMatcher.group(0));
        }

        return resultList;
    }
}
