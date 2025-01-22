import exceptions.FishSizeException;
import types.FishableI_a;
import types.MoiLi_i;
import types.Oama;
import types.Ohua;
import types.Papio;
import types.PuaAwa;
import types.Pua_ama;
import variables.CatchMethod;
import variables.Food;
import variables.Month;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
/**
* Driver for FishInterfaces.Fishable I_a testing.
* @author Lisa Miller
* @since 4/24/22
*/
public class FishingDriver {
   /** Maximum pond capacity for random hooking. */
   static final int POND_CAPACITY = 60;

   /** How many months the game lasts. */
   static final int GAME_LENGTH = 12;
   /** Random generator. */
   static final Random RAND = new Random();
   /** Scanner for user input. */
   static final Scanner SCANNER = new Scanner(System.in);

   /** main method.
    * @param args not used.
    */
   public static void main(String[] args) {
      //ArrayList to simulate a fishpond/lokoi'a
      ArrayList<FishableI_a> lokoi_a;
      int numFeeds = 24;
      boolean debug = true; //for printing

      System.out.println("Player 1 please enter your name:");
      Player player1 = new Player(SCANNER.nextLine().trim());

      System.out.println("Player 2 please enter your name:");
      Player player2 = new Player(SCANNER.nextLine().trim());

      lokoi_a = FishingDriver.fillPond();
      if (!debug) {
         System.out.println(lokoi_a);
      } //closes if statement

      //Let fish in pond grow some
      //eat and grow for 24 months
      FishingDriver.growFish(lokoi_a, numFeeds);
      numFeeds = 1;

      //now lets open the pond for fishing!
      for (int m = 1; m <= GAME_LENGTH; m++) {
         Month month = getMonth(m);
         System.out.println("It is now " + month + ".\n");

         System.out.println(player1.getName() + ", it's your turn!\n");
         FishingDriver.lawai_a(lokoi_a, player1, month);
         addRandFood(player1);

         System.out.println("=".repeat(150));

         System.out.println(player2.getName() + ", it's your turn!\n");
         FishingDriver.lawai_a(lokoi_a, player2, month);
         addRandFood(player2);

         System.out.println("=".repeat(150));

         FishingDriver.growFish(lokoi_a, numFeeds);
      } //closes for loop

      //determines the winner
      System.out.println("=".repeat(150));
      System.out.println("FISHING SEASON OVER, DETERMINING WINNER.\n\n");
      findWinner(player1, player2);

   } //close main

   /**
   * Adds 40 baby I_a to ArrayList.
   * This should match POND_CAPACITY.
   * @return ArrayList with small I_a in it.
   */
   public static ArrayList<FishableI_a> fillPond() {

      ArrayList<FishableI_a> arrayList = new ArrayList<>();
      //make 60 fish in the pond
      //10 of baby of each species

      for (int i = 0; i < 10; i++) {
         arrayList.add(new MoiLi_i());
      } //closes for loop

      for (int i = 0; i < 10; i++) {
         arrayList.add(new Oama());
      } //closes for loop

      for (int i = 0; i < 10; i++) {
         arrayList.add(new Pua_ama());
      } //closes for loop

      for (int i = 0; i < 10; i++) {
         arrayList.add(new Ohua());
      } //closes for loop

      for (int i = 0; i < 10; i++) {
         arrayList.add(new PuaAwa());
      } //closes for loop

      for (int i = 0; i < 10; i++) {
         arrayList.add(new Papio());
      } //closes for loop

      //for testing empty locations
    //   for (int i = 0; i < 50; i++) {
   //          arrayList.remove(i);
   //       }
      return arrayList;

   } //fillPond method


