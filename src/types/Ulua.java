package types;

import exceptions.FishSizeException;
import variables.CatchMethod;
import variables.Food;
import variables.Month;


/**
* Ulua fish object class.
* Adult version of Omilua fish
* @author Rtts
* @since 02/27/2024
*/
public class Ulua extends Pa_u_u {

   /** Max length constant. */
   private static final double ULUA_MAX_LENGTH = 40.0;
   
   /** Min length constant. */
   private static final double ULUA_MIN_LENGTH = 25.0;
   
   
   /**
   * Constructor.
   */
   public Ulua() {
      this(ULUA_MIN_LENGTH);
      this.initSex();
      this.initLength();
   
   } //closes constructor

   /**
   * Constructor.
   * @param length is the fish's length
   * @throws FishSizeException if the new length is outside the allowed range
   */
   public Ulua(double length) throws FishSizeException {
      this(length, "female");
      initSex();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   */
   public Ulua(double length, String sex) {
      this(
              "Ulua",
              ULUA_MAX_LENGTH,
              ULUA_MIN_LENGTH,
              length,
              (length * 2),
              new Food[] {
                  Food.CRUSTACEANS
              },
              "silverish",
              "electric blue",
              sex,
              10.0,
              new Month[] {},
              false,
              new CatchMethod[] {
                  CatchMethod.NET,
                  CatchMethod.POLE,
                  CatchMethod.SPEAR,
                  CatchMethod.TRAP
              },
              20);
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
   * @param legalSize the legal size of the fish
   * @param seasonMonths the fish's season/months
   * @param isBait if it is a bait or not
   * @param catchMethods the catch methods for the fish
   * @param bagLimit the limit of fish in the bag.
   */
   public Ulua(
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
   * Can't level up so returns itself.
   * @return itself
   */
   public Ulua levelUp() {
      return this; 
   
   } //closes levelUp
   
} //closes Ulua