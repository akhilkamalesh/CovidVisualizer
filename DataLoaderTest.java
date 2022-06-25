package prj5;

/**
 * import statements
 */
import java.io.FileNotFoundException;

/**
 * DataLoaderTest extends TestCase and makes sure that DataLoader works as
 * intended.
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */
public class DataLoaderTest extends student.TestCase {

    /**
     * Testing DataLoader so that it works as intended and to make sure that the
     * exceptions gets thrown if it gets triggered
     * 
     * @throws DataLoaderException
     *             When the value is less than 0, this will be thrown
     * @throws java.text.ParseException
     *             When the file doesn't get parsed correctly, this will be
     *             thrown
     * @throws FileNotFoundException
     *             When the file is not found, this will be thrown
     */
    public void testDataLoader()
        throws FileNotFoundException,
        java.text.ParseException,
        DataLoaderException {

        Exception exception = null;
        try {
            new DataLoader("Cases_and_Deaths_by_race_RANDOM_NUMBERS.csv");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof DataLoaderException);

        Exception exception1 = null;
        try {
            new DataLoader("nofile.csv");
        }
        catch (Exception e) {
            exception1 = e;
        }
        assertTrue(exception1 instanceof FileNotFoundException);

        Exception exception2 = null;
        try {
            new DataLoader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertNull(exception2);

        Exception exception3 = null;
        try {
            new DataLoader("Cases_RCSV.csv");
        }
        catch (Exception e) {
            exception3 = e;
        }
        assertNotNull(exception3);
    }
}
