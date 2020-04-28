package com.gerson.gof.strategy;

/**
 * Created by gezz on 2019/3/14.
 */
public class DuckMain {

    public static void main(String[] args) {
        Behavior behavior = new CanFly();
        Behavior cannotFly = new CannotFly();

        WildDuck wildDuck = new WildDuck(behavior);
        wildDuck.fly();

        DomeDuck domeDuck = new DomeDuck(cannotFly);
        domeDuck.fly();
    }
}
