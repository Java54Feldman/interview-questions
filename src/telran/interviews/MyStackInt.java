package telran.interviews;

import java.util.*;

//all methods should have complexity O[1]
public class MyStackInt {
	//Data Structure
	LinkedList<Integer> stackList = new LinkedList<>();
	int maxValue;
	
	public void push(int num) {
		//adds number into top of stack (LIFO) - last element
		if(isEmpty()) {
			maxValue = num;
		} else if(num > maxValue) {
			maxValue = num;
		}
		stackList.push(num);
	}
	public int pop() throws RuntimeException {
		//removes element from top of stack (last element)
		//returns being removed number
		//throws exception if the stack is empty
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		int value = stackList.pop();
		return value;
	}
	public int peek() throws RuntimeException {
		//returns last number
		//throws exception if the stack is empty
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return stackList.peek();
	}
	public boolean isEmpty() {
		//returns true if the stack is empty
		return stackList.isEmpty();
	}
	public int getMaxElement() {
		//returns the max number from the stack
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return maxValue;
	}
	public int size() {
		return stackList.size();
	}
}
