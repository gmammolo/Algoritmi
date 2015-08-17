/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammolo.Java.mammolo.graph;

import mammolo.Java.mammolo.graph.BreadthFirstSearch;
import mammolo.Java.mammolo.graph.UndirectedGraph;
import mammolo.Java.mammolo.graph.SimpleCallback;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Giuseppe
 */
public class BreadthFirstSearchTest {
  
  UndirectedGraph<String, Integer> g;
  SimpleCallback callback;
  public BreadthFirstSearchTest() {
  }
  
  @Before
  public void setUp() {
    callback = new SimpleCallback();
    g = new UndirectedGraph<>();
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
   * Test of search method, of class BreadthFirstSearch.
   */
  @Test
  public void testSearch() {
    System.out.println("search");
    BreadthFirstSearch instance = new BreadthFirstSearch();
    instance.search(g,"A",callback);
    ArrayList<String> result = callback.getCoda();
    ArrayList<String> expResult = new ArrayList<>();
    expResult.add("A");
    expResult.add("B");
    expResult.add("C");
    expResult.add("D");
    expResult.add("E");
    assertEquals(expResult, result);
  }
  
}
