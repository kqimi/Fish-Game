package types;

import exceptions.FishSizeException;
import variables.CatchMethod;
import variables.Food;
import variables.Month;

/**
* FishTypes.Kahaha fish object class.
* @author Rtts
* @since 03/10/2024
*/
public class Kahaha extends Pua_ama {

   /** Max length constant. */
   private static final double KAHAHA_MAX_LENGTH = 8.0;
   
   /** Min length constant. */
   private static final double KAHAHA_MIN_LENGTH = 4.0;
   
   /**
   * Constructor.
   */
   public Kahaha() {
      this(KAHAHA_MIN_LENGTH);
      this.initLength();
   } //closes constructor

   /**
   * Constructor.
   * @param length is the fish's length
   * @throws FishSizeException if the new length is outside the allowed range
   */
   public Kahaha(double length) {
      this(
              "Kahaha",
              KAHAHA_MAX_LENGTH,
              KAHAHA_MIN_LENGTH,
              length,
              (length * 2),
              new Food[] {
                  Food.ZOOPLANKTON,
                  Food.DETRITUS,
                  Food.ALGAE,
                  Food.INVERTEBRATES
              },
              "silver",
              "silver",
              "female",
              0,
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
                  CatchMethod.NET
              },
              Integer.MAX_VALUE
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
   public Kahaha(
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
   * Levels up the FishTypes.Kahaha to a 'Ama'ama.
   * @return an 'Ama'ama
   */
   public Ama_ama levelUp() {
   
      return new Ama_ama(this.maxLength, this.sex);
   
   } //closes levelUp

} //closes FishTypes.Kahaha