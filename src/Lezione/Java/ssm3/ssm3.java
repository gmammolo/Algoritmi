/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lezione.Java.ssm3;

/**
 *
 * @author Giuseppe
 */
public class ssm3 {
    
    
    
    /**
     * Dato un array di interi trovare la  sequenza di interi consecutivi con 
     * la somma maggiore che si possa ottenere nell' array 
     * @param a array dentro il quale cercare il segmento di somma massima
     * @return <code>a[0] = maxSom</code>: somma massima  <br>
     * <code>a[1] = iniMax</code>: indice di inizio della sequenza <br>
     * <code>a[2] = finMax</code>: indice di fine della sequenza <br>
     */
    public static int[] ssm3(int[] a) {
        int n = a.length;
        if(n==0)
            return new int[]{0,0,0};
        int somma = a[0], maxSom = a[0];
        int iniSom = 0;
        int iniMax = 0, finMax = 0;
        for (int j = 1; j < n; j++) {
            if (somma > 0) {
                somma += a[j];
            } else {
                somma = a[j];
                iniSom = j;
            }
            
            if(somma > maxSom)
            {
                maxSom = somma;
                iniMax = iniSom;
                finMax = j;
            
            }
        }
        return new int[]{maxSom, iniMax, finMax};
    }
}
