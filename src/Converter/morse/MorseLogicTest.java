package Converter.morse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MorseLogicTest {

    //  Convert H to Morse.
    @Test
    void testConvertHToMorse() {
        MorseLogic logic = new MorseLogic();
        String text = "H";

        String actual = logic.textToMorse(text);
        String expected = "....";

        assertEquals(expected, actual);
    }

    //  Convert HELLO to Morse.
    @Test
    void testConvertHELLOToMorse() {
        MorseLogic logic = new MorseLogic();
        String text = "HELLO";

        String actual = logic.textToMorse(text);
        String expected = ".... . .-.. .-.. ---";

        assertEquals(expected, actual);
    }



    //  Convert Morse to H.
    @Test
    void testConvertMorseToE() {
        MorseLogic logic = new MorseLogic();
        String morse = "....";

        String actual = logic.morseToText(morse);
        String expected = "H";

        assertEquals(expected, actual);
    }

    //  Convert Morse to HELLO.
    @Test
    void testConvertMorseToHELLO() {
        MorseLogic logic = new MorseLogic();
        String morse = ".... . .-.. .-.. ---";

        String actual = logic.morseToText(morse);
        String expected = "HELLO";

        assertEquals(expected, actual);
    }



    //  Reject invalid characters.

    @Test
    void testConvertInvalidSymbol() {
        MorseLogic logic = new MorseLogic();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> logic.textToMorse("E!")
        );

        assertEquals("Invalid input", exception.getMessage());


    }

    //  Reject empty input.
    @Test
    void testNoInput() {
        MorseLogic logic = new MorseLogic();

        assertThrows(
                IllegalArgumentException.class,
                () -> logic.textToMorse("")
        );
    }

    //  Reject multiple spaces as input.
    @Test
    void testMultipleSpaces() {
        MorseLogic logic = new MorseLogic();

        assertThrows(
                IllegalArgumentException.class,
                () -> logic.textToMorse("       ")
        );
    }

    //  Convert lowercase letters to Morse.
    @Test
    void testConvertLowercaseToMorse() {
        MorseLogic logic = new MorseLogic();
        String text = "hello";

        String actual = logic.textToMorse(text);
        String expected = ".... . .-.. .-.. ---";

        assertEquals(expected, actual);
    }

    //  Convert a sentence with spaces to Morse.

    @Test
    void testConvertSentenceToMorse() {
        MorseLogic logic = new MorseLogic();
        String text = "HELLO WORLD";

        String actual = logic.textToMorse(text);
        String expected = ".... . .-.. .-.. --- .-- --- .-. .-.. -..";

        assertEquals(expected, actual);
    }

}