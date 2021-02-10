package processor;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        List<String> keys = new ArrayList<>(longestWordMap.keySet());
        for (int i = 0; i < keys.size(); i++) {
            if (keys.size() > 1) {
                int count = i + 1;
                LOGGER.info("Longest word number " + count + " is : " + keys.get(i) + ". And it's length is : " + longestWordMap.get(keys.get(i)));
            } else {
                LOGGER.info("Longest word is : " + keys.get(i) + ". And it's length is : " + longestWordMap.get(keys.get(i)));
            }
        }

        return longestWordMap;
    }
}
