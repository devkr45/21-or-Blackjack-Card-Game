import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Deck deck = new Deck();
        deck.shuffle();
        BlackJackGame game = new BlackJackGame();
        game.hitPlayer(deck.getCard());
        game.hitDealer(deck.getCard());
        game.hitPlayer(deck.getCard());
        game.hitDealer(deck.getCard());

        System.out.println(game.getPlayerCardString());
        System.out.println("Dealers Cards: " + game.getDealerCard().get(0).getValue());

        // Check if total of player or dealer is 21
        if (game.getPlayerTotal() == 21 && game.getDealerTotal() == 21) {
            System.out.println("BlackJack!!!! Draw");
        } else if (game.getPlayerTotal() == 21) {
            System.out.println("Player Wins!!! BlackJack");
        } else if (game.getDealerTotal() == 21) {
            System.out.println("Dealer Wins!!! BlackJack");

        }

        while (game.getPlayerTotal() < 21) {  // Hit the player a maximum of 5 times
            System.out.print("Do you want to hit: ");
            Scanner input = new Scanner(System.in);
            String yOrN = input.nextLine();
            if (yOrN.equals("Y")) {
                game.hitPlayer(deck.getCard());

                if (game.getPlayerTotal() == 21) {
                    break;  // Stop the loop if the player reaches 21
                }
            } else {
                break;
            }

            System.out.println(game.getPlayerCardString());
            System.out.println("Dealers Cards: " + game.getDealerCard().get(0).getValue());
        }

        while (game.getDealerTotal() < 17) {  // Hit the dealer a maximum of 5 times
            game.hitDealer(deck.getCard());
            if (game.getDealerTotal() == 21) {
                break;  // Stop the loop if the dealer reaches 21
            }
        }

        if (game.getPlayerTotal() > 21) {
            System.out.println("Dealers win!! Player busted");
        } else if (game.getPlayerTotal() == 21 && game.getDealerTotal() == 21) {
            System.out.println("Game Tie");
        } else if (game.getDealerTotal() > 21) {
            System.out.println("Players win!!! Dealer busted");
        }
        else if (game.getPlayerTotal() == game.getDealerTotal()){
            System.out.println("Game Tie");
        }
        else if (game.getPlayerTotal() > game.getDealerTotal()) {
            System.out.println("Player Win!!!");
        }
        else {
            System.out.println("Dealer Win!!");
        }


        // print the dealer card
        System.out.print("Dealers Cards: ");
        for(Card c: game.getDealerCard()) {
            System.out.print(c.getValue() + " ");
        }
        System.out.println();
    }
}