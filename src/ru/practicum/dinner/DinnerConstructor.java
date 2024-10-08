package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    //we will use ArrayList for saving dinner structure
    private ArrayList<String> dishTypesList = new ArrayList<>();
    Random random = new Random();

    public ArrayList<String> getDishTypesList() {

        return dishTypesList;
    }

    //clear dishTypesList if user want to make new dinner choices
    //Логично...
    void refreshDishTypesList() {
            dishTypesList.clear();
    }
    //Спасибо, мне надо больше думать о том как код читается, не только о том чтобы он работал)
    void makeDinnerStructure(DishList dishListHolder, String type) {
        if (dishListHolder.getList().containsKey(type)) {
            dishTypesList.add(type);
        } else {
            System.out.println("Такого типа блюда нет!");
        }
    }

    void constructDinners(int numberOfCombos, DishList dishList) {
        HashMap<String, ArrayList<Dish>> optionsHashMap = dishList.getList();

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> dinnerOption = new ArrayList<>();

            for (String dishType : dishTypesList) {
                ArrayList<Dish> dishOptions = optionsHashMap.get(dishType);
                String dishOption = dishOptions.get(random.nextInt(dishOptions.size())).getName();
                dinnerOption.add(dishOption);
            }

            System.out.println(dinnerOption);
        }

    }
}
