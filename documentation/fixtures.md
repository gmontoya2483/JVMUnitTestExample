# Test fixtures

A test fixture is a fixed state of a set of objects used as a baseline for running tests. The purpose of a test fixture is to ensure that there is a well known and fixed environment in which tests are run so that results are repeatable. Examples of fixtures:

* Preparation of input data and setup/creation of fake or mock objects
* Loading a database with a specific, known set of data
* Copying a specific known set of files creating a test fixture will create a set of objects initialized to certain states.

There are four fixture annotations: two for class-level fixtures and two for method-level ones. At the class level, you have ```@BeforeClass``` and ```@AfterClass```, and at the method (or test) level, you have ```@Before``` and ```@After```.

* ```@Before```: is executed before the execution of each ```@Test```
* ```@After```: is executed after the execution of each ```@Test```
* ```@BeforeClass```: is executed before the execution of all the ```@Test```
* ```@AfterClass```: is executed after the execution of all the ```@Test```

**NOTE:** ```@BeforeClass``` and ```@AfterClass``` methods have to be defined as ```static```


## Example

```java
    public class ExampleTestFixture {

        @Before
        public void testSetup(){
            System.out.println("Before test -> Setup");

        }

        @After
        public void testTearDown() {
            System.out.println("After test -> TearDown");
        }

        @BeforeClass
        public static void classSetup(){
            System.out.println("Before Class -> Setup");

        }

        @AfterClass
        public static void classTearDown(){
            System.out.println("After Class -> TearDown");

        }

        @Test
        public void test_1(){
            System.out.println("Test_1 -> Started");
            assertEquals("failure - strings are not equal", "text", "text");
            System.out.println("Test_1 -> Finished");
        }

        @Test
        public void test_2(){
            System.out.println("Test_2 -> Started");
            assertEquals("failure - strings are not equal", "text", "text");
            System.out.println("Test_2 -> Finished");
        }

        @Test
        public void test_3(){
            System.out.println("Test_3 -> Started");
            assertEquals("failure - strings are not equal", "text", "text");
            System.out.println("Test_3 -> Finished");
        }
    }
```

```
    "C:\Program Files\Android\Android Studio\jre\bin\java" -Didea.test.cyclic.buffer.size=1048576 -Didea.launcher.port=63875 "-Didea.launcher.bin.path=C:\Program Files\Android\Android Studio\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Android\Android Studio\lib\idea_rt.jar;C:\Program Files\Android\Android Studio\plugins\junit\lib\junit-rt.jar;C:\Users\montoya\AppData\Local\Android\sdk\platforms\android-26\data\res;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\classes\test\debug;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\classes\debug;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-media-compat-26.1.0.aar\0695d2bc707728ee73235d4ce336341b\res;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-media-compat-26.1.0.aar\0695d2bc707728ee73235d4ce336341b\jars\classes.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\junit\junit\4.12\2973d150c0dc1fefe998f834810d68f278ea58ec\junit-4.12.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\android.arch.lifecycle\common\1.0.0\e414a4cb28434e25c4f6aa71426eb20cf4874ae9\common-1.0.0.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-fragment-26.1.0.aar\6e241a41abdc0163eea5d709d9364d04\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-vector-drawable-26.1.0.aar\e4208ad05c34db784d4bbc91139a6a28\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\runtime-1.0.0.aar\8152b201a40c5a111ea26af2d1fbb9cc\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\appcompat-v7-26.1.0.aar\3129eac2faa759c2479292453cf81388\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\appcompat-v7-26.1.0.aar\3129eac2faa759c2479292453cf81388\res;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\com.android.support\support-annotations\26.1.0\814258103cf26a15fcc26ecce35f5b7d24b73f8\support-annotations-26.1.0.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\org.mockito\mockito-core\1.10.19\e8546f5bef4e061d8dd73895b4e8f40e3fe6effe\mockito-core-1.10.19.jar;C:\Users\montoya\AppData\Local\Android\sdk\extras\m2repository\com\android\support\constraint\constraint-layout-solver\1.0.2\constraint-layout-solver-1.0.2.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-core-utils-26.1.0.aar\18f63ffde00ae58ca917b3cc5f39fb5c\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\constraint-layout-1.0.2.aar\05387501d225c7fafd9aaaac3b0d7a81\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\constraint-layout-1.0.2.aar\05387501d225c7fafd9aaaac3b0d7a81\res;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-core-ui-26.1.0.aar\d751547c0e7be767d87a8708981d6ac0\jars\classes.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\org.objenesis\objenesis\2.1\87c0ea803b69252868d09308b4618f766f135a96\objenesis-2.1.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\org.hamcrest\hamcrest-core\1.3\42a25dc3219429f0e5d060061f71acb49bf010a0\hamcrest-core-1.3.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-compat-26.1.0.aar\c4dfe8f23b7307e10914dc373ac0c5b8\res;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-compat-26.1.0.aar\c4dfe8f23b7307e10914dc373ac0c5b8\jars\classes.jar;C:\Users\montoya\.gradle\caches\modules-2\files-2.1\android.arch.core\common\1.0.0\a2d487452376193fc8c103dd2b9bd5f2b1b44563\common-1.0.0.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\support-v4-26.1.0.aar\e719aedcf863e623e2ec13b417d48b45\jars\classes.jar;C:\Users\montoya\.gradle\caches\transforms-1\files-1.1\animated-vector-drawable-26.1.0.aar\9c3c2d758a3a20360e1d0bd2fb13ecd8\jars\classes.jar;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\sourceFolderJavaResources\test\debug;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\intermediates\sourceFolderJavaResources\debug;C:\Users\montoya\Documents\Android\Udacity\JVMUnitTestExample\app\build\generated\mockable-android-26.v3.jar" com.intellij.rt.execution.application.AppMainV2 com.intellij.rt.execution.junit.JUnitStarter -ideVersion5 com.montoya.gabriel.android.jvmunittestexample.ExampleTestFixture
    Before Class -> Setup
    Before test -> Setup
    Test_1 -> Started
    Test_1 -> Finished
    After test -> TearDown
    Before test -> Setup
    Test_2 -> Started
    Test_2 -> Finished
    After test -> TearDown
    Before test -> Setup
    Test_3 -> Started
    Test_3 -> Finished
    After test -> TearDown
    After Class -> TearDown

    Process finished with exit code 0
```

