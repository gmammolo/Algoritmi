package mammolo.unionfind;

import java.util.HashMap;

/**
 *
 * @author Giuseppe
 * @param <T> Tipo dell' elemento da inserire nell' insieme 
 */
public class UnionFind<T> { // esercizio da 10 punti
  
    
  protected  HashMap<T,Node<T>> elemMap;
    
  /**
   * Crea la struttura dati.
   */
  public UnionFind(){
    elemMap = new HashMap<>();
  }
  
  /**
   * Crea un nuovo insieme contenente solo l'elemento T, solleva una
   * eccezione in caso elem sia già presente.
   * @param elem elemento da inserire nell' insieme
   * @throws IllegalAccessException elemento fa parte già di un insieme
   */
  public void makeSet(T elem) throws IllegalAccessException{
    if(elemMap.containsKey(elem))
      throw new IllegalAccessException("Elemento già presente in un nodo");
    elemMap.put(elem, new Node<>(elem));
  }
  
  /**
   * Restituisce il rappresentante dell'insieme in cui si trova e.
   * @param e elemento da cercare negli insieme
   * @return il rappresentante dell' insieme
   */
  public T find (T e){
    Node<T> n = elemMap.get(e);
    if(n==null)
      throw new IllegalArgumentException();
    if(n.parent == null)
      return (T)n.elem;
    else
      n.parent = elemMap.get(find((T)n.parent.elem));
    return (T)n.parent.elem;
  }
  
  /**
   * Kruskal-Union
   * Unisce l'insieme che contiene "a" e l'insieme che contiene "b".
   * Se "a" e "b" fanno parte dello stesso insieme restituisce false e 
   * non fa nulla, altrimenti unisce gli insiemi di cui "a" e "b" fanno
   * parte e restituisce true.
   * @param a primo elemento da fondere
   * @param b secondo elemento da fondere
   * @return <code>true</code> in caso di successo, <code>false</code> se i due 
   * elementi fanno parte dello stesso insieme
   */
  public boolean kruskalUnion(T a, T b){
    T root1 = find(a);
    T root2 = find(b);
    if(root1 == root2) 
      return false;
    
    if(elemMap.get(root1).rango >= elemMap.get(root2).rango )
      union(root1, root2);
    else
      union(root2, root1);
    
    return true;
  }


  protected void union(T a, T b )
  {
    Node<T> root1 = elemMap.get(a);
    Node<T> root2 = elemMap.get(b);
            
    root2.parent = root1;
    root1.rango += root2.rango; 
  }
  
  /**
   * Classe contenente il nodo, usata per creare gli insiemi
   * @param <T> Parametro dell' elemento 
   */
  protected class Node<T> {
    
    Node<T> parent;
    T elem;
    int rango;
    
    
    public Node()
    {
      this(null);
    }
    
    public Node(T e)
    {
      elem = e;
      rango = 1;
      parent = null;
    }
    
    
    
      
  }

}
