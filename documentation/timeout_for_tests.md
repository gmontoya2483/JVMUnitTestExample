# Timeout for tests

Tests that 'runaway' or take too long, can be automatically failed. There are two options for implementing this behavior:

## Timeout parameter on @Test Annotation (applies to test method)

You can optionally specify timeout in milliseconds to cause a test method to fail if it takes longer than that number of milliseconds. If the time limit is exceeded, then the failure is triggered by an ```Exception``` being thrown.

This is implemented by running the test method in a separate thread. If the test runs longer than the allotted timeout, the test will fail and JUnit will interrupt the thread running the test. If a test times out while executing an interruptible operation, the thread running the test will exit (if the test is in an infinite loop, the thread running the test will run forever, while other tests continue to execute).

### Example

```java
    public class ExampleTimeoutParameter {

        @Test (timeout = 100)
        public void test_1(){
            System.out.println("test_1 -> Started");
            assertEquals("failure - strings are not equal", "text", "text");
            System.out.println("test_1 -> Finished");
        }


        @Test (timeout = 100)
        public void test_2()  {
            System.out.println("test_2 -> Started");

            try {
                TimeUnit.SECONDS.sleep(100); // sleep for 100 seconds
                assertEquals("failure - strings are not equal", "text", "text");
                System.out.println("test_2 -> Finished");
            } catch (InterruptedException e) {
                System.out.println("test_2 -> timeout");
            }

        }

        @Test (timeout = 100)
        public void test_3(){
            System.out.println("test_3 -> Started");
            assertEquals("failure - strings are not equal", "text", "text");
            System.out.println("test_3 -> Finished");
        }

    }
```

```
    "C:\Program Files\Android\Android Studio\jre\bin\java" -Didea.test.cyclic.buffer.size=1048576 -Didea.launcher.port=63334 "-Didea.launcher.bin.path=C:\Program Files\Android\Android Studio\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Android\Android Studio\lib\idea_rt.jar;C:\Program Files\Android\Android Studio\plugins\junit\lib\junit-rt.jar;C:\Users\montoya\AppData\Local\Android\sdk\platforms\android-26\data\res;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\classes\test\debug;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\classes\debug;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-media-compat-26.1.0.aar\0695d2bc707728ee73235d4ce336341b\res;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-media-compat-26.1.0.aar\0695d2bc707728ee73235d4ce336341b\jars\classes.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\junit\junit\4.12\2973d150c0dc1fefe998f834810d68f278ea58ec\junit-4.12.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\android.arch.lifecycle\common\1.0.0\e414a4cb28434e25c4f6aa71426eb20cf4874ae9\common-1.0.0.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-fragment-26.1.0.aar\6e241a41abdc0163eea5d709d9364d04\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-vector-drawable-26.1.0.aar\e4208ad05c34db784d4bbc91139a6a28\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\runtime-1.0.0.aar\8152b201a40c5a111ea26af2d1fbb9cc\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\appcompat-v7-26.1.0.aar\3129eac2faa759c2479292453cf81388\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\appcompat-v7-26.1.0.aar\3129eac2faa759c2479292453cf81388\res;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\com.android.support\support-annotations\26.1.0\814258103cf26a15fcc26ecce35f5b7d24b73f8\support-annotations-26.1.0.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\org.mockito\mockito-core\1.10.19\e8546f5bef4e061d8dd73895b4e8f40e3fe6effe\mockito-core-1.10.19.jar;C:\Users\montoya\AppData\Local\Android\sdk\extras\m2repository\com\android\support\constraint\constraint-layout-solver\1.0.2\constraint-layout-solver-1.0.2.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-core-utils-26.1.0.aar\18f63ffde00ae58ca917b3cc5f39fb5c\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\constraint-layout-1.0.2.aar\05387501d225c7fafd9aaaac3b0d7a81\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\constraint-layout-1.0.2.aar\05387501d225c7fafd9aaaac3b0d7a81\res;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-core-ui-26.1.0.aar\d751547c0e7be767d87a8708981d6ac0\jars\classes.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\org.objenesis\objenesis\2.1\87c0ea803b69252868d09308b4618f766f135a96\objenesis-2.1.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\org.hamcrest\hamcrest-core\1.3\42a25dc3219429f0e5d060061f71acb49bf010a0\hamcrest-core-1.3.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-compat-26.1.0.aar\c4dfe8f23b7307e10914dc373ac0c5b8\res;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-compat-26.1.0.aar\c4dfe8f23b7307e10914dc373ac0c5b8\jars\classes.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\android.arch.core\common\1.0.0\a2d487452376193fc8c103dd2b9bd5f2b1b44563\common-1.0.0.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-v4-26.1.0.aar\e719aedcf863e623e2ec13b417d48b45\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\animated-vector-drawable-26.1.0.aar\9c3c2d758a3a20360e1d0bd2fb13ecd8\jars\classes.jar;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\sourceFolderJavaResources\test\debug;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\sourceFolderJavaResources\debug;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\generated\mockable-android-26.v3.jar" com.intellij.rt.execution.application.AppMainV2 com.intellij.rt.execution.junit.JUnitStarter -ideVersion5 com.montoya.gabriel.android.jvmunittestexample.ExampleTimeoutParameter
    test_1 -> Started
    test_1 -> Finished
    test_2 -> Started
    test_2 -> timeout

    org.junit.runners.model.TestTimedOutException: test timed out after 100 milliseconds

    	at java.lang.Thread.sleep(Native Method)
    	at java.lang.Thread.sleep(Thread.java:340)
    	at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
    	at com.montoya.gabriel.android.jvmunittestexample.ExampleTimeoutParameter.test_2(ExampleTimeoutParameter.java:29)
    	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    	at java.lang.reflect.Method.invoke(Method.java:498)
    	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
    	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
    	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
    	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
    	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:298)
    	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:292)
    	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
    	at java.lang.Thread.run(Thread.java:745)

    test_3 -> Started
    test_3 -> Finished

    Process finished with exit code -1
```


