package ru.practicum.dinner;

import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        DishList dishList = new DishList();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish(dishList);
                    break;
                case "2":
                    generateDishCombo(dishList);
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish(DishList dishList) {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        Dish dish = new Dish(dishName);
        dishList.addNewDishToList(dish, dishType);

        // добавьте новое блюдо
    }

    private static void generateDishCombo(DishList dishList) {
        dc.refreshDishTypesList();

        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            dc.makeDinnerStructure(dishList, nextItem);
            nextItem = scanner.nextLine();
        }

        //we will create dinner options if list of dish types is not empty
        if (dc.getDishTypesList().isEmpty()) {
            return;
        }



        // сгенерируйте комбинации блюд и выведите на экран

    }
}
