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

* See [JUnit Asserts](documentation/JUnit_asserts.md)
* See ```ExampleAssertTest```


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
* See examples: ```FunctionalTest```, ```IperformanceTest```, ```IRegressionTest```, ```ExampleCategoryOnClassLevel```, ```ExampleCategoryOnMethodLevel```, ```ExampleCategoryFunctionalTestSuite```, ```ExampleCategoryPerformanceTestSuite```, ```ExampleCategoryRegressionTestSuite```, ```ExampleCategoryWithExcludeTestSuite```, and ```ExampleCategoryWithoutCategoryTestSuite``` classes.

### Third Party Runners

#### MockitoJUnitRunner

By default, the Android Plug-in for Gradle executes your local unit tests against a modified version of the android.jar library, which does not contain any actual code. Instead, method calls to Android classes from your unit test throw an exception. This is to make sure you test only your code and do not depend on any particular behavior of the Android platform (that you have not explicitly mocked).

You can use a mocking framework to stub out external dependencies in your code, to easily test that your component interacts with a dependency in an expected way. By substituting Android dependencies with mock objects, you can isolate your unit test from the rest of the Android system while verifying that the correct methods in those dependencies are called. The Mockito mocking framework for Java (version 1.9.5 and higher) offers compatibility with Android unit testing. With Mockito, you can configure mock objects to return some specific value when invoked.

* Details how to [Create and use Mocked tests](documentation/mockito_runner.md)
* See example ```ExampleMockitotest``` class.


## Test Execution order

* See [Test execution order](documentation/execution_order.md)
* See ```ExampleExecutionOrderNameAscending``` class

## Ignoring tests

If for some reason, you don't want a test to fail, you just want it ignored, you temporarily disable a test.

To ignore a test in JUnit you can either comment a method, or delete the ```@Test``` annotation; but the test runner will not report such a test. Alternatively, you can add the ```@Ignore``` annotation in front or after ```@Test```. Test runners will report the number of ignored tests, along with the number of tests that ran and the number of tests that failed.

Note that ```@Ignore``` takes an optional parameter (a String) if you want to record a reason why a test is being ignored.

### Example

```java
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
```

```
    "C:\Program Files\Android\Android Studio\jre\bin\java" -Didea.test.cyclic.buffer.size=1048576 -Didea.launcher.port=63204 "-Didea.launcher.bin.path=C:\Program Files\Android\Android Studio\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Android\Android Studio\lib\idea_rt.jar;C:\Program Files\Android\Android Studio\plugins\junit\lib\junit-rt.jar;C:\Users\montoya\AppData\Local\Android\sdk\platforms\android-26\data\res;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\classes\test\debug;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\classes\debug;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-media-compat-26.1.0.aar\0695d2bc707728ee73235d4ce336341b\res;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-media-compat-26.1.0.aar\0695d2bc707728ee73235d4ce336341b\jars\classes.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\junit\junit\4.12\2973d150c0dc1fefe998f834810d68f278ea58ec\junit-4.12.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\android.arch.lifecycle\common\1.0.0\e414a4cb28434e25c4f6aa71426eb20cf4874ae9\common-1.0.0.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-fragment-26.1.0.aar\6e241a41abdc0163eea5d709d9364d04\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-vector-drawable-26.1.0.aar\e4208ad05c34db784d4bbc91139a6a28\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\runtime-1.0.0.aar\8152b201a40c5a111ea26af2d1fbb9cc\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\appcompat-v7-26.1.0.aar\3129eac2faa759c2479292453cf81388\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\appcompat-v7-26.1.0.aar\3129eac2faa759c2479292453cf81388\res;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\com.android.support\support-annotations\26.1.0\814258103cf26a15fcc26ecce35f5b7d24b73f8\support-annotations-26.1.0.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\org.mockito\mockito-core\1.10.19\e8546f5bef4e061d8dd73895b4e8f40e3fe6effe\mockito-core-1.10.19.jar;C:\Users\montoya\AppData\Local\Android\sdk\extras\m2repository\com\android\support\constraint\constraint-layout-solver\1.0.2\constraint-layout-solver-1.0.2.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-core-utils-26.1.0.aar\18f63ffde00ae58ca917b3cc5f39fb5c\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\constraint-layout-1.0.2.aar\05387501d225c7fafd9aaaac3b0d7a81\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\constraint-layout-1.0.2.aar\05387501d225c7fafd9aaaac3b0d7a81\res;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-core-ui-26.1.0.aar\d751547c0e7be767d87a8708981d6ac0\jars\classes.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\org.objenesis\objenesis\2.1\87c0ea803b69252868d09308b4618f766f135a96\objenesis-2.1.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\org.hamcrest\hamcrest-core\1.3\42a25dc3219429f0e5d060061f71acb49bf010a0\hamcrest-core-1.3.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-compat-26.1.0.aar\c4dfe8f23b7307e10914dc373ac0c5b8\res;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-compat-26.1.0.aar\c4dfe8f23b7307e10914dc373ac0c5b8\jars\classes.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\android.arch.core\common\1.0.0\a2d487452376193fc8c103dd2b9bd5f2b1b44563\common-1.0.0.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-v4-26.1.0.aar\e719aedcf863e623e2ec13b417d48b45\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\animated-vector-drawable-26.1.0.aar\9c3c2d758a3a20360e1d0bd2fb13ecd8\jars\classes.jar;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\sourceFolderJavaResources\test\debug;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\sourceFolderJavaResources\debug;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\generated\mockable-android-26.v3.jar" com.intellij.rt.execution.application.AppMainV2 com.intellij.rt.execution.junit.JUnitStarter -ideVersion5 com.montoya.gabriel.android.jvmunittestexample.ExampleIgnoreTest
    test_1

    Test 2 was ignored
    test_3

    Process finished with exit code 0
```


* See ```ExampleIgnoreTest``` class


## Timeout for tests

* See [Test execution order](documentation/execution_order.md)
* See ```ExampleTimeoutParameter``` and ```ExampleTimeoutRule```classes




## References
[Building Local Unit Test](https://developer.android.com/training/testing/unit-testing/local-unit-tests.html)

[JUnit 4](http://junit.org/junit4/)

[JUnit 4 Cookbook](http://junit.org/junit4/cookbook.html)

[JUnit 4 Frequently Asked Questins](http://junit.org/junit4/faq.html)


[Vogella Mockito Article](http://www.vogella.com/tutorials/Mockito/article.html)


