package granatamammolo.Java.granatamammolo.dictionary;

import static java.lang.Math.*;

/**
 *
 * @author Federica
 */
public class SearchTree <K extends Comparable <K>, V> implements SortedDictionary  {

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
  
  public String printInOrder(Node node){
    String s = "";
    if(node != null) {
      printInOrder(node.left);
      s += node.value;
      printInOrder(node.right);
    }
    return s;
  }
  
  int height(Node node){
    return (node == null) ? -1 : 1 + max(height(node.left), height(node.right));
  }
  
  public boolean isEmpty() {
    return (this.root != null);
  }
  
  /**
   * Senza rimozione del nodo.
   * @return chiave minima dell'albero
   */
  @Override
  public Comparable minKey() {
    if(root == null) return null;
    return (K) getMin(root).key;
  }

  /**
   * Senza rimozione del nodo.
   * @return chiave di valore massimo.
   */
  @Override
  public Comparable maxKey() {
    if(root == null) return null;
    return (K) getMax(root).key;
  }

  /**
   * Senza rimozione del nodo.
   * @return valore associato alla chiave minima nell'albero. 
   */
  @Override
  public Object elementOfMinKey() {
    if(root == null) return null;
    return getMin(root).value;
  }

  /**
   * Senza rimozione del nodo.
   * @return valore associato alla chiave massima nell'albero. 
   */
  @Override
  public Object elementOfMaxKey() {
    if(root == null) return null;
    return getMax(root).value;
  }

  /**
   * Restituisce il valore associato alla chiave cercata.
   * @param key
   * @return valore se la chiave è presente, null altrimenti.
   */
  @Override
  public Object find(Object key) {
    K keyK = (K) key;     // TOSEE
    Node node = this.root;
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
  public Object add(Object key, Object value) {
    Node node = new Node((K) key, (V) value, null, null);
    if(root == null)  return root = node;    
    return add(node, root);
  }
  
  private Object add(Node newNode, Node node){
    K key = (K) newNode.key;
    K nodeKey = (K) node.key;
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
    }else{  // TOSEE_GIUSE ho trovato un'altra chiave che è uguale a quella che sto inserendo -> errore
      return null;
    }
    return newNode.value;
  }

  @Override
  public void remove(Object key) {
    root = remove((K) key, root);
  }
  
  private Node remove(K key, Node node){
    if(node != null){
      K nodeK = (K) node.key;
      if(key.compareTo(nodeK) < 0)
        remove(key, node.left);
      else if(key.compareTo(nodeK) > 0)
        remove(key, node.right);
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
  
  private Node getMin(Node node){
    if(node.left != null)
      return getMin(node.left);
    return node;
  }
  
  private Node getMax(Node node){
    if(node.right != null)
      return getMin(node.right);
    return node;
  }

}
