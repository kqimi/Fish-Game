package types;

import variables.CatchMethod;
import variables.Food;
import variables.Month;

/**
* FishTypes.Weke_a object class.
* One of the second phases of Weke life
* Either Male or Female
* The size is 7 - 30 inches
* @author Michaela Gillan
* @since 2/18/24
*/
public class Weke_a extends Oama {
   
   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double WEKE_A_MAX_LENGTH = 30.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double WEKE_A_MIN_LENGTH = 7.0;


   /**
   * Constructor.
   */
   public Weke_a() {
      this(WEKE_A_MIN_LENGTH);
      this.initLength(); 
      this.initSex(); 
   }
   
   /**
   * Constructor.
   * @param length is the fish's length
   */
   public Weke_a(double length) {
      this(length, "female");
      initSex();
   } //closes constructor

   /**
    * Constructor.
    * @param length is the fish's length
    * @param sex is the fish's sex
    */
   public Weke_a(double length, String sex) {
      super(
              "Weke'a",
              WEKE_A_MAX_LENGTH,
              WEKE_A_MIN_LENGTH,
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
              new Month[] {},
              true,
              new CatchMethod[] {
                  CatchMethod.NET,
                  CatchMethod.POLE,
                  CatchMethod.TRAP
              },
              50
      );
   } //closes constructor

   /**
   * Returns itself because Weke_a is the max level.
   * @return an Weke'a
   */
   public Weke_a levelUp() {
   
      return this; 
   
   } //closes levelUp
} //closes Weke_a
