
public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit face, Value faceVal){
        suit=face;
        value=faceVal;
    }

    public Value getValue(){return value;}
    
    public String toString(){return value+" of "+suit;}

}
