public class Player {
    //TODO skal have currentRoom og goEast/North/South/West()
    Room currentRoom;
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
    //udvides eventuelt til at sige hvilke døre der er og man har gået igennem
    public String look() {
        return currentRoom.getRoomDescription();
    }

    //TODO skift til getCurrentRoomNameFromPlayer(), skal kalde på player.getCurrentRoomName
    public String getCurrentRoomNameFromPlayer() {
        return currentRoom.getRoomName();
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }


}