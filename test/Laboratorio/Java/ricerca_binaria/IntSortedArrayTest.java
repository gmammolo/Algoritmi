/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio.Java.ricerca_binaria;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author giuseppe
 */
public class IntSortedArrayTest {
    
    public IntSortedArrayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ricercaBinaria method, of class IntSortedArray.
     */
    @Test
    public void testRicercaBinaria() {
        System.out.println("ricercaBinaria");
        int search = 0;
        IntSortedArray instance = new IntSortedArray();
        int expResult = 0;
        int result = instance.ricercaBinaria(search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterativeRicercaBinaria method, of class IntSortedArray.
     */
    @Test
    public void testIterativeRicercaBinaria() {
        System.out.println("iterativeRicercaBinaria");
        int search = 0;
        IntSortedArray instance = new IntSortedArray();
        int expResult = 0;
        int result = instance.iterativeRicercaBinaria(search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class IntSortedArray.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        IntSortedArray instance = new IntSortedArray();
        int expResult = 16;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recursiveRicercaBinaria method, of class IntSortedArray.
     */
    @Test
    public void testRecursiveRicercaBinaria() {
        System.out.println("recursiveRicercaBinaria");
        int search = 0;
        IntSortedArray instance = new IntSortedArray();
        int expResult = 0;
        int result = instance.recursiveRicercaBinaria(search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class IntSortedArray.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        int element = 0;
        IntSortedArray instance = new IntSortedArray();
        instance.insert(1);instance.insert(1);instance.insert(2);
        instance.insert(element);
        int[] expResult = new int[]{0,1,1,2};
        assertEquals(expResult, instance);
    }

    /**
     * Test of get method, of class IntSortedArray.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        IntSortedArray instance = new IntSortedArray();
        instance.insert(2);instance.insert(1);instance.insert(0);
        int expResult = 0;
        int result = instance.get(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of indexOf method, of class IntSortedArray.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        int element = 1;
        IntSortedArray instance = new IntSortedArray();
        instance.insert(0);instance.insert(1);instance.insert(2);
        int expResult = 1;
        int result = instance.indexOf(element);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class IntSortedArray.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        IntSortedArray instance = new IntSortedArray();
        instance.insert(0);instance.insert(1);instance.insert(2);
        String expResult = "[ 0 , 1 , 2 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
