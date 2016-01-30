package mammolo.priorityqueue;

/**
 *
 * @author giuseppe
 */
public interface PriorityQueueStringDouble {

  /**
  * Inserisce l'elemento dentro l'array.
  * Se l'elemento � già presente, il metodo non fa nulla e restituisce false.
  * @param element Elemento da inserire.
  * @param priority Priorità relativa all'elemento da inserire.
  * @return <code>true</code> se l'elemento è stato aggiunto, 
  *         <code>false</code> se l'elemento è già presente.
  */
  boolean add(String element , double priority ) ;

  /**
  * 
  * @return il primo elemento della coda.
  */
  String first();
    
  /**
   * Rimuove il primo elemento della coda.
   * @return elemento rimosso o <code>null</code> se non ci sono elementi in coda.
   */
  String removeFirst();
    
  /**
  * Indica se la coda è vuota
  * @return  <code>true</code> se la coda è vuota, <code>false</code> altrimenti
  */
  boolean isEmpty();

  /**
  * Elimina l'elemento dalla coda.
  * @param element Elemento da eliminare.
  * @return true se l'elemento è stato eliminato, false altrimenti (l'elemento 
  * non è presente).
  */
  boolean delete(String element);

  /**
  * Cambia la priorirà ad un elemento della coda.
  * @param element Elemento a cui cambiare la priorità.
  * @param priority Nuova priorità da impostare.
  * @return <code>true</code> in caso di successo, <code>false</code> altrimenti
  */
  boolean setPriority(String element, double priority);
    
    
    
}
