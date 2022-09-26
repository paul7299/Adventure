public class Adventure {

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

    public void createMap(){
        room1 = new Room("Room 1", "The first room.");
        room2 = new Room("Room 2", "The second room.");
        room3 = new Room("Room 3", "The second room.");
        room4 = new Room("Room 4", "The second room.");
        room5 = new Room("Room 5", "The second room.");
        room6 = new Room("Room 6", "The second room.");
        room7 = new Room("Room 7", "The second room.");
        room8 = new Room("Room 8", "The second room.");
        room9 = new Room("Room 9", "The second room.");

        room1.setRooms(null,room4,null,room2);

    }

}
