
package mammolo.kruskal;

import mammolo.graph.UndirectedGraph;
import mammolo.unionfind.UnionFind;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleSupplier;

/**
 * Algoritmo di Kruskal 
 * @author Giuseppe
 * @param <V> Tipo dell'elemento nel nodo del grafo
 * @param <E> Peso dell' arco
 */
public class MinimalSpanningTreeKruskal<V, E extends DoubleSupplier> {


  
  /**
   * Classe che estende il Comparator per confrontare e ordinare gli Edge nell' arraylist
   */
  class EdgeComparator implements Comparator<Edge<V,E>> {

    @Override
    public int compare(Edge<V,E> t1, Edge<V,E> t2) {
      if(t1.data.getAsDouble()-t2.data.getAsDouble()>0.0)
        return 1;
      else if(t1.data.getAsDouble()-t2.data.getAsDouble()<0.0)
        return -1;   
      return 0;
    }

  }
  
  /**
   * Effettua L'algoritmo di Kruskal sul grafo inserito
   * @param g Grafo dell' algoritmo
   * @return L'albero minimo Ricoprente (MAR) sottoforma di Lista di Edge
   * @throws IllegalAccessException -
   */
  public List<Edge<V,E>> build ( UndirectedGraph<V, E> g ) throws IllegalAccessException {
    ArrayList<Edge<V,E>> priQueue = new ArrayList<>();
    for(V u: g.getVertices()) {
      for(V v: g.getNeighbors(u)) {
        Edge<V,E> e = new Edge<>(u,v,g.getData(u, v));
        if(!priQueue.contains(e))
          priQueue.add(e);
      }
    }
    Collections.sort(priQueue,new EdgeComparator());
    ArrayList<Edge<V,E>> ris= new ArrayList<>();
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
      Edge<V,E> arco = priQueue.get(i);
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
