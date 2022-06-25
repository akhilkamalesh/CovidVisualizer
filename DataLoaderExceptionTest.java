package prj5;

/**
 * DataLoaderExceptionTest extends TestCase and this class tests the
 * DataLoaderException class to make the exception is properly thrown
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */
public class DataLoaderExceptionTest extends student.TestCase {

    /**
     * Tests that the DataLoaderExeption is properly thrown.
     */
    public void testDataLoader() {
        Exception exception = null;
        try {
            throw new DataLoaderException("DataLoaderException");
        }
        catch (Exception e) {
            exception = e;
        }

        assertTrue(exception instanceof DataLoaderException);
    }

}
