/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.sort;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Giuseppe
 */
public class SortingTest {
    protected int[] normal,order;
    
    public SortingTest() {
    }
    
    @Before
    public void setUp() {
        normal = new int[] {1,4,5,6,8,3,2,9,10,7,0};
        order = new int[]  {0,1,2,3,4,5,6,7,8,9,10};
    }

    /**
     * Test of isSorted method, of class Sorting.
     * 
     */
    @Test
    public void testIsSorted() {
        System.out.println("isSorted");
        int[] a = order;
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }

     @Test
    public void testIsSortedDis() {
        System.out.println("isSorted");
        int[] a = normal;
        boolean expResult = false;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ssort method, of class Sorting.
     */
    @Test
    public void testSsort() {
        System.out.println("ssort");
        int[] a = normal;
        Sorting.ssort(a);
        assertArrayEquals(a, order);
    }
    

    /**
     * Test of isort method, of class Sorting.
     */
    @Test
    public void testIsort() {
        System.out.println("isort");
        int[] a = normal;
        Sorting.isort(a);
        Sorting.ssort(a);
        assertArrayEquals(a, order);
    }

    /**
     * Test of iSortBin method, of class Sorting.
     */
    @Test
    public void testISortBin() {
        System.out.println("iSortBin");
        int[] a = normal;
        Sorting.iSortBin(a);
        Sorting.ssort(a);
        assertArrayEquals(a, order);
    }

    /**
     * Test of mSortBasic method, of class Sorting.
     */
    @Test
    public void testMSortBasic() {
        System.out.println("mSortBasic");
        int[] a = normal;
        Sorting.mSortBasic(a);
        Sorting.ssort(a);
        assertArrayEquals(a, order);
    }
    
}
