//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Vending Machine
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
// Below is a javadoc class header to complete
/**
 * Vends and machines
 * 
 * @author Frank Zhang
 * @author Peter Foster
 * 
 *
 */
public class VendingMachine {

  /**
   * Adds/appends an item defined by its description and expirationDate to a vending machine
   * represented by an oversize array of strings defined by the two-dimensional array items and its
   * size itemsCount. The item will be added to the end of the array. If the vending machine is
   * full, the new item won't be added and the method returns the items count passed as input
   * without making any changes to the contents of the array items.
   * 
   * @param description    description of the item to be added to the vending machine
   * @param expirationDate a string parsable to a positive integer which represents the expiration
   *                       date of the item. The date "0" represents January 1st 2023.
   * @param items          a two-dimensional of strings storing items. items[i][0] and items[i][1]
   *                       respectively represent the description and the expiration date of the
   *                       item stored at index i
   * @param itemsCount     number of items in the vending machine
   * @return the size of the vending machine after trying to add the new item
   */
  public static int addItem(String description, String expirationDate, String[][] items,
      int itemsCount) {

    if (itemsCount == items.length) {
      return itemsCount;
    }
    // Creates new item object @ location of first available null (itemsCount index location)
    items[itemsCount] = new String[] {description, expirationDate};
    return itemsCount + 1;
  }

  /**
   * Returns without removing a string representation of the item at the given index within the
   * vending machine defined by the array items and its size itemsCount. This method does not make
   * any changes to the contents of the vending machine.
   * 
   * @param items      two dimensional array storing items within a vending machine where
   *                   items[i][0] represents the description of the item at index i and items[i][1]
   *                   stores its expiration date.
   * @param itemsCount (size) number of items stored in the vending machine
   * @param index      index of an item within the provided vending machine
   * @return a string representation of the item stored at the given index within the vending
   *         machine defined by items and itemsCount. The returned string must have the following
   *         format: "description (expiration date)". If the provided index is out of the range of
   *         indexes 0..itemsCount-1, the method returns "ERROR INVALID INDEX"
   */
  public static String getItemAtIndex(int index, String[][] items, int itemsCount) {
    if (index > itemsCount - 1)
      return "ERROR INVALID INDEX";
    String itemname = items[index][0];
    String date = items[index][1];
    return itemname + " (" + date + ")";
  }

  /**
   * Returns without removing the index of the item having the provided description and the smallest
   * expiration date within the vending machine defined by the array items and its size itemsCount.
   * 
   * @param description description of the item to get its index
   * @param items       two dimensional array storing items within a vending machine where
   *                    items[i][0] represents the description of the item at index i and
   *                    items[i][1] stores its expiration date.
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return the index of the next item, meaning the item with the given description and the
   *         smallest expiration date. If no match found, return -1.
   */
  public static int getIndexNextItem(String description, String[][] items, int itemsCount) {
    int index = -1;
    int date = Integer.MAX_VALUE; // arbitrarily large number
    // If the vending machine contains more than one item with the given description,
    // return the index o the one with the smallest expiration date.
    for (int i = 0; i < itemsCount; i++) {
      if (description.equals(items[i][0])) {
        int expdate = Integer.parseInt(items[i][1]);
        if (expdate < date) {
          index = i;
          date = expdate;
        }
      }
    }
    return index; // DONE
  }

  /**
   * Removes the item having the provided description with the smallest expiration date within the
   * vending machine defined by the array items and its size itemsCount. This method should maintain
   * the order of precedence of items in the vending machine. This means that the remove operation
   * involves a shift operation.
   * 
   * @param description description of the item to remove or dispense
   * @param items       array storing items within a vending machine
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return size of the vending machine after removing the item with the given description and the
   *         smallest expiration date. If no match found, this method must return the provided
   *         itemsCount without making any change to the contents of the vending machine.
   */
  public static int removeNextItem(String description, String[][] items, int itemsCount) {
    int location = getIndexNextItem(description, items, itemsCount);

    if (location == -1) {
      return itemsCount;
    }
    for (int i = location; i < itemsCount; i++) {
      //items[i] = items[i + 1]; SEE ERROR OUT OF BOUNDS  SEE ERROR OUT OF BOUNDS  SEE ERROR OUT OF BOUNDS  SEE ERROR OUT OF BOUNDS  SEE ERROR OUT OF BOUNDS
    }
    items[itemsCount - 1] = null;
    return itemsCount - 1;
  }



