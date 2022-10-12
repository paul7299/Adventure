import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {
    private AdventureController adventureController;
    private Scanner sc = new Scanner(System.in);

    public void startProgram() {
        adventureController = new AdventureController();

        System.out.println("""
                
                Welcome to the game! Let's begin
                You navigate through the game using the commands north, east, south and west.
                type help to see all the comands.
                
                You are watching a football game with your friends. 
                the break is about to come and it is your turn to get beers for the group, but there is a problem.
                there is a shortage of beer at the away stand where you are seated, 
                therfore you must go to the home stand and get the beers.
                
                you heard from a guy behind you that the best beers are served at section 9.
                but remember this is a derby game and the hate is real between the fans, navigate carefully.
                come on go! the break just stared.
                """);

        String userInput = " ";

        while (!userInput.equalsIgnoreCase("exit")) {
            if (adventureController.isPlayerDead()) {
                gameOver();
            }
            if(adventureController.hasWon()){
                hasWon();
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

                room9Message();
                room5Message();

                System.out.println("Choose an action");
                userInput = readString();
                command(userInput);
            }
        }
    }

    //command står for håndteringen af brugerens input, og indeholder de forskellige valgmuligheder brugeren har i spillet
    //Den sikrer at brugerens input minimum er 3 tegn langt, og returnerer fejl, hvis brugerens input ikke er forstået.
    private void command(String userInput) {

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
                    if (!secondInput.equals("")) {
                        System.out.println(adventureController.pickUpItem(secondInput));
                    } else {
                        System.out.println("*You have to type in what you want to take after the take-command*");
                    }
                    break;
                case "drop":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                        if (!secondInput.equals("")) {
                            System.out.println(adventureController.dropItem(secondInput));
                        } else {
                            System.out.println("*You have to type in what you want to drop after the drop-command*");
                        }
                    }
                    break;
                case "inventory":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                        System.out.println("Your inventory contains: " + adventureController.showInventory());
                    }
                    break;
                case "eat":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                        if (!secondInput.equals("")) {
                            System.out.println(adventureController.eatFood(secondInput));
                        } else {
                            System.out.println("*You have to type in what you want to eat after the eat-command*");
                        }
                        System.out.println("\n" + adventureController.showHealth());
                    }
                    break;
                case "drink":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                        if (!secondInput.equals("")) {
                            System.out.println(adventureController.drinkLiquid(secondInput));
                        } else {
                            System.out.println("*You have to type in what you want to drink after the drink-command*");
                        }
                        System.out.println("\n" + adventureController.showHealth());
                    }
                    break;
                case "equip":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                        if (!secondInput.equals("")) {
                            System.out.println(adventureController.equipWeapon(secondInput));
                        } else {
                            System.out.println("*You have to type in what you want to equip after the equip-command*");
                        }
                    }
                    break;
                case "attack":
                    if(secondInput.equals("")){
                    System.out.println(adventureController.attack());
                    }else{
                        System.out.println(adventureController.attack(secondInput));
                    }
                    break;
                case "ammo":
                    System.out.println(adventureController.showCurrentAmmo());
                    break;
                case "health":
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

    //readString omdanner inputtet til lowercase så der ikke kommer fejl hvis man skrev med stort.
    public String readString() {
        String stringToLowercase = sc.nextLine();
        return stringToLowercase.toLowerCase();
    }

    private void gameOver() {
        System.out.println(
                """
                        You have died
                        Choose what to do
                        1. Play again
                        2. exit game
                        """);
        int i = 0;

        while (i != 1 && i !=2){
            i = sc.nextInt();
            switch (i) {
                case 1:
                    startProgram();
                    break;
                case 2:
                    System.out.println("Thank you for playing");
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid input");
            }
    }
    }

    private void room9Message(){
        if(adventureController.hasVisitedRoom9()){
            System.out.println("""
                    You got to section 9 where the bar is.
                    The home fans are heckling and threatening you.
                    The bartender tells you that he is out of Tuborg!
                    But! There's a hidden away bar in section 5! They should have extra Tuborg!!
                    Meanwhile, a masked fan is shouting your way with a baton!
                    """);
        }
    }

    private void room5Message(){
        if(adventureController.hasVisitedRoom5()){
            System.out.println("""
                    You got to section 5 where the hidden bar is.
                    You can smell the Tuborg! But there's a problem!
                    The last Tuborg was taken by a drunk fan in front of you!
                    He has a glass bottle in one hand and the Tuborg in the other.
                    Show him that you deserve the last Tuborg!
                    """);
        }
    }

    private void hasWon(){
        System.out.println(
                """
                You got the tuborg and got to your seat before the 2nd half started!
                You sit back and ready to enjoy the game with a fresh tuborg!
                Unfortunately, the game ends in a boring 0-0...
                
                Choose what to do:
                1. Play again
                2. exit game
                """);
        int i = 0;

        while (i != 1 && i !=2){
            i = sc.nextInt();
            switch (i) {
                case 1:
                    startProgram();
                    break;
                case 2:
                    System.out.println("Thank you for playing");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public String printHelp() {
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
                 - Show ammo        ammo
                 - Drink liquid     drink 
                 - Player health    health 
                 - Exit:            exit
                """;
    }
}


