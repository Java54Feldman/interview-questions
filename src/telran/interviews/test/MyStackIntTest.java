package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.MyStackInt;

class MyStackIntTest {
	MyStackInt stack = new MyStackInt();
	MyStackInt emptyStack = new MyStackInt();

	@BeforeEach
	void setUp() {
		stack.push(5);
		stack.push(10);
		stack.push(3);
	}

	@Test
	public void pushTest() {
		stack.push(15);
		assertEquals(4, stack.size());
		assertEquals(15, stack.getMaxElement());
		assertEquals(15, stack.peek());
		assertEquals(15, stack.pop());
	}

	@Test
	public void popTest() {
		assertEquals(3, stack.pop());
		assertEquals(2, stack.size());
		assertThrows(RuntimeException.class, () -> emptyStack.pop());
	}

	@Test
	public void peekTest() {
		assertEquals(3, stack.peek());
		assertEquals(3, stack.size());
		assertThrows(RuntimeException.class, () -> emptyStack.peek());
	}

	@Test
	public void isEmptyTest() {
		assertFalse(stack.isEmpty());
		assertTrue(emptyStack.isEmpty());

	}

	@Test
	public void getMaxElementTest() {
		assertEquals(10, stack.getMaxElement());
		assertThrows(RuntimeException.class, () -> emptyStack.getMaxElement());
	}

	@Test
	public void sizeTest() {
		assertEquals(0, emptyStack.size());
		stack.push(15);
		assertEquals(4, stack.size());
		stack.pop();
		assertEquals(3, stack.size());
	}

}
