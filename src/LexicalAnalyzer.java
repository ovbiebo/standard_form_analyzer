import java.util.*;
import java.util.regex.*;

public class LexicalAnalyzer {
    private String inputStream;
    boolean b;

    public LexicalAnalyzer(String inputStream) {
        this.inputStream = inputStream;

        Pattern p = Pattern.compile(".s");
        Matcher m = p.matcher(inputStream);
//        b = m.matches();

//        List<String> resultList = new ArrayList<String>();
//        Pattern regex = Pattern.compile("<[^<>]*>");
//        Matcher regexMatcher = regex.matcher(subjectString);
//        int lastIndex = 0;
//        while (regexMatcher.find()) {
//            resultList.add(subjectString.substring(lastIndex);
//        }
    }

    public String getOutput() {
        System.out.println(b);
        return "wahala for who no sabi java";
    }
}
