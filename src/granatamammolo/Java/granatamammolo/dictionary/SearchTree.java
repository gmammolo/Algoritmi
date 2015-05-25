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
  
  public void printPreOrder(Node node){
    System.out.print("( Key - Value )\n");
    if(node != null) {
      System.out.print("(" + node.key + " - " + node.value + ")");
      printPreOrder(node.left);
      printPreOrder(node.right);
    }
  }
  
  public void printInOrder(Node node){
    if(node != null) {
      System.out.print("(" + node.key + " - " + node.value + ")");
      printPreOrder(node.left);
      System.out.print("( Key - Value )\n");
      printPreOrder(node.right);
    }
  }
  
  int height(Node node){
    return (node == null) ? -1 : 1 + max(height(node.left), height(node.right));
  }
  
  public boolean isEmpty() {
    return (this.root != null);
  }
  
  /**
   * Considerata l'implementazione utilizzata, la chiave minima corrisponde
   * alla radice dell'albero. Senza rimozione TOSEE_GIUSE
   * @return chiave minima = radice 
   */
  @Override
  public Comparable minKey() {
    Node min = this.root;
    // (se ci fosse la rimozione) bilanciamento con root vuota TOSEE_GIUSE 
    return (Comparable) min.key;
  }

  /**
   * 
   * @return chiave di valore massimo.
   */
  @Override
  public Comparable maxKey() {
    if(root == null) return null;
    return maxKey(root.key, root);
  }
  
  private Comparable maxKey(K max, Node node){
    K nodeK = (K) node.key;
    if(node != null){
      if(nodeK.compareTo(max) > 0) max = nodeK;
      maxKey(max, node.left);
      maxKey(max, node.right);
    }
    return max;
  }

  /**
   * Considerata l'implementazione utilizzata, la chiave minima corrisponde
   * alla radice dell'albero. Senza rimozione TOSEE_GIUSE
   * @return chiave minima = radice 
   */
  @Override
  public Object elementOfMinKey() {
    Node min = this.root;
    // (se ci fosse la rimozione) bilanciamento con root vuota TOSEE_GIUSE 
    return (Comparable) min.value;
  }

  /**
   * 
   * @return valore associato alla chiave massima.
   */
  @Override
  public Object elementOfMaxKey() {
    K maxK = (K) this.maxKey();
    return find(maxK);
  }

  /**
   * Restituisce il valore associato alla chiave cercata.
   * @param key
   * @return valore se la chiave è presente, null altrimenti.
   */
  @Override
  public Object find(Object key) {
    K keyK = (K) key;     // TOSEE_GIUSE: per scansare il problema dell'object ho fatto così, spero gli vada bene!!
    Node node = this.root;
    while(node != null) {
      K nodeKey = (K) node.key;    // TOSEE_GIUSE perchè gli devo fare il cast?????? il metodo ritorna già un tipo K!!
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
    }
    return node = newNode;
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
          node.value = ???
      }
    }
  }

}
