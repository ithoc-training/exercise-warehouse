package de.ithoc.training.exercise.text;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextExerciseTest {

    @Test
    public void randomTextLength10() {
        TextExercise textExercise = new TextExercise();

        String text = textExercise.randomText(10);

        assertEquals(10, text.length());
        assertTrue("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(text.substring(0, 1)));
        assertTrue("1234567890".contains(text.substring(1, 2)));
        assertFalse(text.contains(" "));
    }

    @Test
    public void validTextSuccess() {
        TextExercise textExercise = new TextExercise();
        String text = "123456789a";

        boolean b = textExercise.validText(text, text.length());

        assertTrue(b);
    }

    @Test
    public void validTextFailureNumbersOnly() {
        TextExercise textExercise = new TextExercise();
        String text = "1234567890";

        boolean b = textExercise.validText(text, text.length());

        assertFalse(b);
    }

    @Test
    public void validTextFailureLettersOnly() {
        TextExercise textExercise = new TextExercise();
        String text = "abCdeFGhiJ";

        boolean b = textExercise.validText(text, text.length());

        assertFalse(b);
    }

    @Test
    public void validTextSuccessIncludingSpecialCharacters() {
        TextExercise textExercise = new TextExercise();
        String text = "12345!789a";

        boolean b = textExercise.validText(text, text.length());

        assertTrue(b);
    }

    @Test
    public void validTextFailureSpace() {
        TextExercise textExercise = new TextExercise();
        String text = "abC e123iJ";

        boolean b = textExercise.validText(text, text.length());

        assertFalse(b);
    }

    @Test
    public void validTextFailureLengthDiffer() {
        TextExercise textExercise = new TextExercise();
        String text = "abCe123J";

        boolean b = textExercise.validText(text, 10);

        assertFalse(b);
    }


}