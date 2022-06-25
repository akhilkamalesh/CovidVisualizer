package prj5;

/**
 * Class that
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */
public class EthnicityTest extends student.TestCase {

    private Ethnicity ethnicity1;

    /**
     * SetUp instantiates the fields in the test class and runs before each
     * test method is run.
     */
    public void setUp() {
        ethnicity1 = new Ethnicity("green", 40, 10);
    }


    /**
     * Tests that getName returns name of the ethnicity.
     */
    public void testGetName() {
        assertEquals(ethnicity1.getName(), "green");
    }


    /**
     * Tests that getCases returns the amount of cases for the ethnicity.
     */
    public void testGetCases() {
        assertEquals(ethnicity1.getCases(), 40);
    }


    /**
     * Tests that getDeaths returns the amount of deaths for the ethnicity.
     */
    public void testGetDeaths() {
        assertEquals(ethnicity1.getDeaths(), 10);
    }


    /**
     * Tests that getCFR returns when given a positive amount of cases and
     * deaths.
     */
    public void testGetCFR1() {
        assertEquals(ethnicity1.getCFR(), 25.0, 0.01);
    }


    /**
     * Tests that getCFR returns 0.0 when given a case amount of 0.
     */
    public void testGetCFR2() {
        Ethnicity ethnicity2 = new Ethnicity("blue", 0, 10);
        assertEquals(ethnicity2.getCFR(), 0.0, 0.01);
    }


    /**
     * Tests that getCFR returns -1.0 when given a negative death count.
     * The death count is -1 when the death numbers are NA.
     */
    public void testGetCFR3() {
        Ethnicity ethnicity2 = new Ethnicity("blue", 40, -1);
        assertEquals(ethnicity2.getCFR(), -1.0, 0.01);
    }


    /**
     * Test the equals method for comparing an Ethnicity object to a null value.
     */
    public void testEquals1() {
        Ethnicity ethnicity2 = null;
        assertFalse(ethnicity1.equals(ethnicity2));
    }


    /**
     * Test the equals method for comparing an Ethnicity object to an object
     * of a different class.
     */
    public void testEquals2() {
        Object ethnicity2 = new Object();
        assertFalse(ethnicity1.equals(ethnicity2));
    }


    /**
     * Test the equals method for comparing an Ethnicity object to an Ethnicity
     * object with a different name.
     */
    public void testEquals3() {
        Ethnicity ethnicity2 = new Ethnicity("blue", 40, 10);
        assertFalse(ethnicity1.equals(ethnicity2));
    }


    /**
     * Test the equals method for comparing an Ethnicity object to an Ethnicity
     * object with a different case number.
     */
    public void testEquals4() {
        Ethnicity ethnicity2 = new Ethnicity("green", 20, 10);
        assertFalse(ethnicity1.equals(ethnicity2));
    }


    /**
     * Test the equals method for comparing an Ethnicity object to an Ethnicity
     * object with a different death number.
     */
    public void testEquals5() {
        Ethnicity ethnicity2 = new Ethnicity("green", 40, 5);
        assertFalse(ethnicity1.equals(ethnicity2));
    }


    /**
     * Test the equals method for comparing an Ethnicity object to an Ethnicity
     * object with the same name, case number, and death number.
     */
    public void testEquals6() {
        Ethnicity ethnicity2 = new Ethnicity("green", 40, 10);
        assertTrue(ethnicity1.equals(ethnicity2));
    }


    /**
     * Tests that toString returns a proper string representation of the
     * Ethnicity object.
     */
    public void testToString() {
        assertEquals(ethnicity1.toString(), "green: 40 cases, 25% CFR");
    }
}
