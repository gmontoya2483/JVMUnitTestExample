package com.montoya.gabriel.android.jvmunittestexample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by montoya on 18.12.2017.
 */

public class ExampleTimeoutRule {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per method tested


    @Test
    public void test_1(){
        System.out.println("test_1 -> Started");
        assertEquals("failure - strings are not equal", "text", "text");
        System.out.println("test_1 -> Finished");
    }

    @Test
    public void test_2() throws InterruptedException {
        System.out.println("test_2 -> Started");
        TimeUnit.SECONDS.sleep(20); // sleep for 100 seconds
        assertEquals("failure - strings are not equal", "text", "text");
        System.out.println("test_2 -> Finished");
    }

    @Test
    public void test_3() {
        System.out.println("test_3 -> Started");
        assertEquals("failure - strings are not equal", "text", "text");
        System.out.println("test_3 -> Finished");
    }
}
