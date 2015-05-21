package granatamammolo.Java.granatamammolo.dictionary;

import static java.lang.Math.*;

/**
 *
 * @author Federica
 */
public class AVLTree <K, V> implements SortedDictionary  {

// dictionary implementato come hashmap
  // quindi dentro key la chiave, mentre dentro value il nodo con valore e nodo dx e sx


    @Override
    public Object find(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  protected static class Node <K, V> {
    K key;
    V value;
    Node left, right;
    
    Node(K k, V v, Node l, Node r){
      this.key = k;
      this.value = v;
      this.left = l;
      this.right = r;
    }
  }
  
  protected Node root;
  
  public AVLTree(){
    root = null;
  }
  
  public AVLTree(K key, V value){
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
  
  int height(Node node){
    return (node == null) ? -1 : 1 + max(height(node.left), height(node.right));
  }
  
  @Override
  public boolean isEmpty() {
    return (this.root != null);
  }
  

//  @Override
//  public V find(K key) {
//    
//  }
  
  
  public Comparable minKey() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Comparable maxKey() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Object elementOfMinKey() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Object elementOfMaxKey() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }


  @Override
  public Object add(Object key, Object value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void remove(Object key) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
 
}
