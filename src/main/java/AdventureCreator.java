// AdventureCreater står for at oprette alle rummene, og placere både Items og Enemies i de specifikke rum
// Den placerer også rummene i forhold til hinanden, så hvert rum selv ved hvor det befinder sig relativt til de andre.

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
        room1 = new Room("Section 1", "The away fan section where you are seated. No one will bother you here");
        room2 = new Room("Section 2", "Another away fan section. No one will bother you here");
        room3 = new Room("Section 3", "Another away fan section, reserved for families.");
        room4 = new Room("Section 4", "A home section, reserved for families.");
        room5 = new Room("Section 5", "A hidden away bar area, there should be Tuborg here!");
        room6 = new Room("Section 6", "A home fan section, lots of tourists sit here.");
        room7 = new Room("Section 7", "A home fan section, lots of music and flags here.");
        room8 = new Room("Section 8", "A home section, the hardcore fans sit here");
        room9 = new Room("Section 9", "A home section, hardcore fans sit here. There's a bar that might have Tuborg!");

        room1.setRooms(null, room4, room2, null);
        room2.setRooms(null, null, room3, room1);
        room3.setRooms(null, room6, null, room2);
        room4.setRooms(room1, room7, null, null);
        room5.setRooms(null, room8, null, null);
        room6.setRooms(room3, room9, null, null);
        room7.setRooms(room4, null, room8, null);
        room8.setRooms(room5, null, room9, room7);
        room9.setRooms(room6, null, null, room8);

        room1.getItemsInRoom().add(new Item("empty beer", "an empty beer"));
        room2.getItemsInRoom().add(new Item("coins", "10 danish crowns"));
        room3.getItemsInRoom().add(new Item("football scarf", "old scarf from the 90s"));
        room4.getItemsInRoom().add(new Item("dice", "danish dice"));

        room1.getItemsInRoom().add(new Food("hotdog", "A fat, juicy hotdog", -5));
        room1.getItemsInRoom().add(new Food("banana", "ripe banana", 15));
        room2.getItemsInRoom().add(new Food("sandwich", "healthy vegatables sandwich", 15));
        room2.getItemsInRoom().add(new Liquid("soda", "A can of soda", -10));
        room3.getItemsInRoom().add(new Food("apple", "A bag of apples for kids", 10));
        room3.getItemsInRoom().add(new Liquid("milk","A small carton of milk", 15));
        room4.getItemsInRoom().add(new Food("carrots", "A bag of carrots for kids", 10));
        room4.getItemsInRoom().add(new Liquid("juice","A small carton of juice", 15));


        room7.getItemsInRoom().add(new MeleeWeapon("drumstick", "A big drumstick used by the home fans", 10));
        room6.getItemsInRoom().add(new RangedWeapon("Firework", "A roman candle, the preferred weapon for violent fans worldwide!", 15, 4));

        // Opretter enemy og dens weapon
        MeleeWeapon shoe = new MeleeWeapon("Shoe", "A worn out Nike shoe", 10);
        createEnemy("blondie",shoe, room8);
        MeleeWeapon baton = new MeleeWeapon("baton", "A baton that's been stolen from security", 15);
        createEnemy("hooligan", baton,room9);
        MeleeWeapon bottle = new MeleeWeapon("bottle", "A glass bottle that's been smuggled in", 15);
        createEnemy("psycho", bottle, room5);
        room5.getEnemiesInRoom().get(0).setItem("tuborg", "A cold, fresh tuborg");
    }

    //Denne metode bruges i AdventureController til at sætte room1 til players currentRoom.
    public Room getRoom1() {
        return room1;
    }

    //Hjælpemetode til at oprette enemies og samtidig tilføje dem til rummets liste. Sparer en masse plads og tid.
    private void createEnemy(String enemyname, Weapon enemyWeapon, Room room){
        Enemy enemy = new Enemy(enemyname, enemyWeapon, room);
        room.getEnemiesInRoom().add(enemy);
    }


    public boolean getRoom5VisitedStatus() {
        return room5.getHasVisited();
    }

    public boolean getRoom9VisitedStatus() {
        return room9.getHasVisited();
    }
}
