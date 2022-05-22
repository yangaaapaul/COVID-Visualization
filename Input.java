package prj5;

import java.io.FileNotFoundException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Paul Yang (906394368)
/**
 * Input Class
 * 
 * @author Paul Yang <yangaapaul@vt.edu>
 * @version Nov 17, 2021
 */
public class Input {

    /**
     * @param args
     *            arguments for Input
     *            main method which runs program
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 1) {
            new CovidReader(args[0]);
        }
        else {
            new CovidReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
    }
}
