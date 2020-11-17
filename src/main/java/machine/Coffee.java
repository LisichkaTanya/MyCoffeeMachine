package machine;

public enum  Coffee {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);

    int water, milk, beans, cup, money;

    Coffee(int water, int milk, int beans, int cup, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cup = cup;
        this.money = money;
    }
}
