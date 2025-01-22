package types;

import exceptions.FishSizeException;
import variables.CatchMethod;
import variables.Food;
import variables.Month;

/**
* Awa 'aua fish object class.
* medium version of Awa fish
* @author Rtts
* @since 02/24/2024
*/
public class Awa_aua extends PuaAwa {

   /** Max length constant. */
   private static final double AWA_AUA_MAX_LENGTH = 30.0;
   
   /** Min length constant. */
   private static final double AWA_AUA_MIN_LENGTH = 12.0;
   
   
   /**
   * Constructor.
   */
   public Awa_aua() {
      this(AWA_AUA_MIN_LENGTH);
      initSex();
      initLength();
      initFinColor();
   } //closes constructor

   /**
   * Constructor.
   * @param length is the fish's length
   * @throws FishSizeException if the new length is outside the allowed range
   */
   public Awa_aua(double length) throws FishSizeException {
      this(length, "male");
      initSex();
      initFinColor();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   */
   public Awa_aua(double length, String sex) {
      this(length, sex, "olive green");
      initFinColor();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   * @param finColor is the fish's fin color
   */
   public Awa_aua(double length, String sex, String finColor) {
      this(
              "Awa 'aua",
              AWA_AUA_MAX_LENGTH,
              AWA_AUA_MIN_LENGTH,
              length,
              (length * 2),
              new Food[] {
                  Food.ALGAE,
                  Food.DETRITUS,
                  Food.INVERTEBRATES,
                  Food.ZOOPLANKTON
              },
              "silver",
              finColor,
              sex,
              9.0,
              new Month[] {
                  Month.JANUARY,
                  Month.FEBRUARY,
                  Month.MARCH,
                  Month.AUGUST,
                  Month.DECEMBER},
              false,
              new CatchMethod[] {
                  CatchMethod.NET},
                  Integer.MAX_VALUE);
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
   * @param seasonMonths the fish's month
   * @param isBait if the item is a bait
   * @param catchMethods array the methods to cath the fish
   * @param bagLimit the fish limit in the bag
   */
   public Awa_aua(
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
   
   /**
   * Levels up the Awa 'aua to an Awa.
   * @return an Awa
   */
   public Awa levelUp() {
   
      return new Awa(this.maxLength, this.sex, this.finColor);
   
   } //closes levelUp
   
} //closes Awa_aua