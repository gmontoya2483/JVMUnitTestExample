package com.montoya.gabriel.android.jvmunittestexample;


import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@Category({IRegressionTest.class, FunctionalTest.class})
public class ExampleCategoryOnClassLevel {


    @Test
    public void test_Class_1() {
        assertThat(1 == 1, is(true));
    }


    @Test
    public void test_Class_2() {
        assertThat(2 == 1, is(false));
    }

}
