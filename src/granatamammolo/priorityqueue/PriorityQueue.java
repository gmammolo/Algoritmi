/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.priorityqueue;

/**
 *
 * @author giuseppe
 * @param <E>
 * @param <P> extends Comparable
 */
public interface PriorityQueue<E, P extends Comparable<P>> {
    
    boolean add(E element, P priority);
    
    E first();
    
    E removeFirst();
    
    boolean isEmpty();
    
    boolean delete(E element);
    
    boolean setPriority(E element, P priority);
}

