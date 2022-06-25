package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class that
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */
public class DataLoader {

    /**
     * Constructor that makes regions filled with data from a given file.
     * 
     * @param regionsFileName
     *            Name of the file containing data
     * @throws FileNotFoundException
     *             If the file cannot be opened.
     * @throws DataLoaderException
     *             If the file is not in the correct format.
     */
    public DataLoader(String regionsFileName)
        throws FileNotFoundException,
        DataLoaderException {

        Region[] regions = readRegionFile(regionsFileName);
        GUICovidVisualizer gui = new GUICovidVisualizer(regions);
    }


    /**
     * 
     * @param regionsFileName
     * @return
     * @throws FileNotFoundException
     * @throws DataLoaderException
     */
    private Region[] readRegionFile(String regionsFileName)
        throws FileNotFoundException,
        DataLoaderException {

        Region[] tempRegions = new Region[6];
        Scanner scanner = new Scanner(new File(regionsFileName));
        scanner.nextLine();
        for (int i = 0; i < tempRegions.length && scanner.hasNextLine(); i++) {
            String[] line = scanner.nextLine().split(",");
            DLList<Ethnicity> ethnicities = new DLList<Ethnicity>();
            ethnicities.add(new Ethnicity("white", inputChecker(line[1]),
                inputChecker(line[6])));
            ethnicities.add(new Ethnicity("black", inputChecker(line[2]),
                inputChecker(line[7])));
            ethnicities.add(new Ethnicity("latinx", inputChecker(line[3]),
                inputChecker(line[8])));
            ethnicities.add(new Ethnicity("asian", inputChecker(line[4]),
                inputChecker(line[9])));
            ethnicities.add(new Ethnicity("other", inputChecker(line[5]),
                inputChecker(line[10])));
            tempRegions[i] = new Region(line[0], ethnicities);
        }

        return tempRegions;
    }


    /**
     * Converts strings to integer data values.
     * 
     * @param input
     *            The string to be parsed for data.
     * @return Integer value for the data from the string.
     * @throws DataLoaderException
     *             If the value is less than 0.
     */
    private int inputChecker(String input) throws DataLoaderException {
        if (input.equals("NA")) {
            return -1;
        }
        int val = Integer.parseInt(input);
        if (val < 0) {
            throw new DataLoaderException("Negative Value Not Allowed");
        }
        return val;

    }
}
