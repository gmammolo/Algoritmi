/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammolo.Java.mammolo.priorityqueue;

/**
 *
 * @author giuseppe
 * @param <E> Tipo dell' elemento da inserire
 * @param <P> extends Comparable . Tipo dell' oggetto per cui ordinare la coda
 */
public interface PriorityQueue<E, P extends Comparable<P>> {
    
  /**
   * Aggiunge l'elemento element alla coda con priorità priority
   * @param element elemento da inserire
   * @param priority priorità dell' elemento
   * @return <code>true</code> in caso di riuscita, <code>false</code> altrimenti.
   */  
  boolean add(E element, P priority);

  /**
   * Restituisce il primo elemento della lista senza rimuoverlo
   * @return Restituisce il primo elemento della lista senza rimuoverlo
   */
  E first();

  /**
   * Restituisce il primo elemento rimuovendolo dalla struttura
   * @return Restituisce il primo elemento rimuovendolo dalla struttura
   */
  E removeFirst();

  /**
   * Verifica se la struttura contiene elementi o meno
   * @return <code>true</code> se la struttura è vuota, <code>false</code> altrimenti.
   */
  boolean isEmpty();

  /**
   * Rumuove un determinato elemento dalla lista
   * @param element elemento da eliminare
   * @return <code>true</code> in caso di successo, <code>false</code> altrimenti.
   */
  boolean delete(E element);

  /**
   * Cambia la priorità dell' elemento
   * @param element elemento a cui cambiare la priorità
   * @param priority nuova priorità da dare  all' elemento
   * @return <code>true</code> in caso di successo, <code>false</code> altrimenti.
   */
  boolean setPriority(E element, P priority);
}

