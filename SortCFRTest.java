package prj5;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Paul Yang (906394368)
/**
 * SortCFRTest Class
 * 
 * @author Paul Yang <yangaapaul@vt.edu>
 * @version Nov 19, 2021
 */
public class SortCFRTest extends TestCase {
    private SortCFR<Race> comp;

    /**
     * sets up before each method and runs before every test
     */
    public void setUp() {
        comp = new SortCFR<Race>();
    }


    /**
     * tests compare method for CFR
     */
    public void testCompare() {
        Race race1 = new Race("asian", 1, 2);
        Race race2 = new Race("black", 2, 1);
        Race sameCFR = new Race("black", 1, 2);
        assertEquals(-1, comp.compare(race1, race2));
        assertEquals(1, comp.compare(race2, race1));
        assertEquals(-1, comp.compare(race1, sameCFR));
    }
}
