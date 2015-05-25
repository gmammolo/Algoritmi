/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.dictionary;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Giuseppe
 */
public class SearchTreeTest {
     
    SearchTree<Integer,String> tree;
    
    public SearchTreeTest() {
    }
    
    @Before
    public void setUp() {
        tree = new SearchTree<>();
        tree.add(5, "5");
        tree.add(2, "2");
        tree.add(1, "1");
        tree.add(3, "3");
        tree.add(8, "8");
        tree.add(9, "9");
    }

    /**
     * Test of printPreOrder method, of class SearchTree.
     */
    @Test
    public void testPrintPreOrder() {
        System.out.println("printPreOrder");
        SearchTree.Node node = null;
        SearchTree instance = new SearchTree();
        instance.printPreOrder(node);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printInOrder method, of class SearchTree.
     */
    @Test
    public void testPrintInOrder() {
        System.out.println("printInOrder");
        SearchTree.Node node = null;
        SearchTree instance = new SearchTree();
        instance.printInOrder(node);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class SearchTree.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SearchTree instance = new SearchTree();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minKey method, of class SearchTree.
     */
    @Test
    public void testMinKey() {
        System.out.println("minKey");
        SearchTree instance = new SearchTree();
        Comparable expResult = null;
        Comparable result = instance.minKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of maxKey method, of class SearchTree.
     */
    @Test
    public void testMaxKey() {
        System.out.println("maxKey");
        SearchTree instance = new SearchTree();
        Comparable expResult = null;
        Comparable result = instance.maxKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elementOfMinKey method, of class SearchTree.
     */
    @Test
    public void testElementOfMinKey() {
        System.out.println("elementOfMinKey");
        SearchTree instance = new SearchTree();
        Object expResult = null;
        Object result = instance.elementOfMinKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elementOfMaxKey method, of class SearchTree.
     */
    @Test
    public void testElementOfMaxKey() {
        System.out.println("elementOfMaxKey");
        SearchTree instance = new SearchTree();
        Object expResult = null;
        Object result = instance.elementOfMaxKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class SearchTree.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        Object key = null;
        SearchTree instance = new SearchTree();
        Object expResult = null;
        Object result = instance.find(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class SearchTree.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object key = null;
        Object value = null;
        SearchTree instance = new SearchTree();
        Object expResult = null;
        Object result = instance.add(key, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class SearchTree.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object key = null;
        SearchTree instance = new SearchTree();
        instance.remove(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
