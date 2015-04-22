import javax.swing.ImageIcon;

public class CardImage extends Card {
    private ImageIcon image;

    public CardImage(int suit, int rank, ImageIcon image) {
        super(suit,rank);
        this.image = image;
    }

    public CardImage(int suit, int rank, String imageFilename) {
        super(suit,rank);
        image = new ImageIcon(imageFilename);
    }

    public CardImage(Card rawCard, ImageIcon image) {
        super(rawCard);
        this.image = image;
    }

    public CardImage(Card otherCard, String imageFilename) {
        super(otherCard);
        image = new ImageIcon(imageFilename);
    }

    public ImageIcon getImage() {
        return image;
    }
}
