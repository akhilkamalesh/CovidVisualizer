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
public class CFRComparator implements Comparator<Ethnicity> {

    /**
     * Method that compares Ethnicity objects by CFR.
     * 
     * @param obj1
     *            The first Ethnicity you want to compare.
     * @param obj2
     *            The second Ethnicity you want to compare.
     * @return Positive value if obj1 has a lower CFR than obj2. Negative value
     *         if obj1 has a greater CFR than obj2. If the same it compares
     *         names by alphabetical order.
     */
    @Override
    public int compare(Ethnicity obj1, Ethnicity obj2) {
        Double cfr1 = new Double(obj1.getCFR());
        Double cfr2 = new Double(obj2.getCFR());

        int comparison = cfr2.compareTo(cfr1);
        return (comparison == 0)
            ? obj1.getName().compareTo(obj2.getName())
            : comparison;
    }
}
