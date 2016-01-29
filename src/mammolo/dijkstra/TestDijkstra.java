/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammolo.dijkstra;

import java.util.List;
import mammolo.graph.SparseGraph;
import mammolo.graph.UndirectedGraph;
import mammolo.kruskal.DoubleValue;

/**
 *
 * @author Giuseppe
 */
public class TestDijkstra {
   public static void main(String [] args) {
       UndirectedGraph<String, DoubleValue> graph = new UndirectedGraph<String, DoubleValue>();
       graph.addVertex("A");
       graph.addVertex("B");
       graph.addVertex("C");
       graph.addVertex("D");
       graph.addVertex("E");
       graph.addVertex("F");
       
       graph.addEdge("A", "B", new DoubleValue(20));
       graph.addEdge("A", "C", new DoubleValue(2));
       graph.addEdge("C", "E", new DoubleValue(3));
       graph.addEdge("B", "D", new DoubleValue(5));
       graph.addEdge("C", "E", new DoubleValue(4));
       graph.addEdge("D", "F", new DoubleValue(4));

       
       dijkstra dj = new dijkstra();
       List<String> path = dj.minPath(graph, "A", "F");
       
   } 
   
}
