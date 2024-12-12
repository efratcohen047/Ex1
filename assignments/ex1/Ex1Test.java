package assignments.ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex1Test {
    @Test
    void computeNumberTest() {
        // Decimal conversions
        assertEquals(0, Ex1.number2Int("0"));
        assertEquals(123, Ex1.number2Int("123"));

        // Binary conversions
        assertEquals(0, Ex1.number2Int("0b2"));
        assertEquals(2, Ex1.number2Int("10b2"));
        assertEquals(7, Ex1.number2Int("111b2"));

        // Other bases
        assertEquals(6, Ex1.number2Int("20b3")); // base 3
        assertEquals(8, Ex1.number2Int("10b8")); // base 8
        assertEquals(15, Ex1.number2Int("FbG")); // base 16
        assertEquals(255, Ex1.number2Int("FFbG")); // base 16

        // Invalid inputs should return -1
        assertEquals(-1, Ex1.number2Int(null));
        assertEquals(-1, Ex1.number2Int(""));
        assertEquals(-1, Ex1.number2Int("abc"));
        assertEquals(-1, Ex1.number2Int("GbF")); // invalid digit for base
    }

    @Test
    void isBasisNumberTest() {
        // Valid decimal numbers
        assertTrue(Ex1.isNumber("0"));
        assertTrue(Ex1.isNumber("1"));
        assertTrue(Ex1.isNumber("123"));

        // Valid numbers with bases
        assertTrue(Ex1.isNumber("0b2"));
        assertTrue(Ex1.isNumber("10b2")); // binary
        assertTrue(Ex1.isNumber("12b3")); // base 3
        assertTrue(Ex1.isNumber("123b8")); // octal
        assertTrue(Ex1.isNumber("123bA")); // base 10
        assertTrue(Ex1.isNumber("ABCbF")); // base 15
        assertTrue(Ex1.isNumber("FEDCbG")); // base 16

        // Invalid cases
        assertFalse(Ex1.isNumber(null));
        assertFalse(Ex1.isNumber(""));
        assertFalse(Ex1.isNumber("b2"));
        assertFalse(Ex1.isNumber("1b1")); // base 1 invalid
        assertFalse(Ex1.isNumber("1bH")); // base 17 invalid
        assertFalse(Ex1.isNumber("GbF")); // digit larger than base
        assertFalse(Ex1.isNumber("1b")); // missing base
        assertFalse(Ex1.isNumber("b")); // just b
    }

    @Test
    void int2NumberTest() {
        // Test all bases from 2 to 16
        assertEquals("1010b2", Ex1.int2Number(10, 2));
        assertEquals("121b3", Ex1.int2Number(16, 3));
        assertEquals("AbG", Ex1.int2Number(10, 16));

        // Test zero in different bases
        assertEquals("0b2", Ex1.int2Number(0, 2));
        assertEquals("0bA", Ex1.int2Number(0, 10));
        assertEquals("0bG", Ex1.int2Number(0, 16));

        // Test invalid inputs
        assertEquals("", Ex1.int2Number(-1, 2)); // negative number
        assertEquals("", Ex1.int2Number(10, 1)); // invalid base
        assertEquals("", Ex1.int2Number(10, 17)); // invalid base

        // Test large numbers
        assertEquals("FFbG", Ex1.int2Number(255, 16));
    }

    @Test
    void maxIndexTest() {
        // Test with different bases
        String[] arr1 = {"1b2", "10b2", "11b2", "100b2"}; // 1,2,3,4
        assertEquals(3, Ex1.maxIndex(arr1));

        String[] arr2 = {"FbG", "10b2", "12b3", "5bA"}; // 15,2,5,5
        assertEquals(0, Ex1.maxIndex(arr2));

        // Test with invalid elements
        String[] arr3 = {"1b2", "invalid", "3b2"}; // 1,invalid,invalid
        assertEquals(0, Ex1.maxIndex(arr3));

        // Test edge cases
        assertEquals(0, Ex1.maxIndex(new String[0]));
        assertEquals(0, Ex1.maxIndex(null));
    }

    @Test
    void equalsTest() {
        // Same number, different bases
        assertTrue(Ex1.equals("1010b2", "AbG")); // both are 10
        assertTrue(Ex1.equals("16b8", "EbG")); // both are 14
        assertTrue(Ex1.equals("20b3", "6bA")); // both are 6

        // Different numbers
        assertFalse(Ex1.equals("1010b2", "BbG"));

        // Invalid inputs
        assertFalse(Ex1.equals("invalid", "1b2"));
        assertFalse(Ex1.equals("1b2", "invalid"));
        assertFalse(Ex1.equals("invalid1", "invalid2"));

        // Same representation, different bases
        assertFalse(Ex1.equals("10b2", "10b3")); // 2 vs 3
    }

    }
