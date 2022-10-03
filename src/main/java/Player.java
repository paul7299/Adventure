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
        String goingNorth;
        if (currentRoom.getRoomNorth() == null) {
            goingNorth = "* You cannot go north from here *";
        } else {
            goingNorth = "* Going north *";
            currentRoom = currentRoom.getRoomNorth();
        } return goingNorth;
    }

    public String goSouth() {
        String goingSouth;
        if (currentRoom.getRoomSouth() == null) {
            goingSouth = "* You cannot go south from here *";
        } else {
            goingSouth = "* Going south *";
            currentRoom = currentRoom.getRoomSouth();
        } return goingSouth;
    }

    public String goEast() {
        String goingEast;
        if (currentRoom.getRoomEast() == null) {
            goingEast = "* You cannot go east from here *";
        } else {
            goingEast = "* Going east *";
            currentRoom = currentRoom.getRoomEast();
        } return goingEast;
    }

    public String goWest() {
        String goingWest;
        if (currentRoom.getRoomWest() == null) {
            goingWest = "* You cannot go west from here *";
            System.out.println("You cannot go west from here");
        } else {
            goingWest = "* Going west *";
            currentRoom = currentRoom.getRoomWest();
        } return goingWest;
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