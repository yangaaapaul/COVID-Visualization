package prj5;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Paul Yang (906394368)
/**
 * StateTest Class
 * 
 * @author Paul Yang <yangaapaul@vt.edu>
 * @version Nov 18, 2021
 */
public class StateTest extends TestCase {
    private State state;
    private SinglyLinkedList<Race> races;

    /**
     * sets up before each method and runs before every test
     */
    public void setUp() {
        races = new SinglyLinkedList<Race>();
        races.add(new Race("white", 111, 222));
        races.add(new Race("black", 222, 333));
        races.add(new Race("asian", 444, 555));
        state = new State("Virginia", races);
    }


    /**
     * test for getName
     */
    public void testGetName() {
        assertEquals(state.getName(), "Virginia");
        assertEquals(state.getRaces(), races);
    }


    /**
     * test for toString method
     */
    public void testToString() {
        String toString = "Virginia white: 111 cases, 200% CFR\r\n"
            + "black: 222 cases, 150% CFR\r\n"
            + "asian: 444 cases, 125% CFR\r\n";
        assertEquals(state.toString(), toString);
    }
}
