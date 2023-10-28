import java.util.Scanner;


interface MenuItem {
    double getPrice();
    String getMenu();
}
class Doner implements MenuItem {
    private static final double PRICE = 1600.0;

    @Override
    public double getPrice() {
        return PRICE;
    }

    @Override
    public String getMenu() {
        return "Doner";
    }
}

class Burger implements MenuItem {
    private static final double PRICE = 1300.0;

    @Override
    public double getPrice() {
        return PRICE;
    }

    @Override
    public String getMenu() {
        return "Burger";
    }
}

class Drink implements MenuItem {
    private String drinkType;
    private double drinkPrice;

    public Drink(String drinkType, double drinkPrice) {
        this.drinkType = drinkType;
        this.drinkPrice = drinkPrice;
    }

    @Override
    public double getPrice() {
        return drinkPrice;
    }

    @Override
    public String getMenu() {
        return drinkType;
    }
}

class RestaurantFactory {
    public MenuItem createMenuItem(int choice) {
        switch (choice) {
            case 1:
                return new Doner();
            case 2:
                return new Burger();

            default:
                return null;
        }
    }

    public MenuItem createDrink(int drinkChoice) {
        switch (drinkChoice) {
            case 1:
                return new Drink("Ayran", 250.0);
            case 2:
                return new Drink("Coca-Cola", 500.0);
            default:
                return null;
        }
    }
}

public class Alibek_Restaurant {
    public static void main(String[] args) {
        RestaurantFactory factory = new RestaurantFactory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Alibek's Restaurant!");
        System.out.println("Menu:");
        System.out.println("1 - Doner");
        System.out.println("2 - Burger");

        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        MenuItem menuItem = factory.createMenuItem(choice);

        if (menuItem != null) {
            System.out.println("You have selected: " + menuItem.getMenu());

            System.out.println("Do you want to add a drink?");
            System.out.println("1 - Ayran");
            System.out.println("2 - Coca-Cola");
            System.out.println("0 - None");

            System.out.print("Enter your drink choice (1, 2, or 0): ");
            int drinkChoice = scanner.nextInt();

            MenuItem drink = factory.createDrink(drinkChoice);

            if (drink != null) {
                System.out.println("You have selected: " + menuItem.getMenu() + " with " + drink.getMenu());
                System.out.println("Price: $" + (menuItem.getPrice() + drink.getPrice()));
            } else {
                System.out.println("Invalid drink choice.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
