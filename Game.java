import java.util.Scanner;

public class Game {   
   public static void main(String[] args) {
      boolean exitGame = false;
      Game game = new Game();
      Map dungeonMap = new Map(5, 6);
            
      Scanner scanner = new Scanner(System.in);
      Room room = new Room(); 
      Inventory inventory = new Inventory();
      //System.out.println(room);
      // TODO: Create a Map which populates each element of the grid with a Room
      // that contains a random assortment of Monsters and Items
      dungeonMap.populateMap();
      // TODO: Create a Player at a random location in the Map
      // HINT: Generate random row/column values using Math.random()
      // and pass them into the Player constructor
      int x =  (int) (Math.random()*5);
      int y =  (int) (Math.random()*6);
      Player player = new Player(100, "Toren", x, y);
      while (exitGame != true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().toUpperCase();
                        
            if (input.equals("EXIT")) {
                System.out.println("Exiting game. Goodbye!");
                exitGame = true;
            }
            else if (input.equals("LOOK") || input.equals("SEARCH")) {
               System.out.println(player.look(dungeonMap));
            }
            // TODO: get the player movement working correctly. It should NOT let the player
            // move beyond the boundaries of the map, and provide the user with descriptions
            // of what is happening. You'll have to change the if/else/if statements here to 
            // do this.
            else if (input.startsWith("MOVE ")) {
               String direction = input.substring(5);
               if (direction.equals("UP")) {
                  if (y+1 > 5) {
                     y = 5;
                     System.out.println("Cannot move more this direction");
                  }
                  else {
                     y += 1;
                     player.moveTo(x,y);
                     System.out.println(player.getRoom(dungeonMap));
                  }   
               } 
               else if (direction.equals("DOWN")) {
                  if (y-1 < 0) {
                     y = 0;
                     System.out.println("Cannot move more this direction");
                  }  
                  else {
                     y -= 1;
                     player.moveTo(x,y);
                     System.out.println(player.getRoom(dungeonMap));
                  }
               }
               else if (direction.equals("LEFT")) {
                  if (x-1 < 0) {
                     x = 0;
                     System.out.println("Cannot move more this direction");
                  }
                  else {
                     x -= 1;
                     player.moveTo(x,y);
                     System.out.println(player.getRoom(dungeonMap)); 
                  }
               }
               else if (direction.equals("RIGHT")) {
                  if (x+1 > 4) {
                     x = 4;
                     System.out.println("Cannot move more this direction");
                  } 
                  else {
                     x += 1;
                     player.moveTo(x,y);
                     System.out.println(player.getRoom(dungeonMap));
                  }
               }
               else {
                  System.out.println("You're trying to move in an invalid direction. Please choose UP, DOWN, LEFT or RIGHT");
               }
            }
            else if (input.startsWith("TAKE ")) {
               String item = input.substring(5);
               for (Item i : player.getRoom(dungeonMap).getItems()) {
                  if (item.equals(i.toString())) {
                     inventory.addItemToInventory(i);
                     player.getRoom(dungeonMap).removeItem(i);
                  }
                  else {
                     System.out.println("Item does not exist in room!");
                  }
               }
            }
         // TODO: display a message to the user telling them their current coordinates every time they move
         System.out.println("("+x+", "+y+")");
       }
   }
}