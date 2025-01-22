package types;
import variables.CatchMethod;
import variables.Food;
import interfaces.Fishable;
import variables.Month;

import java.util.Arrays;

/**
* Abstract parent class for FishInterfaces.Fishable FishTypes.I_a (fish) species.
* Subclass of FishTypes.I_a
* @author Lisa Miller
* @since 4/23/22
*/
public abstract class FishableI_a extends I_a implements Fishable {
   /** the legal size of the fish. */
   protected final double legalSize;
   /** the months of the fish. */
   protected final Month[] seasonMonths;
   /** boolean for whether it is a bait. */
   protected final boolean isBait;
   /** array for the catch methods of the fish. */
   protected CatchMethod[] catchMethods;
   /** the limit of fish in the bag. */
   protected final int bagLimit;

   /**
    * Constructor for types.FishableI_a. Just passes parameters through.
    * @param name           This fish type's Hawaiian name.
    * @param englishName    The fish type's English name.
    * @param scientificName The fish species's scientific name.
    * @param maxLength      The maximum length this name applies.
    * @param minLength      The minimum length this name applies.
    * @param length         This fish's size.
    * @param weight         This fish's weight.
    * @param diet           The diet preference of this fish type.
    * @param bodyColor      The body color of this fish.
    * @param finColor       The fin color of this fish.
    * @param sex            The sex of this fish.
    * @param legalSize      The fish's legal size.
    * @param seasonMonths   The fish's season/months
    * @param isBait         Boolean for whether it is bait
    * @param catchmethods   The catch methods you can use.
    * @param bagLimit       The limit of fish you can have in the bag.
    */

   public FishableI_a(
           String name,
           String englishName,
           String scientificName,
           double maxLength,
           double minLength,
           double length,
           double weight,
           Food[] diet,
           String bodyColor,
           String finColor,
           String sex,
           double legalSize,
           Month[] seasonMonths,
           boolean isBait,
           CatchMethod[] catchmethods,
           int bagLimit) {
         
      super(name, englishName, scientificName, maxLength, minLength, length, weight,
               diet, bodyColor, finColor, sex);

      this.legalSize = legalSize;
      this.seasonMonths = seasonMonths;
      this.isBait = isBait;
      this.catchMethods = catchmethods;
      this.bagLimit = bagLimit;
   }

   /**
    * determines if the fish is legal to keep due to length.
    * different species have different legal sizes
    * @return true If this fish is legal size to keep.
    */
   public boolean isLegalSize() {
      return getLength() >= legalSize;
   }

   /**
    * determines if this fish can be used as a baitfish.
    * @return true if this fish type is used for bait for other fishing.
    */
   public boolean isBait() {
      return isBait;
   }

   /**
    * determines if this fish can be used to eat.
    * @return true if this fish is edible, and allowed to be eaten.
    */
   public boolean isGamefish() {
      return length >= legalSize;
   }

   /**
    * Determines if this fish is in season or not.
    * @param month the current month of the year.
    * @return true if fish is okay to take in the month.
    */
   public boolean isInSeason(Month month) {
      if (Arrays.stream(seasonMonths).toList().isEmpty()) {
         return true;
      }
      return Arrays.stream(seasonMonths).toList().contains(month);
   }

   /**
    * Returns the catch methods for this fish.
    * @return an array of catch methods.
    */
   public CatchMethod[] getCatchMethods() {
      return catchMethods;
   }

   /**
    * Returns the maximum number of this fish you are allowed at one time.
    * @return int representing the maximum catch or Integer.MAX_VALUE if no limit
    */
   public int getBagLimit() {
      return bagLimit;
   }

   /** to determine if the catchMethod is legal or not.
   * @param catchMethod for the catch method used
   * @return true if it is legal
   */
   public boolean isLegalCatchMethod(CatchMethod catchMethod) {
      for (CatchMethod method : catchMethods) {
         if (method == catchMethod) {
            return true;
         }
      }
      return false;
   }
}