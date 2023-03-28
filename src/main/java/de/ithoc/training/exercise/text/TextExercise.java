package de.ithoc.training.exercise.text;

import java.util.Random;

public class TextExercise {

    /**
     * Erzeuge einen Text mit folgenden Kriterien:
     * - Länge exakt 10 Zeichen
     * - Mindestens einen Buchstaben (groß oder klein)
     * - Mindestens eine Zahl (von 0 bis 9)
     * - Keine Leerzeichen
     */
    public String randomText(int textLength) {

        if(textLength <= 0) {
            return "";
        }

        if(textLength == 1) {
            return "a";
        }

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "123456789";

        String text  = "" + letters.charAt(new Random().nextInt(letters.length()));

        for(int i = 1; i < textLength; i++) {
            text = text + numbers.charAt(new Random().nextInt(numbers.length()));
        }

        return text;
    }


    /**
     * Prüfe einen Text auf folgende Kriterien:
     * - Länge exakt der vorgegebenen Länge
     * - Mindestens einen Buchstaben (groß oder klein)
     * - Mindestens eine Zahl (von 0 bis 9)
     * - Keine Leerzeichen
     */
    public boolean validText(String text, int textLength) {

        // check on length
        if(text == null || text.length() != textLength) {
            return false;
        }

        // check on space
        if(text.contains(" ")) {
            return false;
        }

        char[] chars = text.toCharArray();

        // check on letter
        boolean letter = false;
        for(char c : chars) {
            if(Character.isLetter(c)) {
                letter = true;
                break;
            }
        }
        if(!letter) {
            return false;
        }

        // check on number
        boolean number = false;
        for(char c : chars) {
            if(Character.isDigit(c)) {
                number = true;
                break;
            }
        }
        if(!number) {
            return false;
        }

        return true;
    }

}
