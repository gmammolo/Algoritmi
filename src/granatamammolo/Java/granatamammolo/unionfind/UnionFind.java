package granatamammolo.Java.granatamammolo.unionfind;

/**
 *
 * @author Giuseppe
 */
public class UnionFind<T> { // esercizio da 10 punti
  
  /**
   * Crea la struttura dati.
   */
  UnionFind(){
    
  }
  
  /**
   * Crea un nuovo set contenente solo l'elemento T, solleva una
   * eccezione in caso elem sia già presente.
   */
  void makeSet(T elem){
    
  }
  
  /**
   * Restituisce il rappresentante dell'insieme in cui si trova e.
   */
  T find (T e){
    return null; // da modificare
  }
  
  /**
   * Kruskal-Union
   * Unisce l'insieme che contiene "a" e l'insieme che contiene "b".
   * Se "a" e "b" fanno parte dello stesso insieme restituisce false e 
   * non fa nulla, altrimenti unisce gli insiemi di cui "a" e "b" fanno
   * parte e restituisce true.
   */
  boolean union(int a, int b){
    return false; // da modificare
  }
}
//  esercizio da 6 punti (se cambi idea e vuoi fare questo invece di quello da 10)
//Gli elementi degli insiemi sono di tipo int e variano in un range
//[0...n].  il valore di n viene passato al costruttore
//della classe UnionFind
    
/**
//   * Crea la struttura dati e imposta la capacità a n.
//   */
//  UnionFind(int n){
//    
//  }
//  
//  /**
//   * Restituisce la capacità.
//   */
//  int getCapacity(){
//    return 0; // da modificare
//  }
//  
//  /**
//   * Cambia la capacità; se newN < getCapacity() solleva una eccezione.
//   */
//  void setCapacity(int newN) throws IllegalArgumentException {
//    
//  }
//  
//  /**
//   * Restituisce il rappresentante dell'insieme in cui si trova "e".
//   */
//  int find(int e){
//    return 0; // da modificare
//  }
//  
//  /**
//   * Kruskal-Union
//   * Unisce l'insieme che contiene "a" e l'insieme che contiene "b".
//   * Se "a" e "b" fanno parte dello stesso insieme restituisce false e 
//   * non fa nulla, altrimenti unisce gli insiemi di cui "a" e "b" fanno
//   * parte e restituisce true.
//   */
//  boolean union(int a, int b){
//    return false; // da modificare
//  }