package telran.interviews;
import java.util.*;

public class InterviewQuestions {
	public static void displayOccurrences(String[] strings) {
		HashMap<String, Integer> mapOccurrences = getOccurrencesMap(strings);
		TreeMap<Integer, TreeSet<String>> treeMapOccurrences = getTreeMapOccurrences(mapOccurrences);
		displayOccurrences(treeMapOccurrences);
	}

	private static void displayOccurrences(TreeMap<Integer, TreeSet<String>> treeMapOccurrences) {
		treeMapOccurrences.entrySet().forEach(e -> {
			e.getValue().forEach(str -> System.out.printf("%s => %d\n", str, e.getKey()));
		});
		
	}

	private static TreeMap<Integer, TreeSet<String>> getTreeMapOccurrences(HashMap<String, Integer> mapOccurrences) {
		TreeMap<Integer, TreeSet<String>> result = new TreeMap<Integer, TreeSet<String>>(Comparator.reverseOrder());
		mapOccurrences.entrySet()
			.forEach(e -> result.computeIfAbsent(e.getValue(), k -> new TreeSet<>() ).add(e.getKey()));
		return result;
	}

	private static HashMap<String, Integer> getOccurrencesMap(String[] strings) {
		HashMap<String, Integer> result = new HashMap<>();
		for (String str : strings) {
			result.merge(str,  1,  Integer::sum);
		}
		return result;
	}
	static public boolean isSum2(int[] array, int sum) {
		//returns true if a given array contains two numbers, 
		//the summing of which equals a given 'sum' value
		//complexity O[N] only one pass over the elements
		boolean res = false;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < array.length && !res; i++) {
			if(set.contains(sum - array[i])) {
				res = true;
			} else {
				set.add(array[i]);
			}
		}
		return res;
		
	}
	static public int getMaxWithNegativePresentation(int[] array) {
		//returns maximal positive value for which exists negative one with the same abs value
		//if no pair of positive and negative values with the same abs value the method returns -1
		//complexity O[N] only one pass over the elements
		int res = -1;
		HashSet<Integer> set = new HashSet<>();
		for (Integer number : array) {
			if(number < 0) {
				set.add(number);
			} else {
				if(set.contains(-number)) {
					res = Math.max(res, number);
				}
			}
		}
		
		return res;
	}
}
