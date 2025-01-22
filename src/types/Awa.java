package types;

import exceptions.FishSizeException;
import variables.CatchMethod;
import variables.Food;
import variables.Month;


/**
* Awa fish object class.
* Adult version of Awa fish
* @author Rtts
* @since 02/24/2024
*/
public class Awa extends Awa_aua {

   /** Max length constant. */
   private static final double AWA_MAX_LENGTH = 48.0;
   
   /** Min length constant. */
   private static final double AWA_MIN_LENGTH = 30.0;
   
   
   /**
   * Constructor.
   */
   public Awa() {
      this(AWA_MIN_LENGTH);
      this.initSex();
      this.initLength();
      this.initFinColor();
   } //closes constructor

   /**
   * Constructor.
   * @param length is the fish's length
   * @throws FishSizeException if the new length is outside the allowed range
   */
   public Awa(double length) throws FishSizeException {
      this(length, "male");
      initFinColor();
      initSex();
   
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   */
   public Awa(double length, String sex) {
      this(length, sex, "olive green");
      initFinColor();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   * @param finColor is the fish's fin color
   */
   public Awa(double length, String sex, String finColor) {
      super(
              "Awa",
              AWA_MAX_LENGTH,
              AWA_MIN_LENGTH,
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
   * @param seasonMonths the fish's season
   * @param isBait a boolean for if the item is a bait
   * @param catchMethods the different methods to catc the fish
   * @param bagLimit how many fish can you have in the bag

   */
   public Awa(
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
   * Levels up the Awa to a Awa kalamoho.
   * @return an AwaKalamoho
   */
   public Awa levelUp() {
   
      //Males grow to be up to 71 inches and females up to 48 inches
      if (this.sex.equals("male")) {
         return new AwaKalamoho(this.maxLength, this.sex, this.finColor);
      } else {
         return this;
      } //closes if-else statement 
   
   } //closes levelUp
   
} //closes Awa