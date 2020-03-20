package com.baba.NumberTheory;

public class EEA {
    /**
     * Extended Euclid's Algorithm
     */
    static int x;
    static int y;
    static int Gcd;

    public static void main(String[] args) {
        System.out.println(multiplicativeModuloInverse(6,7));
    }

    static void extendedEuclidAlgorithm(int a, int b) {
        if (b == 0) {
            x = 1;
            y = 0;
            Gcd = a;
            return;
        }
        extendedEuclidAlgorithm(b, a % b);
        int cX = y;
        int cY = x - (a / b) * y;

//        System.out.println(cX + " " + cY);

        x = cX;
        y = cY;
    }

    static int multiplicativeModuloInverse(int a, int m){
        extendedEuclidAlgorithm(a, m);
        return (x+m)%m;
    }
}
