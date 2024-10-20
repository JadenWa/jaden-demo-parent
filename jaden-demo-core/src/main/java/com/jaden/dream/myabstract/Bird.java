package com.jaden.dream.myabstract;

import com.jaden.dream.annotation.MethodInfo;

public class Bird extends Flyer {
    @Override
    @MethodInfo(author = "jaden",version = "1.0")
    public String getFly() {
        return super.getFly();
    }
}
