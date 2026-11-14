package Converter.morse;

import java.util.HashMap;


public class MorseLogic {

    // Declare the HashMap used for both conversion directions
    private final HashMap<String, String> map;


    // Start the Morse alphabet and fill in the HashMap
    public MorseLogic() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] morseCodes = {
                ".-", "-...", "-.-.", "-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."
        };
        map = new HashMap<>();


        for (int i = 0; i < letters.length(); i++) {
            String letter = Character.toString(letters.charAt(i));
            String morseCode = morseCodes[i];


            // Store both conversion directions.
            map.put(letter, morseCode);
            map.put(morseCode, letter);
        }
    }


    // Convert Morse code into text
    public String morseToText(String morse) {

        // Error handling: Check for null or empty input.
        if( morse == null|| morse.isBlank()){
            throw new IllegalArgumentException("No input");

        }
        String myText = "";

        // Separate individual Morse codes.
        String[] texts = morse.trim().split("\\s+");


        for (int i = 0; i < texts.length; i++) {

            String letter = map.get(texts[i]);

            // Error handling : Reject unknown Morse codes.
            if (letter == null) {
                throw new IllegalArgumentException("Invalid Morse code");

            }

            myText += letter ;

        }

        return myText;

    }

    // Convert  text into Morse code.
    public String textToMorse(String text) {

        // Error handling : Check for null or empty input.
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("No input");

        }

        String myText = "";

        // Convert lowercase letters to uppercase.
        text = text.toUpperCase().trim();

        for (int i = 0; i < text.length(); i++) {
            String letter = Character.toString(text.charAt(i));

            // Ignore spaces between words.
            if (letter.isBlank()) {
                continue;
            }
            String morse = map.get(letter);

            // Error handling : Reject unsupported characters.
            if (morse == null) {
                throw new IllegalArgumentException("Invalid input");
            }
            myText += morse + " ";

        }

        return myText.trim();

    }
}
