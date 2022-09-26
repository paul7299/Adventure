public class Room {

    private String roomName;
    private String roomDescription;
    private Room roomNorth;
    private Room roomSouth;
    private Room roomEast;
    private Room roomWest;

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    public Room getRoomEast() {
        return roomEast;
    }

    public void setRooms(Room roomNorth, Room roomSouth, Room roomEast, Room roomWest) {
        roomNorth = roomNorth;
        roomSouth = roomSouth;
        roomEast = roomEast;
        roomWest = roomWest;
    }

}
