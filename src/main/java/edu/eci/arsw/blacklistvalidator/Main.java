/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de hilos (N) a utilizar: ");
        int N = sc.nextInt();

        HostBlackListsValidator hblv = new HostBlackListsValidator();

        long start = System.currentTimeMillis();
        List<Integer> blackListOcurrences = hblv.checkHost("202.24.34.55", N);
        long end = System.currentTimeMillis();

        System.out.println("The host was found in the following blacklists:" + blackListOcurrences);
        System.out.println("Total ocurrences: " + blackListOcurrences.size());
        System.out.println("Elapsed time with " + N + " threads: " + (end - start) + " ms");

        sc.close();
    }
}
