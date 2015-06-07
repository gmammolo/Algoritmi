/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.graph;

import granatamammolo.Java.granatamammolo.graph.SparseGraph;


/**
 *
 * @author Giuseppe
 */
public class UndirectedGraph<V,E> extends SparseGraph<V,E>{

  @Override
  public boolean addEdge(V vertex1, V vertex2, E data) {
    if(!eleMap.containsKey(vertex1) || !eleMap.containsKey(vertex2))
      return false;
    Node startNode = eleMap.get(vertex1);
    Node endNode = new Node(vertex2);
    startNode.neighbors.put(endNode, data);
    startNode.gradeOut++;
    endNode.gradeIn++;
    
    startNode = eleMap.get(vertex2);
    endNode = new Node(vertex1);
    startNode.neighbors.put(endNode, data);
    startNode.gradeOut++;
    endNode.gradeIn++;
    return true;
  }
  
  
}