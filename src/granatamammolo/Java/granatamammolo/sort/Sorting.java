package granatamammolo.Java.granatamammolo.sort;

/**
 *
 * @author Federica
 */
public class Sorting {
    
  /**
   * Classe statica non istanziabile
   */
  private Sorting() {}  
    
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

  
  /**
   * Controlla che l'array sia ordinato.
   * @param <T>  extends Comparable
   * @param a  array da ordinare
   * @return <code>true</code> se l'array è ordinato, <code>false</code> altrimenti.
   */
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
   * Implementazione dell'algoritmo di ordinamento del Selection Sort.
   * L'algoritmo scorre l'array   e cerca sempre l' elemento minore  tra i successivi. quando lo trova lo 
   * riordina e riparte a cercare il nuovo minimo nella porzione di array rimasta. termina quando tutto l'array 
   * è stato ordinato. <br>
   * -<b>Caso Migliore= Caso peggiore = Caso medio </b>= O(n^2) [Quadratico]  <br>
   * -<b>Sul Posto</b> <br>
   * -<b>Non Stabile</b><br>
   * <p><i>OTTIMIZZAZIONE: il primo for scorre gli elementi da 0 a n-1, mentre il for interno va da i a n</i></p>
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
        swap(a, iMin, i);
    }    
  }
  
  /**
   * Metodo di supporto per il Selection sort. Scambia di posizione due valori.
   * @param a Array su cui operare.
   * @param iMin Indice dell'elemento minimo.
   * @param index Indice in cui inserire l'elemento minimo.
   */
  private static void swap(int[] a, int iMin, int index){
    int tmp = a[index];
    a[index] = a[iMin];
    a[iMin] = tmp;      
  }
  
  /**
   * Implementazione del Selection Sort per mezzo dei tipi generici.
   * L'algoritmo scorre l'array   per ogni elemento  cerca un elemento minore  tra i successivi.
   * Se lo trova, scambia i due elementi. 
   * <p><i>OTTIMIZZAZIONE: il primo for scorre gli elementi da 0 a n-1, mentre il for interno va da i a n</i></p>
   * -<b>Caso Migliore= Caso peggiore = Caso medio </b> = O(n^2) [Quadratico] <br>
   * -<b>Sul Posto</b> <br>
   * -<b>Non Stabile</b> <br>
   * @param <T> extends Comparable
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
        swap(a, iMin, i);
    } 
  }
 
  /**
   * Metodo di supporto per il Selection sort. Scambia di posizione due valori.
   * @param <T> extends Comparable
   * @param a Array su cui operare.
   * @param iMin Indice dell'elemento minimo.
   * @param index Indice in cui inserire l'elemento minimo.
   */
  private static <T extends Comparable<? super T>> void swap(T[] a, int iMin, int index){
    T tmp = a[index];
    a[index] = a[iMin];
    a[iMin] = tmp;      
  }

