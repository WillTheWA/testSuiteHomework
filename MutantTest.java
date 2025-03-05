package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**

 * Test class for the Triangle implementation.
 */
public class MutantTest {
    // Other Tests From Coverages
    @Test
    public void test1() {
        assertEquals(Type.EQUILATERAL, Triangle.classify(10, 10, 10));
        assertEquals(Type.INVALID, Triangle.classify(2, 1, 5));
        assertEquals(Type.ISOSCELES, Triangle.classify(2,2,1));
        assertEquals(Type.ISOSCELES, Triangle.classify(2,1,2));
        assertEquals(Type.ISOSCELES, Triangle.classify(1,2,2));
        assertEquals(Type.INVALID, Triangle.classify(5,10,5));
        assertEquals(Type.INVALID, Triangle.classify(2, 5, 3));
        assertEquals(Type.INVALID, Triangle.classify(5, 2, 3));
        assertEquals(Type.INVALID, Triangle.classify(3, 5, 2));
    }
    
    // ----------------------MUTATION TESTS----------------------
    
    // Test Mutation Cases Individually
    @Test
    public void test2() {  
        // Handling Zeros and Negative Values
        assertEquals(Type.INVALID, Triangle.classify(0, 5, 5));
        assertEquals(Type.INVALID, Triangle.classify(-1, 5, 5));
        assertEquals(Type.INVALID, Triangle.classify(5, 0, 5));
        assertEquals(Type.INVALID, Triangle.classify(5, -1, 5));
        assertEquals(Type.INVALID, Triangle.classify(5, 5, 0));
        assertEquals(Type.INVALID, Triangle.classify(5, 5, -1));
        assertEquals(Type.INVALID, Triangle.classify(0, 0, 0));
        assertEquals(Type.INVALID, Triangle.classify(1, 2, 3));
        assertEquals(Type.INVALID, Triangle.classify(1, 4, 2));
        assertEquals(Type.INVALID, Triangle.classify(4, 1, 2));
        
        // Large Number Different Values
        assertEquals(Type.SCALENE, Triangle.classify(999999, 1000000, 1000001));
        // This Removed Something
        assertEquals(Type.INVALID, Triangle.classify(1, 1, 2));
        // This killed (a * b > c) (a + b > c)
        assertEquals(Type.INVALID, Triangle.classify(3, 3, 7));
        // Killed 125
        assertEquals(Type.INVALID, Triangle.classify(5, 11, 5));
        // This killed 139
        assertEquals(Type.INVALID, Triangle.classify(7, 3, 3));
        // This killed 139
        assertEquals(Type.INVALID, Triangle.classify(7, 3, 3));
        // This Killed 143
        assertEquals(Type.INVALID, Triangle.classify(6, 3, 3));
        // This Killed 145
        assertEquals(Type.INVALID, Triangle.classify(Integer.MAX_VALUE, Integer.MAX_VALUE, 1));
        
        // Aidans Tests
        assertEquals(Type.INVALID, Triangle.classify(Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2));
        assertEquals(Type.SCALENE, Triangle.classify(10000000, 9999999, 9999998));
        
        // Nadirs Tests
        assertEquals(Type.INVALID, Triangle.classify(Integer.MAX_VALUE, 5, 5));
        assertEquals(Type.INVALID, Triangle.classify(5, Integer.MAX_VALUE, 5));
        assertEquals(Type.INVALID, Triangle.classify(5, 5, Integer.MAX_VALUE));
        
        // Chat
        assertEquals(Triangle.Type.INVALID, Triangle.classify(2, 2, 5));
    }
}
