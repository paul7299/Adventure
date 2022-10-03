import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    public ArrayList<Item> showInventory(){
        return inventory;
    }

    // Constructor
    public Player(Room startRoom) {
        currentRoom = startRoom;
    }
    //Loadbearing Constructor
        public Player(){}


    public String goNorth() {
        String goingNorthResult;
        if (currentRoom.getRoomNorth() == null) {
            goingNorthResult = "* You cannot go north from here *";
        } else {
            goingNorthResult = "* Going north *";
            currentRoom = currentRoom.getRoomNorth();
        } return goingNorthResult;
    }

    public String goSouth() {
        String goingSouthResult;
        if (currentRoom.getRoomSouth() == null) {
            goingSouthResult = "* You cannot go south from here *";
        } else {
            goingSouthResult = "* Going south *";
            currentRoom = currentRoom.getRoomSouth();
        } return goingSouthResult;
    }

    public String goEast() {
        String goingEastResult;
        if (currentRoom.getRoomEast() == null) {
            goingEastResult = "* You cannot go east from here *";
        } else {
            goingEastResult = "* Going east *";
            currentRoom = currentRoom.getRoomEast();
        } return goingEastResult;
    }

    public String goWest() {
        String goingWestResult;
        if (currentRoom.getRoomWest() == null) {
            goingWestResult = "* You cannot go west from here *";
        } else {
            goingWestResult = "* Going west *";
            currentRoom = currentRoom.getRoomWest();
        } return goingWestResult;
    }

    public String look() {
        if(currentRoom.getItemsInRoom().isEmpty())
            return currentRoom.getRoomDescription() + "\n" + "there are no items in the room";
        else
            return currentRoom.getRoomDescription() + "\n" + "In the room you can see the following: " + currentRoom.getItemsInRoom();

    }

    public String getCurrentRoomNameFromPlayer() {
        return currentRoom.getRoomName();
    }

    public void setHasVisitedToTrue(){
        currentRoom.setHasVisitedToTrue();
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public boolean getHasVisitedStatus(){
        return currentRoom.getHasVisited();
    }

    public Item searchForItem(String searchName) {
        for (Item n : inventory) {
            if (n.getItemName().contains(searchName)) {
                return n;
            }
        }
        return null;
    }

// TODO Asger
    public String pickUpItem(String name) {
        Item itemToTransfer = searchForItem(name);
        String e;
        if (itemToTransfer == null) {
            e = "No item found";
        } else {
            inventory.add(itemToTransfer);
            currentRoom.getItemsInRoom().remove(itemToTransfer);
            e = ("You have picked up " + itemToTransfer.getItemName());
        }
        return e;
    }
    // TODO Asger
    public String dropItem(String name) {
        Item itemToTransfer = searchForItem(name);
        if (itemToTransfer == null) {
            return "No item found";
        } else {
            inventory.remove(itemToTransfer);
            currentRoom.getItemsInRoom().add(itemToTransfer);
            return ("You have dropped " + itemToTransfer.getItemName() + " in " + currentRoom.getRoomName());
        }
    }



}