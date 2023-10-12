package com.journaldev.design.Assignment2.observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Интерфейс Subject создает методы для регистрации, отмены регистрации и уведомления.
interface Subject {
    void register(Observer obj);
    void unregister(Observer obj);
    void notifyObservers();
}

// Класс DeliveryData использует интерфейс Subject и представляет данные о доставке.
class DeliveryData implements Subject {
    private List<Observer> observers;
    private String location;

    public DeliveryData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update(location);
        }
    }

    public void locationChanged() {
        this.location = getLocation();
        notifyObservers();
    }

    public String getLocation() {
        return "МестоположениеY";
    }
}

// Интерфейс Observer создает метод update для обновления состояния наблюдателя.
interface Observer {
    public void update(String location);
}

// Класс Seller использует интерфейс Observer и
// представляет продавца, который получает уведомления о местоположении.
class Seller implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Уведомление продавцу - Текущее местоположение: " + location);
    }
}

// Класс User использует интерфейс Observer и представляет пользователя,
// который получает уведомления о местоположении.
class User implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Уведомление пользователю - Текущее местоположение: " + location);
    }
}

// Класс DeliveryWarehouseCenter использует интерфейс Observer и
// представляет центр по доставке, который получает уведомления о местоположении.
class DeliveryWarehouseCenter implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Уведомление центру по доставке - Текущее местоположение: " + location);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        DeliveryData topic = new DeliveryData();

        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        topic.locationChanged();
        topic.unregister(obj3);

        System.out.println();
        topic.locationChanged();
    }
}
