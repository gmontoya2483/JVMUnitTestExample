# Create a Test Suite

Using ```Suite``` as a runner allows you to manually build a suite containing tests from many classes. When you run this class, it will run all the tests in all the suite classes.

The class below is a placeholder for the suite annotations, no other implementation is required. Note the ```@RunWith``` annotation, which specifies that the JUnit 4 test runner to use is ```org.junit.runners.Suite``` for running this particular test class. This works in conjunction with the ```@Suite.SuiteClasses``` annotation, which tells the Suite runner which test classes to include in this suite and in which order.  

```java
    import org.junit.runner.RunWith;
    import org.junit.runners.Suite;
    
    /**
     * Created by montoya on 14.12.2017.
     */
    
    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            ExampleAssertTest.class,
            ExampleUnitTest.class})
    
    
    public class ExampleTestSuite {
    
        // the class remains empty,
        // used only as a holder for the above annotations
    
    }
```
