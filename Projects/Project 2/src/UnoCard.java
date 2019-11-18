import java.util.Random;

public class UnoCard {

    public COLOR color;
    public CARD card;

    public UnoCard() {
        Random rand = new Random();
        int card = rand.nextInt(15);
        int color = rand.nextInt(4);
        this.card = CARD.values()[card];
        this.color = COLOR.values()[color];
    }

    public UnoCard(int cardB) {
        Random rand = new Random();
        int card = rand.nextInt(cardB);
        int color = rand.nextInt(4);
        this.card = CARD.values()[card];
        this.color = COLOR.values()[color];
    }

    public UnoCard(CARD card, COLOR color) {
        this.color = color;
        this.card = card;
    }

    public boolean isWild() {
        return this.card.equals(CARD.WILD);
    }

    public boolean isWildDraw4() {
        return this.card.equals(CARD.WILD_DRAW4);
    }

    public boolean isDraw2() {
        return this.card.equals(CARD.DRAW_2);
    }

    public boolean isReverse() {
        return this.card.equals(CARD.REVERSE);
    }

    public boolean isSkip() {
        return this.card.equals(CARD.SKIP);
    }

    public boolean isPlayable(UnoCard nextCard) {
        if (nextCard.card.equals(this.card)) {
            return true;
        }
        if (nextCard.card.equals(CARD.WILD_DRAW4) || nextCard.card.equals(CARD.WILD)) {
            return true;
        }
        return nextCard.color.equals(this.color);
    }

}
