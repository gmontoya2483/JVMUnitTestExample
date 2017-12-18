# Create and use Categories

From a given set of test classes, the Categories runner runs only the classes and methods that are annotated with either the category given with the ```@IncludeCategory``` annotation, or a subtype of that category. Either classes or interfaces can be used as categories. Subtyping works, so if you say ```@IncludeCategory(SuperClass.class)```, a test marked ```@Category({SubClass.class})``` will be run.

You can also exclude categories by using the ```@ExcludeCategory``` annotation.


## Define the categories

In order to define the categories you need to create the maker Interfaces to represent each category.


``` java
    package com.montoya.gabriel.android.jvmunittestexample;

    public interface IPerformanceTest {
        //category marker interface
    }

```


```java
    package com.montoya.gabriel.android.jvmunittestexample;

    public interface IRegressionTest {
        //category marker interface
    }

```


## Setting the test Categories

In order to define the test categories you need to define the ```@Category``` annotation, which is an array of classes. The Category could be defined either at class or at method level.

1.  ```@Category``` at Method level.

```java
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
```


2.  ```@Category``` at Class level.

```java
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

```



## Defining the Test Suites

1. Functional Test Suite

```java

    @RunWith(Categories.class)
    @Categories.IncludeCategory(FunctionalTest.class)
    @Suite.SuiteClasses({ExampleCategoryOnClassLevel.class, ExampleCategoryOnMethodLevel.class})

    public class ExampleCategoryFunctionalTestSuite {
    }

```

The following test will be executed:

* ExampleCategoryOnClass -> test_Class_1, test_Class_2
* ExampleCategoryOnMethod -> test_Method_1


2. Performance test Suite

```java
    @RunWith(Categories.class)
    @Categories.IncludeCategory(IPerformanceTest.class)
    @Suite.SuiteClasses({ExampleCategoryOnClassLevel.class, ExampleCategoryOnMethodLevel.class})

    public class ExampleCategoryPerformanceTestSuite {
    }

```

The following test will be executed:

* ExampleCategoryOnClass -> None
* ExampleCategoryOnMethod -> test_Method_2, test_Method_3


3. Regression test Suite

```java
    @RunWith(Categories.class)
    @Categories.IncludeCategory({IRegressionTest.class,FunctionalTest.class})
    @Suite.SuiteClasses({ExampleCategoryOnClassLevel.class, ExampleCategoryOnMethodLevel.class})

    public class ExampleCategoryRegressionTestSuite {
    }

```

The following test will be executed:

* ExampleCategoryOnClass -> test_Class_1, test_Class_2
* ExampleCategoryOnMethod -> test_Method_1, test_Method_3

4. With ExcludeCategory test suite

```java
    @RunWith(Categories.class)
    @Categories.IncludeCategory({IRegressionTest.class,FunctionalTest.class})
    @Categories.ExcludeCategory({IPerformanceTest.class})
    @Suite.SuiteClasses({ExampleCategoryOnClassLevel.class, ExampleCategoryOnMethodLevel.class})

    public class ExampleCategoryWithExcludeTestSuite {
    }
```

The following test will be executed:

* ExampleCategoryOnClass -> test_Class_1, test_Class_2
* ExampleCategoryOnMethod -> test_Method_1

5. Without any Category test Suite

```java
    @RunWith(Categories.class)
    @Suite.SuiteClasses({ExampleCategoryOnClassLevel.class, ExampleCategoryOnMethodLevel.class})

    public class ExampleCategoryWithoutCategoryTestSuite {
    }
```

The following test will be executed:

* ExampleCategoryOnClass -> test_Class_1, test_Class_2
* ExampleCategoryOnMethod -> test_Method_1, test_Method_2, test_Method_3, test_Method_4



