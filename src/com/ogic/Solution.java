package com.ogic;

public class Solution {
    static int[] ti = new int[20];

    public int S(int x) {
        return x + 1;
    }

    public int N(int x) {
        return 0;
    }

    public int add(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int fac(int x) {
        if (x < 0) {
            return -1;
        }

        if (x == 0) {
            return 1;
        }

        return mul(x, fac(x - 1));
    }

    public int exp(int x, int y) {
        if (y < 0) {
            return -1;
        }

        if (y == 0) {
            return x;
        }

        return mul(x, exp(x, y - 1));
    }

    public int P(int x) {
        if (x > 0) {
            return x - 1;
        }
        return 0;
    }

    public int sub(int x, int y) {
        if (x > y) {
            return x - y;
        }
        return 0;
    }

    public int abs(int x, int y) {
        return sub(x, y) + sub(y, x);
    }

    public int a(int x) {
        if (x == 0) {
            return 1;
        }
        return 0;
    }

    public int d(int x, int y) {
        return a(a(abs(x, y)));
    }

    public boolean equal(int x, int y) {
        if (d(x, y) == 0) {
            return true;
        }
        return false;
    }

    public boolean greaterThan(int x, int y) {
        if (a(sub(x, y)) == 0) {
            return true;
        }
        return false;
    }

    public boolean notGreaterThan(int x, int y) {
        return !greaterThan(x, y);
    }

    public boolean isXExactDivisionByY(int x, int y) {
        for (int i = 0; i <= x; i++) {
            if (mul(i, y) == x) {
                return true;
            }
        }
        return false;
    }

    public int exactDivisionYByX(int x, int y) {
        for (int i = 0; i <= x; i++) {
            if (mul(x, i + 1) > y) {
                return i;
            }
        }
        return 0;
    }

    public boolean isPrime(int x) {
        if (x > 1) {
            for (int i = 2; i < x; i++) {
                if (isXExactDivisionByY(x, i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int getPrimeByIndex(int index) {
        if (index < 0) {
            return -1;
        }
        if (index == 0) {
            return 0;
        }
        int primeNum = 2;
        int primeLen = 0;
        while (primeLen < index) {
            if (isPrime(primeNum)) {
                primeLen++;
            }
            primeNum++;
        }
        return primeNum;
    }

    public int R(int x, int y) {
        return mul(sub(x, y), exactDivisionYByX(y, x));
    }

    //20
    public int t(int x) {
        if (!isPrime(x)) {
            int ln=0;
            for(int j=0; j < x; j++){
                if(isXExactDivisionByY(x,j) && isPrime(j)){
                    ln++;
                    x = exactDivisionYByX(j,x);
                }
            }
            return ln;
        }
        return 0;
    }

    //21
    public int ti(int x) {
        //int[] ti = new int[20];
        for(int j=0; j<= 20; j++){
            ti[j] = 0;
        }
        if (!isPrime(x)) {
            for(int j=0; j < x; j++){
                if(isXExactDivisionByY(x,j) && isPrime(j)){
                    x = exactDivisionYByX(j,x);
                    for(int z=0; getPrimeByIndex(z)==j; z++)
                    {
                        ti[z] = ti[z]++;
                    }
                }
            }
            return ti[x];
        }
        return 0;
    }


    //22
    public int lt(int x) {
        //int[] ti = new int[20];
        int lt =0;
        ti(x);
        for(int j=0; j<=20; j++){
            if(ti[j]!=0) {
                lt = j;
            }
        }
        return lt;
    }


    //23
    public boolean gn(int x){
        boolean gn = false;
        ti(x);
        for(int j = 0; j < lt(x); j++){
            if (ti[j] != 0){
                gn = true;
            }else {
                gn = false;
            }
        }
        return gn;
    }


    //24
    public int[] godel(int x){
        int[] godel = new int[lt(x)];
        ti(x);
        for(int j = 0; j < lt(x); j++){
            godel[j] = ti[j];
        }
        return godel;
    }


    //25
    public int[] godelmul(int[] x,int[] y){
        int[] godelmul = new int[x.length + y.length];
        for(int j = 0; j < x.length; j++){
            godelmul[j] = x[j];
        }
        for(int j = 0; j < y.length; j++){
            godelmul[j + y.length] = y[j];
        }
        return godelmul;
    }


    //26
    public int jingax(int a, int x){
        int b = 0;
        ti(x);
        for(int j=0; j<=20; j++){
            if(ti[j]== a) {
                b++;
            }
        }
        return b;
    }

    //27
    public int cantorxy(int x, int y){
        return (x+y)*(x+y+1)/2+y;
    }

    //28
    public int r(int z){
        int h1,h2,n=0;
        for(int j=0; j<z; z++){
            h1 = j*(j+1)/2;
            h2 = (j+1)*(j+2)/2;
            if(h1<z && h2>z){
                n=j;
                break;
            }
        }

        return z-n*(n+1)/2;
    }

    //29
    public int l(int z){
        int h1,h2,n=0,y=0;
        for(int j=0; j<z; z++){
            h1 = j*(j+1)/2;
            h2 = (j+1)*(j+2)/2;
            if(h1<z && h2>z){
                n=j;
                y=z-n*(n+1)/2;
                break;
            }
        }

        return n-y;
    }


}