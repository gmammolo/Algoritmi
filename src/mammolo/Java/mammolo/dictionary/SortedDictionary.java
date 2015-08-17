package mammolo.Java.mammolo.dictionary;

/**
 * Interfaccia che estende Dictonary e realizza un dizionario ordinato, con un 
 * ordine totale sulle chiavi.
 * @author Federica
 * @param <K> tipo della chiave del dizionario
 * @param <V> tipo del valore del dizionario
 */
public interface SortedDictionary <K extends Comparable<? super K>, V> extends Dictionary <K, V> { 
  
  /**
   * Restituisce la chiave minore nella struttura Dizionario
   * @return la chiave più piccola 
   */
  K minKey();
  
  /**
   * Restituisce la chiave maggiore nella struttura Dizionario
   * @return la chiave più grande 
   */
  K maxKey();
  
  /**
   * Restituisce l'elemento che corrisponde alla chiave minore
   * @return l'elemento che corrisponde alla chiave minore
   */
  V elementOfMinKey();
  
  /**
   * Restituisce l'elemento che corrisponde alla chiave maggiore
   * @return l'elemento che corrisponde alla chiave maggiore
   */
  V elementOfMaxKey();
  
//  @Override
//  V find(K key);
  
}
