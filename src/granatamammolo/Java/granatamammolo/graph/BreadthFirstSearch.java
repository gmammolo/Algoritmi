/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.PriorityQueue;


/**
 *
 * @author Giuseppe
 */
public class BreadthFirstSearch<V,E> implements GraphSearch<V, E>{
 
  
  public BreadthFirstSearch()
  {
  }
  
  @Override
  public void search(Graph<V, E> graph, V source, SearchCallback<V, E> callback) {
    //TOSEE_Giu: Non sono sicurissimo di aver posizionato bene i due metodi del callback
    Collection<V> list = graph.getVertices();
    int n = list.size();
    PriorityQueue<V> q = new PriorityQueue<>();
    HashMap<V,Boolean> visited= new HashMap<>();
    HashMap<V,V> father= new HashMap<>();
    for(V vert : list) {
      visited.put(vert, Boolean.FALSE);
      father.put(vert, null);
    }
    
    for(V s : list) {
      if(!visited.get(s)){
        visited.put(s, Boolean.TRUE);
        callback.onVisitingVertex(s);
        q.add(s);
        while(!q.isEmpty()) {
          V u = q.remove();
          for(V v :graph.getNeighbors(source)) {
            if(!visited.get(v)) {
              visited.put(v, Boolean.TRUE);
              callback.onTraversingEdge(u, v, graph.getData(u, v));
              callback.onVisitingVertex(v);
              father.put(v, u);
              q.add(v);
            }
          }
        }
      }
    }
    
  }
  
}
