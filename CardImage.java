import javax.swing.ImageIcon;

/** extends Card class to include ImageIcon of card */
public class CardImage extends Card {
    // ImageIcon to store the card image
    private ImageIcon image;

    /**
        default constructor takes suit, rank, and image
        @param suit int value of suit
        @param rank int value of rank
        @param image ImageIcon of card image
    */
    public CardImage(int suit, int rank, ImageIcon image) {
        super(suit,rank);
        this.image = image;
    }

    /**
        alternate constructor takes suit, rank, and image
        @param suit int value of suit
        @param rank int value of rank
        @param imageFilename String of filename to image
    */
    public CardImage(int suit, int rank, String imageFilename) {
        super(suit,rank);
        image = new ImageIcon(imageFilename);
    }

    /**
        alternate constructor takes suit, rank, and image
        @param rawCard Card object to be emulated
        @param image ImageIcon of card image
    */
    public CardImage(Card rawCard, ImageIcon image) {
        super(rawCard);
        this.image = image;
    }

    /**
        alternate constructor takes suit, rank, and image
        @param rawCard Card object to be emulated
        @param imageFilename String of filename to image
    */
    public CardImage(Card rawCard, String imageFilename) {
        super(rawCard);
        image = new ImageIcon(imageFilename);
    }

    /**
        getImage() returns the image of the card
        @return ImageIcon of the card
    */
    public ImageIcon getImage() {
        return image;
    }
}
