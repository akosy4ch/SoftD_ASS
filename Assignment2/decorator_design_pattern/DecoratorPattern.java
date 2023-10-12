package com.journaldev.design.Assignment2.decorator_design_pattern;

// Интерфейс Dress создает метод assemble, который используется для создания нарядов.
interface Dress {
	public void assemble();
}

// Класс BasicDress использует интерфейс Dress и предоставляет базовые характеристики одежды.
class BasicDress implements Dress {
	@Override
	public void assemble() {
		System.out.println("Основные характеристики одежды");
	}
}

// Класс DressDecorator - это декоратор, который содержит ссылку на объект Dress и может добавлять дополнительные характеристики.
class DressDecorator implements Dress {
	protected Dress dress;

	public DressDecorator(Dress c) {
		this.dress = c;
	}

	@Override
	public void assemble() {
		this.dress.assemble();
	}
}

// Классы CasualDress, SportyDress и FancyDress - это конкретные декораторы, которые добавляют к базовой одежде определенный стиль.
class CasualDress extends DressDecorator {
	public CasualDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Добавление характеристик повседневной одежды");
	}
}

class SportyDress extends DressDecorator {
	public SportyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Добавление характеристик спортивной одежды");
	}
}

class FancyDress extends DressDecorator {
	public FancyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Добавление характеристик праздничной одежды");
	}
}

public class DecoratorPattern {
	public static void main(String[] args) {
		// Создаем различные комбинации одежды с использованием декораторов.
		Dress sportyDress = new SportyDress(new BasicDress());
		sportyDress.assemble();
		System.out.println();

		Dress fancyDress = new FancyDress(new BasicDress());
		fancyDress.assemble();
		System.out.println();

		Dress casualDress = new CasualDress(new BasicDress());
		casualDress.assemble();
		System.out.println();

		Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
		sportyFancyDress.assemble();
		System.out.println();

		Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
		casualFancyDress.assemble();
	}
}
