/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.priorityqueue;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author giuseppe
 */
public class PriorityQueueStringDoubleSimple implements PriorityQueueStringDouble{

    private final ArrayList<PairValue> elements;
    
    public PriorityQueueStringDoubleSimple()
    {
        elements = new ArrayList<>();
    }
    
    private class PairValue
    {
        String element;
        double priority;
        
        public PairValue(String element, double priority)
        {
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
    

    private int binarySearch(Double x) {
      int ini = 0, fin = elements.size() - 1;
      if (fin == -1 || x < elements.get(0).getPriority())
        return -1;
      if (x > elements.get(fin).getPriority())
        return -(elements.size() + 1);
      while (ini <= fin) {
        int i = (ini + fin) >>> 1;
        if (x < elements.get(i).getPriority() ) {
          fin = i - 1;
        } else if (x >  elements.get(i).getPriority()) {
          ini = i + 1;
        } else {
          return i;
        }
      }
      return -(ini+1);
    }
    
    @Override
    public boolean add(String element, double priority) {
        if(elements.contains(new PairValue(element, 0)))
            return false;
        
        int index = binarySearch(priority);
        if (index < 0) 
                index = -(index + 1);
        elements.add(index, new PairValue(element, priority));
        return true;
    }

    @Override
    public String first() {
        return (elements.size() > 0) ? elements.get(0).getElement() : null ;
            
    }

    @Override
    public String removeFirst() {
        return ( elements.size() > 0) ? elements.remove(0).getElement()  :  null ;
        
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean delete(String element) {
        return elements.remove(new PairValue(element, 0));
    }

    @Override
    public boolean setPriority(String element, double priority) {
        int index= elements.indexOf(new PairValue(element, 0));
        if(index < 0)
            return false;
        elements.remove(index);
        elements.add(new PairValue(element, priority));
        return true;
    }
    
}
