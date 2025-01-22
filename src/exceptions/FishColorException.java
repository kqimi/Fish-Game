package exceptions;

/**
* Exception for FishTypes.I_a class color errors.
* @author Lisa Miller
* @since 2/2/24
*/
public class FishColorException extends RuntimeException {
  
  /**
  * Constructor. 
  * @param newMessage The error message to be sent.
  */
   public FishColorException(String newMessage) {
      super(newMessage);
   }
}
