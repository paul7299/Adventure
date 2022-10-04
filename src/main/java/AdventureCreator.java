public class AdventureCreator {

    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;

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

        room1.getItemsInRoom().add(new Item("lamp", "an incrediby boring lamp"));
        room1.getItemsInRoom().add(new Item("coins", "10 danish crowns"));
        room2.getItemsInRoom().add(new Item("terning", "a danish terning"));
        room3.getItemsInRoom().add(new Item("a tuborg", "a green bottle of stale beer"));
        room4.getItemsInRoom().add(new Item("an axe", "an old rusty axe"));
        room5.getItemsInRoom().add(new Item("lamp", "an incredibly boring lamp"));
        room6.getItemsInRoom().add(new Item("lamp", "an incredibly boring lamp"));
        room7.getItemsInRoom().add(new Item("lamp", "an incredibly boring lamp"));
        room8.getItemsInRoom().add(new Item("lamp", "an incredibly boring lamp"));
        room9.getItemsInRoom().add(new Item("lamp", "an incredibly boring lamp"));

        room1.getItemsInRoom().add(new Food("hotdog", "juicy hotdog", -10));
        room4.getItemsInRoom().add(new Food("apple", "Pink lady apple", 10));
    }

    //Denne metode bruges i AdventureController
    public Room getRoom1() {
        return room1;
    }
}
