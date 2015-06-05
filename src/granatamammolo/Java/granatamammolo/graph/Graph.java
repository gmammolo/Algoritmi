/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.graph;

import java.util.Collection;

/**
 *
 * @author giuseppe
 */
public interface Graph<V , E>{
    
    
    /**
        * Aggiunge il vertice vertex al grafo se il vertice non vi appartiene gi à .
        * Restituisce true se vertex è stato aggiunto .
        */
    boolean addVertex (V vertex ) ;
    
    /**
     * Aggiunge L'arco al grafo se l'arco  non vi appartiene già. Restituisce true se l'arco viene aggiunto 
     * @param vertex1
     * @param vertex2
     * @param data
     * @return 
     */
    boolean addEdge (V  vertex1 , V vertex2 , E data ) ;
    
    
    boolean hasVertex (V vertex ) ;
    
    boolean hasEdge (V vertex1 ,V vertex2 ) ;
    
    E getData (V vertex1 ,V vertex2 ) ;
    
    /**
     * 
     * @return Lista dei vertici del grafo 
     */
    Collection<V> getVertices( ) ;
    
    /**
     * La lista di adiacenza del vertice vertex
     * @param vertex
     * @return 
     */
    Collection<V> getNeighbors (V vertex ) ;
}
