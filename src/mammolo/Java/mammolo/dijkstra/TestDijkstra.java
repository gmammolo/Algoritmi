/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammolo.Java.mammolo.dijkstra;

import java.util.List;
import mammolo.Java.mammolo.graph.SparseGraph;
import mammolo.Java.mammolo.kruskal.DoubleValue;

/**
 *
 * @author Giuseppe
 */
public class TestDijkstra {
   public static void main(String [] args) {
       SparseGraph<String, DoubleValue> graph = new SparseGraph<String, DoubleValue>();
       graph.addVertex("A");
       graph.addVertex("B");
       graph.addVertex("C");
       graph.addVertex("D");
       graph.addVertex("E");
       graph.addVertex("F");
       
       graph.addEdge("A", "B", new DoubleValue(20));
       graph.addEdge("A", "D", new DoubleValue(3));
       graph.addEdge("B", "C", new DoubleValue(10));
       graph.addEdge("D", "E", new DoubleValue(6));
       graph.addEdge("C", "E", new DoubleValue(4));
       graph.addEdge("E", "F", new DoubleValue(7));
       graph.addEdge("C", "F", new DoubleValue(3));
       
       dijkstra dj = new dijkstra();
       List<String> path = dj.minPath(graph, "A", "F");
       
   } 
   
}
