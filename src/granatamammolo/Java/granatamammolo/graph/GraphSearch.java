/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.graph;

/**
 *
 * @author giuseppe
 */
public interface GraphSearch<V, E> {
    
    void search ( Graph<V, E> graph , V source , SearchCallback <V, E>  callback ) ;
    
}
