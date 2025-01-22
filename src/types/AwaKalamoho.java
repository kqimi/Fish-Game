package types;

import exceptions.FishSizeException;
import variables.CatchMethod;
import variables.Food;
import variables.Month;


/**
* Awa kalamoho fish object class.
* Very large version of Awa fish
* @author Rtts
* @since 02/24/2024
*/
public class AwaKalamoho extends Awa {

   /** Max length constant. */
   private static final double AWA_KALAMOHO_MAX_LENGTH = 71.0;
   
   /** Min length constant. */
   private static final double AWA_KALAMOHO_MIN_LENGTH = 48.0;

   /**
   * Constructor.
   */
   public AwaKalamoho() {
      this(AWA_KALAMOHO_MIN_LENGTH);
      initLength();
      initSex();
      initFinColor();
   } //closes constructor

   /**
   * Constructor.
   * @param length is the fish's length
   * @throws FishSizeException if the new length is outside the allowed range
   */
   public AwaKalamoho(double length) throws FishSizeException {
      this(length, "male");
      initSex();
      initFinColor();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   */
   public AwaKalamoho(double length, String sex) {
      this(length, sex, "olive green");
      initFinColor();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   * @param finColor is the fish's fin color
   */
   public AwaKalamoho(double length, String sex, String finColor) {
      super(
              "Awa kalamoho",
              AWA_KALAMOHO_MAX_LENGTH,
              AWA_KALAMOHO_MIN_LENGTH,
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
   * Returns itself because Awa kalamoho is the max level.
   * @return an Awa kalamoho
   */
   public AwaKalamoho levelUp() {
   
      return this; 
   
   } //closes levelUp

} //closes AwaKalamoho