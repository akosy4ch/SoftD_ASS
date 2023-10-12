package com.journaldev.design.Assignment2.factory_design_pattern;

// Абстрактный класс Vehicle предоставляет метод getWheel() для получения количества колес.
abstract class Vehicle {
	public abstract int getWheel();

	public String toString() {
		return "Количество колес: " + this.getWheel();
	}
}

// Класс Car наследует Vehicle и представляет собой автомобиль с определенным количеством колес.
class Car extends Vehicle {
	int wheel;

	Car(int wheel) {
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// Класс Bike наследует Vehicle и представляет собой велосипед с определенным количеством колес.
class Bike extends Vehicle {
	int wheel;

	Bike(int wheel) {
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// Класс VehicleFactory является приозводством для создания объектов Car и Bike.
class VehicleFactory {
	public static Vehicle getInstance(String type, int wheel) {
		if (type.equals("car")) {
			return new Car(wheel);
		} else if (type.equals("bike")) {
			return new Bike(wheel);
		}
		return null;
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		// Создаем объекты Car и Bike с использованием фабрики.
		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car);

		Vehicle bike = VehicleFactory.getInstance("bike", 2);
		System.out.println(bike);
	}
}
