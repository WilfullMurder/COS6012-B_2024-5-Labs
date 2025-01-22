/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1.example1;

public class Thread2 extends
        Thread {

    private double a, t, value;

    public Thread2(double a,
            double t) {
        this.a = a;
        this.t = t;
    }

    public void run() {
        value = Math.exp(-a * t * t);
    }

    public double getValue() {
        return value;
    }
}
