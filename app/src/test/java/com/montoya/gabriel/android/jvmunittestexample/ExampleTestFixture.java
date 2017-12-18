package com.montoya.gabriel.android.jvmunittestexample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by montoya on 18.12.2017.
 */

public class ExampleTestFixture {

    @Before
    public void testSetup(){
        System.out.println("Before test -> Setup");

    }

    @After
    public void testTearDown() {
        System.out.println("After test -> TearDown");
    }

    @BeforeClass
    public static void classSetup(){
        System.out.println("Before Class -> Setup");

    }

    @AfterClass
    public static void classTearDown(){
        System.out.println("After Class -> TearDown");

    }

    @Test
    public void test_1(){
        System.out.println("Test_1 -> Started");
        assertEquals("failure - strings are not equal", "text", "text");
        System.out.println("Test_1 -> Finished");
    }

    @Test
    public void test_2(){
        System.out.println("Test_2 -> Started");
        assertEquals("failure - strings are not equal", "text", "text");
        System.out.println("Test_2 -> Finished");
    }

    @Test
    public void test_3(){
        System.out.println("Test_3 -> Started");
        assertEquals("failure - strings are not equal", "text", "text");
        System.out.println("Test_3 -> Finished");
    }
}
