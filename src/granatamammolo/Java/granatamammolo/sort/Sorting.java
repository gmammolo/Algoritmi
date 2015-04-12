package granatamammolo.Java.granatamammolo.sort;

/**
 *
 * @author Federica
 */
public class Sorting {
    
  /**
   * Controlla che l'array sia ordinato.
   * @param a Array da controllare.
   * @return <code>true</code> se l'array è ordinato, <code>false</code> altrimenti.
   */
  public static boolean isSorted(int[] a){
    if(a.length == 0 || a.length == 1) 
      return true;
    for(int i = 0; i < a.length-1; i++)
      if(a[i] > a[i+1])
        return false;
    return true;
  }

  public static  <T extends Comparable<? super T>> boolean isSorted (T[] a) {
    if(a.length == 0 || a.length == 1) 
      return true;
    for(int i = 0; i < a.length-1; i++)
      if(a[i].compareTo(a[i+1]) > 0)
        return false; 
    return true;
  }

  
// *****************************************************************************
// *********************** SELECTION SORT **************************************
// *****************************************************************************
  
  /**
   * Implementazione dell'algoritmo Selection Sort.
   * @param a Array da ordinare.
   */
  public static void ssort(int[] a){
    int n = a.length;
    for(int i = 0; i < n-1; i++) {
      // trova il minimo nella porzione successiva ad i
      int iMin = i;
      for(int j = i+1; j < n; j++){
        if(a[j] < a[iMin])
          iMin = j;
      }
      if(iMin != i)
        scambia(a, iMin, i);
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
  
  /**
   * Implementazione del Selection Sort per mezzo dei tipi generici.
   * @param <T> Tipo dell'array.      TOSEE è giusto scritto così?
   * @param a Array da ordinare.
   */
  public static <T extends Comparable<? super T>> void ssort (T[] a){
    int n = a.length;
    for(int i = 0; i < n-1; i++) {
      // trova il minimo nella porzione successiva ad i
      int iMin = i;
      for(int j = i+1; j < n; j++){
        if(a[j].compareTo(a[iMin]) < 0)
          iMin = j;
      }
      if(iMin != i)
        scambia(a, iMin, i);
    } 
  }
 
  /**
   * Metodo di supporto per il Selection sort. Scambia di posizione due valori.
   * @param <T> Tipo dell'array.      TOSEE è giusto scritto così?
   * @param a Array su cui operare.
   * @param iMin Indice dell'elemento minimo.
   * @param index Indice in cui inserire l'elemento minimo.
   */
  private static <T extends Comparable<? super T>> void scambia(T[] a, int iMin, int index){
    T tmp = a[index];
    a[index] = a[iMin];
    a[iMin] = tmp;      
  }

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
        int val = a[i];
        int j = i;
          while(j > 0 && val < a[j-1]){
            a[j] = a[j-1];
            j--;
          }
          a[j] = val;
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
  
  public static <T extends Comparable<? super T>> void isort (T[] a){
    int n = a.length;
    if(n > 1){
      for(int i = 1; i < n; i++){      
        T val = a[i];
        int j = i;
        while(j > 0 && a[j-1].compareTo(val) > 0){
          a[j] = a[j-1];
          j--;
        }
        a[j] = val;
      }   
    }
  }
  
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
          int pos = ricercaBinaria(a, a[i], 0, j);
          inserisci(a, pos, i);
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
   * @param ini Indice iniziale della porzione da considerare per la ricerca.
   * @param fin Indice finale della porzione da considerare per la ricerca.
   * @return Posizione dove inserire val,
   */
  private static int ricercaBinaria(int[] a, int val, int ini, int fin){
    if(val < a[ini])  return ini;
    if(val >= a[fin])  return fin+1;
    int middle;
    while(ini <= fin){
      middle = (ini + fin) >>> 1;
      if(val < a[middle]) 
        fin = middle-1;
      else  
        ini = middle+1;
    }
    return ini;
  }
  
// *****************************************************************************
// *********************** MERGE SORT ******************************************
// *****************************************************************************
  
  /**
   * Implementazione del Merge Sort. Versione non ottimizzata
   * @param a Array da ordinare.
   */
  public static void mSortBasic(int[] a){
    mSortBasicRic(a, 0, a.length-1);
  }
  
  private static void mSortBasicRic(int[] a, int first, int last){
    if(first < last){
      int half = (first + last) / 2;
      mSortBasicRic(a, first, half);
      mSortBasicRic(a, half+1, last);
      mergeBasic(a, first, half, last);
    }
  }  
  
  /**
   * Metodo di supporto per il Merge Sort. Fonde due porzioni ordinate dell'array
   * in una sola. Versione non ottimizzata.
   * @param a Array su cui operare.
   * @param fst Indice iniziale della prima porzione.
   * @param mid Indice finale della prima porzione.
   * @param lst Indice finale della seconda porzione.
   */
  static void mergeBasic(int[] a, int first, int middle, int last) {
    // dimensione array temporaneo
    int n = last - first + 1;
    int[] c = new int[n];
    int i = first, j = middle+1, k = 0; 
    // scorrimento delle due porzioni e inserimento nell'array temporaneo
    while(i <= middle && j <= last) {
      if(a[i] <= a[j]) c[k++] = a[i++];
      else             c[k++] = a[j++];
    }
    // inserimento in c dell'array non ancora esaurito
    while(i <= middle) 
      c[k++] = a[i++];
    while(j <= last) 
      c[k++] = a[j++];
    // copiatura di c all'interno dell'array originale
    for(int h = 0; h < n; h++) 
      a[first + h] = c[h];
  }

  /**
   * Implementazione del Merge Sort. Versione con un unico array ausiliario
   * e merge ottimizzato.
   * @param a Array da ordinare.
   */
  public static void mSortNoGarbage(int[] a){
    int n = a.length;
    int[] aux = new int[n];
    mSortNoGarbageRic(a, 0, n-1, aux);
  }

  private static void mSortNoGarbageRic(int[] a, int first, int last, int[] aux){
    if(first < last){
      int middle = (first + last) >>> 1;
      mSortNoGarbageRic(a, first, middle, aux);
      mSortNoGarbageRic(a, middle+1, last, aux);
      mergeOptimized(a, first, middle, last, aux);
    }
  } 
  
  /**
   * Metodo di supporto per il Merge Sort senza Garbage.
   * @param a Array su cui operare.
   * @param first Indice iniziale della prima porzione.
   * @param middle Indice finale della prima porzione.
   * @param last Indice finale della seconda porzione.
   * @param aux Array ausiliario/di supporto.
   */
  private static void mergeOptimized(int[] a, int first, int middle, int last, int[] aux){
    int i = first, j = middle+1;
    int k = first;
    while(i <= middle && j <= last){
      if(a[i] <= a[j])
        aux[k++] = a[i++];
      else 
        aux[k++] = a[j++];
    }
    // tutti i valori della porzione [middle+1 .. last] sono minori dei valori
    // rimanenti nella prima porzione [i .. middle]
    // quindi sono stati copiati tutti all'interno di aux
    // per questo motivo, la seconda porzione la si può considerare libera
    // per poterci copiare, dal più grande, i valori rimanenti tra [i .. middle]
    int h = middle, l = last;
    while(h >= i)
      a[l--] = a[h--];
    // trasferimento dei valori da aux[] ad a[]
    for(int m = first; m < l; m++)
      a[m] = aux[m];
  }
  
  /**
   * Implementazione del Merge Sort per mezzo dei tipi generici.
   * @param <T> Tipo dell'array.      TOSEE è giusto scritto così?
   * @param a Array da ordinare.
   */
  public static <T extends Comparable<? super T>> void msortNoGarbage (T[] a ){
    int n = a.length;
    T[] aux = (T[]) new Object[n];
    mSortNoGarbageRic(a, 0, n-1, aux);
  }
  
   private static <T extends Comparable<? super T>> void mSortNoGarbageRic(T[] a, int first, int last, T[] aux){
    if(first < last){
      int middle = (first + last) >>> 1;
      mSortNoGarbageRic(a, first, middle, aux);
      mSortNoGarbageRic(a, middle+1, last, aux);
      mergeOptimized(a, first, middle, last, aux);
    }
  } 
   
  private static <T extends Comparable<? super T>> void mergeOptimized(T[] a, int first, int middle, int last, T[] aux){
    int i = first, j = middle+1;
    int k = first;
    while(i <= middle && j <= last){
      if(a[i].compareTo(a[j]) <= 0)
        aux[k++] = a[i++];
      else 
        aux[k++] = a[j++];
    }
    // tutti i valori della porzione [middle+1 .. last] sono minori dei valori
    // rimanenti nella prima porzione [i .. middle]
    // quindi sono stati copiati tutti all'interno di aux
    // per questo motivo, la seconda porzione la si può considerare libera
    // per poterci copiare, dal più grande, i valori rimanenti tra [i .. middle]
    int h = middle, l = last;
    while(h >= i)
      a[l--] = a[h--];
    // trasferimento dei valori da aux[] ad a[]
    for(int m = first; m < l; m++)
      a[m] = aux[m];
  }
  
  /**
   * Implementazione del Merge Sort - versione "a passo alternato".
   * @param a Array da ordinare.
   */
  public static void mSortAlt (int[] a){
    int n = a.length;
    int[] aux = a.clone();
    mSortAltRic(a, 0, n-1, aux);
  }
  
  private static void mSortAltRic(int[] a, int first, int last, int[] b){
    if(first < last){
      int middle = (first + last) >>> 1;
      mSortAltRic(b, first, middle, a);
      mSortAltRic(b, middle+1, last, a);
      mergeAlt(b, first, middle, last, a);
    }
  }
  
  private static void mergeAlt(int[] a, int first, int middle, int last, int[] c) {
    int i = first, j = middle+1, k = 0; 
    // scorrimento delle due porzioni e inserimento nell'array temporaneo
    while(i <= middle && j <= last) {
      if(a[i] <= a[j]) c[k++] = a[i++];
      else             c[k++] = a[j++];
    }
    // inserimento in c dell'array non ancora esaurito
    while(i <= middle) 
      c[k++] = a[i++];
    while(j <= last) 
      c[k++] = a[j++];
  }
  
  /**
   * Implementazione del Merge Sort versione alternata per mezzo dei tipi generici.
   * @param <T> Tipo dell'array.      TOSEE è giusto scritto così?
   * @param a Array da ordinare.
   */
  public static <T extends Comparable<? super T>> void msortAlt (T[ ] a ){
    int n = a.length;
    T[] aux = a.clone();
    mSortAltRic(a, 0, n-1, aux);
  }
  
  private static <T extends Comparable<? super T>> void mSortAltRic(T[] a, int first, int last, T[] b){
    if(first < last){
      int middle = (first + last) >>> 1;
      mSortAltRic(b, first, middle, a);
      mSortAltRic(b, middle+1, last, a);
      mergeAlt(b, first, middle, last, a);
    }
  }
  
  private static <T extends Comparable<? super T>> void mergeAlt(T[] a, int first, int middle, int last, T[] c) {
    int i = first, j = middle+1, k = 0; 
    // scorrimento delle due porzioni e inserimento nell'array temporaneo
    while(i <= middle && j <= last) {
      if(a[i].compareTo(a[j]) <= 0) c[k++] = a[i++];
      else                          c[k++] = a[j++];
    }
    // inserimento in c dell'array non ancora esaurito
    while(i <= middle) 
      c[k++] = a[i++];
    while(j <= last) 
      c[k++] = a[j++];
  }
  
  /**
   * Implementazione del Merge Sort ottimizzato, con l'utilizzo dell'Insertion
   * Sort al di sotto di una certa soglia.
   * @param a 
   */
  public static void mSortIsort(int[] a){
    
  }

    public static <T extends Comparable<? super T>> void iSortBin(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static  <T extends Comparable<? super T>>  void mSortBasic(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}// end class
