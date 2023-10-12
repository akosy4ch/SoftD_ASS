package com.journaldev.design.Assignment2.facade_design_pattern;

// Класс Firefox предоставляет методы для работы с Firefox.
class Firefox {
    public static Driver getFirefoxDriver() {
        return null;
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Генерация HTML-отчета для браузера Firefox");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Генерация JUnit-отчета для браузера Firefox");
    }
}

// Класс Chrome предоставляет методы для работы с Chrome.
class Chrome {
    public static Driver getChromeDriver() {
        return null;
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Генерация HTML-отчета для браузера Chrome");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Генерация JUnit-отчета для браузера Chrome");
    }
}

// Класс WebExplorerHelperFacade предоставляет интерфейс для создании отчетов в разных браузерах.
class WebExplorerHelperFacade {
    public static void generateReports(String explorer, String report, String test) {
        Driver driver = null;
        switch (explorer) {
            case "firefox":
                driver = Firefox.getFirefoxDriver();
                switch (report) {
                    case "html":
                        Firefox.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Firefox.generateJUnitReport(test, driver);
                        break;
                }
                break;
            case "chrome":
                driver = Chrome.getChromeDriver();
                switch (report) {
                    case "html":
                        Chrome.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Chrome.generateJUnitReport(test, driver);
                        break;
                }
        }
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        String test = "CheckElementPresent";

        // Используем фасад для создания отчетов в разных браузерах и форматах.
        WebExplorerHelperFacade.generateReports("firefox", "html", test);
        WebExplorerHelperFacade.generateReports("firefox", "junit", test);
        WebExplorerHelperFacade.generateReports("chrome", "html", test);
        WebExplorerHelperFacade.generateReports("chrome", "junit", test);
    }
}
