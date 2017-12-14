package com.montoya.gabriel.android.jvmunittestexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by montoya on 14.12.2017.
 */



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
