import java.util.ArrayList;

public class Room {
   private ArrayList<Item> itemsInRoom;
   private ArrayList<Monster> monstersInRoom;
   private final int maxNumberOfMonsters = 2;
   private final int maxNumberOfItems = 2;
   
   public Room() {
      monstersInRoom = new ArrayList<Monster>();
      itemsInRoom = new ArrayList<Item>();
      // TODO: Generate a random number of monsters and items between 1 and max (inclusive)
      for (int i = 0; i < (int)(Math.random() * maxNumberOfMonsters) + 1; i++) {
         monstersInRoom.add(new Monster());
      }
      for (int j = 0; j < (int)(Math.random() * maxNumberOfItems) + 1; j++) {
         itemsInRoom.add(new Item());
      }
      // TODO: Create the ArrayLists to hold the Items and Monsters in the Room and populate them with Monsters and Items
      
   }
   public void addItem(Item item) {
      itemsInRoom.add(item);
   }
   public void addMonster(Monster monster) {
      monstersInRoom.add(monster);
   }
   public void removeItem(Item item) {
      itemsInRoom.remove(item);
   }
   public ArrayList<Item> getItems() {
      return itemsInRoom;
   }
   public String toString() {
      String returnString = "Items in room: \n";

      // TODO: build a returnString that nicely formats the Monsters and Items in the Room
      // HINT: Use a for-each loop to go through the ArrayLists
      for (Item item : itemsInRoom) {
         returnString += item + "\n";
      }
      returnString += "Monsters in room: \n";
      for (Monster monster : monstersInRoom) {
         returnString += monster + "\n";
      }
      return returnString;
   }

   }