package interfaces;

/**
* interface for FishTypes.I_a that change color.
* @author Lisa Miller
* @since 2/11/22
*/
public interface ColorChangeable {

   /**
   * Some fish can dynamically change colors, this method should do that.
   * @param bodyColor for the body color
   * @param finColor for the fin color
   */
   void setColor(String bodyColor, String finColor);
}