package granatamammolo.Java.granatamammolo.binarysearch;

/**
 * @author giuseppe
 */
public class IntSortedArray {

    /**
       * Array parzialmente riempito contenente gli elementi.
       */
    protected int[] elements;
    /**
        * Numero di elementi presenti in elements (non è la capacità)
        */
    protected int size;         

  /**
     * Costruttore: crea un array contenente 16 elementi con valori inizializzati a 0 
     */
    public IntSortedArray() {
        this(16);
    }

    /**
     * Costruttore: crea un array di capacità definita
     * @param initialCapacity capacità dell'array 
     * @throws IllegalArgumentException se il valore iniziale inserito è negativo
     */
    public IntSortedArray(int initialCapacity) {
      if (initialCapacity < 0) {
          throw new IllegalArgumentException("La capacità iniziale dell'array non può essere negativa");
      }
      this.elements = new int[initialCapacity];
      this.size = 0;
    }

    /**
     * Crea un array di capacità <code>array.length + 16</code> e inserisce al 
     * suo interno gli elementi dell'array a ordinati.
     * @param a array di int non necessariamente ordinato
     */
    public IntSortedArray(int[] a) {
        this(a.length + 16);
        for(int i=0; i< a.length;i++)
            this.insert(a[i]);
    }

   /**
       * Esegue la ricerca binaria con tutte le ottimizzazioni.
       * Precondizione: l'array è ordinato.
       * @param x intero da cercare all'interno dell'array
       * @return  posizione di x nell'array o posizione dove inserirlo: -(pos+1)
       */   
      protected int binarySearch(int x) {
        int ini = 0, fin = this.size - 1; 
        if (fin == -1 || x < elements[ini]) 
          return -1;
        if (x > elements[fin]) 
          return -(this.size + 1);
        while (ini <= fin) {
            int i = (ini + fin) >>> 1;
            if (x < elements[i])
                fin = i - 1;
            else if (x > elements[i])
                ini = i + 1;
            else
                return i;
        }
        return -(ini+1);
    }
     
    /**
     * @return Numero di elementi presenti nell'array (non è la capacità) 
     */
    public int size() {
        return this.size;
    }
    
    /** 
     * Rialloca l'array elements in un array di dimensione doppia.
     * <p>Viene richiamato da insert()</p>
     */
    protected void reallocate() {
      int newSize= (this.elements.length == 0) ? 1 : this.elements.length * 2;
      int[] doppio = new int[newSize];
      System.arraycopy(this.elements, 0, doppio, 0, this.size);
      this.elements = doppio;
    }
    
    /**
     * Inserisce l'elemento nell'array mantenendolo ordinato <br>
     * Lo inserisce anche se è già presente (ripetendolo). <br>
     * Se l'array è già pieno lo rialloca in un array di dimensione doppia 
     * e poi inserisce l'elemento.
     * @param x elemento da inserire
     * @return l'indice in cui è stato inserito l'elemento
     */
    public int insert(int x) {
        int index = binarySearch(x);
        if(size == elements.length)  
          reallocate();
        if (index < 0) 
          index = -(index + 1);
        for(int i = size; i > index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = x;
        size++;
        return index;
    }
   

    /**
     * Restituisce l'elemento al posto indicato
     * @param i posizione in cui cercare
     * @return valore dell'array in posizione i
     * @throws ArrayIndexOutOfBoundsException Nel caso in cui l'indice non fosse
     * accettabile
     */
    public int get(int i) throws ArrayIndexOutOfBoundsException {    
      if(i < 0 || i >= size)
        throw new ArrayIndexOutOfBoundsException("Elemento non trovato");
      return elements[i];
    }
    
    /**
     * Ritorna l'indice in cui è possibile trovare l'elemento scelto
     * @param x elemento da cercare
     * @return index dell' elemento o -1 in caso non venga trovato
     */
    public int indexOf(int x) {
      int index = binarySearch(x);
      return (index >= 0) ? index : -1;
    }
    
    /**
     * Restituisce una versione stampabile dell'array ordinato.
     * @return String
     */
    @Override
    public String toString() {
      String s= "[";
      for(int i = 0; i < size-1; i++) {
        s += this.elements[i] + ", ";
      }
      if(size > 0)
        s += this.elements[size-1];
      s += "]";
      return s;
    }
}
