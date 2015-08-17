/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammolo.Java.mammolo.graph;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Giuseppe
 */
public class DepthFirstSearch<V,E> implements GraphSearch<V, E>{


  
  
  @Override
  public void search(Graph<V, E> graph, V source, SearchCallback<V, E> callback) {
    Collection<V> list;
    HashMap<V,Boolean> visited;
    HashMap<V,V> father;
    list = graph.getVertices();
    int n = list.size();
    visited = new HashMap<>();
    father = new HashMap<>();
    for(V vert : list) {
      visited.put(vert, Boolean.FALSE);
      father.put(vert, null);
    }
    for(V vert : list) {
      if(!visited.get(vert)) {
        callback.onVisitingVertex(vert);
        visitRic(graph, vert, callback, visited, father);
      }
        
    }
  }    
  
  protected void visitRic(Graph<V, E> graph, V u, SearchCallback<V, E> callback, HashMap<V,Boolean> visited, HashMap<V,V> father ) {
    visited.put(u, Boolean.TRUE);
    for(V v :graph.getNeighbors(u)) {
      if(!visited.get(v)) {
        callback.onVisitingVertex(v);
        callback.onTraversingEdge(u, v, graph.getData(u, v));
        visitRic(graph, v, callback, visited, father);
        
      }
    }
    
  }

}
