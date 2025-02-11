package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {
	Integer[] numbers = {30, -10, 20, 17, 30};
	LinkedList<Integer> list;

	@BeforeEach
	void setUp() {
		list = new LinkedList<>(List.of(numbers));
	}

	@Test
	void removeTest() {
		Integer[] expected = {-10, 20, 17, 30};
		list.remove();
		runTest(expected, list);
		LinkedList<Integer> emptyList = new LinkedList<>();
		//emptyList.remove(); //NoSuchElementException
		assertThrowsExactly(NoSuchElementException.class, () -> emptyList.remove());
	}
	@Test
	void subListTest() {
		List<Integer> sublist = list.subList(3, 5);
		Integer[] expected = {17, 30};
		runTest(expected, sublist);
	}
	@Test
	void sublistAsViewTest() {
		List<Integer> sublist = list.subList(3, 5);
		sublist.add(1, 40);
		list.add(500);
		// sublist.add(100); //индексация изменилась, не пройдёт
		Integer[] expected = {30, -10, 20, 17, 40, 30, 500};
		runTest(expected, list);
		
	}
	private void runTest(Integer[] expected, List<Integer> lst) {
		assertArrayEquals(expected, lst.toArray(Integer[]::new));
	}

}
