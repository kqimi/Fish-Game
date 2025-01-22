package types;

import variables.CatchMethod;
import variables.Food;
import variables.Month;

/**
* Papio fish object class.
* Smallest version of Omilu fish
* Sources for info on this fish family
* (https://scholarspace.manoa.hawaii.edu/server/api/core/bitstreams/fbc009bd
  -1a36-4282-8cc4-9285d4d49d55/content)
* @author Rtts
* @since 02/24/2024
*/
public class Papio extends FishableI_a {

   /** Max length constant. */
   private static final double PAPIO_MAX_LENGTH = 10.0;
   
   /** Min length constant. */
   private static final double PAPIO_MIN_LENGTH = 0.01;

   /**
   * Constructor.
   */
   public Papio() {
      this(PAPIO_MIN_LENGTH);
      this.initLength();
      this.initSex();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   */
   public Papio(double length) {
      this(
              "Papio",
              PAPIO_MAX_LENGTH,
              PAPIO_MIN_LENGTH,
              length,
              (length * 2),
              new Food[] {
                  Food.CRUSTACEANS
              },
              "silverish",
              "dark blue",
              "female",
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
      initSex();
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
   public Papio(
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
              "Bluefin trevally",
              "Caranx melampygus",
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
   * Levels up the Papio to a Pa_u_u.
   * @return a Pa'u'u
   */
   public Pa_u_u levelUp() {
      return new Pa_u_u(this.maxLength, this.sex);
   } //closes levelUp
} //closes Papio