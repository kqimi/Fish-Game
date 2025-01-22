import types.FishableI_a;
import variables.Food;

import java.util.ArrayList;
/**
* Player class.
* @author Rtts
* @since 03/21/2024
*/
public class Player {
   
   /** The players name. */
   private final String name;
   
   /** The players sack of fish. */
   private ArrayList<FishableI_a> sack = new ArrayList<FishableI_a>();
   
   /** The players bag of fish food. */
   private ArrayList<Food> bag = new ArrayList<>();
   
   /**
   * Constructor.
   * @param pName is the players name
   */
   public Player(String pName) {
      this.name = pName;
   
   } //closes constructor
   
   /**
   * Makes and returns a string with player info.
   * @return String with player info 
   */
   public String toString() {
      String s = "Name: " + this.name + "\nFish currently in your sack: "
         + this.sack.size() + "\n";
      
      return s;
   } //closes toString
   
/**=============================ACCSESSOR METHODS=============================*/
   
   /**
   * Gets the players name.
   * @return the players name
   */
   public String getName() {
      return this.name;
   
   } //closes getName
   
   /**
   * Gets the players the players sack of fish.
   * @return the players sack of fish
   */
   public ArrayList<FishableI_a> getSack() {
      return this.sack;
   
   } //closes getSack
   
/**==============================MUTATOR METHODS==============================*/
   
   /**
   * Adds a fish to the player sack.
   * @param ia is the fish to add to the sack
   */
   public void addToSack(FishableI_a ia) {
      sack.add(ia);
   
   } //closes addToSack

   /**
    * Gets the players bag of fish food.
    * @return the players bag of fish food
    */
   public ArrayList<Food> getBag() {
      return this.bag;
   } //closes getBag

} //closes Player