## Timeout Rule (applies to all test cases in the test class)

The Timeout Rule applies the same timeout to all test methods in a class, and will currently execute in addition to any ```timeout``` specified by the timeout parameter on an individual Test annotation.

The timeout specified in the Timeout rule applies to the entire test fixture, including any ```@Before``` or ```@After``` methods. If the test method is in an infinite loop (or is otherwise not responsive to interrupts) then ```@After``` methods will not be called.

### Example

```java
    public class ExampleTimeoutRule {

        @Rule
        public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per method tested


        @Test
        public void test_1(){
            System.out.println("test_1 -> Started");
            assertEquals("failure - strings are not equal", "text", "text");
            System.out.println("test_1 -> Finished");
        }

        @Test
        public void test_2() throws InterruptedException {
            System.out.println("test_2 -> Started");
            TimeUnit.SECONDS.sleep(20); // sleep for 100 seconds
            assertEquals("failure - strings are not equal", "text", "text");
            System.out.println("test_2 -> Finished");
        }

        @Test
        public void test_3() {
            System.out.println("test_3 -> Started");
            assertEquals("failure - strings are not equal", "text", "text");
            System.out.println("test_3 -> Finished");
        }
    }
```

```
    "C:\Program Files\Android\Android Studio\jre\bin\java" -Didea.test.cyclic.buffer.size=1048576 -Didea.launcher.port=63493 "-Didea.launcher.bin.path=C:\Program Files\Android\Android Studio\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Android\Android Studio\lib\idea_rt.jar;C:\Program Files\Android\Android Studio\plugins\junit\lib\junit-rt.jar;C:\Users\montoya\AppData\Local\Android\sdk\platforms\android-26\data\res;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\classes\test\debug;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\classes\debug;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-media-compat-26.1.0.aar\0695d2bc707728ee73235d4ce336341b\res;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-media-compat-26.1.0.aar\0695d2bc707728ee73235d4ce336341b\jars\classes.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\junit\junit\4.12\2973d150c0dc1fefe998f834810d68f278ea58ec\junit-4.12.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\android.arch.lifecycle\common\1.0.0\e414a4cb28434e25c4f6aa71426eb20cf4874ae9\common-1.0.0.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-fragment-26.1.0.aar\6e241a41abdc0163eea5d709d9364d04\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-vector-drawable-26.1.0.aar\e4208ad05c34db784d4bbc91139a6a28\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\runtime-1.0.0.aar\8152b201a40c5a111ea26af2d1fbb9cc\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\appcompat-v7-26.1.0.aar\3129eac2faa759c2479292453cf81388\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\appcompat-v7-26.1.0.aar\3129eac2faa759c2479292453cf81388\res;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\com.android.support\support-annotations\26.1.0\814258103cf26a15fcc26ecce35f5b7d24b73f8\support-annotations-26.1.0.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\org.mockito\mockito-core\1.10.19\e8546f5bef4e061d8dd73895b4e8f40e3fe6effe\mockito-core-1.10.19.jar;C:\Users\montoya\AppData\Local\Android\sdk\extras\m2repository\com\android\support\constraint\constraint-layout-solver\1.0.2\constraint-layout-solver-1.0.2.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-core-utils-26.1.0.aar\18f63ffde00ae58ca917b3cc5f39fb5c\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\constraint-layout-1.0.2.aar\05387501d225c7fafd9aaaac3b0d7a81\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\constraint-layout-1.0.2.aar\05387501d225c7fafd9aaaac3b0d7a81\res;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-core-ui-26.1.0.aar\d751547c0e7be767d87a8708981d6ac0\jars\classes.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\org.objenesis\objenesis\2.1\87c0ea803b69252868d09308b4618f766f135a96\objenesis-2.1.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\org.hamcrest\hamcrest-core\1.3\42a25dc3219429f0e5d060061f71acb49bf010a0\hamcrest-core-1.3.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-compat-26.1.0.aar\c4dfe8f23b7307e10914dc373ac0c5b8\res;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-compat-26.1.0.aar\c4dfe8f23b7307e10914dc373ac0c5b8\jars\classes.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\android.arch.core\common\1.0.0\a2d487452376193fc8c103dd2b9bd5f2b1b44563\common-1.0.0.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-v4-26.1.0.aar\e719aedcf863e623e2ec13b417d48b45\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\animated-vector-drawable-26.1.0.aar\9c3c2d758a3a20360e1d0bd2fb13ecd8\jars\classes.jar;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\sourceFolderJavaResources\test\debug;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\sourceFolderJavaResources\debug;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\generated\mockable-android-26.v3.jar" com.intellij.rt.execution.application.AppMainV2 com.intellij.rt.execution.junit.JUnitStarter -ideVersion5 com.montoya.gabriel.android.jvmunittestexample.ExampleTimeoutRule
    test_1 -> Started
    test_1 -> Finished
    test_2 -> Started

    org.junit.runners.model.TestTimedOutException: test timed out after 10 seconds

    	at java.lang.Thread.sleep(Native Method)
    	at java.lang.Thread.sleep(Thread.java:340)
    	at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
    	at com.montoya.gabriel.android.jvmunittestexample.ExampleTimeoutRule.test_2(ExampleTimeoutRule.java:31)
    	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    	at java.lang.reflect.Method.invoke(Method.java:498)
    	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
    	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
    	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
    	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
    	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:298)
    	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:292)
    	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
    	at java.lang.Thread.run(Thread.java:745)

    test_3 -> Started
    test_3 -> Finished

    Process finished with exit code -1


```