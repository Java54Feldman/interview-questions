package telran.interviews;

import java.util.*;

public class AutoCompletion {
	//Data Structure
	private TreeSet<String> words = new TreeSet<>(String::compareToIgnoreCase);
	public boolean addWord(String word) {
		//adds new word into auto-completion variants
		//returns true if added, false otherwise (if a given word already exists)
		return words.add(word);
	}
	public String[] getVariants(String prefix) {
		//returns all words beginning with a given prefix
		//Complexity of finding the variants is O[logN]
		String nextPrefix = prefix.substring(0, prefix.length() - 1) + (char)(prefix.charAt(prefix.length() - 1) + 1);
		return words.subSet(prefix, nextPrefix).toArray(String[]::new);
	}
}
