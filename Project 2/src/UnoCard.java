import java.util.Random;

public class UnoCard {

    public COLOR color;
    public CARD card;

    public UnoCard() {
        Random rand = new Random();
        color = COLOR.values()[rand.nextInt(5)];
        card = CARD.values()[rand.nextInt(15)];
    }

    public UnoCard(COLOR color, CARD card) {
        this.color = color;
        this.card = card;
    }

    public boolean isWild() {
        return card.equals(CARD.WILD);
    }

    public boolean isWildDraw4() {
        return card.equals(CARD.WILD_DRAW4);
    }

    public boolean isDraw2() {
        return card.equals(CARD.DRAW_2);
    }

    public boolean isReverse() {
        return card.equals(CARD.REVERSE);
    }

    public boolean isSkip() {
        return card.equals(CARD.SKIP);
    }

    public boolean isPlayable(UnoCard nextCard) {
        if (isWild() || isWildDraw4()){
            return true;
        }
        if(nextCard.card.equals(this.card) || nextCard.color.equals(this.color)){
            return true;
        }
        return false;
    }

}
