package mammolo.dictionary;

import static java.lang.Math.*;

/**
 * Albero di Ricerca semplice
 * @author Federica
 * @param <K> tipo della chiave del dizionario
 * @param <V> tipo del valore del dizionario
 */
public class SearchTree <K extends Comparable <K>, V> implements SortedDictionary<K,V>  {


  protected static class Node <K, V> {
    K key;
    V value;
    Node<K,V> left, right;
    
    Node(K k, V v, Node<K,V> l, Node<K,V> r){
      this.key    = k;
      this.value  = v;
      this.left   = l;
      this.right  = r;
    }

  }
  
  /**
   * Root dell' albero di ricerca semplice
   */
  protected Node<K,V> root;
  
  public SearchTree(){
    root = null;
  }
  
  public SearchTree(K key, V value){
    root = new Node<>(key, value, null, null);
  }
  
  /**
   * Stampa l'albero in ordine
   * @return una Stringa contentente la stampa dell' albero
   */
  public String printInOrder(){
    return "["+printInOrder(root)+"]";
  }
  
  private String printInOrder(Node<K, V> node){
    String s = "";
    if(node != null) {
      s += printInOrder(node.left);
      s += " ("+ node.value+") ";
      s += printInOrder(node.right);
    }
    return s;
  }
  
  /**
   * Restituisce il peso di un Nodo
   * @param node nodo di cui si vuole sapere il peso. La foglia vale 1.
   * @return Peso del nodo
   */
  protected static int height(Node<?, ?> node){
    return (node == null) ? -1 : 1 + max(height(node.left), height(node.right));
  }
  
  @Override
  public boolean isEmpty() {
    return (root == null);
  }
  

    @Override
  public K minKey() {
    if(root == null) return null;
    return getMin(root).key;
  }

  @Override
  public K maxKey() {
    if(root == null) return null;
    return getMax(root).key;
  }



    @Override
  public V elementOfMinKey() {
    if(root == null) return null;
    return getMin(root).value;
  }


  @Override
  public V elementOfMaxKey() {
    if(root == null) return null;
    return getMax(root).value;
  }


  @Override
  public V find(K key) {
    K keyK = (K) key;     // TOSEE
    Node<K,V> node = this.root;
    while(node != null) {
      K nodeKey = (K) node.key;    
      if(keyK.compareTo(nodeKey) < 0)    node = node.left;
      else if(keyK.compareTo(nodeKey) > 0) node = node.right;
      else return node.value;
    }
    return null;
  }


  @Override
  public V add(K key, V value) {
    Node<K,V> node = new Node<>(key, value, null, null);
    if(root == null) {
       root = node;
       return root.value;
    }    
    return add(node, root);
  }
  
  private V add(Node<K,V> newNode, Node<K,V> node){
    K key =  newNode.key;
    K nodeKey =  node.key;
    if(key.compareTo(nodeKey) < 0){
      if(node.left == null)
        node.left = newNode;
      else
        add(newNode, node.left);
    }else if(key.compareTo(nodeKey) > 0){
      if(node.right == null)
        node.right = newNode;
      else
        add(newNode, node.right);
    }else{ 
      return null;
    }
    return newNode.value;
  }

  @Override
  public void remove(K key) {
   root = remove( key, root);
  }

  
  private Node<K,V> remove(K key, Node<K,V> node){
    if(node != null){
      K nodeK = node.key;
      if(key.compareTo(nodeK) < 0)
        node.left =  remove(key, node.left);
      else if(key.compareTo(nodeK) > 0)
        node.right = remove(key, node.right);
      else{
        if(node.left == null)
          node = node.right;
        else if(node.right == null)
          node = node.left;
        else
          node.value = getMin(node.right).value;
      }
    }
    return node;
  }
  
  /**
  * Restituisce il nodo minore della struttura.
  * @param node node di partenza
  * @return nodo minore
  */
  protected  Node<K,V> getMin(Node<K,V> node){
    if(node.left != null)
      return getMin(node.left);
    return node;
  }
  
  /**
   * Restituisce il nodo maggiore della struttura.
   * @param node node di partenza
   * @return nodo maggiore
   */
  protected Node<K,V> getMax(Node<K,V> node){
    if(node.right != null)
      return getMax(node.right);
    return node;
  }

}
