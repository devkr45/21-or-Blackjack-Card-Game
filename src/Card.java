
public class Card {

    private int cardValue;

    public Card(int cardValue) {
        this.cardValue = cardValue;
    }

    public int getValue() {
        if (this.cardValue >= 10) {
            return 10;
        }
        else {
            return this.cardValue;
        }
    }
    @Override
    public String toString() {
        return  String.valueOf(cardValue);
    }

}
