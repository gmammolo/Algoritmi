/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lezione.Java.sort;

/**
 *
 * @author Giuseppe
 */
public class isort {

    public static void isort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int x = a[i];
            int j;
            for (j = i; j > 0; j--) {
                if (x >= a[j - 1]) {
                    break;
                }
                a[j] = a[j - 1];
            }
            a[j] = x;
        }
    }

    static int rBin(int x, int[] a, int ini, int end) {
        if (x < a[ini]) {
            return ini;
        }
        if (x >= a[end]) {
            return end + 1;
        }
        while (ini <= end) {
            int mid = (ini + end) >>> 1;
            if (x < a[mid]) {
                end = mid - 1;
            } else {
                ini = mid + 1;
            }
        }
        return ini;
    }

    public static void isortBin(int[] a) {
        int n = a.length;
        if (n == 0) {
            return;
        }
        int start = 1; // cerca il primo elemento non in ordine
        while (start < n && a[start] >= a[start - 1]) {
            start++;
        }
        if (start == n) {
            return; // l'array è già ordinato
        }
        for (int i = start; i < n; i++) {
            int x = a[i];
            int iInser = rBin(x, a, 0, i - 1);
            for (int j = i; j > iInser; j--) {
                a[j] = a[j - 1];
            }
            a[iInser] = x;
        }
    }

    public static void isortBinMOD(int[] a) {
        int n = a.length;
        if (n == 0) {
            return;
        }
        for (int i = 1; i < n; i++) {
            while (i < n && a[i] >= a[i - 1]) {
                i++;
            }
            int x = a[i];
            int iInser = rBin(x, a, 0, i - 1);
            for (int j = i; j > iInser; j--) {
                a[j] = a[j - 1];
            }
            a[iInser] = x;
        }
    }

}
