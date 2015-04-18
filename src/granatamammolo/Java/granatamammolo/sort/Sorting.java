package granatamammolo.Java.granatamammolo.sort;

import java.util.Random;

/**
 *
 * @author Federica
 */
public class Sorting {
   // TOSEE devo levare tutti i commenti in mezzo 
  // TOSEE metodi di supporto renderli generici
  // TOSEE vedere nomi metodi (camel case)
  
  public static Random random = new Random();
  /**
   * Classe statica non istanziabile
   */
  private Sorting() {}  

  
 // <editor-fold defaultstate="collapsed" desc=" isSorted">

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
   // </editor-fold>
  
 // <editor-fold defaultstate="collapsed" desc=" SELECTION SORT ">
  
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

  
// </editor-fold>
  
 // <editor-fold defaultstate="collapsed" desc=" INSERTION SORT ">

  
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
          int pos = binarySearch(a, a[i], 0, j);
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
  private static int binarySearch(int[] a, int val, int ini, int fin){
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
  
  
  
// </editor-fold>
  
 // <editor-fold defaultstate="collapsed" desc=" MergeSort Base ">
  /**
   * Implementazione del Merge Sort( Versione non ottimizzata) <br>
   * <p>Algoritmo ricorsivo: divide l'array da ordinare in tanti piccoli array (N.B. in realtà lavora con gli indici,
   * quindi su porzioni dello stesso array ), fino ad arrivare  all' ultimo passo in cui gli array sono 
   * composti da 1 solo elemento.e poi li riordina risalendo (nel passo invariante generico si ha, quindi,
   * che i due array su cui fare il merge sono ordinati) </p>
   * <p>-<b>Complessità: </b> O(n*log(n)) </p>
   * <p>-<b>Non sul Posto:</b> nel merge viene usato un array ausiliario</p>
   * <p>-<b>Stabile:</b>L'algoritmo che esegue il merge fa in modo che se due elementi chiave
   * sono uguali, venga preso prima quello a sinistra.</p>
   * @param a Array da ordinare.
   */
  public static void mSortBasic(int[] a){
    mSortBasicRic(a, 0, a.length-1);
  }
  
  /**
   * Metodo privato ricorsivo richiamato inizialmente da mSortBasic
   * @see mSortBasic
   * @param a
   * @param first 
   * @param last 
   */
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
   * in una sola con l'ausilio di un array temporaneo (rende l'algoritmo non sul posto). <br>
   * Versione non ottimizzata.
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

   // </editor-fold>
  
 // <editor-fold defaultstate="collapsed" desc=" Merge Sort (No Garbage)">
  /**
   * Implementazione del Merge Sort. Versione con un unico array ausiliario e merge ottimizzato.
   * <p>Crea un array della stessa dimensione dell' array da ordinare che userà come supporto per
   * riordinare l'array a.</p>
   * <p>-<b>Complessità: </b> O(n*log(n)) </p>
   * <p>-<b>Non sul Posto:</b> nel merge viene usato un array ausiliario</p>
   * <p>-<b>Stabile:</b>L'algoritmo che esegue il merge fa in modo che se due elementi chiave
   * sono uguali, venga preso prima quello a sinistra.</p>
   * @param a Array da ordinare.
   */
  public static void mSortNoGarbage(int[] a){
    int n = a.length;
    int[] aux = new int[n];
    mSortNoGarbageRic(a, 0, n-1, aux);
  }

