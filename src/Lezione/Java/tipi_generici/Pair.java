/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lezione.Java.tipi_generici;

/**
 *
 * @author giuseppe
 */
public class Pair<type1, type2> {
    
    private type1 first;
    private type2 second;
    
    public Pair(type1 first, type2 second)
    {
        this.first = first;
        this.second = second;
    }

    public type1 getFirst() {
        return first;
    }

    public void setFirst(type1 first) {
        this.first = first;
    }

    public type2 getSecond() {
        return second;
    }

    public void setSecond(type2 second) {
        this.second = second;
    }

    public Boolean equalToFirst(type1 x)
    {
        return x.equals(first);
    }
    
    public Boolean equalToSecond(type2 x)
    {
        return x.equals(first);
    }
    
}


