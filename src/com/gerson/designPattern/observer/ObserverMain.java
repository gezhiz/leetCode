package com.gerson.designPattern.observer;

/**
 * Created by gezz on 2019/3/14.
 */
public class ObserverMain {

    public static void main(String[] args) {
        O1 o1 = new O1();
        O2 o2 = new O2();
        PlatformWeather platformWeather = new PlatformWeather();
        platformWeather.register(o1);
        platformWeather.register(o2);
        platformWeather.event();
    }
}
