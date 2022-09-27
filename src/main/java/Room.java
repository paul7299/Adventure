public class Room {

    private String roomName;
    private String roomDescription;
    private Room roomNorth;
    private Room roomSouth;
    private Room roomEast;
    private Room roomWest;

    private Boolean hasVisited;

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.hasVisited = false;
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

    public Boolean getHasVisited(){
        return hasVisited;
    }
    public void setHasVisitedToTrue(){
        hasVisited = true;
    }

    public void setRooms(Room roomNorth, Room roomSouth, Room roomEast, Room roomWest) {
        this.roomNorth = roomNorth;
        this.roomSouth = roomSouth;
        this.roomEast = roomEast;
        this.roomWest = roomWest;
    }

}
