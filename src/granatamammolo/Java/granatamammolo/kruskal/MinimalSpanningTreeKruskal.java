/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.kruskal;

import granatamammolo.Java.granatamammolo.graph.UndirectedGraph;
import granatamammolo.Java.granatamammolo.unionfind.UnionFind;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.DoubleSupplier;

/**
 *
 * @author Giuseppe
 */
public class MinimalSpanningTreeKruskal<V, E extends DoubleSupplier> {
  /**
   * TOSEE_Giu: ecco perchè odio tanto i pdf... prima o poi va risistemato questo commento xD
  * Coppia d i v e r t i c i r a p p r e s e n t a n t e un a r c o n e l g r a f o .
  * Se n e l l ’ i m p l e m e n t a z i o n e d e l l e s t r u t t u r e d a t i s i è
  * g i à d e f i n i t a una s t r u t t u r a a n a l o g a , è p o s s i b i l e u s a r e
  *la propria versione .
   */


  
  
  class EdgeComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge t1, Edge t2) {
      if(t1.data.getAsDouble()-t2.data.getAsDouble()>0.0)
        return 1;
      else if(t1.data.getAsDouble()-t2.data.getAsDouble()<0.0)
        return -1;   
      return 0;
    }

  }
  
  public List<Edge> build ( UndirectedGraph<V, E> g ) throws IllegalAccessException {
    ArrayList<Edge> priQueue = new ArrayList<>();
    for(V u: g.getVertices()) {
      for(V v: g.getNeighbors(u)) {
        Edge e = new Edge(u,v,g.getData(u, v));
        if(!priQueue.contains(e))
          priQueue.add(e);
      }
    }
    Collections.sort(priQueue,new EdgeComparator());
    ArrayList<Edge> ris= new ArrayList<>();
    UnionFind<V> union = new UnionFind<>();
    int n = 0;
    for(V ele : g.getVertices())
    {
      union.makeSet(ele);
      n++;
    }
    int i = 0,counter=0;
    while(counter < n-1)
    {
      Edge arco = priQueue.get(i);
      if(union.kruskalUnion((V)arco.v1, (V)arco.v2))
      {
        ris.add(arco);
        counter++;
      }
      i++;
    }
    return ris;
    
  }

}
