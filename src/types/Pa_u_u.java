package types;

import exceptions.FishSizeException;
import variables.CatchMethod;
import variables.Food;
import variables.Month;


/**
* Pa'u'u fish object class.
* medium version of Omilu fish
* @author Rtts
* @since 02/27/2024
*/
public class Pa_u_u extends Papio {

   /** Max length constant. */
   private static final double PA_U_U_MAX_LENGTH = 25.0;
   
   /** Min length constant. */
   private static final double PA_U_U_MIN_LENGTH = 10.0;
   
   /**
   * Constructor.
   */
   public Pa_u_u() {
      this(PA_U_U_MIN_LENGTH);
      this.initSex();
      this.initLength();
            
   } //closes constructor

   /**
   * Constructor.
   * @param length is the fish's length
   * @throws FishSizeException if the new length is outside the allowed range
   */
   public Pa_u_u(double length) throws FishSizeException {
      this(length, "female");
      initLength();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   */
   public Pa_u_u(double length, String sex) {
      this(
              "Pa'u'u",
              PA_U_U_MAX_LENGTH,
              PA_U_U_MIN_LENGTH,
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
              20
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
   * @param seasonMonths the fish's season/months
   * @param isBait if that is the fish bait
   * @param catchMethods the catch methods of this fish
   * @param bagLimit the limit of fish in the bag.
   */
   public Pa_u_u(
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
   * Levels up the Pa'u'u to a FishTypes.Ulua.
   * @return an FishTypes.Ulua
   */
   public Ulua levelUp() {
   
      return new Ulua(this.maxLength, this.sex);
   
   } //closes levelUp
   
} //closes types.Pa_u_u