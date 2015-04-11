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
    @Test
    public void testIsSortedVoidArrays() {
        //TOSEE: l'array int_void per definizione è int_order o no? Secondo me si
        System.out.println("testIsSortedVoidArrays");
        int[] a = int_void;
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsSortedSingleArrays() {
        //TOSEE: se c'è solo un elemento nell' array come fa a non essere int_order? Con un solo elemento infatti è ordinato
        System.out.println("testIsSortedSingleArrays");
        int[] a = int_single;
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }
   
    @Test
    public void testIsSortedOrderArrays() {
        System.out.println("testIsSortedOrderArrays");
        int[] a = int_order.clone();
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }

     @Test
    public void testIsSortedUnorderArrays() {
        System.out.println("testIsSortedUnorderArrays");
        int[] a = int_unorder.clone();
        boolean expResult = false;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }
    
    //####################################################################
    
    @Test
    public void testSsortUnorderArrays() {
        System.out.println("testSsortUnorderArrays");
        int[] a = int_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testSsortOrderArrays() {
        System.out.println("testSsortOrderArrays");
        int[] a = int_order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testSsortVoidArrays() {
        System.out.println("testSsortVoidArrays");
        int[] a = int_void;
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_void);
    }
    
    @Test
    public void testSsortSingleArrays() {
        System.out.println("testSsortSingleArrays");
        int[] a = int_single;
        System.out.println(Arrays.toString(a));
        Sorting.ssort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_single);
    }
     
    //####################################################################
 
    @Test
    public void testIsortOrderArray() {
        System.out.println("testIsortOrderArray");
        int[] a = int_order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testIsortUnorderArray() {
        System.out.println("testIsortUnorderArray");
        int[] a = int_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testIsortVoidArray() {
        System.out.println("testIsortVoidArray");
        int[] a = int_void.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_void);
    }
    
    @Test
    public void testIsortSingleArray() {
        System.out.println("testIsortSingleArray");
        int[] a = int_single.clone();
        System.out.println(Arrays.toString(a));
        Sorting.isort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_single);
    }
    
    //####################################################
    
    @Test
    public void testISortBinOrderArrays() {
        System.out.println("testISortBinOrderArrays");
        int[] a = int_order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
        @Test
    public void testISortBinUnorderArray() {
        System.out.println("testISortBinUnorderArray");
        int[] a = int_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
        @Test
    public void testISortBinVoidArray() {
        System.out.println("testISortBinVoidArray");
        int[] a = int_void.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_void);
    }
    
        @Test
    public void testISortBinSingleArray() {
        System.out.println("testISortBinSingleArray");
        int[] a = int_single.clone();
        System.out.println(Arrays.toString(a));
        Sorting.iSortBin(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_single);
    }
    
    //######################################################

    @Test
    public void testMSortBasicOrderArrays() {
        System.out.println("testMSortBasicOrderArrays");
        int[] a = int_order.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testMSortBasicUnorderArrays() {
        System.out.println("testMSortBasicUnorderArrays");
        int[] a = int_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_order);
    }
    
    @Test
    public void testMSortBasicVoidArray() {
        System.out.println("testMSortBasicVoidArray");
        int[] a = int_void.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_void);
    }
    
    @Test
    public void testMSortBasicSingleArray() {
        System.out.println("testMSortBasicSingleArray");
        int[] a = int_single.clone();
        System.out.println(Arrays.toString(a));
        Sorting.mSortBasic(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, int_single);
    }
    
}
