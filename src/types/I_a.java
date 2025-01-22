package types;

import exceptions.FishFoodException;
import exceptions.FishSizeException;
import variables.Food;

import java.util.Arrays;
import java.util.Random;
/**
* Abstract parent class for FishTypes.I_a (fish) species.
* @author Lisa Miller
* @since 2/11/22
*/
public abstract class I_a implements Comparable<I_a> {

   /*** instance constants, these are fixed for each type. ***/
   /** The Hawaiian name. */
   protected final String name;
   /** The English name. */
   protected final String englishName;
   /** The scientific name. */
   protected final String scientificName;
   /** The maximum length. */
   protected final double maxLength;
    /** The minimum length. */
   protected final double minLength;
      /** The diet eaten. */
   protected final Food[] diet;
   
   /*** instance variables, these are (possibly) variable for each fish. ***/
    /** The actual fish length in inches. */
   protected double length;
   /** The fish weight in ounces. */
   protected double weight;
   /** The body color. */
   protected String bodyColor;
   /** The fin color. */
   protected String finColor;
   /** The fishes' sex. */
   protected String sex;
   /** The growth rate max per food eaten.*/
   protected double growthRate = 0.8;
   
   /**
   * constructor. 
   * initial length should be generated in subclass.
   *@param name This fish type's Hawaiian name.
   *@param englishName The fish type's English name.
   *@param scientificName The fish species's scientific name.
   *@param maxLength The maximum length this name applies.
   *@param minLength The minimum length this name applies.
   *@param length This fish's size.
   *@param weight This fish's weight.
   *@param diet The diet preference of this fish type.
   *@param bodyColor The body color of this fish.
   *@param finColor The fin color of this fish.
   *@param sex The sex of this fish.
   *@throws FishSizeException if length > maxLength or < minLength
   **/
   public I_a(String name, String englishName, String scientificName,
         double maxLength, double minLength, double length, double weight,
         Food[] diet, String bodyColor, String finColor, String sex)
         throws FishSizeException {
        
      //set instance variables
      this.name = name;
      this.englishName = englishName;
      this.scientificName = scientificName;
      this.maxLength = maxLength;
      this.minLength = minLength;
      if (length >= minLength && length <= maxLength) {
         this.length = length;
      } else {
         throw new FishSizeException(name + " length must be within "
            + minLength + " and " + maxLength + " inches long. But was sent "
            + length);
      }
      this.weight = weight;
      this.diet = diet;
      this.bodyColor = bodyColor;
      this.finColor = finColor;
      this.sex = sex;           
   }
   
   /** 
   * Initializing the length and weight.
   *
   * @throws FishSizeException for length errors
   */ 
   protected void initLength() throws FishSizeException {
      Random ran = new Random();
      this.length = this.minLength
              + (this.maxLength - this.minLength) * ran.nextDouble();
      this.weight = this.length * 2;
   } //closes initLength
   
   /*** abstract methods to be implemented in the sub-classes ****/
   /**
   * Sets the fish's length to newLength.
   * @param newLength the new fish length.
   * @throws FishSizeException if the new length is not within min-max range
   */
   public void setLength(double newLength) throws FishSizeException {

      //*****from FishTypes.MoiLi_i.java setLength method*****\\
      if (newLength >= this.minLength && newLength < this.maxLength) {
         this.length = newLength;
      } else {
         throw new FishSizeException(this.name + " must be within "
                 + this.minLength + " and " + this.maxLength
                 + " inches long.");
      }
   }
   
   /**
   * Sets the fish's weight to newWeight.
   * @param newWeight the fish's new weight.
   */
   public void setWeight(double newWeight) {
      this.weight = newWeight;
   }

   /**
    * Has the fish eat to increase size.
    * @param food is the food fed to the fish
    * @throws FishFoodException if the food is not in the fish's diet
    */
   public void eat(Food food) {
      if (!Arrays.stream(getDiet()).toList().contains(food)) {
         throw new FishFoodException(this.name + " does not eat " + food.name);
      }
      this.grow(food.multiplier);
   } //closes eat

   /**
   * Should be used by eat method to increase length of fish. 
   * Should determine a new length and internally call setLength
   * @throws FishSizeException if the new length is not within min-max range
   */
   public void grow() {
      grow(1.0);
   } //closes grow
   
