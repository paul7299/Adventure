import java.util.Scanner;

public class UserInterface {
   private Adventure adventure = new Adventure();
   private Scanner sc = new Scanner(System.in);

    //TODO lav en readString() til at tage sig af case følsomhed

    public void startProgram() {
        System.out.println("Welcome to the game. let's start");
        command();
        }

        private void command(){
        String userInput;
        String action;
            System.out.println("Choose an action");
            userInput = sc.nextLine();

            //Todo lav en løkke rundt om switch hvis noget går galt
            switch (userInput) {
                case "north":
                    System.out.println("Going north");
                    break;
                case "south":
                    System.out.println("Going south");
                    break;
                case "east":
                    System.out.println("Going east");
                    break;
                case "west":
                    System.out.println("going west");
                    break;
                case "look":
                    System.out.println(adventure.look());
                default:
                    break;
            }
    }
//TODO ændre case til lowercase
    //Omdanner inputtet til lowercase så der ikke kommer fejl hvis man skrev med stort.
    public String readString(String input){
        return input.toLowerCase();
    }
}


