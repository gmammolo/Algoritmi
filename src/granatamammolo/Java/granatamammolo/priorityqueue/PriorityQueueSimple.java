package granatamammolo.Java.granatamammolo.priorityqueue;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author giuseppe
 */
public class PriorityQueueSimple<E, P extends Comparable <P>> implements PriorityQueue<E,P>{

  protected final ArrayList<PairValue> elements;

  public PriorityQueueSimple(){
      elements = new ArrayList<>();
  }

  protected class PairValue{
    E element;
    P priority;

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
            hash = 47 * hash + Objects.hashCode(this.element);
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
    

  protected int binarySearch(P x) {
    int ini = 0, fin = elements.size() - 1;
    if (fin == -1 || x.compareTo(elements.get(0).getPriority()) < 0 )
      return -1;
    if (x.compareTo(elements.get(fin).getPriority()) > 0)
      return -(elements.size() + 1);
    while (ini <= fin) {
      int i = (ini + fin) >>> 1;
      if (x.compareTo(elements.get(i).getPriority()) < 0 ) {
        fin = i - 1;
      } else if (x.compareTo(elements.get(i).getPriority()) >  0) {
        ini = i + 1;
      } else {
        return i;
      }
    }
    return -(ini+1);
  }
    

  @Override
  public E first() {
    return (elements.size() > 0) ? elements.get(0).getElement() : null ;
  }

  @Override
  public E removeFirst() {
    return ( elements.size() > 0) ? elements.remove(0).getElement()  :  null ;

  }

  @Override
  public boolean isEmpty() {
    return elements.isEmpty();
  }

  @Override
  public boolean add(E element, P priority) {
      
    if(element == null || elements.contains(new PairValue(element, null)))
      return false;

    int index = binarySearch(priority);
    if (index < 0) 
      index = -(index + 1);
    elements.add(index, new PairValue(element, priority));
    return true;
  }
  
      

  @Override
  public boolean delete(E element) {
    return elements.remove(new PairValue(element, null));
  }

  @Override
  public boolean setPriority(E element, P priority) {
    int index = elements.indexOf(new PairValue(element, null));
    if(index < 0)
      return false;
    elements.remove(index);
    add(element, priority);
    return true;
  }
  
  
  
    
}
