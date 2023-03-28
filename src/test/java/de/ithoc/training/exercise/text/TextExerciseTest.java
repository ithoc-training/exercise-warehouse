package de.ithoc.training.exercise.text;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextExerciseTest {

    @Test
    public void randomTextLength10() {
        TextExercise textExercise = new TextExercise();

        String text = textExercise.randomText(10);

        assertEquals(10, text.length());
    }

}