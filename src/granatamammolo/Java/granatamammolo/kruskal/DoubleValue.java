/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.kruskal;

import java.util.function.DoubleSupplier;

/**
 * Estensione del DoubleSupplier.
 * Accetta un numero intero o double.
 * Questa classe è stata creata per fare il test.
 * @author Giuseppe
 */
public class DoubleValue implements DoubleSupplier{

  Double value;
  
  public DoubleValue(Double val) {
    value = val;
  }
  
  public DoubleValue(Integer val) {
    this(val.doubleValue());
  }
  
  @Override
  public double getAsDouble() {
    return value;
  }

  @Override
  public String toString() {
    return value +"";
  }
  
  
}