   /**
   * Runs arraylist of I_a through 24 eating/growing cycles.
   * @param arrayList the list of fish.
   * @param numFeeds is the number of times the loop to feed the fish should run
   */
   public static void growFish(ArrayList<FishableI_a> arrayList, int numFeeds) {
      FishableI_a ia;
      boolean debug = false; //turn printing on and off
      for (int m = 0; m < numFeeds; m++) {
      //all fish in the pond
         for (int i = 0; i < arrayList.size(); i++) {
         //loop over array
            if (debug) {
               System.out.println("==========================");
               System.out.println("Feeding  the fish" + i);
               System.out.println("==========================\n");
            } //closes if statement

            ia = arrayList.get(i);
            if (debug) {
               System.out.println(ia);
            } //closes if statement

            try { //must check for need to levelUp
            //use EnglishName because doesn't change with size
               Food[] diet = ia.getDiet();
               int nextFood = RAND.nextInt(diet.length);
               ia.grow(diet[nextFood].multiplier);
               ia.grow();
               if (debug) {
                  System.out.println("****After eat and grow: " + ia.getName()
                        + ": " + ia.getLength() + "\n");
               } //closes if statement

            } catch (FishSizeException fe) {
               //need to level up
               ia = (FishableI_a) ia.levelUp();
               if (debug) {
                  System.out.println(fe.getMessage());
                  System.out.println("**** After levelUp: " + ia + "\n");
               } //closes if statement

            } //closes try-catch statement
            arrayList.set(i, ia);
         } //closes i for loop

      } //closes m for loop

   } //close growFish method

   /**
    * simulate fishing/lawai'a.
    * @param fishPond arrayList of fish to be caught
    * @param player is the current player
    * @param month is the current month
    */
   public static void lawai_a(ArrayList<FishableI_a> fishPond, Player player,
                              Month month) {

      FishableI_a ia;
      boolean validInput = false;
      int casts = 0;
      ArrayList<FishableI_a> sack = player.getSack();

      while (casts < 3) {
         System.out.printf("Number of actions left: %d/%d\n", casts, 3);
         printChoices();

         switch (SCANNER.nextLine()) {

            case "1":
               castForFish(fishPond, month, player);
               casts++;
               break;

            case "2":
               printRules();
               break;

            case "3":
               for (int i = 0; i < sack.size(); i++) {
                  ia = sack.get(i);

                  System.out.println("Name:\n"
                          + ia.getName() + "\nLength:\n"
                          + ia.getSex() + "\nWeight:\n"
                          + ia.getWeight() + "\nSex:\n"
                          + ia.getSex() + "\n");
                  sack.set(i, ia);
               } //closes for loop
               break;

            case "4":
               System.out.println("Which fish would you like to throw back?"
                       + " (C to cancel)");

               for (int i = 0; i < sack.size(); i++) {
                  ia = sack.get(i);

                  System.out.println("\nNumber " + (i + 1) + ":\n");
                  System.out.println("Name:\n"
                          + ia.getName() + "\n\nLength:\n"
                          + ia.getLength() + "\n\nWeight:\n"
                          + ia.getWeight() + "\n\nSex:\n"
                          + ia.getSex() + "\n\n");
                  sack.set(i, ia);
               } //closes for loop

               while (!validInput) {

                  try {
                     String userIn = SCANNER.nextLine();

                     if (userIn.equalsIgnoreCase("C")) {
                        break;
                     } //closes if statement

                     int fNum = Integer.parseInt(userIn);
                     ia = sack.get(fNum - 1);
                     fishPond.add(ia);
                     sack.remove(fNum - 1);
                     System.out.println("Removed this fish from your sack and "
                             + "threw it back into the pond:\n\n" + ia + "\n");
                     validInput = true;

                  } catch (NumberFormatException nfe) {
                     System.out.println("Not a valid number. Try again.");
                  } catch (IndexOutOfBoundsException ibe) {
                     System.out.println("There is no fish at that index."
                             + "Try again.");
                  } //closes try-catch statement

               } //closes while loop
               validInput = false;
               break;

            case "5":
               printBag(player);
               break;

            case "6":
               useFood(fishPond, player);
               break;

            default:
               System.out.println("Not a valid choice. Try again.");
               break;

         } //closes switch statement

      } //closes while loop

   } //close lawai_a method

   /**
    * Prints the players choices.
    */
   public static void printChoices() {
      System.out.println("Choose:");
      System.out.println("1. Cast out for a fish");
      System.out.println("2. View fishing rules");
      System.out.println("3. View sack of fish");
      System.out.println("4. Throw back a fish in the sack.");
      System.out.println("5. View bag of fish food");
      System.out.println("6. Feed fish from bag of food");

   } //closes printChoices

