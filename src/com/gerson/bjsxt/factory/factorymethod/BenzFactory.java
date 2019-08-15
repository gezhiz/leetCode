package com.gerson.bjsxt.factory.factorymethod;

public class BenzFactory implements CarFactory {

	@Override
	public Car createCar() {
		return new Benz();
	}

}