// *****************************************************************************
// *********************** INSERTION SORT **************************************
// *****************************************************************************
  
  /**
   * <p>Implementazione dell'algoritmo di <strong>ordinamento</strong> Insertion Sort.
   * Si prende via via l'elemento successivo e lo si inserisce in maniera ordinata nella parte che era già
   * stata ordinata</p>
   * <p>-<strong>Caso Peggiore:</strong>L'array di partenza è ordinato inversamente.  O(n^2)</p>
   * <p>-<strong>Caso Migliore:</strong>L'array di partenza è già ordinato: O(n)</p>
   * <p>-<strong>Caso Medio:</strong> O(n) ~ O(n^2)</p>
   * <p>-<strong>Sul Posto</strong></p>
   * <p>-<strong>Stabile:</strong> l'array posiziona ogni elemento nel primo posto utile per ordinare l'array
   * e una volta posizionato non sarà più spostato, mantenendo stabile l'algoritmo</p>
   * @param a Algoritmo da ordinare.
   */
  public static void isort(int[] a){
    int n = a.length;
    if(n > 1){
      for(int i = 1; i < n; i++){
        int val = a[i];
        int j = i;
          while(j > 0 && val < a[j-1]){
            a[j] = a[--j]; 
          }
          a[j] = val;
      }   
    }
  }
  
  /**
   * Metodo di supporto per l'Insertion Sort (Versione con Ricerca binaria). Inserisce l'elemento di posizione 
   * i in posizione j, shiftando il resto dell'array di una posizione.
   * @param a Array su cui operare.
   * @param j Posizione di destinazione dell'elemento.
   * @param i Posizione originale dell'elemento (<code>i-1</code> corrisponde con l'ultimo elemento
   * ordinato ).
   */
  private static void insert(int[] a, int j, int i){
    int val = a[i];
    for(int k = i; k > j; k--){
      a[k] = a[k-1];
    }
    a[j] = val;
  }
  
  /**
   * <p>Implementazione dell'algoritmo di <strong>ordinamento</strong> Insertion Sort.
   * Si prende via via l'elemento successivo e lo si inserisce in maniera ordinata nella parte che era già
   * stata ordinata</p>
   * <p><strong>Caso Peggiore:</strong>L'array di partenza è ordinato inversamente.  O(n^2)</p>
   * <p><strong>Caso Migliore:</strong>L'array di partenza è già ordinato: O(n)</p>
   * <p><strong>Caso Medio:</strong> O(n) ~ O(n^2)</p>
   * <p>-<strong>Sul Posto</strong></p>
   * <p>-<strong>Stabile:</strong> l'array posiziona ogni elemento nel primo posto utile per ordinare l'array
   * e una volta posizionato non sarà più spostato, mantenendo stabile l'algoritmo</p>
   * @param <T> extends Comparable
   * @param a  array da ordinare
   */
  public static <T extends Comparable<? super T>> void isort (T[] a){
    int n = a.length;
    if(n > 1){
      for(int i = 1; i < n; i++){      
        T val = a[i];
        int j = i;
        while(j > 0 && a[j-1].compareTo(val) > 0){
          a[j] = a[--j];
        }
        a[j] = val;
      }   
    }
  }
  
  /**
   * <p>Implementazione dell'algoritmo di <strong>ordinamento</strong> Insertion Sort con ausilio 
   * della ricerca binaria. Si prende via via l'elemento successivo e lo si inserisce in maniera 
   * ordinata nella parte che era già stata ordinata</p>
   * <p>NOTE SULLA RICERCA BINARIA: la ricerca binaria ha una complessita <code>O(log(n))</code> ,
   * a cui bisogna però aggiungere lo spostamento dei valori dell' array in avanti fino alla posizione occupata
   * dal valore da ordinare (che nell' algoritmo di base viene fatto nello stesso momento in cui si cerca
   * il valore) Dunque la complessità temporale rimane comunque quadratica nel caso peggiore</p>  //TOSEE: Assicurarsi che non ho scritto una fesseria ^^"
   * <p>-<strong>Caso Peggiore:</strong>L'array di partenza è ordinato inversamente.  O(n^2)</p>
   * <p>-<strong>Caso Migliore:</strong>L'array di partenza è già ordinato: O(n*log(n))</p> //TOSEE: verificare se è vero
   * <p>-<strong>Caso Medio:</strong> O(n) ~ O(n^2)</p>
   * <p>-<strong>Sul Posto</strong></p>
   * <p>-<strong>Stabile:</strong> La ricerca binaria ritorna sempre la posizione più a sinistra possibile (modificata per farlo)</p>
   * @param a Array da ordinare.
   */
  public static void iSortBin(int[] a){
    int n = a.length;
    if(n > 1){
      for(int i = 1; i < n; i++){
        int j = i-1;
        if(a[i] < a[j]){
          int pos = ricercaBinaria(a, a[i], 0, j);
          insert(a, pos, i);
        }          
      }  
    }      
  }
  
  /**
   * Metodo di supporto per l'Insertion Sort con Ricerca binaria per determinare il punto di
   * inserimento del valore.<br>
   * Complessità:<code> i= fin - ini := O(log(i))</code>
   * <p><i>NOTE: L'algoritmo è modificato in modo da non uscire appena trova la posizione adatta
   * per il valore cercato, ma continua per trovare la "posizione migliore", ovvero quella più a sinistra possibile
   * (in questo caso)</i></p>
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
   * Implementazione del Merge Sort( Versione non ottimizzata) <br>
   * <p></p>
   * <p>-<b>Complessità: </b> O(n*log(n)) </p>
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
   * <p>Complessità: O(n)</p>
   * @param a Array su cui operare.
   * @param first Indice iniziale della prima porzione.
   * @param middle Indice finale della prima porzione.
   * @param last Indice finale della seconda porzione.
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
   * @param a  array da ordinare
   */
  public static void mSortIsort(int[] a){
    
  }
  
}// end class
