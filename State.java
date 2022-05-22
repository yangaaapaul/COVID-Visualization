package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Paul Yang (906394368)
/**
 * State Class
 * 
 * @author Paul Yang <yangaapaul@vt.edu>
 * @version Nov 17, 2021
 */
public class State {
    private String name;
    private SinglyLinkedList<Race> races;

    /**
     * State Constructor
     * 
     * @param name
     *            name of state
     * @param races
     *            list of races
     */
    State(String name, SinglyLinkedList<Race> races) {
        this.name = name;
        this.races = races;
    }


    /**
     * @return races
     *         getter for races
     */
    public SinglyLinkedList<Race> getRaces() {
        return races;
    }


    /**
     * @return name
     *         getter for name
     */
    public String getName() {
        return name;
    }


    /**
     * @return State as a string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(name).append(" ").append(races).toString();
    }
}
