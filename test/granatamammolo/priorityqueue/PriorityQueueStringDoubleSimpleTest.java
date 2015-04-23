/*
* TOSEE: buon divertimento con i test xD
 */
package granatamammolo.priorityqueue;

import granatamammolo.Java.priorityqueue.PriorityQueueStringDoubleSimple;
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
public class PriorityQueueStringDoubleSimpleTest {
    
    PriorityQueueStringDoubleSimple queue;
    
    public PriorityQueueStringDoubleSimpleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        queue = new PriorityQueueStringDoubleSimple();
        queue.add("Lavare i denti", 1.0);
        queue.add("Fare il Bucato", 5.0);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class PriorityQueueStringDoubleSimple.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String element = "";
        double priority = 0.0;
        PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
        boolean expResult = false;
        boolean result = instance.add(element, priority);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of first method, of class PriorityQueueStringDoubleSimple.
     */
    @Test
    public void testFirst() {
        System.out.println("first");
        String expResult = "Lavare i denti";
        String result = queue.first();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeFirst method, of class PriorityQueueStringDoubleSimple.
     */
    @Test
    public void testRemoveFirst() {
        System.out.println("removeFirst");
        PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
        String expResult = "";
        String result = instance.removeFirst();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class PriorityQueueStringDoubleSimple.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class PriorityQueueStringDoubleSimple.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String element = "";
        PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
        boolean expResult = false;
        boolean result = instance.delete(element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPriority method, of class PriorityQueueStringDoubleSimple.
     */
    @Test
    public void testSetPriority() {
        System.out.println("setPriority");
        String element = "";
        double priority = 0.0;
        PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
        boolean expResult = false;
        boolean result = instance.setPriority(element, priority);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
