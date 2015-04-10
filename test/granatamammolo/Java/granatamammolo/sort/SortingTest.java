/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.sort;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Giuseppe
 */
public class SortingTest {
    protected int[] unorder,order,voidarray,single;
    
    public SortingTest() {
    }
    
    @Before
    public void setUp() {
        voidarray = new int[0];
        single= new int[]{1};
        unorder = new int[] {1,4,5,6,8,3,2,9,10,7,0};
        order = new int[]  {0,1,2,3,4,5,6,7,8,9,10};
    }
    
    @Test
    public void testIsSortedVoidArrays() {
        //TOSEE: l'array voidarray per fefinizione è order o no?
        System.out.println("testIsSortedVoidArrays");
        int[] a = voidarray;
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsSortedSingleArrays() {
        //TOSEE: se c'è solo un elemento nell' array come fa a non essere order?
        System.out.println("testIsSortedSingleArrays");
        int[] a = single;
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsSortedOrderArrays() {
        System.out.println("testIsSortedOrderArrays");
        int[] a = order.clone();
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }

     @Test
    public void testIsSortedUnorderArrays() {
        System.out.println("testIsSortedUnorderArrays");
        int[] a = unorder.clone();
        boolean expResult = false;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }
    
    //####################################################################
    
    @Test
    public void testSsortUnorderArrays() {
        System.out.println("testSsortUnorderArrays");
        int[] a = unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, order);
    }
    
    @Test
    public void testSsortOrderArrays() {
        System.out.println("testSsortOrderArrays");
        int[] a = order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, order);
    }
    
    @Test
    public void testSsortVoidArrays() {
        System.out.println("testSsortVoidArrays");
        int[] a = voidarray;
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, voidarray);
    }
    
    @Test
    public void testSsortSingleArrays() {
        System.out.println("testSsortSingleArrays");
        int[] a = single;
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, single);
    }
    
    //####################################################################
 
    @Test
    public void testIsortOrderArray() {
        System.out.println("testIsortOrderArray");
        int[] a = order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, order);
    }
    
    @Test
    public void testIsortUnorderArray() {
        System.out.println("testIsortUnorderArray");
        int[] a = unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, order);
    }
    
    @Test
    public void testIsortVoidArray() {
        System.out.println("testIsortVoidArray");
        int[] a = voidarray.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, voidarray);
    }
    
    @Test
    public void testIsortSingleArray() {
        System.out.println("testIsortSingleArray");
        int[] a = single.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, single);
    }

    
    //####################################################
    
    @Test
    public void testISortBinOrderArrays() {
        System.out.println("testISortBinOrderArrays");
        int[] a = order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, order);
    }
    
        @Test
    public void testISortBinUnorderArray() {
        System.out.println("testISortBinUnorderArray");
        int[] a = unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, order);
    }
    
        @Test
    public void testISortBinVoidArray() {
        System.out.println("testISortBinVoidArray");
        int[] a = voidarray.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, voidarray);
    }
    
        @Test
    public void testISortBinSingleArray() {
        System.out.println("testISortBinSingleArray");
        int[] a = single.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, single);
    }
    
    //######################################################

    @Test
    public void testMSortBasicOrderArrays() {
        System.out.println("testMSortBasicOrderArrays");
        int[] a = order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, order);
    }
    
    @Test
    public void testMSortBasicUnorderArrays() {
        System.out.println("testMSortBasicUnorderArrays");
        int[] a = unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, order);
    }
    
    @Test
    public void testMSortBasicVoidArray() {
        System.out.println("testMSortBasicVoidArray");
        int[] a = voidarray.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, voidarray);
    }
    
    @Test
    public void testMSortBasicSingleArray() {
        System.out.println("testMSortBasicSingleArray");
        int[] a = single.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, single);
    }
    
}
