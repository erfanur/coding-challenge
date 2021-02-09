package processor;

import org.apache.log4j.Logger;

import java.util.HashMap;

public class WordProcessor {
    private static final Logger LOGGER = Logger.getLogger(WordProcessor.class);

    /**
     * Returns a map containing the longest words and their length for a given sentence
     *
     * @param sentence
     * @return map containing words and their length ie. {followed=8}
     */
    public static HashMap longestWord(String sentence) {
        HashMap<String, Integer> longestWordMap = new HashMap<>();
        String[] wordArray = sentence.split(" ");
        int maxlength = 0;

        //Iterate through the array and find the length of the longest word
        for (String word : wordArray) {
            if (word.length() > maxlength) {
                maxlength = word.length();
            }
        }

        //Put all words that matches maxlength into the map
        for (String word : wordArray) {
            if (word.length() == maxlength) {
                longestWordMap.put(word, word.length());
            }
        }
        LOGGER.info("Longest word/s: " + longestWordMap);
        return longestWordMap;
    }
}
