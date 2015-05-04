package granatamammolo.Java.granatamammolo.priorityqueue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Federica
 */
public class PriorityQueueStringDoubleSimpleTest {
  
  public PriorityQueueStringDoubleSimpleTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
////////////////////////////////////////////////////////////////////////////////
  /**
   * Test of add method, of class PriorityQueueStringDoubleSimple.
   * Casi da testare:
   * - elemento già esistente
   * - elemento non esistente e inserimento in prima posizione
   * - elemento non esistente e inserimento in ultima posizione
   * - elemento non esistente e inserimento in posizione interna
   */
  @Test
  public void testAdd_ExistingElement() {
    System.out.println("testAdd_ExistingElement");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    instance.add("Cucinare", 2.0);
    instance.add("Fare la doccia", 0.0);
    instance.add("Lavare i denti", 1.0);
    boolean ris = instance.add("Lavare i denti", 1.0);
    assertEquals(false, ris);
  }
  
  @Test
  public void testAdd_NotExistingElem_FirstPosition(){
    System.out.println("testAdd_NotExistingElem_FirstPosition");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    instance.add("Cucinare", 2.0);    
    instance.add("Lavare i denti", 1.0);
    instance.add("Fare la doccia", 0.0);
    String result = instance.first();
    assertEquals("Fare la doccia", result);
  }
  
  @Test
  public void testAdd_NotExistingElem_LastPosition(){
    System.out.println("testAdd_NotExistingElem_LastPosition");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();   
    instance.add("Lavare i denti", 1.0);
    instance.add("Fare la doccia", 0.0);
    boolean result = instance.add("Cucinare", 2.0);
    assertEquals(true, result);
    instance.removeFirst();
    instance.removeFirst();
    String res = instance.first();
    assertEquals("Cucinare", res);
  }
  
  @Test
  public void testAdd_NotExistingElem_MiddlePosition(){
    System.out.println("testAdd_NotExistingElem_MiddlePosition");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();   
    instance.add("Fare la doccia", 0.0);
    instance.add("Lavare i denti", 1.0);    
    instance.add("Cucinare", 2.0);;
    instance.removeFirst();
    String res = instance.first();
    assertEquals("Lavare i denti", res);
  }

////////////////////////////////////////////////////////////////////////////////
  /**
   * Test of first method, of class PriorityQueueStringDoubleSimple.
   * Casi da testare:
   * - Coda vuota
   * - Coda con qualche elemento
   */
  @Test
  public void testFirst_EmptyQueue() {
    System.out.println("testFirst_EmptyQueue");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    String expResult = null;
    String result = instance.first();
    assertEquals(expResult, result);
  }
  
  @Test
  public void testFirst_FullQueue() {
    System.out.println("testFirst_FullQueue");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    instance.add("Fare la doccia", 0.0);
    instance.add("Lavare i denti", 1.0);    
    instance.add("Cucinare", 2.0);
    String expResult = "Fare la doccia";
    String result = instance.first();
    assertEquals(expResult, result);
  }

////////////////////////////////////////////////////////////////////////////////

  /**
   * Test of removeFirst method, of class PriorityQueueStringDoubleSimple.
   * Casi da testare:
   * - coda vuota
   * - coda con qualche elemento
   */
  @Test
  public void testRemoveFirst_EmptyQueue() {
    System.out.println("testRemoveFirst_EmptyQueue");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    String expResult = null;
    String result = instance.removeFirst();
    assertEquals(expResult, result);
  }
  
  @Test
  public void testRemoveFirst_FullQueue() {
    System.out.println("testRemoveFirst_FullQueue");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    instance.add("Fare la doccia", 0.0);
    instance.add("Lavare i denti", 1.0);    
    instance.add("Cucinare", 2.0);
    String expResult = "Fare la doccia";
    String result = instance.removeFirst();
    assertEquals(expResult, result);
  }
  
////////////////////////////////////////////////////////////////////////////////

  /**
   * Test of isEmpty method, of class PriorityQueueStringDoubleSimple.
   * Casi da testare:
   * - la coda è vuota
   * - la coda non è vuota
   */
  @Test
  public void testIsEmpty_EmptyQueue() {
    System.out.println("testIsEmpty_EmptyQueue");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    boolean expResult = true;
    boolean result = instance.isEmpty();
    assertEquals(expResult, result);
  }
  
  @Test
  public void testIsEmpty_FullQueue() {
    System.out.println("testIsEmpty_FullQueue");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    instance.add("Fare la doccia", 0.0);
    instance.add("Lavare i denti", 1.0);    
    instance.add("Cucinare", 2.0);
    boolean result = instance.isEmpty();
    assertEquals(false, result);
  }
  
////////////////////////////////////////////////////////////////////////////////

