package mammolo.priorityqueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author giuseppe
 * @param <E> Tipo dell' elemento da inserire
 * @param <P> Tipo della priorità
 */
public class PriorityQueueHeap<E, P extends Comparable<P>> implements PriorityQueue<E, P> {

  private class binaryTree {

    private class PairValue {

      private E element;
      private P priority;

      public PairValue(E element, P priority) {
        this.element = element;
        this.priority = priority;
      }

      public E getElement() {
        return element;
      }

      public void setElement(E element) {
        this.element = element;
      }

      public P getPriority() {
        return priority;
      }

      public void setPriority(P priority) {
        this.priority = priority;
      }

      @Override
      public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.element);
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

    HashMap<E, Integer> position;
    ArrayList<PairValue> heap;

    public binaryTree(int initialCapacity) {
      heap = new ArrayList<>(initialCapacity);
      position = new HashMap<>(initialCapacity);
    }

    /**
     * Restituisce l'indice del figlio sinistro dell'elemento all'indice index.
     *
     * @param index indice dell'elemento su cui operare.
     * @return int indice del figlio sinistro o -1 se non ha un figlio sinistro.
     */
    private int getLeft(int index) {
      int left = 2 * index + 1;
      return (left < heap.size()) ? left : -1;
    }

    /**
     * Restituisce l'indice del figlio destro dell'elemento all'indice index.
     *
     * @param index indice dell'elemento su cui operare.
     * @return int indice del figlio destro 0 -1 se non ha il figlio destro.
     */
    private int getRight(int index) {
      int right = 2 * index + 2;
      return (right < heap.size()) ? right : -1;
    }

    /**
     * Restituisce l'indice del padre.
     *
     * @param index indice dell'elemento su cui operare.
     * @return indice del padre o -1 se non ha un padre.
     */
    private int getParent(int index) {
      int parent = (index - 1) / 2;
      return (parent >= 0) ? parent : -1;
    }

    private void moveUp(int i) {
      if (i >= heap.size() || i < 0) {
        throw new IllegalArgumentException();
      }
      PairValue pv = heap.get(i);
      while (i > 0 && pv.getPriority().compareTo(heap.get(getParent(i)).getPriority()) < 0) {
        heap.set(i, heap.get(getParent(i)));
        position.put(heap.get(getParent(i)).element, i);
        i = getParent(i);
      }
      heap.set(i, pv);
      position.put(pv.element, i);
    }

    private void moveDown(int i) {
      if (i >= heap.size() || i < 0) {
        throw new IllegalArgumentException();
      }
      PairValue pv = heap.get(i);
      while ((getLeft(i) + getRight(i)) >= -1) { // ha almeno un figlio
        int minleaf = getLeft(i);
        if (getRight(i) != -1 && heap.get(getRight(i)).getPriority().compareTo(heap.get(getLeft(i)).getPriority()) < 0) {
          minleaf = getRight(i);
        }
        heap.set(i, heap.get(minleaf));
        position.put(heap.get(minleaf).element, i);
        i = minleaf;
      }
      heap.set(i, pv);
      position.put(pv.element, i);
    }

    private boolean add(E element, P priority) {
      if (position.containsKey(element) || priority == null) {
        return false;
      }
      heap.add(new PairValue(element, priority));
      moveUp(heap.size() - 1);
      return true;
    }

    private E first() {
      if (heap.size() == 0) {
        return null;
      }
      return heap.get(0).getElement();
    }

    private E removeFirst() {
      if (heap.size() == 0) {
        return null;
      }
      PairValue first = heap.get(0);
      heap.set(0, heap.get(heap.size() - 1));
      heap.remove(heap.size() - 1);
      if (heap.size() > 0) {
        moveDown(0);
      }
      return first.getElement();

    }

    private boolean isEmpty() {
      return heap.isEmpty();
    }

    private boolean delete(E element) {
      Integer index = position.get(element);
      if (index == null) {
        return false;
      }
      heap.set(index, heap.get(heap.size() - 1));
      moveDown(index);
      heap.remove(heap.size() - 1);
      return true;
    }

    private boolean setPriority(E element, P priority) {
      Integer index = position.get(element);
      if (index == null) {
        return false;
      }
      heap.set(index, new PairValue(element, priority));
      return true;
    }

  }

  binaryTree albero;

  public PriorityQueueHeap() {
    this(16);
  }

  public PriorityQueueHeap(int capacity) {
    albero = new binaryTree(capacity);
  }

  @Override
  public E first() {
    return albero.first();
  }

  @Override
  public E removeFirst() {
    return albero.removeFirst();
  }

  @Override
  public boolean isEmpty() {
    return albero.isEmpty();
  }

  @Override
  public boolean add(E element, P priority) {
    return albero.add(element, priority);
  }

  @Override
  public boolean delete(E element) {
    return albero.delete(element);
  }

  @Override
  public boolean setPriority(E element, P priority) {
    return albero.setPriority(element, priority);
  }
}
