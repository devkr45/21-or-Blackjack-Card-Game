import java.util.Arrays;
import java.util.Collections;

public class Deck {
    private Card[] cards;
    private int cardPosition;

    public Deck() {
        cardPosition = 0;
        cards = new Card[52];
        for (int i = 1; i < 53; i++) {
            if (i % 13 == 0) {
                cards[i-1] = new Card(13);
            }
            else {
                cards[i - 1] = new Card(i % 13);
            }
        }
    }
    public void shuffle() {
        // Shuffle the cards using the shuffle method from the Collections class
        Collections.shuffle(Arrays.asList(cards));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.length; i++) {
            sb.append(cards[i].toString());
            sb.append(" ");
        }

        return sb.toString();
    }

    public Card getCard() {
        Card card = cards[cardPosition];
        cardPosition = cardPosition + 1;
        return card;

    }
}
