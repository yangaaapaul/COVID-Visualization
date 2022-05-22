package prj5;

import java.text.DecimalFormat;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Paul Yang (906394368)
/**
 * Race Class
 * 
 * @author Paul Yang <yangaapaul@vt.edu>
 * @version Nov 17, 2021
 */
public class Race {
    private int cases;
    private int deaths;
    private double cfr;
    private String name;

    /**
     * Race Constructor
     * 
     * @param name
     *            name of race
     * @param cases
     *            number of cases
     * @param deaths
     *            number of deaths
     */
    public Race(String name, int cases, int deaths) {
        this.name = name;
        this.cases = cases;
        this.deaths = deaths;
        cfr = ((double)deaths / cases) * 100;
        // if statement used to handle special case if value is NA
        if (cases == -1 || deaths == -1) {
            cfr = -1;
        }
    }


    /**
     * @return deaths
     *         getter for deaths
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * @return cases
     *         getter for cases
     */
    public int getCases() {
        return cases;
    }


    /**
     * @return name
     *         getter for name
     */
    public String getName() {
        return name;
    }


    /**
     * @return CFR
     *         method that calculates CFR
     */
    public double getCFR() {
        return cfr;
    }


    /**
     * @return race as a string
     *         toString method for race
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("##.#");
        return sb.append(name).append(": ").append(cases).append(" cases, ")
            .append(df.format(getCFR())).append("% CFR").toString();
    }
}
