import java.util.ArrayList;
import java.util.List;

public class BlackJackGame {

    private List<Card> dealerCard;
    private List<Card> playerCard;
    private int playerTotal;
    private int dealerTotal;


    public BlackJackGame() {

        dealerCard = new ArrayList<>();
        playerCard = new ArrayList<>();
    }
    // Return true if the player has bust, false otherwise
    public void hitPlayer(Card card) {
        // Add a card to the player card

        playerCard.add(card);

    }

    public void reset() {
        // Reset the whole dealer and players card

        dealerCard.clear();
        dealerTotal = 0;

        playerCard.clear();
        playerTotal = 0;
    }


    // Returns 1 if player is the winner -1 if the dealer is the winner and 0 if it is a tie
    public int determineWinner() {
        // Check if the player has bust
        if (this.getPlayerTotal() > 21) {
            return 1;
        }

        // Check if the dealer has bust
        if (dealerTotal > 21) {
            return -1;
        }

        // Compare the player's and dealer's totals
        if (playerTotal > dealerTotal) {
            return 1;
        } else if (playerTotal < dealerTotal) {
            return -1;
        } else {
            return 0;
        }
    }


    public void hitDealer(Card card) {
        // Check if the total is already 17 or over
        dealerCard.add(card);

    }

    public int getPlayerTotal() {
        int total = 0;
        for(Card c: playerCard) {
            total += c.getValue();
        }
        return total;
    }

    public int getDealerTotal() {
        int total = 0;
        for(Card c: dealerCard) {
            total += c.getValue();
        }
        return total;
    }

    public List<Card> getDealerCard() {
        return dealerCard;
    }

    public List<Card> getPlayerCard() {
        return playerCard;
    }

    public String getPlayerCardString() {
        String s = "Your Cards are:";
        for (Card c : this.getPlayerCard()) {
            s += " " +c.getValue();
        }

        return s;
    }
}

