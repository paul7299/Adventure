import java.util.ArrayList;

public class Room {

    private String roomName;
    private String roomDescription;
    private Room roomNorth;
    private Room roomSouth;
    private Room roomEast;
    private Room roomWest;
    private Boolean hasVisited; //Denne bolean vil sige noget om man har besøget et rum før
    private ArrayList<Item> itemsInRoom;

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.hasVisited = false; //hasVisited sættes false ved default fordi man ikke har besøgt et rum til at starte med
        itemsInRoom = new ArrayList<Item>();
    }

    public void addItemToRoom(String name){
        itemsInRoom.add(new Item(name));
    }

    public void deleteItemFromRoom(String name){
        int foundIndex = -1;
        for (int i = 0; i < itemsInRoom.size(); i++) {
            if (itemsInRoom.get(i).getItemName().contains(name)) {
                foundIndex = i;
            }
        }
        itemsInRoom.remove(foundIndex);
    }


    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
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


//TODO Paul ik akut, lav setRoom op på Tines metode
    //Starter mmed at bruge en setter eks. seteast til at forbinde det valte rum med et rum i paramteren
    // Tjekker at det valgte rum (this) ikke er forbundet til parameter rummet (eks. setEast), this er ikke west
    // hvis ikke, så brug set for omvendt retning
    // eks. room1.setEast(room2)
    // inde i set methoden: if room2.getwest != this
    //                              room2.setwest(this)
    //room2 bliver sat til east for room 1
    //room 1 bliver sat til west for room 2
    //i metoden refererer vi til room1 med this
}
