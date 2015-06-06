package granatamammolo.Java.granatamammolo.priorityqueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author giuseppe
 */
public class PriorityQueueStringDoubleHeap implements PriorityQueueStringDouble{
  
  private class binaryTree {
        
    private class PairValue {
      private String element;
      private double priority;

      public PairValue(String element, double priority) {
        this.element = element;
        this.priority = priority;
      }

      public String getElement() {
        return element;
      }

      public void setElement(String element) {
        this.element = element;
      }

      public double getPriority() {
        return priority;
      }

      public void setPriority(double priority) {
        this.priority = priority;
      }

      @Override
      public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.element);
        return hash;
      }

      @Override
      public boolean equals(Object obj) {
        if (obj == null) {
          return false;
        }
        if (getClass() != obj.getClass()) {
          return false;
        }
        final PairValue other = (PairValue) obj;
        if (!Objects.equals(this.element, other.element)) {
          return false;
        }
        return true;
      }
      
    }
      
    HashMap<String,Integer> position;
    ArrayList<PairValue> heap;
         
    public binaryTree(int initialCapacity) {
        heap = new ArrayList<>(initialCapacity);  
        position = new HashMap<>(initialCapacity);
    }   
         
    /**
    * Restituisce l'indice del figlio sinistro dell'elemento all'indice index.
    * @param index indice dell'elemento su cui operare.
    * @return int indice del figlio sinistro o -1 se non ha un figlio sinistro.
    */
    private int getLeft(int index) {
      int left= 2*index +1;
      return (left < heap.size()) ? left : -1 ;
    }
        
    /**
    * Restituisce l'indice del figlio destro dell'elemento all'indice index.
    * @param index indice dell'elemento su cui  operare.
    * @return int indice del figlio destro 0 -1 se non ha il figlio destro.
    */
    private int getRight(int index) {
      int right =  2*index+2;
      return (right < heap.size()) ? right : -1 ;
    }

    /**
    * Restituisce l'indice del padre.
    * @param index indice dell'elemento su cui operare.
    * @return indice del padre o -1 se non ha un padre.
    */
    private int getParent(int index) {
      int parent = (index-1)/2;
      return (parent >= 0 ) ? parent : -1;
    }

    private void moveUp(int i) {
      if(i >= heap.size() || i < 0) throw new IllegalArgumentException();
      PairValue pv = heap.get(i);
      while (i>0 && pv.getPriority() < heap.get(getParent(i)).getPriority() ) {
        heap.set(i, heap.get(getParent(i)) );
        position.put(heap.get(getParent(i)).element, i);
        i=getParent(i);
      }
      heap.set(i, pv);
      position.put(pv.element, i);
    }
        
    private void moveDown(int i) {  
      if(i >= heap.size() || i < 0)  throw new IllegalArgumentException();
      PairValue pv = heap.get(i);
      while((getLeft(i) + getRight(i)) >= -1 ) { // ha almeno un figlio
        int minleaf = getLeft(i);
        if(getRight(i) != -1 && heap.get(getRight(i)).getPriority() < heap.get(getLeft(i)).getPriority() )
          minleaf = getRight(i);
        heap.set(i, heap.get(minleaf));
        position.put(heap.get(minleaf).element, i);
        i=minleaf;
      }
      heap.set(i, pv);  
      position.put(pv.element, i);
    }

    private boolean add(String element, double priority) {
      if(position.containsKey(element))
        return false;
      heap.add(new PairValue(element, priority));
      moveUp(heap.size()-1);
      return true;
    }

    private String first() {    
      if(heap.size() == 0) return null;
      return heap.get(0).getElement();
    }

    private String removeFirst() {
      if(heap.size() == 0)  return null;
      PairValue first = heap.get(0);
      heap.set(0, heap.get(heap.size() - 1));
      heap.remove(heap.size() - 1);
      if(heap.size() > 0 )
        moveDown(0);
      return first.getElement();

    }

    private boolean isEmpty() {
      return heap.isEmpty();
    }

    private boolean delete(String element) {
      Integer index = position.get(element);
      if(index == null ) return false;
      heap.set(index, heap.get(heap.size() - 1));
      moveDown(index);
      heap.remove(heap.size() - 1);
      position.remove(element);
      return true;
    }

    private boolean setPriority(String element, double priority) {
      Integer index = position.get(element);
      if(index == null) return false;
      delete(element);
      add(element, priority);
      return true;
    }
         
  }
    
    binaryTree albero;
    
    public PriorityQueueStringDoubleHeap() {
      this(16);
    }
    
    public PriorityQueueStringDoubleHeap(int capacity) {
      albero = new binaryTree(capacity);
    }
    
    
    @Override
    public boolean add(String element, double priority) {
        if(priority < 0)
            throw new IllegalArgumentException("La priorita' deve essere positiva");
        return albero.add(element,priority);
    }

    @Override
    public String first() {
      return albero.first();
    }

    @Override
    public String removeFirst() {
      return albero.removeFirst();
    }

    @Override
    public boolean isEmpty() {
      return albero.isEmpty();
    }

    @Override
    public boolean delete(String element) {
      return albero.delete(element);
    }

    @Override
    public boolean setPriority(String element, double priority) {
        if(priority <= 0)
            return false;
        return albero.setPriority(element, priority);
    }
    
}
