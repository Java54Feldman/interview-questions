package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeSetTests {
	TreeSet<Integer> treeSet;
	Integer[] numbers = {10, -20, 30, -100, 80, 35, 200};
	
	@BeforeEach
	void setUp() {
		treeSet = new TreeSet<>(List.of(numbers));
	}

	@Test
	void subsetTest() {
		Set<Integer> set = treeSet.subSet(10, true, 40, false); // включ-невключ
		Integer[] expected = {30, 35, 10};
		runTest(expected, set);
		
	}
	@Test
	void subsetAsViewAddTest() {
		Set<Integer> set = treeSet.subSet(0, true, 50, false);
		set.add(20);
		Integer[] expected = {10, -20, 30, -100, 80, 35, 200, 20};
		//set.add(150); // такое добавление не пройдёт (неверный диапазон)
		runTest(expected, treeSet);
	}
	@Test
	void subsetAsViewRemoveTest() {
		Set<Integer> set = treeSet.subSet(0, true, 50, false);
		set.clear();
		Integer[] expected = {-20, -100, 80, 200};
		runTest(expected, treeSet);
	}
	@Test
	void setAsCopyTest() {
		List<Integer> list = treeSet.stream().filter(n -> n >= 0 && n <= 50)
				.toList();
		TreeSet<Integer> set = new TreeSet<>(list); // для сортировки
		Integer[] expected = {10, 30, 35};
		runTest(expected, set);
		
	}
	private void runTest(Integer[] expected, Set<Integer> set) {
		Arrays.sort(expected);
		Integer[] actual = set.toArray(Integer[]::new);
		assertArrayEquals(expected, actual);
		
	}
}
