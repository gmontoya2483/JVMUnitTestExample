package com.montoya.gabriel.android.jvmunittestexample;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by montoya on 18.12.2017.
 */

public class ExampleIgnoreTest {

    @Test
    public void test_1(){
        System.out.println("test_1");
        assertEquals("failure - strings are not equal", "text", "text");
    }

    @Ignore("Test 2 was ignored")
    @Test
    public void test_2(){
        System.out.println("test_2");
        assertEquals("failure - strings are not equal", "text", "text");
    }

    @Test
    public void test_3(){
        System.out.println("test_3");
        assertEquals("failure - strings are not equal", "text", "text");
    }
}
