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
    protected int[] int_unorder,int_order,int_void,int_single,int_decrescent, int_ord_decrescent;
    protected String[] string_unorder,string_order,string_void,string_single;
     
    public SortingTest() {
    }
    
    @Before
    public void setUp() {
        int_void = new int[0];
        int_single= new int[]{1};
        int_unorder = new int[] {1,1,1,4,5,6,8,1,2,1,5,3,3,3,3,4,4,2,9,10,7,0};
        
        int_order = int_unorder.clone();
        Arrays.sort(int_order);
        
        int_decrescent = new int[]{10,10,10,9,9,9,9,7,7,7,6,5,4,4,4,3,2,2,1,0};
        int_ord_decrescent = int_decrescent.clone();
        Arrays.sort(int_ord_decrescent);
        
        string_unorder = new String[]{ "Batman", "Katy", "Drizzit", "Drizzit", "Pluto", "Batman", "Tartaglia",  "Batman", "Michelangelo"};
        string_order =string_unorder.clone();
        Arrays.sort(string_order);
        string_void = new String[0];
        string_single = new String[]{"Giuseppe"};
    }
        
    // <editor-fold defaultstate="collapsed" desc=" IsSorted">
    
    
    @Test
    public void testIsSorted_VoidIntArrays() {
        System.out.println("testIsSorted_VoidIntArrays");
        int[] a = int_void;
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsSorted_SingleIntArrays() {
        System.out.println("testIsSorted_SingleIntArrays");
        int[] a = int_single;
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }
   
    @Test
    public void testIsSorted_OrderIntArrays() {
        System.out.println("testIsSorted_OrderIntArrays");
        int[] a = int_order.clone();
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }

     @Test
    public void testIsSorted_UnorderIntArrays() {
        System.out.println("testIsSorted_UnorderIntArrays");
        int[] a = int_unorder.clone();
        boolean expResult = false;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }
    
    
     @Test
    public void testIsSorted_VoidArrays() {
        System.out.println("testIsSorted_VoidArrays");
        String[] a = string_void;
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsSorted_SingleArrays() {
        System.out.println("testIsSorted_SingleArrays");
        String[] a = string_single;
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }
   
    @Test
    public void testIsSorted_OrderArrays() {
        System.out.println("testIsSorted_OrderArrays");
        String[] a = string_order.clone();
        boolean expResult = true;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }

     @Test
    public void testIsSorted_UnorderArrays() {
        System.out.println("testIsSorted_UnorderArrays");
        String[] a = string_unorder.clone();
        boolean expResult = false;
        boolean result = Sorting.isSorted(a);
        assertEquals(expResult, result);
    }
    
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" SSort">
    
    @Test
    public void testSSort_UnorderIntArrays() {
        System.out.println("testSSort_UnorderIntArrays");
        int[] a = int_unorder.clone();
        System.out.println(Arrays.toString(a));
        Sorting.sSort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testSSort_OrderIntArrays() {
        System.out.println("testSSort_OrderIntArrays");
        int[] a = int_order.clone();
        Sorting.sSort(a);
        assertArrayEquals(int_order ,a );
    }
    
    @Test
    public void testSSort_VoidIntArrays() {
        System.out.println("testSSort_VoidIntArrays");
        int[] a = int_void.clone();
        Sorting.sSort(a);
        assertArrayEquals(int_void, a);
    }
    
    @Test
    public void testSSort_SingleIntArrays() {
        System.out.println("testSSort_SingleIntArrays");
        int[] a = int_single.clone();
        Sorting.sSort(a);
        assertArrayEquals(int_single, a);
    }
    
    @Test
    public void testSSort_DecrescentIntArrays() {
        System.out.println("testSSort_DecrescentIntArrays");
        int[] a = int_decrescent.clone();
        Sorting.sSort(a);
        assertArrayEquals(int_ord_decrescent, a);
    }

    @Test
    public void testSSort_UnorderArrays() {
        System.out.println("testSSort_UnorderArrays");
        String[] a = string_unorder.clone();
        Sorting.sSort(a);
        assertArrayEquals(string_order , a);
    }
    
    @Test
    public void testSSort_OrderArrays() {
        System.out.println("testSSort_OrderArrays");
        String[] a = string_order.clone();
        Sorting.sSort(a);
        assertArrayEquals(string_order, a);
    }
    
    @Test
    public void testSSort_VoidArrays() {
        System.out.println("testSSort_VoidArrays");
        String[] a = string_void.clone();
        Sorting.sSort(a);
        assertArrayEquals(string_void, a);
    }
    
    @Test
    public void testSSort_SingleArrays() {
        System.out.println("testSSort_SingleArrays");
        String[] a = string_single.clone();
        Sorting.sSort(a);
        assertArrayEquals(string_single,a);
    }
       
    // </editor-fold >
    
    // <editor-fold defaultstate="collapsed" desc=" ISort">
 
    @Test
    public void testISort_OrderIntArrays() {
        System.out.println("testISort_OrderIntArrays");
        int[] a = int_order.clone();
        Sorting.iSort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testISort_UnorderIntArrays() {
        System.out.println("testISort_UnorderIntArrays");
        int[] a = int_unorder.clone();
        System.out.println(Arrays.toString(int_unorder));
        Sorting.iSort(a);
        System.out.println(Arrays.toString(a));
        Arrays.sort(int_unorder);
        assertArrayEquals(int_unorder, a);
    }
    
    @Test
    public void testISort_VoidIntArrays() {
        System.out.println("testISort_VoidIntArrays");
        int[] a = int_void.clone();
        Sorting.iSort(a);
        assertArrayEquals(int_void, a);
    }
    
    @Test
    public void testISort_SingleIntArrays() {
        System.out.println("testISort_SingleIntArrays");
        int[] a = int_single.clone();
        Sorting.iSort(a);
        assertArrayEquals(int_single, a);
    }
    
        @Test
    public void testISort_DecrescentIntArrays() {
        System.out.println("testISort_DecrescentIntArrays");
        int[] a = int_decrescent.clone();
        Sorting.iSort(a);
        assertArrayEquals(int_ord_decrescent, a);
    }
    
        @Test
    public void testISort_OrderArrays() {
        System.out.println("testISort_OrderArrays");
        String[] a = string_order.clone();
        Sorting.iSort(a);
        assertArrayEquals(string_order, a);
    }
    
    @Test
    public void testISort_UnorderArrays() {
        System.out.println("testISort_UnorderArrays");
        String[] a = string_unorder.clone();
        Sorting.iSort(a);
        assertArrayEquals(string_order, a );
    }
    
    @Test
    public void testISort_VoidArrays() {
        System.out.println("testISort_VoidArrays");
        String[] a = string_void.clone();
        Sorting.iSort(a);
        assertArrayEquals(string_void, a);
    }
    
    @Test
    public void testISort_SingleArrays() {
        System.out.println("testISort_SingleArrays");
        String[] a = string_single.clone();
        Sorting.iSort(a);
        assertArrayEquals(string_single, a);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" ISortBin">
    
    @Test
    public void testISortBin_OrderIntArrays() {
        System.out.println("testISortBin_OrderIntArrays");
        int[] a = int_order.clone();
        Sorting.iSortBin(a);
        assertArrayEquals(int_order, a);
    }
    
        @Test
    public void testISortBin_UnorderIntArray() {
        System.out.println("testISortBin_UnorderIntArray");
        int[] a = int_unorder.clone();
        Sorting.iSortBin(a);
        assertArrayEquals(int_order, a);
    }
    
        @Test
    public void testISortBin_VoidIntArray() {
        System.out.println("testISortBin_VoidIntArray");
        int[] a = int_void.clone();
        Sorting.iSortBin(a);
        assertArrayEquals(int_void, a);
    }
    
        @Test
    public void testISortBin_SingleIntArray() {
        System.out.println("testISortBin_SingleIntArray");
        int[] a = int_single.clone();
        Sorting.iSortBin(a);
        assertArrayEquals(int_single, a);
    }
    
            @Test
    public void testISortBin_DecrescentIntArray() {
        System.out.println("testISortBin_DecrescentIntArray");
        int[] a = int_decrescent.clone();
        Sorting.iSortBin(a);
        assertArrayEquals(int_ord_decrescent, a);
    }
    
    /// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" MSortBasic">

    @Test
    public void testMSortBasic_OrderIntArrays() {
        System.out.println("testMSortBasic_OrderIntArrays");
        int[] a = int_order.clone();
        Sorting.mSortBasic(a);
        assertArrayEquals(int_order, a );
    }
    
    @Test
    public void testMSortBasic_UnorderIntArrays() {
        System.out.println("testMSortBasic_UnorderIntArrays");
        int[] a = int_unorder.clone();
        Sorting.mSortBasic(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testMSortBasic_VoidIntArrays() {
        System.out.println("testMSortBasic_VoidIntArrays");
        int[] a = int_void.clone();
        Sorting.mSortBasic(a);
        assertArrayEquals(int_void, a );
    }
    
    @Test
    public void testMSortBasic_SingleIntArrays() {
        System.out.println("testMSortBasic_SingleIntArrays");
        int[] a = int_single.clone();
        Sorting.mSortBasic(a);
        assertArrayEquals(int_single, a);
    }
    
        @Test
    public void testMSortBasic_DecrescentIntArrays() {
        System.out.println("testMSortBasic_DecrescentIntArrays");
        int[] a = int_decrescent.clone();
        Sorting.mSortBasic(a);
        assertArrayEquals(int_ord_decrescent, a);
    }
    

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" MSortNoGarbage">

    @Test
    public void testMSortNoGarbage_OrderIntArrays() {
        System.out.println("testMSortNoGarbage_OrderIntArrays");
        int[] a = int_order.clone();
        Sorting.mSortNoGarbage(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testMSortNoGarbage_UnorderIntArrays() {
        System.out.println("testMSortNoGarbage_UnorderIntArrays");
        int[] a = int_unorder.clone();
        Sorting.mSortNoGarbage(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testMSortNoGarbage_VoidIntArrays() {
        System.out.println("testMSortNoGarbage_VoidIntArrays");
        int[] a = int_void.clone();
        Sorting.mSortNoGarbage(a);
        assertArrayEquals(int_void, a);
    }
    
    @Test
    public void testMSortNoGarbage_SingleIntArrays() {
        System.out.println("testMSortNoGarbage_SingleIntArrays");
        int[] a = int_single.clone();
        Sorting.mSortNoGarbage(a);
        assertArrayEquals(int_single, a);
    }
    
        @Test
    public void testMSortNoGarbage_DecrescentIntArrays() {
        System.out.println("testMSortNoGarbage_DecrescentIntArrays");
        int[] a = int_decrescent.clone();
        Sorting.mSortNoGarbage(a);
        assertArrayEquals(int_ord_decrescent, a);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" QSort">
    
    @Test
    public void testQSort_OrderIntArrays() {
        System.out.println("testQSort_OrderIntArrays");
        int[] a = int_order.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testQSort_UnorderIntArrays() {
        System.out.println("testQSort_UnorderIntArrays");
        int[] a = int_unorder.clone();
        Sorting.qSortBasic(a);
        Arrays.sort(int_unorder);
        assertArrayEquals(int_unorder, a);
    }
    
    @Test
    public void testQSort_VoidIntArrays() {
        System.out.println("testQSort_VoidIntArrays");
        int[] a = int_void.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(int_void, a);
    }
    
    @Test
    public void testQSort_SingleIntArrays() {
        System.out.println("testQSort_SingleIntArrays");
        int[] a = int_single.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(int_single, a);
    }
    
        @Test
    public void testQSort_DecrementIntArrays() {
        System.out.println("testQSort_DecrementIntArrays");
        int[] a = int_decrescent.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(int_ord_decrescent, a);
    }
    
    @Test
    public void testQSort_OrderArrays() {
        System.out.println("testQSort_OrderArrays");
        String[] a = string_order.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(string_order, a);
    }
    
    @Test
    public void testQSort_UnorderArrays() {
        System.out.println("testQSort_UnorderArrays");
        String[] a = string_unorder.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(string_order, a );
    }
    
    @Test
    public void testQSort_VoidArrays() {
        System.out.println("testQSort_VoidArrays");
        String[] a = string_void.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(string_void, a);
    }
    
    @Test
    public void testQSort_SingleArrays() {
        System.out.println("testQSort_SingleArrays");
        String[] a = string_single.clone();
        Sorting.qSortBasic(a);
        assertArrayEquals(string_single, a);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" QSortHoare">
    
    @Test
    public void testQSortHoare_OrderIntArrays() {
        System.out.println("testQSortHoare_OrderIntArrays");
        int[] a = int_order.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testQSortHoare_UnorderIntArrays() {
        System.out.println("testQSortHoare_UnorderIntArrays");
        int[] a = int_unorder.clone();
        Sorting.qSortHoare(a);
        Arrays.sort(int_unorder);
        assertArrayEquals(int_unorder, a);
    }
    
    @Test
    public void testQSort_HoareVoidIntArrays() {
        System.out.println("testQSort_HoareVoidIntArrays");
        int[] a = int_void.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(int_void, a);
    }
    
    @Test
    public void testQSortHoare_SingleIntArrays() {
        System.out.println("testQSortHoare_SingleIntArrays");
        int[] a = int_single.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(int_single, a);
    }
    
        @Test
    public void testQSortHoare_DecrescentIntArrays() {
        System.out.println("testQSortHoare_DecrescentIntArrays");
        int[] a = int_decrescent.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(int_ord_decrescent, a);
    }
        
    @Test
    public void testQSortHoare_OrderArrays() {
        System.out.println("testQSortHoare_OrderArrays");
        String[] a = string_order.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(string_order, a);
    }
    
    @Test
    public void testQSortHoare_UnorderArrays() {
        System.out.println("testQSortHoare_UnorderArrays");
        String[] a = string_unorder.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(string_order, a );
    }
    
    @Test
    public void testQSortHoare_VoidArrays() {
        System.out.println("testQSortHoare_VoidArrays");
        String[] a = string_void.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(string_void, a);
    }
    
    @Test
    public void testQSortHoare_SingleArrays() {
        System.out.println("testQSortHoare_SingleArrays");
        String[] a = string_single.clone();
        Sorting.qSortHoare(a);
        assertArrayEquals(string_single, a);
    }
    
    
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" MSortParallel">
    
       
    @Test
    public void testMSortParallel_OrderIntArrays() {
        System.out.println("testMSortParallel_OrderIntArrays");
        int[] a = int_order.clone();
        Sorting.parallelMergesort(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testMSortParallel_UnorderIntArrays() {
        System.out.println("testMSortParallel_UnorderIntArrays");
        int[] a = int_unorder.clone();
        Sorting.parallelMergesort(a);
        Arrays.sort(int_unorder);
        assertArrayEquals(int_unorder, a);
    }
    
    @Test
    public void testMSortParallel_VoidIntArrays() {
        System.out.println("testMSortParallel_VoidIntArrays");
        int[] a = int_void.clone();
        Sorting.parallelMergesort(a);
        assertArrayEquals(int_void, a);
    }
    
    @Test
    public void testMSortParallel_SingleIntArrays() {
        System.out.println("testMSortParallel_SingleIntArrays");
        int[] a = int_single.clone();
        Sorting.parallelMergesort(a);
        assertArrayEquals(int_single, a);
    }
    
        @Test
    public void testMSortParallel_DecrescentIntArrays() {
        System.out.println("testMSortParallel_DecrescentIntArrays");
        int[] a = int_decrescent.clone();
        Sorting.parallelMergesort(a);
        assertArrayEquals(int_ord_decrescent, a);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" QSortISort">
    
    @Test
    public void testQSortISort_OrderIntArrays() {
        System.out.println("testQSortISort_OrderIntArrays");
        int[] a = int_order.clone();
        Sorting.qSortHoareIsort(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testQSortISort_UnorderIntArrays() {
        System.out.println("testQSortISort_UnorderIntArrays");
        int[] a = int_unorder.clone();
        Sorting.qSortHoareIsort(a);
        Arrays.sort(int_unorder);
        assertArrayEquals(int_unorder, a);
    }
    
    @Test
    public void testQSortISort_VoidIntArrays() {
        System.out.println("testQSortISort_VoidIntArrays");
        int[] a = int_void.clone();
        Sorting.qSortHoareIsort(a);
        assertArrayEquals(int_void, a);
    }
    
    @Test
    public void testQSortISort_SingleIntArrays() {
        System.out.println("testQSortISort_SingleIntArrays");
        int[] a = int_single.clone();
        Sorting.qSortHoareIsort(a);
        assertArrayEquals(int_single, a);
    }
    
    
        @Test
    public void testQSortISort_DecrescentIntArrays() {
        System.out.println("testQSortISort_DecrescentIntArrays");
        int[] a = int_decrescent.clone();
        Sorting.qSortHoareIsort(a);
        assertArrayEquals(int_ord_decrescent, a);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" QSortParallel">
    
    @Test
    public void testQSortParallel_OrderIntArrays() {
        System.out.println("testQSortParallel_OrderIntArrays");
        int[] a = int_order.clone();
        Sorting.parallelQuicksort(a);
        assertArrayEquals(int_order, a);
    }
    
    @Test
    public void testQSortParallel_UnorderIntArrays() {
        System.out.println("testQSortParallel_UnorderIntArrays");
        int[] a = int_unorder.clone();
        Sorting.parallelQuicksort(a);
        Arrays.sort(int_unorder);
        assertArrayEquals(int_unorder, a);
    }
    
    @Test
    public void testQSortParallel_VoidIntArrays() {
        System.out.println("testQSortParallel_VoidIntArrays");
        int[] a = int_void.clone();
        Sorting.parallelQuicksort(a);
        assertArrayEquals(int_void, a);
    }
    
    @Test
    public void testQSortParallel_SingleIntArrays() {
        System.out.println("testQSortParallel_SingleIntArrays");
        int[] a = int_single.clone();
        Sorting.parallelQuicksort(a);
        assertArrayEquals(int_single, a);
    }
    
        @Test
    public void testQSortParallel_DecrescentIntArrays() {
        System.out.println("testQSortParallel_DecrescentIntArrays");
        int[] a = int_decrescent.clone();
        Sorting.parallelQuicksort(a);
        assertArrayEquals(int_ord_decrescent, a);
    }
    
    // </editor-fold>
}
