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
public class CountThreadsMain extends Thread {

    private int range_initial;
    private int range_final;

    public CountThreadsMain(int range_initial, int range_final) {
        this.range_initial = range_initial;
        this.range_final = range_final;
    }

    public void run() {
        for (int i = range_initial; i <= range_final; i++) {
            System.out.println(i);
        }
    }

}
