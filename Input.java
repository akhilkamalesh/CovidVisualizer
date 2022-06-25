package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * Class that outputs what gets passed in DataLoader
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */
public class Input {

    /**
     * Main method that runs this program
     * 
     * @param args
     *            String[] argument that is passed that can be used to run this
     *            program
     * @throws ParseException
     *             When file is not parsed correctly, this gets thrown
     */
    public static void main(String[] args) throws ParseException {

        if (args.length > 0) {
            try {
                DataLoader dataLoader = new DataLoader(args[0]);
            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (DataLoaderException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else {
            try {
                DataLoader dataLoader = new DataLoader(
                    "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (DataLoaderException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
