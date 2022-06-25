package prj5;

import java.util.Iterator;

/**
 * Class that
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */
public class Region {

    private String name;
    private DLList<Ethnicity> ethnicities;

    /**
     * Constructor for the region class.
     * 
     * @param name
     *            Name of the region.
     * @param ethnicities
     *            A DLList of the ethnicities contained in the region.
     */
    public Region(String name, DLList<Ethnicity> ethnicities) {
        this.name = name;
        this.ethnicities = ethnicities;
    }


    /**
     * Getter method that returns the name of the region.
     * 
     * @return The string name of the region.
     */
    public String getName() {
        return name;
    }


    /**
     * Getter method that returns the ethnicities DLList.
     * 
     * @return The ethnicities DLList.
     */
    public DLList<Ethnicity> getEthinicities() {
        return ethnicities;
    }


    /**
     * Sorts the ethnicities by alphabetical order.
     */
    public void sortAlpha() {
        ethnicities.sort(new AlphaComparator());
    }


    /**
     * Sorts the ethnicities by order of largest CFR to smallest.
     */
    public void sortByCFR() {
        ethnicities.sort(new CFRComparator());
    }


    /**
     * Returns a string representation of the region object.
     * 
     * @return String representation of region.
     */
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(name);
        strBuild.append("\n");

        this.sortAlpha();
        Iterator<Ethnicity> iteratorA = ethnicities.iterator();
        while (iteratorA.hasNext()) {
            strBuild.append(iteratorA.next().toString());

            if (iteratorA.hasNext()) {
                strBuild.append("\n");
            }
        }
        strBuild.append("\n=====\n");

        this.sortByCFR();
        Iterator<Ethnicity> iteratorB = ethnicities.iterator();
        while (iteratorB.hasNext()) {
            strBuild.append(iteratorB.next().toString());

            if (iteratorB.hasNext()) {
                strBuild.append("\n");
            }
        }
        strBuild.append("\n=====");
        return strBuild.toString();
    }
}
