# Create and use Parameterized tests

The use of the Parameterized runners allows to enter a set of inputs to be tested. During the execution, the program will iterate throw all the values and it will be return a result for each iteration.

In order to define a parameterized runner, the annotation ```@RunWith``` must be set to ```Parameterized.class```, the ```@Parameters``` annotation should define a Collection of objects as it is defined below:


```java
    import org.junit.runners.Parameterized;
    import org.junit.runners.Parameterized.Parameters;

    @RunWith(Parameterized.class)
    public class FibonacciTest {
        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                     { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
               });
        }
```

Or

```java
@Parameters
public static Iterable<? extends Object> data() {
    return Arrays.asList("first test", "second test");
}
```


```java
@Parameters
public static Object[] data() {
    return new Object[] { "first test", "second test" };
}
```


## Using the Constructor to set the parameters


```java
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
```


In this example, we are providing 2 objects to the collection and instance of ```Suma.class``` and an ```Integer```. The constructor receives two parameters, a Suma object and an int and it set the values of the member variables. Finally the test make use of the member variables to evaluate the asserts.



```java
    public class Suma {

        private int mValor1;
        private int mValor2;

        public Suma(int valor1, int valor2) {
            this.mValor1 = valor1;
            this.mValor2 = valor2;
        }

        public int getSuma(){
            return mValor1 + mValor2;
        }

        public int getValor1(){
            return getSuma()-mValor2;
        }

        public int getValor2(){
            return getSuma()-mValor1;
        }

    }
```

See the ```ExampleParameterizedRunnerWithConstructor``` class example.


## Parameters injected with the @Parameter notation

It is also possible to inject data values directly into fields without needing a constructor using the ```@Parameter``` annotation, like so:

```java
@RunWith(Parameterized.class)
public class ExampleParameterizedRunnerWithInjection {

    @Parameters (name = "{index}: String \"{0}\" contains \"{1}\"")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Hello World", "ello" }, { "Hello JUnit", "Unit" }
        });
    }

    @Parameter // first data value (0) is default
    public String fInput;   /* NOT private */

    @Parameter(1)
    public String fSubString; /* NOT private */

    @Test
    public void StringContains(){
        assertThat("The substring is not contained in the string",fInput, containsString(fSubString));
    }
}
```

See the ```ExampleParameterizedRunnerWithInjection``` class example

## Single parameter

If your test needs a single parameter only, you don't have to wrap it with an array. Instead you can provide an Iterable or an array of objects.

```java

@RunWith(Parameterized.class)
public class ExampleParameterizedRunnerSingle {

    @Parameters (name = "{index}: String \"{0}\" hast the Substring \"test\"")
    public static Object[] data() {
        return new Object[] { "first test", "second test" };
    }

    @Parameter // first data value (0) is default
    public String fInput;


    @Test
    public void StringContains(){
        assertThat("The substring is not contained in the string",fInput, containsString("test"));
    }

}
```

See the ```ExampleParameterizedRunnerSingle``` class example

## Identify Individual test cases
In order to easily identify the individual test cases in a Parameterized test, you may provide a name using the ```@Parameters``` annotation. This name is allowed to contain placeholders that are replaced at runtime:

* {index}: the current parameter index
* {0}, {1}, …: the first, second, and so on, parameter value. NOTE: single quotes ' should be escaped as two single quotes ''.

```java
    @Parameters (name = "{index}: String \"{0}\" hast the Substring \"test\"")
        public static Object[] data() {
            return new Object[] { "first test", "second test" };
        }
```

```java
    @Parameters (name = "{index}: String \"{0}\" contains \"{1}\"")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { "Hello World", "ello" }, { "Hello JUnit", "Unit" }
            });
        }
```

See both ```ExampleParameterizedRunnerSingle``` and  ```ExampleParameterizedRunnerWithInjection```class examples

