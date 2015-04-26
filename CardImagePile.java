import java.util.ArrayList;

/** queue front-end specifically for CardImage objects */
public class CardImagePile extends CardPile {

    /** no-arg constructor */
    public CardImagePile() {
        super();
    }

    /**
        constructor that takes a Queue as input
        @param queue Queue to be converted to CardPile
    */
    public CardImagePile(Queue queue) {
        super(queue);
    }

    /**
        constructor that takes a CardImage array as input
        @param array CardImage [] array to be converted to CardPile
    */
    public CardImagePile(CardImage [] array) {
        super(array);
    }

    /**
        constructor that takes a CardImage ArrayList as input
        @param list ArrayList of CardImage objects to be converted to CardPile
    */
    public CardImagePile(ArrayList<CardImage> list) {
        // calls the superclass constructor for arrays
        super(list.toArray(new CardImage[list.size()]));
    }

    /**
        returns the top card
        @return Top card from the deck
    */
    public CardImage draw() {
        return (CardImage) super.draw(); // simply casts superclass output to CardImage class
    }
}
