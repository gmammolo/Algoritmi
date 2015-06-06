/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.kruskal;


import granatamammolo.Java.granatamammolo.graph.UndirectedGraph;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleSupplier;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Giuseppe
 */
public class MinimalSpanningTreeKruskalTest {
  
  UndirectedGraph<String, DoubleSupplier> g;
  
  public MinimalSpanningTreeKruskalTest() {
  }
  
  @Before
  public void setUp() {

    g = new UndirectedGraph<>();
    g.addVertex("A");
    g.addVertex("B");
    g.addVertex("C");
    g.addVertex("D");
    g.addVertex("E");
    
    g.addEdge("A", "B", new DoubleValue(1));
    g.addEdge("A", "C", new DoubleValue(2));
    g.addEdge("A", "D", new DoubleValue(5));
    g.addEdge("B", "C", new DoubleValue(3));
    g.addEdge("B", "D", new DoubleValue(1));
    g.addEdge("E", "C", new DoubleValue(3));
    g.addEdge("D", "E", new DoubleValue(4));
    
  }

  /**
   * Test of build method, of class MinimalSpanningTreeKruska.
   */
  @Test
  public void testBuild() throws Exception {
    System.out.println("build");
    MinimalSpanningTreeKruskal instance = new MinimalSpanningTreeKruskal();
//    List<MinimalSpanningTreeKruska.Edge> expResult = null;
    List<Edge> result = instance.build(g);
    ArrayList<Edge> expResult = new ArrayList<>();
    expResult.add(new Edge<String,DoubleValue>("A", "B", new DoubleValue(1)));
    expResult.add(new Edge<String,DoubleValue>("B", "D", new DoubleValue(1)));
    expResult.add(new Edge<String,DoubleValue>("A", "C", new DoubleValue(2)));
    expResult.add(new Edge<String,DoubleValue>("C", "E", new DoubleValue(3)));
    assertEquals(expResult, result);
   //System.out.println( g.toDot("Grafo"));
    
  }
  
}
