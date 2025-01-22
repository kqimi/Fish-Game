package types;

import variables.CatchMethod;
import variables.Food;
import variables.Month;

/**
* Moi object class.
* This is the fourth and final phase of Moi life
* It is strictly female
* The size is 16 inches and up
* @author Lisa Miller
* @version 1.0
* @since 2/14/22
*/
public class Moi extends PalaMoi {
   
   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia.
   * This is the state record 
   * Private because not inherited.
   */
   private static final double MOI_MAX_LENGTH = 30.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double MOI_MIN_LENGTH = 16.0;
   
 
   /**
   * Constructor for Moi.
   */
   public Moi() {
      this(MOI_MIN_LENGTH);
      initSex();
      initLength();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   */
   public Moi(double length) {
      this(length, "female");
      initSex();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   */
   public Moi(double length, String sex) {
      super(
              "Moi",
              MOI_MAX_LENGTH,
              MOI_MIN_LENGTH,
              length,
              (length * 2),
              new Food[] {
                  Food.CRUSTACEANS
              },
             "silver", 
             "silver with black tips", 
              sex,
              11,
              new Month[] {
                  Month.JANUARY,
                  Month.FEBRUARY,
                  Month.MARCH,
                  Month.APRIL,
                  Month.MAY,
                  Month.SEPTEMBER,
                  Month.OCTOBER,
                  Month.NOVEMBER,
                  Month.DECEMBER
              },
              true,
              new CatchMethod[] {
                  CatchMethod.POLE,
                  CatchMethod.NET
              },
              15
      );
      
   
   } //closes constructor

   
   /** returns the same fish
   * Moi don't level up, this is the terminal type.
   * method is required but shouldn't do anything
   * @return the same fish
   */
   public Moi levelUp() {
   
      return this;
   
   }
   

}
   
