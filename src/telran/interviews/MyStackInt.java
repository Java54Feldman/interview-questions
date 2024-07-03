package telran.interviews;

import java.util.*;

//all methods should have complexity O[1]
public class MyStackInt {
	//Data Structure
	LinkedList<Integer> stackList = new LinkedList<>();
	LinkedList<Integer> maxValueList = new LinkedList<>();
	
	public void push(int num) {
		//adds number into top of stack (LIFO) - last element
		if(maxValueList.isEmpty() || num >= maxValueList.peekLast()) {
			maxValueList.addLast(num);
		} 
		stackList.push(num);
	}
	public int pop() {
		//removes element from top of stack (last element)
		//returns being removed number
		//throws exception if the stack is empty
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		int value = stackList.pop();
		if(maxValueList.peekLast().equals(value)) {
			maxValueList.removeLast();
		}
		return value;
	}
	public int peek() {
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
		return maxValueList.peekLast();
	}
	public int size() {
		return stackList.size();
	}
}
