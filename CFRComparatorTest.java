package prj5;

/**
 * Class that
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */
public class CFRComparatorTest extends student.TestCase {

    private CFRComparator cfrComparator;

    /**
     * SetUp instantiates the fields in the test class and runs before each
     * test method is run.
     */
    public void setUp() {
        cfrComparator = new CFRComparator();
    }


    /**
     * Tests that compare returns a negative integer when an ethnicity with a
     * greater CFR is compared to an ethnicity with a smaller CFR.
     */
    public void testCompare1() {
        Ethnicity ethnicity1 = new Ethnicity("A", 20, 15);
        Ethnicity ethnicity2 = new Ethnicity("A", 10, 5);
        assertEquals(cfrComparator.compare(ethnicity1, ethnicity2), -1);
    }


    /**
     * Tests that compare returns a positive integer for the alphabetical order
     * by name when an ethnicity is compared to an ethnicity with the same CFR
     * but the name of the first ethnicity comes after the name of the second.
     */
    public void testCompare2() {
        Ethnicity ethnicity1 = new Ethnicity("B", 10, 5);
        Ethnicity ethnicity2 = new Ethnicity("A", 200, 100);
        assertEquals(cfrComparator.compare(ethnicity1, ethnicity2), 1);
    }


    /**
     * Tests that compare returns a positive integer when an ethnicity with a
     * smaller CFR is compared to an ethnicity with a greater CFR.
     */
    public void testCompare3() {
        Ethnicity ethnicity1 = new Ethnicity("A", 50, 10);
        Ethnicity ethnicity2 = new Ethnicity("A", 40, 15);
        assertEquals(cfrComparator.compare(ethnicity1, ethnicity2), 1);
    }
}
