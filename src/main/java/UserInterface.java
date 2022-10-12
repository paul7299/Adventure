import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {
    /**
     * Vores UserInterface står for at håndtere alt kommunikation mellem programmet og brugeren
     */
    private AdventureController adventureController;
    private final Scanner sc = new Scanner(System.in);

    public void startProgram() {
        /**
         * @startProgram() står for at udskrive reglerne for spillet og videresende brugerens input til vores @command metode.
         * Derudover udskriver den også information om det rum man går ind i.
         */
        adventureController = new AdventureController();

        System.out.println("""
                Welcome to the game! Let's begin
                You are stuck in a maze. The objective of the game is to reach room 5.
                You navigate through the game using the commands Go north, Go east, Go south and Go west.
                To view your current room, type "look".
                If you want to pick up an item; type "take" and specify which item you want to take.
                If you want to drop an item; type "drop" and specify which item you want to drop.
                If you want to view your inventory, type "inventory".
                If you want to drink or eat an consumable, type either "drink" or "eat" and specify which consumable afterwards.
                If you want to equip a weapon from your inventory, type "equip weapon"
                If you want to attack with your equipped weapon, type "attack"
                If you want to view your current amount of ammo, type "show ammo"
                If you want to view your health, type "show health".
                If you want to quit the game, type "exit". 
                If you forget the commands, type "help".
                """);

        String userInput = " ";

        while (!userInput.equalsIgnoreCase("exit")) {
            if (adventureController.isPlayerDead()) {
                gameOver();
            }
            System.out.println("\nYou are in " + adventureController.getPlayerCurrentRoomName());
            if (!adventureController.hasVisitedStatus()) {
                System.out.println(adventureController.playerLook());
                adventureController.setHasVisitedStatusToTrue();
            }
            if (adventureController.hasVisitedStatus()) {
                for (String s : adventureController.getCurrentRoomDoors()) {
                    if (s != null) System.out.println(s);
                }

                System.out.println("Choose an action");
                userInput = readString();
                command(userInput);
            }
        }
    }

    private void command(String userInput) {
        /**
         * @command står for håndteringen af brugerens input, og indeholder de forskellige valgmuligheder brugeren har i spillet
         * Den sikrer at brugerens input minimum er 3 tegn langt, og returnerer fejl, hvis brugerens input ikke er forstået.
         */
        if (userInput.length() >= 3) {
            String[] listOfWord = userInput.split(" ");

            String firstInput = listOfWord[0];

            String secondInput = "";
            // Checks if the array is bigger than 1
            if (listOfWord.length > 1) {
                secondInput = listOfWord[1];
            }

            switch (firstInput) {
                case "north":
                    System.out.println(adventureController.playerGoNorth());
                    break;
                case "south":
                    System.out.println(adventureController.playerGoSouth());
                    break;
                case "east":
                    System.out.println(adventureController.playerGoEast());
                    break;
                case "west":
                    System.out.println(adventureController.playerGoWest());
                    break;
                case "look":
                    System.out.println("You are observing the room: ");
                    System.out.println(adventureController.playerLook());
                    adventureController.getCurrentRoomDoors();
                    break;
                case "help":
                    System.out.println(printHelp());
                    break;
                case "exit":
                    System.out.println("*Exiting game*");
                    System.exit(0);
                    break;
                case "take":
                   /* System.out.println("Which item do you want to pick up?");
                    String takeName = sc.nextLine();
                    System.out.println(adventureController.pickUpItem(takeName.toLowerCase()));*/
                    System.out.println(adventureController.pickUpItem(secondInput));
                    break;
                case "drop":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                       /* System.out.println("Which item do you want to drop?");
                        String dropName = readString();
                        System.out.println(adventureController.dropItem(dropName));*/
                        System.out.println(adventureController.dropItem(secondInput));
                    }
                    break;
                case "inventory":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                        System.out.println("Your inventory contains: " + adventureController.showInventory());
                    }
                    break;
                case "eat food", "eat":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                      /*  System.out.println("What do you want to eat?");
                        String eatName = readString();
                        System.out.println(adventureController.eatFood(eatName));*/
                        System.out.println(adventureController.eatFood(secondInput));
                        System.out.println("\n" + adventureController.showHealth());
                    }
                    break;
                case "drink liquid", "drink":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                       /* System.out.println("What do you want to drink?");
                        String drinkName = sc.nextLine();
                        System.out.println(adventureController.drinkLiquid(drinkName));*/
                        System.out.println(adventureController.drinkLiquid(secondInput));
                        System.out.println("\n" + adventureController.showHealth());
                    }
                    break;
                case "equip weapon", "equip":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                 /*       System.out.println("Which weapon you want to equip?");
                        String equipName = sc.nextLine();
                        System.out.println(adventureController.equipWeapon(equipName));*/
                        System.out.println(adventureController.equipWeapon(secondInput));

                    }
                    break;
                case "attack":
                    if(secondInput.isEmpty()){
                    System.out.println(adventureController.attack());
                    }else{
                        System.out.println(adventureController.attack(secondInput));
                    }
                    break;
                case "show ammo", "ammo":
                    System.out.println(adventureController.showCurrentAmmo());
                    break;
                case "show health", "health":
                    System.out.println(adventureController.showHealth());
                    break;
                default:
                    System.out.println("* Wrong input *");
                    break;
            }

        } else {
            System.out.println("input needs to be at least 3 chars");
        }
    }


    public String readString() {
        /**
         *@readString omdanner inputtet til lowercase så der ikke kommer fejl hvis man skrev med stort.
         */
        String stringToLowercase = sc.nextLine();
        return stringToLowercase.toLowerCase();
    }

    public void gameOver() {
        /**
         * @gameOver udskriver når spillet er slut, og spilleren får mulighed for at prøve igen eller exit game.
         */
        System.out.println(
                            """
                            You have died
                            Choose what to do
                            1. Play again
                            2. exit game
                            """);
        int i = sc.nextInt();
        switch (i) {
            case 1:
                startProgram();
                break;
            case 2:
                System.out.println("Thank you for playing");
                System.exit(0);
                break;
        }
    }

    public String printHelp() {
        /**
         * @printHelp returnerer alle kommandoer spilleren har mulighed for at at benytte
         */
        return """
                 * Help - list of commands: *
                 - Go north:        north 
                 - Go south:        south 
                 - Go east:         east 
                 - Go west:         west 
                 - Look around:     look 
                 - Take item        take 
                 - Drop item        drop 
                 - view inventory   inventory 
                 - Eat food         Eat food / eat 
                 - equip weapon     equip weapon/ equip
                 - attack           attack
                 - Show ammo        Show ammo/ ammo
                 - Drink liquid     Drink liquid / drink 
                 - Player health    Show health / health 
                 - Exit:            exit
                """;
    }
}


