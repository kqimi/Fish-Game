package types;

import interfaces.SexChangeable;
import variables.CatchMethod;
import variables.Food;
import variables.Month;

/**
* Moi-li'i fish object class.
* Smallest type version of Moi fish
* Parent class to Moi Mana
* @author Lisa Miller
* @version 1.0
* @since 2/11/22
*/
public class MoiLi_i extends FishableI_a implements SexChangeable {

   // Constants for this fish.
   // protected will be inherited by subclasses unless replaced
   /** constant reproductive mode for this Ia. */
   protected static final String REPRODUCTIVE_MODE = "protoandrous";

   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double MOILI_I_MAX_LENGTH = 8.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double MOILI_I_MIN_LENGTH = 0.0;

   
   /**
   * Constructor.
   */
   public MoiLi_i() {
      this(MOILI_I_MIN_LENGTH);
   }
   
   /**
    * Constructor with length parameter.
    * @param length is the fish's length
    */
   public MoiLi_i(double length) {
      this(
              "Moi-li'i",
              MOILI_I_MAX_LENGTH,
              MOILI_I_MIN_LENGTH,
              length,
              (length * 2),
              new Food[] {
                  Food.CRUSTACEANS
              },
              "silver", 
              "silver with black tips", 
              "none",
              11,
              new Month[] {
                  Month.JANUARY,
                  Month.FEBRUARY,
                  Month.MARCH,
                  Month.APRIL,
                  Month.MAY,
                  Month.SEPTEMBER,
                  Month.OCTOBER,
                  Month.NOVEMBER,
                  Month.DECEMBER
              },
              true,
              new CatchMethod[] {
              },
              15
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
   public MoiLi_i(
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
              "Six-fingered threadfin", 
              "Polydactylus sexfilis",
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

   
 
   /** returns new Moi Mana version of this fish.
   * When a moi-li'i reaches maxLength, it should levelUp to a MoiMana of  min length
   * min size of next size is always max length of this one
   * @return a new MoiMana
   */
   public MoiMana levelUp() {
      return new MoiMana(this.maxLength);
   }

   //============== required by SexChangable interface ===============================
   
   /** 
   * changes this Moi-li'i s sex
   * Moi-li'i cannot change sex within their size group. Can only change at levelUp
   */
   public void changeSex() {
      throw new UnsupportedOperationException("Moi-li'i cannot change sex.");
   }
   
   /**
   * Gets the reproductive mode of this sex changing fish.
   * @return returns the reproductive mode of this sex changing fish.
   */
   public String getReproductiveMode() {
      return REPRODUCTIVE_MODE;
   }
  
}