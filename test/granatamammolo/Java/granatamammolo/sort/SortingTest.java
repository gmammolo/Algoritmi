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
    protected int[] int_unorder,int_order,int_void,int_single;
    protected String[] string_unorder,string_order,string_void,string_single;
     
    public SortingTest() {
    }
    
    @Before
    public void setUp() {
        int_void = new int[0];
        int_single= new int[]{1};
        int_unorder = new int[] {1,4,5,6,8,3,2,9,10,7,0};
        int_order = new int[]  {0,1,2,3,4,5,6,7,8,9,10};
        
        string_unorder = new String[]{"Katy", "Drizzit", "Pluto", "Batman", "Tartaglia", "Michelangelo"};
        string_order =string_unorder.clone();
        Arrays.sort(string_order);
        string_void = new String[0];
        string_single = new String[]{"Giuseppe"};
    }
    // TOSEE testare tutti i metodi generici + msort con noGarbage
    
    //###########################################################
    
    @Test
    public void testIsSortedVoidIntArrays() {
        System.out.println("testIsSortedVoidIntArrays");
        int[] a = int_void;
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsSortedSingleIntArrays() {
        //TOSEE: se c'è solo un elemento nell' array come fa a non essere int_order? Con un solo elemento infatti è ordinato
        System.out.println("testIsSortedSingleIntArrays");
        int[] a = int_single;
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }
   
    @Test
    public void testIsSortedOrderIntArrays() {
        System.out.println("testIsSortedOrderIntArrays");
        int[] a = int_order.clone();
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }

     @Test
    public void testIsSortedUnorderIntArrays() {
        System.out.println("testIsSortedUnorderIntArrays");
        int[] a = int_unorder.clone();
        boolean expResult = false;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }
    
    
     @Test
    public void testIsSortedVoidArrays() {
        //TOSEE: l'array int_void per definizione è int_order o no? Secondo me si
        System.out.println("testIsSortedVoidArrays");
        String[] a = string_void;
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsSortedSingleArrays() {
        //TOSEE: se c'è solo un elemento nell' array come fa a non essere int_order? Con un solo elemento infatti è ordinato
        System.out.println("testIsSortedSingleArrays");
        String[] a = string_single;
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }
   
    @Test
    public void testIsSortedOrderArrays() {
        System.out.println("testIsSortedOrderArrays");
        String[] a = string_order.clone();
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }

     @Test
    public void testIsSortedUnorderArrays() {
        System.out.println("testIsSortedUnorderArrays");
        String[] a = string_unorder.clone();
        boolean expResult = false;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }
    
    
    //####################################################################
    
    @Test
    public void testSsortUnorderIntArrays() {
        System.out.println("testSsortUnorderIntArrays");
        int[] a = int_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testSsortOrderIntArrays() {
        System.out.println("testSsortOrderIntArrays");
        int[] a = int_order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testSsortVoidIntArrays() {
        System.out.println("testSsortVoidIntArrays");
        int[] a = int_void;
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_void);
    }
    
    @Test
    public void testSsortSingleIntArrays() {
        System.out.println("testSsortSingleIntArrays");
        int[] a = int_single;
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_single);
    }
     
    
    
    
    @Test
    public void testSsortUnorderArrays() {
        System.out.println("testSsortUnorderArrays");
        String[] a = string_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_order);
    }
    
    @Test
    public void testSsortOrderArrays() {
        System.out.println("testSsortOrderArrays");
        String[] a = string_order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_order);
    }
    
    @Test
    public void testSsortVoidArrays() {
        System.out.println("testSsortVoidArrays");
        String[] a = string_void;
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_void);
    }
    
    @Test
    public void testSsortSingleArrays() {
        System.out.println("testSsortSingleArrays");
        String[] a = string_single;
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_single);
    }
         
    //####################################################################
 
    @Test
    public void testIsortOrderIntArray() {
        System.out.println("testIsortOrderIntArray");
        int[] a = int_order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testIsortUnorderIntArray() {
        System.out.println("testIsortUnorderIntArray");
        int[] a = int_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testIsortVoidIntArray() {
        System.out.println("testIsortVoidIntArray");
        int[] a = int_void.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_void);
    }
    
    @Test
    public void testIsortSingleIntArray() {
        System.out.println("testIsortSingleIntArray");
        int[] a = int_single.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_single);
    }
    
    
        @Test
    public void testIsortOrderArray() {
        System.out.println("testIsortOrderArray");
        String[] a = string_order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_order);
    }
    
    @Test
    public void testIsortUnorderArray() {
        System.out.println("testIsortUnorderArray");
        String[] a = string_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_order);
    }
    
    @Test
    public void testIsortVoidArray() {
        System.out.println("testIsortVoidArray");
        String[] a = string_void.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_void);
    }
    
    @Test
    public void testIsortSingleArray() {
        System.out.println("testIsortSingleArray");
        String[] a = string_single.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_single);
    }
    
    //####################################################
    
    @Test
    public void testISortBinOrderIntArrays() {
        System.out.println("testISortBinOrderIntArrays");
        int[] a = int_order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
        @Test
    public void testISortBinUnorderIntArray() {
        System.out.println("testISortBinUnorderIntArray");
        int[] a = int_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
        @Test
    public void testISortBinVoidIntArray() {
        System.out.println("testISortBinVoidIntArray");
        int[] a = int_void.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_void);
    }
    
        @Test
    public void testISortBinSingleIntArray() {
        System.out.println("testISortBinSingleIntArray");
        int[] a = int_single.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_single);
    }
    
    
    
     @Test
    public void testISortBinOrderArrays() {
        System.out.println("testISortBinOrderArrays");
        String[] a = string_order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_order);
    }
    
        @Test
    public void testISortBinUnorderArray() {
        System.out.println("testISortBinUnorderArray");
        String[] a = string_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_order);
    }
    
        @Test
    public void testISortBinVoidArray() {
        System.out.println("testISortBinVoidArray");
        String[] a = string_void.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_void);
    }
    
        @Test
    public void testISortBinSingleArray() {
        System.out.println("testISortBinSingleArray");
        String[] a = string_single.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_single);
    }
    
    
    //######################################################

    @Test
    public void testMSortBasicOrderIntArrays() {
        System.out.println("testMSortBasicOrderIntArrays");
        int[] a = int_order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testMSortBasicUnorderIntArrays() {
        System.out.println("testMSortBasicUnorderIntArrays");
        int[] a = int_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testMSortBasicVoidIntArray() {
        System.out.println("testMSortBasicVoidIntArray");
        int[] a = int_void.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_void);
    }
    
    @Test
    public void testMSortBasicSingleIntArray() {
        System.out.println("testMSortBasicSingleIntArray");
        int[] a = int_single.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_single);
    }
    
    
        @Test
    public void testMSortBasicOrderArrays() {
        System.out.println("testMSortBasicOrderArrays");
        String[] a = string_order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_order);
    }
    
    @Test
    public void testMSortBasicUnorderArrays() {
        System.out.println("testMSortBasicUnorderArrays");
        String[] a = string_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_order);
    }
    
    @Test
    public void testMSortBasicVoidArray() {
        System.out.println("testMSortBasicVoidArray");
        String[] a = string_void.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_void);
    }
    
    @Test
    public void testMSortBasicSingleArray() {
        System.out.println("testMSortBasicSingleArray");
        String[] a = string_single.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, string_single);
    }
    
    //######################################################

    @Test
    public void testMSortNoGarbageOrderIntArrays() {
        System.out.println("testMSortNoGarbageOrderIntArrays");
        int[] a = int_order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortNoGarbage(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testMSortNoGarbageUnorderIntArrays() {
        System.out.println("testMSortNoGarbageUnorderIntArrays");
        int[] a = int_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortNoGarbage(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testMSortNoGarbageVoidIntArray() {
        System.out.println("testMSortNoGarbageVoidIntArray");
        int[] a = int_void.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortNoGarbage(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_void);
    }
    
    @Test
    public void testMSortNoGarbageSingleIntArray() {
        System.out.println("testMSortNoGarbageSingleIntArray");
        int[] a = int_single.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortNoGarbage(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_single);
    }
    
}
