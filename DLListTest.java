package prj5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * DLList extends TestCase and this class tests the methods in DLList to make
 * sure it works as intended
 * 
 * @author akhilkamalesh
 * @version 11/21/2020
 */
public class DLListTest {
    private DLList<String> emptyList;
    private DLList<String> fullList;
    private DLList<String> oneItemList;

    /**
     * setUp() sets up three DLList objects
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        emptyList = new DLList<String>();
        fullList = new DLList<String>();
        oneItemList = new DLList<String>();
        for (int i = 0; i < 15; i++) {
            fullList.add("Test" + i);
        }
        oneItemList.add("Test0");
    }


    /**
     * Testing the add method
     */
    @Test
    public void testAdd() {
        try {
            emptyList.add(null);
            fail();
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        emptyList.add("Test0");
        oneItemList.add("Test1");
        fullList.add("Test15");
        assertEquals(1, emptyList.getSize());
        assertTrue(emptyList.contains("Test0"));
        assertEquals(0, emptyList.getPosition("Test0"));
        assertEquals(2, oneItemList.getSize());
        assertTrue(oneItemList.contains("Test1"));
        assertEquals(1, oneItemList.getPosition("Test1"));
        assertEquals(16, fullList.getSize());
        assertTrue(fullList.contains("Test15"));
        assertEquals(15, fullList.getPosition("Test15"));
    }


    /**
     * More tests on the add method
     */
    @Test
    public void testAddTwo() {
        try {
            emptyList.add(15, "Test0");
            fail();
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            emptyList.add(0, null);
            fail();
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            emptyList.add(-5, "Test0");
            fail();
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        emptyList.add(0, "Test0");
        oneItemList.add(0, "Test1");
        fullList.add(8, "Test15");
        assertEquals(1, emptyList.getSize());
        assertTrue(emptyList.contains("Test0"));
        assertEquals(0, emptyList.getPosition("Test0"));
        assertEquals(2, oneItemList.getSize());
        assertTrue(oneItemList.contains("Test1"));
        assertEquals(0, oneItemList.getPosition("Test1"));
        assertEquals(1, oneItemList.getPosition("Test0"));
        assertEquals(16, fullList.getSize());
        assertTrue(fullList.contains("Test15"));
        assertEquals(8, fullList.getPosition("Test15"));
        fullList.add(16, "Test16");
    }


    /**
     * testing the remove method
     */
    public void testRemove() {
        try {
            emptyList.remove(null);
            fail();
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        emptyList.remove("Test0");
        oneItemList.remove("Test0");
        fullList.remove("Test14");
        fullList.remove("Test7");
        assertEquals(0, emptyList.getSize());
        assertFalse(emptyList.contains("Test0"));
        assertEquals(13, fullList.getSize());
        assertFalse(fullList.contains("Test7"));
        assertFalse(fullList.contains("Test14"));
    }


    /**
     * More tests on the remove class
     */
    public void testRemoveTwo() {
        try {
            emptyList.remove(15);
            fail();
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }

        try {
            emptyList.remove(-5);
            fail();
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

}
