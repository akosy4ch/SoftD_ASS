package com.journaldev.design.Assignment2.bridge_design_pattern;

// Абстрактный класс TV, который связан с классом Remote.
abstract class TV {
    Remote remote;

    TV(Remote r) {
        this.remote = r;
    }

    abstract void on();
    abstract void off();
}

// Класс Sony, который наследует TV и использует пульт.
class Sony extends TV {
    Remote remoteType;

    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Sony TV ВКЛ: ");
        remoteType.on();
    }

    public void off() {
        System.out.print("Sony TV ВЫКЛ: ");
        remoteType.off();
    }
}

// Класс Philips, похожий на класс Sony, но для телевизоров Philips.
class Philips extends TV {
    Remote remoteType;

    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Philips TV ВКЛ: ");
        remoteType.on();
    }

    public void off() {
        System.out.print("Philips TV ВЫКЛ: ");
        remoteType.off();
    }
}

// Интерфейс Remote, который определяет методы on() и off() для пультов.
interface Remote {
    public void on();
    public void off();
}

// Класс OldRemote, который ипользует Remote для старых пультов.
class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ВКЛ с помощью старого пульта");
    }

    @Override
    public void off() {
        System.out.println("ВЫКЛ с помощью старого пульта");
    }
}

// Класс NewRemote, который использует Remote для новых пультов.
class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ВКЛ с помощью нового пульта");
    }

    @Override
    public void off() {
        System.out.println("ВЫКЛ с помощью нового пульта");
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        // Создаем экземпляры телевизоров и пультов для Sony и Philips и управляем ими.
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}
