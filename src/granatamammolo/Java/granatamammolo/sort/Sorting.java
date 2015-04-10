package granatamammolo.Java.granatamammolo.sort;

/**
 *
 * @author Federica
 */
public class Sorting {
  
// *****************************************************************************
// *********************** ISSORTED ********************************************
// *****************************************************************************
  
  /**
   * Controlla che l'array sia ordinato.
   * @param a Array da controllare.
   * @return true se l'array è ordinato, false altrimenti.
   */
  public static boolean isSorted(int[] a){
    if(a.length == 0 || a.length == 1) return false;
    for(int i = 0; i < a.length-1; i++)
      if(a[i] > a[i+1])
        return false;
    return true;
  }
  
//  public static <T extends Comparable<?superT>> boolean isSorted (T[] a){
//    
//  }
  
// *****************************************************************************
// *********************** SELECTION SORT **************************************
// *****************************************************************************
  
  /**
   * Implementazione dell'algoritmo Selection Sort.
   * @param a Array da ordinare.
   */
  public static void ssort(int[] a){
    int i = 0, n = a.length;
    while(i < n){
      int iMin = i;
      for(int j = i+1; j < n-1; j++){
        if(a[j] < a[i]){
          a[i] = a[j];
          iMin = j;
        }
      }
      if(iMin != i)
        scambia(a, iMin, i);
      i++;
    }    
  }
  
  /**
   * Metodo di supporto per il Selection sort. Scambia di posizione due valori.
   * @param a Array su cui operare.
   * @param iMin Indice dell'elemento minimo.
   * @param index Indice in cui inserire l'elemento minimo.
   */
  private static void scambia(int[] a, int iMin, int index){
    int tmp = a[index];
    a[index] = a[iMin];
    a[iMin] = tmp;      
  }
  
//  public static <T extends Comparable<?superT>> boolean ssort (T[] a){
//    
//  }

// *****************************************************************************
// *********************** INSERTION SORT **************************************
// *****************************************************************************
  
  /**
   * Implementazione dell'algoritmo Insertion Sort.
   * @param a Algoritmo da ordinare.
   */
  public static void isort(int[] a){
    int n = a.length;
    if(n > 1){
      for(int i = 1; i < n; i++){
        int j = i-1;
        if(a[i] < a[j]){
          while(a[i] < a[j])
            j--;
          inserisci(a, j, i);
        }
      }   
    }
  }
  
  /**
   * Metodo di supporto per l'Insertion Sort. Inserisce l'elemento in posizione 
   * i in posizione j, shiftando il resto dell'array di una posizione.
   * @param a Array su cui operare.
   * @param j Posizione di destinazione dell'elemento.
   * @param i Posizione originale dell'elemento.
   */
  private static void inserisci(int[] a, int j, int i){
    int val = a[i];
    for(int k = i; k > j; k--){
      a[k] = a[k-1];
    }
    a[j] = val;
  }
  
//  public static <T extends Comparable<?superT>> boolean isort (T[] a){
//    
//  }
  
  /**
   * Insertion sort con utilizzo della ricerca binaria del punto di inserimento.
   * @param a Array da ordinare.
   */
  public static void iSortBin(int[] a){
    int n = a.length;
    if(n > 1){
      for(int i = 1; i < n; i++){
        int j = i-1;
        if(a[i] < a[j]){
          int pos = ricercaBinaria(a, a[i], j);
          inserisci(a, -pos+1, i);
        }
          
      }  
    }      
  }
  
  /**
   * Metodo di supporto per l'Insertion Sort. Ricerca binaria (versione
   * leggermente modificata) per determinare il punto di inserimento del
   * valore.
   * @param a Array su cui operare.
   * @param val Valore da ordinare.
   * @param limite Indice massimo da considerare nell'array. Simula la fine 
   *                dell'array, perchè dall'indice successione c'è la porzione
   *                di array ancora da ordinare.
   * @return posizione di x nell'array o posizione dove inserirlo: -(pos+1)
   */
  private static int ricercaBinaria(int[] a, int val, int limite){
    int ini = 0, fin = limite; 
      if (fin == -1 || val < a[ini]) 
        return -1;
      if (val > a[fin]) 
        return -(limite + 1);
      while (ini <= fin) {
        int i = (ini + fin) >>> 1;
        if (val < a[i])
          fin = i - 1;
        else if (val > a[i])
          ini = i + 1;
        else
          return i;
      }
      return -(ini+1);
  }
  
// *****************************************************************************
// *********************** MERGE SORT ******************************************
// *****************************************************************************
  
  /**
   * Implementazione del Merge Sort.
   * @param a Array da ordinare.
   */
  public static void mSortBasic(int[] a){
    
  }
}
