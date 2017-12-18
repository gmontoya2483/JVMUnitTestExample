package com.montoya.gabriel.android.jvmunittestexample;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

/**
 * Created by montoya on 18.12.2017.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExampleExecutionOrderNameAscending {

    @Test
    public void test_orderName_D(){
        System.out.println("test_orderName_D");
        assertEquals("failure - strings are not equal", "text", "text");
    }

    @Test
    public void test_orderName_A(){
        System.out.println("test_orderName_A");
        assertEquals("failure - strings are not equal", "text", "text");
    }


    @Test
    public void test_orderName_C(){
        System.out.println("test_orderName_C");
        assertEquals("failure - strings are not equal", "text", "text");
    }

    @Test
    public void test_orderName_B(){
        System.out.println("test_orderName_B");
        assertEquals("failure - strings are not equal", "text", "text");
    }

}
