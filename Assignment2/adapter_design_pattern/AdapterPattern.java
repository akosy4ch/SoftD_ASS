package com.journaldev.design.Assignment2.adapter_design_pattern;

// Определяем интерфейс WebDriver, который будет использоваться для работы с разными браузерами.
interface WebDriver {
	public void getElement(); // Метод для получения элемента
	public void selectElement(); // Метод для выбора элемента
}

// Класс ChromeDriver реализует интерфейс WebDriver для работы с браузером Chrome.
class ChromeDriver implements WebDriver {
	@Override
	public void getElement() {
		System.out.println("Получение элемента из ChromeDriver");
	}

	@Override
	public void selectElement() {
		System.out.println("Выбор элемента из ChromeDriver");
	}
}

// Класс IEDriver использует интерфейс WebDriver для работы с IE браузером.
class IEDriver implements WebDriver {
	public void findElement() {
		System.out.println("Поиск элемента в IEDriver");
	}

	public void clickElement() {
		System.out.println("Клик по элементу в IEDriver");
	}
}

// Класс WebDriverAdapter использует IEDriver и адаптирует его методы под интерфейс WebDriver.
class WebDriverAdapter implements WebDriver {
	IEDriver ieDriver;

	public WebDriverAdapter(IEDriver ieDriver) {
		this.ieDriver = ieDriver;
	}

	@Override
	public void getElement() {
		ieDriver.findElement();
	}

	@Override
	public void selectElement() {
		ieDriver.clickElement();
	}
}

public class AdapterPattern {
	public static void main(String[] args) {
		// Создаем объект ChromeDriver и используем его методы.
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.getElement();
		chromeDriver.selectElement();

		// Создаем объект IEDriver и используем его методы.
		IEDriver ieDriver = new IEDriver();
		ieDriver.findElement();
		ieDriver.clickElement();

		// Создаем адаптер WebDriverAdapter для IEDriver и используем методы через интерфейс WebDriver.
		WebDriver wID = new WebDriverAdapter(ieDriver);
		wID.getElement();
		wID.selectElement();
	}
}