   /**
   * Should be used by eat method to increase length of fish. 
   * Should determine a new length and internally call setLength
   * @param mult is the foods growth multiplier
   * @throws FishSizeException if the new length is not within min-max range
   */
   public void grow(double mult) {
      Random ran = new Random();

      double lengthIncrease = (ran.nextDouble() * growthRate) * mult;

      //calculate a new length by adding a random value between 0 and growthRate
      double newLen = this.length + lengthIncrease;

      //check to see if this fish needs to level up
      if (newLen > this.maxLength) {
         throw new FishSizeException("This fish has outgrown its name,"
                 + " it must level up!");
      } else {
         this.length = newLen;
         this.weight = 2 * newLen; //rudimentary weight calc
      }
   } //closes grow
   
   /** returns new FishTypes.I_a of next level
   * When a fish reaches maxSize, it should transform to next
   * level Hawaiian type.
   * @return a new FishTypes.I_a of the next level type, should replace caller
   */
   public abstract I_a levelUp();
   
   //########### Protected class method ################
   
      /** initialize random fish sex
   * choose randomly male or female
   * used by some subclasses.
   */
   protected void initSex() {
      //randomize sex
      Random ran = new Random();
      int flip = ran.nextInt(2);
      
      if (flip == 0) {
         this.sex = "male";
      } else {
         this.sex = "female";
      }
   }

  
   /*** public class methods - methods used by all sub-classes ***/
   
   /**
   * Returns FishTypes.I_a information as a formatted String.
   * @return String representing FishTypes.I_a object data.
   */
   public String toString() {
   
      String s = "Name: " + this.name + "\n";
      s = s + "English name: " +  this.englishName + "\n";
      s = s + "Scientific name: " + this.scientificName + "\n";
      s = s + "Length: " + this.length + "\n";
      s = s + "Weight: " + this.weight + "\n";
      s = s + "Body color: " + this.bodyColor + "\n";
      s = s + "Fin color: " + this.finColor + "\n";
      s = s + "Sex: " + this.sex;
      
      return s;
   }
   /** Get Methods **/
   
   /** 
   * Gets the Hawaiian name.
   * @return The Hawaiian name of this fish.
   */
   public String getName() {
      return this.name;
   }
   
   /**
   * Gets the English name.
   * @return The English name of this fish.
   */
   public String getEnglishName() {
      return this.englishName;
   }
   /**
   * Gets the Scientific name.
   * @return The scientific name of this fish.
   */
   public String getScientificName() {
      return this.scientificName;
   }

   /** 
   * Gets the maximum length for this fish type.
   * @return The maximum length.
   */   
   public double getMaxLength() {
      return this.maxLength;
   }
      /** 
   * Gets the minimum length for this fish type.
   * @return The minimum length.
   */   
   public double getMinLength() {
      return this.minLength;
   }
   /**
   * Gets the length.
   * @return This fish's length.
   */ 
   public double getLength() {
      return this.length;
   }

   /**
   * Gets the fish type diet.
   * @return This fish type's diet.
   */   
   public Food[] getDiet() {
      return this.diet;
   }
   
   /**
   * Gets the body color.
   * @return The fish's general body color.
   */
   public String getBodyColor() {
      return this.bodyColor;
   }
   
   /**
   * Gets the fin color.
   * @return bodyColor The fish's general fin color.
   */
   public String getFinColor() {
      return this.finColor;
   }
   /** 
   * Gets this fish's sex.
   *@return The fish's sex
   */   
   public String getSex() {
      return this.sex;
   }
   
   
   
   /**************** Required for Comparable ******************/
   /**
   * compareTo method imposes sorting order on FishTypes.I_a.
   * @param i The FishTypes.I_a being compared to this
   * @return 0 if equal, < 0 if this comes before i, > 0 if this comes after i
   */
   public int compareTo(I_a i) {
      int diff = (int) ((this.length - i.getLength()) * 100);
      
      if (diff == 0) { 
         String s1 = this.name.toLowerCase();
         String s2 = i.getName().toLowerCase();
         diff = s1.compareTo(s2);
      }
      return diff;
   }
   /**
   * compares two FishTypes.I_a for equality.
   * @param i The FishTypes.I_a being compared to this
   * @return true if the two FishTypes.I_a are equal, false if not
   */
   public boolean equals(I_a i) {
      if (this.compareTo(i) == 0) {
         return true;
      }    
      return false;
   }
   
   /** 
   * get the weight of the fish.
   * @return weight the weight of the fish
   */
   public double getWeight() {
      return weight;
   }
} //close class
