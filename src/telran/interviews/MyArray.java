package telran.interviews;

import java.util.HashMap;

//all methods must have complexity O[1]
public class MyArray<T> {
	//Data Structure
    HashMap<Integer, T> map = new HashMap<>();
    T defaultValue;
    int size;
    
	public void setAll(T value) {
		//all array's elements should be set with a given value
		defaultValue = value;
		map = new HashMap<>();
	}
	public void set(int index, T value) {
		//set new value at a given index
		//throws ArrayIndexOutOfBoundsException for incorrect index
		checkIndex(index);
		map.put(index, value);
	}
	private void checkIndex(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	public T get(int index) {
		//returns a value at a given index
		//throws ArrayIndexOutOfBoundsException for incorrect index
        checkIndex(index);
        return map.getOrDefault(index, defaultValue);
	}
	public MyArray(int size) {
		//creates the Array object for a given size
		//with setting null's at each elements
        this.size = size;
	}
}
