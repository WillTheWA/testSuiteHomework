package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**

 * Test class for the Triangle implementation.
 */
public class MutantTest {

    // ----------------------COVERAGE TESTS----------------------
    // Test Equilateral
    @Test
    public void test1() {
        Type actual = Triangle.classify(10, 10, 10);
        Type expected = EQUILATERAL;
        assertEquals(actual, expected);
    }
    
    // Test Scalene
    @Test
    public void test2() {
        Type actual = Triangle.classify(3, 4, 5);
        Type expected = SCALENE;
        assertEquals(actual, expected);
    }
    
    // Test Negative Digit Invalid
    @Test
    public void test3() {
        Type actual = Triangle.classify(-1, 4, 5);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }
    
    // Test Middle Invalid
    @Test
    public void test4() {
        Type actual = Triangle.classify(2, 1, 5);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }
    
    // Test trian == 1 and a + b > c
    @Test
    public void test5() {
        Type actual = Triangle.classify(2,2,1);
        Type expected = ISOSCELES;
        assertEquals(actual, expected);
    }
    
    // Test trian == 2 and a + c > b
    @Test
    public void test6() {
        Type actual = Triangle.classify(2,1,2);
        Type expected = ISOSCELES;
        assertEquals(actual, expected);
    }
    
    // Test trian == 3 and b + c > a
    @Test
    public void test7() {
        Type actual = Triangle.classify(1,2,2);
        Type expected = ISOSCELES;
        assertEquals(actual, expected);
    }
    
    // Test Last Return Invalid
    @Test
    public void test8() {
        Type actual = Triangle.classify(5,10,5);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }
    
    // Test Triangle Class
    @Test
    public void test9() {
        Triangle triangle = new Triangle();
        assertNotNull(triangle);
    }
    
    // Test Enum
    @Test
    public void test10() {
        assertEquals(Type.INVALID, Type.valueOf("INVALID"));
        assertEquals(Type.SCALENE, Type.valueOf("SCALENE"));
        assertEquals(Type.EQUILATERAL, Type.valueOf("EQUILATERAL"));
        assertEquals(Type.ISOSCELES, Type.valueOf("ISOSCELES"));
    }
    
    // ----------------------BRANCH TESTS----------------------
    // First test INVALID (b <= 0, c <= 0)
    @Test
    public void test11() {
        Type actual = Triangle.classify(1, -4, 5);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }
    
    @Test
    public void test12() {
        Type actual = Triangle.classify(1, 4, -5);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }
    
    // Second test INVALID (a + c == b, b + c == a)
    @Test
    public void test13() {
        Type actual = Triangle.classify(2, 5, 3);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }
    
    @Test
    public void test14() {
        Type actual = Triangle.classify(5, 2, 3);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }
    
    // Trian 'Switch Case' Tests
    @Test
    public void test15() {
        Type actual = Triangle.classify(2,2,5);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }
    
    @Test
    public void test16() {
        Type actual = Triangle.classify(5,2,2);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }
    
    // ----------------------MUTATION TESTS----------------------
    // Zeros or Negatives
    @Test
    public void test17() {
        assertEquals(Type.INVALID, Triangle.classify(0, 5, 5));
        assertEquals(Type.INVALID, Triangle.classify(-1, 5, 5));
        assertEquals(Type.INVALID, Triangle.classify(5, 0, 5));
        assertEquals(Type.INVALID, Triangle.classify(5, -1, 5));
        assertEquals(Type.INVALID, Triangle.classify(5, 5, 0));
        assertEquals(Type.INVALID, Triangle.classify(5, 5, -1));
        assertEquals(Type.INVALID, Triangle.classify(0, 0, 0));
    }
    
    // INVALID Inequality
    @Test
    public void test18() {
        assertEquals(Type.INVALID, Triangle.classify(1, 2, 3));
        assertEquals(Type.INVALID, Triangle.classify(1, 4, 2));
        assertEquals(Type.INVALID, Triangle.classify(4, 1, 2));
    }
    
    // Test Mutation Cases Individually
    @Test
    public void test19() {                
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
    }
}