  /**
   * Test of delete method, of class PriorityQueueStringDoubleSimple.
   * Casi da testare:
   * - coda vuota
   * - elemento non presente
   * - elemento presente e in prima posizione
   * - elemento presente e in ultima posizione
   * - elemento presente e in posizione interna
   */
  @Test
  public void testDelete_EmptyQueue() {
    System.out.println("testDelete_EmptyQueue");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    String element = "Cucinare";
    boolean result = instance.delete(element);
    assertEquals(false, result);
  }
  
  @Test
  public void testDelete_NotExistingElement() {
    System.out.println("testDelete_NotExistingElement");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    instance.add("Fare la doccia", 0.0);
    instance.add("Lavare i denti", 1.0);    
    instance.add("Cucinare", 2.0);
    String element = "Vestirsi";
    boolean result = instance.delete(element);
    assertEquals(false, result);
  }
  
  @Test
  public void testDelete_ExistingElement_FirstPosition() {
    System.out.println("testDelete_ExistingElement_FirstPosition");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    instance.add("Fare la doccia", 0.0);
    instance.add("Lavare i denti", 1.0);    
    instance.add("Cucinare", 2.0);
    String element = "Fare la doccia";
    boolean result = instance.delete(element);
    assertEquals(true, result);
    String first = instance.first();
    assertEquals("Lavare i denti", first);
  }
  
  @Test
  public void testDelete_ExistingElement_LastPosition() {
    System.out.println("testDelete_ExistingElement_LastPosition");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    instance.add("Fare la doccia", 0.0);
    instance.add("Lavare i denti", 1.0);    
    instance.add("Cucinare", 2.0);
    String element = "Cucinare";
    boolean result = instance.delete(element);
    assertEquals(true, result);
    instance.removeFirst();
    instance.removeFirst();
    boolean res = instance.isEmpty();
    assertEquals(true, res);
  }
  
  @Test
  public void testDelete_ExistingElement_MiddlePosition() {
    System.out.println("testDelete_ExistingElement_MiddlePosition");
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    instance.add("Fare la doccia", 0.0);
    instance.add("Lavare i denti", 1.0);    
    instance.add("Cucinare", 2.0);
    
    String element = "Lavare i denti";
    boolean result = instance.delete(element);
    assertEquals(true, result);
    
    String res = instance.first();
    String expResult = "Fare la doccia";
    assertEquals(expResult, res);
    
    instance.removeFirst();
    res = instance.first();
    expResult = "Cucinare";
    assertEquals(expResult, res);
  }

///////////////////////////////////////////////////////////////////////////////
  
  /**
   * Test of setPriority method, of class PriorityQueueStringDoubleSimple.
   * Casi da testare:
   * - nuova priorità uguale alla precedente
   * - nuova priorità minore di zero
   * - nuova priorità corretta
   * - priorità di un elemento non presente
   */
  @Test(expected = IllegalArgumentException.class)  
  public void testSetPriority_UnderZero() {   
    System.out.println("testSetPriority_UnderZero");        
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    instance.add("Fare la doccia", 0.0);
    instance.add("Lavare i denti", 1.0);    
    instance.add("Cucinare", 2.0);
    boolean result = instance.setPriority("Lavare i denti", -1.0);
    assertEquals(false, result);
  }
  
  @Test
  public void testSetPriority_RepeatPriority() {       
    System.out.println("testSetPriority_UnderZero");        
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    instance.add("Fare la doccia", 0.0);
    instance.add("Lavare i denti", 1.0);    
    instance.add("Cucinare", 2.0);
    boolean result = instance.setPriority("Lavare i denti", 1.0);
    assertEquals(true, result);
    // TOSEE_GIUSE : vorrei testare la priorità
  }
  
  @Test
  public void testSetPriority_RightPriority() {       
    System.out.println("testSetPriority_UnderZero");        
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    instance.add("Fare la doccia", 0.0);
    instance.add("Lavare i denti", 1.0);    
    instance.add("Cucinare", 2.0);
    boolean result = instance.setPriority("Lavare i denti", 3.0);
    assertEquals(true, result);
    // TOSEE_GIUSE : vorrei testare la nuova priorità
  }
  
  @Test
  public void testSetPriority_NotExistingElement() {
    System.out.println("testSetPriority_NotExistingElement");
    String element = "primo";
    double priority = 0.0;
    PriorityQueueStringDoubleSimple instance = new PriorityQueueStringDoubleSimple();
    boolean expResult = false;
    boolean result = instance.setPriority(element, priority);
    assertEquals(expResult, result);
  }
}
