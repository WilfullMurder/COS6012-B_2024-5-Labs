/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1.example1;

public class Thread1 extends Thread {

    private double K, a, t, value;

    public Thread1(double K, double a, double t) {
        this.K = K;
        this.a = a;
        this.t = t;
    }

    public void run() {
        value = 2 * K * a * t;
    }

    public double getValue() {
        return value;
    }
}
