package com.montoya.gabriel.android.jvmunittestexample;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by montoya on 18.12.2017.
 */

public class ExampleTimeoutParameter {

    @Test (timeout = 100)
    public void test_1(){
        System.out.println("test_1 -> Started");
        assertEquals("failure - strings are not equal", "text", "text");
        System.out.println("test_1 -> Finished");
    }


    @Test (timeout = 100)
    public void test_2()  {
        System.out.println("test_2 -> Started");

        try {
            TimeUnit.SECONDS.sleep(100); // sleep for 100 seconds
            assertEquals("failure - strings are not equal", "text", "text");
            System.out.println("test_2 -> Finished");
        } catch (InterruptedException e) {
            System.out.println("test_2 -> timeout");
        }

    }

    @Test (timeout = 100)
    public void test_3(){
        System.out.println("test_3 -> Started");
        assertEquals("failure - strings are not equal", "text", "text");
        System.out.println("test_3 -> Finished");
    }

}
