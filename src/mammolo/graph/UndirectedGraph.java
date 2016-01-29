/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammolo.graph;

import mammolo.graph.SparseGraph;


/**
 *
 * @author Giuseppe
 */
public class UndirectedGraph<V,E> extends SparseGraph<V,E>{

  @Override
  public boolean addEdge(V vertex1, V vertex2, E data) {
    if(!eleMap.containsKey(vertex1) || !eleMap.containsKey(vertex2))
      return false;
    Node<V> startNode = eleMap.get(vertex1);
    Node<V> endNode = new Node<V>(vertex2);
    startNode.neighbors.put(endNode, data);
    startNode.gradeOut++;
    endNode.gradeIn++;
    
    startNode = eleMap.get(vertex2);
    endNode = new Node<>(vertex1);
    startNode.neighbors.put(endNode, data);
    startNode.gradeOut++;
    endNode.gradeIn++;
    return true;
  }
  
  
}
