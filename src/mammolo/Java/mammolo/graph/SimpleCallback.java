/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mammolo.Java.mammolo.graph;

import java.util.ArrayList;

/**
 * Callback Creata come ausilio per i test.
 * Salva i Nodi in un arrayList nell' ordine in cui vengono visitati
 * @author Giuseppe
 */
public class SimpleCallback  implements SearchCallback<String, Integer>{

  ArrayList<String> coda = new ArrayList<>();
  
  
  @Override
  public void onVisitingVertex(String vertex) {
    coda.add(vertex);
  }

  @Override
  public void onTraversingEdge(String source, String dest, Integer info) {
    
  }
  
  public ArrayList<String> getCoda(){
    return coda;
  }
  
}
