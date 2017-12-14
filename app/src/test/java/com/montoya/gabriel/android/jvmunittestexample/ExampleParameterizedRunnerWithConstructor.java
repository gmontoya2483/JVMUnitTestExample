package com.montoya.gabriel.android.jvmunittestexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by montoya on 14.12.2017.
 */



@RunWith(Parameterized.class)
public class ExampleParameterizedRunnerWithConstructor {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new Suma(2,2), 4 }, { new Suma(3,7), 10 }
        });
    }

    private Suma fInput;
    private int fExpected;

    public ExampleParameterizedRunnerWithConstructor(Suma input, int expected) {
        fInput= input;
        fExpected= expected;
    }



    @Test
    public void testGetSuma(){
        assertEquals("The expected result is not the correct: ",fExpected,fInput.getSuma());
    }

    @Test
    public void testGetValor1(){
        assertEquals("The valor 1 is not correct: ",fExpected - fInput.getValor2(),fInput.getValor1());
    }

    @Test
    public void testGetValor2(){
        assertEquals("The valor 2 is not correct: ",fExpected - fInput.getValor1(),fInput.getValor2());
    }













}
