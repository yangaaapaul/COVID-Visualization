package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Paul Yang (906394368)
/**
 * SinglyLinkedListTest Class
 * 
 * @author Paul Yang <yangaapaul@vt.edu>
 * @version Nov 18, 2021
 */
public class SinglyLinkedListTest extends TestCase {
    private SinglyLinkedList<String> list1;
    private SinglyLinkedList<String> list2;
    private Iterator<String> iter;
    private SinglyLinkedList<Race> races;

    /**
     * sets up before each method and runs before every test
     */
    public void setUp() {
        list1 = new SinglyLinkedList<String>();
        list1.add("entry1");
        list1.add("entry2");
        iter = list1.iterator();
        list2 = new SinglyLinkedList<String>();
        list2.add("entry1");
        list2.add("entry2");
        races = new SinglyLinkedList<Race>();
        races.add(new Race("white", 222, 111));
        races.add(new Race("black", 222, 222));
        races.add(new Race("asian", 555, 111));
    }


    /**
     * tests sort method
     */
    public void testSort() {

        races.sort(new SortCFR<Race>());
        String sortedCFR = "black: 222 cases, 100% CFR\r\n"
            + "white: 222 cases, 50% CFR\r\n" + "asian: 555 cases, 20% CFR\r\n";
        assertEquals(races.toString(), sortedCFR);
        races.sort(new SortAlpha<Race>());
        String sortedAlpha = "asian: 555 cases, 20% CFR\r\n"
            + "black: 222 cases, 100% CFR\r\n"
            + "white: 222 cases, 50% CFR\r\n";
        assertEquals(races.toString(), sortedAlpha);
    }


    /**
     * test for add method
     */
    public void testAdd() {
        assertEquals(list1.size(), 2);
        list1.clear();
        assertTrue(list1.isEmpty());
        assertEquals(list1.size(), 0);
        Exception e = null;
        try {
            list1.add(null);
        }
        catch (IllegalArgumentException iae) {
            e = iae;
        }
        assertNotNull(e);
    }


    /**
     * test for toString method
     */
    public void testToString() {
        String toString = "entry1\r\n" + "entry2\r\n";
        assertEquals(list1.toString(), toString);
    }


    /**
     * test for equals method
     */
    public void testEquals() {
        assertFalse(list1.equals(null));
        assertFalse(list1.equals(new Object()));
        assertTrue(list1.equals(list1));
        assertTrue(list1.equals(list2));
        SinglyLinkedList<String> difData = new SinglyLinkedList<String>();
        difData.add("entry1");
        difData.add("entry3");
        assertFalse(list1.equals(difData));

        SinglyLinkedList<String> difSize = new SinglyLinkedList<String>();
        difSize.add("entry1");
        assertFalse(list1.equals(difSize));
    }


    /**
     * tests next method for iterator
     */
    public void testNext() {
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), "entry1");
        assertEquals(iter.next(), "entry2");
        assertFalse(iter.hasNext());
        Exception e = null;
        try {
            iter.next();
        }
        catch (NoSuchElementException nse) {
            e = nse;
        }
        assertNotNull(e);
    }
}
