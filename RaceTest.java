package prj5;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Paul Yang (906394368)
/**
 * RaceTest Class
 * 
 * @author Paul Yang <yangaapaul@vt.edu>
 * @version Nov 17, 2021
 */
public class RaceTest extends TestCase {
    private Race race1;

    /**
     * sets up before each methoda and runs before every test
     */
    public void setUp() {
        race1 = new Race("Black", 179563, 13365);
    }


    /**
     * test for getter methods
     */
    public void testGetters() {
        assertEquals("Black", race1.getName());
        assertEquals(179563, race1.getCases());
        assertEquals(13365, race1.getDeaths());
        assertEquals(7.443070120236352, race1.getCFR(), .1);
        Race race2 = new Race("Black", -1, 341);
        Race race3 = new Race("Black", 85454, -1);
        assertEquals(race2.getCFR(), -1.0, .5);
        assertEquals(race3.getCFR(), -1.0, .5);

    }


    /**
     * test for toString method
     */
    public void testToString() {
        String toString = "Black: 179563 cases, 7.4% CFR";
        assertEquals(race1.toString(), toString);

    }

}
