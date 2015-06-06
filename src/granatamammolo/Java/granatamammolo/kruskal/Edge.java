/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.kruskal;

import java.util.Objects;
import java.util.function.DoubleSupplier;

/**
 *
 * @author Giuseppe
 */

  public class Edge<V, E extends DoubleSupplier> {
    V v1 ;
    V v2 ;
    E data ;
    
    public Edge(V v1, V v2, E data)
    {
      this.v1 = v1;
      this.v2 = v2;
      this.data = data;
    }

    @Override
    public int hashCode() {
      int hash = 3;
      hash = 11 * hash + Objects.hashCode(this.v1);
      hash = 11 * hash + Objects.hashCode(this.v2);
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
      final Edge other = (Edge) obj;
      if (Objects.equals(this.v1, other.v1) && Objects.equals(this.v2, other.v2) ) {
        return true;
      }
      if (Objects.equals(this.v1, other.v2) && Objects.equals(this.v2, other.v1) ) {
        return true;
      }
      
      return false;
    }

    @Override
    public String toString() {
      return "{"+v1 + "--" + data + "->" + v2+"}";
    }
    
    
  }        
