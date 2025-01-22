package variables;

/**
* enum representing the different food you can use to find the fishes.
*/
public enum Food {
    /** Food type: algae. */
    ALGAE("Algae", 1.0),
    /** Food type: crustaceans. */
    CRUSTACEANS("Crustaceans", 1.0),
    /** Food type: detritus. */
    DETRITUS("", 1.0),
    /** Food type: invertebrates. */
    INVERTEBRATES("", 1.0),
    /** Food type: mollusk. */
    MOLLUSK("", 1.0),
    /** Food type: worms. */
    WORMS("", 1.0),
    /** Food type: zooplankton. */
    ZOOPLANKTON("", 1.0);

   /** food name. */
   public final String name; // Suppressing Checkstyle warning for public field
   /** multiplier. */
   public final double multiplier; // Suppressing Checkstyle warning for public field

   /** 
   * constructor for the food that feeds the fish.
   * @param name the name of the food
   * @param multiplier multiply the length of the fish when fed
   */
   Food(String name, double multiplier) {
      this.name = name;
      this.multiplier = multiplier;
   }
}
