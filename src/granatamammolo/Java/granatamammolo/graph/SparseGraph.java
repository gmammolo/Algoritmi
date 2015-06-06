/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author Giuseppe
 */
public class SparseGraph<V,E> implements Graph<V,E> {

  
  
  HashMap<V,Node<V>> eleMap;
  
  
  public SparseGraph()
  {
    eleMap = new HashMap<>();
  }

  @Override
  public boolean addVertex(V vertex)  {
    if(eleMap.containsKey(vertex))
      return false;
    eleMap.put(vertex, new Node(vertex));
    return true;
  }

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

  @Override
  public boolean hasVertex(V vertex) {
    return eleMap.containsKey(vertex);
  }

  @Override
  public boolean hasEdge(V vertex1, V vertex2) {
    if(!eleMap.containsKey(vertex1) || !eleMap.containsKey(vertex2))
      return false;
    return eleMap.get(vertex1).neighbors.containsKey(new Node<V>(vertex2));
  }

  @Override
  public E getData(V vertex1, V vertex2) {
    if(!eleMap.containsKey(vertex1) || !eleMap.containsKey(vertex2))
        return null;
    return eleMap.get(vertex1).neighbors.get(new Node<V>(vertex2));
  }

  @Override
  public Set<V> getVertices() {
    return eleMap.keySet();
  }

  @Override
  public HashSet<V> getNeighbors(V vertex) {
    
    HashSet<V> res = new HashSet<V>();
    Node<V> n = eleMap.get(vertex);
    if(n==null)
      return res;
    Iterator it =  n.neighbors.entrySet().iterator();

    while (it.hasNext())
    {
      Entry<Node<V>,E> pair = (Entry)it.next();
      res.add(pair.getKey().elem);
    }
    return res;
    
  }
 
  @Override
  public String toDot(String name){
    String s="graph "+name+" { \n";
    UniquePairList<V> list = new UniquePairList<>();
    for(V u: this.getVertices()) {
      for(V v: this.getNeighbors(u)) {
        list.add(u,v);
      }
    }
    for(int i=0; i<list.size();i++) {
      V u= list.getFirst(i);
      V v= list.getSecond(i);
      s+= "\t"+u.toString()+" -- "+v.toString()+" [label=\""+getData(u, v).toString()+"\" color=\"red\" style=bold]; \n";
    }
    
    return s+"}\n";
  }
  
  
  protected class Node<V> {
    
    HashMap<Node<V>,E> neighbors;
    V elem;
    int gradeOut;
    int gradeIn;
    
    
    public Node()
    {
      this(null);
    }
    
    public Node(V e)
    {
      elem = e;
      neighbors = new HashMap<>();
    }

    public int getGrade() {
      return gradeOut+gradeIn;
    }

    @Override
    public int hashCode() {
      int hash = 5;
      hash = 53 * hash + Objects.hashCode(this.elem);
      return hash;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
        
      if (getClass() != obj.getClass()) {
        return false;
      }
      final Node<?> other = (Node<?>) obj;
      if (!Objects.equals(this.elem, other.elem)) {
        return false;
      }
      return true;
    }
    
  }
  
}
