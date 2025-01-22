package types;

import variables.CatchMethod;
import variables.Food;
import variables.Month;

import java.util.Random;
/**
* Pua awa fish object class.
* Smallest version of FishTypes.Awa fish
* Sources for info on this fish family
* (https://scholarspace.manoa.hawaii.edu/server/api/core/bitstreams/fbc009bd
  -1a36-4282-8cc4-9285d4d49d55/content)
* (https://en.wikipedia.org/wiki/Milkfish)
* (https://www.fao.org/fishery/docs/CDrom/aquaculture/I1129m/file
  /en/en_milkfish.htm)
* @author Rtts
* @since 02/24/2024
*/
public class PuaAwa extends FishableI_a {

   /** Max length constant. */
   private static final double PUA_AWA_MAX_LENGTH = 12.0;
   
   /** Min length constant. */
   private static final double PUA_AWA_MIN_LENGTH = 0.01;

   /**
   * Constructor.
   */
   public PuaAwa() {
      this(PUA_AWA_MIN_LENGTH);
      this.initLength();
      this.initFinColor();
      this.initSex();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   */
   public PuaAwa(double length) {
      this(
              "Pua awa",
              PUA_AWA_MAX_LENGTH,
              PUA_AWA_MIN_LENGTH,
              length,
              (length * 2),
              new Food[] {
                  Food.ALGAE,
                  Food.DETRITUS,
                  Food.INVERTEBRATES,
                  Food.ZOOPLANKTON
              },
              "silver",
              "olive green",
              "male",
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
                  Integer.MAX_VALUE
      );
      this.initFinColor();
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
   * @param legalSize the legal size of the fish
   * @param seasonMonths the fish's season/months
   * @param isBait if it is a bait or not
   * @param catchMethods the catch methods for the fish
   * @param bagLimit the limit of fish in the bag.
   */
   public PuaAwa(
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
              "Milkfish",
              "Chanos chanos",
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
   * Sets the fish's initial Fin color.
   */
   protected void initFinColor() {
   
      Random ran = new Random();
      
      //assigns a random fin color
      if (ran.nextInt(2) == 0) {
         this.finColor = "olive green";
      } else {
         this.finColor = "blue";
      } //closes if-else statement
   
   } //closes initFinColor

   /**
   * Levels up the Pua awa to an FishTypes.Awa 'aua.
   * @return an FishTypes.Awa_aua
   */
   public Awa_aua levelUp() {
   
      return new Awa_aua(this.maxLength, this.sex, this.finColor);
   
   } //closes levelUp
} //closes FishTypes.PuaAwa