   /**
    * Prints the fishing rules.
    */
   public static void printRules() {
      System.out.println("Here are the fishing rules:");
      System.out.println("Ama'Ama rules: Minimum legal length is 11 inches, "
              + "Season is open from April - November, "
              + "Legal catch methods are net and pole\n");
      System.out.println("'Oama rules: No minimum legal length, "
              + "Season is always open, Legal catch methods are net, "
              + "trap and pole\n");
      System.out.println("'Ohua rules: Minimum legal length is 12 inches, "
              + "Season is always open, "
              + "Legal catch methods are throw net, spear and pole\n");
      System.out.println("Moi rules: Minimum legal length is 11 inches, "
              + "Season is open from September - May, "
              + "Legal catch methods are net and pole\n");
      System.out.println("Awa rules: Minimum legal length is 9 inches, "
              + "Season is always open, "
              + "Legal catch methods are net and pole\n");
      System.out.println("Papio rules: Minimum legal length is 10 inches, "
              + "Season is always open, "
              + "Legal catch methods are net, pole, spear and trap\n");

   } //closes printRules

   /**
    * Get the month that corresponds with the given number.
    * @param m is the number that corresponds to a month
    * @return the month as a Month enum
    */
   public static Month getMonth(int m) {
      switch (m) {
         case 1:
            return Month.JANUARY;
         case 2:
            return Month.FEBRUARY;
         case 3:
            return Month.MARCH;
         case 4:
            return Month.APRIL;
         case 5:
            return Month.MAY;
         case 6:
            return Month.JUNE;
         case 7:
            return Month.JULY;
         case 8:
            return Month.AUGUST;
         case 9:
            return Month.SEPTEMBER;
         case 10:
            return Month.OCTOBER;
         case 11:
            return Month.NOVEMBER;
         case 12:
            return Month.DECEMBER;
         default:
            throw new IllegalArgumentException("Invalid month number: " + m);
      }
   }

   /**
   * A method that casts for a fish.
   * @param pond is the ArrayList of fish in the pond
   * @param month is the current month
   * @param player is the current player
   */
   public static void castForFish(ArrayList<FishableI_a> pond, Month month, Player player) {
      CatchMethod catchMethod = getCatchMethod();
      FishableI_a caughtIa = null;
      switch (catchMethod) {
         case POLE:
            caughtIa = usePole(pond);
            break;
         case NET:
            caughtIa = useNet(pond, askForDesirableIa(pond));
            break;
         case SPEAR:
            caughtIa = useSpear(pond, askForDesirableIa(pond));
            break;
         case TRAP:
            caughtIa = useTrap(pond);
            break;
         default:
            break;
      }
      if (caughtIa == null) {
         System.out.println("You didn't hook anything.\n");
         return;
      }
      askToKeep(caughtIa, month, catchMethod, player);
   }

   /**
    * Gets the player's preferred catch method.
    * @return The chosen catch method.
    */
   public static CatchMethod getCatchMethod() {
      boolean invalid = true;
      CatchMethod catchMethod = null;
      while (invalid) {
         System.out.println("Choose your catch method:");
         System.out.println("1: Pole");
         System.out.println("2: Net");
         System.out.println("3: Spear");
         System.out.println("4: Trap");
         switch (SCANNER.nextLine()) {
            case "1":
               catchMethod = CatchMethod.POLE;
               invalid = false;
               break;
            case "2":
               catchMethod = CatchMethod.NET;
               invalid = false;
               break;
            case "3":
               catchMethod = CatchMethod.SPEAR;
               invalid = false;
               break;
            case "4":
               catchMethod = CatchMethod.TRAP;
               invalid = false;
               break;
            default:
               System.out.println("Not a valid catch method. Try again.\n");
         } // switch statement
      } // while loop

      System.out.println("You chose: " + catchMethod.name());
      return catchMethod;
   } // getCatchMethod

