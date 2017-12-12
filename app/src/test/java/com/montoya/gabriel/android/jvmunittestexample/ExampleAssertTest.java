package com.montoya.gabriel.android.jvmunittestexample;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Created by montoya on 12.12.2017.
 */

@RunWith(JUnit4.class)
public class ExampleAssertTest {

    @Test
    public void testAssertByteArrayEquals() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();

        assertArrayEquals("failure - byte arrays not same", expected, actual);
    }


    @Test
    public void testAssertArrayEquals() {
        String [] expected = {"Hola","Chau","Bla bla"};
        String [] actual = {"Hola","Chau","Bla bla"};

        assertArrayEquals("failure - byte arrays not same", expected, actual);
    }


    @Test
    public void testAssertEquals(){
        assertEquals("failure - strings are not equal", "text", "text");
    }


    @Test
    public void testAssertFalse() {
        assertFalse("failure - should be false", false);
    }

    @Test
    public void testAssertTrue() {
        assertTrue("failure - should be true", true);
    }


    @Test
    public void testAssertNotNull() {
        assertNotNull("should not be null", new Object());
    }

    @Test
    public void testAssertNull() {
        assertNull("should be null", null);
    }

    @Test
    public void testAssertSame() {
        Integer aNumber = Integer.valueOf(768);
        assertSame("should be same", aNumber, aNumber);
    }


    // JUnit Matchers assertThat
    @Test
    public void testAssertThatBothContainsString() {
        assertThat("albumen", both(containsString("a")).and(containsString("b")));
        assertThat("albumen", either(containsString("a")).or(containsString("h")));

    }


    @Test
    public void testAssertThatHasItems() {
        assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
    }


    @Test
    public void testAssertThatEveryItemContainsString() {
        assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), everyItem(containsString("n")));
    }


    @Test
    public void testAssertThathasItemContainsStringAet() {
        assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), hasItems(containsString("et")));
    }


    // Core Hamcrest Matchers with assertThat
    @Test
    public void testAssertThatHamcrestCoreMatchers() {
        assertThat("good", allOf(equalTo("good"), startsWith("good")));
        assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
        assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
        assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(), not(sameInstance(new Object())));
    }



}
