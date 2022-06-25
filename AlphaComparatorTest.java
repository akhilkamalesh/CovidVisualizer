package prj5;

/**
 * Class that
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */
public class AlphaComparatorTest extends student.TestCase {

    private AlphaComparator alphaComparator;

    /**
     * SetUp instantiates the fields in the test class and runs before each
     * test method is run.
     */
    public void setUp() {
        alphaComparator = new AlphaComparator();
    }


    /**
     * Tests that compare returns a negative integer when ethnicity "A" is
     * compared to ethnicity "B."
     */
    public void testCompare1() {
        Ethnicity ethnicity1 = new Ethnicity("A", 0, 10);
        Ethnicity ethnicity2 = new Ethnicity("B", 0, 10);
        assertEquals(alphaComparator.compare(ethnicity1, ethnicity2), -1);
    }


    /**
     * Tests that compare returns a negative integer when ethnicity "F" is
     * compared to ethnicity "Y."
     */
    public void testCompare2() {
        Ethnicity ethnicity1 = new Ethnicity("F", 0, 10);
        Ethnicity ethnicity2 = new Ethnicity("Y", 0, 10);
        assertEquals(alphaComparator.compare(ethnicity1, ethnicity2), -19);
    }


    /**
     * Tests that compare returns a positive integer when ethnicity "C" is
     * compared to ethnicity "A."
     */
    public void testCompare3() {
        Ethnicity ethnicity1 = new Ethnicity("C", 0, 10);
        Ethnicity ethnicity2 = new Ethnicity("A", 0, 10);
        assertEquals(alphaComparator.compare(ethnicity1, ethnicity2), 2);
    }


    /**
     * Test that compare returns 0 when one ethnicity has the same name as
     * another.
     */
    public void testCompare4() {
        Ethnicity ethnicity1 = new Ethnicity("blue", 20, 10);
        Ethnicity ethnicity2 = new Ethnicity("blue", 24, 9);
        assertEquals(alphaComparator.compare(ethnicity1, ethnicity2), 0);
    }
}
