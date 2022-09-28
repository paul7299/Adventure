//TODO Refactor til AdventureController
public class Adventure {

    //TODO currentRoom flyttes til player. Alle steder man kalder currentroom, skal man i stedet kalde player.getCurrentRoom.
    Room currentRoom;
    //TODO de 9 rum ti adventure creator
    Room room1;
    Room room2;
    Room room3;
    Room room4;
    Room room5;
    Room room6;
    Room room7;
    Room room8;
    Room room9;

    public Adventure() {
    }

    //TODO bruger en setter til east,north osv. med parameter nabo room
    //Starter mmed at bruge en setter eks. seteast til at forbinde det valte rum med et rum i paramteren
    // Tjekker at det valgte rum (this) ikke er forbundet til parameter rummet (eks. setEast), this er ikke west
    // hvis ikke, så brug set for omvendt retning
    // eks. room1.setEast(room2)
    // inde i set methoden: if room2.getwest != this
    //                              room2.setwest(this)
    //room2 bliver sat til east for room 1
    //room 1 bliver sat til west for room 2
    //i metoden refererer vi til room1 med this

    //TODO flyt createMap() til adventureCreator
    public void createMap() {
        room1 = new Room("Room 1", "The first room.");
        room2 = new Room("Room 2", "The second room.");
        room3 = new Room("Room 3", "The third room.");
        room4 = new Room("Room 4", "The fourth room.");
        room5 = new Room("Room 5", "The fifth room.");
        room6 = new Room("Room 6", "The sixth room.");
        room7 = new Room("Room 7", "The seventh room.");
        room8 = new Room("Room 8", "The eight room.");
        room9 = new Room("Room 9", "The ninth room.");

        room1.setRooms(null, room4, room2, null);
        room2.setRooms(null, null, room3, room1);
        room3.setRooms(null, room6, null, room2);
        room4.setRooms(room1, room7, null, null);
        room5.setRooms(null, room8, null, null);
        room6.setRooms(room3, room9, null, null);
        room7.setRooms(room4, null, room8, null);
        room8.setRooms(room5, null, room9, room7);
        room9.setRooms(room6, null, null, room8);

        this.currentRoom = room1;
    }

    //TODO flyt goEast(),goNorth(), goSouth(), goWest() og look() til player
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
    public String getCurrentRoomName() {
        return currentRoom.getRoomName();
    }

    //Opdaterer status for om man har besøgt et rum. True = Har besøgt et rum

    //Skal bruges senere til døre
    //TODO skal kalde på players current room
    public void getCurrentRoomDoors() {
        if (currentRoom.getRoomNorth() != null) {
            System.out.println("There is a door north");
        }
        if (currentRoom.getRoomSouth() != null) {
            System.out.println("There is a door south");
        }
        if (currentRoom.getRoomEast() != null) {
            System.out.println("There is a door east");
        }
        if (currentRoom.getRoomWest() != null) {
            System.out.println("There is a door west");
        }
    }

    //TODO skal kalde på players current room
    public void setHasVisitedStatusToTrue() {
        currentRoom.setHasVisitedToTrue();
    }

    //bruges til at tjekke om man har besøgt et rum før
    //TODO skal kalde på players currentRoom
    public Boolean hasVisitedStatus() {
        return currentRoom.getHasVisited();
    }

}

