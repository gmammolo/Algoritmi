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
        int_unorder = new int[] {1,4,5,6,8,5,3,3,2,9,10,7,0};
        int_order = int_unorder.clone();
        Arrays.sort(int_order);
        
        string_unorder = new String[]{ "Batman", "Katy", "Drizzit", "Drizzit", "Pluto", "Batman", "Tartaglia",  "Batman", "Michelangelo"};
        string_order =string_unorder.clone();
        Arrays.sort(string_order);
        string_void = new String[0];
        string_single = new String[]{"Giuseppe"};
    }
    
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
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testSsortOrderIntArrays() {
        System.out.println("testSsortOrderIntArrays");
        int[] a = int_order.clone();
        Sorting.ssort(a);
        assertArrayEquals(int_order ,a );
    }
    
    @Test
    public void testSsortVoidIntArrays() {
        System.out.println("testSsortVoidIntArrays");
        int[] a = int_void.clone();
        Sorting.ssort(a);
        assertArrayEquals(int_void, a);
    }
    
    @Test
    public void testSsortSingleIntArrays() {
        System.out.println("testSsortSingleIntArrays");
        int[] a = int_single.clone();
        Sorting.ssort(a);
        assertArrayEquals(int_single, a);
    }

    @Test
    public void testSsortUnorderArrays() {
        System.out.println("testSsortUnorderArrays");
        String[] a = string_unorder.clone();
        Sorting.ssort(a);
        assertArrayEquals(string_order , a);
    }
    
    @Test
    public void testSsortOrderArrays() {
        System.out.println("testSsortOrderArrays");
        String[] a = string_order.clone();
        Sorting.ssort(a);
        assertArrayEquals(string_order, a);
    }
    
    @Test
    public void testSsortVoidArrays() {
        System.out.println("testSsortVoidArrays");
        String[] a = string_void.clone();
        Sorting.ssort(a);
        assertArrayEquals(string_void, a);
    }
    
    @Test
    public void testSsortSingleArrays() {
        System.out.println("testSsortSingleArrays");
        String[] a = string_single.clone();
        Sorting.ssort(a);
        assertArrayEquals(string_single,a);
    }
         
    //####################################################################
 
    @Test
    public void testIsortOrderIntArray() {
        System.out.println("testIsortOrderIntArray");
        int[] a = int_order.clone();
        Sorting.isort(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testIsortUnorderIntArray() {
        System.out.println("testIsortUnorderIntArray");
        int[] a = int_unorder.clone();
        Sorting.isort(a);
        Arrays.sort(int_unorder);
        assertArrayEquals(int_unorder, a);
    }
    
    @Test
    public void testIsortVoidIntArray() {
        System.out.println("testIsortVoidIntArray");
        int[] a = int_void.clone();
        Sorting.isort(a);
        assertArrayEquals(int_void, a);
    }
    
    @Test
    public void testIsortSingleIntArray() {
        System.out.println("testIsortSingleIntArray");
        int[] a = int_single.clone();
        Sorting.isort(a);
        assertArrayEquals(int_single, a);
    }
    
    
        @Test
    public void testIsortOrderArray() {
        System.out.println("testIsortOrderArray");
        String[] a = string_order.clone();
        Sorting.isort(a);
        assertArrayEquals(string_order, a);
    }
    
    @Test
    public void testIsortUnorderArray() {
        System.out.println("testIsortUnorderArray");
        String[] a = string_unorder.clone();
        Sorting.isort(a);
        assertArrayEquals(string_order, a );
    }
    
    @Test
    public void testIsortVoidArray() {
        System.out.println("testIsortVoidArray");
        String[] a = string_void.clone();
        Sorting.isort(a);
        assertArrayEquals(string_void, a);
    }
    
    @Test
    public void testIsortSingleArray() {
        System.out.println("testIsortSingleArray");
        String[] a = string_single.clone();
        Sorting.isort(a);
        assertArrayEquals(string_single, a);
    }
    
    //####################################################
    
    @Test
    public void testISortBinOrderIntArrays() {
        System.out.println("testISortBinOrderIntArrays");
        int[] a = int_order.clone();
        Sorting.iSortBin(a);
        assertArrayEquals(int_order, a);
    }
    
        @Test
    public void testISortBinUnorderIntArray() {
        System.out.println("testISortBinUnorderIntArray");
        int[] a = int_unorder.clone();
        Sorting.iSortBin(a);
        assertArrayEquals(int_order, a);
    }
    
        @Test
    public void testISortBinVoidIntArray() {
        System.out.println("testISortBinVoidIntArray");
        int[] a = int_void.clone();
        Sorting.iSortBin(a);
        assertArrayEquals(int_void, a);
    }
    
        @Test
    public void testISortBinSingleIntArray() {
        System.out.println("testISortBinSingleIntArray");
        int[] a = int_single.clone();
        Sorting.iSortBin(a);
        assertArrayEquals(int_single, a);
    }
    
    //######################################################

    @Test
    public void testMSortBasicOrderIntArrays() {
        System.out.println("testMSortBasicOrderIntArrays");
        int[] a = int_order.clone();
        Sorting.mSortBasic(a);
        assertArrayEquals(int_order, a );
    }
    
    @Test
    public void testMSortBasicUnorderIntArrays() {
        System.out.println("testMSortBasicUnorderIntArrays");
        int[] a = int_unorder.clone();
        Sorting.mSortBasic(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testMSortBasicVoidIntArray() {
        System.out.println("testMSortBasicVoidIntArray");
        int[] a = int_void.clone();
        Sorting.mSortBasic(a);
        assertArrayEquals(int_void, a );
    }
    
    @Test
    public void testMSortBasicSingleIntArray() {
        System.out.println("testMSortBasicSingleIntArray");
        int[] a = int_single.clone();
        Sorting.mSortBasic(a);
        assertArrayEquals(int_single, a);
    }
    

    //######################################################

    @Test
    public void testMSortNoGarbageOrderIntArrays() {
        System.out.println("testMSortNoGarbageOrderIntArrays");
        int[] a = int_order.clone();
        Sorting.mSortNoGarbage(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testMSortNoGarbageUnorderIntArrays() {
        System.out.println("testMSortNoGarbageUnorderIntArrays");
        int[] a = int_unorder.clone();
        Sorting.mSortNoGarbage(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testMSortNoGarbageVoidIntArray() {
        System.out.println("testMSortNoGarbageVoidIntArray");
        int[] a = int_void.clone();
        Sorting.mSortNoGarbage(a);
        assertArrayEquals(int_void, a);
    }
    
    @Test
    public void testMSortNoGarbageSingleIntArray() {
        System.out.println("testMSortNoGarbageSingleIntArray");
        int[] a = int_single.clone();
        Sorting.mSortNoGarbage(a);
        assertArrayEquals(int_single, a);
    }
    
    //##########################################
    
    @Test
    public void testQsortOrderIntArray() {
        System.out.println("testQsortOrderIntArray");
        int[] a = int_order.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testQsortUnorderIntArray() {
        System.out.println("testQsortUnorderIntArray");
        int[] a = int_unorder.clone();
        Sorting.qSortBasic(a);
        Arrays.sort(int_unorder);
        assertArrayEquals(int_unorder, a);
    }
    
    @Test
    public void testQsortVoidIntArray() {
        System.out.println("testQsortVoidIntArray");
        int[] a = int_void.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(int_void, a);
    }
    
    @Test
    public void testQsortSingleIntArray() {
        System.out.println("testQsortSingleIntArray");
        int[] a = int_single.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(int_single, a);
    }
    
    
    @Test
    public void testQsortOrderArray() {
        System.out.println("testQsortOrderArray");
        String[] a = string_order.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(string_order, a);
    }
    
    @Test
    public void testQsortUnorderArray() {
        System.out.println("testQsortUnorderArray");
        String[] a = string_unorder.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(string_order, a );
    }
    
    @Test
    public void testQsortVoidArray() {
        System.out.println("testQsortVoidArray");
        String[] a = string_void.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(string_void, a);
    }
    
    @Test
    public void testQsortSingleArray() {
        System.out.println("testIsortSingleArray");
        String[] a = string_single.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(string_single, a);
    }
    
    //###############################################à
    
       @Test
    public void testQsortHoareOrderIntArray() {
        System.out.println("testQsortHoareOrderIntArray");
        int[] a = int_order.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testQsortHoareUnorderIntArray() {
        System.out.println("testQsortHoareUnorderIntArray");
        int[] a = int_unorder.clone();
        Sorting.qSortHoare(a);
        Arrays.sort(int_unorder);
        assertArrayEquals(int_unorder, a);
    }
    
    @Test
    public void testQsortHoareVoidIntArray() {
        System.out.println("testQsortHoareVoidIntArray");
        int[] a = int_void.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(int_void, a);
    }
    
    @Test
    public void testQsortHoareSingleIntArray() {
        System.out.println("testQsortHoareSingleIntArray");
        int[] a = int_single.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(int_single, a);
    }
    
    
        
    @Test
    public void testQsortHoareOrderArray() {
        System.out.println("testQsortHoareOrderArray");
        String[] a = string_order.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(string_order, a);
    }
    
    @Test
    public void testQsortUHoarenorderArray() {
        System.out.println("testQsortHoareUnorderArray");
        String[] a = string_unorder.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(string_order, a );
    }
    
    @Test
    public void testQsortHoareVoidArray() {
        System.out.println("testQsortHoareVoidArray");
        String[] a = string_void.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(string_void, a);
    }
    
    @Test
    public void testQsortHoareSingleArray() {
        System.out.println("testIsortHoareSingleArray");
        String[] a = string_single.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(string_single, a);
    }
    
    
}
