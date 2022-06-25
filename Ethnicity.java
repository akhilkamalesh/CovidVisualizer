package prj5;

import java.text.DecimalFormat;

/**
 * Class that
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */
public class Ethnicity {

    private String name;
    private int cases;
    private int deaths;

    /**
     * Constructor for the Ethnicity object.
     * 
     * @param name
     *            Name of the ethnicity.
     * @param cases
     *            Coronavirus cases for the ethnicity.
     * @param deaths
     *            Coronavirus deaths for the ethnicity.
     */
    public Ethnicity(String name, int cases, int deaths) {
        this.name = name;
        this.cases = cases;
        this.deaths = deaths;
    }


    /**
     * Getter method for the name of the ethnicity.
     * 
     * @return String for the name.
     */
    public String getName() {
        return name;
    }


    /**
     * Getter method for the cases of the ethnicity.
     * 
     * @return Integer for the cases.
     */
    public int getCases() {
        return cases;
    }


    /**
     * Getter method for the deaths of the ethnicity.
     * 
     * @return Integer for the deaths.
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * Gets the case fatality ratio(CFR) for the ethnicity.
     * 
     * @return Double representing the CFR ratio.
     */
    public double getCFR() {
        if (cases <= 0 || deaths < 0) {
            if (cases == 0) {
                return 0.0;
            }
            return -1.0;
        }
        return ((double)deaths / (double)cases) * 100.0;
    }


    /**
     * Compares if the objects are equal to each other.
     * 
     * @param obj
     *            The object you want to compare the current object to.
     * @return Boolean for if the name, cases, and deaths are the same for the
     *         objects.
     */
    public boolean equals(Object obj) {
        if (obj != null && this.getClass().equals(obj.getClass())) {
            Ethnicity other = (Ethnicity)obj;

            return this.getName().equals(other.getName()) && this
                .getCases() == other.getCases() && this.getDeaths() == other
                    .getDeaths();
        }
        return false;
    }


    /**
     * Returns a string representation of the ethnicity object.
     * 
     * @return String representation of ethnicity.
     */
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(name);
        strBuild.append(": ");
        strBuild.append(cases);
        strBuild.append(" cases, ");

        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        strBuild.append(decimalFormat.format(this.getCFR()));
        strBuild.append("% CFR");

        return strBuild.toString();
    }
}
