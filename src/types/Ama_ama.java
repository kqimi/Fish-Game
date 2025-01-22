package types;

import variables.CatchMethod;
import variables.Food;
import variables.Month;

/**
* 'Ama'ama fish object class.
* @author Rtts
* @since 03/17/2024
*/
public class Ama_ama extends Kahaha {

   /** Max length constant. */
   private static final double AMA_AMA_MAX_LENGTH = 12.0;
   
   /** Min length constant. */
   private static final double AMA_AMA_MIN_LENGTH = 8.0;
   
   /** catchMethods array. */
   private static final CatchMethod[] CATCH_METHODS = {
      CatchMethod.NET
   };

   /**
   * Constructor.
   */
   public Ama_ama() {
      this(0);
      this.initSex();
      this.initLength();
   } //closes constructor

   /**
   * Constructor.
   * @param length is the fish's length
   */
   public Ama_ama(double length) {
      this(length, "female");
      this.initSex();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   */
   public Ama_ama(double length, String sex) {
      this(
              "'Ama'ama",
              AMA_AMA_MAX_LENGTH,
              AMA_AMA_MIN_LENGTH,
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
              sex,
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
              new CatchMethod[]{
                  CatchMethod.NET
              },
              Integer.MAX_VALUE
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
   public Ama_ama(
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
   * Levels up the 'Ama'ama to a 'Anae.
   * @return an 'Anae
   */
   public Ama_ama levelUp() {
   
      return new Anae(this.maxLength, this.sex); 
   
   } //closes levelUp
} //closes FishTypes.Ama_ama
