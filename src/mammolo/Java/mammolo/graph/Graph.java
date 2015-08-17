
package mammolo.Java.mammolo.graph;

import java.util.Collection;

/**
 * Grafo generico
 * @author giuseppe
 * @param <V> Tipo dell' elemento nel Nodo
 * @param <E> Tipo del Peso dell' arco
 */
public interface Graph<V , E>{
    
    
    /**
    * Aggiunge il vertice vertex al grafo se il vertice non vi appartiene gi à .
    * Restituisce true se vertex è stato aggiunto .
   * @param vertex valore del vertice da aggiungere
   * @return <code>true</code> in caso di riuscita, <code>false</code> altrimenti.
    */
    boolean addVertex (V vertex );
    
    /**
     * Aggiunge L'arco al grafo se l'arco  non vi appartiene già. Restituisce true se l'arco viene aggiunto 
     * @param vertex1 valore del primo vertice
     * @param vertex2 valore del secondo vertice
     * @param data peso dell' arco che unisce i due vertici
     * @return <code>true</code> in caso di riuscita, <code>false</code> altrimenti.
     */
    boolean addEdge (V  vertex1 , V vertex2 , E data ) ;
    
    /**
     * Restituisce true se vertex fa parte del grafo .
     * @param vertex vertice da cercare
     * @return <code>true</code> se lo trova, <code>false</code> altrimenti.
     */
    boolean hasVertex (V vertex ) ;
    
    /**
     * Restituisce true sel’ arco ( vertex1 , vertex2 ) fa
     * parte del grafo .
     * @param vertex1 vertice A
     * @param vertex2 vertice B
     * @return <code>true</code> se lo trova, <code>false</code> altrimenti.
     */
    boolean hasEdge (V vertex1 ,V vertex2 ) ;
    
    /**
     * Restituisce il dato associato all’ arco vertex1 - vertex2
     * @param vertex1 vertice A
     * @param vertex2 vertice B
     * @return Il valore dell' arco identificato
     */
    E getData (V vertex1 ,V vertex2 ) ;
    
    /**
     * Genera una lista contenete tutti i Nodi (vertici) presenti nel grafo
     * @return Lista dei vertici del grafo 
     */
    Collection<V> getVertices( ) ;
    
    /**
     * La lista di adiacenza del vertice vertex
     * @param vertex nodo da cercare
     * @return Una lista conteente tutti i nodi raggiungibili da vertex con un
     * unico passo
     */
    Collection<V> getNeighbors (V vertex ) ;
    
    /**
     * Restituisce una versione stampabile del grafo nel formato graphviz
     * @param Name Nome da dare al grafo
     * @return una variabile String contente la giusta formattazione
     */
    String toDot(String Name);
}
