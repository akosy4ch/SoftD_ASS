package com.journaldev.design.Assignment2.singleton_design_pattern;

// моментальная инициализацией
class SingletonEagar {
  private static SingletonEagar instance = new SingletonEagar();

  private SingletonEagar() {
    // Приватный конструктор
  }

  public static SingletonEagar getInstance() {
    return instance;
  }
}

//инициализация  без синхронизации
class Singleton {
  private static Singleton instance;

  private Singleton() {
    // Приватный конструктор
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}

//инициализация  с синхронизацией метода
class SingletonSynchronizedMethod {
  private static SingletonSynchronizedMethod instance;

  private SingletonSynchronizedMethod() {
    // Приватный конструктор
  }

  public static synchronized SingletonSynchronizedMethod getInstance() {
    if (instance == null) {
      instance = new SingletonSynchronizedMethod();
    }
    return instance;
  }
}

// инициализация с синхронизацией блока
class SingletonSynchronized {
  private static SingletonSynchronized instance;

  private SingletonSynchronized() {
    // Приватный конструктор
  }

  public static SingletonSynchronized getInstance() {
    if (instance == null) {
      synchronized (SingletonSynchronized.class) {
        if (instance == null) {
          instance = new SingletonSynchronized();
        }
      }
    }
    return instance;
  }
}

public class SingletonPattern {
  public static void main(String[] args) {
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    System.out.println(instance);
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
    System.out.println(instance1);
  }
}
