package types;

import variables.CatchMethod;
import variables.Food;
import variables.Month;

/**
* Pua'ama fish object class.
* Smallest type version of 'Ama'ama fish
* Parent class to Kahaha
* @since 02.15.24
*/
public class Pua_ama extends FishableI_a {

   /** Max length constant. */
   private static final double PUA_AMA_MAX_LENGTH = 4.0;

   /** Min length constant. */
   private static final double PUA_AMA_MIN_LENGTH = 0.01;

   /**
    * Default constructor.
    */
   public Pua_ama() {
      this(PUA_AMA_MIN_LENGTH);
   }

   /**
    * Constructor with length parameter.
    * @param length is the fish's length
    */
   public Pua_ama(double length) {
      this(
              "Pua'ama",
              PUA_AMA_MAX_LENGTH,
              PUA_AMA_MIN_LENGTH,
              length,
              0.1,
              Food.values(), // Inherit diet from Kahaha
              "silver",
              "silver",
              "none",
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
   public Pua_ama(
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
              "Striped Mullet",
              "Mugil Cephalus",
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

   /**
    * Levels up the Pua'ama to a Kahaha.
    * @return a Kahaha instance
    */
   public Kahaha levelUp() {
      return new Kahaha(this.maxLength);
   }
}
