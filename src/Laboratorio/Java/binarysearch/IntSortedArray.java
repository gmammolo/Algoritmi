/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio.Java.binarysearch;

/**
 *
 * @author giuseppe
 */
public class IntSortedArray {

    protected Integer[] elements;
    protected int size;
    
    /**
     * Indica se utilizzare il metodo Ricorsivo o iterativo per la Ricerca Binaria
     */
    public static boolean recursive = false;

    /**
     * Crea un Array  con capacità 16 elementi con valori inizializzati a 0 
     */
    public IntSortedArray() {
        this(16);
    }

    /**
     * Crea un array di capacità definita
     * @param initialCapacity capacità dell' array 
     * @throws IllegalArgumentException Lancia l'eccezione se il valore iniziale
     * inserito è negativo
     */
    public IntSortedArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Non può essere negativo");
        }

        elements = new Integer[initialCapacity];
        size = 0;
    }

    /**
     * Crea un array di capacità <code>array.length + 16</code> e inserisce al 
     * suo interno gli elementi dell' array a
     * @param a array di int non necessariamente ordinato di valori iniziali
     */
    public IntSortedArray(int[] a) {
        this(a.length + 16);
        for(int i=0; i< a.length;i++)
            this.insert(a[i]);
    }
    
    /**
     * <p>Metodo per la Ricerca Binaria. Richiama la ricerca binaria
     * con il metodo Ricorsivo o Iterativo in base al valore settato in 
     * <code>static boolean recursive </code></p>
     * <p>di default usa la ricerca iterativa, in quanto è quella specificata nel pdf</p>
     * @see  iterativeBinarySearch e recursiveBinarySearch per maggiori 
     * informazioni
     * @param search valore da cercare
     * @return l'index dell' elemento cercato oppure la posizione dove inserirlo 
     * nel caso non sia presente nell' array nella forma -(index -1)
     */
    protected int binarySearch(int search)
    {
        if(IntSortedArray.recursive)
            return recursiveBinarySearch(search);
        else
            return iterativeBinarySearch(search);
    }
    
    /**
     * Esegue la ricerca binaria raffinata  in modo iterativo 
     * @param search intero da cercare dentro l'array
     * @return la posizione dell' elemento <code>search</code> oppure la 
     * posizione dove inserirlo: <code>-(pos+1)</code>
     */
    protected int iterativeBinarySearch(int search) {
        int ini = 0, fin = size - 1;
        if (fin == -1 || search < elements[0]) 
            return -1;
        if (search > elements[fin])
            return -(size + 1);
        while (ini <= fin) {
            int i = (ini + fin) >>> 1;
            if (search < elements[i]) {
                fin = i - 1;
            } else if (search > elements[i]) {
                ini = i + 1;
            } else {
                return i;
            }
        }
        return -(ini+1);
    }
     
    /**
     * 
     * @return Numero di Elementi insetiti dentro l'array 
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Esegue la ricerca binaria raffinata  in modo ricorsivo 
     * @param search intero da cercare dentro l'array
     * @return la posizione dell' elemento <code>search</code> oppure la 
     * posizione dove inserirlo: <code>-(pos+1)</code>
     */
    protected int recursiveBinarySearch(int search) {
        if (size == 0 || search < elements[0]) 
            return -1;
        if (search > elements[size-1])
            return -(size + 1);
        return recursiveBinarySearch(search, 0, size-1);
    }
    
    private int recursiveBinarySearch(int search, int start, int end) {
        
        if (start > end)
           return -(start + 1);
        int i = (start + end) >>> 1;
        if (search == elements[i]) {
            return i;
        } else if (start > end) {
            return -(end + 1);
        } else if (search < elements[i]) {
            return recursiveBinarySearch(search, start, i - 1);
        } else { //if(search > elements[i])
        
            return recursiveBinarySearch(search, i + 1, end);
        }

    }

    /**
     * Rialloca l'array elements  in un array di dimensione doppia.
     * <p>Viene richiamato da insert()</p>
     */
    private void reallocate() {
        Integer[] t = new Integer[size*2];
        for(int i=0; i<size; i++)
            t[i]=elements[i];
        elements=t;
    }
    
    /**
     * inserisce l'elemento nell' array mantenendolo Ordinato <br>
     * Lo Inserisce Anche se è già presente (ripetendolo più volte). <br>
     * Se l'array è già pieno lo rialloca in un array di dimensione doppia 
     * e poi inserisce  l'elemento
     * @param element elemento da inserire
     * @return int ritorna l'indice in cui è stato inserito l'elemento
     */
    public int insert(int element) {
        int index = binarySearch(element);
        if(size >=elements.length)
            reallocate();
        if (index < 0) 
            index=-index - 1;
        if(index < size) {
            for(int i=size; i>index; i--)
            {
                elements[i] = elements[i-1];
            }
        }
        elements[index] = element;
        size++;
        return index;
    }
   

    /**
     * Restituisce l'elemento al posto indicato
     * @param index posizione in cui cercare
     * @return valore dell' array
     * @throws ArrayIndexOutOfBoundsException Nel caso in cui l'indice non è
     * accettabile
     */
    public int get(int index) throws ArrayIndexOutOfBoundsException
    {    
        if(index< 0 || index >= size)
            throw  new ArrayIndexOutOfBoundsException("Elemento non trovato");
        return elements[index];
    }
    
    /**
     * Ritorna l'indice in cui è possibile trovare l'elemento scelto
     * @param element elemento da cercare
     * @return index dell' elemento o -1 in caso non venga trovato
     */
    public int indexOf(int element) {
            int index = binarySearch(element);
            return ( index >= 0 ) ? index : -1;
    }
    
    /**
     * restituisce una versione stampabile dell' array
     * @return String
     */
    public String toString() {
        String s= "[";
        for(int i=0; i< size-1; i++)
        {
           s += elements[i] + ", ";
        }
        if(size > 0)
            s+= elements[size-1];
        s+= "]";
       return s;
    }
    

}
