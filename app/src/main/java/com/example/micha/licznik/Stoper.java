package com.example.micha.licznik;



public class Stoper {
    int number1;
    int number2;
    int number3;
    int number4;
    long start;
    long time;

    public Stoper(int a, int b, int c, int d) {

        number1 = a;
        number2 = b;
        number3 = c;
        number4 = d;

        time = number4 * 1000 + number3 * 10 * 1000 + number2 * 60 * 1000 + number1 * 10 * 60 * 1000;
        start = System.currentTimeMillis();
    }

    public String getTime() {
        long now = System.currentTimeMillis();
        long value = time - (now - start);
        if (value <= 0)
            return "0000";
        long n1 = value / (10 * 60 * 1000);
        value-=n1*10 * 60 * 1000;
        long n2 = value / (60 * 1000);
        value-=n2*60 * 1000;
        long n3 = value / (10 * 1000);
        value-=n3*10 * 1000;
        long n4 = value / (1000);
        return "" + n1 + n2 + n3 + n4;

    }
}