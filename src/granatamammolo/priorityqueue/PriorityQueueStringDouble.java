package granatamammolo.priorityqueue;

/**
 *
 * @author giuseppe
 */
public interface PriorityQueueStringDouble {

    /**
        * Inserisce l'elemento dentro l'array
         * Se l'elemento è gia presente, il metodo non fa nulla  e restituisce false;
         * @param element
         * @param priority
         * @return <code>true</code> in caso positivo, <code>false</code> se l'elemento è già presente
         */
    boolean add(String element , double priority ) ;

    /**
        * 
        * @return il primo elemento della coda
        */
    String first();
    
    /**
     * Rimuove il primo elemento della coda
     * @return elemento rimosso o <code>null</code> se non ci sono elementi in coda
     */
    String removeFirst();
    
    /**
     * 
     * @return  <code>true</code> se è vuoto, <code>false</code> altrimenti
     */
    boolean isEmpty();
    
    /**
        * Elimina l'elemento dalla coda
        * @param element
        * @return false in caso non sia presente;
        */
    boolean delete(String element);
    
    /**
     * Cambia la priorirà a un elemento della coda
     * @param element elemento a cui cambiare la priorità
     * @param priority nuova priorità da impostare
     * @return <code>true</code> in caso di successo , <code>false</code> altrimenti
     */
    boolean setPriority(String element, double priority);
    
    
    
}
