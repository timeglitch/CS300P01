import java.util.Arrays;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Vending MachineTester
// Course: CS 300 Fall 2022
//
// Author: Frank Zhang
// Email: fjzhang@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Peter Foster
// Partner Email: prfoster@wisc.edu
// Partner Lecturer's Name: Jeff Nyhoff
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////
public class VendingMachineTester {

  // TODO complete the implementation of the following tester methods and add their javadoc style
  // method headers

  // Checks the correctness of getIndexNextItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testGetIndexNextItem() {
    // Test scenarios normal and edge cases
    // Recall that the VendingMachine.getNextItem method gets the next item to be dispensed given
    // its description without removing it.

    // 1. Next item to be dispensed is NOT found: the expected output is -1
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("candy", items, itemsCount) != -1) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did not return "
                + "-1 when no match found.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 2. Next item to be dispensed is at index 0
    {
      String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 0) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at index 0.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 3. Next item to be dispensed is at the end of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Chocolate", items, itemsCount) != 6) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at the end of the array");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 4. Next item to be dispensed is at the middle of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 3) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains matches with the provided "
                + "item description with different expiration dates.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    return true; // No bug detected
  }

  // Checks the correctness of containsItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testContainsItem() {
    // Define at least two test scenarios: (1) successful search returning true and (2) unsuccessful
    // search returning false.

    // 1. Test does not contains item - Should return false
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.containsItem("Corn", items, itemsCount)) {
        System.out.println("testContainsItem(). Problem detected: Your containsItem did not return "
            + "false when no match found.");
        return false;
      }

    }

    // 2. Test do contain item - Should return true
    {
      // define the vending machine
      String[][] items = new String[][] {{"Water", "5"}, {"Chocolate Cake", "1"}, {"Doritos", "20"},
          null, null, null, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (!VendingMachine.containsItem("Doritos", items, itemsCount)) {
        System.out.println("testContainsItem(). Problem detected: Your containsItem did not return "
            + "true when match found.");
        return false;
      }
    }

    return true; // No bug detected
  }

  // Checks the correctness of getItemAtIndex defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testGetItemAtIndex() {
    // Define at least two test scenarios: (1) the provided index is out of the range
    // 0..itemsCount-1, (2) the provided index is in bounds [0..itemsCount-1].
    // For each test scenario, ensure that the method returned the exact expected string output
    // without making any changes to the contents of the array.

    // 1. The provided index is out of the range - Should return "ERROR INVALID INDEX".
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;
      int outOfRangeIndex = 999;

      // check the correctness of the output
      if (!VendingMachine.getItemAtIndex(outOfRangeIndex, items, itemsCount)
          .equals("ERROR INVALID INDEX")) {
        System.out
            .println("testGetItemAtIndex(). Problem detected: Your getItemAtIndex did not return "
                + "ERROR INVALID INDEX when accessing an out of range index");
        return false;
      }
    }

    // 2. The provided index is within range - Should return a string representation of the item
    // stored at the given index
    {
      // define the vending machine
      String[][] items = new String[][] {{"Water", "15"}, null, null, null, null, null, null};
      int itemsCount = 1;
      int withinRangeIndex = 0;

      // check the correctness of the returned String
      if (!VendingMachine.getItemAtIndex(withinRangeIndex, items, itemsCount)
          .equals("Water (15)")) {
        System.out.println("testGetItemAtIndex(). Problem detected: Your getItemAtIndex returned "
            + "the wrong String data when accessing an appropriate index");
      }

      // check the correctness of the error prompt
      if (VendingMachine.getItemAtIndex(withinRangeIndex, items, itemsCount)
          .equals("ERROR INVALID INDEX")) {
        System.out.println("testGetItemAtIndex(). Problem detected: Your getItemAtIndex returned "
            + "ERROR INVALID INDEX when accessing an appropriate index");
        return false;
      }
    }

    return true; // No bug detected
  }

  // Checks the correctness of getItemOccurrences defined in the VendingMachine class.
  public static boolean testGetItemsOccurrences() {
    // Define at least two test scenarios: (1) no match found so that the method returns zero,
    // (2) the items array contains multiple occurrences of the provided item description.

    // For each test scenario, ensure that the method returned the expected output without making
    // any changes to the contents of the array.

    // 1. No match found so that the method returns zero
    {
      // define the vending machine

      String[][] items = new String[][] {{"Waffles", "20"}, {"Not Soda", "60"}, null, null, null};
      int itemsCount = 2;
      // check the correctness of the output
      if (!(VendingMachine.getItemOccurrences("Soda", items, itemsCount) == 0)) {
        System.out.println(
            "testGetItemOccurrences. Problem detected: Your getItemOccurrences did not return "
                + "the valid number of occurences (None/0).");
        return false;
      }

      // Check to see if any changes were made to array
      if (!(items[0][0].equals("Waffles") && (items[0][1].equals("20")))) {
        System.out
            .println("testGetItemOccurrences. Problem detected: Your getItemOccurrences shifted"
                + " your array!");
        return false;
      }
      // Check to see if any changes were made to array
      if (!(items[1][0].equals("Not Soda") && (items[1][1].equals("60")))) {
        System.out
            .println("testGetItemOccurrences. Problem detected: Your getItemOccurrences shifted"
                + " your array!");

        return false;
      }
    }

    // 2. The items array contains multiple occurrences of the item ("Soda") -
    // prompts error message if number of occurrences != number of items
    {
      // define the vending machine

      String[][] items = new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"},
          {"Soda", "20"}, {"Soda", "100"}, {"Water", "30"}, {"Soda", "20"}};
      int itemsCount = 7;
      int numOfOccurences = 4; // There are 4 Soda items
      // check the correctness of the output
      if (!(VendingMachine.getItemOccurrences("Soda", items, itemsCount) == numOfOccurences)) {
        System.out.println(
            "testGetItemOccurrences. Problem detected: Your getItemOccurrences did not return "
                + "the valid number of occurences.");
        return false;
      }

      // Check to see if any changes were made to array
      if (!(items[0][0].equals("Water") && (items[0][1].equals("50")))) {
        System.out
            .println("testGetItemOccurrences. Problem detected: Your getItemOccurrences shifted"
                + " your array!");
        return false;
      }
      // Check to see if any changes were made to array
      if (!(items[1][0].equals("Soda") && (items[1][1].equals("60")))) {
        System.out
            .println("testGetItemOccurrences. Problem detected: Your getItemOccurrences shifted"
                + " your array!");
        return false;
      }
    }

    return true; // No bug detected
  }

  // Checks the correctness of addItem defined in the VendingMachine class.
  public static boolean testAddItem() {
    // Define at least three test scenarios: (1) adding a new item to an empty vending machine whose
    // size is zero (provided itemsCount == 0), (2) adding a new item to a non-empty non-full
    // vending machine, and (3) adding a new item to a full vending machine where the provided
    // itemsCount equals the length of the provided items array.

    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.

    // 1. Adding a new item to an empty vending machine whose size is zero - should return 0
    // since the vending machine size is 0
    {
      String[][] items = new String[][] {};
      int itemsCount = 0;
      // check the correctness of the output
      if (!(VendingMachine.addItem("Test Item", "42", items, itemsCount) == 0)) {
        System.out.println("testAddItem(). Problem detected: Result unexpected");
        return false;
      }
    }

    // 1.5 Adding a new item to an empty vending machine whose size is not-zero - should return 1
    // since the vending machine size is updated to 1
    {
      String[][] items = new String[][] {null, null, null, null, null};
      int itemsCount = 0;
      // check the correctness of the output
      if (!(VendingMachine.addItem("Test Item", "20", items, itemsCount) == 1)) {
        System.out.println("testAddItem(). Problem detected: Result unexpected");
        return false;
      }
      // check to make sure array is still in order based off of specific index
      if (!(items[0][0].equals("Test Item") && (items[0][1].equals("20")))) {
        System.out.println("testAddItem(). Problem detected: Your array shifted");
        return false;
      }
    }

    // 2. Adding a new item to a non-empty non-full vending machine - should return
    // new size of vending machine
    {
      String[][] items = new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"},
          {"Chips", "20"}, {"Soda", "100"}, {"Coke", "30"}, {"Soda", "20"}, null, null};
      int itemsCount = 7;
      // check the correctness of the output
      if (!(VendingMachine.addItem("Test Item", "20", items, itemsCount) == 8)) {
        System.out.println("testAddItem(). Problem detected: Result unexpected");
        return false;
      }

      // check to make sure array is still in order based off of specific index
      if (!(items[7][0].equals("Test Item") && (items[7][1].equals("20")))) {
        System.out.println("testAddItem(). Problem detected: Your array shifted");
        return false;
      }
    }

    // 3. Adds a new item to a full vending machine where the provided
    // itemsCount equals the length of the provided items array.
    // Should return itemsCount/items.length
    {
      String[][] items = new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"},
          {"Chips", "20"}, {"Soda", "100"}, {"Coke", "30"}, {"Soda", "20"}};
      int itemsCount = 7;
      // check the correctness of the output
      if (!(VendingMachine.addItem("Test Item", "20", items, itemsCount) == 7)) {
        System.out.println("testAddItem(). Problem detected: Result ERROR.");
        return false;
      }

    }
    return true; //DONE
  }

  // Checks the correctness of removeNextItem defined in the VendingMachine class.
  public static boolean testRemoveNextItem() {
    // Define at least four test scenarios: (1) trying to remove a non-existing item from a vending
    // machine (the vending machine can be empty or not), (2) the next item to be removed matching
    // the provided description is at index 0 of the array, (3) the next item to be removed is at
    // index itemsCount of the array (at the end of the array), and (4) the next item to be removed
    // is at a middle index of the provided items array.

    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.


    // Basic test
    {
      String[][] items = new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"},
          {"Chips", "20"}, {"Soda", "100"}, {"Coke", "30"}, {"Soda", "20"}};
      int itemsCount = 7;
      // check the correctness of the output
      if (!(VendingMachine.removeNextItem("Soda", items, itemsCount) == 6)) {
        System.out.println("testRemoveNextItem(). Problem detected: Array size ERRONEOUS.");
        return false;
      }

    }

    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of getItemsSummary defined in the VendingMachine class.
  public static boolean testGetItemsSummary() {
    // Define at least three scenarios: (1) the vending machine is empty, (2) the vending machine
    // contains non duplicate items (no multiple items with the same description), (3) the vending
    // machine contains multiple items with the same description at various index locations.

    return false; // default return statement to let this incomplete code compiles with no errors.
  }

  // This method returns false if any of the tester methods defined in this class fails, and true
  // if no bug detected.
  public static boolean runAllTests() {
    if (testGetIndexNextItem() && testContainsItem() && testGetItemAtIndex()
        && testGetItemsOccurrences() && testAddItem() && testRemoveNextItem()
        && testGetItemsSummary())
      return true;

    return false; // return statement if there are any issues
  }

  // main method to call the tester methods defined in this class
  public static void main(String[] args) {
    System.out.println("testGetIndexNextItem(): " + testGetIndexNextItem());
    System.out.println("testContainsItem(): " + testContainsItem());
    System.out.println("testGetItemAtIndex(): " + testGetItemAtIndex());
    System.out.println("testGetItemsOccurrences(): " + testGetItemsOccurrences());
    System.out.println("testAddItem() " + testAddItem());
    System.out.println("testRemoveNextItem() " + testRemoveNextItem());
    System.out.println("testGetItemsSummary(): " + testGetItemsSummary());


    System.out.println("runAllTests(): " + runAllTests());

  }

}
