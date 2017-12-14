package com.montoya.gabriel.android.jvmunittestexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by montoya on 14.12.2017.
 */

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
