/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammolo.dictionary;

import mammolo.dictionary.SearchTree;
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
     * Test of printInOrder method, of class SearchTree.
     */
    @Test
    public void testPrintInOrderEmpty() {
        System.out.println("printInOrder");
        SearchTree instance = new SearchTree();
        String res = instance.printInOrder();
        assertEquals("[]", res);
    }

        @Test
    public void testPrintInOrder() {
        System.out.println("printInOrder");
        System.out.println(tree.printInOrder());
        //exp= [ (1)  (2)  (3)  (5)  (8)  (9) ]
        String res = tree.printInOrder();
        assertEquals("[ (1)  (2)  (3)  (5)  (8)  (9) ]", res);
    }

    

    @Test
    public void testIsEmptyEmpty() {
        System.out.println("isEmpty");
        SearchTree<Integer,String> instance = new SearchTree<>();
        boolean expResult = true;
        boolean result = instance.isEmpty();
    }

    @Test
    public void testIsEmptyNotEmpty() {
      System.out.println("isEmpty");
      boolean expResult = false;
      boolean result = tree.isEmpty();
      assertEquals(expResult, result);
    }

    
    /**
     * Test of minKey method, of class SearchTree.
     */
    @Test
    public void testMinKey() {
        System.out.println("minKey");
        Integer expResult = 1;
        Comparable result = tree.minKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of maxKey method, of class SearchTree.
     */
    @Test
    public void testMaxKey() {
        System.out.println("maxKey");
        Integer expResult = 9;
        Comparable result = tree.maxKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of elementOfMinKey method, of class SearchTree.
     */
    @Test
    public void testElementOfMinKey() {
        System.out.println("elementOfMinKey");
        String expResult = "1";
        Object result = tree.elementOfMinKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of elementOfMaxKey method, of class SearchTree.
     */
    @Test
    public void testElementOfMaxKey() {
        System.out.println("elementOfMaxKey");
        String expResult = "9";
        Object result = tree.elementOfMaxKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of find method, of class SearchTree.
     */
    @Test
    public void testFindNormal() {
        System.out.println("find");
        Integer key = 3;
        String expResult = "3";
        Object result = tree.find(key);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFindVoid() {
        System.out.println("find");
        Integer key = 3;
        SearchTree instance = new SearchTree();
        String expResult = null;
        Object result = instance.find(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class SearchTree.
     */
    @Test
    public void testAddVoid() {
      System.out.println("add");
      SearchTree<Integer,String> instance = new SearchTree<>();

      String ret = (String) instance.add(1, "1");
      String expResult = "1";
      assertEquals(expResult, ret);
      assertEquals(expResult, instance.find(1));
    }

    @Test
    public void testAddNormal() {
        System.out.println("add");
        
        String ret =(String) tree.add(6, "6");
        String expResult = "6";
        assertEquals(expResult, ret);
        assertEquals(expResult, tree.find(6));
    }
    
    @Test
    public void testAddMinElement() {
        System.out.println("add");
        
        String ret =(String) tree.add(0, "0");
        String expResult = "0";
        assertEquals(expResult, ret);
        assertEquals(expResult, tree.elementOfMinKey());
    }
    
    
        @Test
    public void testAddMaxElement() {
        System.out.println("add");
        
        String ret =(String) tree.add(12, "12");
        String expResult = "12";
        assertEquals(expResult, ret);
        assertEquals(expResult, tree.elementOfMaxKey());
    }
    
    @Test
    public void testRemoveVoid() {
        System.out.println("remove");
        Integer key = 1;
        SearchTree instance = new SearchTree();
        instance.remove(key);
        assertEquals(null, instance.find(key));
    }
    
    @Test
    public void testRemoveExist() {
      System.out.println("remove");
      Integer key = 1;
      tree.remove(key);
      System.out.println("test" + tree.printInOrder());
      assertEquals(null, tree.find(key));
    }
    
     @Test
    public void testRemoveNotExist() {
      System.out.println("remove");
      Integer key = 7;
      tree.remove(key);
      assertEquals(null, tree.find(key));
    }
    
}
