package granatamammolo.Java.granatamammolo.priorityqueue;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author giuseppe
 */
public class PriorityQueueSimple<E, P extends Comparable <P>> implements PriorityQueue{

  private final ArrayList<PairValue> elements;

  // TOSEE_GIUSE se nei test volessi (e mi serve) testare la nuova priorità (getPriority), non lo si può fare
  // perchè io di là non ho l'oggetto pair value --> bisogna inserirlo nella classe esterna. Inoltre i metodi in pair
  // value, a meno che li utilizzi tu, non servono.
  // metto dei commenti nei test su dove vorrei cosa
  public PriorityQueueSimple(){
      elements = new ArrayList<>();
  }

  private class PairValue{
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
    

  private int binarySearch(P x) {
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
  public boolean add(Object element, Comparable priority) {
    E elem;
    P prior;
    try {
        elem = (E) element;
        prior = (P) priority;
    } catch(ClassCastException e) {
        return false;
    }
      
    if(elements.contains(new PairValue(elem, null)))
      return false;

    int index = binarySearch(prior);
    if (index < 0) 
      index = -(index + 1);
    elements.add(index, new PairValue(elem, prior));
    return true;
  }
  
      

  @Override
  public boolean delete(Object element) {
    E elem;
    try {
        elem = (E) element;
    } catch(ClassCastException e) {
        return false;
    }
    return elements.remove(new PairValue((E) element, null));
  }

  @Override
  public boolean setPriority(Object element, Comparable priority) {
    E elem;
    P prior;
    try {
        elem = (E) element;
        prior = (P) priority;
    } catch(ClassCastException e) {
        return false;
    }
    int index = elements.indexOf(new PairValue(elem, null));
    if(index < 0)
      return false;
    elements.remove(index);
    elements.add(new PairValue(elem, prior));
    return true;
  }
  
  
  
    
}
