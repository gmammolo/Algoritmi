package granatamammolo.Java.granatamammolo.dictionary;

/**
 *
 * @author Federica
 */
public interface SortedDictionary <K extends Comparable<? super K>, V> extends Dictionary <K, V> { 
  
  K minKey();
  K maxKey();
  V elementOfMinKey();
  V elementOfMaxKey();
  
}
