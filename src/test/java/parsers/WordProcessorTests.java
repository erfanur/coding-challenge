package parsers;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import processor.WordProcessor;

import java.util.HashMap;

public class WordProcessorTests {
    private static final Logger LOGGER = Logger.getLogger(WordProcessorTests.class);
    HashMap<String, Integer> processedWords = new HashMap<>();

    @BeforeTest
    public void clearMap() {
        processedWords.clear();
    }

    /**
     * Validates that the longest word in the given sentence is returned.
     */
    @Test(priority = 0)
    public void findTheLongestWord() {
        String sentence = "“The cow jumped over the moon.";
        LOGGER.info("Sentence: " + sentence);
        processedWords = WordProcessor.longestWord(sentence);
        Assert.assertEquals(processedWords.size(), 1);
    }

    /**
     * Validates whether three long words of equal length are returned.
     */
    @Test(priority = 1)
    public void findTheLongestWords() {
        String sentence = "The cat went to the academy in order to acquire the ability to jump over the moon.";
        LOGGER.info("Sentence: " + sentence);
        processedWords = WordProcessor.longestWord(sentence);
        Assert.assertEquals(processedWords.size(), 3);
    }

    /**
     * Validates that repeated words are counted only once.
     */
    @Test(priority = 2)
    public void findTheLongestMatchingWords() {
        String sentence = "The dog followed the cat who followed the cow to the moon.";
        LOGGER.info("Sentence: " + sentence);
        processedWords = WordProcessor.longestWord(sentence);
        Assert.assertEquals(processedWords.size(), 1);
    }
}
