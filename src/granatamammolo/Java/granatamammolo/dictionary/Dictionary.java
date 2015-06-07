package granatamammolo.Java.granatamammolo.dictionary;

/**
 *
 * @author Federica
 * @param <K> Tipo della chiave
 * @param <V> Tipo del valore da inserire nel dizionario
 */
public interface Dictionary <K,V>{
  
  /**
   * Restituisce true se il dizionario è vuoto
   * @return <code>true</code> se la coda è vuota, <code>false</code> altrimenti
   */
  boolean isEmpty();
  
  /**
   * Restituisce il valore associato alla chiave <code>key</code>
   * (o null se la chiave non è presente)
   * @param key chiave da cercare
   * @return valore V che corrisponde alla chiave key
   */
  V find(K key);
  
  /**
   * Associa il valore <code>value</code> alla chiave <code>key</code>
   * e restituisce il valore precedentemente associato a key (o null
   * se la chiave non era associata a nessun valore)
   * @param key key da aggiungere
   * @param value valore da inserire
   * @return  valore precedentemente associato a key (o null se la chiave non
   * era associata a nessun valore)
   */
  V add(K key, V value);
  
  /**
   * Rimuove la chiave <code>key</code> dal dizionario, se presente,
   * altrimenti non fa nulla
   * @param key chiave dell' elemento da rimuovere
   */
  void remove(K key);
  
}
