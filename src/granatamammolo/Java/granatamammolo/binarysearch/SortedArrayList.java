package granatamammolo.Java.granatamammolo.binarysearch;

import java.util.ArrayList;

/**
 * 
 * @author Giuseppe
 * @param <E> Generic Type Comparable
 */
public class SortedArrayList<E extends Comparable<E>> {
    
    protected ArrayList<E> elements;
    
//    /**
//     * Indica se utilizzare il metodo Ricorsivo o iterativo per la Ricerca Binaria
//     */
//    public static boolean recursive = false;

    /**
     * Costruttore: crea un Array contenente 16 elementi con valori inizializzati a 0 
     */
    public SortedArrayList() {    // TOSEE dovrebbe essere SortedArrayList<E>()
        //this(16);
      this.elements = new ArrayList<E>(16);
    }

    /**
     * Costruttore: crea un array di capacità definita
     * @param initialCapacity capacità dell' array 
     * @throws IllegalArgumentException Lancia l'eccezione se il valore iniziale
     * inserito è negativo
     */
    public SortedArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Non può essere negativo");
        }
        this.elements = new ArrayList<>(initialCapacity);
    }

    /**
     * Crea un array di capacità <code>array.length + 16</code> e inserisce al 
     * suo interno gli elementi dell'array a
     * @param a array di elementi di tipo E non necessariamente ordinato 
     */
    public SortedArrayList(E[] a) {
      //        this(a.size() + 16);
      this.elements = new ArrayList<E>(a.length + 16);
      for(int i = 0; i < a.length; i++)
            this.insert(a[i]);
    }
    
//    /**
//     * <p>Metodo per la Ricerca Binaria. Richiama la ricerca binaria
//     * con il metodo Ricorsivo o Iterativo in base al valore settato in 
//     * <code>static boolean recursive </code></p>
//     * <p>di default usa la ricerca iterativa, in quanto è quella specificata nel pdf</p>
//     * @see recursiveBinarySearch 
//     * @see iterativeBinarySearch 
//     * @param x valore da cercare
//     * @return l'index dell' elemento cercato oppure la posizione dove inserirlo 
//     * nel caso non sia presente nell' array nella forma -(index -1)
//     */
//    protected int binarySearch(E x) {
//      if(IntSortedArray.recursive)
//        return recursiveBinarySearch(x);
//      else
//        return iterativeBinarySearch(x);
//    }
    
//    /**
//     * Esegue la ricerca binaria raffinata  in modo iterativo 
//     * @param search intero da cercare dentro l'array
//     * @return la posizione dell' elemento <code>search</code> oppure la 
//     * posizione dove inserirlo: <code>-(pos+1)</code>
//     */
//    protected int iterativeBinarySearch(E search) {
    /**
     * Esegue la ricerca binaria con le varie ottimizzazioni.
     * @param x Elemento da ricercare.
     * @return posizione di x nell'array o posizione dove inserirlo: -(pos+1)
     */
    protected int binarySearch(E x) {
      int ini = 0, fin = size() - 1;
      if (fin == -1 || x.compareTo(elements.get(0)) < 0 ) 
        return -1;
      if (x.compareTo(elements.get(fin)) > 0)
        return -(size() + 1);
      while (ini <= fin) {
        int i = (ini + fin) >>> 1;
        if (x.compareTo(elements.get(i)) < 0) {
          fin = i - 1;
        } else if (x.compareTo( elements.get(i)) >0 ) {
          ini = i + 1;
        } else {
          return i;
        }
      }
      return -(ini+1);
    }
     
    /**
     * Restituisce il numero di elementi presente nell'array.
     * @return Numero di elementi inseriti dentro l'array 
     */
    public int size() {
      return this.elements.size();
    }
    
//    /**
//     * Esegue la ricerca binaria raffinata  in modo ricorsivo 
//     * @param search intero da cercare dentro l'array
//     * @return la posizione dell' elemento <code>search</code> oppure la 
//     * posizione dove inserirlo: <code>-(pos+1)</code>
//     */
//    protected int recursiveBinarySearch(E search) {
//        if (size() == 0 || search.compareTo( elements.get(0)) < 0) 
//            return -1;
//        if (search.compareTo(elements.get(size() - 1)) > 0)
//            return -(size() + 1);
//        return recursiveBinarySearch(search, 0, size()-1);
//    }
    
    private int recursiveBinarySearch(E search, int start, int end) {
        
        if (start > end)
           return -(start + 1);
        int i = (start + end) >>> 1;
        if (search.compareTo(elements.get(i)) == 0) {
            return i;
        } else if (start > end) {
            return -(end + 1);
        } else if (search.compareTo( elements.get(i)) < 0) {
            return recursiveBinarySearch(search, start, i - 1);
        } else { //if(search > elements[i])
        
            return recursiveBinarySearch(search, i + 1, end);
        }

    }

    /**
     * Inserisce l'elemento nell'array mantenendolo ordinato <br>
     * Lo inserisce anche se è già presente (ripetendolo più volte). <br>
     * Se l'array è già pieno lo rialloca in un array di dimensione doppia 
     * e poi inserisce  l'elemento.
     * @param x elemento da inserire
     * @return int ritorna l'indice in cui è stato inserito l'elemento
     */
    public int insert(E x) {
      int index = binarySearch(x);
      if(size() >= elements.size())          
        elements.ensureCapacity(size()*2+16);
      if (index < 0) 
        index = -index - 1;
      elements.add(index, x);
      return index;
    }
   

    /**
     * Restituisce l'elemento al posto indicato
     * @param index posizione in cui cercare
     * @return valore dell' array
     * @throws ArrayIndexOutOfBoundsException Nel caso in cui l'indice non è
     * accettabile
     */
    public E get(int i) throws ArrayIndexOutOfBoundsException {    
      if(i < 0 || i >= size())
        throw  new ArrayIndexOutOfBoundsException("Elemento non trovato");
      return this.elements.get(i);
    }
    
    /**
     * Ritorna l'indice in cui è possibile trovare l'elemento scelto
     * @param x elemento da cercare
     * @return index dell'elemento o -1 in caso non venga trovato
     */
    public int indexOf(E x) {
      int index = binarySearch(x);
      return ( index >= 0 ) ? index : -1;
    }


    
    /**
     * Restituisce una versione stampabile dell'array
     * @return Stringa rappresentante gli elementi dell'array.
     */
    public String toString() {
      return this.elements.toString();
//      String s= "[";                  TOSEE vuole solo che richiami toString
//      for(int i=0; i< size()-1; i++) 
//         s += elements.get(i) + ", ";
//      if(size() > 0)
//        s+= elements.get(size()-1);
//      s+= "]";
//      return s;
    }
    
}
