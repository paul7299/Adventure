import java.util.ArrayList;

public class Player {

    private int playerHealth;
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    public ArrayList<Item> showInventory() {
        return inventory;
    }

    // Constructor
    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.playerHealth = 50;
    }

    public String goNorth() {
        String goingNorthResult;
        if (currentRoom.getRoomNorth() == null) {
            goingNorthResult = "* You cannot go north from here *\n";
        } else {
            goingNorthResult = "* Going north *\n";
            currentRoom = currentRoom.getRoomNorth();
        }
        return goingNorthResult;
    }

    public String goSouth() {
        String goingSouthResult;
        if (currentRoom.getRoomSouth() == null) {
            goingSouthResult = "* You cannot go south from here *\n";
        } else {
            goingSouthResult = "* Going south *\n";
            currentRoom = currentRoom.getRoomSouth();
        }
        return goingSouthResult;
    }

    public String goEast() {
        String goingEastResult;
        if (currentRoom.getRoomEast() == null) {
            goingEastResult = "* You cannot go east from here *\n";
        } else {
            goingEastResult = "* Going east *\n";
            currentRoom = currentRoom.getRoomEast();
        }
        return goingEastResult;
    }

    public String goWest() {
        String goingWestResult;
        if (currentRoom.getRoomWest() == null) {
            goingWestResult = "* You cannot go west from here *\n";
        } else {
            goingWestResult = "* Going west *\n";
            currentRoom = currentRoom.getRoomWest();
        }
        return goingWestResult;
    }

    public String look() {
        if (currentRoom.getItemsInRoom().isEmpty())
            return currentRoom.getRoomDescription() + "\n" + "there are no items in the room\n";
        else
            return currentRoom.getRoomDescription() + "\n" + "In the room you can see the following: " + currentRoom.getItemsInRoom() + "\n";

    }

    public String getCurrentRoomNameFromPlayer() {
        return currentRoom.getRoomName();
    }

    public void setHasVisitedToTrue() {
        currentRoom.setHasVisitedToTrue();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean getHasVisitedStatus() {
        return currentRoom.getHasVisited();
    }

    public int getPlayerHealth(){
        return playerHealth;
    }

    public Item searchForItem(String searchName, ArrayList<Item> arrayList) {
        for (Item n : arrayList) {
            if (n.getItemName().contains(searchName)) {
                return n;
            }
        }
        return null;
    }

    // TODO Asger
    public String pickUpItem(String name) {
        Item itemToTransfer = searchForItem(name, currentRoom.getItemsInRoom());
        String e;
        if (itemToTransfer == null) {
            e = "No item found\n";
        } else {
            inventory.add(itemToTransfer);
            currentRoom.getItemsInRoom().remove(itemToTransfer);
            e = ("You have picked up " + itemToTransfer.getItemName() + "\n");
        }
        return e;
    }

    // TODO Asger
    public String dropItem(String name) {
        Item itemToTransfer = searchForItem(name, inventory);
        if (itemToTransfer == null) {
            return "No item found\n";
        } else {
            inventory.remove(itemToTransfer);
            currentRoom.getItemsInRoom().add(itemToTransfer);
            return ("You have dropped " + itemToTransfer.getItemName() + " in " + currentRoom.getRoomName() + "\n");
        }
    }

    public String[] getCurrentRoomDoors() {
        String doorNorth = null;
        String doorSouth = null;
        String doorEast = null;
        String doorWest = null;

        if (currentRoom.getRoomNorth() != null) {
            doorNorth = ("There is a door North");
        }
        if (currentRoom.getRoomSouth() != null) {
            doorSouth = ("There is a door South");
        }
        if (currentRoom.getRoomEast() != null) {
            doorEast = ("There is a door East");
        }
        if (currentRoom.getRoomWest() != null) {
            doorWest = ("There is a door West");
        }
        return new String[]{doorNorth, doorSouth, doorEast, doorWest};
    }

  public String eatFood(String name){
        Item foodToEat = searchForItem(name, inventory);
        if(foodToEat == null){
            return "You don't have this item\n";
        }
        else if (foodToEat instanceof Food) {
          inventory.remove(foodToEat);
          playerHealth += ((Food) foodToEat).getConsumeableHealth();
          return "You have eaten " + foodToEat.getItemName() + "\n";
          } else {
              return "You cannot eat this\n";
          }
  }

  public String drinkLiquid(String name){
      Item liquidToDrink = searchForItem(name, inventory);
      if(liquidToDrink == null){
          return "You don't have this item\n";
      }
      else if (liquidToDrink instanceof Liquid) {
          inventory.remove(liquidToDrink);
          playerHealth += ((Liquid) liquidToDrink).getConsumeableHealth();
          return "You have drinked " + liquidToDrink.getItemName() + "\n";
      } else {
          return "You cannot drink this\n";
      }
  }

}
