package types;

import exceptions.FishSizeException;
import variables.CatchMethod;
import variables.Food;
import variables.Month;

import java.util.Random;
/**
* Panuhunuhu object class.
* This is the second phase of Uhu life
* Can be either male or female
* The size is 4 - 12 inches
* @author Silver Liang
* @since 2/10/24
*/
public class Panuhunuhu extends Ohua {
   
   // Constant instance variables, only add if changed from superclass
   
   /** Constant maximum length for this Ia.
   * Private because not inherited.
   */
   private static final double PANUHUNUHUMAXLENGTH = 12.0;
   /** constant minimum length for this Ia.
   * Private because not inherited.
   */
   private static final double PANUHUNUHUMINLENGTH = 4.0;
   
   /**
   * Constructor for making Panuhunuhu with random length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the second phase of the species and can be either male or female.
   * @throws FishSizeException if length is > maxLength or < minLength
   * Must send minLength through as a temp length or throws exception
   */
   public Panuhunuhu() {
      this(PANUHUNUHUMINLENGTH);
      this.initLength();
      this.initSex();
   }
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @throws FishSizeException if the new length is outside the allowed range
   */
   public Panuhunuhu(double length) {
      this(
              "Panuhunuhu",
              PANUHUNUHUMAXLENGTH,
              PANUHUNUHUMINLENGTH,
              length,
              (length * 2),
              new Food[] {
                  Food.ALGAE
              },
              "gray", 
              "reddish gray", 
              "female",
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
   public Panuhunuhu(
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
    * Returns a new Uhu version of this fish.
    * When Panuhunuhu reaches maxLength, it should levelUp to Uhu min size.
    * The min size of the next size is always the max size of this one.
    *
    * @return a new Uhu
    */
   public Uhu levelUp() {
      Random rand = new Random();
      Uhu uhu = new Uhu(this.maxLength, this.sex);
      if (this.sex.equals("male")) {
         return uhu;
      }
      int randomSupermale = rand.nextInt(2);
      if (randomSupermale == 0) {
         uhu.changeSex();
         uhu.setColor("blue-green", "blue");
      }
      return uhu;
   }
   
   /**
   * changes this Panuhunuhu's color.
   * Panuhunuhu cannot change color. Can only change at levelUp
   * @param bodyColor is the fish's body color
   * @param finColor is the fish's fin color
   * @throws UnsupportedOperationException always
   */
   public void setColor(String bodyColor, String finColor) 
      throws UnsupportedOperationException {
      
      if (bodyColor == "blue-green" && finColor == "blue"
            && (this.sex.equals("supermale") || this.sex.equals("female"))) {
         
         this.bodyColor = bodyColor;
         this.finColor = finColor;
      } else {
         //For some reason junit wants this exception to be thrown instead
         throw new UnsupportedOperationException("Panuhunuhu cannot change"
            + "color unless leveling up.");
      } //closes if-else statement
   }

}