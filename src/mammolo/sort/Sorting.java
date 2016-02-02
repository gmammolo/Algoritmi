package mammolo.sort;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Federica
 */
public class Sorting {

    public static Random random = new Random();

    /**
     * Classe statica non istanziabile
     */
    private Sorting() {
    }

    // <editor-fold defaultstate="collapsed" desc=" isSorted">
    /**
     * Controlla che l'array sia ordinato.
     *
     * @param a Array da controllare.
     * @return <code>true</code> se l'array è ordinato, <code>false</code>
     * altrimenti.
     */
    public static boolean isSorted(int[] a) {
        if (a.length == 0 || a.length == 1) {
            return true;
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Controlla che l'array sia ordinato.
     *
     * @param <T> extends Comparable
     * @param a array da ordinare
     * @return <code>true</code> se l'array è ordinato, <code>false</code>
     * altrimenti.
     */
    public static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
        if (a.length == 0 || a.length == 1) {
            return true;
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
   // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" SELECTION SORT ">
    /**
     * Implementazione dell'algoritmo di ordinamento del Selection Sort.
     * L'algoritmo scorre l'array e cerca sempre l'elemento minore tra i
     * successivi. Quando lo trova lo riordina e riparte a cercare il nuovo
     * minimo nella porzione di array rimasta. Termina quando tutto l'array
     * stato ordinato. <br>
     * Ha sempre un caso quadratico, ma potrebbe risultare il migliore da usare
     * nel caso in cui lo spostamento degli elementi nell' array è molto
     * costoso. <br>
     * -<b>Caso Migliore = Caso peggiore = Caso medio </b>= O(n^2) [Quadratico]
     * <br>
     * -<b>Sul Posto</b> <br>
     * -<b>Non Stabile</b><br>
     * <p>
     * <i>OTTIMIZZAZIONE: il primo <code>for</code> scorre gli elementi da 0 a
     * n-1, mentre il for interno va da i a n</i></p>
     *
     * @param a Array da ordinare.
     */
    public static void sSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[iMin]) {
                    iMin = j;
                }
            }
            if (iMin != i) {
                swap(a, iMin, i);
            }
        }
    }

    /**
     * Implementazione del Selection Sort per mezzo dei tipi generici.
     * L'algoritmo scorre l'array e cerca sempre l'elemento minore tra i
     * successivi. Quando lo trova lo riordina e riparte a cercare il nuovo
     * minimo nella porzione di array rimasta. Termina quando tutto l'array
     * stato ordinato. <br>
     * Ha sempre un caso quadratico, ma potrebbe risultare il migliore da usare
     * nel caso in cui lo spostamento degli elementi nell' array è molto
     * costoso. <br>
     * -<b>Caso Migliore = Caso peggiore = Caso medio </b>= O(n^2) [Quadratico]
     * <br>
     * -<b>Sul Posto</b> <br>
     * -<b>Non Stabile</b><br>
     * <p>
     * <i>OTTIMIZZAZIONE: il primo <code>for</code> scorre gli elementi da 0 a
     * n-1, mentre il for interno va da i a n</i></p>
     *
     * @param <T> extends Comparable
     * @param a Array da ordinare.
     */
    public static <T extends Comparable<? super T>> void sSort(T[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j].compareTo(a[iMin]) < 0) {
                    iMin = j;
                }
            }
            if (iMin != i) {
                swap(a, iMin, i);
            }
        }
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" INSERTION SORT ">
    /**
     * <p>
     * Implementazione dell'algoritmo di <strong>ordinamento</strong> Insertion
     * Sort. Si prende via via l'elemento successivo e lo si inserisce in
     * maniera ordinata nella parte che era già stata ordinata</p>
     * <p>
     * Un fatto interessante è che il caso ottimo si ottiene quando l'array è
     * già ordinato. Risulta essere un algoritmo ottimo quando si ha la certezza
     * che gli elementi sono poco distanti dalla loro posizione finale, e quindi
     * la complessità diventa O(k*n) e quindi lineare per k piccoli </p>
     * <p>
     * -<strong>Caso Peggiore:</strong>L'array di partenza è ordinato
     * inversamente. O(n^2)</p>
     * <p>
     * -<strong>Caso Migliore:</strong>L'array di partenza è già ordinato:
     * O(n)</p>
     * <p>
     * -<strong>Caso Medio:</strong> O(n) ~ O(n^2)</p>
     * <p>
     * -<strong>Sul Posto</strong></p>
     * <p>
     * -<strong>Stabile:</strong> l'array posiziona ogni elemento nel primo
     * posto utile per ordinare l'array e una volta posizionato non sarà più
     * spostato, mantenendo stabile l'algoritmo</p>
     *
     * @param a Array da ordinare.
     */
    public static void iSort(int[] a) {
        iSortRange(a, 0, a.length - 1);
    }

    /**
     * Applica l'algoritmo dell'Insertion sort su un intervallo dell'array.
     *
     * @see iSort
     * @param a Array da ordinare.
     * @param inf Indice iniziale dell'intervallo.
     * @param sup Indice finale dell'intervallo.
     */
    private static void iSortRange(int[] a, int inf, int sup) {
        int n = sup - inf;
        if (n < 1) {
            return;
        }
        for (int i = inf + 1; i <= sup; i++) {
            int val = a[i];
            int j = i;
            while (j > 0 && val < a[j - 1]) {
                a[j] = a[--j];
            }
            a[j] = val;
        }
    }

    private static <T extends Comparable<? super T>> void iSortRange(T[] a, int inf, int sup) {
        int n = sup - inf;
        if (n < 1) {
            return;
        }
        for (int i = inf + 1; i <= sup; i++) {
            T val = a[i];
            int j = i;
            while (j > 0 && val.compareTo(a[j - 1]) < 0) {
                a[j] = a[--j];
            }
            a[j] = val;
        }
    }

    /**
     * <p>
     * Implementazione dell'algoritmo di <strong>ordinamento</strong> Insertion
     * Sort con i tipi generici. Si prende via via l'elemento successivo e lo si
     * inserisce in maniera ordinata nella parte che era già stata ordinata</p>
     * <p>
     * Un fatto interessante è che il caso ottimo si ottiene quando l'array è
     * già ordinato. Risulta essere un algoritmo ottimo quando si ha la certezza
     * che gli elementi sono poco distanti dalla loro posizione finale, e quindi
     * la complessità diventa O(k*n) e quindi lineare per k piccoli </p>
     * <p>
     * -<strong>Caso Peggiore:</strong>L'array di partenza è ordinato
     * inversamente. O(n^2)</p>
     * <p>
     * -<strong>Caso Migliore:</strong>L'array di partenza è già ordinato:
     * O(n)</p>
     * <p>
     * -<strong>Caso Medio:</strong> O(n) ~ O(n^2)</p>
     * <p>
     * -<strong>Sul Posto</strong></p>
     * <p>
     * -<strong>Stabile:</strong> l'array posiziona ogni elemento nel primo
     * posto utile per ordinare l'array e una volta posizionato non sarà più
     * spostato, mantenendo stabile l'algoritmo</p>
     *
     * @param <T> extends Comparable
     * @param a Array da ordinare
     */
    public static <T extends Comparable<? super T>> void iSort(T[] a) {
        int n = a.length;
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                T val = a[i];
                int j = i;
                while (j > 0 && a[j - 1].compareTo(val) > 0) {
                    a[j] = a[--j];
                }
                a[j] = val;
            }
        }
    }

    /**
     * <p>
     * Implementazione dell'algoritmo di <strong>ordinamento</strong>
     * Insertion Sort con ausilio della ricerca binaria. Si prende via via
     * l'elemento successivo e lo si inserisce in maniera ordinata nella parte
     * che era già stata ordinata</p>
     * <p>
     * NOTE SULLA RICERCA BINARIA: la ricerca binaria ha una complessità
     * <code>O(log(n))</code>, a cui bisogna però aggiungere lo spostamento dei
     * valori dell'array in avanti fino alla posizione occupata dal valore da
     * ordinare (che nell'algoritmo di base viene fatto nello stesso momento in
     * cui si cerca il valore). Dunque la complessità temporale rimane comunque
     * quadratica nel caso peggiore</p>
     * <p>
     * -<strong>Caso Peggiore:</strong>L'array di partenza è ordinato
     * inversamente. O(n^2)</p>
     * <p>
     * -<strong>Caso Migliore:</strong>L'array di partenza è già ordinato:
     * O(n)</p>
     * <p>
     * -<strong>Caso Medio:</strong> O(n) ~ O(n^2)</p>
     * <p>
     * -<strong>Sul Posto</strong></p>
     * <p>
     * -<strong>Stabile:</strong> La ricerca binaria ritorna sempre la posizione
     * più a sinistra possibile (modificata per farlo)</p>
     *
     * @param a Array da ordinare.
     */
    public static void iSortBin(int[] a) {
        int n = a.length;
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                int j = i - 1;
                if (a[i] < a[j]) {
                    int pos = binarySearch(a, a[i], 0, j);
                    insert(a, pos, i);
                }
            }
        }
    }

    /**
     * Metodo di supporto per l'Insertion Sort con Ricerca binaria per
     * determinare il punto di inserimento del valore.<br>
     * Complessità:<code> i = fin - ini := O(log(i))</code>
     * <p>
     * <i>NOTE: L'algoritmo è modificato in modo da non uscire appena trova la
     * posizione adatta per il valore cercato, ma continua per trovare la
     * "posizione migliore", ovvero quella più a sinistra possibile (in questo
     * caso)</i></p>
     *
     * @param a Array su cui operare.
     * @param val Valore da ordinare.
     * @param ini Indice iniziale della porzione da considerare per la ricerca.
     * @param fin Indice finale della porzione da considerare per la ricerca.
     * @return Posizione dove inserire val,
     */
    private static int binarySearch(int[] a, int val, int ini, int fin) {
        if (val < a[ini]) {
            return ini;
        }
        if (val >= a[fin]) {
            return fin + 1;
        }
        int middle;
        while (ini <= fin) {
            middle = (ini + fin) >>> 1;
            if (val < a[middle]) {
                fin = middle - 1;
            } else {
                ini = middle + 1;
            }
        }
        return ini;
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" MERGE SORT Base ">
    /**
     * Implementazione del Merge Sort (Versione non ottimizzata) <br>
     * <p>
     * Algoritmo ricorsivo: divide l'array originario da ordinare in tanti
     * piccoli array, li ordina e li riunisce. <br>
     * NB in realtà lavora con gli indici, quindi su porzioni dello stesso
     * array), fino ad arrivare all'ultimo passo in cui gli array sono composti
     * da 1 solo elemento. Poi li riordina risalendo (nel passo invariante
     * generico si ha, quindi, che i due array su cui fare il merge sono
     * ordinati) </p>
     * <p>
     * -<b>Complessità: </b> O(n*log(n)) </p>
     * <p>
     * -<b>Complessità spaziale:</b> Varia in base alla versione. in questo caso
     * genera molti piccoli array di supporto che vengono eliminati. in ogni
     * caso S(n) in quanto il massimo raggiungibile è un array temporaneo lungo
     * quanto l'array originario</p>
     * <p>
     * -<b>Non sul Posto:</b> nel merge viene usato un array ausiliario</p>
     * <p>
     * -<b>Stabile:</b>L'algoritmo che esegue il merge fa in modo che se due
     * elementi chiave sono uguali, venga preso prima quello a sinistra.</p>
     *
     * @param a Array da ordinare.
     */
    public static void mSortBasic(int[] a) {
        mSortBasicRic(a, 0, a.length - 1);
    }

    /**
     * Metodo privato ricorsivo richiamato inizialmente da mSortBasic.
     *
     * @see mSortBasic
     * @param a array da ordinare
     * @param first indice primo elemento
     * @param last indice ultimo elemento
     */
    private static void mSortBasicRic(int[] a, int first, int last) {
        if (first < last) {
            int half = (first + last) / 2;
            mSortBasicRic(a, first, half);
            mSortBasicRic(a, half + 1, last);
            mergeBasic(a, first, half, last);
        }
    }

    /**
     * Metodo di supporto per il Merge Sort. Fonde due porzioni ordinate
     * dell'array in una sola con l'ausilio di un array temporaneo (rende
     * l'algoritmo non sul posto). <br>
     * Versione non ottimizzata.
     * <p>
     * Complessità: O(n)</p>
     *
     * @param a Array su cui operare.
     * @param first Indice iniziale della prima porzione.
     * @param middle Indice finale della prima porzione.
     * @param last Indice finale della seconda porzione.
     */
    static void mergeBasic(int[] a, int first, int middle, int last) {
        int n = last - first + 1;
        int[] c = new int[n];
        int i = first, j = middle + 1, k = 0;
        while (i <= middle && j <= last) {
            if (a[i] <= a[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = a[j++];
            }
        }
        while (i <= middle) {
            c[k++] = a[i++];
        }
        while (j <= last) {
            c[k++] = a[j++];
        }
        for (int h = 0; h < n; h++) {
            a[first + h] = c[h];
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Merge Sort (No Garbage)">
    /**
     * Implementazione del Merge Sort. Versione con un unico array ausiliario e
     * merge ottimizzato.
     * <p>
     * Crea un array della stessa dimensione dell'array da ordinare che userà
     * come supporto per riordinare l'array a.</p>
     * <p>
     * -<b>Complessità: </b> O(n*log(n)) </p>
     * <p>
     * -<b>Complessità spaziale:</b> S(n), ovvero la grandezza dell' array
     * ausiliario
     * <p>
     * -<b>Non sul Posto:</b> nel merge viene usato un array ausiliario</p>
     * <p>
     * -<b>Stabile:</b>L'algoritmo che esegue il merge fa in modo che se due
     * elementi chiave sono uguali, venga preso prima quello a sinistra.</p>
     *
     * @param a Array da ordinare.
     */
    public static void mSortNoGarbage(int[] a) {
        int n = a.length;
        int[] aux = new int[n];
        mSortNoGarbageRic(a, 0, n - 1, aux);
    }

    /**
     * Metodo ausiliario privato per mSortNoGarbage
     *
     * @see mSortNoGarbage
     * @param a array da ordinare
     * @param first indice primo elemento
     * @param last indice ultimo elemento
     * @param aux array ausiliario
     */
    protected static void mSortNoGarbageRic(int[] a, int first, int last, int[] aux) {
        if (first < last) {
            int middle = (first + last) >>> 1;
            mSortNoGarbageRic(a, first, middle, aux);
            mSortNoGarbageRic(a, middle + 1, last, aux);
            mergeOptimized(a, first, middle, last, aux);
        }
    }

    /**
     * Metodo per effettuare il merge (relativo al Merge Sort senza Garbage).
     * <b>Non</b> è a passo alternato, contiene le varie ottimizzazioni del
     * merge. NB: dopo il while, tutti i valori della porzione [middle+1 ..
     * last] sono minori dei valori rimanenti nella prima porzione [i ..
     * middle], quindi sono stati copiati tutti all'interno di aux. Per questo
     * motivo, la seconda porzione la si può considerare libera per poterci
     * copiare, dal più grande, i valori rimanenti tra [i .. middle].
     *
     * @param a Array su cui operare.
     * @param first Indice iniziale della prima porzione.
     * @param middle Indice finale della prima porzione.
     * @param last Indice finale della seconda porzione.
     * @param aux Array ausiliario/di supporto.
     */
    protected static void mergeOptimized(int[] a, int first, int middle, int last, int[] aux) {
        int i = first, j = middle + 1;
        int k = first;
        if (a[j - 1] <= a[j]) {
            return;
        }
        while (i <= middle && j <= last) {
            if (a[i] <= a[j]) {
                aux[k++] = a[i++];
            } else {
                aux[k++] = a[j++];
            }
        }
        int h = middle, l = last;
        while (h >= i) {
            a[l--] = a[h--];
        }
        for (int m = first; m < k; m++) {
            a[m] = aux[m];
        }
    }

    /**
     * Implementazione del Merge Sort per mezzo dei tipi generici.
     * <p>
     * Crea un array della stessa dimensione dell'array da ordinare che userà
     * come supporto per riordinare l'array a.</p>
     * <p>
     * -<b>Complessità: </b> O(n*log(n)) </p>
     * <p>
     * -<b>Non sul Posto:</b> nel merge viene usato un array ausiliario</p>
     * <p>
     * -<b>Stabile:</b>L'algoritmo che esegue il merge fa in modo che se due
     * elementi chiave sono uguali, venga preso prima quello a sinistra.</p>
     *
     * @param <T> extends Comparable
     * @param a Array da ordinare.
     */
    public static <T extends Comparable<? super T>> void mSortNoGarbage(T[] a) {
        int n = a.length;
        @SuppressWarnings("unchecked")
        T[] aux =  (T[]) new Comparable[n];
        mSortNoGarbageRic(a, 0, n - 1, aux);
        

    }

    /**
     * Metodo Ausiliario privato usato da msortNoGarbage
     *
     * @see mSortNoGarbage
     * @param <T> extends Comparable
     * @param a array da ordinare
     * @param first indice primo elemento
     * @param last indice ultimo elemento
     * @param aux array ausiliario
     */
    private static <T extends Comparable<? super T>> void mSortNoGarbageRic(T[] a, int first, int last, T[] aux) {
        if (first < last) {
            int middle = (first + last) >>> 1;
            mSortNoGarbageRic(a, first, middle, aux);
            mSortNoGarbageRic(a, middle + 1, last, aux);
            mergeOptimized(a, first, middle, last, aux);
        }
    }

    private static <T extends Comparable<? super T>> void mergeOptimized(T[] a, int first, int middle, int last, T[] aux) {
    	int i = first, j = middle + 1;
        int k = first;
        if (a[j - 1].compareTo(a[j]) <= 0) {
            return;
        }
        while (i <= middle && j <= last) {
            if (a[i].compareTo(a[j]) <= 0) {
                aux[k++] = a[i++];
            } else {
                aux[k++] = a[j++];
            }
        }
        int h = middle, l = last;
        while (h >= i) {
            a[l--] = a[h--];
        }
        for (int m = first; m < k; m++) {
            a[m] = aux[m];
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Merge Sort Alternato">  
    /**
     * Implementazione del Merge Sort - versione "a passo alternato". Versione
     * ottimizzata del merge sort: L'array ausiliario viene caricato con gli
     * stessi valori dell'array da ordinare e si esegue il merge usando in modo
     * alternato porzioni dei due array, evitando cosi di dover caricare i
     * valori ordinati nell' ausiliario dentro l'array originale.
     *
     * @param a Array da ordinare.
     */
    public static void mSortAlt(int[] a) {
        int n = a.length;
        int[] aux = a.clone();
        mSortAltRic(a, 0, n - 1, aux);
    }

    private static void mSortAltRic(int[] a, int first, int last, int[] b) {
        if (first < last) {
            int middle = (first + last) >>> 1;
            mSortAltRic(b, first, middle, a);
            mSortAltRic(b, middle + 1, last, a);
            mergeAlt(b, first, middle, last, a);
        }
    }

    private static void mergeAlt(int[] a, int first, int middle, int last, int[] c) {
        int i = first, j = middle + 1, k = 0;
        if (a[j - 1] <= a[j]) {
            return;
        }
        while (i <= middle && j <= last) {
            if (a[i] <= a[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = a[j++];
            }
        }
        while (i <= middle) {
            c[k++] = a[i++];
        }
        while (j <= last) {
            c[k++] = a[j++];
        }
    }

    /**
     * Implementazione del Merge Sort versione alternata per mezzo dei tipi
     * generici.
     *
     * @param <T> extends Comparable
     * @param a Array da ordinare.
     */
    public static <T extends Comparable<? super T>> void mSortAlt(T[] a) {
        int n = a.length;
        T[] aux = a.clone();
        mSortAltRic(a, 0, n - 1, aux);
    }

    private static <T extends Comparable<? super T>> void mSortAltRic(T[] a, int first, int last, T[] b) {
        if (first < last) {
            int middle = (first + last) >>> 1;
            mSortAltRic(b, first, middle, a);
            mSortAltRic(b, middle + 1, last, a);
            mergeAlt(b, first, middle, last, a);
        }
    }

    private static <T extends Comparable<? super T>> void mergeAlt(T[] a, int first, int middle, int last, T[] c) {
        int i = first, j = middle + 1, k = 0;
        if (a[j - 1].compareTo(a[j]) <= 0) {
            return;
        }
        while (i <= middle && j <= last) {
            if (a[i].compareTo(a[j]) <= 0) {
                c[k++] = a[i++];
            } else {
                c[k++] = a[j++];
            }
        }
        while (i <= middle) {
            c[k++] = a[i++];
        }
        while (j <= last) {
            c[k++] = a[j++];
        }
    }

 // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Merge Sort Isort ">
    /**
     * Implementazione del Merge Sort ottimizzato, con l'utilizzo dell'Insertion
     * Sort al di sotto di una certa soglia.
     *
     * @param a array da ordinare
     */
    public static void mSortISort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int[] b = a.clone();
        mSortIsortRic(a, 0, a.length, b);
    }

    private static void mSortIsortRic(int[] a, int inf, int sup, int[] b) {
        if (inf >= sup) {
            return;
        }
        int soglia = 7;
        if ((sup - inf) < soglia) {
            iSortRange(a, inf, sup);
        } else {                        // mSortAlt
            int first = inf, last = sup - 1;
            if (first < last) {
                int middle = (first + last) >>> 1;
                mSortIsortRic(b, first, middle, a);
                mSortIsortRic(b, middle + 1, last, a);
                mergeAlt(b, first, middle, last, a);
            }
        }
    }

    public static <T extends Comparable<? super T>> void mSortISort(T[] a) {
        if (a.length <= 1) {
            return;
        }
        T[] b = a.clone();
        mSortISortRic(a, 0, a.length, b);
    }

    private static <T extends Comparable<? super T>> void mSortISortRic(T[] a, int inf, int sup, T[] b) {
        if (inf >= sup) {
            return;
        }
        int soglia = 7;
        if ((sup - inf) < soglia) {
            iSortRange(a, inf, sup);
        } else {                        // mSortAlt
            int first = inf, last = sup - 1;
            if (first < last) {
                int middle = (first + last) >>> 1;
                mSortISortRic(b, first, middle, a);
                mSortISortRic(b, middle + 1, last, a);
                mergeAlt(b, first, middle, last, a);
            }
        }
    }

  // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Merge Sort Parallel ">
    /**
     * Versione parallela del mergeSort a passo alternato.
     *
     * @param a array da ordinare
     * @see mSortAlt
     */
    public static void parallelMergeSort(int[] a) {
        int n = a.length - 1;
        int cores = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = ForkJoinPool.commonPool();
        int[] aux = new int[a.length];
        ParallelMergeSorter sorter = new ParallelMergeSorter(a, 0, n, aux, cores);
        pool.invoke(sorter);
    }

    private static class ParallelMergeSorter extends RecursiveAction {

		private static final long serialVersionUID = 1L;
		int[] a, aux;
        int first, last;
        int numThreads; // numero dei threads ancora disponibili

        ParallelMergeSorter(int[] a, int f, int l, int[] aux, int n) {
            this.a = a;
            this.aux = aux;
            first = f;
            last = l;
            numThreads = n;
        }

        @Override
        protected void compute() {
            if (first >= last) {
                return;
            }
            if (numThreads <= 1) {
                mSortNoGarbageRic(a, first, last, aux);
            } else {
                int m = (first + last) / 2;
                ParallelMergeSorter left = new ParallelMergeSorter(a, first, m, aux, numThreads / 2);
                ParallelMergeSorter right = new ParallelMergeSorter(a, m + 1, last, aux, numThreads / 2);
                invokeAll(left, right);
                mergeOptimized(a, first, m, last, aux);
            }
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Quick Sort Base  ">  
    /**
     * Implementazione del QuickSort base (con estrazione del pivot e scelta del
     * pivot tramite random). Gli elementi uguali al pivot rimangono sempre
     * nella stessa porzione di destra (insieme agli elementi &lt; pivot).
     * L'indice i indica l'ultima posizione degli elementi minori del pivot.
     * <p>
     * -<b>Complessità: </b> O(n*log(n)), ma ha un caso peggiore 0(n^2) </p>
     * <p>
     * -<b>Complessità spaziale:</b> siccome usa le chiamate ricorsive ha
     * S(log(n) ) nel caso medio ed S(n) nel peggiore</p>
     * <p>
     * -<b>Sul Posto:</b> </p>
     * <p>
     * -<b>Stabile:</b></p>
     *
     * @param a Array da ordinare
     */
    public static void qSortBasic(int[] a) {
        if (a.length <= 1) {
            return;
        }
        qSortBasicRic(a, 0, a.length - 1);
    }

    private static void qSortBasicRic(int[] a, int inf, int sup) {
        if (inf >= sup) {
            return;
        }
        int iPivot = random.nextInt(sup - inf + 1) + inf;
        swap(a, inf, iPivot);
        int i = inf;
        for (int j = inf + 1; j <= sup; j++) {
            if (a[j] < a[inf]) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i, inf);
        qSortBasicRic(a, inf, i - 1);
        qSortBasicRic(a, i + 1, sup);
    }

    public static <T extends Comparable<? super T>> void qSortBasic(T[] a) {
        if (a.length <= 1) {
            return;
        }
        qSortBasicRic(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void qSortBasicRic(T[] a, int inf, int sup) {
        if (inf >= sup) {
            return;
        }
        int iPivot = random.nextInt(sup - inf + 1) + inf;
        swap(a, inf, iPivot);
        int i = inf;
        for (int j = inf + 1; j <= sup; j++) {
            if (a[j].compareTo(a[inf]) < 0) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i, inf);
        qSortBasicRic(a, inf, i - 1);
        qSortBasicRic(a, i + 1, sup);
    }
  // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Quick Sort Bandiera  "> 
    /**
     * Implementazione del QuickSort con Algoritmo della Bandiera. Viene
     * applicato l'algoritmo della bandiera viene applicato scegliendo un pivot
     * casuale e quindi mettendo a sinistra i minori, al centro i valori uguali
     * a pivot e a destra i maggiori. Poi si effettua l'ordinamento solo sulla
     * parte sinistra e destra. L'algoritmo risulta ovviamente più veloce nei
     * casi in cui ci sono molte ripetizioni dentro l'array.
     * <p>
     * -<b>Complessità: </b> O(n*log(n)), ma ha un caso peggiore 0(n^2) </p>
     * <p>
     * -<b>Complessità spaziale:</b> siccome usa le chiamate ricorsive ha
     * S(log(n) ) nel caso medio ed S(n) nel peggiore</p>
     * <p>
     * -<b>Sul Posto:</b> </p>
     * <p>
     * -<b>Stabile:</b></p>
     *
     * @param a Array da ordinare
     */
    public static void qSortBandiera(int[] a) {
        if (a.length <= 1) {
            return;
        }
        qSortBandieraRic(a, 0, a.length - 1);
    }

    private static void qSortBandieraRic(int[] a, int inf, int sup) {
        if (inf >= sup) {
            return;
        }
        int Pivot = a[random.nextInt(sup - inf + 1) + inf];
        int i = inf, j = inf, k = sup;
        while (j <= k) {
            if (a[j] < Pivot) {
                swap(a, i, j);
                i++;
                j++;
            } else if (a[j] > Pivot) {
                swap(a, j, k);
                k--;
            } else { //pivot
                j++;
            }

        }
        qSortBandieraRic(a, inf, i - 1);
        qSortBandieraRic(a, k + 1, sup);
    }

    /**
     * Implementazione del QuickSort con Algoritmo della Bandiera. Viene
     * applicato l'algoritmo della bandiera viene applicato scegliendo un pivot
     * casuale e quindi mettendo a sinistra i minori, al centro i valori uguali
     * a pivot e a destra i maggiori. Poi si effettua l'ordinamento solo sulla
     * parte sinistra e destra. L'algoritmo risulta ovviamente più veloce nei
     * casi in cui ci sono molte ripetizioni dentro l'array.
     * <p>
     * -<b>Complessità: </b> O(n*log(n)), ma ha un caso peggiore 0(n^2) </p>
     * <p>
     * -<b>Complessità spaziale:</b> siccome usa le chiamate ricorsive ha
     * S(log(n) ) nel caso medio ed S(n) nel peggiore</p>
     * <p>
     * -<b>Sul Posto:</b> </p>
     * <p>
     * -<b>Stabile:</b></p>
     *
     * @param a Array da ordinare
     * @param <T> comparable type
     */
    public static <T extends Comparable<? super T>> void qSortBandiera(T[] a) {
        if (a.length <= 1) {
            return;
        }
        qSortBandieraRic(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void qSortBandieraRic(T[] a, int inf, int sup) {
        if (inf >= sup) {
            return;
        }
        T Pivot = a[random.nextInt(sup - inf + 1) + inf];
        int i = inf, j = inf, k = sup;
        while (j <= k) {
            if (a[j].compareTo(Pivot) < 0) {
                swap(a, i, j);
                i++;
                j++;
            } else if (a[j].compareTo(Pivot) > 0) {
                swap(a, j, k);
                k--;
            } else { //pivot
                j++;
            }

        }
        qSortBandieraRic(a, inf, i - 1);
        qSortBandieraRic(a, k + 1, sup);
    }
  // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Quick Sort Hoare ">
    /**
     * Implementazione del QuickSort alla Hoare. Gli elementi uguali al pivot
     * possono essere in entrambi i lati rispetto al pivot. Algoritmo sul posto.
     * Il pivot non viene rimosso.
     *
     * @param a Array da ordinare
     */
    public static void qSortHoare(int[] a) {
        if (a.length <= 1) {
            return;
        }
        qSortHoareRic(a, 0, a.length - 1);
    }

    private static void qSortHoareRic(int[] a, int inf, int sup) {
        if (inf >= sup) {
            return;
        }
        int i = inf, j = sup;
        int pivot = a[random.nextInt(sup - inf + 1) + inf];
        do {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        assert (i == j + 1 || i == j + 2);
        qSortHoareRic(a, inf, j);
        qSortHoareRic(a, i, sup);
    }

    public static <T extends Comparable<? super T>> void qSortHoare(T[] a) {
        if (a.length <= 1) {
            return;
        }
        qSortHoareRic(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void qSortHoareRic(T[] a, int inf, int sup) {
        if (inf >= sup) {
            return;
        }
        int i = inf, j = sup;
        T pivot = a[random.nextInt(sup - inf + 1) + inf];
        do {
            while (a[i].compareTo(pivot) < 0) {
                i++;
            }
            while (a[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        assert (i == j + 1 || i == j + 2);
        qSortHoareRic(a, inf, j);
        qSortHoareRic(a, i, sup);
    }

    /**
     * Implementazione del QuickSort versione Hoare, ottimizzato con
     * l'esecuzione dell'InsertionSort al di sotto di una certa soglia.
     *
     * @param a array da ordinare
     */
    public static void qSortHoareISort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        qSortHoareISortRic(a, 0, a.length);
    }

    private static void qSortHoareISortRic(int[] a, int inf, int sup) {
        if (inf >= sup) {
            return;
        }
        int soglia = 7;
        if ((sup - inf) <= soglia) {
            iSortRange(a, inf, sup);
        } else {                        // qsortAlt
            sup--;
            int i = inf, j = sup;
            int pivot = a[random.nextInt(sup - inf + 1) + inf];
            do {
                while (a[i] < pivot) {
                    i++;
                }
                while (a[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    swap(a, i, j);
                    i++;
                    j--;
                }
            } while (i <= j);
            assert (i == j + 1 || i == j + 2);
            qSortHoareRic(a, inf, j);
            qSortHoareRic(a, i, sup);
        }
    }
  // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Quick Sort Parallel ">
    public static void parallelQuickSort(int[] a) {
        int n = a.length - 1;
        int cores = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = ForkJoinPool.commonPool();
        ParallelQuickSorter sorter = new ParallelQuickSorter(a, 0, n, cores);
        pool.invoke(sorter);
    }

    private static class ParallelQuickSorter extends RecursiveAction {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int[] a;
        int inf, sup;
        int numThreads; // numero dei threads ancora disponibili

        ParallelQuickSorter(int[] a, int f, int l, int n) {
            this.a = a;
            inf = f;
            sup = l;
            numThreads = n;
        }

        @Override
        protected void compute() {
            if (inf >= sup) {
                return;
            }
            if (numThreads <= 1) {
                qSortBasicRic(a, inf, sup);
            } else {
                int iPivot = random.nextInt(sup - inf + 1) + inf;
                swap(a, inf, iPivot);
                int i = inf;
                for (int j = inf + 1; j <= sup; j++) {
                    if (a[j] < a[inf]) {
                        i++;
                        swap(a, i, j);
                    }
                }
                swap(a, i, inf);
                ParallelQuickSorter left = new ParallelQuickSorter(a, inf, i, numThreads / 2);
                ParallelQuickSorter right = new ParallelQuickSorter(a, i + 1, sup, numThreads / 2);
                invokeAll(left, right);
            }
        }
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Heap Sort ">
    /**
     * <p>
     * L'heapsort per eseguire l'ordinamento, utilizza la struttura dati heap (
     * con coda con priorità). Concettualmente molto simile al selection sort,
     * cambia nella struttura utilizzata (una coda con priorità a massimo).
     * </p>
     *    * <p>
     * -<b>Complessità: </b> O(n*log(n)) </p>
     * <p>
     * -<b>Complessità spaziale:</b> Varia in base alla versione. in questo caso
     * genera molti piccoli array di supporto che vengono eliminati. in ogni
     * caso S(n) in quanto il massimo raggiungibile è un array temporaneo lungo
     * quanto l'array originario</p>
     * <p>
     * -<b>Sul Posto:</b> La struttura Heap viene costruita sull' array
     * stesso</p>
     * <p>
     * -<b>Stabile</b></p>
     *
     * @param a
     */
    public static void hSort(int[] a) {
        hSort(a, 0, a.length - 1);
    }

    protected static void hSort(int[] a, int first, int last) {
        int n = first + last - 1;
        for (int j = (n) / 2; j >= first; j--) {
            moveDown(a, first, j, last + 1);
        }

        for (int i = last; i > first; i--) {
            int tmp = a[first];
            a[first] = a[i];
            a[i] = tmp;
            moveDown(a, first, first, i);
        }
    }

    protected static void moveDown(int[] a, int first, int i, int last) {
        int elem = a[i];
        int j;
        while ((j = 2 * i + 1 - first) < last) {
            if (j + 1 < last && a[j + 1] > a[j]) {
                j++;
            }
            if (elem >= a[j]) {
                break;
            }
            a[i] = a[j];
            i = j;
        }
        a[i] = elem;
    }

    /**
     * <p>
     * L'heapsort per eseguire l'ordinamento, utilizza la struttura dati heap (
     * con coda con priorità). Concettualmente molto simile al selection sort,
     * cambia nella struttura utilizzata (una coda con priorità a massimo).
     * </p>
     *    * <p>
     * -<b>Complessità: </b> O(n*log(n)) </p>
     * <p>
     * -<b>Complessità spaziale:</b> Varia in base alla versione. in questo caso
     * genera molti piccoli array di supporto che vengono eliminati. in ogni
     * caso S(n) in quanto il massimo raggiungibile è un array temporaneo lungo
     * quanto l'array originario</p>
     * <p>
     * -<b>Sul Posto:</b> La struttura Heap viene costruita sull' array
     * stesso</p>
     * <p>
     * -<b>Stabile</b></p>
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable<? super T>> void hSort(T[] a) {
        hSort(a, 0, a.length - 1);
    }

    protected static <T extends Comparable<? super T>> void hSort(T[] a, int first, int last) {
        int n = first + last - 1;
        for (int j = (n) / 2; j >= first; j--) {
            moveDown(a, first, j, last + 1);
        }

        for (int i = last; i > first; i--) {
            T tmp = a[first];
            a[first] = a[i];
            a[i] = tmp;
            moveDown(a, first, first, i);
        }
    }

    protected static <T extends Comparable<? super T>> void moveDown(T[] a, int first, int i, int last) {
        T elem = a[i];
        int j;
        while ((j = 2 * i + 1 - first) < last) {
            if (j + 1 < last && a[j + 1].compareTo(a[j]) > 0) {
                j++;
            }
            if (elem.compareTo(a[j]) >= 0) {
                break;
            }
            a[i] = a[j];
            i = j;
        }
        a[i] = elem;
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" IntroSort ">
    /**
     * Metodo di ordinamento ottimizzato. Il quicksort è asintodicamente più
     * veloce dell' heapsort e quindi è preferibile a quest'ultimo. In questa
     * versione si ovvia al caso peggiore del quicksort (O(n)). Si calcola il
     * logaritmo in base 2 della lunghezza dell' array e si effettua il
     * quicksort decrementando di 1 il livello a ogni ricorsione. Se si
     * raggiunge il livello 0 vuol dire che si sta per ottenere un caso non
     * pseudolineare e quindi si finisce di ordinare l'array tramite l'heapsort.
     * Altro punto di forza è l'inserimento della soglia, in quanto si è visto
     * che per n piccoli, l'isort risulta più veloce del quicksort.
     *
     * @param <T>
     * @param a
     */
    public static void IntroSort(int[] a) {
        int n = a.length;
        random = new Random();
        int log = 31 - Integer.numberOfLeadingZeros(n);
        IntroSort(a, 0, n - 1, 2 * log);
    }

    protected static void IntroSort(int[] a, int fst, int lst, int lev) {
        int soglia = 3;
        if (fst >= lst) {
            return;
        }
        if (lst - fst < soglia) {
            iSortRange(a, fst, lst);
        } else if (lev == 0) {
            hSort(a, fst, lst);
        } else {
            int i = fst;
            int iPivot = random.nextInt(lst - fst + 1) + fst;
            swap(a, fst, iPivot);
            for (int j = fst + 1; j <= lst; j++) {
                if (a[j] < a[fst]) {
                    i++;
                    swap(a, i, j);
                }
            }
            swap(a, i, fst);
            IntroSort(a, fst, i - 1, lev - 1);
            IntroSort(a, i + 1, lst, lev - 1);
        }
    }

    /**
     * Metodo di ordinamento ottimizzato. Il quicksort è asintodicamente più
     * veloce dell' heapsort e quindi è preferibile a quest'ultimo. In questa
     * versione si ovvia al caso peggiore del quicksort (O(n)). Si calcola il
     * logaritmo in base 2 della lunghezza dell' array e si effettua il
     * quicksort decrementando di 1 il livello a ogni ricorsione. Se si
     * raggiunge il livello 0 vuol dire che si sta per ottenere un caso non
     * pseudolineare e quindi si finisce di ordinare l'array tramite l'heapsort.
     * Altro punto di forza è l'inserimento della soglia, in quanto si è visto
     * che per n piccoli, l'isort risulta più veloce del quicksort.
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable<? super T>> void IntroSort(T[] a) {
        int n = a.length;
        random = new Random();
        int log = 31 - Integer.numberOfLeadingZeros(n);
        IntroSort(a, 0, n - 1, 2 * log);
    }

    protected static <T extends Comparable<? super T>> void IntroSort(T[] a, int fst, int lst, int lev) {
        int soglia = 2;
        if (fst >= lst) {
            return;
        }
        if (lst - fst <= soglia) {
            iSortRange(a, fst, lst);
        } else if (lev == 0) {
            hSort(a, fst, lst);
        } else {
            int i = fst;
            int iPivot = random.nextInt(lst - fst + 1) + fst;
            swap(a, fst, iPivot);
            for (int j = fst + 1; j <= lst; j++) {
                if (a[j].compareTo(a[fst]) < 0) {
                    i++;
                    swap(a, i, j);
                }
            }
            swap(a, i, fst);
            IntroSort(a, fst, i - 1, lev - 1);
            IntroSort(a, i + 1, lst, lev - 1);

        }
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Metodi di supporto ">
    /**
     * Metodo di supporto per scambio di posizione di due valori in un array.
     *
     * @param array Array su cui operare.
     * @param i Indice del primo elemento.
     * @param j Indice del secondo elemento.
     */
    private static void swap(int[] array, int i, int j) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    /**
     * Metodo di supporto per scambio di posizione di due valori in un array con
     * tipi generici.
     *
     * @param <T> extends Comparable
     * @param array Array su cui operare.
     * @param i Indice del primo elemento.
     * @param j Indice del secondo elemento.
     */
    private static <T extends Comparable<? super T>> void swap(T[] array, int i, int j) {
        T tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    /**
     * Metodo di supporto per l'Insertion Sort (Versione con Ricerca binaria).
     * Inserisce l'elemento di posizione i in posizione j, shiftando il resto
     * dell'array di una posizione.
     *
     * @param a Array su cui operare.
     * @param j Posizione di destinazione dell'elemento.
     * @param i Posizione originale dell'elemento (<code>i-1</code> corrisponde
     * all'ultimo elemento ordinato ).
     */
    private static void insert(int[] a, int j, int i) {
        int val = a[i];
        for (int k = i; k > j; k--) {
            a[k] = a[k - 1];
        }
        a[j] = val;
    }
  // </editor-fold>
}
