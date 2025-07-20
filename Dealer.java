import java.util.*;

public class Dealer {
    private String name;

    public String getName()
    {
        return this.name;
    }

    public Dealer(String name)
    {
        this.name = name;
    }

    public void distributeCards(Deck deck1, Player player1, Player player2)
    {
        Random random1 = new Random();
        int number1;
        int number2;
        int counter = deck1.getDeckOfCards().size()/2;
        while(counter > 0)
        {
            number1 = random1.nextInt(0,deck1.getDeckOfCards().size());
            player1.getPlayerCards().add(deck1.getDeckOfCards().get(number1));
            deck1.getDeckOfCards().remove(number1);
            number2 = random1.nextInt(0, deck1.getDeckOfCards().size());
            player2.getPlayerCards().add(deck1.getDeckOfCards().get(number2));
            deck1.getDeckOfCards().remove(number2);
            counter--;
        }
    }
}
