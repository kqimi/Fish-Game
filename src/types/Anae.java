package types;

import variables.CatchMethod;
import variables.Food;
import variables.Month;


/**
* 'Anae fish object class.
* @author Rtts
* @since 03/10/2024
*/
public class Anae extends Ama_ama {

   /** Max length constant. */
   private static final double ANAE_MAX_LENGTH = 27.0;
   
   /** Min length constant. */
   private static final double ANAE_MIN_LENGTH = 12.0;
   

   /**
   * Constructor.
   */
   public Anae() {
      this(ANAE_MIN_LENGTH);
      initSex();
      initLength();
   } //closes constructor

   /**
   * Constructor.
   * @param length is the fish's length
   */
   public Anae(double length) {
      this(length, "female");
      initSex();
   } //closes constructor
   
   /**
   * Constructor.
   * @param length is the fish's length
   * @param sex is the fish's sex
   */
   public Anae(double length, String sex) {
      super(
              "'Anae",
              ANAE_MAX_LENGTH,
              ANAE_MIN_LENGTH,
              length,
              (length * 2),
              new Food[] {
                  Food.ZOOPLANKTON,
                  Food.DETRITUS,
                  Food.ALGAE,
                  Food.INVERTEBRATES
              },
              "silver",
              "silver",
              sex,
              0,
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
              new CatchMethod[]{
                  CatchMethod.NET
              },
              Integer.MAX_VALUE
      );
      
   
   } //closes constructor
   
   /**
   * Returns itself because Anae is the max level.
   * @return an 'Anae
   */
   public Anae levelUp() {
   
      return this; 
   
   } //closes levelUp
} //closes Anae