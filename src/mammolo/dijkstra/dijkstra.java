/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammolo.dijkstra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.DoubleSupplier;
import mammolo.graph.Graph;
import mammolo.graph.UndirectedGraph;

/**
 *
 * @author Giuseppe
 */
public class dijkstra<V, E extends DoubleSupplier> {

    public List<V> minPath(UndirectedGraph<V, E> graph, V source, V dest) {
        List<V> path = new LinkedList<V>();
        Set<V> vertices = (Set<V>) graph.getVertices();
        HashMap<V, Double> dist = new HashMap<>();
        HashMap<V, V> padre = new HashMap<>();
        for (V x : vertices) {
            dist.put(x, Double.MAX_VALUE);
            padre.put(x, null);
        }
        dist.put(source, 0.0);
        padre.put(source, source);

        PriorityQueue<NodoPrioritario<V>> Q = new PriorityQueue<>();
        for (V x : vertices) {
            Q.add(new NodoPrioritario<>(x, dist.get(x)));
        }
        while (!Q.isEmpty()) {
            V u = Q.poll().getNode();
            for (V v : graph.getNeighbors(u)) {
                Double c = graph.getData(u, v).getAsDouble();
                if (dist.get(u) + c < dist.get(v)) {
                    padre.put(v, u);
                    dist.put(v, dist.get(u) + c);
                    Q.remove(new NodoPrioritario(v, 0));
                    Q.add(new NodoPrioritario<>(v, dist.get(v)));
                    if (v == dest) {
                        path = new LinkedList<V>();                            
                        V x = v;
                        while (padre.get(x) != x) {
                            path.add(x);
                            x = padre.get(x);
                        }
                        path.add(x);

                    }

                }
            }
        }
        return path;
    }
    
}


