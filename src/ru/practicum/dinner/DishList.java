package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DishList {
    private HashMap<String, ArrayList<Dish>> dishList = new HashMap<>();


    public void addNewDishToList(Dish dish, String type) {
        /*Check list is not empty and type of dish already in list*/
        //Спасибо за помощь!
        dishList.computeIfAbsent(type, k -> new ArrayList<Dish>());
        dishList.get(type).add(dish);
    }

    public HashMap<String, ArrayList<Dish>> getList() {
        return dishList;
    }
}
