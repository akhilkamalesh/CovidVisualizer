package prj5;

import java.util.Iterator;

/**
 * DLListTest extends TestCase and this class tests the methods in DLList to
 * make sure they work as intended.
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */
public class DLListIteratorTest extends student.TestCase {

    private DLList<String> list;
    private DLList<String> list1;

    /**
     * Instantiates fields before each test method is run.
     */
    public void setUp() {
        list = new DLList<String>();
        list1 = new DLList<String>();
        list.add("Pizza");
        list.add("Pasta");
        list.add("Garlic bread");
        list.add("Sprite");
    }


    /**
     * Tests the hasNext method for the private iterator class in DLList
     */
    public void testHasNext() {
        Iterator<String> iter = list.iterator();
        Iterator<String> iter1 = list1.iterator();
        assertTrue(iter.hasNext());
        iter.next();
        assertTrue(iter.hasNext());
        iter.next();
        assertTrue(iter.hasNext());
        iter.next();
        assertTrue(iter.hasNext());
        iter.next();

        assertFalse(iter1.hasNext());
    }


    /**
     * Tests the next method for the private iterator class in DLList
     */
    public void testNext() {
        Iterator<String> iter = list.iterator();
        assertEquals("Pizza", iter.next());
        assertEquals("Pasta", iter.next());

        Iterator<String> iter1 = list1.iterator();
        Exception exception = null;
        try {
            iter1.next();
        }
        catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
    }


    /**
     * Tests the remove method for the private iterator class in DLList
     */
    public void testRemove() {
        Iterator<String> iter = list.iterator();
        iter.next();
        iter.next();
        iter.remove();
        assertEquals(3, list.getSize());

        Exception exception = null;
        try {
            iter.remove();
        }
        catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
    }

}
