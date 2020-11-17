package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int disposableCups = 9;
    private int money = 550;
    Scanner scanner = new Scanner(System.in);
    Coffee coffee = null;

    //запускаем машину
    public void start() {
        boolean exit = true;
        while (exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            switch (scanner.next()) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
                case "exit":
                    exit = false;
                    break;
            }
        }
    }

    //метод выбора и покупки кофе
    void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (scanner.next()) {
            case "1":
                coffee = coffee.ESPRESSO;
                checkForBuy();
                break;
            case "2":
                coffee = coffee.LATTE;
                checkForBuy();
                break;
            case "3":
                coffee = coffee.CAPPUCCINO;
                checkForBuy();
                break;
            case "back":
                start();
                break;
            default:
                break;
        }
    }

    //метод для проверки количества ингридиентов для нужного кофе
    void checkForBuy() {
        if (water < coffee.water) {
            System.out.println("Sorry, not enough water!\n");
        } else {
            if (milk < coffee.milk) {
                System.out.println("Sorry, not enough coffee milk!\n");
            } else {
                if (beans < coffee.beans) {
                    System.out.println("Sorry, not enough coffee beans!\n");

                } else {
                    if (disposableCups < coffee.cup) {
                        System.out.println("Sorry, not enough disposable cups!\n");
                    } else {
                        System.out.println("I have enough resources, making you a coffee!\n");
                        water -= coffee.water;
                        milk -= coffee.milk;
                        beans -= coffee.beans;
                        disposableCups -= coffee.cup;
                        money += coffee.money;
                    }
                }
            }
        }
    }

    //метод добавления ингридиентов
    void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        disposableCups += scanner.nextInt();
    }

    //метод просмотра - сколько ингридиентов в машине
    void remaining() {
        System.out.println("\nThe coffee machine has:\n" + water +
                " of water\n" + milk +
                " of milk\n" + beans +
                " of coffee beans\n" + disposableCups +
                " of disposable cups\n" + money +
                " of money\n");
    }

    //метод изъятия денег
    void take() {
        System.out.println("\nI gave you $" + money + "\n");
        money = 0;
    }

}
