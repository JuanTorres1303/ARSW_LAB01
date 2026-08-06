/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThread {

    public static void main(String a[]) {
        CountThreadsMain t1 = new CountThreadsMain(0, 99);
        CountThreadsMain t2 = new CountThreadsMain(100, 199);
        CountThreadsMain t3 = new CountThreadsMain(200, 299);
        t1.start();
        t2.start();
        t3.start();
    }

}
