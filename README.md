# JVM unit Test

The intention of this project is to show how to implement a **local** JVM unit test.


## Set Up the Testing Environment

In your Android Studio project, you must store the source files for local unit tests at ```module-name/src/test/java/```. This directory already exists when you create a new project.
in the current example is on ``` \JVMUnitTestExample\app\src\test\java\com\montoya\gabriel\android\jvmunittestexample```

![Screenshot1](images/android_test_folder.png)
   
   
   

You also need to configure the testing dependencies for your project to use the standard APIs provided by the JUnit 4 framework.  

```gradle  
    dependencies {
        // Required -- JUnit 4 framework
        testCompile 'junit:junit:4.12'
   
    }
```


## Create a Local Unit Test Class

Your local unit test class should be written as a JUnit 4 test class. [JUnit](http://junit.org/junit4/) is the most popular and widely-used unit testing framework for Java. The latest version of this framework, JUnit 4, allows you to write tests in a cleaner and more flexible way than its predecessor versions. Unlike the previous approach to Android unit testing based on JUnit 3, with JUnit 4, you do not need to extend the ```junit.framework.TestCase``` class. You also do not need to prefix your test method name with the ```‘test’``` keyword, or use any classes in the ```junit.framework``` or ```junit.extensions``` package.   

To create a basic JUnit 4 test class, create a Java class that contains one or more test methods. A test method begins with the ```@Test``` annotation and contains the code to exercise and verify a single functionality in the component that you want to test.

The following example shows how you might implement a local unit test class. The test method ```emailValidator_CorrectEmailSimple_ReturnsTrue```  verifies that the ```isValidEmail()``` method in the app under test returns the correct result.  

```java
    import org.junit.Test;
    import java.util.regex.Pattern;
    import static org.junit.Assert.assertFalse;
    import static org.junit.Assert.assertTrue;
    
    public class EmailValidatorTest {
    
        @Test
        public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
            assertThat(EmailValidator.isValidEmail("name@email.com"), is(true));
        }
        ...
    }
```  

To test that components in your app return the expected results, use the [junit.Assert](http://junit.org/junit4/javadoc/latest/org/junit/Assert.html) methods to perform validation checks (or assertions) to compare the state of the component under test against some expected value. To make tests more readable, you can use ```Hamcrest matchers``` (such as the ```is()``` and ```equalTo()``` methods) to match the returned result against the expected result.

## Run Local Unit Test

To run your local unit tests, follow these steps:

1. Be sure your project is synchronized with Gradle by clicking ***Sync Project***  in the toolbar.
2. Run your test in one of the following ways:
    * To run a single test, open the **Project** window, and then right-click a test and click ***Run*** .
    * To test all methods in a class, right-click a class or method in the test file and click ***Run*** .
    * To run all tests in a directory, right-click on the directory and select ***Run tests*** .

The Android Plugin for Gradle compiles the local unit test code located in the default directory (src/test/java/), builds a test app, and executes it locally using the default test runner class. Android Studio then displays the results in the Run window.


## Asserts Examples

See [JUnit Asserts](documentation/JUnit_asserts.md)


## Test runners

When a class is annotated with ```@RunWith``` or extends a class annotated with ```@RunWith```, JUnit will invoke the class it references to run the tests in that class instead of the runner built into JUnit.


* The default runner is ```BlockJUnit4ClassRunner```
* Annotating a class with ```@RunWith(JUnit4.class)``` will always invoke the default JUnit 4 runner in the current version of JUnit, this class aliases the current default JUnit 4 class runner.
* [Test runners](https://github.com/junit-team/junit4/wiki/Test-runners)


### Specialized Runners

#### Suite

* ```Suite``` is a standard runner that allows you to manually build a suite containing tests from many classes.
* Details how to [Create and use Test Suites](documentation/test_suite.md)
* More information at Aggregating tests in Suites page.
* http://junit.org/javadoc/latest/org/junit/runners/Suite.html
* See example: ```ExampleTestSuite``` class

#### Parameterized

* ```Parameterized``` is a standard runner that implements parameterized tests. When running a parameterized test class, instances are created for the cross-product of the test methods and the test data elements.
* Details how to [Create and use Parameterized tests](documentation/parameters_runner.md)
* More information at [Parameterized Tests](https://github.com/junit-team/junit4/wiki/Parameterized-tests) page.
* See examples: ```ExampleParameterizedRunnerWithConstructor```, ```ExampleParameterizedRunnerWithInjection``` and ```ExampleParameterizedRunnerSingle``` classes

#### Categories

* ```Categories``` is a standard runner enabling subsets of tests tagged with certain categories to execute/be excluded from a given test run.
* More information at [Categories](https://github.com/junit-team/junit4/wiki/Categories) and [Mkyong - JUnit - Categories Test](https://www.mkyong.com/unittest/junit-categories-test/) pages.
* Details how to [Create and use Categories](documentation/categories_runner.md)

## References
[Building Local Unit Test](https://developer.android.com/training/testing/unit-testing/local-unit-tests.html)

[JUnit 4](http://junit.org/junit4/)

[JUnit 4 Cookbook](http://junit.org/junit4/cookbook.html)

[JUnit 4 Frequently Asked Questins](http://junit.org/junit4/faq.html)


[Vogella Mockito Article](http://www.vogella.com/tutorials/Mockito/article.html)


