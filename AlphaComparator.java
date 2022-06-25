package prj5;

import java.util.Comparator;

/**
 * Class that
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */
public class AlphaComparator implements Comparator<Ethnicity> {

    /**
     * Method that compares Ethnicity objects by alphabetical order.
     * 
     * @param obj1
     *            The first Ethnicity you want to compare.
     * @param obj2
     *            The second Ethnicity you want to compare.
     * @return Positive value if obj1 is later alphabetically than obj2.
     *         Negative value if obj1 is earlier alphabetically than obj2.
     *         Zero if the same order.
     */
    @Override
    public int compare(Ethnicity obj1, Ethnicity obj2) {
        return obj1.getName().compareTo(obj2.getName());
    }
}
