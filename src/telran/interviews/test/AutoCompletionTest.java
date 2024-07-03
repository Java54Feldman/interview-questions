package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

import telran.interviews.AutoCompletion;

class AutoCompletionTest {
	String[] words = { "ab", "ABC", "avfdr", "aV", "aVV", "aaA" };
	String[] wordsAb = { "ab", "ABC" };
	String[] wordsAv = { "aV", "aVV", "avfdr" };
//	String[] wordsAv = { "avfdr", "aV", "aVV" };
	String[] wordsAa = { "aaA" };

	@Test
	void test() {
		AutoCompletion autoCompletion = new AutoCompletion();
		for (String word : words) {
			autoCompletion.addWord(word);
		}
		Arrays.sort(wordsAb);
		Arrays.sort(wordsAv);
		Arrays.sort(wordsAa);
		String[] actualAb = autoCompletion.getVariants("ab");
		String[] actualAv = autoCompletion.getVariants("av");
		String[] actualAa = autoCompletion.getVariants("aa");
		Arrays.sort(actualAb);
		Arrays.sort(actualAv);
		Arrays.sort(actualAa);
		
		assertArrayEquals(wordsAb, actualAb);
		assertArrayEquals(wordsAv, actualAv);
		assertArrayEquals(wordsAa, actualAa);
		
	}

}
