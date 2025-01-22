package types;

import variables.CatchMethod;
import variables.Food;
import variables.Month;

/**
* Pala Moi object class.
* This is the third phase of Moi life
* It is strictly a hermaphrodite (intersexed)
* The size is 12 - 16 inches
* @author Lisa Miller
* @version 1.0
* @since 2/14/22
*/
public class PalaMoi extends MoiMana {
   
   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double PALA_MOI_MAX_LENGTH = 16.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double PALA_MOI_MIN_LENGTH = 12.0;

   /**
   * Constructor.
   */
   public PalaMoi() {
      this(PALA_MOI_MIN_LENGTH);
      this.initSex();
      this.initLength();  
   }
   
   /**
   * Constructor. 
   * @param length is the fish's length
   */
   public PalaMoi(double length) {
      this(length, "hermaphrodite");
      this.initSex();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   */
   public PalaMoi(double length, String sex) {
      this(
              "Pala Moi",
              PALA_MOI_MAX_LENGTH,
              PALA_MOI_MIN_LENGTH,
              length,
              (length * 2),
              new Food[] {
                  Food.CRUSTACEANS
              },
              "silver", 
              "silver with black tips", 
              sex,
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
                  CatchMethod.POLE,
                  CatchMethod.NET
              },
              15
      );
   
   } //closes constructor
   
   /**
   * Constructor.
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
   public PalaMoi(
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
           int bagLimit) {
   
      super(
              name,
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
   } //closes constructor

     
   /** returns new Moi version of this fish.
   * When a Pala Moi reaches maxLength, it should levelUp to a Moi of  min size
   * min size of next size is always max size of this one
   * @return a new Moi
   */
   public Moi levelUp() {
   
      return new Moi(this.maxLength, this.sex);
   
   }

}
   
