package granatamammolo.Java.granatamammolo.dictionary;

/**
 *
 * @author Federica
 */
public interface Dictionary <K,V>{
  
  /**
   * Restituisce true se il dizionario è vuoto
   */
  boolean isEmpty();
  
  /**
   * Restituisce il valore associato alla chiave <code>key</code>
   * (o null se la chiave non è presente)
   */
  V find(K key);
  
  /**
   * Associa il valore <code>value</code> alla chiave <code>key</code>
   * e restituisce il valore precedentemente associato a key (o null
   * se la chiave non era associata a nessun valore)
   */
  V add(K key, V value);
  
  /**
   * Rimuove la chiave <code>key</code> dal dizionario, se presente,
   * altrimenti non fa nulla
   */
  void remove(K key);
  
}
