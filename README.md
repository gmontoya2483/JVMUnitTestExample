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






## References
[Building Local Unit Test](https://developer.android.com/training/testing/unit-testing/local-unit-tests.html)
