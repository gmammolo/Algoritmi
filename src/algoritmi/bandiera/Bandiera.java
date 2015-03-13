/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmi.bandiera;

/**
 *
 * @author giuseppe
 */
public class Bandiera {
    /**
     * Rappresenta il colore <i>Verde</i>, che nel nostro caso corrisponde 
     * ai numeri <code>n%3=1</code>
     */
    protected final static int VERDE = 1;
        /**
     * Rappresenta il colore <i>Bianco</i>, che nel nostro caso corrisponde 
     * ai numeri <code>n%3=2</code>
     */
    protected final static int BIANCO = 2;
        /**
     * Rappresenta il colore <i>Rosso</i>, che nel nostro caso corrisponde 
     * ai numeri <code>n%3=0</code>
     */
    protected final static int ROSSO = 0;
    
    /**
     * Esegue l'algoritmo della Bandiera Ottimizzato 
     * <b>Modificando il parametro in ingresso.</b><br>
     * NOTE: Ho scelto di Usare un <code>Integer[]</code> e non <code>int[]</code>
     * perchè per una comoda stampa ho utilizzato il metodo 
     * <code>Arrays.deepToString(array)</code> che richiede come argomento un 
     * array di elementi castabili come <code>Object</code>.<br>
     * @param a array di <code>Integer</code> che viene riordinato secondo 
     * l'algoritmo della bandiera. Java effettua il passaggio di Object per 
     * riferimento, quindi il parametrò verrà modificato
     */
    public static void Bandiera(Integer[] a) {
        int j,i=j=0;
        int k=a.length-1;
        while(j<k)
        {
            int aj = a[j];
            if(a[j]%3==VERDE)
            {
                a[j]=a[i];
                a[i]=aj;
                i++;j++;
            }
            else if(a[j]%3==BIANCO)
            {
                j++;
            }
            else if(a[j]%3==ROSSO)
            {
                while(k-1 > j && a[k-1]%3==ROSSO)
                    k--;
                a[j]=a[k];
                a[k]=aj;
                k--;
            }
        }
    }
    
    /**
     * Esegue l'algoritmo della Bandiera Ottimizzato
     * <b>Lasciando Invariato il parametro in ingresso.</b><br>
     * NOTE: Ho scelto di Usare un <code>Integer[]</code> e non <code>int[]</code>
     * perchè per una comoda stampa ho utilizzato il metodo 
     * <code>Arrays.deepToString(array)</code> che richiede come argomento un 
     * array di elementi castabili come <code>Object</code>.<br>
     * @param array array di <code>Integer</code> che viene riordinato secondo 
     * l'algoritmo della bandiera. L'array resta invariato
     * @return <code>Integer[]</code> contenente una copia dell' array riordinato
     * con l'algoritmo della bandiera
     */
   public static Integer[] Bandiera_Copy(Integer[] array) {
        Integer[] a = array.clone();
        int j,i=j=0;
        int k=a.length-1;
        while(j<k)
        {
            int aj = a[j];
            if(a[j]%3==VERDE)
            {
                a[j]=a[i];
                a[i]=aj;
                i++;j++;
            }
            else if(a[j]%3==BIANCO)
            {
                j++;
            }
            else if(a[j]%3==ROSSO)
            {
                while(k-1 > j && a[k-1]%3==ROSSO)
                    k--;
                a[j]=a[k];
                a[k]=aj;
                k--;
            }    
        }
        return a;
    }
    
}
