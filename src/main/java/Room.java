import java.util.ArrayList;

public class Room {
    
    private final String roomName;
    private final String roomDescription;
    private final ArrayList<Item> itemsInRoom;
    private final ArrayList<Enemy> enemiesInRoom;
    private Room roomNorth;
    private Room roomSouth;
    private Room roomEast;
    private Room roomWest;
    private Boolean hasVisited; //Denne bolean vil sige noget om man har besøget et rum før
    
    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        hasVisited = false; //hasVisited sættes false ved default fordi man ikke har besøgt et rum til at starte med
        itemsInRoom = new ArrayList<>();
        enemiesInRoom = new ArrayList<Enemy>();
    }
    
    //TODO reducér clutter
    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
    }
    
    public ArrayList<Enemy> getEnemiesInRoom() {
        return enemiesInRoom;
    }
    
    public Room getRoomEast() {
        return roomEast;
    }
    
    public Room getRoomSouth() {
        return roomSouth;
    }
    
    public Room getRoomNorth() {
        return roomNorth;
    }
    
    public Room getRoomWest() {
        return roomWest;
    }
    
    public String getRoomName() {
        return roomName;
    }
    
    public String getRoomDescription() {
        return roomDescription;
    }
    
    public Boolean getHasVisited() {
        return hasVisited;
    }
    
    public void setHasVisitedToTrue() {
        hasVisited = true;
    }
    
    public void setRooms(Room roomNorth, Room roomSouth, Room roomEast, Room roomWest) {
        this.roomNorth = roomNorth;
        this.roomSouth = roomSouth;
        this.roomEast = roomEast;
        this.roomWest = roomWest;
    }

}
