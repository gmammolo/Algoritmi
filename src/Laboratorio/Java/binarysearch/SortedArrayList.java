/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio.Java.binarysearch;

import java.util.ArrayList;

/**
 * 
 * @author Giuseppe
 * @param <E> Generic Type Comparable
 */
public class SortedArrayList<E extends Comparable<E>> {
    
    protected ArrayList<E> elements;
    
    /**
     * Indica se utilizzare il metodo Ricorsivo o iterativo per la Ricerca Binaria
     */
    public static boolean recursive = false;

    /**
     * Crea un Array  con capacità 16 elementi con valori inizializzati a 0 
     */
    public SortedArrayList() {
        this(16);
    }

    /**
     * Crea un array di capacità definita
     * @param initialCapacity capacità dell' array 
     * @throws IllegalArgumentException Lancia l'eccezione se il valore iniziale
     * inserito è negativo
     */
    public SortedArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Non può essere negativo");
        }

        elements = new ArrayList<>(initialCapacity);
    }

    /**
     * Crea un array di capacità <code>array.length + 16</code> e inserisce al 
     * suo interno gli elementi dell' array a
     * @param a array di int non necessariamente ordinato di valori iniziali
     */
    public SortedArrayList(ArrayList<E> a) {
        this(a.size() + 16);
        for(int i=0; i< a.size();i++)
            this.insert(a.get(i));
    }
    
    /**
     * <p>Metodo per la Ricerca Binaria. Richiama la ricerca binaria
     * con il metodo Ricorsivo o Iterativo in base al valore settato in 
     * <code>static boolean recursive </code></p>
     * <p>di default usa la ricerca iterativa, in quanto è quella specificata nel pdf</p>
     * @see recursiveBinarySearch 
     * @see iterativeBinarySearch 
     * @param search valore da cercare
     * @return l'index dell' elemento cercato oppure la posizione dove inserirlo 
     * nel caso non sia presente nell' array nella forma -(index -1)
     */
    protected int binarySearch(E search)
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
    protected int iterativeBinarySearch(E search) {
        int ini = 0, fin = size() - 1;
        if (fin == -1 || search.compareTo(elements.get(0)) < 0 ) 
            return -1;
        if (search.compareTo(elements.get(fin)) > 0)
            return -(size() + 1);
        while (ini <= fin) {
            int i = (ini + fin) >>> 1;
            if (search.compareTo(elements.get(i)) < 0) {
                fin = i - 1;
            } else if (search.compareTo( elements.get(i)) >0 ) {
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
        return elements.size();
    }
    
    /**
     * Esegue la ricerca binaria raffinata  in modo ricorsivo 
     * @param search intero da cercare dentro l'array
     * @return la posizione dell' elemento <code>search</code> oppure la 
     * posizione dove inserirlo: <code>-(pos+1)</code>
     */
    protected int recursiveBinarySearch(E search) {
        if (size() == 0 || search.compareTo( elements.get(0)) < 0) 
            return -1;
        if (search.compareTo(elements.get(size() - 1)) > 0)
            return -(size() + 1);
        return recursiveBinarySearch(search, 0, size()-1);
    }
    
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
     * inserisce l'elemento nell' array mantenendolo Ordinato <br>
     * Lo Inserisce Anche se è già presente (ripetendolo più volte). <br>
     * Se l'array è già pieno lo rialloca in un array di dimensione doppia 
     * e poi inserisce  l'elemento
     * @param element elemento da inserire
     * @return int ritorna l'indice in cui è stato inserito l'elemento
     */
    public int insert(E element) {
        int index = binarySearch(element);
        if(size() >=elements.size())
            elements.ensureCapacity(size()*2+16);
        if (index < 0) 
            index=-index - 1;
        elements.add(index, element);
        return index;
    }
   

    /**
     * Restituisce l'elemento al posto indicato
     * @param index posizione in cui cercare
     * @return valore dell' array
     * @throws ArrayIndexOutOfBoundsException Nel caso in cui l'indice non è
     * accettabile
     */
    public E get(int index) throws ArrayIndexOutOfBoundsException
    {    
        if(index< 0 || index >= size())
            throw  new ArrayIndexOutOfBoundsException("Elemento non trovato");
        return elements.get(index);
    }
    
    /**
     * Ritorna l'indice in cui è possibile trovare l'elemento scelto
     * @param element elemento da cercare
     * @return index dell' elemento o -1 in caso non venga trovato
     */
    public int indexOf(E element) {
            int index = binarySearch(element);
            return ( index >= 0 ) ? index : -1;
    }


    
    /**
     * restituisce una versione stampabile dell' array
     * @return String
     */
    public String toString() {
        String s= "[";
        for(int i=0; i< size()-1; i++)
        {
           s += elements.get(i) + ", ";
        }
        if(size() > 0)
            s+= elements.get(size()-1);
        s+= "]";
       return s;
    }
    
}
