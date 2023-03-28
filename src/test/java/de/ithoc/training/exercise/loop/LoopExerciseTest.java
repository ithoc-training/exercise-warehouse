package de.ithoc.training.exercise.loop;

import de.ithoc.training.exercise.text.TextExercise;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoopExerciseTest {

    @Test
    public void generateTextList() {
        LoopExercise loopExercise = new LoopExercise();

        List<String> strings = loopExercise.generateTextList();

        assertEquals(1000, strings.size());
    }

    @Test
    public void printTextList() {
        LoopExercise loopExercise = new LoopExercise();
        List<String> strings = loopExercise.generateTextList();

        String textList = loopExercise.printTextList(strings);
        System.out.println(textList);

        assertNotNull(textList);
        assertFalse(textList.isEmpty());
    }

}