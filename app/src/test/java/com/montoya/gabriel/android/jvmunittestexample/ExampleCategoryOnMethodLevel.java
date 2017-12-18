package com.montoya.gabriel.android.jvmunittestexample;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by montoya on 18.12.2017.
 */

public class ExampleCategoryOnMethodLevel {

    @Category({FunctionalTest.class, IRegressionTest.class})
    @Test
    public void test_Method_1(){
        assertThat("good", anyOf(equalTo("bad"), startsWith("go")));
    }


    @Category({IPerformanceTest.class})
    @Test
    public void test_Method_2(){
        assertTrue("Not true:",1==1);
    }


    @Category({IPerformanceTest.class,IRegressionTest.class})
    @Test
    public void test_Method_3(){
        assertEquals("Not equal:",5,3 + 2);
    }

    @Test
    public void test_Method_4(){
        assertEquals("Not equal:",5,3 + 2);
    }

}
