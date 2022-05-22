package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Paul Yang (906394368)
/**
 * COVIDReader Class
 * 
 * @author Paul Yang <yangaapaul@vt.edu>
 * @version Nov 18, 2021
 */
public class CovidReader {
    private State[] state;

    /**
     * constant for number of states
     */
    public static final int NUM_STATES = 6;

    /**
     * COVIDReader Constructor
     * 
     * @throws FileNotFoundException
     */
    public CovidReader(String fileName) throws FileNotFoundException {
        readStateAndRace(fileName);
        // instantiates window using parsed data as input
        new GUI(state);
    }


    /**
     * parses the states and the respective races from the csv file
     * 
     * @throws FileNotFoundException
     */
    public void readStateAndRace(String fileName) throws FileNotFoundException {
        state = new State[NUM_STATES];

        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int index = 0;
        // advances scanner one line because first line of the CSV does not need
        // to be parsed
        sc.nextLine();
        while (sc.hasNextLine()) {
            SinglyLinkedList<Race> races = new SinglyLinkedList<Race>();
            // stores each element of the line into an array
            String[] parameters = sc.nextLine().split(", *", 11);
            for (int i = 0; i < parameters.length; i++) {
                // if statement handles special case where cases/deaths is NA
                if (parameters[i].equals("NA")) {
                    parameters[i] = "-1";
                }
            }
            // parses input to create a linked list of races
            // using each respective race's cases and deaths
            races.add(new Race("white", Integer.parseInt(parameters[1]), Integer
                .parseInt(parameters[6])));
            races.add(new Race("black", Integer.parseInt(parameters[2]), Integer
                .parseInt(parameters[7])));
            races.add(new Race("latinx", Integer.parseInt(parameters[3]),
                Integer.parseInt(parameters[8])));
            races.add(new Race("asian", Integer.parseInt(parameters[4]), Integer
                .parseInt(parameters[9])));
            races.add(new Race("other", Integer.parseInt(parameters[5]), Integer
                .parseInt(parameters[10])));

            // stores the first linked list as the first element in the array of
            // states and then increments to the next element in the array
            state[index] = new State(parameters[0], races);
            index++;
        }
        sc.close();
    }


    /**
     * @return state
     *         getter for state
     */
    public State[] getState() {
        return state;
    }
}
