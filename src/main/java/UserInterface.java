import java.util.Scanner;

public class UserInterface {
   private Adventure adventure = new Adventure();
   private Scanner sc = new Scanner(System.in);

    public void startProgram() {
        String direction; //TODO lav en readString() til at tage sig af case følsomhed

        System.out.println("Welcome to the game. let's start");

        System.out.println("Choose a direction");
        direction = sc.nextLine();

        switch (direction) {
            case "North":
                System.out.println("Going north");
                break;
            case "South":
                System.out.println("Going south");
                break;
            case "East":
                System.out.println("Going east");
                break;
            case "West":
                System.out.println("going west");
                break;
            default:
                break;
        }
        }

    }


