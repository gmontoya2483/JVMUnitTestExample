package com.montoya.gabriel.android.jvmunittestexample;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by montoya on 18.12.2017.
 */

@RunWith(Categories.class)
@Categories.IncludeCategory(IPerformanceTest.class)
@Suite.SuiteClasses({ExampleCategoryOnClassLevel.class, ExampleCategoryOnMethodLevel.class})

public class ExampleCategoryPerformanceTestSuite {
}