   /**
    * Asks the player whether to keep the caught fish.
    * @param caughtIa The fish caught.
    * @param month The current month.
    * @param catchMethod The method used to catch the fish.
    * @param player The current player.
    */
   public static void askToKeep(
           FishableI_a caughtIa,
           Month month,
           CatchMethod catchMethod,
           Player player) {
      System.out.println("You have caught a fish!\n");

      boolean invalid = true;
      while (invalid) {
         System.out.println("Y: Yes, keep the fish.");
         System.out.println("N: No, throw it back in!");
         System.out.println("R: Read the rules.");
         System.out.println("I: Get information on the fish.\n");
         switch (SCANNER.nextLine().toUpperCase()) {
            case "Y":
               System.out.println("You decided to keep the fish.");
               invalid = false;
               break;
            case "N":
               System.out.println("You threw the fish back in the water.\n");
               return;
            case "R":
               printRules();
               break;
            case "I":
               System.out.println("It is currently " + month.name());
               System.out.println(caughtIa);
               break;
            default:
               System.out.println("Invalid choice! Please choose one of the options below.");
         } // switch statement
      } // while loop

      // Note, this should only execute if the player selects "Y".
      if (!(caughtIa.isInSeason(month) || caughtIa.isGamefish()
              || caughtIa.isLegalCatchMethod(catchMethod))) {
         System.out.println("Illegal fish! Your sack has been emptied.");
         player.getSack().removeAll(player.getSack());
      }
      System.out.println("You've got a legal fish!");
      player.getSack().add(caughtIa);
   }

   /**
    * Asks the player for their preferred fish type.
    * @param pond The ArrayList of fish in the pond.
    * @return The preferred fish type.
    */
   public static String askForDesirableIa(ArrayList<FishableI_a> pond) {
      boolean invalid = true;
      String desirableIa = null;
      ArrayList<String> uniqueFish = new ArrayList<>();

      for (FishableI_a ia : pond) {
         String name = ia.getName().toLowerCase();
         if (!uniqueFish.contains(name)) {
            uniqueFish.add(name);
         }
      }

      while (invalid) {
         System.out.println("What kind of I'a would you like? Your options are:");
         int index = 1;
         for (String ia : uniqueFish) {
            System.out.printf("%d: %s\n", index, ia);
            index++;
         }
         String iaNumber = SCANNER.nextLine();
         try {
            int selection = Integer.parseInt(iaNumber);
            if (selection >= 1 && selection <= uniqueFish.size()) {
               desirableIa = uniqueFish.get(selection - 1);
               invalid = false;
            } else {
               System.out.printf("Invalid option, please select a number between %d"  
                    + "and %d\n", 1, uniqueFish.size());
            }
         } catch (NumberFormatException e) {
            System.out.printf("Invalid option, please select a number between %d"
                    + "and %d\n", 1, uniqueFish.size());
         }
      }
      return desirableIa;
   }

   /**
    * Simulates fishing with a pole, biasing towards larger fish.
    * @param pond The ArrayList of fish in the pond.
    * @return The caught fish.
    */
   public static FishableI_a usePole(ArrayList<FishableI_a> pond) {
      FishableI_a caughtIa = null;
      double totalLength = 0;
      for (FishableI_a ia : pond) {
         totalLength += ia.getLength();
      }
      // Generate a random value between 0 and the total length
      double randomValue = RAND.nextDouble() * totalLength;
      for (FishableI_a ia : pond) {
         // Subtract the length of the current fish from the random value
         randomValue -= ia.getLength();
         if (randomValue <= 0) {
            caughtIa = ia;
            break;
         }
      }
      // This dictates if the pole is able to "catch" the fish or not.
      // You can adjust the threshold to control the catch rate.
      if (caughtIa != null && RAND.nextDouble() >= 0.5) {
         return null;
      }
      return caughtIa;
   }

   /**
    * Simulates fishing with a net.
    * @param pond The ArrayList of fish in the pond.
    * @param selectedIa The selected fish type.
    * @return The caught fish.
    */
   public static FishableI_a useNet(ArrayList<FishableI_a> pond, String selectedIa) {
      int time = RAND.nextInt(5, 10);
      System.out.printf("Press ENTER at about %d seconds. Time your entry well!\n", time);
      long t1 = System.currentTimeMillis();
      //Interesting hack to just press enter. The string value doesn't actually matter.
      String string = SCANNER.nextLine();
      long t2 = System.currentTimeMillis();
      double elapsedTime = (t2 - t1) / 1000.0; // Convert milliseconds to seconds
      double catchProbability = Math.max(0.0, 2.0 - Math.abs(elapsedTime - time));
      System.out.printf("Your response was at %.2f seconds.\n", elapsedTime);

      FishableI_a caughtIa = null;
      double totalLength = 0;
      double selectedLength = 0;
      int numOfSelections = 0;
      for (FishableI_a ia : pond) {
         totalLength += ia.getLength();
         if (ia.getName().equals(selectedIa)) {
            continue;
         }
         selectedLength += ia.getLength();
         numOfSelections++;
         if (RAND.nextBoolean()) {
            caughtIa = ia;
         }
      }
      double averageLength = selectedLength / numOfSelections;
      double initProbability = (1 - averageLength / totalLength);

      double totalProbability = initProbability + catchProbability;
      if (totalProbability >= 1.0) {
         return caughtIa;
      }
      return null;
   }

