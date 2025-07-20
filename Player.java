import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> playerCards = new ArrayList<>();
    private int numCards = playerCards.size();
    
    public String getName() {
        return name;
    }

    public int getNumCards() {
        return numCards;
    }

    public ArrayList<Card> getPlayerCards()
    {
        return playerCards;
    }

    public Player(String name)
    {
        this.name = name;
    }

    public Player(String name, int numCards, ArrayList<Card> playerCards)
    {
        this.name = name;
        this.numCards = numCards;
        this.playerCards = playerCards;
    }
}
