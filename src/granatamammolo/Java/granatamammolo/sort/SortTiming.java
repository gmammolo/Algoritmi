package granatamammolo.Java.granatamammolo.sort;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Performs experiments on sorting algorithms (to be implemented in a class
 * named Sorting). Each algorithm is called on a number of randomly generated
 * integer arrays. Results are written on disk in CSV format.
 */
public class SortTiming {
  /**
   * Logger instance for the output on consolle.
   */
  private static final Logger log = Logger.getLogger( SortTiming.class.getName() );

  /**
   * Class for storing experiment results. An experiment is defined as a set of
   * measurement on a given array size. Each measurement is associated to a particular
   * algorithm whose name is given upon initialization.
   */
  protected static class Timings {
    public static final String SEP=";";
    /**
     * List of names of the tested algorithms
     */
    private ArrayList<String> headerFields;

    /**
     * List of array sizes used in the experiments
     */
    private ArrayList<Integer> sizes;

    /**
     * List of experiments results. Each experiment result
     *  is a list of timings (should be one for each tested algorithm).
     */
    private ArrayList<ArrayList<Double>> timings;

    /**
     * @param list the list of algorithms that are being tested
     */
    Timings(String[] list) {
      headerFields = new ArrayList<String>();
      headerFields.add("Size");
      headerFields.addAll(Arrays.asList(list));

      sizes = new ArrayList<Integer>();
      timings = new ArrayList<ArrayList<Double>>();
    }

    /**
     * Create a new experiment and appends it to the experiments list.
     */
    public void addExperiment(int size) {
      sizes.add(size);
      timings.add(new ArrayList<Double>());
    }

    /**
     * Append a new timing result to the current experiment (i.e., the
     * last creatd one).
     * @param timing the timing to be appended
     */
    public void addTiming(double timing) {
      timings.get(timings.size()-1).add(timing);
    }

    /**
     * Joins all elements of the given array list into a
     * string. The elements will be separated by a comma symbol.
     * @param values the object whose string representation should be joined.
     */
    private <E> String join(ArrayList<E> values) {
      String result = "";
      boolean first = true;

      for(E value : values) {
        if(first) {
          first = false;
        } else {
          result += SEP;
        }
        result += value.toString();
      }

      return result;
    }

    /**
     * @return a CSV representation of the content of this object.
     */
    public String toCsvString() {
      String result = join(headerFields) + "\n";
      for( int i=0; i<sizes.size(); ++i ) {
        ArrayList<Double> timing = timings.get(i);
        result += sizes.get(i) + SEP;
        result += join(timing) + "\n";
      }

      return result;
    }
  }

  /**
   * Builds a new array of random integers. It can be subclassed
   * to vary the way the array is built.
   */
  protected static class ArrayBuilder {
    /**
     * The minimal value of integers in the built array.
     */
    protected int min;
    /**
     * The maximal value of integers in the built array.
     */
    protected int max;

    ArrayBuilder(int min, int max) {
      this.min = min;
      this.max = max;
    }

    /**
     * Create a new array of random integers. The integers put into the array
     * will vary between min and max.
     * @param size the size of the newly built array
     * @return a newly built array containing "size" random integers.
     */
    protected int[] randomArray(int size) {
      int[] array = new int[size];
      for(int i=0; i<size; ++i) {
        array[i] = min + (int)(Math.random()*max);
      }

      return array;
    }
  }

  /**
   * Calls method m on the given array and returns the elapsed time in milliseconds
   * @param m the method to be invoked
   * @param array the parameter to be passed on m invokation
   * @return the time elapsed from invokation of m(array) to its completion
   */
  protected static double testTimes(Method m, int[] array) throws ReflectiveOperationException {
    final long startTime = System.nanoTime();
    m.invoke(null, array);
    final long endTime = System.nanoTime();

    return (endTime - startTime)/1E6d;
  }

  /**
   * Run the experimentation on the algorithms specified by the algorithms parameter.
   * Each algorithm will be tested over a set of arrays whose size vary from minSize
   * to maxSize in steps of stepSize.
   * Results of the experimentation are collected into the returned Timings object.
   * @param algorithms a list containing the names of the algorithms to be tested.  It
   *     is assumed that the Sorting class contains a method for each tested algorithm and
   *     that the method name corresponds to the name used in this list.
   * @param minSize the minimum size of arrays used to test the algorithms
   * @param maxSize the maximum size of arrays used to test the algorithms
   * @param stepSize the step size to be used while generating the random arrays
   * @return a Timings class containing the results of the experimentation
   */
  static public Timings measureAlgorithms(String[] algorithms, int minSize, int maxSize, int stepSize, ArrayBuilder builder) throws ReflectiveOperationException {
    Timings timings = new Timings(algorithms);
    for( int size=minSize; size<=maxSize; size+=stepSize ) {
      log.info("Starting experiment for array size:" + size);
      timings.addExperiment(size);
      int[] array = builder.randomArray(size);

      for( String algorithm : algorithms ) {
        log.info(algorithm);
        Method m = Sorting.class.getDeclaredMethod(algorithm, int[].class);
        timings.addTiming(testTimes(m, array.clone()));
      }
    }

    return timings;
  }

  /**
   * Writes into filename the results stored in the given Timings object.
   * Results are written in CSV format.
   */
  static public void writeResults(String filename, Timings timings) throws IOException  {
    PrintWriter writer = new PrintWriter(new FileWriter(filename));
    writer.println("sep="+Timings.SEP);
    writer.println(timings.toCsvString());
    writer.flush();
    writer.close();
    
  }
  
  /**
   * Il programma deve effettuare
   * misurazioni su array di dimensioni crescenti distinte per gli algoritmi quadratici
   * e per quelli ottimali. 
   * 
   * Gli algoritmi quadratici vanno musurati insieme ad almeno
   * un algoritmo ottimale (al fine di apprezzarne la differenza di prestazioni). In
   * entrambi i casi gli ultimi esperimenti (quelli che misurano i tempi di esecuzione
   * su array di dimensioni maggiori) devono forzare gli algoritmi a lavorare per
   * almeno qualche decina di secondi.
   * Si testino infine i metodi sort e parallelSort della classe Arrays della libreria di
   * Java, che hanno un’ottimizzazione molto spinta e sono quindi presumibilmente
   * i più veloci di tutti.
   */
  public static void main(String[] args) throws ReflectiveOperationException, IOException {
    String[] quadratic = { "iSort", "sSort" };          // si può aggiungere: iSortBin
    String[] optimal = { "qSortHoare", "mSortAlt" };    // si può aggiungere: mSortBasic, mSortISort, mSortNoGarbage, parallelMergeSort
                                                        // si può aggiungere: parallelQuickSort, qSortBasic, qSortHoareISort
    
    ArrayBuilder builder = new ArrayBuilder(Integer.MIN_VALUE, Integer.MAX_VALUE);

    //TOSEE: ORIGINALI:
    writeResults("quadratic.csv", measureAlgorithms(quadratic, (int) 1E5, (int) 1E6, (int) 5E4 , builder));
    writeResults("optimal.csv", measureAlgorithms(optimal, (int) 1E6, (int) 20E6, (int) 1E6, builder));

//    writeResults("quadratic.csv", measureAlgorithms(quadratic, (int) 10, (int) 150, (int) 5 , builder));
//    writeResults("optimal.csv", measureAlgorithms(optimal, (int) 10, (int) 150, (int) 5, builder));
  }
}
