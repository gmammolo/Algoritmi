/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.binarysearch;

import granatamammolo.Java.granatamammolo.binarysearch.IntSortedArray;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Giuseppe
 */
public class IntSortedArrayTest {
    

    
    public IntSortedArrayTest() {
    }

    /**
     * Test of size method, of class IntSortedArray.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        System.out.println("\tTest Array Vuoto;");
        IntSortedArray instance = new IntSortedArray();
        assertEquals(0, instance.size());
        
        System.out.println("\tTest Array Un Elemento;");
        instance = new IntSortedArray(new int[]{0});
        assertEquals(1, instance.size());
        
        System.out.println("\tTest Array Pieno;");
        instance = new IntSortedArray(new int[]{0,2,4,5,8,7,4});
        assertEquals(7, instance.size());
    }
    
    
    /**
     * Test of insert method, of class IntSortedArray.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        
        System.out.println("\t Inserimento ad array Vuoto");
        IntSortedArray instance = new IntSortedArray();
        int result = instance.insert(0);
        assertEquals("[0]", instance.toString());
        assertEquals(0, result);
        
        System.out.println("\t Inserimento All'ultimo posto");
        instance = new IntSortedArray(new int[]{0,1,2,3});
        result = instance.insert(4);
        assertEquals("[0, 1, 2, 3, 4]", instance.toString());
        assertEquals(4, result);
        
        System.out.println("\t Inserimento nel mezzo dell' Array");
        instance = new IntSortedArray(new int[]{0,1,5,3});
        result = instance.insert(2);
        assertEquals("[0, 1, 2, 3, 5]", instance.toString());
        assertEquals(2, result);
    }

    /**
     * Test of get method, of class IntSortedArray.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        
        
        IntSortedArray instance = new IntSortedArray(new int[]{5});
        assertEquals(5, instance.get(0));
        
        instance = new IntSortedArray(new int[]{5,3,4,5,6});
        assertEquals(3, instance.get(0));
        assertEquals(5, instance.get(3));
    }

    /**
     * Test of testIndexOf method, of class IntSortedArray.
     */
    @Test
    public void TestIndexOf() {
        System.out.println("indexOf");
        IntSortedArray instance = new IntSortedArray(new int[]{0,4,3,5,6,7,2});
        System.out.println(instance.toString());
        int index = instance.indexOf(0);
        assertEquals(0 ,instance.indexOf(0) );
        assertEquals(1 ,instance.indexOf(2) );
        assertEquals(2, instance.indexOf(3) );
        assertEquals(4, instance.indexOf(5) );
    }

    /**
     * Test of toString method, of class IntSortedArray.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        IntSortedArray instance = new IntSortedArray(new int[]{0,3});
        String expResult = "[0, 3]";
        assertEquals(expResult, instance.toString());
        instance = new IntSortedArray(new int[]{0});
        assertEquals("[0]", instance.toString());
        instance = new IntSortedArray();
        assertEquals("[]", instance.toString());
    }
    
}
