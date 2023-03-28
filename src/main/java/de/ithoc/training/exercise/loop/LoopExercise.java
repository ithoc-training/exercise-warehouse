package de.ithoc.training.exercise.loop;

import de.ithoc.training.exercise.text.TextExercise;

import java.util.ArrayList;
import java.util.List;

public class LoopExercise {

    /**
     * Erzeuge eine Liste (List list = new ArrayList()) mit 1000 Elementen. Füge in einer for-Schleife
     * jeweils einen aus TextExercise zufällig generierten Text in die Liste, so dass am Ende eine Liste
     * mit Elementtypen String und voraussichtlich unterschiedlichen Texten besteht.
     * Stelle den einzelnen Elementen den Index aus der Schleife voran.
     */
    public List<String> generateTextList() {

        int n = 1000;
        List<String> list = new ArrayList<>(n);

        TextExercise textExercise = new TextExercise();
        for(int index = 0; index < n; index++) {
            list.add(index + ": " + textExercise.randomText(5));
        }

        return list;
    }


    /**
     * Erzeuge einen Text, der alle Elemente der gegebenen Liste enthält. Dabei steht jedes Element in
     * einer eigenen Zeile.
     */
    public String printTextList(List<String> list) {

        StringBuilder builder = new StringBuilder();
        for(String text : list) {
            builder.append(text).append(System.getProperty("line.separator"));
        }

        return builder.toString();
    }

}
