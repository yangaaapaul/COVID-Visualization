package prj5;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Paul Yang (906394368)
/**
 * SortAlphaTest Class
 * 
 * @author Paul Yang <yangaapaul@vt.edu>
 * @version Nov 19, 2021
 */
public class SortAlphaTest extends TestCase {
    private SortAlpha<Race> comp;

    /**
     * sets up before each method and runs before every test
     */
    public void setUp() {
        comp = new SortAlpha<Race>();
    }


    /**
     * tests compare method for alpha-order
     */
    public void testCompare() {
        Race race1 = new Race("asian", 1, 2);
        Race race2 = new Race("black", 2, 1);
        assertEquals(-1, comp.compare(race1, race2));
        assertEquals(0, comp.compare(race1, race1));
        assertEquals(1, comp.compare(race2, race1));
    }
}
