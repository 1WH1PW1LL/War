import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deckOfCards = new ArrayList<>(52); 

    public ArrayList<Card> getDeckOfCards()
    {
        return deckOfCards;
    }

    public Deck()
    {

    }

    public Deck(ArrayList<Card> deckOfCards)
    {
        this.deckOfCards = deckOfCards;
    }

    public void populateDeck()
    {
        for(int i = 2; i <= 10; i++)
        {
            deckOfCards.add(new Card(Integer.toString(i), "Spades"));
            deckOfCards.add(new Card(Integer.toString(i), "Diamonds"));
            deckOfCards.add(new Card(Integer.toString(i), "Hearts"));
            deckOfCards.add(new Card(Integer.toString(i), "Clubs"));
        }

        deckOfCards.add(new Card("Jack", "Spades"));
        deckOfCards.add(new Card("Jack", "Diamonds"));
        deckOfCards.add(new Card("Jack", "Hearts"));
        deckOfCards.add(new Card("Jack", "Clubs"));
        deckOfCards.add(new Card("Queen", "Spades"));
        deckOfCards.add(new Card("Queen", "Diamonds"));
        deckOfCards.add(new Card("Queen", "Hearts"));
        deckOfCards.add(new Card("Queen", "Clubs"));
        deckOfCards.add(new Card("King", "Spades"));
        deckOfCards.add(new Card("King", "Diamonds"));
        deckOfCards.add(new Card("King", "Diamonds"));
        deckOfCards.add(new Card("Ace", "Hearts"));
        deckOfCards.add(new Card("Ace", "Spades"));
        deckOfCards.add(new Card("Ace", "Diamonds"));
        deckOfCards.add(new Card("Ace", "Diamonds"));
        deckOfCards.add(new Card("Ace", "Hearts"));
    }

}
