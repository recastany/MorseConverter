package Converter.morse;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        // Create a Scanner object to read user input from the keyboard.
        Scanner scanner = new Scanner(System.in);

        // Create an instance of the MorseLogic class
        MorseLogic logic = new MorseLogic();

        // Ask the user to enter Morse code.
        System.out.println("Enter Morse code:");


        try {
            String morse = scanner.nextLine();

            //Convert Morse code into English text
        String text = logic.morseToText(morse);
        System.out.println(text);

        } catch (IllegalArgumentException e) {

            //  Handle invalid Morse code or empty input.

            System.out.println("Error: " + e.getMessage());
        }

        //Ask the user to enter English text.
        System.out.println("Enter English text:");

        try {

        String text = scanner.nextLine();

        //Convert English text into Morse code.
        String morse = logic.textToMorse(text);

        System.out.print(morse);

    } catch (IllegalArgumentException e) {

        //  Handle invalid characters or empty input.
        System.out.println("Error: " + e.getMessage());
    }

    //  Close the Scanner.
    scanner.close();
}

}






