import java.util.Scanner;

interface Property {
    double calcRent(int numRooms);
    double calcBathCost(int numBathrooms);
    double calcPoolCost(boolean hasPool);

}

class Apartment implements Property {
    @Override
    public double calcRent(int numRooms) {
        double basePrice = 10000;
        if (numRooms > 1) {
            return basePrice * numRooms * 0.75;
        } else {
            return basePrice * numRooms;
        }
    }
    @Override
    public  double calcBathCost(int numBathrooms){
        double basePrice = 2000;
        if (numBathrooms >1) {
            return basePrice * numBathrooms * 0.50;
        }else {
            return basePrice * numBathrooms;
        }
    }
    @Override
    public double calcPoolCost(boolean hasPool) {
        return 0;
    }
}

class House {
    public double calcRent(int numRooms, boolean hasPool) {
        double basePrice = 15000;
        double poolPrice = hasPool ? 50000 : 0;
        return (basePrice + poolPrice) * numRooms;
    }
}

class HouseAdapter implements Property {
    private House house;

    public HouseAdapter(House house) {
        this.house = house;
    }

    @Override
    public double calcRent(int numRooms) {
        return house.calcRent(numRooms, false);
    }

    @Override
    public double calcPoolCost(boolean hasPool) {
        return hasPool ? 50000 : 0;
    }
    @Override
    public double calcBathCost(int numBathrooms) {
        return house.calcRent(numBathrooms,false);
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип недвижимости:");
        System.out.println("1 - Квартира");
        System.out.println("2 - Дом");
        int choice = scanner.nextInt();

        Property property;
        if (choice == 1) {
            property = new Apartment();
        } else if (choice == 2) {
            property = new HouseAdapter(new House());
        } else {
            System.out.println("Выбор недействителен.");
            return;
        }

        System.out.println("Введите количество комнат:");
        int numRooms = scanner.nextInt();

        System.out.println("Введите кол-во сан.узлов:");
        int numBathrooms = scanner.nextInt();

        boolean hasPool = false;
        if (choice == 2) {
            System.out.println("Есть ли бассейн? (yes/no):");
            String poolInput = scanner.next().toLowerCase();
            hasPool = poolInput.equals("yes");
        }

        double rent = property.calcRent(numRooms) + property.calcPoolCost(hasPool) + property.calcBathCost(numBathrooms);
        System.out.println("Цена аренды за один день: " + rent);

        scanner.close();
    }
}