  /**
   * metodo ausiliario privato per mSortNoGarbage
   * @see mSortNoGarbage
   * @param a
   * @param first
   * @param last
   * @param aux 
   */
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
   * <b>Non<b> è a passo alternato, contiene le varie ottimizzazioni del merge
   * @param a Array su cui operare.
   * @param first Indice iniziale della prima porzione.
   * @param middle Indice finale della prima porzione.
   * @param last Indice finale della seconda porzione.
   * @param aux Array ausiliario/di supporto.
   */
  private static void mergeOptimized(int[] a, int first, int middle, int last, int[] aux){
    int i = first, j = middle+1;
    int k = first;
    // TOSEE: NON VEDO QUESTA OTTIMIZZAZIONE :
    //Se quando si deve effettuare la fusione l'ultimo elemento del segmento sinistro è minore o 
    //uguale al primo elemento del segmento di destra, la sequenza dei due segmenti è già un
    //segmento ordinato e quindi la fusione non è necessaria.
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
    for(int m = first; m < k; m++)
      a[m] = aux[m];
  }
  
  /**
   * Implementazione del Merge Sort per mezzo dei tipi generici.
   * <p>Crea un array della stessa dimensione dell' array da ordinare che userà come supporto per
   * riordinare l'array a.</p>
   * <p>-<b>Complessità: </b> O(n*log(n)) </p>
   * <p>-<b>Non sul Posto:</b> nel merge viene usato un array ausiliario</p>
   * <p>-<b>Stabile:</b>L'algoritmo che esegue il merge fa in modo che se due elementi chiave
   * sono uguali, venga preso prima quello a sinistra.</p>
   * @param <T> extends Comparable
   * @param a Array da ordinare.
   */
  public static <T extends Comparable<? super T>> void msortNoGarbage (T[] a ){
    int n = a.length;
    T[] aux = (T[]) new Object[n];
    mSortNoGarbageRic(a, 0, n-1, aux);
  }
  
  /**
   * Metodo Ausiliario privato usato da msortNoGarbage
   * @see msortNoGarbage
   * @param <T>
   * @param a
   * @param first
   * @param last
   * @param aux 
   */
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
    // TOSEE: NON VEDO QUESTA OTTIMIZZAZIONE :
    //Se quando si deve effettuare la fusione l'ultimo elemento del segmento sinistro è minore o 
    //uguale al primo elemento del segmento di destra, la sequenza dei due segmenti è già un
    //segmento ordinato e quindi la fusione non è necessaria.
    
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
  
  
   // </editor-fold>
  
