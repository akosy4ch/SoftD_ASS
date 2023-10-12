package com.journaldev.design.Assignment2.proxy_design_pattern;

// Интерфейс DatabaseExecuter создает метод для базы данных.
interface DatabaseExecuter {
	public void executeDatabase(String query) throws Exception;
}

// Класс DatabaseExecuterImpl использует интерфейс DatabaseExecuter и представляет реального исполнителя.
class DatabaseExecuterImpl implements DatabaseExecuter {
	@Override
	public void executeDatabase(String query) throws Exception {
		System.out.println("Собираюсь выполнить запрос: " + query);
	}
}

// Класс DatabaseExecuterProxy использует интерфейс DatabaseExecuter и представляет прокси-исполнителя.
class DatabaseExecuterProxy implements DatabaseExecuter {
	boolean ifAdmin;
	DatabaseExecuterImpl dbExecuter;

	public DatabaseExecuterProxy(String name, String passwd) {
		if (name.equals("Admin") && passwd.equals("Admin@123")) {
			ifAdmin = true;
		}
		dbExecuter = new DatabaseExecuterImpl();
	}

	@Override
	public void executeDatabase(String query) throws Exception {
		if (ifAdmin) {
			dbExecuter.executeDatabase(query);
		} else {
			if (query.equals("DELETE")) {
				throw new Exception("DELETE не разрешено для неадминистративного пользователя");
			} else {
				dbExecuter.executeDatabase(query);
			}
		}
	}
}

public class ProxyPattern {
	public static void main(String[] args) throws Exception {
		// Создаем прокси для неадминистративного пользователя и пытаемся выполнить недопустимый запрос.
		DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuter.executeDatabase("DELEE"); // Опечатка в запросе.

		// Создаем прокси для неадминистративного пользователя для выполнения запроса DELETE .
		DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuterDELETE.executeDatabase("DELETE");

		// Создаем прокси для администратора и выполняем запрос DELETE .
		DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		adminExecuter.executeDatabase("DELETE");
	}
}
