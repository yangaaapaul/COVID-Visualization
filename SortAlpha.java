package prj5;

import java.util.Comparator;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Paul Yang (906394368)
/**
 * CompareAlpha Class
 * 
 * @param <T>
 *            generic class
 * @author Paul Yang <yangaapaul@vt.edu>
 * @version Nov 17, 2021
 */
public class SortAlpha<T> implements Comparator<Race> {
    @Override
    public int compare(Race r1, Race r2) {
        return r1.getName().compareTo(r2.getName());
    }

}
