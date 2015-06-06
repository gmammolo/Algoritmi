/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.graph;

import java.util.Collection;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Giuseppe
 */
public class SparseGraphTest {
  
  SparseGraph<String, Integer> g;
  
  public SparseGraphTest() {
  }
  
  @Before
  public void setUp() {
    g = new SparseGraph<>();
    g.addVertex("A");
    g.addVertex("B");
    g.addVertex("C");
    g.addVertex("D");
    g.addVertex("E");
    
    g.addEdge("A", "B", 1);
    g.addEdge("A", "C", 2);
    g.addEdge("A", "D", 5);
    g.addEdge("B", "C", 3);
    g.addEdge("B", "D", 1);
    g.addEdge("E", "C", 3);
    g.addEdge("D", "E", 4);
    
    
  }

  /**
   * Test of addVertex method, of class SparseGraph.
   */
  @Test
  public void testAddVertex() {
    System.out.println("addVertex");
    Object vertex = null;
    SparseGraph instance = new SparseGraph();
    instance.addVertex("A");
    boolean expResult = true;
    assertEquals(expResult, instance.hasVertex("A"));
  }

  /**
   * Test of addEdge method, of class SparseGraph.
   */
  @Test
  public void testAddEdge() {
    System.out.println("addEdge");
    Object vertex1 = "A";
    Object vertex2 = "B";
    Object data = 5;
    SparseGraph instance = new SparseGraph();
    instance.addVertex(vertex1);
    instance.addVertex(vertex2);
    boolean result = instance.addEdge(vertex1, vertex2, data);
    assertEquals(true, result);
    assertEquals(true, instance.hasEdge(vertex1, vertex2));
  }

  /**
   * Test of hasVertex method, of class SparseGraph.
   */
  @Test
  public void testHasVertex() {
    System.out.println("hasVertex");
    String vertex = "A";
    boolean result = g.hasVertex(vertex);
    assertEquals(true, result);
  }

  @Test
  public void testHasVertexEEmpty() {
    System.out.println("hasVertex");
    String vertex = "Q";
    boolean result = g.hasVertex(vertex);
    assertEquals(false, result);
  }
  
  /**
   * Test of hasEdge method, of class SparseGraph.
   */
  @Test
  public void testHasEdge() {
    System.out.println("hasEdge");
    String vertex1 = "A";
    String vertex2 = "B";
    boolean result = g.hasEdge(vertex1, vertex2);
    assertEquals(true, result);
  }

  @Test
  public void testHasEdgeEmpty() {
    System.out.println("hasEdge");
    String vertex1 = "A";
    String vertex2 = "E";
    boolean result = g.hasEdge(vertex1, vertex2);
    assertEquals(false, result);
  }
  
  /**
   * Test of getData method, of class SparseGraph.
   */
  @Test
  public void testGetData() {
    System.out.println("getData");
    Object result = g.getData("A", "B");
    assertEquals(1, result);
  }

  /**
   * Test of getVertices method, of class SparseGraph.
   */
  @Test
  public void testGetVertices() {
    System.out.println("getVertices");
    SparseGraph instance = new SparseGraph();
    Set expResult = null;
    Set result = instance.getVertices();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getNeighbors method, of class SparseGraph.
   */
  @Test
  public void testGetNeighbors() {
    System.out.println("getNeighbors");
    SparseGraph instance = new SparseGraph();
    Collection expResult = null;
    Collection result = instance.getNeighbors("A");
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of toDot method, of class SparseGraph.
   */
//  @Test
//  public void testToDot() {
//    System.out.println("toDot");
//    String name = "Grafo";
//    System.out.println( g.toDot(name));
//  }
  
}