 // <editor-fold defaultstate="collapsed" desc=" Merge Sort Alternato">  
  /**
   * Implementazione del Merge Sort - versione "a passo alternato".
   * Versione ottimizzata del merge sort: L'arrey ausiliario viene caricato con gli stessi valori dell' array
   * da ordinare e si esegue il merge usando in modo alternato porzioni dei due array, evitando cosi 
   * di dover caricare i valori ordinati nell' ausiliario dentro l'array originale.
   * @param a Array da ordinare.
   */
  public static void msortAlt (int[] a){
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
    
    // TOSEE: NON VEDO QUESTA OTTIMIZZAZIONE :
    //Se quando si deve effettuare la fusione l'ultimo elemento del segmento sinistro è minore o 
    //uguale al primo elemento del segmento di destra, la sequenza dei due segmenti è già un
    //segmento ordinato e quindi la fusione non è necessaria.
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
    
    // TOSEE: NON VEDO QUESTA OTTIMIZZAZIONE :
    //Se quando si deve effettuare la fusione l'ultimo elemento del segmento sinistro è minore o 
    //uguale al primo elemento del segmento di destra, la sequenza dei due segmenti è già un
    //segmento ordinato e quindi la fusione non è necessaria.
    
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
  
 // </editor-fold>
  
 // <editor-fold defaultstate="collapsed" desc=" MSort Isort ">
  
 /**
   * Implementazione del Merge Sort ottimizzato, con l'utilizzo dell'Insertion
   * Sort al di sotto di una certa soglia.
   * @param a  array da ordinare
   */
  public static void mSortIsort(int[] a){
      //TOSEE: perchè non l'avevi fatto? l'ho completato io
    int soglia = 10;
    if(a.length <= soglia)
        isort(a);
    else
        msortAlt(a);
  }
  
  // </editor-fold>
   
  /**
   * Versione parallela di una delle versioni precedenti. TOSEE non credo lo farò
   * @param a 
   */
  public static void parallelMergesort(int[] a){
    
  }
  
  
 // <editor-fold defaultstate="collapsed" desc=" QuickSort Base  ">  
  /**
   * Implementazione del QuickSort base (con estrazione del pivot e scelta
   * del pivot tramite random).
   * Gli elementi uguali al pivot rimangono sempre nella stessa porzione di 
   * destra (insieme agli elementi > pivot). L'indice i indica l'ultima posizione
   * degli elementi minori del pivot.
   * @param a Array da ordinare
   */
  public static void qSortBasic(int[] a){
    if(a.length <= 1) return;    
    qSortBasicRic(a, 0, a.length-1);
  }
  
  private static void qSortBasicRic(int[] a, int inf, int sup){
    if(inf >= sup) return;
    int iPivot = random.nextInt(sup - inf + 1) + inf;
    swap(a, inf, iPivot);
    int i = inf;
    for(int j = inf+1; j <= sup; j++){
      if(a[j] < a[inf]){
        i++;
        swap(a, i , j);
      }
    }
    swap(a, i, inf);
    qSortBasicRic(a, inf, i);
    qSortBasicRic(a, i+1, sup);
  }
  
  public static <T extends Comparable<? super T>> void qSortBasic(T[] a){
    if(a.length <= 1) return;
    qSortBasicRic(a, 0, a.length-1);
  }
  
  private static <T extends Comparable<? super T>> void qSortBasicRic(T[] a, int inf, int sup){
    if(inf >= sup) return;
    int iPivot = random.nextInt(sup - inf + 1) + inf;
    swap(a, inf, iPivot);
    int i = inf;
    for(int j = inf+1; j <= sup; j++){
      if(a[j].compareTo(a[inf]) < 0){
        i++;
        swap(a, i , j);
      }
    }
    swap(a, i, inf);
    qSortBasicRic(a, inf, i);
    qSortBasicRic(a, i+1, sup);
  }
  // </editor-fold> 
  
  // <editor-fold defaultstate="collapsed" desc=" QuickSort Hoare  ">
  
  /**
   * Implementazione del QuickSort alla Hoare. 
   * Gli elementi uguali al pivot possono essere in entrambi i lati rispetto al
   * pivot.
   * Algoritmo sul posto. Il pivot non viene rimosso.
   * @param a Array da ordinare
   */
  public static void qSortHoare(int [] a){
    if(a.length <= 1) return;
    qSortHoareRic(a, 0, a.length-1);
  }
  
  private static void qSortHoareRic(int[] a, int inf, int sup){
    if(inf >= sup) return;
    int i = inf, j = sup;
    int pivot = a[random.nextInt(sup - inf + 1) + inf];
    do{
      while(a[i] < pivot)
        i++;
      while(a[j] > pivot)
        j--;
      if(i <= j){
        swap(a, i, j);
        i++; j--;
      }
    }while(i <= j);
//    assert(i == j+1 || i == j+2);
    System.out.println(j + " " + i);
    qSortHoareRic(a, inf, j);
    qSortHoareRic(a, i, sup);
  }
  
  public static <T extends Comparable<? super T>> void qSortHoare(T [] a){
    if(a.length <= 1) return;
    qSortHoareRic(a, 0, a.length-1);
  }
  
  private static <T extends Comparable<? super T>> void qSortHoareRic(T[] a, int inf, int sup){
    if(inf >= sup) return;
    int i = inf, j = sup;
    T pivot = a[random.nextInt(sup - inf + 1) + inf];
    do{
      while(a[i].compareTo(pivot) < 0)
        i++;
      while(a[j].compareTo(pivot) > 0)
        j--;
      if(i <= j){
        swap(a, i, j);
        i++;
        j--;
      }
    }while(i <= j);
    assert(i == j+1 || i == j+2);
    qSortHoareRic(a, inf, j);
    qSortHoareRic(a, i, sup);
  }
  
  
  // </editor-fold> 
}
