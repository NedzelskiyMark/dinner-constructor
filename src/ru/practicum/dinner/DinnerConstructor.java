package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    //we will use ArrayList for saving dinner structure
    private ArrayList<String> dishTypesList = new ArrayList<>();
    Random random = new Random();

    public ArrayList<String> getDishTypesList () {
        return dishTypesList;
    }

    //clear dishTypesList if user want to make new dinner choices
    void refreshDishTypesList () {
        if (!dishTypesList.isEmpty()) {
            dishTypesList.clear();
        }
    }

    void makeDinnerStructure (DishList dishlist, String type) {
        if (!dishlist.getList().containsKey(type)) {
            System.out.println("Такого типа блюда нет!");
        } else {
            dishTypesList.add(type);
        }
    }

    void constructDinners (int numberOfCombos, DishList dishList) {
        HashMap<String, ArrayList<Dish>> optionsHashMap = dishList.getList();

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> dinnerOption = new ArrayList<>();

            for (int j = 0; j < dishTypesList.size(); j++) {
                String dishType = dishTypesList.get(j);
                ArrayList<Dish> dishOptions = optionsHashMap.get(dishType);
                String dishOption = dishOptions.get(random.nextInt(dishOptions.size())).getName();
                dinnerOption.add(dishOption);
            }

            System.out.println(dinnerOption);
        }

    }
}
