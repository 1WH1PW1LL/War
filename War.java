import java.util.*;

public class War {
    public static void main()
    {
        // The deck.
        Deck deck1 = new Deck();
        deck1.populateDeck();

        System.out.println(deck1.getDeckOfCards().size());

        Scanner keyboard = new Scanner(System.in);

        // Creating the player objects.
        String name1;
        String name2;
        System.out.println("What is the first player's name?");
        name1 = keyboard.nextLine();
        System.out.println("What is the second player's name?");
        name2 = keyboard.nextLine();
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);

        // Makes the dealer object.
        System.out.println("What is the dealer's name?");
        String dealerName;
        dealerName = keyboard.nextLine();
        Dealer dealer1 = new Dealer(dealerName);

        // Gives Everyone their cards.
        dealer1.distributeCards(deck1, player1, player2);

        // Showing both player's their cards.
        System.out.println(player1.getName() + " these are your cards." + player2.getName() + " look away.");
        for(int i = 0; i < player1.getPlayerCards().size(); i++)
        {
            System.out.println((i+1)+". " + player1.getPlayerCards().get(i).getValue() + " of " + player1.getPlayerCards().get(i).getColor());
        }
        System.out.println(player2.getName() + " these are your cards." + player1.getName() + " look away.");
        for(int j = 0; j < player2.getPlayerCards().size(); j++)
        {
            System.out.println((j+1)+". " + player2.getPlayerCards().get(j).getValue() + " of " + player1.getPlayerCards().get(j).getColor());
        }

        System.out.println(player1.getPlayerCards().size());
        System.out.println(player2.getPlayerCards().size());

        // Play game.
        int count = 0;
        while(player1.getPlayerCards().size() > 0 && player2.getPlayerCards().size() > 0 && count < 100)
        {
            int player1CardValue = 0, player2CardValue = 0;
            String player1Value, player2Value;
            player1Value = player1.getPlayerCards().get(0).getValue();
            player2Value = player2.getPlayerCards().get(0).getValue();

            System.out.println(player1.getName() + " uses " + player1.getPlayerCards().get(0).getValue() + " of " + player1.getPlayerCards().get(0).getColor() + " vs. " + player2.getName() + " uses " + player2.getPlayerCards().get(0).getValue() + " of " + player2.getPlayerCards().get(0).getColor());

            player1CardValue = War.stringValueToInt(player1Value);
            player2CardValue = War.stringValueToInt(player2Value);

            if(player1CardValue > player2CardValue)
            {
                player1.getPlayerCards().add(player1.getPlayerCards().get(0));
                player1.getPlayerCards().add(player2.getPlayerCards().get(0));
                player1.getPlayerCards().remove(0);
                player2.getPlayerCards().remove(0);
            }
            else if(player1CardValue < player2CardValue)
            {
                player2.getPlayerCards().add(player1.getPlayerCards().get(0));
                player2.getPlayerCards().add(player2.getPlayerCards().get(0));
                player1.getPlayerCards().remove(0);
                player2.getPlayerCards().remove(0);
            }
            else if(player1CardValue == player2CardValue)
            {
                System.out.println("War!!!!!!!!!!!!!!!!!!!!");
                int i = 0;
                while(player1CardValue == player2CardValue)
                {
                    i+=4;
                    player1CardValue = War.stringValueToInt(player1.getPlayerCards().get(i).getValue());
                    player2CardValue = War.stringValueToInt(player2.getPlayerCards().get(i).getValue());
                }

                if(player1CardValue > player2CardValue)
                {
                    System.out.println(player1.getName() + " uses " + player1.getPlayerCards().get(i).getValue() + " of " + player1.getPlayerCards().get(i).getColor() + " vs. " + player2.getName() + " uses " + player2.getPlayerCards().get(i).getValue() + " of " + player2.getPlayerCards().get(i).getColor());
                    System.out.println(player1.getName() + " wins " + (i+1) + " cards after " + (i+1)/5 + " rounds of war.");
                    for(int j = 0; j <= i; j++)
                    {
                        player1.getPlayerCards().add(player1.getPlayerCards().get(0));
                        player1.getPlayerCards().add(player2.getPlayerCards().get(0));
                        player1.getPlayerCards().remove(0);
                        player2.getPlayerCards().remove(0);
                    }
                }
                else if(player1CardValue < player2CardValue)
                {
                    System.out.println(player1.getName() + " uses " + player1.getPlayerCards().get(i).getValue() + " of " + player1.getPlayerCards().get(i).getColor() + " vs. " + player2.getName() + " uses " + player2.getPlayerCards().get(i).getValue() + " of " + player2.getPlayerCards().get(i).getColor());
                    System.out.println(player2.getName() + " wins " + (i+1) + " cards after " + (i+1)/5 + " rounds of war.");
                    for(int j = 0; j <= i; j++)
                    {
                        player2.getPlayerCards().add(player1.getPlayerCards().get(0));
                        player2.getPlayerCards().add(player2.getPlayerCards().get(0));
                        player1.getPlayerCards().remove(0);
                        player2.getPlayerCards().remove(0);
                    }
                }
            }
            System.out.println(player1.getName() + ": " + player1.getPlayerCards().size() + "             " + player2.getName() +": "+ player2.getPlayerCards().size());   
            System.out.println();
            count++;
        }

        if(player1.getPlayerCards().size()>player2.getPlayerCards().size())
        {
            System.out.println(player1.getName() + " has won in " +count+" rounds!");
        }
        else if(player2.getPlayerCards().size()>player1.getPlayerCards().size())
        {
            System.out.println(player2.getName() + " has won in " +count+" rounds!");
        }
        System.out.println();
        System.out.println("Final Score: ");
        System.out.println(player1.getName() + ": " + player1.getPlayerCards().size() + "             " + player2.getName() + player2.getPlayerCards().size());   
    }

    public static int stringValueToInt(String player1Value)
    {
        int player1CardValue = 0;
        if(player1Value.equals("2") || player1Value.equals("3") || player1Value.equals("4") || player1Value.equals("5") || player1Value.equals("6") || player1Value.equals("7") || player1Value.equals("8") || player1Value.equals("9") || player1Value.equals("10"))
        {
            player1CardValue = Integer.valueOf(player1Value);
        }
        else if(player1Value.equals("Jack"))
        {
            player1CardValue = 11;
        }
        else if(player1Value.equals("Queen"))
        {
            player1CardValue = 12;
        }
        else if(player1Value.equals("King"))
        {
            player1CardValue = 13;
        }
        else if(player1Value.equals("Ace"))
        {
            player1CardValue = 14;
        }
        return player1CardValue;
    }
}
