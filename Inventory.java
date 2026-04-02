import java.util.ArrayList;
public class Inventory {
   private ArrayList<Item> inventory;
   public Inventory() {
      inventory = new ArrayList<Item>();
   }
   public String addItemToInventory(Item item) {
      if (!inventory.contains(item)) {
         inventory.add(item);
         return "Added " + item + " to inventory";
      }
      else {
         return "Already have item in inventory!";
      }
   }
   public String removeItemFromInventory(Item item) {
      if(inventory.contains(item)) {
         inventory.remove(item);
         return "Removed " + item + " from inventory";
      }
      else {
         return "You do not have this item!";
      }
   }
   public boolean hasItem(String item) {
      for (Item i : inventory) {
         if (i.toString().equals(item)) {
            return true;
         }
      }
      return false;
   }
}