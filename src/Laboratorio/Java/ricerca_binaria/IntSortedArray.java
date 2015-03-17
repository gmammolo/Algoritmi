/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio.Java.ricerca_binaria;

import java.util.ArrayList;
import java.util.Arrays;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author giuseppe
 */
public class IntSortedArray {

    private Integer[] m_elements;
    private int m_size;
    
    /**
     * Indica se utilizzare il metodo Ricorsivo o iterativo per la Ricerca Binaria
     */
    public static boolean recursive = true;

    /**
     * Crea un Array  con capacità 16 elementi con valori inizializzati a 0 
     */
    public IntSortedArray() {
        this(16);
    }

    /**
     * Crea un array di capacità definita
     * @param capacity capacità dell' array 
     */
    public IntSortedArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Non può essere negativo");
        }

        m_elements = new Integer[capacity];
        m_size = 0;
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
     * <p>Metodo Pubblico per la Ricerca Binaria. Richiama la ricerca binaria
     * con il metodo Ricorsivo o Iterativo in base al valore settato in 
     * <code>static boolean recursive </code></p>
     * @see RecursiveRicercaBinaria#recursiveRicercaBinaria e IterativeRicercaBinaria per maggiori 
     * informazioni
     * @param search valore da cercare
     * @return l'index dell' elemento cercato oppure la posizione dove inserirlo 
     * nel caso non sia presente nell' array nella forma -(index -1)
     */
    public int ricercaBinaria(int search)
    {
        if(IntSortedArray.recursive)
            return IntSortedArray.this.recursiveRicercaBinaria(search);
        else
            return iterativeRicercaBinaria(search);
    }
    
    /**
     * Esegue la ricerca binaria raffinata  in modo iterativo 
     * @param search intero da cercare dentro l'array
     * @return la posizione dell' elemento <code>search</code> oppure la 
     * posizione dove inserirlo: <code>-(pos+1)</code>
     */
    public int iterativeRicercaBinaria(int search) {
        int ini = 0, fin = m_size - 1;
        if (fin == -1 || search < m_elements[0]) 
            return -1;
        if (search > m_elements[fin])
            return -(m_size + 1);
        while (ini <= fin) {
            int i = (ini + fin) >>> 1;
            if (search < m_elements[i]) {
                fin = i - 1;
            } else if (search > m_elements[i]) {
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
        return m_size;
    }
    
    /**
     * Esegue la ricerca binaria raffinata  in modo ricorsivo 
     * @param search intero da cercare dentro l'array
     * @return la posizione dell' elemento <code>search</code> oppure la 
     * posizione dove inserirlo: <code>-(pos+1)</code>
     */
    public int recursiveRicercaBinaria(int search) {
        if (m_size == 0 || search < m_elements[0]) 
            return -1;
        if (search > m_elements[m_size-1])
            return -(m_size + 1);
        return IntSortedArray.this.recursiveRicercaBinaria(search, 0, m_size-1);
    }
    
    private int recursiveRicercaBinaria(int search, int start, int end) {
        
        if (start > end)
           return -(start + 1);
        int i = (start + end) >>> 1;
        if (search == m_elements[i]) {
            return i;
        } else if (start > end) {
            return -(end + 1);
        } else if (search < m_elements[i]) {
            return IntSortedArray.this.recursiveRicercaBinaria(search, start, i - 1);
        } else //if(search > m_elements[i])
        {
            return IntSortedArray.this.recursiveRicercaBinaria(search, i + 1, end);
        }

    }

    /**
     * inserisce l'elemento nell' array mantenendolo Ordinato <br>
     * Lo Inserisce Anche se è già presente (ripetendolo più volte). <br>
     * Se l'array è già pieno lo rialloca in un array di dimensione doppia 
     * e poi inserisce  l'elemento
     * @param element elemento da inserire
     */
    public void insert(int element) {
        int index = ricercaBinaria(element);

        if(m_size >=m_elements.length)
        {
            //rialloca
            Integer[] t = new Integer[m_size*2];
            for(int i=0; i<m_size; i++)
                t[i]=m_elements[i];
            m_elements=t;
        }
        if (index < 0) 
            index=-index - 1;
        if(index < m_size)
        {
            for(int i=m_size; i>index; i--)
            {
                m_elements[i] = m_elements[i-1];
            }
        }
        m_elements[index] = element;
        m_size++;
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
        if(index< 0 || index > m_size)
            throw  new ArrayIndexOutOfBoundsException("Elemento non trovato");
        return m_elements[index];
    }
    
    /**
     * Ritorna l'indice in cui è possibile trovare l'elemento scelto
     * @param element elemento da cercare
     * @return index dell' elemento o -1 in caso non venga trovato
     */
    public int indexOf(int element) throws ArrayIndexOutOfBoundsException{
            int index = ricercaBinaria(element);
            return ( index > 0 ) ? index : -1;
    }

    /**
     * restituisce una versione stampabile dell' array
     * @return 
     */
    public String toString() {
        String s= "[ ";
        for(int i=0; i< m_size-1; i++)
        {
           s += m_elements[i] + " , ";
        }
       s+= m_elements[m_size-1] + " ]";
       return s;
    }
}
