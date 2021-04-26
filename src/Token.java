public class Token {
    private final String name;
    private int attributeValue;

    public Token(String name) {
        this.name = name;
    }

    public Token(String name, int attributeValue) {
        this.name = name;
        this.attributeValue = attributeValue;
    }

    public String getName() {
        return name;
    }

    public int getAttributeValue() {
        return attributeValue;
    }
}
