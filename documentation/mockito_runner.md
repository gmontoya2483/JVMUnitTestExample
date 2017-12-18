# Create and use Mocked tests

To add a mock object to your local unit test using this framework, follow this programming model:

1. Include the Mockito library dependency in your ```build.gradle``` file.

```Gradle
    dependencies {

        testImplementation 'org.mockito:mockito-core:1.10.19'

    }
```


2. At the beginning of your unit test class definition, add the ```@RunWith(MockitoJUnitRunner.class)``` annotation. This annotation tells the Mockito test runner to validate that your usage of the framework is correct and simplifies the initialization of your mock objects.

3. To create a mock object for an Android dependency, add the ```@Mock``` annotation before the field declaration.

4. To stub the behavior of the dependency, you can specify a condition and return value when the condition is met by using the ```when()``` and ```thenReturn()``` methods.


## Example

```java
    public class ClassUnderTest {
        private Context mContext;

        public ClassUnderTest(Context context) {
            this.mContext=context;
        }

        public String getHelloWorldString(){
            return mContext.getString(R.string.hello_word);
        }
    }
```


```java
    @RunWith(MockitoJUnitRunner.class)
    public class ExampleMockitoTest {

        private static final String FAKE_STRING = "HELLO WORLD";

        @Mock
        Context mMockContext;

        @Test
        public void readStringFromContext_LocalizedString() {
            // Given a mocked Context injected into the object under test...
            when(mMockContext.getString(R.string.hello_word))
                    .thenReturn(FAKE_STRING);
            ClassUnderTest myObjectUnderTest = new ClassUnderTest(mMockContext);

            // ...when the string is returned from the object under test...
            String result = myObjectUnderTest.getHelloWorldString();

            // ...then the result should be the expected one.
            assertThat(result, is(FAKE_STRING));
        }


    }
```