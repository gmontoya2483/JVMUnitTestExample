package com.montoya.gabriel.android.jvmunittestexample;

/**
 * Created by montoya on 14.12.2017.
 */

public class Suma {

    private int mValor1;
    private int mValor2;

    public Suma(int valor1, int valor2) {
        this.mValor1 = valor1;
        this.mValor2 = valor2;
    }

    public int getSuma(){
        return mValor1 + mValor2;
    }

    public int getValor1(){
        return getSuma()-mValor2;
    }

    public int getValor2(){
        return getSuma()-mValor1;
    }

}
