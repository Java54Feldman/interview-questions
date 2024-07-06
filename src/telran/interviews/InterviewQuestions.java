package telran.interviews;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class InterviewQuestions {
	public static void displayOccurrences(String[] strings) {
		HashMap<String, Integer> mapOccurrences = getOccurrencesMap(strings);
		TreeMap<Integer, TreeSet<String>> treeMapOccurrences = getTreeMapOccurrences(mapOccurrences);
		displayOccurrences(treeMapOccurrences);
	}
	public static void displayOccurrencesStream(String[] strings) {
		Arrays.stream(strings)
		.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
		.entrySet().stream().sorted((e1, e2) -> {
			int res = Long.compare(e2.getValue(), e1.getValue());
			return res == 0 ? e1.getKey().compareTo(e2.getKey()) : res;
		}).forEachOrdered(e -> System.out.printf("%s => %d\n", e.getKey(), e.getValue()));
	}

	private static void displayOccurrences(TreeMap<Integer, TreeSet<String>> treeMapOccurrences) {
		treeMapOccurrences.entrySet().forEach(e -> {
			e.getValue().forEach(str -> System.out.printf("%s => %d\n", str, e.getKey()));
		});

	}

	private static TreeMap<Integer, TreeSet<String>> getTreeMapOccurrences(HashMap<String, Integer> mapOccurrences) {
		TreeMap<Integer, TreeSet<String>> result = new TreeMap<Integer, TreeSet<String>>(Comparator.reverseOrder());
		mapOccurrences.entrySet()
				.forEach(e -> result.computeIfAbsent(e.getValue(), k -> new TreeSet<>()).add(e.getKey()));
		return result;
	}

	private static HashMap<String, Integer> getOccurrencesMap(String[] strings) {
		HashMap<String, Integer> result = new HashMap<>();
		for (String str : strings) {
			result.merge(str, 1, Integer::sum);
		}
		return result;
	}

	static public boolean isSum2(int[] array, int sum) {
		// returns true if a given array contains two numbers, the summing of which
		// equals a given 'sum' value
		// complexity O[N] only one pass over the elements
		HashSet<Integer> helper = new HashSet<>();
		int index = 0;
		while (index < array.length && !helper.contains(sum - array[index])) {
			helper.add(array[index++]);
		}
		return index < array.length;
	}

	static public int getMaxWithNegativePresentation(int[] array) {
		// returns maximal positive value for which exists negative one with the same
		// abs value
		// if no pair of positive and negative values with the same abs value the method
		// returns -1
		// complexity O[N] only one pass over the elements
		int maxRes = -1;
		HashSet<Integer> helper = new HashSet<>();
		for (int num : array) {
			if (helper.contains(-num)) {
				maxRes = Math.max(maxRes, Math.abs(num));
			} else {
				helper.add(num);
			}
		}
		return maxRes;
	}
	public static Map<Integer, Integer> getMapSquares(List<Integer> numbers) {
//		Map<Integer, Integer> res = numbers.stream().distinct()
//				.collect(Collectors.toMap(n -> n, n -> n * n));
		Map<Integer, Integer> res = numbers.stream()
				.collect(Collectors.toMap(n -> n, n -> n * n, 
						(v1, v2) -> v1, LinkedHashMap::new));
		return res;
	}
	public static boolean isAnagram(String word, String anagram) {
		//O[N], 2 pass over
		//sorting is disallowed
		//returns true if anagram string contains all letters from word
		//in another order (case sensitive)
		boolean res = false;
		if(!word.equals(anagram) && (word.length() == anagram.length())) {
			Map<String, Long> lettersCounts = Arrays.stream(word.split(""))
					.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
			
			//V.R. solution start
			res = true;
			char[] anagramChars = anagram.toCharArray();
			int index = 0;
			while (index < anagramChars.length && res){
				if (lettersCounts.compute(String.valueOf(anagramChars[index++]), (k, v) -> v == null ? -1 : v - 1 ) < 0 ) {
					res = false;
				}			
			}
			//V.R. solution end
			
			//my solution
//			String[] anagramArr = anagram.split("");
//			int i = 0;
//			while (i < anagramArr.length 
//					&& lettersCounts.containsKey(anagramArr[i]) 
//					&& lettersCounts.get(anagramArr[i]) != 0) {
//				lettersCounts.put(anagramArr[i], lettersCounts.get(anagramArr[i]) - 1);
//				i++;
//			}
//
//			if (lettersCounts.values().stream().allMatch(v -> v == 0)) {
//				res = true;
//			}
		}
		return res;
	}
	public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory, List<LocalDate> dates) {
		//create List<DateRole> with roles matching with the given dates
		//most effective data structure
        List<DateRole> result = new LinkedList<>();
        TreeMap<LocalDate, String> roleMap = new TreeMap<>(); 
        for (DateRole role : rolesHistory) {
            roleMap.put(role.date(), role.role());
        }
        for (LocalDate date : dates) {
        	String role = null;
        	if(roleMap.floorEntry(date) != null) {
        		role = roleMap.floorEntry(date).getValue();
        	}
            result.add(new DateRole(date, role));
        }
        return result;
	}
	public static void displayDigitStatistics() {
		//display out statistics in the following format (example)
		/* 1 -> .......
		 * 2 -> .......
		 * .......
		 */
		//sorted by counts of occurrences in the descending order
		//takes 1_000_000 random numbers in range [0-Integer.MAX_VALUE)
		//one pipeline with no additional yours methods
		new Random().ints(1_000_000, 0, Integer.MAX_VALUE)
			.flatMap(i -> String.valueOf(i).chars().map(Character::getNumericValue)).boxed()
			.collect(Collectors.groupingBy(n -> n, Collectors.counting()))
			.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
			.forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
	}
}