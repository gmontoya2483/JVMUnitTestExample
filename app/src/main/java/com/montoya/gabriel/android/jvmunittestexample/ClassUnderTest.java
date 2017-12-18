package com.montoya.gabriel.android.jvmunittestexample;

import android.content.Context;

/**
 * Created by montoya on 18.12.2017.
 */

public class ClassUnderTest {
    private Context mContext;

    public ClassUnderTest(Context context) {
        this.mContext=context;
    }

    public String getHelloWorldString(){
        return mContext.getString(R.string.hello_word);
    }
}
