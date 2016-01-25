/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammolo.Java.mammolo.dijkstra;

import java.util.Objects;
import java.util.function.DoubleSupplier;

/**
 * implements DoubleSupplier
 * @author Giuseppe
 */
public class NodoPrioritario<V> implements Comparable<NodoPrioritario<V>> , DoubleSupplier {

  V node;
  Double value;
  
  public NodoPrioritario(V nodo, Double val) {
    node = nodo; 
    value = val;
  }
  
  public NodoPrioritario(V node, Integer val) {
      this(node, val.doubleValue());
  }
  
  public V getNode() 
  {
      return node;
  }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.node);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodoPrioritario<?> other = (NodoPrioritario<?>) obj;
        if (!Objects.equals(this.node, other.node)) {
            return false;
        }
        return true;
    }
  

  
  @Override
  public double getAsDouble() {
    return value;
  }

  @Override
  public String toString() {
    return value +"";
  }

    @Override
    public int compareTo(NodoPrioritario o) {
       return (int)(getAsDouble() - o.getAsDouble());
    }
  
    
}
