import javax.swing.ImageIcon;

/** extends Card class to include ImageIcon of card */
public class CardImage extends Card {

    /**
        default constructor takes suit and rank
        @param suit int value of suit
        @param rank int value of rank
    */
    public CardImage(int suit, int rank) {
        super(suit,rank);
    }

    /**
        alternate constructor takes Card object
        @param rawCard Card object to be emulated
    */
    public CardImage(Card rawCard) {
        super(rawCard);
    }

    /**
        getImage() returns the image of the card
        @return ImageIcon of the card
    */
    public ImageIcon getImage() {
        return new ImageIcon("Card_images/" + super.toString().toLowerCase().replace(' ','_') + ".png");
    }
}
