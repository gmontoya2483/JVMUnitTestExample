package com.montoya.gabriel.android.jvmunittestexample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by montoya on 14.12.2017.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ExampleAssertTest.class,
        ExampleUnitTest.class,
        ExampleParameterizedRunnerWithConstructor.class,
})


public class ExampleTestSuite {

    // the class remains empty,
    // used only as a holder for the above annotations

}


