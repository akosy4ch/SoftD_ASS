package com.journaldev.design.Assignment2.flyweight_design_pattern;

import java.util.HashMap;
import java.util.Random;

// Интерфейс Employee создает  методы для навыков и задачи.
interface Employee {
  public void assignSkill(String skill);
  public void task();
}

// Класс Developer использует интерфейс Employee и представляет разработчика с его работой и навыками.
class Developer implements Employee {
  private final String JOB;
  private String skill;

  public Developer() {
    JOB = "Исправление проблемы";
  }

  @Override
  public void assignSkill(String skill) {
    this.skill = skill;
  }

  @Override
  public void task() {
    System.out.println("Разработчик с навыком: " + this.skill + " и работой: " + JOB);
  }
}

// Класс Tester использует интерфейс Employee и представляет тестировщика с его работой и навыками.
class Tester implements Employee {
  private final String JOB;
  private String skill;

  public Tester() {
    JOB = "Тестирование проблемы";
  }

  @Override
  public void assignSkill(String skill) {
    this.skill = skill;
  }

  @Override
  public void task() {
    System.out.println("Тестировщик с навыком: " + this.skill + " и работой: " + JOB);
  }
}

// Класс EmployeeFactory - это фабрика для создания объектов Developer и Tester с общими характеристиками.
class EmployeeFactory {
  private static HashMap<String, Employee> m = new HashMap<String, Employee>();

  public static Employee getEmployee(String type) {
    Employee p = null;
    if (m.get(type) != null) {
      p = m.get(type);
    } else {
      switch (type) {
        case "Developer":
          System.out.println("Создан разработчик");
          p = new Developer();
          break;
        case "Tester":
          System.out.println("Создан тестировщик");
          p = new Tester();
          break;
        default:
          System.out.println("Нет такого сотрудника");
      }

      m.put(type, p);
    }
    return p;
  }
}

public class FlyweightPattern {
  private static String employeeType[] = {"Developer", "Tester"};
  private static String skills[] = {"Java", "C++", ".Net", "Python"};

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      Employee e = EmployeeFactory.getEmployee(getRandEmployee());
      e.assignSkill(getRandSkill());
      e.task();
    }
  }

  public static String getRandEmployee() {
    Random r = new Random();
    int randInt = r.nextInt(employeeType.length);
    return employeeType[randInt];
  }

  public static String getRandSkill() {
    Random r = new Random();
    int randInt = r.nextInt(skills.length);
    return skills[randInt];
  }
}
