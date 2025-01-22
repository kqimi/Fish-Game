package types;

import exceptions.FishColorException;
import exceptions.FishSexException;
import variables.CatchMethod;
import variables.Food;
import variables.Month;

/**
* FishTypes.Uhu object class.
* This is the third and final phase of FishTypes.Uhu life
* It can be a male, female or supermale
* The size is 12 inches and up
* @author Silver Liang
* @since 2/10/24
*/
public class Uhu extends Panuhunuhu {

   // Constant instance variables, only add if changed from superclass
   
   /** constant maximum length for this Ia.
   * This is the state record
   * Private because not inherited.
   */
   private static final double UHU_MAX_LENGTH = 30.0;
   /** constant maximum length for this Ia.
   * This is the state record
   * Private because not inherited.
   */
   private static final double UHU_MIN_LENGTH = 12.0;
   
   /**
   * Constructor. 
   */
   public Uhu() {
      this(UHU_MIN_LENGTH);
      this.initLength();
      this.initSex();
   }
   
   /**
   * Constructor.
   * @param length is the fish's length
   */
   public Uhu(double length) {
      this(length, "female");
      initSex();
   } //closes constructor
      
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   */
   public Uhu(double length, String sex) {
      super(
              "Uhu",
              UHU_MAX_LENGTH,
              UHU_MIN_LENGTH,
              length,
              (length * 2),
              new Food[] {
                  Food.ALGAE,
              },
              "gray", 
              "reddish gray",
              sex,
              12,
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
                  CatchMethod.NET,
                  CatchMethod.SPEAR,
                  CatchMethod.POLE
              },
              Integer.MAX_VALUE
      );
      
   
   } //closes constructor   

   //================ reuired by SexChangeable interface =================

   /**
   * changes this FishTypes.Uhu's sex.
   * changes sex from female to supermale
   * @throws FishSexException if fish sex is male
   */
   public void changeSex() throws FishSexException {
      if (this.sex.equals("female")) {
         this.sex = "supermale";
      } else {   
         throw new FishSexException("Cannot change sex.");
      } //closes if-else statement
   }
   
   /**
   * sets this FishTypes.Uhu's color.
   * @param bodyColor new body color if FishTypes.Uhu becomes a supermale
   * @param finColor new fin color if FishTypes.Uhu becomes a supermale
   * @throws FishColorException if incorrect colors
   */
   public void setColor(String bodyColor, String finColor) 
      throws FishColorException {
      
      if (bodyColor == "blue-green" && finColor == "blue"
            && (this.sex.equals("supermale") || this.sex.equals("female"))) {
         
         this.bodyColor = bodyColor;
         this.finColor = finColor;
      } else {
         throw new FishColorException("Incorrect color"); 
      } //closes if-else statement 
   
   }
   
   /** returns the same fish
   * FishTypes.Uhu don't level up, this is the terminal type.
   * method is required but shouldn't do anything.
   * @return the same fish
   */
   public Uhu levelUp() {
   
      return this;
   
   }
   
}
