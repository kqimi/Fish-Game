package types;

import variables.CatchMethod;
import variables.Food;
import variables.Month;

/**
* FishTypes.Weke_ula object class.
* One of the second phases of Weke life
* Either Male or Female
* The size is 7 - 30 inches
* @author Michaela Gillan
* @since 2/18/24
*/
public class Weke_ula extends Oama {
   
   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double WEKE_ULA_MAX_LENGTH = 30.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double WEKE_ULA_MIN_LENGTH = 7.0;
   

   /**
   * Constructor.
   */
   public Weke_ula() {
      this(WEKE_ULA_MIN_LENGTH);
      initSex();
      initLength();
   } //closes constructor

   /** 
   * Constructor.
   * @param length the fish's length
   */
   public Weke_ula(double length) {
     this(length, "female");
      initSex();
   }
     
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   */
   public Weke_ula(double length, String sex) {
      super(
              "Weke'ula",
              WEKE_ULA_MAX_LENGTH,
              WEKE_ULA_MIN_LENGTH,
              length,
              (length * 2),
              new Food[] {
                  Food.WORMS,
                  Food.MOLLUSK,
                  Food.INVERTEBRATES
              },
              "white with yellow stripe and black spot", 
              "white", 
              sex,
              7,
              new Month[] {
              },
              true,
              new CatchMethod[]{
                  CatchMethod.NET,
                  CatchMethod.POLE,
                  CatchMethod.TRAP
              },
              50
      );
   
   } //closes constructor
   
   /**
   * Returns itself because Weke_ula is the max level.
   * @return an Weke'ula
   */
   public Weke_ula levelUp() {
      return this;
   } //closes levelUp
} //closes Weke_ula
