package com.jaden.dream.myabstract;


import org.springframework.util.StringUtils;

public class Flyer extends AbstractFlyer{
    private String fly;

    public String getFly() {
        return fly;
    }

    public void setFly(String fly) {
        this.fly = fly;
    }

    public String fly(){
        if(StringUtils.hasText(this.fly))
        //System.out.println( Thread.currentThread().getId()+" is running");
        System.out.println("i can use"+this.fly+" to fly");
        return this.fly;
    }

    @Override
    public String abFly() {
        System.out.println("i can achieve flyer to fly");
        return "abFly";
    }
}
