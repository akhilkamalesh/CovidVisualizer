package prj5;

/**
 * DataLoaderException extends Exception and this class is created so that an
 * exception can be thrown in DataLoader if a value is less than 0
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */
@SuppressWarnings("serial")
public class DataLoaderException extends Exception {

    /**
     * Constructor for DataLoaderException.
     * 
     * @param message
     *            Message that is displayed when the error is thrown.
     */
    public DataLoaderException(String message) {
        super(message);
    }
}
