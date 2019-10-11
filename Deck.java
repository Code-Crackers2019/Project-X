
import java.util.*;
public class Deck {

    public ArrayList<Card> playingDeck;
    public Stack<Card> deck;
    
//the stack is a last in first out data structure used to remove top elements and add elements.
    // the array list creates an Arrray of cards in this deck class.
    
    public Deck(){
        playingDeck=new ArrayList<>();
        deck=new Stack<>();
    }

    public void createPlayingDeck(){//Create a deck of cards(52 cards)
        deck=new Stack<>();
        for(Suit suit: Suit.values()){
            for (Value val: Value.values()){
                Card card=new Card(suit, val);// this combines suit plus card value from suit and value class
                playingDeck.add(card);
                deck.push(card);// the push element adds to the top of deck
            }
        }
    }

    public void shuffleDeck(){//shuffle the deck
        ArrayList<Card> temp=new ArrayList<>();
        Random rand=new Random();
        int cardIndex=0, deckSize=playingDeck.size();
        deck=new Stack<>();

        for (int i=0;i<deckSize;i++){
            cardIndex=rand.nextInt(playingDeck.size());//generate a random index
            temp.add(playingDeck.get(cardIndex));
            deck.push(playingDeck.get(cardIndex));
            playingDeck.remove(cardIndex);//remove the card from the playing deck
        }

        playingDeck=temp;
    }

    public Card drawCard(){//remove the card at the top of deck
        Card card=deck.pop();
        playingDeck.remove(card);
        return card;
    }
    
    public int size(){return playingDeck.size();}//get size of the deck
    
    public ArrayList<Card> getDeck(){return playingDeck;}
    
    public Card peek(){return deck.peek();}//look at the card at the top deck

    public void emptyDeck(){//remove all the cards from the deck
        ArrayList<Card> temp=new ArrayList<>();
        Stack<Card> newStack=new Stack<>();
        deck=newStack;
        playingDeck=temp;
    }

    public void addCard(Card card){//add a card to the deck
        playingDeck.add(card);
        deck.push(card);
    }

    public Card getCard(int i){//remove one card from the deck
         Card temp=playingDeck.get(i);
         playingDeck.remove(i);
         Stack<Card> tempDeck=new Stack<>();
         for(Card card: playingDeck){tempDeck.push(card);}
         deck=tempDeck;
         return temp;
    }

    public boolean contains(Value val){//check if a deck contains a certain card
      for(Card card: playingDeck){
         if(card.getValue()==val){
            return true;
         }
      }
      
      return false;
    }
    
    public String toString(){
      String res="";
      int i=0;
      for(Card card: playingDeck){
         res+=i+"-"+card.toString()+"\n";
         i++;
      }
      
      return res;
    }
    
    // goal of game to check if deck has Cards with values and suit to form AK47
    
    public boolean win(){// check if the deck contains AK47
      ArrayList<Value> vals=new ArrayList<>();
      for (Card card: playingDeck){
         Value val=card.getValue();
         if((val==Value.ACE || val==Value.KING || val==Value.FOUR || val==Value.SEVEN) && !vals.contains(val)){
            vals.add(val);
         }
      }
      if (vals.size()==4){return true;}
      else{return false;}
    }
}
