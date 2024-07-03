package telran.interviews;

import java.util.*;

public class AutoCompletion {
	//Data Structure
	LinkedHashMap<String, TreeSet<String>> map = new LinkedHashMap<>();
	public boolean addWord(String word) {
		//adds new word into auto-completion variants
		//returns true if added, false otherwise (if a given word already exists)
		String key = word;
		String wordLowerCase = word.toLowerCase();
		TreeSet<String> wordSet = map.getOrDefault(key, new TreeSet<>());
		for (int i = 1; i <= wordLowerCase.length(); i++) {
			wordSet.add(wordLowerCase.substring(0, i));
		}
		return map.putIfAbsent(key, wordSet) == null;
	}
	public String[] getVariants(String prefix) {
		//returns all words beginning with a given prefix
		//Complexity of finding the variants is O[logN]
		LinkedList<String> result = new LinkedList<>();
	    String prefixLowerCase = prefix.toLowerCase();
	    for (Map.Entry<String, TreeSet<String>> entry : map.entrySet()) {
	        if (entry.getValue().contains(prefixLowerCase)) {
	            result.add(entry.getKey());
	        }
	    }
	    return result.toArray(new String[0]);
	}
}