  /**
   * Returns the number of occurrences of an item with a given description within the vending
   * machine defined by items and itemsCount
   * 
   * @param description description (name) of an item
   * @param items       two dimensional array storing items within a vending machine where
   *                    items[i][0] represents the description of the item at index i and
   *                    items[i][1] stores its expiration date.
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return the number of occurrences of an item with a given description within the vending
   *         machine
   */
  public static int getItemOccurrences(String description, String[][] items, int itemsCount) {
    int counter = 0;

    for (int i = 0; i < itemsCount; i++) {
      if (description.equals(items[i][0])) {
        counter++;
      }

    }
    return counter; // DONE
  }

  /**
   * Checks whether a vending machine defined by the array items and its size itemsCount contains at
   * least an item with the provided description
   * 
   * @param description description (name) of an item to search
   * @param items       two dimensional array storing items within a vending machine where
   *                    items[i][0] represents the description of the item at index i and
   *                    items[i][1] stores its expiration date.
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return true if there is a match with description in the vending machine, false otherwise
   */
  public static boolean containsItem(String description, String[][] items, int itemsCount) {
    return getItemOccurrences(description, items, itemsCount) > 0; // DONE
  }

  /**
   * Returns the number of items in the vending machine with a specific description and whose
   * expiration dates are greater or equal to a specific expiration date
   * 
   * @param description    description of the item to find its number of occurrences
   * @param expirationDate specific (earliest) expiration date
   * @param items          two dimensional array storing items within a vending machine where
   *                       items[i][0] represents the description of the item at index i and
   *                       items[i][1] stores its expiration date.
   * @param itemsCount     (size) number of items stored in the vending machine
   * @return the number of items with a specific description and whose expiration date is greater or
   *         equal to the given one
   */
  public static int getItemsOccurrencesByExpirationDate(String description, String expirationDate,
      String[][] items, int itemsCount) {
    int counter = 0;
    int date = Integer.parseInt(expirationDate);

    for (int i = 0; i < itemsCount; i++) {
      if (description.equals(items[i][0]) && (Integer.parseInt(items[i][1]) >= date)) {
        counter++;
      }

    }
    return counter;
  }

  /**
   * Returns a summary of the contents of a vending machine in the following format: Each line
   * contains the description or item name followed by one the number of occurrences of the item
   * name in the vending machine between parentheses. For instance, if the vending machine contains
   * five bottles of water, ten chocolates, and seven snacks, the summary description will be as
   * follows. "water (5)\nchocolate (10)\nsnack (7)" If the vending machine is empty, this method
   * returns an empty string ""
   * 
   * @param items      two dimensional array storing items within a vending machine where
   *                   items[i][0] represents the description of the item at index i and items[i][1]
   *                   stores its expiration date.
   * @param itemsCount (size) number of items stored in the vending machine
   * @return a descriptive summary of the contents of a vending machine
   */
  public static String getItemsSummary(String[][] items, int itemsCount) {
    String[] names = new String[itemsCount + 1000];
    int[] amt = new int[itemsCount + 1000];
    int namessize = 0;
    for (int i = 0; i < itemsCount; i++) {
      int index = listIterator(items[i][0], names);
      if (index == -1) {
        names[namessize] = items[i][0];
        amt[namessize] = 1;
        namessize = namessize + 1;
      } else {
        amt[index] = amt[index] + 1;
      }
    }
    String output = "";
    for (int i = 0; i < names.length; i++) {
      if (names[i] != null) {
        output = output + names[i] + " (" + amt[i] + ")\n";
      }
    }
    return output; // DONE
  }


  /**
   * 
   * @param description item name
   * @param names       list of names
   * @return int location
   */
  private static int listIterator(String description, String[] names) {
    for (int i = 0; i < names.length; i++) {
      if (description.equals(names[i]))
        return i;
    }
    return -1;
  }

}
