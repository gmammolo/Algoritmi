/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammolo.graph;

/**
 *
 * @author giuseppe
 */
public interface SearchCallback<V, E> {
    
    void onVisitingVertex (V vertex ) ;
    
    void onTraversingEdge (V source , V dest , E info ) ;
    
    
}
