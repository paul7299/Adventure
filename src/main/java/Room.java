public class Room {

    private String roomName;
    private String roomDescription;
    private Room roomNorth;
    private Room roomSouth;
    private Room roomEast;
    private Room roomWest;
    private int doorNorth;
    private int doorSouth;
    private int doorEast;
    private int doorWest;

    // doors: 1 = åben, 2 = låst, 0 = ingen dør

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    public Room(String roomName, String roomDescription, int doorNorth, int doorSouth, int doorEast, int doorWest) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.doorNorth = doorNorth;
        this.doorSouth = doorSouth;
        this.doorEast = doorEast;
        this.doorWest = doorWest;
    }

    public int getDoorNorth() {
        return doorNorth;
    }

    public int getDoorSouth() {
        return doorSouth;
    }

    public int getDoorEast() {
        return doorEast;
    }

    public int getDoorWest() {
        return doorWest;
    }

    public Room getRoomEast() {
        return roomEast;
    }
    public Room getRoomSouth(){
        return roomSouth;
    }
    public Room getRoomNorth(){
        return roomNorth;
    }
    public Room getRoomWest(){
        return roomWest;
    }

    public String getRoomName() {
        return roomName;
    }
    public String getRoomDescription(){
        return roomDescription;
    }

    // set-metode for room directions (ikke constructor) fordi vi setter dem til eksisterende rooms
    public void setRooms(Room roomNorth, Room roomSouth, Room roomEast, Room roomWest) {
        this.roomNorth = roomNorth;
        this.roomSouth = roomSouth;
        this.roomEast = roomEast;
        this.roomWest = roomWest;
    }

}
