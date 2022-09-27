public class Adventure {

    Room currentRoom;
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
        room1 = new Room("Room 1", "The first room.", 0, 1, 2, 0);
        room2 = new Room("Room 2", "The second room.", 0, 0, 1, 2);
        room3 = new Room("Room 3", "The third room.", 0, 1, 0, 1);
        room4 = new Room("Room 4", "The fourth room.", 1, 1, 0, 0);
        room5 = new Room("Room 5", "The fifth room.", 0, 1, 0, 0);
        room6 = new Room("Room 6", "The sixth room.", 1, 1, 0, 0);
        room7 = new Room("Room 7", "The seventh room.", 1, 0, 1, 0);
        room8 = new Room("Room 8", "The eight room.", 1, 0, 1, 1);
        room9 = new Room("Room 9", "The ninth room.", 1, 0, 0, 1);

        room1.setRooms(null,room4,room2,null);
        room2.setRooms(null,null,room3,room1);
        room3.setRooms(null,room6,null,room2);
        room4.setRooms(room1,room7,null,null);
        room5.setRooms(null,room8,null,null);
        room6.setRooms(room3,room9,null,null);
        room7.setRooms(room4,null,room8,null);
        room8.setRooms(room5,null,room9,room7);
        room9.setRooms(room6,null,null,room8);

        this.currentRoom = room1;
    }

 public void goEast(){
        if(currentRoom.getRoomEast() == null){
            System.out.println("You cannot go east from here");
        }
        else {
            if (currentRoom.getDoorEast() == 1) {
                currentRoom = currentRoom.getRoomEast();

            } else if (currentRoom.getDoorEast() == 2) {
                System.out.println("This door is locked. Maybe you can find a key somewhere.");
            }
        }
    }

    public void goNorth(){
        if(currentRoom.getRoomNorth() == null){
            System.out.println("You cannot go north from here");
        }
        else {
            currentRoom = currentRoom.getRoomNorth();
        }
    }

    public void goSouth(){
        if(currentRoom.getRoomSouth() == null){
            System.out.println("You cannot go south from here");
        }
        else {
            if (currentRoom.getDoorSouth() == 1) {
                currentRoom = currentRoom.getRoomSouth();

            } else if (currentRoom.getDoorSouth() == 2) {
                System.out.println("This door is locked. Maybe you can find a key somewhere.");
            }

        }
    }

    public void goWest(){
        if(currentRoom.getRoomWest() == null){
            System.out.println("You cannot go west from here");
        }
        else{
            currentRoom = currentRoom.getRoomWest();
        }
    }

 public String look(){
        return currentRoom.getRoomDescription();
 }


    public String getCurrentRoomName() {
        return currentRoom.getRoomName();
    }
}
