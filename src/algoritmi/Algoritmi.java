/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmi;

import algoritmi.bandiera.Bandiera;
import algoritmi.ssm3.ssm3;
import java.util.Arrays;

/**
 *
 * @author Giuseppe
 */
public class Algoritmi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//            ExecuteSSM3();
        Bandiera();
    }
    
    /**
     * Esegue un fac simile della classe ssm3, con dei dati di prova già preimpostati
     */
    public static void ExecuteSSM3()
    {
        int[] a = {-7, 4, -8, 3, 4, -2, 6, -10, 1, 3, -9, 9};
        int[] res = ssm3.ssm3(a);
        
        System.out.println("Somma:"+res[0]+"\t Indici:"+res[1]+"-"+res[2]);
        System.out.print("{");
        for(int i=0; i<a.length;i++)
        {
            if(i>=res[1] && i<=res[2])
                System.out.print(ColorRed(a[i])+";");
            else
                System.out.print(a[i]+";");
        }
        System.out.println("}");
    }
    
    
    /**
     * Esegue un Fac Simile della Bandiera, con dei dati già preimpostati
     */
    public static void Bandiera()
    {
        Integer[] ar = new Integer[]{2,3,5,6,7,9,12,43,4,1,7,5,3};
        System.out.println("OLD:\n"+Arrays.deepToString(ar));
        Bandiera.Bandiera(ar);
        System.out.println("NEW:\n"+Arrays.deepToString(ar));
    }
    
    
    /**
     * Trasforma un intero affinchè si possa scrivere in rosso sulla console
     * di output
     * @param number
     * @return un numero pronto da stampare in rosso
     */
    private static String ColorRed(int number)
    {
        String red=(char)27 + "[31m" , endRed = (char)27 + "[0m" ;
        return red+number+endRed;
    }
    
    /**
     * Trasforma una stringa affinchè si possa scrivere in rosso sulla console
     * di output
     * @param value
     * @return 
     */
    private static String ColorRed(String value)
    {
        String red=(char)27 + "[31m" , endRed = (char)27 + "[0m" ;
        return red+value+endRed;
    }
    
}