   /**
    * Simulates fishing with a spear.
    * @param pond The ArrayList of fish in the pond.
    * @param selectedIa The selected fish type.
    * @return The caught fish.
    */
   public static FishableI_a useSpear(ArrayList<FishableI_a> pond, String selectedIa) {
      int time = RAND.nextInt(5, 10);
      System.out.printf("Press ENTER at about %d seconds. Time your entry well!\n", time);
      long t1 = System.currentTimeMillis();
      //Interesting hack to just press enter. The string value doesn't actually matter.
      String string = SCANNER.nextLine();
      long t2 = System.currentTimeMillis();
      double elapsedTime = (t2 - t1) / 1000.0; // Convert milliseconds to seconds
      double catchProbability = Math.max(0.0, 2.0 - Math.abs(elapsedTime - time));
      System.out.printf("Your response was at %.2f seconds\n", elapsedTime);

      FishableI_a caughtIa = null;
      double totalLength = 0;
      double selectedLength = 0;
      int numOfSelections = 0;
      for (FishableI_a ia : pond) {
         totalLength += ia.getLength();
         if (ia.getName().equals(selectedIa)) {
            continue;
         }
         selectedLength += ia.getLength();
         numOfSelections++;
         if (RAND.nextBoolean()) {
            caughtIa = ia;
         }
      }
      double averageLength = selectedLength / numOfSelections;
      double initProbability = (1 - averageLength / totalLength);

      double totalProbability = initProbability + catchProbability;
      if (totalProbability >= 1.0) {
         return caughtIa;
      }
      return null;
   }

   /**
    * Simulates fishing with a trap.
    * @param pond The ArrayList of fish in the pond.
    * @return The caught fish.
    */
   public static FishableI_a useTrap(ArrayList<FishableI_a> pond) {
      FishableI_a caughtIa = null;
      // Sort the pond by fish length in ascending order
      Collections.sort(pond);
      double totalInverseLength = 0;
      // Calculate the total inverse length
      for (FishableI_a ia : pond) {
         totalInverseLength += 1 / ia.getLength();
      }
      double randomValue1 = RAND.nextDouble() * totalInverseLength;
      double cumulativeInverseLength = 0;
      for (FishableI_a ia : pond) {
         cumulativeInverseLength += 1 / ia.getLength();
         // Check if the random value falls within the cumulative range
         if (randomValue1 < cumulativeInverseLength) {
            caughtIa = ia;
            break; // Exit the loop once a fish is caught
         }
      }
      // Adjust the probability of catching the fish based on a random value
      double randomValue2 = RAND.nextDouble();
      if (randomValue2 >= 0.8) { // Adjust the threshold as needed
         return null;
      }
      return caughtIa;
   }


