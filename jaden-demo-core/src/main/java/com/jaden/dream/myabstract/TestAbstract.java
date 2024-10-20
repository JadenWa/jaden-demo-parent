package com.jaden.dream.myabstract;

public class TestAbstract {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Bird bird = Bird.class.newInstance();
        AbstractFlyer bird1 = Bird.class.newInstance();
        bird.abFly();
        bird.abFly();
        if(bird instanceof AbstractFlyer){
            System.out.println("yes");
        }

    }
}
