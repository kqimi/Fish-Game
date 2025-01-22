package types;

import exceptions.FishSizeException;
import variables.CatchMethod;
import variables.Food;
import variables.Month;

/**
* Moi Mana object class.
* This is the second phase of Moi life
* It is strictly male
* The size is 8 - 12 inches
* @author Lisa Miller
* @version 1.0
* @since 2/14/22
*/
public class MoiMana extends MoiLi_i {
   
   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double MOI_MANA_MAX_LENGTH = 12.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double MOI_MANA_MIN_LENGTH = 8.0;
   
 
   /**
   * Constructor.
   */
   public MoiMana() {
      this(MOI_MANA_MIN_LENGTH);
      this.initLength();  
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @throws FishSizeException if the new length is outside the allowed range
   */
   public MoiMana(double length) {
      this(
              "Moi Mana",
              MOI_MANA_MAX_LENGTH,
              MOI_MANA_MIN_LENGTH,
              length,
              (length * 2),
              new Food[] {
                  Food.CRUSTACEANS
              },
              "silver", 
              "silver with black tips", 
              "male",
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
      this.initSex();
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
   public MoiMana(
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
   
   /** returns new Pala Moi version of this fish.
   * When a Moi Mana reaches maxLength, it should levelUp to a MoiMana of  min size
   * min size of next size is always max size of this one
   * @return a new MoiMana
   */
   public PalaMoi levelUp() {
   
      return new PalaMoi(this.maxLength, this.sex);
   
   }
}
   
