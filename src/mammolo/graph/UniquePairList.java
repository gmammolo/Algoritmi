/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammolo.graph;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Semplicissima Lista che contiene una coppia di valori, Assicurandosi che la coppia non si ripeta
 * @author Giuseppe
 */
public class UniquePairList<V> {
  
  ArrayList<UniquePairValue<V>> list;
  
  public UniquePairList() {
    list= new ArrayList<>();
  }


  public boolean add(V a, V b) {
    UniquePairValue<V> pair = new UniquePairValue(a,b);
    if(list.contains(pair ))
      return false;
    list.add(pair);
    return true;
  }
  
  
  public int size() {
    return list.size();
  }
  
  public V getFirst(int index) {
    return list.get(index).first;
  }
  
  public V getSecond(int index) {
    return list.get(index).second;
  }
  
  protected class UniquePairValue<V> {
    V first;
    V second;
    
    public UniquePairValue(V f, V s) {
      first =f;
      second = s;
    }

    @Override
    public int hashCode() {
      int hash = 5;
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
      final UniquePairValue<?> other = (UniquePairValue<?>) obj;
      
      if(Objects.equals(this.first, other.first) && Objects.equals(this.second, other.second))
        return true;
      
      if (Objects.equals(this.first, other.second) && Objects.equals(this.second, other.first)  ) {
        return true;
      }

      return false;
    }
    
    
  }

}
