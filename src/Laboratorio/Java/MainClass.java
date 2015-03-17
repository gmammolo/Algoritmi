/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio.Java;

import Laboratorio.Java.ricerca_binaria.IntSortedArray;


/**
 *
 * @author giuseppe
 */
public class MainClass {
    
    
    public static void main(String[] args) {
        IntSortedArray array = new IntSortedArray(3);
        array.insert(2);
        array.insert(4);
        array.insert(6);
        array.insert(3);
        array.insert(1);
//        IntSortedArray array = new IntSortedArray(new int[]{3,4,7,6,2,4,5,4,2,12,4,9});
        System.out.println(array.toString());
        
    }
     
}
