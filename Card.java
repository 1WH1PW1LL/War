public class Card {
    private String value;
    
    public String getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    private String color;

    public Card(String value, String color)
    {
        this.value = value;
        this.color = color;
    }
    
}
