package types;

import exceptions.FishColorException;
import interfaces.ColorChangeable;
import variables.CatchMethod;
import variables.Food;
import variables.Month;

import java.util.Random;

/**
* Oama fish object class.
* Baby/base class for Weke
* Parent to Weke_a and Weke_ula
* @author Michaela Gillan
* @since 2/18/24
*/

public class Oama extends FishableI_a implements ColorChangeable {
   
   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double OAMA_MAX_LENGTH = 7.0;
   
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double OAMA_MIN_LENGTH = 0.01;

   /** 
   * Default constructor.
   */
   public Oama() {
      this(OAMA_MIN_LENGTH);
   } 
   
   /** 
   * Constructor with length parameter.
   * @param length is the fish's length
   */
   public Oama(double length) {
      this(
            "'Oama",
            OAMA_MAX_LENGTH,
            OAMA_MIN_LENGTH,
            length,
            0.1,
            new Food[] {
               Food.INVERTEBRATES,
               Food.MOLLUSK,
               Food.WORMS
            },
            "white with yellow stripe",
            "yellow or white", 
            "none",
            0,
            new Month[] {},
           true,
           new CatchMethod[] {
               CatchMethod.NET,
               CatchMethod.POLE,
               CatchMethod.TRAP
           },
           50
         );
      this.initLength();
      this.initSex();
   }
   
   /**
   * Constructor with all parameters.
   * @param name is the fish's name
   * @param maxLen is the fish's maximum length
   * @param minLen is the fish's minimum length
   * @param length is the fish's length
   * @param weight is the fish's weight
   * @param diet is the fish's diet
   * @param bodyColor is the fish's body color
   * @param finColor is the fish's fin color
   * @param sex is the fish's sex
   * @param legalSize the fish's legal size
   * @param seasonMonths the fish's season
   * @param isBait a boolean for if the item is a bait
   * @param catchMethods the different methods to catc the fish
   * @param bagLimit how many fish can you have in the bag
   */
   public Oama(
         String name,
         double maxLen,
         double minLen,
         double length,
         double weight,
         Food[] diet,
         String bodyColor,
         String finColor,
         String sex,
         double legalSize,
         Month[] seasonMonths,
         boolean isBait,
         CatchMethod[] catchMethods,
         int bagLimit
   ) {
      super(
            name,
            "Goatfish",
            "Mulloidichthys",
            maxLen,
            minLen,
            length,
            weight,
            diet,
            bodyColor,
            finColor,
            sex,
            legalSize,
            seasonMonths,
            isBait,
              catchMethods,
            bagLimit
         );
   }


/** returns new Weke'a or Weke'Ula version of this fish.
   * When Oama reaches maxLength, it levelUps to Weke'a/Weke'Ula of minLength
   * min size of next size is always max length of this one
   * @return a new Weke_a||Weke_Ula
   */
   public Oama levelUp() {
   
      Random rand = new Random(); 
      int randomWeke = rand.nextInt(2);
      
      if (randomWeke == 0) {
         return new Weke_a(this.maxLength);
      } else { 
         return new Weke_ula(this.maxLength);
      } 
   
   }
   
   /** 
   * changes this Oama's color.
   * Oama cannot change sex. Can only change at levelUp
   * @throws FishColorException always
   * @param bodyColor This fish's Body Color.
   * @param finColor This fish's Fin Color.
   * @throws UnsupportedOperationException if fish cant change color
   */
   public void setColor(String bodyColor, String finColor) {
      if (this.name.equals("Weke'a") || this.name.equals("Weke'ula")) {
         this.bodyColor = bodyColor;
         this.finColor = finColor;
      } else {
         //For some reason junit wants this exception to be thrown instead
         throw new UnsupportedOperationException("Oama cannot change color.");
      } //closes if-else statement
   }
} //end main