package com.journaldev.design.Assignment2.builder_design_pattern;

// Класс Vehicle с его комплектующими .
class Vehicle {
  private String engine;
  private int wheel;
  private int airbags;

  public String getEngine() {
    return this.engine;
  }

  public int getWheel() {
    return this.wheel;
  }

  public int getAirbags() {
    return this.airbags;
  }

  private Vehicle(VehicleBuilder builder) {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }

  //  класс VehicleBuilder используется для создания объекта Vehicle.
  public static class VehicleBuilder {
    private String engine;
    private int wheel;
    private int airbags;

    // Конструктор VehicleBuilder принимает баззовые параметры.
    public VehicleBuilder(String engine, int wheel) {
      this.engine = engine;
      this.wheel = wheel;
    }

    // Метод setAirbags позволяет установить необязательные параметры.
    public VehicleBuilder setAirbags(int airbags) {
      this.airbags = airbags;
      return this;
    }

    // Метод build создает и возвращает объект Vehicle с заданными параметрами.
    public Vehicle build() {
      return new Vehicle(this);
    }
  }
}

public class BuilderPattern {
  public static void main(String[] args) {
    // Создаем объекты автомобиля и мотоцикла с использованием данного паттерна.
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

    // Выводим характеристики автомобиля и мотоцикла.
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());

    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}