   /**
   * Determines the winner of the game.
   * @param p1 is player1
   * @param p2 is player2
   */
   public static void findWinner(Player p1, Player p2) {
      ArrayList<FishableI_a> p1Sack = p1.getSack();
      ArrayList<FishableI_a> p2Sack = p2.getSack();
      FishableI_a ia;
      double p1Sum = 0.0;
      double p2Sum = 0.0;


      //gets the sum of player1's three longests fish lengths
      for (int i = 0; i < 3 && i < p1Sack.size(); i++) {
         ia = p1Sack.get(i);
         p1Sum = p1Sum + ia.getLength();
         p1Sack.set(i, ia);
      } //closes for loop

      //gets the sum of player2's three longests fish lengths
      for (int i = 0; i < 3 && i < p2Sack.size(); i++) {
         ia = p2Sack.get(i);
         p2Sum = p2Sum + ia.getLength();
         p2Sack.set(i, ia);
      } //closes for loop

      if (p1Sack.size() > 0 || p2Sack.size() > 0) {

         //prints player1's three longest fish
         if (p1Sack.size() != 0) {
            System.out.println(p1.getName() + "'s (up to) three largest fish:");
         } //closes if statement

         for (int i = 0; i < 3 && i < p1Sack.size(); i++) {
            ia = p1Sack.get(i);
            System.out.println(ia + "\n");
            p1Sack.set(i, ia);
         } //closes for loop

         //prints player2's three longest fish
         if (p2Sack.size() != 0) {
            System.out.println(p2.getName() + "'s (up to) three largest fish:");
         } //closes if statement

         for (int i = 0; i < 3 && i < p2Sack.size(); i++) {
            ia = p2Sack.get(i);
            System.out.println(ia + "\n");
            p2Sack.set(i, ia);
         } //closes for loop

         try {
            if (p1Sum > p2Sum) {
               ia = p1Sack.get(0);
               System.out.println(p1.getName() + " wins!");
               System.out.println("Their largest fish was:\n" + ia + "\n");
               System.out.println("The sum of their (up to) three largest fish"
                     + " lengths are: " + p1Sum);
               p1Sack.set(0, ia);
            } else if (p2Sum > p1Sum) {
               ia = p2Sack.get(0);
               System.out.println(p2.getName() + " wins!");
               System.out.println("Their largest fish was:\n" + ia + "\n");
               System.out.println("The sum of their (up to) three largest fish"
                     + " lengths are: " + p2Sum);
               p2Sack.set(0, ia);
            } else {
               System.out.println("It's a tie!");
               System.out.println("The sum of " + p1.getName() + "'s (up to)"
                     + "three largest fish lengths are:" + p1Sum);
               System.out.println("The sum of " + p2.getName() + "'s (up to)"
                     + "three largest fish lengths are:" + p2Sum);
            } //closes if-else if-else statement

         } catch (IndexOutOfBoundsException ie) {

            if (p1Sack.size() == 0) {

               ia = p2Sack.get(0);
               System.out.println(p1.getName() + " has no fish.");
               System.out.println(p2.getName() + " wins by default!");
               System.out.println("Their largest fish was:\n" + ia + "\n");
               System.out.println("The sum of their (up to) three largest fish"
                     + " lengths are: " + p2Sum);
               p2Sack.set(0, ia);

            } else {

               ia = p1Sack.get(0);
               System.out.println(p2.getName() + " has no fish.");
               System.out.println(p1.getName() + " wins by default!");
               System.out.println("Their largest fish was:\n" + ia + "\n");
               System.out.println("The sum of their (up to) three largest fish"
                     + " lengths are: " + p1Sum);

            } //closes if-else statement

         } //closes try-catch statement

      } else {
         System.out.println("Neither player has any fish.");
         System.out.println("It's a tie!");
      } //closes if statement

   } //closes findWinner

   /**
    * Adds a random food item to the players food bag.
    * @param player is the current player
    */
   public static void addRandFood(Player player) {
      int random = RAND.nextInt(Food.values().length);
      Food randFood = Food.values()[random];
      player.getBag().add(randFood);
      System.out.println("\nAdded " + randFood.name + " to "
              + player.getName() + "'s bag.\n");
   } //closes addRandFood

   /**
    * Prints the player's bag of fish food.
    * @param player the current player
    */
   public static void printBag(Player player) {
      ArrayList<Food> bag = player.getBag();
      if (bag == null || bag.isEmpty()) {
         System.out.println("Your bag is empty!");
         return;
      }

      Map<Food, Integer> itemCountMap = new HashMap<>();

      // Count occurrences of each food item in the bag
      for (Food item : bag) {
         Integer count = itemCountMap.get(item);
         if (count == null) {
            itemCountMap.put(item, 1);
         } else {
            itemCountMap.put(item, count + 1);
         }
      }

      System.out.println("Food items in bag:");
      for (Map.Entry<Food, Integer> entry : itemCountMap.entrySet()) {
         Food foodItem = entry.getKey();
         int count = entry.getValue();
         System.out.println(foodItem.name + ": " + count);
      }
      System.out.println();
   }

