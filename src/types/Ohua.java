package types;

import interfaces.ColorChangeable;
import interfaces.SexChangeable;
import variables.CatchMethod;
import variables.Food;
import variables.Month;

/**
* 'Ohua fish object class.
* Smallest type version of Uhu fish
* Parent class to Panuhunuhu
* @author Silver Liang
* @since 02/10/24
*/
public class Ohua extends FishableI_a implements SexChangeable,
        ColorChangeable {

   // Constants for this fish.
   // protected will be inherited by subclasses unless replaced
   /** constant reproductive mode for this Ia. */
   protected static final String REPRODUCTIVE_MODE = "Protogynous";
   
   /** constant maximum length for this Ia.
   * Private because not inherited.
   */
   private static final double OHUA_MAX_LENGTH = 4.0;
   /** constant minimum length for this Ia.
   * Private because not inherited.
   */
   private static final double OHUA_MIN_LENGTH = 0.0;
   
   /** 
   * Constructor.
   */
   public Ohua() {
      this(OHUA_MIN_LENGTH);
      this.initLength();
   }
   
   /**
    * Constructor with length parameter.
    * @param length is the fish's length
    */
   public Ohua(double length) {
      this(
              "‘Ohua",
              OHUA_MAX_LENGTH,
              OHUA_MIN_LENGTH,
              length,
              0.1,
              new Food[] {
                  Food.ALGAE
              }, // Inherit diet from Kahaha
              "gray", 
              "reddish gray", 
              "none",
              12,
              new Month[] {
                  Month.APRIL,
                  Month.MAY,
                  Month.JUNE,
                  Month.JULY,
                  Month.AUGUST,
                  Month.SEPTEMBER,
                  Month.OCTOBER,
                  Month.NOVEMBER
              },
              true,
              new CatchMethod[] {
                  CatchMethod.NET,
                  CatchMethod.SPEAR,
                  CatchMethod.POLE
              },
              Integer.MAX_VALUE
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
   public Ohua(
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
              "Parrotfish", 
              "Scaridae",
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
   
      
   /** returns new Panuhunuhu version of this fish.
   * When 'Ohua reaches maxLength, it levelUps to Panuhunuhu of minLength
   * min size of next size is always max length of this one
   * @return a new Panuhunuhu
   */
   public Panuhunuhu levelUp() {
   
      return new Panuhunuhu(this.maxLength);
   }

   //================ reuired by SexChangeable interface =================

   /**
   * changes this Ohua's sex.
   * Ohua cannot change sex. Can only change at levelUp
   * @throws UnsupportedOperationException always
   */
   public void changeSex() {
      //For some reason junit wants this exception to be thrown instead
      throw new UnsupportedOperationException("Ohua cannot change sex unless"
         + "leveling up.");
   }
   
   //================ reuired by ColorChangeable interface =================

   /**
   * changes this Ohua's color.
   * Ohua cannot change color. Can only change at levelUp
   * @param finColor is the fish's fin color
   * @param bodyColor is the fish's body color
   * @throws UnsupportedOperationException always
   */
   public void setColor(String bodyColor, String finColor)
      throws UnsupportedOperationException {
      
      this.bodyColor = bodyColor;
      this.finColor = finColor;
      //For some reason junit wants this exception to be thrown instead
      throw new UnsupportedOperationException("Ohua cannot change color unless"
         + " leveling up.");
   }
   
   /**
   * returns the reproductive mode of this sex changing fish.
   * @return The fish's reproductive mode.
   */
   public String getReproductiveMode() {
      return REPRODUCTIVE_MODE;
   }

}

