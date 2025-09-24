package com.santaclaus.utils;

/**
 * String formatting and restructuring
 */
public class StringUtils {

    /**
     * Method that appends spaces to a string up to 45 characters.
     * This is for representing data visually good in SystemOut
     */
    public static String formatString(String ... strings) {
        StringBuilder formattedString = new StringBuilder();

        for(String string : strings) {
            formattedString.append(string);
            for(int i = 0; i < 45 - string.length(); i++) {
                formattedString.append(" ");
            }
        }
        return formattedString.toString();
    }

    /**
     * Returns true if string contains >= 2 spaces at the end, false otherwise
     */
    public static boolean hasSpacesAtTheEnd(String string) {
        if(string.contains(" ") && string.lastIndexOf("  ") == string.length() - 2) {
            return true;
        }
        return false;
    }

    /**
     * Removes spaces at the end of the string and returns the string modified
     */
    public static String removeSpacesAtTheEnd(String string) {
        if(hasSpacesAtTheEnd(string)) {
            return string.replaceFirst("\\s{2,}", "");
        }
        return string;
    }
}
