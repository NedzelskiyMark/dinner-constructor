package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DishList {
    private HashMap<String, ArrayList<Dish>> dishList = new HashMap<>();


    public void addNewDishToList(Dish dish, String type) {

        /*Check list is not empty and type of dish already in list*/
        if (dishList.containsKey(type)) {
            dishList.get(type).add(dish);
        } else {
            ArrayList<Dish> list = new ArrayList<>();
            list.add(dish);
            dishList.put(type, list);
        }


    }

    public HashMap<String, ArrayList<Dish>> getList () {
        return dishList;
    }
}
