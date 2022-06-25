package prj5;

/**
 * Class that
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */
public class RegionTest extends student.TestCase {

    private Region region1;
    private DLList<Ethnicity> ethnicities;

    /**
     * SetUp instantiates the fields in the test class and runs before each
     * test method is run.
     */
    public void setUp() {
        ethnicities = new DLList<Ethnicity>();
        region1 = new Region("VA", ethnicities);
    }


    /**
     * Tests that getName returns the name of the region.
     */
    public void testGetName() {
        assertEquals(region1.getName(), "VA");
    }


    /**
     * Tests that getEthnicities returns the ethnicities DLList.
     */
    public void testGetEthnicities() {
        assertEquals(region1.getEthinicities(), ethnicities);
        System.out.println(ethnicities);
        System.out.println(region1.getEthinicities());
    }


    /**
     * Tests that sortAlpha sorts the list of ethnicities in the region
     * alphabetically.
     */
    public void testSortAlpha() {
        DLList<Ethnicity> ethnicitiesList = new DLList<Ethnicity>();
        Ethnicity ethnicity1 = new Ethnicity("a", 40, 10);
        Ethnicity ethnicity2 = new Ethnicity("b", 80, 10);
        Ethnicity ethnicity3 = new Ethnicity("c", 20, 10);
        ethnicitiesList.add(ethnicity1);
        ethnicitiesList.add(ethnicity3);
        ethnicitiesList.add(ethnicity2);
        Region region2 = new Region("DC", ethnicitiesList);
        region2.sortAlpha();
        assertEquals(region2.getEthinicities().getPosition(ethnicity1), 0);
        assertEquals(region2.getEthinicities().getPosition(ethnicity2), 1);
        assertEquals(region2.getEthinicities().getPosition(ethnicity3), 2);
    }


    /**
     * Tests that sortByCFR sorts the list of ethnicities in the region
     * by CFR.
     */
    public void testSortByCFR() {
        DLList<Ethnicity> ethnicitiesList = new DLList<Ethnicity>();
        Ethnicity ethnicity1 = new Ethnicity("a", 40, 10); // 25% CFR
        Ethnicity ethnicity2 = new Ethnicity("b", 80, 10); // 12.5% CFR
        Ethnicity ethnicity3 = new Ethnicity("c", 20, 10); // 50% CFR
        ethnicitiesList.add(ethnicity1);
        ethnicitiesList.add(ethnicity3);
        ethnicitiesList.add(ethnicity2);
        Region region2 = new Region("DC", ethnicitiesList);
        region2.sortByCFR();
        assertEquals(region2.getEthinicities().getPosition(ethnicity1), 1);
        assertEquals(region2.getEthinicities().getPosition(ethnicity2), 2);
        assertEquals(region2.getEthinicities().getPosition(ethnicity3), 0);

        DLList<Ethnicity> ethnicitiesList2 = new DLList<Ethnicity>();
        Ethnicity ethnicity10 = new Ethnicity("a", 40, 10); // 25% CFR
        Ethnicity ethnicity20 = new Ethnicity("b", 80, 10); // 12.5% CFR
        Ethnicity ethnicity30 = new Ethnicity("c", 20, 10); // 50% CFR
        ethnicitiesList2.add(ethnicity10);
        ethnicitiesList2.add(ethnicity20);
        ethnicitiesList2.add(ethnicity30);
        Region region20 = new Region("DC", ethnicitiesList2);
        region20.sortByCFR();
        assertEquals(region20.getEthinicities().getPosition(ethnicity10), 1);
        assertEquals(region20.getEthinicities().getPosition(ethnicity20), 2);
        assertEquals(region20.getEthinicities().getPosition(ethnicity30), 0);
    }


    /**
     * Tests that toString returns the proper string representation of the
     * region object.
     */
    public void testToString() {
        DLList<Ethnicity> ethnicitiesList = new DLList<Ethnicity>();
        Ethnicity ethnicity1 = new Ethnicity("a", 40, 10);
        Ethnicity ethnicity2 = new Ethnicity("b", 80, 10);
        Ethnicity ethnicity3 = new Ethnicity("c", 20, 10);
        ethnicitiesList.add(ethnicity1);
        ethnicitiesList.add(ethnicity3);
        ethnicitiesList.add(ethnicity2);
        Region region2 = new Region("DC", ethnicitiesList);
        assertEquals(region2.toString(), "DC\r\n" + "a: 40 cases, 25% CFR\r\n"
            + "b: 80 cases, 12.5% CFR\r\n" + "c: 20 cases, 50% CFR\r\n"
            + "=====\r\n" + "c: 20 cases, 50% CFR\r\n"
            + "a: 40 cases, 25% CFR\r\n" + "b: 80 cases, 12.5% CFR\r\n"
            + "=====");
    }
}
