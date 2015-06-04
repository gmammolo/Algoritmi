/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.kruskal;

import granatamammolo.Java.granatamammolo.priorityqueue.PriorityQueueHeap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author Giuseppe
 */
public class UndirectedGraph<V,E extends Comparable<E>>{
  
  HashMap<V,Node<V>> eleMap;
  
 
  
  public UndirectedGraph()
  {
    eleMap = new HashMap<>();
  }
  
  public boolean addNode(V e)
  {
    if(eleMap.containsKey(e))
      return false;
    eleMap.put(e, new Node(e));
    return true;
  }
  
  public boolean addArco(V start, V end, E peso )
  {
    if(!eleMap.containsKey(start))
      return false;
    if(!eleMap.containsKey(end))
      addNode(end);
    Node startNode = eleMap.get(start);
    Node endNode = new Node(end);
    startNode.adiacente.put(endNode, peso);
    startNode.gradoOut++;
    endNode.gradoIn++;
    return true;
  }
  
  
  public PriorityQueueHeap edges()
  {
    PriorityQueueHeap<Edge,E> list = new PriorityQueueHeap<>();
    for(Entry<V,Node<V>> entry : eleMap.entrySet() )
    {
      Iterator it = entry.getValue().adiacente.entrySet().iterator();
      while (it.hasNext())
      {
        Entry<Node<V>,E> pair = (Entry)it.next();
        list.add(new Edge(entry.getKey(), pair.getKey().elem , pair.getValue() ) , pair.getValue());
      }
      
    }
    
    return list;
  }
  
  public class Edge {
    V v1 ;
    V v2 ;
    E data ;
    
    public Edge(V v1, V v2, E data)
    {
      this.v1 = v1;
      this.v2 = v2;
      this.data = data;
    }
  }        
  
  protected class Node<V> {
    
    HashMap<Node<V>,E> adiacente;
    V elem;
    int gradoOut;
    int gradoIn;
    
    
    public Node()
    {
      this(null);
    }
    
    public Node(V e)
    {
      elem = e;
      adiacente = null;
    }

    public int getGrado() {
      return gradoOut+gradoIn;
    }

    
   
    
  }
  
}
