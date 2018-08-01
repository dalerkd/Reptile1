package com.company;

/*
 * ax2+bx+c
 *
 * */
public class QuadPolynomial {
    public int a;
    public int b;
    public int c;

    public int result(int x) {
        return a * x * x + b * x + c;
    }

}
