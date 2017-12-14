# JUnit Asserts

JUnit provides overloaded assertion methods for all primitive types and Objects and arrays (of primitives or Objects). The parameter order is expected value followed by actual value. Optionally the first parameter can be a String message that is output on failure. There is a slightly different assertion, ```assertThat``` that has parameters of the optional failure message, the actual value, and a ```Matcher``` object. Note that expected and actual are reversed compared to the other assert methods.  


## Examples

See and execute the ```ExampleAssertTest``` class


### assertArrayEquals()

It verifies that 2 arrays are exactly the same. In the example below we compared 2 arrays of string however it applies to kind of arrays.


```java 
        @Test
        public void testAssertByteArrayEquals() {
            byte[] expected = "trial".getBytes();
            byte[] actual = "trial".getBytes();
    
            assertArrayEquals("failure - byte arrays not same", expected, actual);
        }
```
```java
        @Test
        public void testAssertArrayEquals() {
            String [] expected = {"Hola","Chau","Bla bla"};
            String [] actual = {"Hola","Chau","Bla bla"};
    
            assertArrayEquals("failure - Arrays not same", expected, actual);
        }
``` 

## assertEquals() and assertNotEquals()  

```java
    @Test
    public void testAssertEquals(){
        assertEquals("failure - strings are not equal", "text", "text");
    }
```
   
```java
    @Test 
    public void testAssertNotEquals(){
        assertNotEquals("failure - integers are equal",3,2);        
    }
```

## assertFalse() and assertTrue()  

```java
        @Test
        public void testAssertFalse() {
            assertFalse("failure - should be false", false);
        }
```

```java
        @Test
        public void testAssertTrue() {
            assertTrue("failure - should be true", true);
        }
```

## assertNull() and assertNotNull()

```java
    @Test
    public void testAssertNotNull() {
        assertNotNull("should not be null", new Object());
    }
```

```java
    @Test
    public void testAssertNull() {
        assertNull("should be null", null);
    }
```

## assertSame() and assertNotSame()

```java
     @Test
        public void testAssertSame() {
            Integer aNumber = Integer.valueOf(768);
            assertSame("should be same", aNumber,aNumber);
            assertNotSame("shouldn´t be same",aNumber,Integer.valueOf(763));
        }
```


## assertThat()


```java
    @Test
    public void testAssertThatIs(){

        assertThat("This is the reason", 3, is(3));
        assertThat("This is the reason", 3, not(is(2)));
        assertThat(3, not(is(2)));

    }
```

```java
// JUnit Matchers assertThat
    @Test
    public void testAssertThatBothContainsString() {
        assertThat("albumen", both(containsString("a")).and(containsString("b")));
        assertThat("albumen", either(containsString("a")).or(containsString("h")));

    }
```

```java
    @Test
    public void testAssertThatHasItems() {
        assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
    }


    @Test
    public void testAssertThatEveryItemContainsString() {
        assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), everyItem(containsString("n")));
    }
```

```java
    @Test
    public void testAssertThathasItemContainsStringAet() {
        assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), hasItems(containsString("et")));
    }
```

```java
    // Core Hamcrest Matchers with assertThat
    @Test
    public void testAssertThatHamcrestCoreMatchers() {
        assertThat("good", allOf(equalTo("good"), startsWith("good")));
        assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
        assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
        assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(), not(sameInstance(new Object())));
    }
```
```java
    @Test
    public void testAssertThatIs(){

        assertThat("This is the reason", 3, is(3));
        assertThat("This is the reason", 3, not(is(2)));
        assertThat(3, not(is(2)));

    }
```

 

