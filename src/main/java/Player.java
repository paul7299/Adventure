import java.util.ArrayList;

public class Player {
    Room currentRoom;

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


    public void goEast() {
        if (currentRoom.getRoomEast() == null) {
            System.out.println("You cannot go east from here");
        } else {
            currentRoom = currentRoom.getRoomEast();
        }
    }
    public void goNorth() {
        if (currentRoom.getRoomNorth() == null) {
            System.out.println("You cannot go north from here");
        } else {
            currentRoom = currentRoom.getRoomNorth();
        }
    }
    public void goSouth() {
        if (currentRoom.getRoomSouth() == null) {
            System.out.println("You cannot go south from here");
        } else {
            currentRoom = currentRoom.getRoomSouth();
        }
    }
    public void goWest() {
        if (currentRoom.getRoomWest() == null) {
            System.out.println("You cannot go west from here");
        } else {
            currentRoom = currentRoom.getRoomWest();
        }
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

    public Room getCurrentRoom(){
        return currentRoom;
    }

}