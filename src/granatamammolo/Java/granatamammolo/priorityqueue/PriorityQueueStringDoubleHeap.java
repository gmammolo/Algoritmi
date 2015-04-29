package granatamammolo.Java.granatamammolo.priorityqueue;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author giuseppe
 */
public class PriorityQueueStringDoubleHeap implements PriorityQueueStringDouble{
  
  private class binaryTree     {
        
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
        
    ArrayList<PairValue> heap;
         
      public binaryTree(int initialCapacity) {
          heap = new ArrayList<>(initialCapacity);    
      }   
         
      /**
      * Restituisce l'indice del figlio sinistro dell'elemento all'indice index.
      * @param index indice dell'elemento su cui operare.
      * @return int indice del figlio sinistro o -1 se non ha un figlio sinistro.
      */
      private int getLeft(int index) {
        int left= 2*index +1;
        return (left <= heap.size()) ? left : -1 ;
      }
        
      /**
      * Restituisce l'indice del figlio destro dell'elemento all'indice index.
      * @param index indice dell'elemento su cui  operare.
      * @return int indice del figlio destro 0 -1 se non ha il figlio destro.
      */
      private int getRight(int index) {
        int right =  2*index+2;
        return (right <= heap.size()) ? right : -1 ;
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
          i=getParent(i);
        }
        heap.set(i, pv);
      }
        
      private void moveDown(int i) {        // TOSEE_GIUSE: credo che l'errore sia qui, perchè tutti i test che falliscono hanno in comune questo metodo
        if(i >= heap.size() || i < 0)  throw new IllegalArgumentException();
        PairValue pv = heap.get(i);
        while((getLeft(i) + getRight(i)) >= -1 ) { // ha almeno un figlio
          int minleaf = getLeft(i);
          if(heap.get(getRight(i)).getPriority() < heap.get(getLeft(i)).getPriority() )
            minleaf = getRight(i);
          heap.set(i, heap.get(minleaf));
          i=minleaf;
        }
        heap.set(i, pv);            
      }
         
      private boolean add(String element, double priority) {
        if(heap.contains(new PairValue(element, priority)))
          return false;
        heap.add(new PairValue(element, priority));
        moveUp(heap.size()-1);
        return true;
      }

      private String first() {    // TOSEE_GIUSE non è meglio tornare null piuttosto che un'eccezione?
        if(heap.size() == 0)  throw new IllegalArgumentException();
        return heap.get(0).getElement();
      }

      private String removeFirst() {  // TOSEE_GIUSE non è meglio tornare null piuttosto che un'eccezione?
        if(heap.size() == 0)  throw new IllegalArgumentException();
        PairValue first = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        moveDown(0);
        return first.getElement();

      }

      private boolean isEmpty() {
        return heap.isEmpty();
      }

      private int binarySearch(String element) {
        int ini = 0, fin = heap.size() - 1;
        if (fin == -1 || element.compareTo(heap.get(0).getElement()) < 0 )
          return -1;
        if (element.compareTo(heap.get(fin).getElement()) > 0)
          return -(heap.size() + 1);
        while (ini <= fin) {
          int i = (ini + fin) >>> 1;
          if (element.compareTo(heap.get(i).getElement() )< 0 ) {
            fin = i - 1;
          } else if (element.compareTo(heap.get(i).getElement()) > 0) {
            ini = i + 1;
          } else {
            return i;
          }
        }
        return -(ini+1);
        }

      private boolean delete(String element) {
        //if(!heap.contains(element)) return false;
        int index = binarySearch(element);
        if(index < 0) return false;
        heap.set(index, heap.get(heap.size() - 1));
        moveDown(index);
        return true;
      }

      private boolean setPriority(String element, double priority) {
        int index = binarySearch(element);
        if(index < 0) return false;
        heap.set(index, new PairValue(element, priority));
        return true;
      }
         
    }
    
    binaryTree albero;
    
    public PriorityQueueStringDoubleHeap() {
      this(16);
    }
    
    public PriorityQueueStringDoubleHeap(int capacity) {
      albero = new binaryTree( capacity);
    }
    
    
    @Override
    public boolean add(String element, double priority) {
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
      return albero.setPriority(element, priority);
    }
    
}
