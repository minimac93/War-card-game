/** Exception thrown when an attempt is made to draw
from a card pile that is empty */
public class DeckException extends RuntimeException {
    public DeckException(String s) {
        super(s);
    }
}
