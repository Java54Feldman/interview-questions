package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.MyArray;

class MyArrayTest {

    MyArray<Integer> myArray;

    @BeforeEach
    void setUp() {
        myArray = new MyArray<>(5);
    }

    @Test
    void testSetAll() {
        myArray.setAll(10);
        for (int i = 0; i < 5; i++) {
            assertEquals(10, myArray.get(i));
        }
    }

    @Test
    void testSet() {
        myArray.set(0, 5);
        assertEquals(5, myArray.get(0));
        assertNull(myArray.get(1));
    }

    @Test
    void testGet() {
        myArray.set(0, 5);
        myArray.set(1, 10);
        assertEquals(5, myArray.get(0));
        assertEquals(10, myArray.get(1));
        assertNull(myArray.get(2));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArray.get(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArray.get(5));
    }

}
