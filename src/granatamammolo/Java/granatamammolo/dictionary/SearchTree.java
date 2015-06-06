package granatamammolo.Java.granatamammolo.dictionary;

import static java.lang.Math.*;

/**
 *
 * @author Federica
 */
public class SearchTree <K extends Comparable <K>, V> implements SortedDictionary<K,V>  {









  protected static class Node <K, V> {
    K key;
    V value;
    Node left, right;
    
    Node(K k, V v, Node l, Node r){
      this.key    = k;
      this.value  = v;
      this.left   = l;
      this.right  = r;
    }

  }
  
  protected Node<K,V> root;
  
  public SearchTree(){
    root = null;
  }
  
  public SearchTree(K key, V value){
    root = new Node(key, value, null, null);
  }
  
  
  public String printInOrder(){
    return "["+printInOrder(root)+"]";
  }
  
  public String printInOrder(Node node){
    String s = "";
    if(node != null) {
      s += printInOrder(node.left);
      s += " ("+ node.value+") ";
      s += printInOrder(node.right);
    }
    return s;
  }
  
  int height(Node node){
    return (node == null) ? -1 : 1 + max(height(node.left), height(node.right));
  }
  
  public boolean isEmpty() {
    return (root == null);
  }
  
  /**
   * Senza rimozione del nodo.
   * @return chiave minima dell'albero
   */
    @Override
  public K minKey() {
    if(root == null) return null;
    return getMin(root).key;
  }

  /**
   * Senza rimozione del nodo.
   * @return chiave di valore massimo.
   */
  @Override
  public K maxKey() {
    if(root == null) return null;
    return getMax(root).key;
  }


  /**
   * Senza rimozione del nodo.
   * @return valore associato alla chiave minima nell'albero. 
   */
    @Override
  public V elementOfMinKey() {
    if(root == null) return null;
    return getMin(root).value;
  }

  /**
   * Senza rimozione del nodo.
   * @return valore associato alla chiave massima nell'albero. 
   */
  
  @Override
  public V elementOfMaxKey() {
    if(root == null) return null;
    return getMax(root).value;
  }

  /**
   * Restituisce il valore associato alla chiave cercata.
   * @param key
   * @return valore se la chiave è presente, null altrimenti.
   */
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

  /**
   * Aggiunta di un valore value con chiave key.
   * @param key
   * @param value
   * @return il nodo aggiunto.
   */
  @Override
  public V add(K key, V value) {
    Node<K,V> node = new Node(key, value, null, null);
    if(root == null) {
       root = node;
       return root.value;
    }    
    return add(node, root);
  }
  
  protected V add(Node<K,V> newNode, Node<K,V> node){
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

  
  protected Node<K,V> remove(K key, Node<K,V> node){
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
  
  protected Node<K,V> getMin(Node node){
    if(node.left != null)
      return getMin(node.left);
    return node;
  }
  
  protected Node<K,V> getMax(Node node){
    if(node.right != null)
      return getMax(node.right);
    return node;
  }

}