   /**
    * Method to let the player use food in their bag to feed fish.
    * @param fishPond is the ArrayList of fish in the pond
    * @param player is the current player feeding fish
    */
   public static void useFood(ArrayList<FishableI_a> fishPond, Player player) {
      ArrayList<Food> bag = player.getBag();
      if (bag == null || bag.isEmpty()) {
         System.out.println("Your bag is empty!");
         return;
      }

      Food food;
      boolean valid = false;

      System.out.println("Choose a food item to feed the fish: (C to cancel)"
              + " (D for fish diets)");
      printBag(player);

      while (!valid) {
         printBag(player);
         switch (SCANNER.nextLine()) {

            case "1":
               food = Food.ALGAE;
               valid = true;
               break;
            case "2":
               food = Food.CRUSTACEANS;
               valid = true;
               break;

            case "3":
               food = Food.DETRITUS;
               valid = true;
               break;

            case "4":
               food = Food.INVERTEBRATES;
               valid = true;
               break;

            case "5":
               food = Food.MOLLUSK;
               valid = true;
               break;

            case "6":
               food = Food.WORMS;
               valid = true;
               break;

            case "7":
               food = Food.ZOOPLANKTON;
               valid = true;
               break;

            case "C": 
            case "c":
               return;

            case "D":
            case "d":
               printDiets();
               continue;
            default:
               System.out.println("Invaid input. Try again.\n");
               continue;
         } //closes switch statement

         for (Food item : bag) {
            if (item.equals(food)) {
               bag.remove(item);
               feedFish(fishPond, item);
               return;

            } //closes if-else statement

         } //closes for loop

         //prints if there are none of food type in bag
         System.out.println("You have no " + food.name
                 + ". Please choose again.");

      } //closes while loop

   } //closes useFood

   /**
    * Feeds a random fish in the pond that eats the given food type.
    * @param fishPond is the ArrayList of fish in the pond
    * @param food is the food to be fed to a random fish
    */
   public static void feedFish(ArrayList<FishableI_a> fishPond, Food food) {
      FishableI_a ia;
      Food[] diet;
      boolean fed = false;
      double oldLen;
      double newLen;
      int count = 0;
      int index = RAND.nextInt(fishPond.size());
      ia = fishPond.get(index);

      try {

         while (!fed) {

            ia = fishPond.get(index);
            diet = ia.getDiet();

            //checks if ia eats given food
            for (int i = 0; i < diet.length; i++) {
               if (food.equals(diet[i])) {
                  oldLen = ia.getLength();
                  ia.eat(food);
                  newLen = ia.getLength();
                  System.out.println("\nFed a random " + ia.getName()
                          + " in the pond. (It grew " + (newLen - oldLen)
                          + " inches)\n");
                  fed = true;

               } //closes if statement

            } //closes for loop


            //if ia doesn't eat given food get new ia
            if (!fed) {
               index = RAND.nextInt(fishPond.size());

            } //closes if statement

            count++;
            //prevents an infinite loop if there are no fish that eat the food
            if (count > (fishPond.size() * 4)) {
               System.out.println("There are no fish in the pond that eat "
                       + food.name);
               return;
            } //closes if statement

         } //closes while loop

         //fse thrown if fish is too large and needs to level up
      } catch (FishSizeException fse) {
         oldLen = ia.getLength();
         System.out.print(ia.getName() + " leveled up to a ");
         ia = (FishableI_a) ia.levelUp();
         newLen = ia.getLength();
         System.out.println(ia.getName() + ". (It grew " + (newLen - oldLen)
                 + " inches)\n");

      } //closes try-catch statement

      //puts fed (and possibly leveled up) fish back into pond
      fishPond.set(index, ia);

   } //closes feedFish

   /**
    * Prints the diets of all the fish.
    */
   public static void printDiets() {
      System.out.println("These are the diets of the fish:");
      System.out.println("Ama'Ama: Algae, Detritus, Invertebrates,"
              + " Zooplankton.");
      System.out.println("'Oama: Invertebrates, Mollusk, Worms.");
      System.out.println("'Ohua: Algae.");
      System.out.println("Moi: Crustaceans.");
      System.out.println("Awa: Algae, Detritus, Invertebrates, Zooplankton.");
      System.out.println("Papio: Crustaceans.\n");

   } //closes printRules

} //closes FishingDriver