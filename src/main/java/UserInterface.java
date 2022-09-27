import java.util.Scanner;

public class UserInterface {
   private Adventure adventure = new Adventure();
   private Scanner sc = new Scanner(System.in);

    //TODO lav en readString() til at tage sig af case følsomhed

    public void startProgram() {
        adventure.createMap();

        System.out.println("Welcome to the game. let's start");


        String userInput = "x";

        while (!userInput.equalsIgnoreCase("exit")) {
            System.out.println("Choose an action");
            userInput = readString();

            command(userInput);
        }
    }

    private void command(String userInput){

        switch (userInput) {
            case "north", "n":
                System.out.println("Going north");
                adventure.goNorth();
                break;
            case "south", "s":
                System.out.println("Going south");
                adventure.goSouth();
                break;
            case "east", "e":
                System.out.println("Going east");
                adventure.goEast();
                break;
            case "west", "w":
                System.out.println("going west");
                adventure.goWest();
                break;
            case "look", "l":
                System.out.println("You are observing the room:");
                System.out.println(adventure.look());
                break;
            case "help":
                System.out.println("Commands available: ");
                break;
            case "exit":
                System.out.println("*Exiting game*");
                System.exit(0);
                break;
            default:
                System.out.println("*Wrong input*");
                break;
            }

    }
//TODO ændre case til lowercase
    //Omdanner inputtet til lowercase så der ikke kommer fejl hvis man skrev med stort.
    public String readString(){
        String stringToLowercase = sc.nextLine();
        return stringToLowercase.toLowerCase();
    }
}


// Her er en lille push/pull

